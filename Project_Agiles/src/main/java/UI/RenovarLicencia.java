/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Exceptions.ComprobanteDirectorioException;
import Exceptions.ComprobanteYaExisteException;
import Exceptions.DatosLicenciaException;
import Exceptions.DatosTitularException;
import Gestores.GestorArchivos;
import Gestores.GestorLicencias;
import Gestores.GestorSesion;
import Gestores.GestorTitular;
import Modelo.Licencia;
import Modelo.Titular;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.exit;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Julian
 */
public class RenovarLicencia extends javax.swing.JFrame {

    Licencia lic;
    Titular tit;
    private Border borde;

    /**
     * Creates new form RenovarLicencia
     */
    public RenovarLicencia(Licencia lic) {
        initComponents();
        this.setLic(lic);
        this.setTit(this.getLic().getTitular());
        borde = nombreET.getBorder();
        this.setLocationRelativeTo(null);
        fecha.setMaxSelectableDate(new Date());
        Date minDate = new Date();
        minDate.setTime(minDate.getTime() - TimeUnit.DAYS.toMillis(365 * 100));
        fecha.setMinSelectableDate(minDate);

        /*Key listeners para validar y restringir los Edit text de la interfaz
         */
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

        

        //Se llenan los campos con los datos actuales del titular
        llenarCampos();
        
        /*Generamos en primera instancia una nueva licencia (sin guardar)
        para que se calcule su fecha de caducidad y el costo, usando los datos
        ya existentes de titular y clase. Se setean donde corresponda.
         */
        try {
            lic = GestorLicencias.crearLicencia(this.getLic().getTitular(), GestorSesion.getUsuarioActual(), (String) this.getLic().getClase());
        } catch (DatosLicenciaException ex) {
            Logger.getLogger(RenovarLicencia.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.getCostoText().setText(((Float) lic.getCosto()).toString());
        this.getExpiracionText().setText(lic.getFechaExpiracion().toString());

    }

    private RenovarLicencia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        jLabel11 = new javax.swing.JLabel();
        dniET = new javax.swing.JTextField();
        nombreLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dniLabel = new javax.swing.JLabel();
        costoText = new javax.swing.JTextField();
        imprimirButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        claseCombo = new javax.swing.JComboBox<>();
        expiracionText = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Nombre:");

        nombreET.setFocusCycleRoot(true);

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

        jLabel11.setText("DNI:");

        dniET.setEditable(false);

        nombreLabel.setText("Clase:");

        jLabel12.setText("Fecha de expiración:");

        dniLabel.setText("Costo:");

        costoText.setEditable(false);

        imprimirButton.setText("Imprimir Comprobante");
        imprimirButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        imprimirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirButtonActionPerformed(evt);
            }
        });

        jButton4.setText("Volver");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        claseCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "E", "G" }));
        claseCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                claseComboItemStateChanged(evt);
            }
        });
        claseCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                claseComboActionPerformed(evt);
            }
        });

        expiracionText.setEditable(false);
        expiracionText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expiracionTextActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setText("RENOVAR LICENCIA");

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dniLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(costoText))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(expiracionText))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nombreLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(claseCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imprimirButton)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel)
                    .addComponent(claseCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(expiracionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dniLabel)
                    .addComponent(costoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imprimirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imprimirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirButtonActionPerformed

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
        nombreET.setBorder(borde);
        apellidoET.setBorder(borde);
        dniET.setBorder(borde);
        ciudadET.setBorder(borde);
        calleET.setBorder(borde);
        numeroET.setBorder(borde);

        /*Guardamos el nuevo objeto licencia en la base de datos, con los
        datos provenientes de la interfaz. Pasamos el nuevo titular (en caso
        de que se hayan cambiado los datos) al metodo de modificar licencia.
         */
        try {
            
            lic = GestorLicencias.modificarLicencia(this.getTit(), GestorSesion.getUsuarioActual(), (String) this.getClaseCombo().getSelectedItem(), this.getLic());
            this.setTit(GestorTitular.modificarTitular(nombre, apellido, dni, fechaNacimiento, grupoSanguineo, factorRh, esDonante, ciudad, calle, numero, piso, departamento));
            GestorArchivos.imprimir(lic);
            File escritorioDelUsuario = FileSystemView.getFileSystemView().getHomeDirectory();

            showMessageDialog(null, "Se guardó el archivo extosamente en " + escritorioDelUsuario.getAbsolutePath() + "/Comprobantes");

            this.dispose();
        } catch (DatosTitularException e) {
            if (!e.getApellido()) {
                apellidoET.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            }

            if (!e.getNombre()) {
                nombreET.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            }

            if (!e.getDni()) {
                dniET.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
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
        } catch (DatosLicenciaException e) {
            Logger.getLogger(RenovarLicencia.class.getName()).log(Level.SEVERE, null, e);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EmitirLicencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ComprobanteYaExisteException ex) {
            Logger.getLogger(RenovarLicencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ComprobanteDirectorioException ex) {
            Logger.getLogger(RenovarLicencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_imprimirButtonActionPerformed

    private void claseComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_claseComboItemStateChanged
        /*Cada vez que cambiamos la clase de la licencia, se re-calcula
        el costo y la fecha de caducidad de la misma. Para esto creamos un
        nuevo objeto licencia (el cual no se guarda hasta que se confima
        la operación. Solo se hace esto porque cuando se construye hacemos
        automaticamente estos calculos.
         */
        Licencia lic = null;
        try {
            lic = GestorLicencias.crearLicencia(this.getTit(), GestorSesion.getUsuarioActual(), (String) this.getClaseCombo().getSelectedItem());
        } catch (DatosLicenciaException ex) {
            Logger.getLogger(RenovarLicencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.getCostoText().setText(((Float) lic.getCosto()).toString());
        this.getExpiracionText().setText(lic.getFechaExpiracion().toString());
    }//GEN-LAST:event_claseComboItemStateChanged

    private void claseComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_claseComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_claseComboActionPerformed

    private void expiracionTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expiracionTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_expiracionTextActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ListadoLicenciasExpirado listado = new ListadoLicenciasExpirado();
        listado.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoET;
    private javax.swing.JTextField calleET;
    private javax.swing.JTextField ciudadET;
    private javax.swing.JComboBox<String> claseCombo;
    private javax.swing.JTextField costoText;
    private javax.swing.JTextField departamentoET;
    private javax.swing.JTextField dniET;
    private javax.swing.JLabel dniLabel;
    private javax.swing.JCheckBox donante;
    private javax.swing.JTextField expiracionText;
    private javax.swing.JComboBox<String> factor;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JComboBox<String> grupoSang;
    private javax.swing.JButton imprimirButton;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombreET;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField numeroET;
    private javax.swing.JTextField pisoET;
    // End of variables declaration//GEN-END:variables

    public JTextField getApellidoET() {
        return apellidoET;
    }

    public JTextField getCalleET() {
        return calleET;
    }

    public JTextField getCiudadET() {
        return ciudadET;
    }

    public JComboBox<String> getClaseCombo() {
        return claseCombo;
    }

    public JTextField getCostoText() {
        return costoText;
    }

    public JTextField getDepartamentoET() {
        return departamentoET;
    }

    public JTextField getDniET() {
        return dniET;
    }

    public JLabel getDniLabel() {
        return dniLabel;
    }

    public JCheckBox getDonante() {
        return donante;
    }

    public JTextField getExpiracionText() {
        return expiracionText;
    }

    public JComboBox<String> getFactor() {
        return factor;
    }

    public JDateChooser getFecha() {
        return fecha;
    }

    public JComboBox<String> getGrupoSang() {
        return grupoSang;
    }

    public JTextField getNombreET() {
        return nombreET;
    }

    public JTextField getNumeroET() {
        return numeroET;
    }

    public JTextField getPisoET() {
        return pisoET;
    }

    public Licencia getLic() {
        return lic;
    }

    public void setLic(Licencia lic) {
        this.lic = lic;
    }

    public Titular getTit() {
        return tit;
    }

    public void setTit(Titular tit) {
        this.tit = tit;
    }

    private void llenarCampos() {
        this.getNombreET().setText(this.getLic().getTitular().getNombre());
        this.getApellidoET().setText(this.getLic().getTitular().getApellido());
        this.getDniET().setText(((Integer) this.getLic().getTitular().getDni()).toString());
        this.getFecha().setDate(this.getLic().getTitular().getFechaNacimiento());
        this.getGrupoSang().setSelectedItem(this.getLic().getTitular().getGrupoSanguineo());
        this.getFactor().setSelectedItem(this.getLic().getTitular().getFactorRh());
        this.getDonante().setSelected(this.getLic().getTitular().isEsDonante());
        this.getCiudadET().setText(this.getLic().getTitular().getDomicilio().getCiudad());
        this.getCalleET().setText(this.getLic().getTitular().getDomicilio().getCalle());
        this.getNumeroET().setText(((Integer) this.getLic().getTitular().getDomicilio().getNumero()).toString());
        this.getPisoET().setText(((Integer) this.getLic().getTitular().getDomicilio().getPiso()).toString());
        this.getDepartamentoET().setText(this.getLic().getTitular().getDomicilio().getDepartamento());
        this.getClaseCombo().setSelectedItem(this.getLic().getClase());
    }
}
