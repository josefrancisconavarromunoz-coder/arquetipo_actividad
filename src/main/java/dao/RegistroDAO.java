package dao;

import config.DatabaseConfig;
import model.Registro;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RegistroDAO {

    public List<Registro> obtenerTodos() {
        List<Registro> lista = new ArrayList<>();
        
        try {
            Connection conn = DatabaseConfig.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM alumnos");

            while (rs.next()) {
                Registro r = new Registro(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("email"),
                    rs.getString("telefono"),
                    rs.getString("direccion")
                );
                lista.add(r);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
    }
}