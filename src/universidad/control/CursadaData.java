/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.control;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import universidad.modelo.Alumno;
import universidad.modelo.Cursada;
import universidad.modelo.Materia;

/**
 *
 * @author matia
 */
public class CursadaData {
    
    private Connection connection = null;
    private Conexion conexion;
    
    public CursadaData(Conexion conexion) {
        try {
            this.conexion=conexion;
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    
    public void guardarCursada(Cursada cursada){
        String sql = "INSERT INTO cursada(idAlumno, idMateria, nota) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, cursada.getAlumno().getId());
            statement.setInt(2, cursada.getMateria().getId());
            statement.setInt(3, cursada.getNota());
   
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                cursada.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un alumno");
            }
            statement.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
    }
    
    public List<Cursada> obtenerCursadas(){
        List<Cursada> cursadas = new ArrayList<Cursada>();
            String sql =  "SELECT * FROM cursada";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Cursada cursada;
            while(resultSet.next()){
                cursada = new Cursada();
                cursada.setId(resultSet.getInt("id"));
                
                Alumno a=buscarAlumno(resultSet.getInt("idAlumno"));
                cursada.setAlumno(a);
                
                Materia m=buscarMateria(resultSet.getInt("idMateria"));
                cursada.setMateria(m);
                cursada.setNota(resultSet.getInt("nota"));

                cursadas.add(cursada);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los alumnos: " + ex.getMessage());
        }

        return cursadas;
    }
    
    public List<Cursada> obtenerCursadasXAlumno(int id){
        String sql = "SELECT * FROM cursada WHERE idAlumno = ?";
        List<Cursada> cursadas = new ArrayList<Cursada>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            Cursada cursada;
            while(resultSet.next()){
                cursada = new Cursada();
                cursada.setId(resultSet.getInt("id"));
                
                Alumno a=buscarAlumno(resultSet.getInt("idAlumno"));
                cursada.setAlumno(a);
                
                Materia m=buscarMateria(resultSet.getInt("idMateria"));
                cursada.setMateria(m);
                cursada.setNota(resultSet.getInt("nota"));

                cursadas.add(cursada);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los alumnos: " + ex.getMessage());
        }

        return cursadas;
    }

    public Alumno buscarAlumno(int id){
        AlumnoData ad=new AlumnoData(conexion);
        return ad.buscarAlumno(id);
    }
    
    public Materia buscarMateria(int id){
        MateriaData md=new MateriaData(conexion);
        return md.buscarMateria(id);
    }
    
    public List<Materia> obtenerMateriasCursadas(int id){
        String sql = "SELECT materia.id, materia.nombre  FROM materia, cursada WHERE cursada.idMateria = materia.id AND cursada.idAlumno = ? ";
    List<Materia> materias = new ArrayList<Materia>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Materia materia;
            while(resultSet.next()){
                materia = new Materia();
                materia.setId(resultSet.getInt("id"));
                materia.setNombre(resultSet.getString("nombre"));
                materias.add(materia);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los alumnos: " + ex.getMessage());
        }

        return materias;
    }
    
    public List<Materia> obtenerMateriasNOCursadas(int id){
        String sql = "SELECT materia.id, materia.nombre \n" +
                        "FROM materia \n" +
                        "WHERE materia.id NOT IN (SELECT cursada.idMateria FROM cursada where cursada.idAlumno = ?)";
    List<Materia> materias = new ArrayList<Materia>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Materia materia;
            while(resultSet.next()){
                materia = new Materia();
                materia.setId(resultSet.getInt("id"));
                materia.setNombre(resultSet.getString("nombre"));
                materias.add(materia);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los alumnos: " + ex.getMessage());
        }

        return materias;
      
    }
    
    public void borrarCursadaDeUnaMateriaDeunAlumno(int idAlumno,int idMateria){
        String sql = "DELETE FROM cursada WHERE idAlumno = ? AND idMateria = ? ;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idAlumno);
            statement.setInt(2, idMateria);

            statement.executeUpdate();
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
    }
    
    public void actualizarNotaCursada(int idAlumno,int idMateria, int nota){  
            String sql = "UPDATE cursada SET nota = ? WHERE idAlumno = ? AND idMateria = ? ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,nota);
            statement.setInt(2, idAlumno);
            statement.setInt(3, idMateria);
 
            statement.executeUpdate();         
            
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
    }
}
