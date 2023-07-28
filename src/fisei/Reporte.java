/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fisei;

import bd.Cliente;
import javax.swing.DefaultComboBoxModel;
import okhttp3.MediaType;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author User
 */
public class Reporte extends javax.swing.JFrame {
    
    String[] idsPeriodos, periodosList, horariosList, idsHorarios, idsLaboratorios, idsParalelos, idsMaterias, laboratoriosList,paralelosList,materiasList;
    
    DefaultComboBoxModel periodosModel = new DefaultComboBoxModel();
    DefaultComboBoxModel horariosModel = new DefaultComboBoxModel();
    DefaultComboBoxModel laboratoriosModel = new DefaultComboBoxModel();
    DefaultComboBoxModel materiasModel = new DefaultComboBoxModel();
    DefaultComboBoxModel paralelosModel = new DefaultComboBoxModel();
    
    Integer fila, idActual;
    

    Cliente cliente = new Cliente();
    MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public Reporte() {
        initComponents();
        //cargarPeriodos();
        cargarLaboratorios();
        cargarHorarios();
        cargarMaterias();
        cargarParalelos();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        periodos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        horarios = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        laboratorios = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        paralelos = new javax.swing.JComboBox<>();
        materias = new javax.swing.JComboBox<>();
        guardar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Periodo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        periodos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(periodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 140, -1));

        jLabel2.setText("Horario");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, 20));

        horarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(horarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 140, 20));

        jLabel3.setText("Laboratorio");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        laboratorios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(laboratorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 230, -1));

        jLabel4.setText("Materia");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, -1, -1));

        jLabel5.setText("Paralelo");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, -1, -1));

        paralelos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(paralelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 70, -1));

        materias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(materias, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 230, -1));

        guardar.setText("Guardar nuevo");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        getContentPane().add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 170, -1));

        editar.setText("Editar");
        editar.setEnabled(false);
        getContentPane().add(editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 80, -1));

        eliminar.setText("Eliminar");
        eliminar.setEnabled(false);
        getContentPane().add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, 80, -1));

        cancelar.setText("Cancelar");
        cancelar.setEnabled(false);
        getContentPane().add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 160, 170, -1));

        volver.setText("jButton1");
        getContentPane().add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_guardarActionPerformed

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
            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reporte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JButton editar;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton guardar;
    private javax.swing.JComboBox<String> horarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox<String> laboratorios;
    private javax.swing.JComboBox<String> materias;
    private javax.swing.JComboBox<String> paralelos;
    private javax.swing.JComboBox<String> periodos;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables

    private void cargarPeriodos() {
        JSONArray respuesta = cliente.get("http://localhost:8080/periodo/obtenerPeriodos");//Con getResponse() consumimos la api

        periodosList = new String[respuesta.length()];
        idsPeriodos = new String[respuesta.length()];

        for (int i = 0; i < respuesta.length(); i++) {
            JSONObject jsonObject = respuesta.getJSONObject(i);
            idsPeriodos[i] = String.valueOf(jsonObject.getInt("id"));
            periodosList[i] = String.valueOf(jsonObject.getString("nombre"));
        }
        periodosModel = new DefaultComboBoxModel(periodosList);
        periodos.setModel(periodosModel);
    }

    private void cargarHorarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void cargarMaterias() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void cargarLaboratorios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void cargarParalelos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
