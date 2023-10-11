package servlets;

import com.umariana.tarea.Registro;
import com.umariana.tarea.metodos;

import java.io.*;
import java.util.*;
import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvIngresar", urlPatterns = {"/SvIngresar"})
public class SvIngresar extends HttpServlet {
   ArrayList <Registro> registrar = new ArrayList<>();
   
   metodos metodoss = new metodos();
    /**
     * Processes requests for both HTTP GET and POST methods.
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        
        // Obtener datos del formulario
        String nombre = request.getParameter("nombre");
        String usuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("contrasenia");
        
        // Crear un nuevo registro
        Registro nuevoRegistro = new Registro(nombre, usuario, contrasenia);
        
        // Cargar los usuarios existentes
        ArrayList<Registro> registrar = metodos.cargarUsuarios(context);
        
        // Agregar el nuevo registro a la lista
        registrar.add(nuevoRegistro);
        
        // Guardar la lista actualizada en el archivo
        metodos.guardarUsuarios(context, registrar);
        
       response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
