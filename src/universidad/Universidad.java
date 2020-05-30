/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import universidad.modelo.Alumno;
import universidad.control.AlumnoData;
import universidad.control.Conexion;
import universidad.control.CursadaData;
import universidad.control.MateriaData;
import universidad.modelo.Cursada;
import universidad.modelo.Materia;

/**
 *
 * @author HP
 */
public class Universidad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

            
            //Connection con = new Conexion().getConexion();
            Conexion cargarConexion;
            try {
                cargarConexion = new Conexion();
                

                //Alumno alumno = new Alumno("Carlos", LocalDate.now(), true);
                AlumnoData ad = new AlumnoData(cargarConexion);
                //ad.guardarAlumno(al);

                /*
                List<Alumno> lista = ad.obtenerAlumnos();
                for (Alumno it:lista){
                    System.out.println("id: " + it.getId());
                    System.out.println("Nombre: " + it.getNombre());
                }
                */

                
                //ad.borrarAlumno(4);
                
                
                /*
                Alumno ab = ad.buscarAlumno(5);
                ab.setNombre("Pedro Jose DONOSO");
                ad.actualizarAlumno(ab);
                */
                
                MateriaData md = new MateriaData(cargarConexion);
                //Materia materia = new Materia("Laboratorio I");
                //md.guardarMateria(materia);
                
                /*
                List<Materia> materias = new ArrayList<Materia>();
                materias = md.obtenerMaterias();
                for (Materia m:materias) {
                    System.out.println("Id: " + m.toString());
                }
                */
                

                Alumno alumno = new Alumno();
                alumno = ad.buscarAlumno(3);
                Materia materia = new Materia();
                materia = md.buscarMateria(2);
                
                Cursada cursada = new Cursada(alumno,materia,10);
                CursadaData cd = new CursadaData(cargarConexion);                
                cd.guardarCursada(cursada);
                
                
            }catch (ClassNotFoundException ex) {
                //Logger.getLogger(Universidad.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("ERROR: no existen los drivers para la conexion. " + ex.getMessage());
            }

          
    }
    
}
