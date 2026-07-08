package com.revature.service;

import com.revature.exception.UserNotFoundException;
import com.revature.exception.UserUnsuccessfullyAddedException;
import com.revature.model.Expense;

import java.sql.SQLException;
import java.util.List;

public class ExpenseService {

    
    private ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Message persistExpense(Expense expense) {  
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
                                return expenseRepository.save(expense);
                            }
        }
        return null;
    }
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
    public Expense getExpenseById(String id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if (optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
    public List<Expense> getAllExpensesByUserId(String userId) {
        List<Expense> expensesToBeReturned = expenseRepository.findAll();
        List<Expense> filteredExpensesToBeReturned = new ArrayList<>();
        for(int i=0; i<expensesToBeReturned.size(); i++) {
            if(expensesToBeReturned.get(i).getPostedBy() == postedBy) {
                filteredExpensesToBeReturned.add(expensesToBeReturned.get(i));
            }
        }
       
        return filteredExpensesToBeReturned;
    }
    public String updateExistingExpense(String Id, Expense expense) {
        try {
            String currentExpenseUserId = expense.getUserId();
            String currentExpenseDescription = expense.getDescription();
            String currentExpenseDate = expense.getDate();
            String currentExpenseCategory = expense.getCategory();
            if ((currentExpenseUserId != null) && (currentExpenseUserId != "") && (currentExpenseUserId != " ")) {
                    if ((currentExpenseDescription != null) && (currentExpenseDescription != "") && (currentExpenseDescription != " ")) {
                        if ((currentExpenseDate != null) && (currentExpenseDate != "") && (currentExpenseDate != " ")) {
                            if ((currentExpenseCategory != null) && (currentExpenseCategory != "") && (currentExpenseCategory != " ")) {
                                
                                
                                if ((currentExpenseDescription.length() <= 255)&& (currentExpenseDescription.length() > 0)) {
                                    
                                    float currentExpenseAmount = expense.getAmount();
                                    User postingUser = userService.getExistingUserById(currentExpenseUserId);
                                    User isValidUser = userService.isValidUser(postingUser);
                
                                    Optional<Expense> existingExpense = expenseRepository.findById(Id);
                                    if(existingExpense.isPresent()) {
                                        Expense expenseToBeUpdated = existingExpense.get();
                                        // expenseToBeUpdated.setUserId(currentExpenseUserId);
                                        // expenseToBeUpdated.setAmount(currentExpenseAmount);
                                        // expenseToBeUpdated.setDescription(currentExpenseDescription);
                                        // expenseToBeUpdated.setDate(currentExpenseDate);
                                        // expenseToBeUpdated.setCategory(currentExpenseCategory);
                                        messageRepository.save(expenseToBeUpdated);
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

