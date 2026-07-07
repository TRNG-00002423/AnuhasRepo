package com.revature.service;

import com.revature.exception.UserNotFoundException;
import com.revature.exception.UserUnsuccessfullyAddedException;
import com.revature.model.Approval;
import com.revature.model.Expense;

import java.sql.SQLException;
import java.util.List;

public class ApprovalsService {

    private ApprovalDao approvalDao = new ApprovalDao();

    public List<Approval> getAllExpenses() throws SQLException {
        return approvalDao.getAllUsers();
    }

    public void addApproval(Approval approval) throws SQLException {

        approval.setUser_id(approval.getUser_id().strip());
        approval.setAmount(expense.getAmount().strip());
        approval.setDescription(expense.getDescription().strip());
        approval.setDate(expense.getDate().strip());
        approval.setCategory(expense.getCategory().strip());

        if (approval.getEmail().length() == 0) {
            throw new IllegalArgumentException("Email cannot be blank");
        }

        if (approval.getPassword().length() == 0) {
            throw new IllegalArgumentException("Password cannot be blank");
        }

        if (approval.getRole().length() == 0) {
            throw new IllegalArgumentException("Role cannot be blank");
        }

        int recordsAdded = approvalDao.addUser(approval); 

        if (recordsAdded != 1) { 
            throw new UserUnsuccessfullyAddedException("Expense could not be added");
        }
    }

    public Approval getExpenseById(String id) throws SQLException {
        Approval approval = approvalDao.getApprovalById(id); // null if user does not exist

        if (approval == null) {
            throw new UserNotFoundException("User with id " + id + " was not found");
        } else {
            return approval;
        }
    }

    
}
