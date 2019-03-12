/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import Service.ListeDesPretsService;
import Service.LivreService;
import bo.ListeDesPrets;
import bo.Livre;
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
public class supprimerListeDesPrets extends HttpServlet {
    @EJB
    private LivreService livreServiceImp;
    @EJB
    private ListeDesPretsService listeDesPretsServiceImpl;

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
        try {
            ListeDesPrets listeDesPrets = listeDesPretsServiceImpl.getById(Long.parseLong(request.getParameter("id")));
            listeDesPretsServiceImpl.delete(Long.parseLong(request.getParameter("id")));
            Livre livre = livreServiceImp.getById(listeDesPrets.getLivre().getId());
            livre.setExemplaire(livre.getExemplaire()+1);
            livreServiceImp.update(livre, livre.getId());
            ArrayList<ListeDesPrets> listeDesPretses = listeDesPretsServiceImpl.getAll();
            HttpSession session = request.getSession();
            session.setAttribute("listeDesPretses", listeDesPretses);
        } catch (Exception e) {
        }
        this.getServletContext().getRequestDispatcher("/listeDesPretses.jsp").forward(request, response);
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
