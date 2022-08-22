package com.revature.daos;

import com.revature.pojos.Reimbursement;
import com.revature.services.DatasourceService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ReimbursementDAO implements DatasourceCRUD<Reimbursement>{
    Connection connection;

    public ReimbursementDAO() {
        connection = DatasourceService.getConnection();
    }

    @Override
    public void create(Reimbursement reimbursement) {

         try {
             String sql = "INSERT INTO reimbursements (type, message, user_id, approved) VALUES (?, ?, ?, ?)";
             PreparedStatement pstmt = connection.prepareStatement(sql);

             pstmt.setString(1, reimbursement.getType());
             pstmt.setString(2, reimbursement.getMessage());
             pstmt.setInt(3, reimbursement.getUserId());
             pstmt.setString(4, reimbursement.getApproved());

             pstmt.executeUpdate();

         } catch (SQLException e) {
             e.printStackTrace();
         }
    }

    @Override
    public Reimbursement read(int id) {
        Reimbursement reimbursement = new Reimbursement();

        try {
            String sql = "SELECT * FROM reimbursements WHERE reimbursement_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet results = pstmt.executeQuery();

            if(results.next()) {
                reimbursement.setReimbursementId(results.getInt("reimbursement_id"));
                reimbursement.setType(results.getString("type"));
                reimbursement.setMessage(results.getString("message"));
                reimbursement.setUserId(results.getInt("user_id"));
                reimbursement.setApproved(results.getString("approved"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbursement;
    }

    @Override
    public List readAll() {
        List<Reimbursement> reimbursementList = new LinkedList<>();

        try {
            String sql = "SELECT * FROM reimbursements";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            ResultSet results = pstmt.executeQuery();

            while(results.next()) {
                Reimbursement reimbursement = new Reimbursement();
                reimbursement.setReimbursementId(results.getInt("reimbursement_id"));
                reimbursement.setType(results.getString("type"));
                reimbursement.setMessage(results.getString("message"));
                reimbursement.setUserId(results.getInt("user_id"));
                reimbursement.setApproved(results.getString("approved"));
                reimbursementList.add(reimbursement);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbursementList;
    }

    @Override
    public void update(Reimbursement reimbursement) {
        try {
            String sql = "UPDATE reimbursements SET type = ?, message = ? WHERE reimbursement_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, reimbursement.getType());
            pstmt.setString(2, reimbursement.getMessage());
            pstmt.setInt(3, reimbursement.getReimbursementId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM reimbursements WHERE reimbursement_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, id);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}