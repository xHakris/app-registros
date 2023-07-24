
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
            // Realiza tus operaciones en la base de datos aquí
            // Por ejemplo, puedes ejecutar consultas, insertar datos, etc.
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.closeConnection(connection); // Cierra la conexión cuando ya no la necesitas
        }
    }
}

