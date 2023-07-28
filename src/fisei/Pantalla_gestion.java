package fisei;

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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
    Integer fila, idActual;
    String lab1, lab2, carrera1, carrera2, paralelo1, paralelo2, docente1, docente2, nivel1, nivel2, ingreso1, ingreso2, salida1, salida2, materia1, materia2;

    public Pantalla_gestion() {
        initComponents();
        seleccionarMateria();
        this.setLocationRelativeTo(null);
        cargarReportes();
        setFechas();
        cargarTablaReportes("");
        reporteClick.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        reportes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        periodo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bloqueCond = new javax.swing.JComboBox<>();
        jornadaCond = new javax.swing.JComboBox<>();
        dia = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        reporteClick = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        nivelCond = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        auxiliar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reportes.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 321, 1470, 500));

        jButton1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton1.setText("Editar Materias");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 260, -1, 40));

        jButton2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton2.setText("Editar Horarios");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 260, -1, 40));

        periodo.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        periodo.setText("2023 Abril - Septiembre 2023");
        getContentPane().add(periodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 140, -1, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setText("Fecha actual:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 170, -1, -1));

        fecha.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        fecha.setText("24-07-2023");
        getContentPane().add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel4.setText("FACULTAD DE INGENIERIA EN SISTEMAS, ELECTRONICA E INDUSTRIAL");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        bloqueCond.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        bloqueCond.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "Bloque 1", "Bloque 2" }));
        bloqueCond.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bloqueCondItemStateChanged(evt);
            }
        });
        getContentPane().add(bloqueCond, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 100, -1));

        jornadaCond.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jornadaCond.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Niguno", "Mañana", "Tarde" }));
        jornadaCond.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jornadaCondItemStateChanged(evt);
            }
        });
        getContentPane().add(jornadaCond, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 100, -1));

        dia.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        dia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dia.setText("Reporte del dia LUNES");
        getContentPane().add(dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, 360, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setText("Filtrar por");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setText("Bloque");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 50, -1));

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setText("Jornada");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, -1));

        jButton3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton3.setText("Editar Docentes");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, -1, 40));

        reporteClick.setBackground(new java.awt.Color(204, 255, 204));
        reporteClick.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        reporteClick.setText("Generar Reporte Seleccionado");
        reporteClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteClickActionPerformed(evt);
            }
        });
        getContentPane().add(reporteClick, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 260, 240, 40));

        jButton5.setBackground(new java.awt.Color(204, 255, 204));
        jButton5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton5.setText("Generar Reportes");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 160, 40));

        nivelCond.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        nivelCond.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        nivelCond.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                nivelCondItemStateChanged(evt);
            }
        });
        getContentPane().add(nivelCond, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 100, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setText("Nivel");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, -1, -1));

        auxiliar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        getContentPane().add(auxiliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 340, -1));

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setText("Nombre del Auxiliar*");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jButton4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton4.setText("Agregar Reporte");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 160, 40));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel1.setText("Periodo:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 140, -1, -1));

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

        for (int i = 0; i < reportes.getRowCount(); i++) {
            if (i % 2 == 0) {
                //pares
                lab1 = reportes.getValueAt(i, 1).toString();
                docente1 = reportes.getValueAt(i, 2).toString();
                materia1 = reportes.getValueAt(i, 3).toString();
                paralelo1 = reportes.getValueAt(i, 4).toString();
                nivel1 = reportes.getValueAt(i, 5).toString();
                carrera1 = reportes.getValueAt(i, 6).toString();
                ingreso1 = reportes.getValueAt(i, 8).toString();
                salida1 = reportes.getValueAt(i, 9).toString();
                i++;
                
            }
            if(i % 2 != 0 && i<reportes.getRowCount()) { //Controlamos q sea par y que el i no haya superado el rango de reportes
                //impares
                lab2 = reportes.getValueAt(i, 1).toString();
                docente2 = reportes.getValueAt(i, 2).toString();
                materia2 = reportes.getValueAt(i, 3).toString();
                paralelo2 = reportes.getValueAt(i, 4).toString();
                nivel2 = reportes.getValueAt(i, 5).toString();
                carrera2 = reportes.getValueAt(i, 6).toString();
                ingreso2 = reportes.getValueAt(i, 8).toString();
                salida2 = reportes.getValueAt(i, 9).toString();
            }
            try {
                Map parametros = new HashMap();
                parametros.put("fecha", fecha.getText());
                parametros.put("auxiliar", auxiliar.getText());
                parametros.put("periodo", periodo.getText());
                parametros.put("carrera", carrera1);
                parametros.put("carrera2", carrera2);
                parametros.put("lab1", lab1);
                parametros.put("lab2", lab2);
                parametros.put("docente1", docente1);
                parametros.put("docente2", docente2);
                parametros.put("nivel1", nivel1);
                parametros.put("nivel2", nivel2);
                parametros.put("ingreso1", ingreso1);
                parametros.put("ingreso2", ingreso2);
                parametros.put("salida1", salida1);
                parametros.put("salida2", salida2);
                parametros.put("materia1", materia1);
                parametros.put("materia2", materia2);
                parametros.put("paralelo1", paralelo1);
                parametros.put("paralelo1", paralelo2);

                String path = "C:\\Users\\User\\Documents\\NetBeansProjects\\RegistroPracticas\\src\\reporte\\Plantilla.jrxml";
                JasperReport reporte = JasperCompileManager.compileReport(path);
                JasperPrint print = JasperFillManager.fillReport(reporte, parametros, cc.conectar());
                JasperViewer.viewReport(print, false);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "No se puede sacar el reporte, " + ex);
            }
        }


    }//GEN-LAST:event_jButton5ActionPerformed

    private void reporteClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteClickActionPerformed
        imprimirSolo();
    }//GEN-LAST:event_reporteClickActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Reporte r = new Reporte();
        r.show();
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

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
    private javax.swing.JTextField auxiliar;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jornadaCond;
    private javax.swing.JComboBox<String> nivelCond;
    private javax.swing.JLabel periodo;
    private javax.swing.JButton reporteClick;
    private javax.swing.JTable reportes;
    // End of variables declaration//GEN-END:variables

    private void cargarReportes() {

    }

    private void setFechas() {
        DateFormat dateFormat = new SimpleDateFormat("EEEE");//Formato para dias

        String diaNow = dateFormat.format(new Date()).toUpperCase();

        dia.setText("Reporte del día "+diaNow);//guardamos en el txt

        DateFormat fec = new SimpleDateFormat("yyyy-MM-d");//Formato de la fecha

        String date = fec.format(new Date()).toUpperCase();

        fecha.setText(date);//guardamos en el txt

    }

    public void cargarTablaReportes(String condicional) {

        /////////////////
        try {
            String[] titulos = {"#", "Laboratorio", "Docente", "Materia", "Paralelo", "Nivel", "Carrera", "Facultad", "H. Ingreso", "H. Salida", "Periodo académico", "Bloque"};
            String[] materiasList = new String[12];
            modelo = new DefaultTableModel(null, titulos);
            String sql = "SELECT r.id, l.nombre, d.nombre, m.nombre, m.nivel, c.nombre, f.abreviatura, h.horaEntrada, h.horaSalida, b.nombre, p.nombre "
                    + "FROM reporte r "
                    + "JOIN materia m ON r.id_Materia = m.id "
                    + "JOIN horarios h ON r.id_Horario = h.id "
                    + "JOIN laboratorios l ON r.id_Laboratorio = l.id "
                    + "JOIN paralelos p ON r.id_paralelo = p.id "
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
                materiasList[4] = rs.getString("p.nombre");
                materiasList[5] = rs.getString("m.nivel");
                materiasList[6] = rs.getString("c.nombre");
                materiasList[7] = rs.getString("f.abreviatura");
                materiasList[8] = rs.getString("h.horaEntrada");
                materiasList[9] = rs.getString("h.horaSalida");
                materiasList[10] = periodo.getText();
                materiasList[11] = rs.getString("b.nombre");
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

    private void seleccionarMateria() {
        reportes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (reportes.getSelectedRow() != -1) {
                    reporteClick.setEnabled(true);
                    fila = reportes.getSelectedRow();
                    lab1 = reportes.getValueAt(fila, 1).toString();
                    docente1 = reportes.getValueAt(fila, 2).toString();
                    materia1 = reportes.getValueAt(fila, 3).toString();
                    paralelo1 = reportes.getValueAt(fila, 4).toString();
                    nivel1 = reportes.getValueAt(fila, 5).toString();
                    carrera1 = reportes.getValueAt(fila, 6).toString();
                    ingreso1 = reportes.getValueAt(fila, 8).toString();
                    salida1 = reportes.getValueAt(fila, 9).toString();
                    idActual = Integer.valueOf(reportes.getValueAt(fila, 0).toString()); //Guardamos el ID para actualizar o eliminar posteriormente
                }
            }

        });
    }

    private void imprimirReportes() {
        try {
            Map parametros = new HashMap();
            parametros.put("fecha", fecha.getText());
            parametros.put("auxiliar", auxiliar.getText());
            parametros.put("periodo", periodo.getText());
            parametros.put("carrera", auxiliar.getText());
            parametros.put("carrera2", auxiliar.getText());
            parametros.put("lab1", auxiliar.getText());
            parametros.put("lab2", auxiliar.getText());
            parametros.put("docente1", auxiliar.getText());
            parametros.put("docente2", auxiliar.getText());
            parametros.put("nivel1", auxiliar.getText());
            parametros.put("nivel2", auxiliar.getText());
            parametros.put("ingreso1", auxiliar.getText());
            parametros.put("ingreso2", auxiliar.getText());
            parametros.put("salida1", auxiliar.getText());
            parametros.put("salida2", auxiliar.getText());
            parametros.put("materia1", auxiliar.getText());
            parametros.put("materia2", auxiliar.getText());

            String path = "C:\\Users\\User\\Documents\\NetBeansProjects\\RegistroPracticas\\src\\reporte\\Plantilla.jrxml";
            JasperReport reporte = JasperCompileManager.compileReport(path);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametros, cc.conectar());
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "No se puede sacar el reporte, " + ex);
        }
    }
    
    private void imprimirSolo() {
        try {
            Map parametros = new HashMap();
            parametros.put("fecha", fecha.getText());
            parametros.put("auxiliar", auxiliar.getText());
            parametros.put("periodo", periodo.getText());
            parametros.put("carrera", carrera1);
            parametros.put("carrera2", "");
            parametros.put("lab1", lab1);
            parametros.put("lab2", "");
            parametros.put("docente1", docente1);
            parametros.put("docente2", "");
            parametros.put("nivel1", nivel1);
            parametros.put("nivel2", "");
            parametros.put("ingreso1", ingreso1);
            parametros.put("ingreso2", "");
            parametros.put("salida1", salida1);
            parametros.put("salida2", "");
            parametros.put("materia1", materia1);
            parametros.put("materia2", "");
            parametros.put("paralelo1", paralelo1);
            parametros.put("paralelo2", "");

            String path = "C:\\Users\\User\\Documents\\NetBeansProjects\\RegistroPracticas\\src\\reporte\\Plantilla.jrxml";
            JasperReport reporte = JasperCompileManager.compileReport(path);
            JasperPrint print = JasperFillManager.fillReport(reporte, parametros, cc.conectar());
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "No se puede sacar el reporte, " + ex);
        }
    }
}
