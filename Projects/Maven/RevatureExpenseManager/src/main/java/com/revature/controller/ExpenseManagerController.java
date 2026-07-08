package com.revature.controller;

import com.revature.model.User;
import com.revature.model.Expense;

import java.util.List;

import com.revature.model.Approval;
import com.revature.service.ApprovalService;
import com.revature.service.ExpenseService;
import com.revature.service.UserService;

public class ExpenseManagerController {

    private UserService userService;
    private ExpenseService expenseService;
    private ApprovalService approvalService;

    public ExpenseManagerController(UserService userService, ExpenseService expenseService, ApprovalService approvalService) {
        this.userService = userService;
        this.expenseService = expenseService;
        this.approvalService = approvalService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> createNewUser(@RequestBody User user) {
        String email = user.getEmail();
        email.replace(" ", "");
        String password = user.getPassword();
        password.replace(" ", "");

        try {
            User isValidUser = userService.isValidUser(user);
            if (isValidUser != null){
                return ResponseEntity.status(409).build();
            } else { 
                if ((email != null) && (email != "") && (email != " ")) {
                    if ((password != null) && (password.length() >= 4)) {
                        User newlyCreatedUser = userService.persistUser(user);
                        return ResponseEntity.ok(newlyCreatedUser);
                    }
                } else {
                    return ResponseEntity.status(409).build();
                }
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return ResponseEntity.status(409).build();
    }


    @PostMapping("/login")
    public ResponseEntity<User> getExistingUserEntity(@RequestBody User user) {
        try {
            User isValidUser = userService.isValidUser(user);
            if (isValidUser != null){
                return ResponseEntity.ok(isValidUser);
            } else { 
                return ResponseEntity.status(401).build();
            }
        } catch(Exception ex){
            ex.printStackTrace();
        } 
        return ResponseEntity.status(401).build();
    }  


    @PostMapping("/expenses")
    public ResponseEntity<Expense> createNewExpense(@RequestBody Expense expense) {
        try {
            
            String currentExpenseUserId = expense.getUserId();
            String currentExpenseDescription = expense.getDescription();
            String currentExpenseDate = expense.getDate();
            String currentExpenseCategory = expense.getCategory();
             
            if ((currentExpenseUserId != null) && (currentExpenseUserId != "") && (currentExpenseUserId != " ")) {
                if ((currentExpenseDescription != null) && (currentExpenseDescription != "") && (currentExpenseDescription != " ")) {
                    if ((currentExpenseDate != null) && (currentExpenseDate != "") && (currentExpenseDate != " ")) {
                        if ((currentExpenseCategory != null) && (currentExpenseCategory != "") && (currentExpenseCategory != " ")) {
                            
                            if (currentExpenseDescription.length() <= 255) {
                                float currentExpenseAmount = expense.getAmount();
                                User postingUser = userService.getExistingUserById(currentExpenseUserId);
                                User isValidUser = userService.isValidUser(postingUser);
                                if (isValidUser != null){
                                    
                                    Expense newlyCreatedExpense = expenseService.persistExpense(expense);
                                    return ResponseEntity.ok(newlyCreatedExpense);
                                } else { 
                                    return ResponseEntity.status(400).build();
                                }
                            }
                        }
                    }
                }
                return ResponseEntity.badRequest().build();
            } else {
                
                return ResponseEntity.badRequest().build();
            }

        } catch(Exception ex){
            ex.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/expenses")
    public ResponseEntity<List<Expense>> retrieveAllExpenses() {
        
        List<Expense> expensesBeingReturned = expenseService.getAllExpenses();
        return ResponseEntity.ok(expensesBeingReturned);
    }

    @GetMapping("/expenses/{expenseId}")
    public ResponseEntity<Expense> getExistingExpenseById(@PathVariable String expenseId) {
        
        Expense expenseBeingReturned = expenseService.getExpenseById(expenseId);
        return ResponseEntity.status(200).body(expenseBeingReturned);
    }
    @GetMapping("/user/{userId}/expenses")
    public ResponseEntity<List<Expense>> getExistingExpense(@PathVariable String userId) {
        
        try {
                List<Expense> expenseBeingReturned = expenseService.getAllExpensesByUserId(userId);
                             
                return ResponseEntity.ok(expenseBeingReturned);
        } catch(Exception ex){
            ex.printStackTrace();
        } 
        
        return ResponseEntity.badRequest().build();
    }
    @PatchMapping("/expenses/{expenseId}")
    public ResponseEntity<String> updateExistingExpense(@PathVariable String expenseId, @RequestBody Expense expense) {
        
        String updatedExpense = expenseService.updateExistingExpense(expenseId, expense);
        if(updatedExpense == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(updatedExpense);
        }
    }


    @PostMapping("/approvals")
    public ResponseEntity<Approval> createNewExpense(@RequestBody Approval approval) {
        try {
            
            String currentApprovalExpenseId = approval.getExpenseId();
            String currentApprovalStatus = approval.getStatus();
            String currentApprovalReviewer = approval.getReviewer();
            String currentApprovalComment = approval.getComment();
             
            if ((currentApprovalExpenseId != null) && (currentApprovalExpenseId != "") && (currentApprovalExpenseId != " ")) {
                if ((currentApprovalStatus != null) && (currentApprovalStatus != "") && (currentApprovalStatus != " ")) {
                    if ((currentApprovalReviewer != null) && (currentApprovalReviewer != "") && (currentApprovalReviewer != " ")) {
                        if ((currentApprovalComment != null) && (currentApprovalComment != "") && (currentApprovalComment != " ")) {
                            
                            if (currentApprovalComment.length() <= 255) {
                                String currentApprovalReviewDate = approval.getReview_date();
                                User postingUser = userService.getExistingUserById(currentApprovalReviewer);
                                User isValidUser = userService.isValidUser(postingUser);
                                Expense refrencedExpense = expenseService.getExistingExpenseById(currentApprovalExpenseId);
                                Expense isValidExpense = expenseService.isValidUser(refrencedExpense);
                                if ((isValidUser != null) && (isValidExpense != null)){
                                    Approval newlyCreatedApproval = ApprovalService.persistExpense(approval);
                                    return ResponseEntity.ok(newlyCreatedApproval);
                                } else { 
                                    return ResponseEntity.status(400).build();
                                }
                            }
                        }
                    }
                }
                return ResponseEntity.badRequest().build();
            } else {
                
                return ResponseEntity.badRequest().build();
            }

        } catch(Exception ex){
            ex.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/approvals")
    public ResponseEntity<List<Approval>> retrieveAllApprovals() {
        
        List<Approval> approvalsBeingReturned = approvalService.getAllApprovals();
        return ResponseEntity.ok(approvalsBeingReturned);
    }

    @GetMapping("/approvals/{approvalId}")
    public ResponseEntity<Approval> getExistingApprovalById(@PathVariable String approvalId) {
        
        Approval approvalBeingReturned = approvalService.getApprovalById(approvalId);
        return ResponseEntity.status(200).body(approvalBeingReturned);
    }
    @GetMapping("/user/{userId}/approvals")
    public ResponseEntity<List<Approval>> getExistingApproval(@PathVariable String userId) {
        
        try {
                List<Approval> approvalBeingReturned = approvalService.getAllApprovalsByUserId(userId);
                             
                return ResponseEntity.ok(approvalBeingReturned);
        } catch(Exception ex){
            ex.printStackTrace();
        } 
        
        return ResponseEntity.badRequest().build();
    }
    @PatchMapping("/approvals/{approvalId}")
    public ResponseEntity<String> updateExistingApproval(@PathVariable String approvalId, @RequestBody Approval approval) {
        // (User Story 7) : API can update a message identified by a messageId
        String updatedApproval = approvalService.updateExistingApproval(approvalId, approval);
        if(updatedApproval == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(updatedApproval);
        }
    }
}








    
}