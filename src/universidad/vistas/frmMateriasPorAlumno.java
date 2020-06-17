/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.vistas;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import universidad.control.AlumnoData;
import universidad.control.Conexion;
import universidad.control.CursadaData;
import universidad.control.MateriaData;
import universidad.modelo.Alumno;
import universidad.modelo.Cursada;
import universidad.modelo.Materia;

/**
 *
 * @author HP
 */
public class frmMateriasPorAlumno extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo;
    
    private AlumnoData alumnoData;
    private MateriaData materiaData;
    private CursadaData cursadaData;
    
    private ArrayList<Alumno> listaAlumnos;
    private ArrayList<Materia> listaMaterias;
    private ArrayList<Cursada> listaCursada;
    
    private Conexion con;

    /**
     * Creates new form frmMateriasPorAlumno
     */
    public frmMateriasPorAlumno() {
        try {
            initComponents();
            con = new Conexion("jdbc:mariadb://localhost:3306/universidad", "root", "");
            modelo = new DefaultTableModel();
            
            alumnoData = new AlumnoData(con);
            listaAlumnos = (ArrayList)alumnoData.obtenerAlumnos();
            materiaData = new MateriaData(con);
            listaMaterias = (ArrayList)materiaData.obtenerMaterias();
            cursadaData = new CursadaData(con);
            listaCursada = (ArrayList)cursadaData.obtenerCursadas();
            
            cargarAlumnos();
            armarCabezeraTabla();
            cargarDatosTabla();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmMateriasPorAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxAlumno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMaterias = new javax.swing.JTable();

        setClosable(true);
        setTitle("Materias por alumno");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Listado de Materia por Alumnos");

        jLabel2.setText("Alumnos");

        cbxAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAlumnoActionPerformed(evt);
            }
        });

        tblMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblMaterias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cbxAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAlumnoActionPerformed
        // TODO add your handling code here:
        cargarDatosTabla();
    }//GEN-LAST:event_cbxAlumnoActionPerformed

    public void cargarAlumnos() {
        for(Alumno item:listaAlumnos) {
            this.cbxAlumno.addItem(item);
        }
    }
    
    public void armarCabezeraTabla() {
        ArrayList<Object> columnas = new ArrayList<Object>();
        columnas.add("ID");
        columnas.add("MATERIA");
        columnas.add("NOTA");
        for(Object it:columnas) {
            modelo.addColumn(it);
        }
        this.tblMaterias.setModel(modelo);
    }
    
    public void borrarFilasTabla() {

        int f = modelo.getRowCount()-1;
        for (int i=f; i>=0; i--) {
            modelo.removeRow(i);
        }
    }
    
    public void cargarDatosTabla() {
        borrarFilasTabla();
        
        Alumno al = (Alumno)this.cbxAlumno.getSelectedItem();
        for(Cursada a:listaCursada) {
            if (a.getAlumno().getId() == al.getId() ) {
                modelo.addRow(new Object[]{a.getMateria().getId(), a.getMateria().getNombre(), a.getNota()});
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Alumno> cbxAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMaterias;
    // End of variables declaration//GEN-END:variables
}
