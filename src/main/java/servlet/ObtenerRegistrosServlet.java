package servlet;

import dao.RegistroDAO;
import model.Registro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
//Esta clase recibe la petición cuando el usuario pulsa el botón, pedirle los datos 
//a la base de datos y enviárselos a la vista
@WebServlet("/registros")
public class ObtenerRegistrosServlet extends HttpServlet {

    private final RegistroDAO registroDAO = new RegistroDAO();

    @Override //procesar la petición
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        //obtener y enviar datos 
        List<Registro> lista = registroDAO.obtenerTodos();
        request.setAttribute("registros", lista);
        //redirección a la vista
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}