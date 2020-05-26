/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.control;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import universidad.modelo.Alumno;

/**
 *
 * @author HP
 */
public class AlumnoData {
    private Connection con;

    public AlumnoData(Conexion conexion) {
        try {
            con = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion. " + ex.getMessage());
        }

    }

    public void guardarAlumno(Alumno alumno) {
        try {
            String sql = "INSERT INTO alumno (nombre, fecNac, activo) VALUES (? , ? , ?);";
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alumno.getNombre());
            ps.setDate(2, Date.valueOf( alumno.getFecNac()) );
            ps.setBoolean(3, alumno.getActivo());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next())
                alumno.setId(rs.getInt(1));
            else
                System.out.println("No se pudo obtener el id luego de insertar un alumno");
            
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Alumno> obtenerAlumnos() {
        List<Alumno> listaAlumnos = new ArrayList<Alumno>();
        String sql = "SELECT * FROM alumno;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Alumno alumno;
            while (rs.next()) {
                alumno = new Alumno();
                alumno.setId(rs.getInt("id"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFecNac(rs.getDate("fecNac").toLocalDate());
                alumno.setActivo(rs.getBoolean("activo"));
                
                listaAlumnos.add(alumno);
            }
            ps.close();
        } catch (SQLException e) {
            //Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("ERROR al intentar conectar a sql. " + e.getMessage());
        }
        return listaAlumnos;
    }
    
    public void borrarAlumno(int id) {
        try {
            String sql = "DELETE FROM alumno WHERE id = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarAlumno(Alumno alumno) {
        try {
            String sql = "UPDATE alumno SET nombre = ?, fecNac = ?, activo = ? WHERE id = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, alumno.getNombre());
            ps.setDate(2, Date.valueOf(alumno.getFecNac()));
            ps.setBoolean(3, alumno.getActivo());
            ps.setInt(4, alumno.getId());
            
            ps.executeUpdate();
            
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public Alumno buscarAlumno(int id) {
        Alumno alumno=null;
        try {
            String sql = "SELECT * FROM alumno WHERE id = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setId(rs.getInt("id"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFecNac(rs.getDate("fecNac").toLocalDate());
                alumno.setActivo(rs.getBoolean("activo"));
            }
            
            ps.close();            
        
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumno;
    }
}
