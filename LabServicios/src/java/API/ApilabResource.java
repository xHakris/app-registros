/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import models.Bloque;
import models.Carrera;
import models.Docente;
import models.Facultad;
import models.Materia;

/**
 * REST Web Service
 *
 * @author zapju
 */
@Path("apilab")
public class ApilabResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ApilabResource
     */
    public ApilabResource() {
    }

    /**
     * Retrieves representation of an instance of API.ApilabResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/materias")
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
    Docente docente = null;
    try {
        Connection connection = Conexion.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM docente WHERE id = ?");
        statement.setInt(1, idDocente);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            docente = new Docente();
            docente.setIdDocente(resultSet.getInt("id"));
            docente.setNombreDocente(resultSet.getString("nombre"));
        }

        resultSet.close();
        statement.close();
        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return docente;
}

private Carrera obtenerCarreraPorID(int idCarrera) {
    Carrera carrera = null;
    try {
        Connection connection = Conexion.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM carrera WHERE id = ?");
        statement.setInt(1, idCarrera);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            carrera = new Carrera();
            carrera.setIdCarrera(resultSet.getInt("id"));
            carrera.setNombreCarrera(resultSet.getString("nombre"));
            // Si la tabla "carrera" tiene una columna que referencia al "bloque", puedes obtener el ID del bloque y asignarlo aquí.
            int idBloque = resultSet.getInt("bloqueID");
            Bloque bloque = obtenerBloquePorID(idBloque);
            carrera.setBloque(bloque);
        }

        resultSet.close();
        statement.close();
        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return carrera;
}

private Bloque obtenerBloquePorID(int idBloque) {
    Bloque bloque = null;
    try {
        Connection connection = Conexion.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM bloque WHERE id = ?");
        statement.setInt(1, idBloque);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            bloque = new Bloque();
            bloque.setIdBloque(resultSet.getInt("id"));
            bloque.setNombreBloque(resultSet.getString("nombre"));
            
            // Si la tabla "bloque" tiene una columna que referencia a la "facultad", puedes obtener el ID de la facultad y asignarlo aquí.
            int idFacultad = resultSet.getInt("facultadID");
            Facultad facultad = obtenerFacultadPorID(idFacultad);
            bloque.setFacultad(facultad);
        }

        resultSet.close();
        statement.close();
        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return bloque;
}

private Facultad obtenerFacultadPorID(int idFacultad) {
    Facultad facultad = null;
    try {
        Connection connection = Conexion.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM facultad WHERE id = ?");
        statement.setInt(1, idFacultad);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            facultad = new Facultad();
            facultad.setIdFacultad(resultSet.getInt("id"));
            facultad.setAbreviaturaFacultad(resultSet.getString("abreviatura"));
            facultad.setNombreFacultad(resultSet.getString("nombre"));
        }

        resultSet.close();
        statement.close();
        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return facultad;
}



    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ApilabResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
