/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endpoint;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Carrera;
import models.Docente;
import models.Materia;

/**
 *
 * @author zapju
 */
@WebServlet("/materias")
public class MateriaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Materia> materias = new ArrayList<>();

        try {
            Connection connection = Conexion.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM materia");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(resultSet.getInt("idMateria"));
                materia.setNombreMateria(resultSet.getString("nombreMateria"));

                int docenteID = resultSet.getInt("docenteID");
                Docente docente = obtenerDocentePorID(docenteID);
                materia.setDocente(docente);

                int carreraID = resultSet.getInt("carreraID");
                Carrera carrera = obtenerCarreraPorID(carreraID);
                materia.setCarrera(carrera);

                materias.add(materia);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Convertir la lista de materias a formato JSON y responder con la lista
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(materias));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Implementar la lógica para crear una nueva materia en la base de datos
        // a partir de los datos proporcionados en la solicitud
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Implementar la lógica para actualizar una materia existente en la base de datos
        // a partir de los datos proporcionados en la solicitud
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Implementar la lógica para eliminar una materia existente de la base de datos
        // a partir del ID proporcionado en la solicitud
    }

    private Docente obtenerDocentePorID(int idDocente) {
        return null;
        // Implementar la lógica para obtener un docente por su ID desde la base de datos
        // y retornar un objeto Docente
    }

    private Carrera obtenerCarreraPorID(int idCarrera) {
        return null;
        // Implementar la lógica para obtener una carrera por su ID desde la base de datos
        // y retornar un objeto Carrera
    }

    private Facultad obtenerFacultadPorID(int idFacultad) {
        return null;
        // Implementar la lógica para obtener una facultad por su ID desde la base de datos
        // y retornar un objeto Facultad
    }

    private Bloque obtenerBloquePorID(int idBloque) {
        return null;
        // Implementar la lógica para obtener un bloque por su ID desde la base de datos
        // y retornar un objeto Bloque
    }
}

