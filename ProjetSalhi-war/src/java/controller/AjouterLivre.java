/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import Service.LivreService;
import bo.Livre;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "AjouterLivre", urlPatterns = {"/ajouterLivre"})
public class AjouterLivre extends HttpServlet {
    @EJB
    private LivreService livreServiceImp;
    private static int boolClick = 1;

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
        this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
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
        long id = 0;
         HttpSession session = request.getSession();
        Livre livre = (Livre) session.getAttribute("livre");
        String cote = request.getParameter("cote");
        String maisonEdition = request.getParameter("maisonEdition");
        String titre = request.getParameter("titre");
        String date = request.getParameter("anneeEdition");
        String exemplaire = request.getParameter("exemplaire");
        String auteur = request.getParameter("auteur");
        if(livre==null){
        livre = new Livre();
        livre.setCote(cote);
        livre.setMaisonEdition(maisonEdition);
        livre.setTitre(titre);
        livre.setAuteur(auteur);
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            livre.setAnneeEdition(format.parse(date));
        } catch (ParseException e) {
        }
        try {
            livre.setExemplaire(Integer.parseInt(exemplaire));
             
            if(request.getParameter("titre")!=null){
             id = livreServiceImp.save(livre);
                session.setAttribute("livre", null);
            }
            livre = null;
        
        } catch (Exception e) {
        }
        }
        
              
                ArrayList<Livre> livres  = livreServiceImp.getAll();
                session.setAttribute("livres", livres);
                this.getServletContext().getRequestDispatcher("/ajouterLivre.jsp").forward(request, response);
               
            
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
