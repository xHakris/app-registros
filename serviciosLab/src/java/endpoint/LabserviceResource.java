/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endpoint;

import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import models.Carrera;
import models.Docente;
import models.Materia;

/**
 * REST Web Service
 *
 * @author zapju
 */
@Path("labservice")
public class LabserviceResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LabserviceResource
     */
    public LabserviceResource() {
    }

    /**
     * Retrieves representation of an instance of endpoint.LabserviceResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getMaterias() {
        List<Materia> materias = new ArrayList<>();

        try {
            Connection connection = Conexion.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM materia");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(resultSet.getInt("id"));
                materia.setNombreMateria(resultSet.getString("nombre"));

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
        return new Gson().toJson(materias);
    }

    // Método para obtener un Docente por su ID desde la base de datos
    private Docente obtenerDocentePorID(int idDocente) {
        // Implementar la lógica para obtener un docente por su ID desde la base de datos
        // y retornar un objeto Docente
        // Aquí puedes realizar la consulta a la base de datos para obtener el docente por ID
        // y luego crear y retornar el objeto Docente con los datos obtenidos.
        // Por simplicidad, en este ejemplo, se devuelve null.
        return null;
    }

    // Método para obtener una Carrera por su ID desde la base de datos
    private Carrera obtenerCarreraPorID(int idCarrera) {
        // Implementar la lógica para obtener una carrera por su ID desde la base de datos
        // y retornar un objeto Carrera
        // Aquí puedes realizar la consulta a la base de datos para obtener la carrera por ID
        // y luego crear y retornar el objeto Carrera con los datos obtenidos.
        // Por simplicidad, en este ejemplo, se devuelve null.
        return null;
    }
}
