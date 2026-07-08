package com.revature.model;

public class Expense {

    int nextid;
    private String expenseId;
    private String userId;
    private float amount;
    private String description;
    private String date;
    private String category;

    public Expense() {
    }

    public Expense(String expenseId, String userId, float amount, String description, String date, String category) {
        this.expenseId = Integer.toString(nextId);
        this.userId = userId;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.category = category;
        nextid++;
    }

    public String getExpenseId() {
        return expenseId;
    }

    // public void setExpenseId(String expenseId) {
    //     this.expenseId = expenseId;
    // }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseId=" + expenseId +
                ", userId='" + userId + '\'' +
                ", amount='" + amount + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (expenseId == null) {
            if (other.expenseId != null)
                return false;
        } else if (!expenseId.equals(other.expenseId))
            return false;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        // if (amount == null) {
        //     if (other.amount != null)
        //         return false;
        // } else if (!amount.equals(other.amount))
        //     return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (category == null) {
            if (other.category != null)
                return false;
        } else if (!category.equals(other.category))
            return false;
        return true;
    }


    

}
