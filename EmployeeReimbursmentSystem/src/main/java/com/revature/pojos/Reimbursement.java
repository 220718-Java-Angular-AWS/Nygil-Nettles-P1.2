package com.revature.pojos;

import java.util.Objects;

public class Reimbursement {
    private Integer reimbursementId;
    private String type;
    private String message;
    private Integer userId;
    private String approved;

    public Reimbursement() {

    }

    public Reimbursement(Integer reimbursementId, String type, String message, Integer userId, String approved) {
        this.reimbursementId = reimbursementId;
        this.type = type;
        this.message = message;
        this.userId = userId;
        this.approved = approved;
    }

    public Integer getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(Integer reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    @Override
    public String toString() {
        return "reimbursement{" +
                "reimbursementId=" + reimbursementId +
                ", type='" + type + '\'' +
                ", message='" + message + '\'' +
                ", userId=" + userId +
                ", approved=" + approved +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement reimbursement = (Reimbursement) o;
        return Objects.equals(reimbursementId, reimbursement.reimbursementId) && Objects.equals(type, reimbursement.type) && Objects.equals(message, reimbursement.message) && Objects.equals(userId, reimbursement.userId) && Objects.equals(approved, reimbursement.approved);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reimbursementId, type, message, userId, approved);
    }
}