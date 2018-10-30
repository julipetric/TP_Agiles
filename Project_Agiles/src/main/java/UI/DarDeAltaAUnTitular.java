/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Exceptions.DatosDomicilioException;
import Exceptions.DatosTitularException;
import Exceptions.DatosUsuarioInvalidosException;
import Gestores.GestorLicencias;
import Gestores.GestorTitular;
import Modelo.Licencia;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author tomas
 */
public class DarDeAltaAUnTitular extends javax.swing.JFrame {

    private Border borde;
    
    /**
     * Creates new form DarDeAltaAUnTitular
     */
    public DarDeAltaAUnTitular() {
        initComponents();
        borde=nombreET.getBorder();
        this.setLocationRelativeTo(null);
        fecha.setMaxSelectableDate(new Date());
        Date minDate = new Date();
        minDate.setTime(minDate.getTime()-TimeUnit.DAYS.toMillis(365*100));
        fecha.setMinSelectableDate(minDate);

        nombreET.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent k) {
                if (nombreET.getText().length() >= 26) {
                    k.consume();
                }
            }
        });
        apellidoET.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent k) {
                if (apellidoET.getText().length() >= 26) {
                    k.consume();
                }
            }
        });
        dniET.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent k) {
                if (dniET.getText().length() >= 8 || k.getKeyChar() < '0' || k.getKeyChar() > '9') {
                    k.consume();
                }
            }
        });
        ciudadET.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent k) {
                if (ciudadET.getText().length() >= 50) {
                    k.consume();
                }
            }
        });
        calleET.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent k) {
                if (calleET.getText().length() >= 50) {
                    k.consume();
                }
            }
        });
        pisoET.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent k) {
                if (pisoET.getText().length() >= 3 || k.getKeyChar() < '0' || k.getKeyChar() > '9') {
                    k.consume();
                }
            }
        });
        numeroET.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent k) {
                if (numeroET.getText().length() >= 6 || k.getKeyChar() < '0' || k.getKeyChar() > '9') {
                    k.consume();
                }
            }
        });
        departamentoET.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent k) {
                if (departamentoET.getText().length() >= 2) {
                    k.consume();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField7 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nombreET = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        apellidoET = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        calleET = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        numeroET = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        departamentoET = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pisoET = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ciudadET = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        grupoSang = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        factor = new javax.swing.JComboBox<>();
        donante = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        dniET = new javax.swing.JTextField();

        jButton2.setText("Guardar");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellido");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Domicilio"));

        jLabel3.setText("Calle");

        jLabel4.setText("N°");

        jLabel5.setText("Piso:");

        jLabel6.setText("Departamento:");

        jLabel7.setText("Ciudad:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pisoET, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(departamentoET, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(calleET, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numeroET, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ciudadET))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ciudadET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calleET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(numeroET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(pisoET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(departamentoET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setText("Fecha nacimiento:");

        jLabel9.setText("Grupo sanguineo:");

        grupoSang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "A", "B", "AB" }));

        jLabel10.setText("Facor Rh:");

        factor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+", "-" }));

        donante.setText("Donante");

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Volver");

        jLabel11.setText("DNI:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombreET, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dniET)
                                    .addComponent(apellidoET))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(factor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(donante))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(grupoSang, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(10, 10, 10)
                                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(nombreET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(grupoSang, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(apellidoET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(factor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(donante))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(dniET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            String nombre = nombreET.getText();
            String apellido = apellidoET.getText();
            String dni = dniET.getText();
            Date fechaNacimiento = fecha.getDate();
            String grupoSanguineo = (String) grupoSang.getSelectedItem();
            String factorRh = (String) factor.getSelectedItem();
            Boolean esDonante = donante.isSelected();
            
            //Domicilio
            String ciudad = ciudadET.getText();
            String calle = calleET.getText();
            String numero = numeroET.getText();
            String piso = pisoET.getText();
            String departamento = departamentoET.getText();
            //
            
            nombreET.setBorder(borde);
            apellidoET.setBorder(borde);
            dniET.setBorder(borde);
            ciudadET.setBorder(borde);
            calleET.setBorder(borde);
            numeroET.setBorder(borde);

            if (GestorTitular.guardarTitular(nombre, apellido, dni, fechaNacimiento, grupoSanguineo, factorRh, esDonante, ciudad, calle, numero, piso, departamento)) {
                JOptionPane.showMessageDialog(null, "Titular dado de alta correctamente", "", JOptionPane.PLAIN_MESSAGE);
                initComponents();
            }

        } catch (DatosTitularException e) {
            
            if(!e.getApellido()) apellidoET.setBorder(BorderFactory.createLineBorder(Color.RED,1));
            
            if(!e.getNombre()) nombreET.setBorder(BorderFactory.createLineBorder(Color.RED,1));
            
            if(!e.getDni()) dniET.setBorder(BorderFactory.createLineBorder(Color.RED,1));
            
            if(!e.getDomicilioException().getCiudad()) ciudadET.setBorder(BorderFactory.createLineBorder(Color.RED,1));
            
            if(!e.getDomicilioException().getCalle()) calleET.setBorder(BorderFactory.createLineBorder(Color.RED,1));
            
            if(!e.getDomicilioException().getNumero()) numeroET.setBorder(BorderFactory.createLineBorder(Color.RED,1));
        }

    }//GEN-LAST:event_jButton1ActionPerformed

        /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

               
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println(ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DarDeAltaAUnTitular().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoET;
    private javax.swing.JTextField calleET;
    private javax.swing.JTextField ciudadET;
    private javax.swing.JTextField departamentoET;
    private javax.swing.JTextField dniET;
    private javax.swing.JCheckBox donante;
    private javax.swing.JComboBox<String> factor;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JComboBox<String> grupoSang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField nombreET;
    private javax.swing.JTextField numeroET;
    private javax.swing.JTextField pisoET;
    // End of variables declaration//GEN-END:variables
}
