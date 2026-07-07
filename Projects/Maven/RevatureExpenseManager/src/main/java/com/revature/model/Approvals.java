package com.revature.model;

public class Approvals {

    int nextId;
    private String approvalId;
    private String expenseId;
    private String status;
    private String reviewer;
    private String comment;
    private String review_date;

    
    public Approvals() {
    }


    public Approvals(String approvalId, String expenseId, String status, String reviewer, String comment, String review_date) {
        this.approvalId = nextId;
        this.expenseId = expenseId;
        this.status = status;
        this.reviewer = reviewer;
        this.comment = comment;
        this.review_date = review_date;
        nextId++;
    }


    public String getApprovalId() {
        return approvalId;
    }


    // public void setApprovalId(String approvalId) {
    //     this.approvalId = approvalId;
    // }


    public String getExpenseId() {
        return expenseId;
    }


    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public String getReviewer() {
        return reviewer;
    }


    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }


    public String getComment() {
        return comment;
    }


    public void setComment(String comment) {
        this.comment = comment;
    }


    public String getReview_date() {
        return review_date;
    }


    public void setReview_date(String review_date) {
        this.review_date = review_date;
    }

    @Override
    public String toString() {
        return "Account{" +
                "approvalId=" + approvalId +
                ", expenseId='" + expenseId + '\'' +
                ", status='" + status + '\'' +
                ", reviewer='" + reviewer + '\'' +
                ", comment='" + comment + '\'' +
                ", review_date='" + review_date + '\'' +
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
        if (approvalId == null) {
            if (other.approvalId != null)
                return false;
        } else if (!approvalId.equals(other.approvalId))
            return false;
        if (expenseId == null) {
            if (other.expenseId != null)
                return false;
        } else if (!expenseId.equals(other.expenseId))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        if (reviewer == null) {
            if (other.reviewer != null)
                return false;
        } else if (!reviewer.equals(other.reviewer))
            return false;
        if (comment == null) {
            if (other.comment != null)
                return false;
        } else if (!comment.equals(other.comment))
            return false;
        if (review_date == null) {
            if (other.review_date != null)
                return false;
        } else if (!review_date.equals(other.review_date))
            return false;
        return true;
    }


    

}
