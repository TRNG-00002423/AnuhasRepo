package com.revature.service;

import com.revature.exception.UserNotFoundException;
import com.revature.exception.UserUnsuccessfullyAddedException;
import com.revature.model.Approval;
import com.revature.model.Expense;

import java.sql.SQLException;
import java.util.List;

public class ApprovalService {    
        
    private ApprovalRepository approvalRepository;

    public ApprovalService(ApprovalRepository approvalRepository) {
        this.approvalRepository = approvalRepository;
    }

    public Approval persistApproval(Approval approval) {  
            
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
                            return expenseRepository.save(expense);
                        }
                    }
                }
            }
        }

        return null;
    }



    public List<Approval> getAllApprovals() {
        return approvalRepository.findAll();
    }
    public Approval getApprovalById(String id) {
        Optional<Approval> optionalApproval = approvalRepository.findById(id);
        if (optionalApproval.isPresent()) {
            return optionalApproval.get();
        } else {
            return null;
        }
    }

    public List<Approval> getAllApprovalsByUserId(String userId) {
        List<Approval> approvalsToBeReturned = approvalRepository.findAll();
        List<Approval> filteredApprovalsToBeReturned = new ArrayList<>();
        for(int i=0; i<approvalsToBeReturned.size(); i++) {
            if(approvalsToBeReturned.get(i).getPostedBy() == postedBy) {
                filteredApprovalsToBeReturned.add(approvalsToBeReturned.get(i));
            }
        }
       
        return filteredApprovalsToBeReturned;
    }

    public String updateExistingApproval(String Id, Expense expense) {
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
                                return expenseRepository.save(expense);
                                
                
                                Optional<Approval> existingApproval = approvalRepository.findById(Id);
                                if(existingApproval.isPresent()) {
                                    Expense approvalToBeUpdated = existingApproval.get();
                                    // expenseToBeUpdated.setExpenseId(currentApprovalExpenseId);
                                    // expenseToBeUpdated.setStatus(currentApprovalStatus);
                                    // expenseToBeUpdated.setReviewer(currentApprovalReviewer);
                                    // expenseToBeUpdated.setComment(currentApprovalComment);
                                    // expenseToBeUpdated.setReview_date(currentApprovalReviewDate);
                                    approvalRepository.save(approvalToBeUpdated);
                                    return "1";
                                }
                            }
                        }
                    }
                }
            }
                
            return null;
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
            
            
            

    
}

