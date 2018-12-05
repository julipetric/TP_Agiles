/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Gestores.GestorArchivos;
import Gestores.GestorLicencias;
import Gestores.GestorSesion;
import Modelo.Licencia;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Julian
 */
public class ListadoPorCriterios extends javax.swing.JFrame {

    Licencia elegida;
    ArrayList<Licencia> licencias;

    public ArrayList<Licencia> getLicencias() {
        return licencias;
    }

    public void setLicencias(ArrayList<Licencia> licencias) {
        this.licencias = licencias;
    }

    public Licencia getElegida() {
        return elegida;
    }

    public void setElegida(Licencia elegida) {
        this.elegida = elegida;
    }

    public JTable getTablaLicencias() {
        return tablaLicencias;
    }

    /**
     * Creates new form ListadoPorCriterios
     */
    public ListadoPorCriterios() {
        initComponents();
        this.setLocationRelativeTo(null);
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon/license-plate.png"));
        ImageIcon icon = new ImageIcon(image);
        setIconImage(icon.getImage());

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
        nroLicenciaET.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent k) {
                if (nroLicenciaET.getText().length() >= 8 || k.getKeyChar() < '0' || k.getKeyChar() > '9') {
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

        donanteGroup = new javax.swing.ButtonGroup();
        vigenteGroup = new javax.swing.ButtonGroup();
        titleLabel = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        nombreET = new javax.swing.JTextField();
        apellidoLabel = new javax.swing.JLabel();
        apellidoET = new javax.swing.JTextField();
        dniLabel = new javax.swing.JLabel();
        dniET = new javax.swing.JTextField();
        nroLabel = new javax.swing.JLabel();
        nroLicenciaET = new javax.swing.JTextField();
        grupoCombo = new javax.swing.JComboBox<>();
        grupoLabel = new javax.swing.JLabel();
        factorCombo = new javax.swing.JComboBox<>();
        claseLabel = new javax.swing.JLabel();
        claseCombo = new javax.swing.JComboBox<>();
        donanteLabel = new javax.swing.JLabel();
        vigenteLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLicencias = new javax.swing.JTable();
        imprimirBusqueda = new javax.swing.JButton();
        volverButton = new javax.swing.JButton();
        vigenteSiCheck = new javax.swing.JCheckBox();
        vigenteNoCheck = new javax.swing.JCheckBox();
        buscarButton1 = new javax.swing.JButton();
        donanteNoButton = new javax.swing.JCheckBox();
        donanteSiButton = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Listado de Licencias por criterio");
        setResizable(false);

        titleLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        titleLabel.setText("BUSCAR LICENCIAS");

        nombreLabel.setText("Nombre:");

        apellidoLabel.setText("Apellido:");

        dniLabel.setText("DNI:");

        nroLabel.setText("Nro. Licencia:");

        grupoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "A", "B", "AB", "0" }));
        grupoCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        grupoLabel.setText("Grupo/Factor:");

        factorCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Positivo", "Negativo" }));
        factorCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        claseLabel.setText("Clase:");

        claseCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "A", "B", "C", "E", "G" }));
        claseCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        donanteLabel.setText("Donante:");

        vigenteLabel.setText("Licencia vigente:");

        tablaLicencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Apellido", "Nombre", "DNI", "Domicilio", "Tipo Licencia", "Fecha Vencimiento", "Grupo/Factor Sanguineo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaLicencias.setColumnSelectionAllowed(true);
        tablaLicencias.setEnabled(false);
        tablaLicencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaLicenciasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaLicencias);
        tablaLicencias.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        imprimirBusqueda.setText("Imprimir busqueda");
        imprimirBusqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        imprimirBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirBusquedaActionPerformed(evt);
            }
        });

        volverButton.setText("Volver");
        volverButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        volverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverButtonActionPerformed(evt);
            }
        });

        vigenteSiCheck.setSelected(true);
        vigenteSiCheck.setText("Sí");
        vigenteSiCheck.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        vigenteNoCheck.setSelected(true);
        vigenteNoCheck.setText("No");
        vigenteNoCheck.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        buscarButton1.setText("Buscar");
        buscarButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buscarButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButton1ActionPerformed(evt);
            }
        });

        donanteNoButton.setText("No");

        donanteSiButton.setText("Si");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nombreLabel)
                                            .addComponent(dniLabel))
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(claseLabel)
                                        .addGap(31, 31, 31)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(claseCombo, 0, 319, Short.MAX_VALUE)
                                    .addComponent(nombreET, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dniET, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nroLabel)
                                    .addComponent(apellidoLabel)
                                    .addComponent(grupoLabel)
                                    .addComponent(donanteLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(apellidoET, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(grupoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(factorCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(nroLicenciaET, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(donanteSiButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(donanteNoButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(vigenteLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(vigenteSiCheck)
                                        .addGap(11, 11, 11)
                                        .addComponent(vigenteNoCheck))))
                            .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(29, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(volverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imprimirBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(682, Short.MAX_VALUE)
                    .addComponent(buscarButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(19, 19, 19)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel)
                    .addComponent(nombreET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellidoLabel)
                    .addComponent(apellidoET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dniLabel)
                    .addComponent(dniET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nroLabel)
                    .addComponent(nroLicenciaET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(claseLabel)
                        .addComponent(claseCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(grupoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(grupoLabel)
                        .addComponent(factorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(donanteLabel)
                    .addComponent(vigenteLabel)
                    .addComponent(vigenteSiCheck)
                    .addComponent(vigenteNoCheck)
                    .addComponent(donanteNoButton)
                    .addComponent(donanteSiButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(volverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imprimirBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(445, Short.MAX_VALUE)
                    .addComponent(buscarButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imprimirBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirBusquedaActionPerformed
        GestorArchivos.imprimirBusqueda(this.getLicencias());

        File escritorioDelUsuario = FileSystemView.getFileSystemView().getHomeDirectory();

        showMessageDialog(null, "Se guardó el archivo extosamente en " + escritorioDelUsuario.getAbsolutePath().toString() + "\\Busquedas");

        this.dispose();
    }//GEN-LAST:event_imprimirBusquedaActionPerformed

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

    private void tablaLicenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaLicenciasMouseClicked
        //Comparamos la posición del cursor con la fila correspondiente y guardamos el valor        
        int r = this.getTablaLicencias().rowAtPoint(evt.getPoint());

        //Cada vez que clickeamos, actualizamos en una variable la licencia elegida
        this.setElegida(this.getLicencias().get(r));

        //Si clickeamos fuera de la tabla, desceleccionamos
        if (r >= 0 && r < this.getTablaLicencias().getRowCount()) {
            this.getTablaLicencias().setRowSelectionInterval(r, r);
        } else {
            this.getTablaLicencias().clearSelection();
        }

        /*Si es click derecho, generamos el menú desplegable. Se le pasa 
        la licencia elegida actual para futuro uso*/
        if (SwingUtilities.isRightMouseButton(evt)) {
            if (GestorLicencias.esVigente(this.getElegida())) {
                MenuClickDerVigente menu = new MenuClickDerVigente(this.getElegida(), null, this);
                menu.show(evt.getComponent(), evt.getX(), evt.getY());
            } else {
                MenuClickDerExpirada menu = new MenuClickDerExpirada(this.getElegida(), null, this);
                menu.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_tablaLicenciasMouseClicked

    private void buscarButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButton1ActionPerformed
        //Se crea un arreglo para pasarle al metodo de búsqueda del gestor
        //de licencias para la búsqueda
        cargarTabla();
    }//GEN-LAST:event_buscarButton1ActionPerformed

    public void cargarTabla() {
        //Se crea un arreglo para pasarle al metodo de búsqueda del gestor
        //de licencias para la búsqueda
        ArrayList<Object> criterios = new ArrayList<>(10);

        criterios.add(0, this.nombreET.getText());
        criterios.add(1, this.apellidoET.getText());
        criterios.add(2, this.dniET.getText());
        criterios.add(3, this.nroLicenciaET.getText());
        criterios.add(4, this.grupoCombo.getSelectedItem());
        criterios.add(5, this.factorCombo.getSelectedItem());
        criterios.add(6, this.claseCombo.getSelectedItem());
        if (donanteSiButton.isSelected() == donanteNoButton.isSelected()) {
            criterios.add(7, null);
        } else {
            criterios.add(7, this.donanteSiButton.isSelected());
        }
        criterios.add(8, this.vigenteSiCheck.isSelected());
        criterios.add(9, this.vigenteNoCheck.isSelected());

        ArrayList<Licencia> lista = new ArrayList<>();
        this.setLicencias(GestorLicencias.buscarPorCriterios(criterios));

        DefaultTableModel model = (DefaultTableModel) this.getTablaLicencias().getModel();
        model.setRowCount(0);
        for (int i = 0; i < this.getLicencias().size(); i++) {
            String grupoFactor = this.getLicencias().get(i).getTitular().getGrupoSanguineo() + " " + this.getLicencias().get(i).getTitular().getFactorRh();
            Object[] fila = new Object[]{
                this.getLicencias().get(i).getTitular().getApellido(),
                this.getLicencias().get(i).getTitular().getNombre(),
                this.getLicencias().get(i).getTitular().getDni(),
                this.getLicencias().get(i).getTitular().getDomicilio().asString(),
                this.getLicencias().get(i).getClase(),
                this.getLicencias().get(i).getFechaExpiracion(), grupoFactor};
            model.addRow(fila);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoET;
    private javax.swing.JLabel apellidoLabel;
    private javax.swing.JButton buscarButton1;
    private javax.swing.JComboBox<String> claseCombo;
    private javax.swing.JLabel claseLabel;
    private javax.swing.JTextField dniET;
    private javax.swing.JLabel dniLabel;
    private javax.swing.ButtonGroup donanteGroup;
    private javax.swing.JLabel donanteLabel;
    private javax.swing.JCheckBox donanteNoButton;
    private javax.swing.JCheckBox donanteSiButton;
    private javax.swing.JComboBox<String> factorCombo;
    private javax.swing.JComboBox<String> grupoCombo;
    private javax.swing.JLabel grupoLabel;
    private javax.swing.JButton imprimirBusqueda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreET;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JLabel nroLabel;
    private javax.swing.JTextField nroLicenciaET;
    private javax.swing.JTable tablaLicencias;
    private javax.swing.JLabel titleLabel;
    private javax.swing.ButtonGroup vigenteGroup;
    private javax.swing.JLabel vigenteLabel;
    private javax.swing.JCheckBox vigenteNoCheck;
    private javax.swing.JCheckBox vigenteSiCheck;
    private javax.swing.JButton volverButton;
    // End of variables declaration//GEN-END:variables
}
