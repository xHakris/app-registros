
package bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection conn = null;
    
    public Connection conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/registrolaboratorios","root","");
        }catch(Exception e){
            System.out.println(e);}
        return conn;
 
    }
}
