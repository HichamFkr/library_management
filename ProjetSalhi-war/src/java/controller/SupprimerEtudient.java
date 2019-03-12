/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Service.EtudientService;
import Service.ListeDesPretsService;
import bo.Etudient;
import bo.ListeDesPrets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
public class SupprimerEtudient extends HttpServlet {
    @EJB
    private ListeDesPretsService listeDesPretsServiceImpl;

    @EJB
    private EtudientService etudientServiceImp;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        ArrayList<ListeDesPrets> list = listeDesPretsServiceImpl.getByIdEtudient(id);
        if(list.size()==0){
        etudientServiceImp.delete(id);
        ArrayList<Etudient> etudients = etudientServiceImp.getAll();
        HttpSession session = request.getSession();
        session.setAttribute("etudients", etudients);
        }else{
            
        }
        this.getServletContext().getRequestDispatcher("/ListEtudient.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
