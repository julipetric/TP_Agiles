/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Exceptions.DatosUsuarioException;
import Gestores.GestorUsuario;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.border.Border;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author tomas
 */
public class DarDeAltaUsuario extends javax.swing.JFrame {

    private Border borde;

    /**
     * Creates new form DarDeAltaUsuario
     */
    public DarDeAltaUsuario() {
        initComponents();
        borde = nombreET.getBorder();
        this.setLocationRelativeTo(null);
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon/license-plate.png"));
        ImageIcon icon = new ImageIcon(image);
        setIconImage(icon.getImage());

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
        usuarioET.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent k) {
                if (usuarioET.getText().length() >= 26 || !String.valueOf(k.getKeyChar()).matches("[A-Za-z0-9 ]*")) { //Acepta tambien "_"
                    k.consume();
                }
            }
        });
        passET.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent k) {
                if (String.valueOf(passET.getPassword()).length() >= 26) {
                    k.consume();
                }
            }
        });
        pass2ET.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent k) {
                if (String.valueOf(pass2ET.getPassword()).length() >= 26) {
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

        permisosLabel = new javax.swing.JLabel();
        permisosCombo = new javax.swing.JComboBox<>();
        nombreET = new javax.swing.JTextField();
        nombreLabel = new javax.swing.JLabel();
        apellidoLabel = new javax.swing.JLabel();
        apellidoET = new javax.swing.JTextField();
        userLabel = new javax.swing.JLabel();
        usuarioET = new javax.swing.JTextField();
        pass1Label = new javax.swing.JLabel();
        pass2Label = new javax.swing.JLabel();
        volverBtn = new javax.swing.JButton();
        aceptarBtn = new javax.swing.JButton();
        dniLabel = new javax.swing.JLabel();
        dniET = new javax.swing.JTextField();
        jPanel = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        calleET = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        numeroET = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        departamentoET = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        pisoET = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        ciudadET = new javax.swing.JTextField();
        passET = new javax.swing.JPasswordField();
        pass2ET = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Alta Usuario");
        setResizable(false);

        permisosLabel.setText("Permisos:");

        permisosCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Operario", "Administrador" }));
        permisosCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        nombreLabel.setText("Nombre:");

        apellidoLabel.setText("Apellido:");

        userLabel.setText("Nombre de Usuario:");

        pass1Label.setText("Contraseña:");

        pass2Label.setText("Repetir contraseña:");

        volverBtn.setText("Volver");
        volverBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        aceptarBtn.setText("Aceptar");
        aceptarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aceptarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarBtnActionPerformed(evt);
            }
        });

        dniLabel.setText("DNI:");

        jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Domicilio"));

        jLabel18.setText("Calle");

        jLabel19.setText("N°");

        jLabel20.setText("Piso:");

        jLabel21.setText("Departamento:");

        jLabel22.setText("Ciudad:");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel18)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(pisoET, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(departamentoET, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(calleET, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numeroET, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ciudadET))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ciudadET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(22, 22, 22)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calleET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(numeroET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(pisoET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(departamentoET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(volverBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aceptarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pass2Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pass2ET))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dniLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(userLabel)
                                    .addComponent(nombreLabel)
                                    .addComponent(apellidoLabel)
                                    .addComponent(pass1Label)
                                    .addComponent(permisosLabel))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(permisosCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(apellidoET, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                                            .addComponent(usuarioET, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(dniET, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(nombreET)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(passET, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(permisosLabel)
                    .addComponent(permisosCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidoLabel)
                    .addComponent(apellidoET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dniLabel)
                    .addComponent(dniET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(userLabel)
                    .addComponent(usuarioET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pass1Label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pass2ET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pass2Label))
                .addGap(21, 21, 21)
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(volverBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarBtnActionPerformed

        try {
            String permiso = (String) permisosCombo.getSelectedItem();
            String nombre = nombreET.getText();
            String apellido = apellidoET.getText();
            String dni = dniET.getText();
            String user = usuarioET.getText();
            String pass = String.valueOf(passET.getPassword());
            String pass2 = String.valueOf(pass2ET.getPassword());

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

            String departamento = departamentoET.getText();
            //

            nombreET.setBorder(borde);
            apellidoET.setBorder(borde);
            dniET.setBorder(borde);
            usuarioET.setBorder(borde);
            passET.setBorder(borde);
            pass2ET.setBorder(borde);
            ciudadET.setBorder(borde);
            calleET.setBorder(borde);
            numeroET.setBorder(borde);

            if (GestorUsuario.darDeAltaUsuario(dni, nombre, apellido, user, pass, pass2, permiso, ciudad, calle, numero, piso, departamento)) {
                JOptionPane.showMessageDialog(null, "Usuario creado correctamente", "", JOptionPane.PLAIN_MESSAGE);
                borrarCampos();
            }
        } catch (DatosUsuarioException e) {

            if (!e.getApellido()) {
                apellidoET.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            }

            if (!e.getNombre()) {
                nombreET.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            }

            if (!e.getDni()) {
                dniET.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            }

            if (!e.getUsuario()) {
                usuarioET.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            }

            if (!e.getPass()) {
                passET.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            }

            if (!e.getPass2()) {
                pass2ET.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            }

            if (!e.getDomicilioException().getCiudad()) {
                ciudadET.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            }

            if (!e.getDomicilioException().getCalle()) {
                calleET.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            }

            if (!e.getDomicilioException().getNumero()) {
                numeroET.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            }
        }


    }//GEN-LAST:event_aceptarBtnActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        MenuAdmin menu = new MenuAdmin();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_volverBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarBtn;
    private javax.swing.JTextField apellidoET;
    private javax.swing.JLabel apellidoLabel;
    private javax.swing.JTextField calleET;
    private javax.swing.JTextField ciudadET;
    private javax.swing.JTextField departamentoET;
    private javax.swing.JTextField dniET;
    private javax.swing.JLabel dniLabel;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel;
    private javax.swing.JTextField nombreET;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField numeroET;
    private javax.swing.JLabel pass1Label;
    private javax.swing.JPasswordField pass2ET;
    private javax.swing.JLabel pass2Label;
    private javax.swing.JPasswordField passET;
    private javax.swing.JComboBox<String> permisosCombo;
    private javax.swing.JLabel permisosLabel;
    private javax.swing.JTextField pisoET;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField usuarioET;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void borrarCampos() {
        permisosCombo.setSelectedIndex(0);
        nombreET.setText("");
        apellidoET.setText("");
        dniET.setText("");
        usuarioET.setText("");
        passET.setText("");
        pass2ET.setText("");
        ciudadET.setText("");
        calleET.setText("");
        numeroET.setText("");
        pisoET.setText("");
        departamentoET.setText("");
    }

}
