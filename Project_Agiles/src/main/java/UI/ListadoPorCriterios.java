/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javax.swing.ButtonGroup;

/**
 *
 * @author Julian
 */
public class ListadoPorCriterios extends javax.swing.JFrame {

    /**
     * Creates new form ListadoPorCriterios
     */
    public ListadoPorCriterios() {
        initComponents();
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
        domicilioLabel = new javax.swing.JLabel();
        domicilioEditText = new javax.swing.JTextField();
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
        jTable1 = new javax.swing.JTable();
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

        domicilioLabel.setText("Domicilio:");

        grupoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        grupoLabel.setText("Grupo/Factor:");

        factorCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        claseLabel.setText("Clase:");

        claseCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "A", "B", "C", "D", "E", "F" }));

        donanteLabel.setText("Donante:");

        donanteGroup.add(donanteSiButton);
        donanteSiButton.setText("Sí");

        donanteGroup.add(donanteNoButton);
        donanteNoButton.setText("No");

        vigenteLabel.setText("Licencia vigente:");

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Apellido", "Nombre", "DNI", "Domicilio", "Tipo Licencia", "Fecha Vencimiento", "Grupo/Factor Sanguineo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        buscarButton.setText("Buscar");
        buscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButtonActionPerformed(evt);
            }
        });

        volverButton.setText("Volver");

        vigenteSiCheck.setSelected(true);
        vigenteSiCheck.setText("Sí");

        vigenteNoCheck.setSelected(true);
        vigenteNoCheck.setText("No");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(volverButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buscarButton))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nombreLabel)
                                        .addComponent(dniLabel))
                                    .addGap(18, 18, 18))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(domicilioLabel)
                                    .addGap(11, 11, 11)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(claseLabel)
                                .addGap(31, 31, 31)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(claseCombo, 0, 319, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(domicilioEditText, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                                .addComponent(nombreEditText)
                                .addComponent(dniEditText)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(domicilioLabel)
                    .addComponent(domicilioEditText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grupoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grupoLabel)
                    .addComponent(factorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(claseLabel)
                    .addComponent(claseCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(donanteLabel)
                    .addComponent(donanteSiButton)
                    .addComponent(donanteNoButton)
                    .addComponent(vigenteLabel)
                    .addComponent(vigenteSiCheck)
                    .addComponent(vigenteNoCheck))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarButton)
                    .addComponent(volverButton))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoEditText;
    private javax.swing.JLabel apellidoLabel;
    private javax.swing.JButton buscarButton;
    private javax.swing.JComboBox<String> claseCombo;
    private javax.swing.JLabel claseLabel;
    private javax.swing.JTextField dniEditText;
    private javax.swing.JLabel dniLabel;
    private javax.swing.JTextField domicilioEditText;
    private javax.swing.JLabel domicilioLabel;
    private javax.swing.ButtonGroup donanteGroup;
    private javax.swing.JLabel donanteLabel;
    private javax.swing.JRadioButton donanteNoButton;
    private javax.swing.JRadioButton donanteSiButton;
    private javax.swing.JComboBox<String> factorCombo;
    private javax.swing.JComboBox<String> grupoCombo;
    private javax.swing.JLabel grupoLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nombreEditText;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nroEditText;
    private javax.swing.JLabel nroLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.ButtonGroup vigenteGroup;
    private javax.swing.JLabel vigenteLabel;
    private javax.swing.JCheckBox vigenteNoCheck;
    private javax.swing.JCheckBox vigenteSiCheck;
    private javax.swing.JButton volverButton;
    // End of variables declaration//GEN-END:variables
}
