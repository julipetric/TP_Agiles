/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Gestores.GestorLicencias;
import Gestores.GestorSesion;
import Modelo.Licencia;
import java.util.ArrayList;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
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
        nombreEditText = new javax.swing.JTextField();
        apellidoLabel = new javax.swing.JLabel();
        apellidoEditText = new javax.swing.JTextField();
        dniLabel = new javax.swing.JLabel();
        dniEditText = new javax.swing.JTextField();
        nroLabel = new javax.swing.JLabel();
        nroEditText = new javax.swing.JTextField();
        grupoCombo = new javax.swing.JComboBox<>();
        grupoLabel = new javax.swing.JLabel();
        factorCombo = new javax.swing.JComboBox<>();
        claseLabel = new javax.swing.JLabel();
        claseCombo = new javax.swing.JComboBox<>();
        donanteLabel = new javax.swing.JLabel();
        donanteSiButton = new javax.swing.JRadioButton();
        donanteNoButton = new javax.swing.JRadioButton();
        vigenteLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLicencias = new javax.swing.JTable();
        buscarButton = new javax.swing.JButton();
        volverButton = new javax.swing.JButton();
        vigenteSiCheck = new javax.swing.JCheckBox();
        vigenteNoCheck = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Listado de Licencias");

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

        claseCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "A", "B", "C", "D", "E", "F" }));
        claseCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        donanteLabel.setText("Donante:");

        donanteGroup.add(donanteSiButton);
        donanteSiButton.setText("Sí");
        donanteSiButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        donanteGroup.add(donanteNoButton);
        donanteNoButton.setText("No");
        donanteNoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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
        tablaLicencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaLicenciasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaLicencias);
        tablaLicencias.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        buscarButton.setText("Buscar");
        buscarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButtonActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(volverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buscarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(nombreEditText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dniEditText, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nroLabel)
                            .addComponent(apellidoLabel)
                            .addComponent(grupoLabel)
                            .addComponent(donanteLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(apellidoEditText, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(grupoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(factorCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(nroEditText, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(donanteSiButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(donanteNoButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(vigenteLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vigenteSiCheck)
                                .addGap(18, 18, 18)
                                .addComponent(vigenteNoCheck))))
                    .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel)
                    .addComponent(nombreEditText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellidoLabel)
                    .addComponent(apellidoEditText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dniLabel)
                    .addComponent(dniEditText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nroLabel)
                    .addComponent(nroEditText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(donanteSiButton)
                    .addComponent(donanteNoButton)
                    .addComponent(vigenteLabel)
                    .addComponent(vigenteSiCheck)
                    .addComponent(vigenteNoCheck))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(volverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed

        //Se crea un arreglo para pasarle al metodo de búsqueda del gestor
        //de licencias para la búsqueda
        ArrayList<Object> criterios = new ArrayList<>(10);

        criterios.add(0, this.nombreEditText.getText());
        criterios.add(1, this.apellidoEditText.getText());
        criterios.add(2, this.dniEditText.getText());
        criterios.add(3, this.nroEditText.getText());
        criterios.add(4, this.grupoCombo.getSelectedItem());
        criterios.add(5, this.factorCombo.getSelectedItem());
        criterios.add(6, this.claseCombo.getSelectedItem());
        if (!donanteSiButton.isSelected() && !donanteNoButton.isSelected()) {
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
    }//GEN-LAST:event_buscarButtonActionPerformed

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
                MenuClickDerVigente menu = new MenuClickDerVigente(this.getElegida());
                menu.show(evt.getComponent(), evt.getX(), evt.getY());
            } else {
                MenuClickDerExpirada menu = new MenuClickDerExpirada(this.getElegida());
                menu.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_tablaLicenciasMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoEditText;
    private javax.swing.JLabel apellidoLabel;
    private javax.swing.JButton buscarButton;
    private javax.swing.JComboBox<String> claseCombo;
    private javax.swing.JLabel claseLabel;
    private javax.swing.JTextField dniEditText;
    private javax.swing.JLabel dniLabel;
    private javax.swing.ButtonGroup donanteGroup;
    private javax.swing.JLabel donanteLabel;
    private javax.swing.JRadioButton donanteNoButton;
    private javax.swing.JRadioButton donanteSiButton;
    private javax.swing.JComboBox<String> factorCombo;
    private javax.swing.JComboBox<String> grupoCombo;
    private javax.swing.JLabel grupoLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreEditText;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nroEditText;
    private javax.swing.JLabel nroLabel;
    private javax.swing.JTable tablaLicencias;
    private javax.swing.JLabel titleLabel;
    private javax.swing.ButtonGroup vigenteGroup;
    private javax.swing.JLabel vigenteLabel;
    private javax.swing.JCheckBox vigenteNoCheck;
    private javax.swing.JCheckBox vigenteSiCheck;
    private javax.swing.JButton volverButton;
    // End of variables declaration//GEN-END:variables
}
