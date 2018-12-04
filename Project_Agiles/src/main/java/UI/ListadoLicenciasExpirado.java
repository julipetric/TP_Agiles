/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Gestores.GestorLicencias;
import Gestores.GestorSesion;
import Modelo.Licencia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tomas
 */
public class ListadoLicenciasExpirado extends javax.swing.JFrame {

    /**
     * Creates new form ListadoLicenciasExpirado
     */
    ArrayList<Licencia> licenciasExpiradas;
    Licencia elegida;

    public Licencia getElegida() {
        return elegida;
    }

    public ListadoLicenciasExpirado() {
        initComponents();

        this.setLicenciasExpiradas(GestorLicencias.getLicenciasExpiradas());

        cargarTabla();
    }

    public void setLicenciasExpiradas(ArrayList<Licencia> licenciasExpiradas) {
        this.licenciasExpiradas = licenciasExpiradas;
    }

    private void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) expiradasTable.getModel();
        modelo.setRowCount(0);
        Iterator it = licenciasExpiradas.iterator();
        while (it.hasNext()) {
            Licencia licencia = (Licencia) it.next();
            Object rowData[] = new Object[5];
            rowData[0] = licencia.getFechaExpiracion();
            rowData[1] = licencia.getTitular().getDni();
            rowData[2] = licencia.getTitular().getNombre();
            rowData[3] = licencia.getTitular().getApellido();
            rowData[4] = licencia.getClase();
            modelo.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        expiradasTable = new javax.swing.JTable();
        volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        expiradasTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fecha expiración", "DNI", "Nombre", "Apellido", "Clase"
            }
        ));
        expiradasTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                expiradasTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(expiradasTable);

        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(volver, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(volver, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        if (GestorSesion.getUsuarioActual().isEsAdministrador()) {
            MenuAdmin menu = new MenuAdmin();
            menu.setVisible(true);
            this.dispose();
        } else {
            MenuOperario menu = new MenuOperario();
            menu.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_volverActionPerformed

    private void expiradasTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expiradasTableMouseClicked
        int r = this.getExpiradasTable().rowAtPoint(evt.getPoint());
        this.setElegida(this.getLicenciasExpiradas().get(r));
        if (r >= 0 && r < this.getExpiradasTable().getRowCount()) {
            this.getExpiradasTable().setRowSelectionInterval(r, r);
        } else {
            this.getExpiradasTable().clearSelection();
        }
        if (SwingUtilities.isRightMouseButton(evt)) {
            MenuClickDerExpirada menu = new MenuClickDerExpirada(this.getElegida());
            menu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_expiradasTableMouseClicked

    public ArrayList<Licencia> getLicenciasExpiradas() {
        return licenciasExpiradas;
    }

    public void setElegida(Licencia elegida) {
        this.elegida = elegida;
    }

    public JTable getExpiradasTable() {
        return expiradasTable;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable expiradasTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
