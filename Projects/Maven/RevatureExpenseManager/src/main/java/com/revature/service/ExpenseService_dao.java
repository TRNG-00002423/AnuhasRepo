package com.revature.service;

import com.revature.exception.UserNotFoundException;
import com.revature.exception.UserUnsuccessfullyAddedException;
import com.revature.model.Expense;

import java.sql.SQLException;
import java.util.List;

public class ExpenseService {

    
    private MessageRepository messageRepository;
    private ExpenseDao expenseDao = new ExpenseDao();

    public List<Expense> getAllExpenses() throws SQLException {
        return expenseDao.getAllUsers();
    }

    public void addExpense(Expense expense) throws SQLException {

        expense.setUser_id(expense.getUser_id().strip());
        expense.setAmount(expense.getAmount().strip());
        expense.setDescription(expense.getDescription().strip());
        expense.setDate(expense.getDate().strip());
        expense.setCategory(expense.getCategory().strip());

        if (expense.getEmail().length() == 0) {
            throw new IllegalArgumentException("Email cannot be blank");
        }

        if (expense.getPassword().length() == 0) {
            throw new IllegalArgumentException("Password cannot be blank");
        }

        if (expense.getRole().length() == 0) {
            throw new IllegalArgumentException("Role cannot be blank");
        }

        int recordsAdded = expenseDao.addUser(expense); 

        if (recordsAdded != 1) { 
            throw new UserUnsuccessfullyAddedException("Expense could not be added");
        }
    }

    public Expense getExpenseById(String id) throws SQLException {
        Expense expense = expenseDao.getExpenseById(id); // null if user does not exist

        if (expense == null) {
            throw new UserNotFoundException("User with id " + id + " was not found");
        } else {
            return expense;
        }
    }

    
}