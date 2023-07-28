package fisei;

import bd.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class Pantalla_gestion extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    Conexion cc = new Conexion();
    Connection cn = cc.conectar();

    public Pantalla_gestion() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarReportes();
        setFechas();
        cargarTablaReportes("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        reportes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bloqueCond = new javax.swing.JComboBox<>();
        jornadaCond = new javax.swing.JComboBox<>();
        dia = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        nivelCond = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        reportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Laboratorio ", "Docente", "Materia", "Nivel", "Hora ingreso", "Hora salida", "Periodo academico"
            }
        ));
        jScrollPane1.setViewportView(reportes);

        jButton1.setText("Editar Materias");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Editar Horarios");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Periodo 2023 Abril - Septiembre");

        jLabel2.setText("Fecha actual:");

        fecha.setText("24-07-2023");

        jLabel4.setText("FACULTAD DE INGENIERIA EN SISTEMAS, ELECTRONICA E INDUSTRIAL");

        jLabel5.setText("Reportes del dia");

        bloqueCond.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "Bloque 1", "Bloque 2" }));
        bloqueCond.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bloqueCondItemStateChanged(evt);
            }
        });

        jornadaCond.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Niguno", "Mañana", "Tarde" }));
        jornadaCond.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jornadaCondItemStateChanged(evt);
            }
        });

        dia.setText("LUNES");

        jLabel3.setText("Filtrar por");

        jLabel6.setText("Bloque");

        jLabel7.setText("Jornada");

        jButton3.setText("Editar Docentes");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Reporte Seleccionado");

        jButton5.setText("Reporte Diario");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        nivelCond.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        nivelCond.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                nivelCondItemStateChanged(evt);
            }
        });

        jLabel8.setText("Nivel");

        jLabel9.setText("Nombre del Auxiliar*");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1308, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(459, 459, 459)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(164, 164, 164))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(104, 104, 104))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fecha))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(354, 354, 354)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(jLabel3)
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bloqueCond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jornadaCond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nivelCond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(59, 59, 59)
                                .addComponent(jLabel8)))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jLabel1))
                .addGap(121, 121, 121))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dia)
                    .addComponent(jButton3))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(fecha))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bloqueCond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jornadaCond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(nivelCond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Materia m = new Materia();
        m.show();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Horario m = new Horario();
        m.show();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bloqueCondItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bloqueCondItemStateChanged
        cambiarBloque(bloqueCond.getSelectedItem().toString());
    }//GEN-LAST:event_bloqueCondItemStateChanged

    private void jornadaCondItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jornadaCondItemStateChanged
        cambiarJornada(jornadaCond.getSelectedItem().toString());
    }//GEN-LAST:event_jornadaCondItemStateChanged

    private void nivelCondItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_nivelCondItemStateChanged
        cambiarNivel(nivelCond.getSelectedItem().toString());
    }//GEN-LAST:event_nivelCondItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Docente m = new Docente();
        m.show();
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            Map parametros = new HashMap();
            parametros.put("fecha", fecha.getText());
            parametros.put("id_reporte", "1");
            String path ="C:\\Users\\User\\Documents\\NetBeansProjects\\RegistroPracticas\\src\\reporte\\Plantilla.jrxml";
            JasperReport reporte = JasperCompileManager.compileReport(path);
            JasperPrint print = JasperFillManager.fillReport(reporte,parametros, cc.conectar());
            JasperViewer.viewReport(print,false);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "No se puede sacar el reporte, "+ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Pantalla_gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla_gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla_gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla_gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla_gestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> bloqueCond;
    private javax.swing.JLabel dia;
    private javax.swing.JLabel fecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> jornadaCond;
    private javax.swing.JComboBox<String> nivelCond;
    private javax.swing.JTable reportes;
    // End of variables declaration//GEN-END:variables

    private void cargarReportes() {

    }

    private void setFechas() {
        DateFormat dateFormat = new SimpleDateFormat("EEEE");//Formato para dias

        String diaNow = dateFormat.format(new Date()).toUpperCase();

        dia.setText(diaNow);//guardamos en el txt

        DateFormat fec = new SimpleDateFormat("yyyy-MM-d");//Formato de la fecha

        String date = fec.format(new Date()).toUpperCase();

        fecha.setText(date);//guardamos en el txt

    }

    public void cargarTablaReportes(String condicional) {
        try {
            String[] titulos = {"#", "Laboratorio", "Docente", "Materia", "Nivel", "Carrera", "Facultad", "H. Ingreso", "H. Salida", "Periodo académico", "Bloque"};
            String[] materiasList = new String[11];
            modelo = new DefaultTableModel(null, titulos);
            String sql = "SELECT r.id, l.nombre, d.nombre, m.nombre, m.nivel, c.nombre, f.abreviatura, h.horaEntrada, h.horaSalida, b.nombre "
                    + "FROM reporte r "
                    + "JOIN materia m ON r.id_Materia = m.id "
                    + "JOIN horarios h ON r.id_Horario = h.id "
                    + "JOIN laboratorios l ON r.id_Laboratorio = l.id "
                    + "JOIN docentes d ON m.docenteID = d.id "
                    + "JOIN carrera c ON m.carreraID = c.id "
                    + "JOIN bloques b ON c.bloqueID = b.id "
                    + "JOIN facultades f ON b.facultadID = f.id "
                    + condicional;

            Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sql);
            while (rs.next()) {
                materiasList[0] = rs.getString("r.id");
                materiasList[1] = rs.getString("l.nombre");
                materiasList[2] = rs.getString("d.nombre");
                materiasList[3] = rs.getString("m.nombre");
                materiasList[4] = rs.getString("m.nivel");
                materiasList[5] = rs.getString("c.nombre");
                materiasList[6] = rs.getString("f.abreviatura");
                materiasList[7] = rs.getString("h.horaEntrada");
                materiasList[8] = rs.getString("h.horaSalida");
                materiasList[9] = "";
                materiasList[10] = rs.getString("b.nombre");
                modelo.addRow(materiasList);
            }
            reportes.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void cambiarBloque(String valor) {
        if (!valor.equals("Ninguno")) {
            switch (valor) {
                case "Bloque 1":
                    cargarTablaReportes("WHERE b.nombre = 'Bloque 1'");
                    break;
                case "Bloque 2":
                    cargarTablaReportes("WHERE b.nombre = 'Bloque 2'");
                    break;

            }
        } else {
            cargarTablaReportes("");
        }
    }

    private void cambiarJornada(String valor) {
        if (!valor.equals("Ninguno")) {
            switch (valor) {
                case "Mañana":
                    cargarTablaReportes("WHERE m.nivel <= 13 ");
                    break;
                case "Tarde":
                    cargarTablaReportes("WHERE m.nivel >= 13 ");
                    break;

            }
        } else {
            cargarTablaReportes("");
        }
    }

    private void cambiarNivel(String valor) {
        if (!valor.equals("Ninguno")) {
            switch (valor) {
                case "1":
                    cargarTablaReportes("WHERE m.nivel = 1");
                    break;
                case "2":
                    cargarTablaReportes("WHERE m.nivel = 2");
                    break;
                case "3":
                    cargarTablaReportes("WHERE m.nivel = 3");
                    break;
                case "4":
                    cargarTablaReportes("WHERE m.nivel = 4");
                    break;
                case "5":
                    cargarTablaReportes("WHERE m.nivel = 5");
                    break;
                case "6":
                    cargarTablaReportes("WHERE m.nivel = 6");
                    break;
                case "7":
                    cargarTablaReportes("WHERE m.nivel = 7");
                    break;
                case "8":
                    cargarTablaReportes("WHERE m.nivel = 8");
                    break;
                case "9":
                    cargarTablaReportes("WHERE m.nivel = 9");
                    break;

            }
        } else {
            cargarTablaReportes("");
        }
    }
}
