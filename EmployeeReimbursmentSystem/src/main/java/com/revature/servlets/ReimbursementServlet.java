package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Reimbursement;
import com.revature.services.ReimbursementService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class ReimbursementServlet extends HttpServlet {
    private ReimbursementService service;
    private ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        System.out.println("Reimbursement servlet initializing...");
        this.service = new ReimbursementService();
        this.mapper = new ObjectMapper();
        System.out.println("Reimbursement servlet initialized!");
    }

    @Override
    public void destroy() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer userId = Integer.parseInt(req.getParameter("user-id"));

        List<Reimbursement> reimbursementList = service.getReimbursementsForUser(userId);

        String json = mapper.writeValueAsString(reimbursementList);

        resp.getWriter().print(json);
        resp.setStatus(200);
        resp.setContentType("Application/Json");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader buffer = req.getReader();

        while(buffer.ready()) {
            builder.append(buffer.readLine());
        }

        String json = builder.toString();
        Reimbursement newReimbursement = mapper.readValue(json, Reimbursement.class);

        service.saveReimbursement(newReimbursement);

        resp.setStatus(200);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("approved");
        if(param==null) {
            StringBuilder builder = new StringBuilder();
            BufferedReader buffer = req.getReader();
            while(buffer.ready()) {
                builder.append(buffer.readLine());
            }
            String json = builder.toString();
            Reimbursement updated = mapper.readValue(json, Reimbursement.class);
            service.updateReimbursement(updated);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer reimbursementId = Integer.parseInt(req.getParameter("reimbursement-id"));
        service.deleteReimbursement(reimbursementId);
    }


}
