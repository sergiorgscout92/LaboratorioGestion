package controller;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aprendiz;
import modelDao.AprendizDao;

/**
 *
 * @author APRENDIZ
 */
@WebServlet(name = "ControladorAprendiz", urlPatterns = {"/ControladorAprendiz"})
public class ControladorAprendiz extends HttpServlet {
      String agregarap="view/FAprendiz.jsp";
      String editarap="view/EditarA.jsp";
      String listarap="view/ListarA.jsp";
      int id; 
      Aprendiz p=new Aprendiz();
      AprendizDao adao= new AprendizDao();
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
            out.println("<title>Servlet ControladorAprendiz</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorAprendiz at " + request.getContextPath() + "</h1>");
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
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listarap")){
            acceso=listarap;
        }else if(action.equalsIgnoreCase("agregarap")){
            acceso=agregarap;
        }
        else if(action.equalsIgnoreCase("Registrar")){
            int documento = Integer.parseInt(request.getParameter("documento"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String email = request.getParameter("correo");
            int telefono = Integer.parseInt(request.getParameter("Numero"));
            p.setDocumentoa(documento);
            p.setNombrea(nombre);
            p.setApellidoa(apellido);
            p.setCorreoa(nombre);
            p.setTelefonoa(telefono);
            adao.registrar(p);
            acceso=listarap;
        }else if(action.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));
            p.setId(id);
            adao.eliminar(id);
            acceso=listarap;
        }else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("id", request.getParameter("id"));
            acceso=editarap;
            
             
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
