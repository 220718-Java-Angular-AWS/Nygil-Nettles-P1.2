package com.revature.services;

import com.revature.daos.ReimbursementDAO;
import com.revature.pojos.Reimbursement;

import java.util.List;

public class ReimbursementService {
    private ReimbursementDAO dao;

    public ReimbursementService() {
        this.dao = new ReimbursementDAO();
    }

    public void saveReimbursement(Reimbursement reimbursement) {
        dao.create(reimbursement);
    }

    public Reimbursement getReimbursement(int id) {
        return dao.read(id);
    }

    public List<Reimbursement> getAllReimbursements() {
        return dao.readAll();
    }

    public List<Reimbursement> getReimbursementsForUser(Integer userId) {
        List<Reimbursement> reimbursementList = dao.readAll();

        for(Reimbursement reimbursement : reimbursementList) {
            if(!reimbursement.getUserId().equals(userId)) {
                reimbursementList.remove(reimbursement);
            }
        }
        return reimbursementList;
    }

    public List<Reimbursement> filterReimbursements(String type) {
        List<Reimbursement> reimbursementList = dao.readAll();
        for (Reimbursement reimbursement : reimbursementList) {
            if (!reimbursement.getType().equals(type)) {
                reimbursementList.remove(reimbursement);
            }
        }
            return reimbursementList;
    }

    public void updateReimbursement(Reimbursement reimbursement) {
        dao.update(reimbursement);
    }

    public void deleteReimbursement(int id) {
        dao.delete(id);
    }

}
