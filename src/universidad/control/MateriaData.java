/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import universidad.modelo.Materia;

/**
 *
 * @author HP
 */
public class MateriaData {
    private Connection con;

    public MateriaData(Conexion conexion) {
        try {
            this.con = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion. " + ex.getMessage());
        }
    }
    
    public void guardarMateria(Materia materia) {
        String sql = "INSERT INTO materia (nombre) VALUES( ? );";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next())
                materia.setId(rs.getInt(1));
            else
                System.out.println("ERROR al intentar insertar la materia. No se pudo obetener el ID.");
            
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Materia> obtenerMaterias() {
        List<Materia> listaMaterias = new ArrayList<Materia>();
        String sql = "SELECT * FROM materia;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Materia materia=null;
            while (rs.next()) {
                materia = new Materia();
                materia.setId(rs.getInt("id"));
                materia.setNombre(rs.getString("nombre"));
                
                listaMaterias.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaMaterias;
    }
    
    public Materia buscarMateria(int id) {
        Materia materia = new Materia();
        String sql = "SELECT * FROM materia WHERE materia_id = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                materia.setId(rs.getInt("id"));
                materia.setNombre(rs.getString("nombre"));
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return materia;
    }
}
