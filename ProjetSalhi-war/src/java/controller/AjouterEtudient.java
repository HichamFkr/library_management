/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import Service.EtudientService;
import bo.Etudient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
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
public class AjouterEtudient extends HttpServlet {
    @EJB
    private EtudientService etudientServiceImp;
    private static HashMap<String,String> erreurs = new HashMap<String, String>();

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
        
       //processRequest(request, response);
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
            HttpSession session = request.getSession();
            String email = request.getParameter("email");
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String matricule = request.getParameter("matricule");
            if(nom==null)
                erreurs.put("nom", "erreurNom");
            if(email==null)
                erreurs.put("email", "erreurEmail");
            if(prenom==null)
                erreurs.put("prenom", "erreurPrenom");
            if(matricule==null)
                erreurs.put("matricule", "erreurMatricule");
            Etudient e = (Etudient) session.getAttribute("etudient");
            long id = 0;
            if(e == null){
            e = new Etudient();
            e.setEmail(email);
            e.setMatricule(matricule);
            e.setNom(nom);
            e.setPrenom(prenom);
            if(nom!=null)
            id = etudientServiceImp.save(e);
            session.setAttribute("etudient", null);
            }
          
                ArrayList<Etudient> etudients = etudientServiceImp.getAll();
                session.setAttribute("etudients", etudients);
            
                this.getServletContext().getRequestDispatcher("/ajouterEtudient.jsp").forward(request, response);
            
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
