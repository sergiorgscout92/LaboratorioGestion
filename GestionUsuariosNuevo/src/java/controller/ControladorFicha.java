/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ficha;
import modelDao.FichaDao;

/**
 *
 * @author APRENDIZ
 */
@WebServlet(name = "ControladorFicha", urlPatterns = {"/ControladorFicha"})
public class ControladorFicha extends HttpServlet {
    String agregarFi="view/FormFicha.jsp";
    String listarFi="view/ListarF.jsp";
    String editarFi="view/EditarF.jsp";
    Ficha fi = new Ficha();
    FichaDao fdao = new FichaDao();
    int cod;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorFicha</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorFicha at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        if(action.equalsIgnoreCase("listarFi")){
            acceso=listarFi;
        }else if(action.equalsIgnoreCase("agregarFi")){
            acceso=agregarFi;
        }if(action.equalsIgnoreCase("Registrar")){
            int codfi = Integer.parseInt(request.getParameter("codficha"));
            int cantapre = Integer.parseInt(request.getParameter("cantapre"));
            String nombrepro = request.getParameter("nombrepro");
            String NombreA = request.getParameter("NombreA");
            
            fi.getCodficha();
            fi.getCantapre();
            fi.getNombrepro();
            fi.getNombreA();
            
            
            
            fdao.registroFicha(fi);
            acceso=listarFi;
        }else if(action.equalsIgnoreCase("eliminarFi")){
            cod=Integer.parseInt(request.getParameter("codficha"));
            fi.getCodficha();
            fdao.eliminarFicha(cod);
            acceso=listarFi;   
        }else if(action.equalsIgnoreCase("editarFi")){
            request.setAttribute("cod", request.getParameter("cod"));
            acceso=editarFi;
        }else if(action.equalsIgnoreCase("Actualizar")){
            
        }       
        RequestDispatcher view=request.getRequestDispatcher(acceso);
            view.forward(request, response);
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
        processRequest(request, response);
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
