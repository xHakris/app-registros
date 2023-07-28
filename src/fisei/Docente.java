/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fisei;

import bd.Cliente;
import bd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author User
 */
public class Docente extends javax.swing.JFrame {

    MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    DefaultTableModel modelo = new DefaultTableModel();
    String doc;
    Integer fila, idActual;
    Conexion cc = new Conexion();
    Connection cn = cc.conectar();
    TableColumnModel columnModel;
    JSONArray docentesJSON;
    Cliente cliente = new Cliente();

    public Docente() {
        initComponents();
        seleccionarDocente();
        cargarTablaDocentes();
        this.setLocationRelativeTo(null);
        cerrarEdicion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreDocente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jbtn_Nuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        docentes = new javax.swing.JTable();
        jbtn_editar = new javax.swing.JButton();
        jbtn_Eliminar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreDocenteActionPerformed(evt);
            }
        });
        getContentPane().add(nombreDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 201, -1));

        jLabel1.setText("Nombre de la materia");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jbtn_Nuevo.setText("Agregar nuevo");
        jbtn_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_NuevoActionPerformed(evt);
            }
        });
        getContentPane().add(jbtn_Nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 283, 220, 30));

        docentes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(docentes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 11, 870, -1));

        jbtn_editar.setText("Actualizar");
        jbtn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_editarActionPerformed(evt);
            }
        });
        getContentPane().add(jbtn_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 105, 30));

        jbtn_Eliminar.setText("Borrar");
        jbtn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_EliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jbtn_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 105, 30));

        jButton4.setText("Volver");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, -1, -1));

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreDocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreDocenteActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Pantalla_gestion pg = new Pantalla_gestion();
        pg.show();
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jbtn_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_NuevoActionPerformed
        if (nombreDocente.equals("") || nombreDocente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre para el docente");
        } else {
            agregarDocente();
        }
    }//GEN-LAST:event_jbtn_NuevoActionPerformed

    private void jbtn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_editarActionPerformed
        editarDocente();
    }//GEN-LAST:event_jbtn_editarActionPerformed

    private void jbtn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_EliminarActionPerformed
        borrarDocente();
    }//GEN-LAST:event_jbtn_EliminarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        cerrarEdicion();
    }//GEN-LAST:event_cancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Docente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Docente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Docente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Docente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Docente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JTable docentes;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtn_Eliminar;
    private javax.swing.JButton jbtn_Nuevo;
    private javax.swing.JButton jbtn_editar;
    private javax.swing.JTextField nombreDocente;
    // End of variables declaration//GEN-END:variables

    public void cargarTablaDocentes() {
        //http://localhost:8080/docente/obtenerDocentes
        String[] titulos = {"#", "Nombre del docente"};
        modelo = new DefaultTableModel(null, titulos);
        JSONArray datos = cliente.get("http://localhost:8080/docente/obtenerDocentes");//Con getResponse() consumimos la api
        String[] respuesta = new String[2];

        for (int i = 0; i < datos.length(); i++) {
            JSONObject jsonObject = datos.getJSONObject(i); //Guardamos el dato [i] en un objeto
            respuesta[0] = String.valueOf(jsonObject.getInt("id")); //Guardamos el valor del jsonObject en un array
            respuesta[1] = jsonObject.getString("nombre");
            modelo.addRow(respuesta);
        }

        docentes.setModel(modelo);
        columnModel = docentes.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(1);
    }

    private void agregarDocente() {
        JSONObject postData = new JSONObject();
        postData.put("nombre", nombreDocente.getText());

        RequestBody requestbody = RequestBody.create(JSON, postData.toString());

        boolean respuesta = cliente.post("http://localhost:8080/docente/guardar", requestbody);

        if (respuesta) {
            JOptionPane.showMessageDialog(null, "Se ha agregado el docente\n'" + nombreDocente.getText() + "'\ncorrectamente");
            cargarTablaDocentes();
            BorrarTxt();
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar el docente");
        }

    }

    private void editarDocente() {
        if (nombreDocente.getText().isEmpty() || nombreDocente.equals("")) {

            JOptionPane.showMessageDialog(this, "Debe un ingresar un nombre para el docenet");
            nombreDocente.requestFocus();

        } else {
            JSONObject putData = new JSONObject();
            putData.put("id", idActual);
            putData.put("nombre", nombreDocente.getText());

            RequestBody requestbody = RequestBody.create(JSON, putData.toString());

            boolean respuesta = cliente.put("http://localhost:8080/docente/actualizarMateria", requestbody);

            if (respuesta) {
                JOptionPane.showMessageDialog(null, "Actualizo Correctamente");
                cargarTablaDocentes();
                BorrarTxt();
                cerrarEdicion();
            } else {
                JOptionPane.showMessageDialog(null, "Error al editar el docente");
            }
        }

    }

    private void borrarDocente() {

        if (JOptionPane.showConfirmDialog(new JInternalFrame(),
                "Estas seguro de borrar el registro",
                "Borrar registros", JOptionPane.WARNING_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            boolean respuesta = cliente.delete("http://localhost:8080/docente/" + idActual);

            if (respuesta) {
                JOptionPane.showMessageDialog(null, "Se elimino correctamente");
                cargarTablaDocentes();
                BorrarTxt();
                cerrarEdicion();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el docente");
            }
        }

    }

    private void BorrarTxt() {
        nombreDocente.setText("");
    }

    private void seleccionarDocente() {
        docentes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                activarBotonesEdicion();
                if (docentes.getSelectedRow() != -1) {
                    jbtn_Nuevo.setEnabled(false);
                    fila = docentes.getSelectedRow();
                    nombreDocente.setText(docentes.getValueAt(fila, 1).toString());
                    idActual = Integer.valueOf(docentes.getValueAt(fila, 0).toString()); //Guardamos el ID para actualizar o eliminar posteriormente
                }
            }

        });
    }

    private void activarBotonesEdicion() {
        jbtn_editar.setEnabled(true);
        jbtn_Eliminar.setEnabled(true);
        cancelar.setEnabled(true);
    }

    private void cerrarEdicion() {
        jbtn_editar.setEnabled(false);
        jbtn_Eliminar.setEnabled(false);
        cancelar.setEnabled(false);
        nombreDocente.setText("");
        jbtn_Nuevo.setEnabled(true);
    }

}
