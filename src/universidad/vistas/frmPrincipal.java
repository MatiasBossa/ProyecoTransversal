/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.vistas;


/**
 *
 * @author HP
 */
public class frmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form frmPrincipal
     */
    public frmPrincipal() {
        initComponents();
        this.setSize(1024, 600);
        this.setTitle("Sistema transversal. Universidad V 1.0");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_archivo = new javax.swing.JMenu();
        item_salir = new javax.swing.JMenuItem();
        menu_materia = new javax.swing.JMenu();
        item_materia = new javax.swing.JMenuItem();
        menu_alumno = new javax.swing.JMenu();
        item_alumno = new javax.swing.JMenuItem();
        menu_inscripcion = new javax.swing.JMenu();
        item_inscripcion = new javax.swing.JMenuItem();
        item_nota = new javax.swing.JMenuItem();
        menu_consulta = new javax.swing.JMenu();
        item_alumnos_x_materia = new javax.swing.JMenuItem();
        item_materias_x_alumno = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );

        menu_archivo.setText("Archivo");

        item_salir.setText("Salir del sistema");
        item_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_salirActionPerformed(evt);
            }
        });
        menu_archivo.add(item_salir);

        jMenuBar1.add(menu_archivo);

        menu_materia.setText("Materias");

        item_materia.setText("Formulario de Materias");
        item_materia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_materiaActionPerformed(evt);
            }
        });
        menu_materia.add(item_materia);

        jMenuBar1.add(menu_materia);

        menu_alumno.setText("Alumnos");

        item_alumno.setText("Formulario de Alumnos");
        item_alumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_alumnoActionPerformed(evt);
            }
        });
        menu_alumno.add(item_alumno);

        jMenuBar1.add(menu_alumno);

        menu_inscripcion.setText("Cursadas");

        item_inscripcion.setText("Incripciones de Alumnos en Materias");
        item_inscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_inscripcionActionPerformed(evt);
            }
        });
        menu_inscripcion.add(item_inscripcion);

        item_nota.setText("Registrar Notas de Alumno en Materia");
        item_nota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_notaActionPerformed(evt);
            }
        });
        menu_inscripcion.add(item_nota);

        jMenuBar1.add(menu_inscripcion);

        menu_consulta.setText("Consultas");

        item_alumnos_x_materia.setText("Listado de Alumnos Por Materia");
        item_alumnos_x_materia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_alumnos_x_materiaActionPerformed(evt);
            }
        });
        menu_consulta.add(item_alumnos_x_materia);

        item_materias_x_alumno.setText("Listado de Materias Por Alumno");
        item_materias_x_alumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_materias_x_alumnoActionPerformed(evt);
            }
        });
        menu_consulta.add(item_materias_x_alumno);

        jMenuBar1.add(menu_consulta);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void item_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_salirActionPerformed
        // TODO add your handling code here:
        System.exit(WIDTH);
    }//GEN-LAST:event_item_salirActionPerformed

    private void item_materiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_materiaActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        frmMateria frm = new frmMateria();
        frm.setVisible(true);
        escritorio.add(frm);
        escritorio.moveToFront(frm);
    }//GEN-LAST:event_item_materiaActionPerformed

    private void item_alumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_alumnoActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        frmAlumno frm = new frmAlumno();
        frm.setVisible(true);
        escritorio.add(frm);
        escritorio.moveToFront(frm);
    }//GEN-LAST:event_item_alumnoActionPerformed

    private void item_alumnos_x_materiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_alumnos_x_materiaActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        frmAlumnosPorMateria frm = new frmAlumnosPorMateria();
        frm.setVisible(true);
        escritorio.add(frm);
        escritorio.moveToFront(frm);
    }//GEN-LAST:event_item_alumnos_x_materiaActionPerformed

    private void item_materias_x_alumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_materias_x_alumnoActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        frmMateriasPorAlumno frm = new frmMateriasPorAlumno();
        frm.setVisible(true);
        escritorio.add(frm);
        escritorio.moveToFront(frm);
    }//GEN-LAST:event_item_materias_x_alumnoActionPerformed

    private void item_inscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_inscripcionActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        frmInscripcion frm = new frmInscripcion();
        frm.setVisible(true);
        escritorio.add(frm);
        escritorio.moveToFront(frm);
    }//GEN-LAST:event_item_inscripcionActionPerformed

    private void item_notaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_notaActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        frmNota frm = new frmNota();
        frm.setVisible(true);
        escritorio.add(frm);
        escritorio.moveToFront(frm);
    }//GEN-LAST:event_item_notaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem item_alumno;
    private javax.swing.JMenuItem item_alumnos_x_materia;
    private javax.swing.JMenuItem item_inscripcion;
    private javax.swing.JMenuItem item_materia;
    private javax.swing.JMenuItem item_materias_x_alumno;
    private javax.swing.JMenuItem item_nota;
    private javax.swing.JMenuItem item_salir;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menu_alumno;
    private javax.swing.JMenu menu_archivo;
    private javax.swing.JMenu menu_consulta;
    private javax.swing.JMenu menu_inscripcion;
    private javax.swing.JMenu menu_materia;
    // End of variables declaration//GEN-END:variables
}
