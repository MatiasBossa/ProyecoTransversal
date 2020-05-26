/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.modelo;

/**
 *
 * @author Nicolas
 */
public class Cursada {
    private int id=-1;
    private Alumno alumno;
    private Materia materia;
    private int nota;
    
    public Cursada(Alumno alumno, Materia materia, int nota) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }
        
    public Cursada(int id, Alumno alumno, Materia materia, int nota) {
        this.id = id;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }
    
}
