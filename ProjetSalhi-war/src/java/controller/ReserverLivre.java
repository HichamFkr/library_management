/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import Service.ListeDesPretsService;
import Service.LivreService;
import bo.Etudient;
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
public class ReserverLivre extends HttpServlet {
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
    @EJB
   private LivreService livreService; 
   private ArrayList<Livre> list ;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Livre livre = livreService.getById(Long.parseLong(request.getParameter("id")));
        HttpSession session = request.getSession();
        list = (ArrayList<Livre>) session.getAttribute("listReserver");
        Etudient e = (Etudient) session.getAttribute("etudient");
        if(list == null){
            list = new ArrayList<>();
        }
        if(list.size()>3 || e == null ){
            
            session.setAttribute("listReserver",new ArrayList<Livre>());
        }else{
            list.add(livre);
            session.setAttribute("listReserver", list);
        }
        System.out.println("list "+list.size());
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
        HttpSession session = request.getSession();
        list = (ArrayList<Livre>) session.getAttribute("listReserver");
       String message = "";
        if(list != null){
             Etudient e = (Etudient)session.getAttribute("etudient"); 
             ArrayList<ListeDesPrets> ldps = listeDesPretsServiceImpl.getByIdEtudient(e.getId());
            if(ldps.size()<3&&(list.size()==Math.abs(list.size()-ldps.size())||list.size()<Math.abs(list.size()-ldps.size()))){ 
            for (Livre livre : list) {
                ListeDesPrets listeDesPrets = new ListeDesPrets();
                listeDesPrets.setEtudient(e);
                listeDesPrets.setLivre(livre);
                listeDesPrets.setIsRetourne(false);
                long id = listeDesPretsServiceImpl.save(listeDesPrets);
                livre.setExemplaire(livre.getExemplaire()-1);
                livreServiceImp.update(livre, livre.getId());
            }   
            
            }else{
                 message ="err"; 
                
            }
               list.removeAll(list); 
            session.setAttribute("edudient", null);
        session.setAttribute("listReservarion", null);
                   
       // this.getServletContext().getRequestDispatcher("/ListEtudient.jsp").forward(request, response);
        }
       this.getServletContext().getRequestDispatcher("/ListEtudient.jsp").forward(request, response);
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
