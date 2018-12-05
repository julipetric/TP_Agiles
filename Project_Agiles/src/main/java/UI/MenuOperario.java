/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Gestores.GestorSesion;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author tomas
 */
public class MenuOperario extends javax.swing.JFrame {

    /**
     * Creates new form MenuOperario
     */
    public MenuOperario() {
        initComponents();
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon/license-plate.png"));
        ImageIcon icon = new ImageIcon(image);
        setIconImage(icon.getImage());
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listarExpiradasButton = new javax.swing.JButton();
        cerrarSesionButton = new javax.swing.JButton();
        AltaTitularButton = new javax.swing.JButton();
        listarPorCriterioButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Operario");
        setResizable(false);

        listarExpiradasButton.setText("Listar Licencias Expiradas");
        listarExpiradasButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listarExpiradasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarExpiradasButtonActionPerformed(evt);
            }
        });

        cerrarSesionButton.setText("Cerrar Sesion");
        cerrarSesionButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cerrarSesionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionButtonActionPerformed(evt);
            }
        });

        AltaTitularButton.setText("Dar de alta titular");
        AltaTitularButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AltaTitularButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AltaTitularButtonActionPerformed(evt);
            }
        });

        listarPorCriterioButton.setText("Listar licencias por criterio");
        listarPorCriterioButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listarPorCriterioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarPorCriterioButtonActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/engineer (3).png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(listarExpiradasButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AltaTitularButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(listarPorCriterioButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(cerrarSesionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(listarExpiradasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(listarPorCriterioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AltaTitularButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cerrarSesionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listarExpiradasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarExpiradasButtonActionPerformed
        ListadoLicenciasExpirado listado = new ListadoLicenciasExpirado();
        listado.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_listarExpiradasButtonActionPerformed

    private void cerrarSesionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionButtonActionPerformed
        if (GestorSesion.getUsuarioActual() != null) {
            GestorSesion.cerrarSesion();
            Login login = new Login();
            login.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_cerrarSesionButtonActionPerformed

    private void AltaTitularButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AltaTitularButtonActionPerformed
        DarDeAltaTitular ventana = new DarDeAltaTitular();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AltaTitularButtonActionPerformed

    private void listarPorCriterioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarPorCriterioButtonActionPerformed
        ListadoPorCriterios listado = new ListadoPorCriterios();
        listado.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_listarPorCriterioButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AltaTitularButton;
    private javax.swing.JButton cerrarSesionButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton listarExpiradasButton;
    private javax.swing.JButton listarPorCriterioButton;
    // End of variables declaration//GEN-END:variables
}
