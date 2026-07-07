package com.revature.controller;


public class ExpenseManagerController {

    private UserService userService;
    private ExpenseService expenseService;
    private ApprovalService approvalService;

    public ExpenseManagerController(UserService userService, ExpenseService expenseService, ApprovalService approvalService) {
        this.userService = userService;
        this.expenseService = expenseService;
        this.approvalService = approvalService;
    }
    
}