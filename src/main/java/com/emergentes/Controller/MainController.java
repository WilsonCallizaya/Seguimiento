package com.emergentes.Controller;

import com.emergentes.bean.BeanEstudiante;
import com.emergentes.entidades.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BeanEstudiante dao = new BeanEstudiante();
        Estudiante es = new Estudiante();
        long id;
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
                nuevo(request, response);
                request.setAttribute("estudiante", es);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "edit":
                id = Long.parseLong(request.getParameter("id"));
                es = dao.buscar(id);
                request.setAttribute("estudiante", es);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "delete":
                id = Long.parseLong(request.getParameter("id"));
                dao.eliminar(id);
                response.sendRedirect("MainController");
                break;
            case "view":
                List<Estudiante> lista = new ArrayList<Estudiante>();
                try {
                    lista = dao.listarTodos();
                } catch (Exception e) {
                    System.out.println("Error al listar");
                }
                request.setAttribute("estudiantes", lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BeanEstudiante dao = new BeanEstudiante();
        String idString = request.getParameter("id");
    long id = 0; // Valor predeterminado o cualquier otro valor apropiado si el campo está vacío
    if (idString != null && !idString.isEmpty()) {
        id = Long.parseLong(idString);
    }
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("email");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        Estudiante es = new Estudiante();
        es.setId(id);
        es.setNombre(nombre);
        es.setApellidos(apellidos);
        es.setEmail(email);
        es.setFechaNacimiento(convierteFecha(fechaNacimiento));
        if (id == 0) {
            dao.insertar(es);

        } else {
            dao.editar(es);
        }
        response.sendRedirect("MainController");

    }

    private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BeanEstudiante dao = new BeanEstudiante();
        Estudiante e = new Estudiante();
        request.setAttribute("estudiante", e);
        request.getRequestDispatcher("editar.jsp").forward(request, response);
    }

    private void mostrar() {
        BeanEstudiante dao = new BeanEstudiante();
        List<Estudiante> lista = dao.listarTodos();

        for (Estudiante item : lista) {
            System.out.println(item.toString());
        }

    }

    private void editar() {
        BeanEstudiante dao = new BeanEstudiante();
        long id = 10;
        Estudiante es = dao.buscar(id);
        es.setNombre("Juana");
        es.setApellidos("Marca");
        es.setEmail("Juana@mail.com");
        dao.editar(es);
    }

    private void eliminar() {

        BeanEstudiante dao = new BeanEstudiante();
        long id = 11;
        dao.eliminar(id);
    }

    public Date convierteFecha(String fecha) {
        Date fechaBD = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fechaTMP;
        try {
            fechaTMP = formato.parse(fecha);
            fechaBD = new Date(fechaTMP.getTime());

        } catch (Exception e) {
        }
        return fechaBD;
    }
}
