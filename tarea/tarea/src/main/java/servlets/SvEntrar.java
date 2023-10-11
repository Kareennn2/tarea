/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import com.umariana.tarea.Registro;
import com.umariana.tarea.metodos;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
@WebServlet(name = "SvEntrar", urlPatterns = {"/SvEntrar"})
public class SvEntrar extends HttpServlet {

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
        processRequest(request, response);
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
         ServletContext context = getServletContext();
        String nombreUsuario = null;

        // Cargar los usuarios desde el archivo
        ArrayList<Registro> registrar = metodos.cargarUsuarios(context);

        // Almacenar usuario y contraseña en el mapa
        String usuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("contrasenia");

        boolean usuarioValido = false;

        for (Registro reg : registrar) {
            String usuarioRegistro = reg.getUsuario();
            String contraseniaRegistro = reg.getContrasenia();

            if (usuarioRegistro != null && contraseniaRegistro != null &&
                usuarioRegistro.equals(usuario) && contraseniaRegistro.equals(contrasenia)) {
                nombreUsuario = reg.getNombre();
                usuarioValido = true;
                break;
            }
        }

      if(!usuarioValido){response.sendRedirect("tareas.jsp?nombre=" + nombreUsuario);
                   }else{
                        request.getRequestDispatcher("index.jsp");
                   }
    
    
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
