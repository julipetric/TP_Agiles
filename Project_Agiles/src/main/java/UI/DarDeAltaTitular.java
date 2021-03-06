/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Exceptions.DatosTitularException;
import Gestores.GestorSesion;
import Gestores.GestorTitular;
import Modelo.Titular;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

/**
 *
 * @author tomas
 */
public class DarDeAltaTitular extends javax.swing.JFrame {

    private final Border borde;

    /**
     * Creates new form DarDeAltaAUnTitular
     */
    public DarDeAltaTitular() {
        initComponents();
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon/license-plate.png"));
        ImageIcon icon = new ImageIcon(image);
        setIconImage(icon.getImage());
        borde = nombreET.getBorder();
        this.setLocationRelativeTo(null);
        fecha.setMaxSelectableDate(new Date());
        Date minDate = new Date();
        minDate.setTime(minDate.getTime() - TimeUnit.DAYS.toMillis(365 * 100));
        fecha.setMinSelectableDate(minDate);

        nombreET.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent k) {
                if (nombreET.getText().length() >= 26 || !String.valueOf(k.getKeyChar()).matches("[a-zA-Z0-9 ]*")) {
                    k.consume();
                }
            }
        });
        apellidoET.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent k) {
                if (apellidoET.getText().length() >= 26 || !String.valueOf(k.getKeyChar()).matches("[a-zA-Z0-9 ]*")) {
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
                if (ciudadET.getText().length() >= 30) {
                    k.consume();
                }
            }
        });
        calleET.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent k) {
                if (calleET.getText().length() >= 30) {
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
                if (numeroET.getText().length() >= 5 || k.getKeyChar() < '0' || k.getKeyChar() > '9') {
                    k.consume();
                }
            }
        });
        departamentoET.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent k) {
                if (departamentoET.getText().length() >= 2 || !String.valueOf(k.getKeyChar()).matches("[a-zA-Z0-9]*")) {
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
        guardarButton = new javax.swing.JButton();
        volverButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        dniET = new javax.swing.JTextField();

        jButton2.setText("Guardar");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Alta Titular");
        setResizable(false);

        jLabel1.setText("Nombre:");

        nombreET.setFocusTraversalPolicy(null);
        nombreET.setHighlighter(null);
        nombreET.setNextFocusableComponent(apellidoET);
        nombreET.setVerifyInputWhenFocusTarget(false);

        jLabel2.setText("Apellido");

        apellidoET.setNextFocusableComponent(dniET);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Domicilio"));

        jLabel3.setText("Calle");

        calleET.setNextFocusableComponent(numeroET);

        jLabel4.setText("N°");

        numeroET.setNextFocusableComponent(pisoET);

        jLabel5.setText("Piso:");

        departamentoET.setNextFocusableComponent(volverButton);

        jLabel6.setText("Departamento:");

        pisoET.setNextFocusableComponent(departamentoET);

        jLabel7.setText("Ciudad:");

        ciudadET.setNextFocusableComponent(calleET);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
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
                .addGap(59, 116, Short.MAX_VALUE))
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

        fecha.setNextFocusableComponent(grupoSang);

        jLabel9.setText("Grupo sanguineo:");

        grupoSang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "A", "B", "AB" }));
        grupoSang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        grupoSang.setNextFocusableComponent(factor);

        jLabel10.setText("Facor Rh:");

        factor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+", "-" }));
        factor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        factor.setNextFocusableComponent(donante);

        donante.setText("Donante");
        donante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        donante.setNextFocusableComponent(ciudadET);

        guardarButton.setText("Siguiente");
        guardarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guardarButton.setNextFocusableComponent(nombreET);
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        volverButton.setText("Volver");
        volverButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        volverButton.setNextFocusableComponent(guardarButton);
        volverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverButtonActionPerformed(evt);
            }
        });

        jLabel11.setText("DNI:");

        dniET.setNextFocusableComponent(fecha);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(factor, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(donante))
                            .addComponent(fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(grupoSang, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(volverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(guardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombreET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(apellidoET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(dniET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(grupoSang, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(factor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(donante)
                            .addComponent(jLabel10))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(volverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed

        String nombre = nombreET.getText();
        String apellido = apellidoET.getText();
        String dni = dniET.getText();
        Date fechaNacimiento = fecha.getDate();
        String grupoSanguineo = (String) grupoSang.getSelectedItem();
        String factorRh = (String) factor.getSelectedItem();
        if ("+".equals(factorRh)) {
            factorRh = "Positivo";
        } else {
            factorRh = "Negativo";
        }
        Boolean esDonante = donante.isSelected();
        //Domicilio
        String ciudad = ciudadET.getText();
        String calle = calleET.getText();
        String numero = numeroET.getText();
        String piso;
        if (!pisoET.getText().isEmpty()) {
            piso = pisoET.getText();
        } else {
            piso = "0";
        }

        String departamento;
        if (!departamentoET.getText().isEmpty()) {
            departamento = departamentoET.getText();
        } else {
            departamento = "-";
        }

        //
        jLabel2.setForeground(Color.BLACK);
        jLabel1.setForeground(Color.BLACK);
        jLabel11.setForeground(Color.BLACK);
        jLabel7.setForeground(Color.BLACK);
        jLabel3.setForeground(Color.BLACK);
        jLabel4.setForeground(Color.BLACK);
        jLabel8.setForeground(Color.BLACK);

        Titular tit = new Titular();

        try {
            tit = GestorTitular.guardarTitular(nombre, apellido, dni, fechaNacimiento, grupoSanguineo, factorRh, esDonante, ciudad, calle, numero, piso, departamento);
            EmitirLicencia emitirVentana = new EmitirLicencia(tit, this);
            emitirVentana.setVisible(true);
            //TODO: Hacer que se cierre solo despues de haber impreso la licencia
            this.setVisible(false);
        } catch (DatosTitularException e) {
            if (!e.getApellido()) {
                jLabel2.setForeground(Color.RED);
            }

            if (!e.getNombre()) {
                jLabel1.setForeground(Color.RED);
            }

            if (!e.getDni()) {
                jLabel11.setForeground(Color.RED);
            }

            if (!e.getDomicilioException().getCiudad()) {
                jLabel7.setForeground(Color.RED);
            }

            if (!e.getDomicilioException().getCalle()) {
                jLabel3.setForeground(Color.RED);
            }

            if (!e.getDomicilioException().getNumero()) {
                jLabel4.setForeground(Color.RED);
            }
            if (!e.getFechaNacimiento()) {
                jLabel8.setForeground(Color.RED);
            }
        }


    }//GEN-LAST:event_guardarButtonActionPerformed

    private void volverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverButtonActionPerformed
        if (GestorSesion.getUsuarioActual().isEsAdministrador()) {
            MenuAdmin menu = new MenuAdmin();
            menu.setVisible(true);
            this.dispose();
        } else {
            MenuOperario menu = new MenuOperario();
            menu.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_volverButtonActionPerformed


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
    private javax.swing.JButton guardarButton;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JButton volverButton;
    // End of variables declaration//GEN-END:variables
}
