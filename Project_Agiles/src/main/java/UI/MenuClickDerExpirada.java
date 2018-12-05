/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Modelo.Licencia;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author Julian
 */
public class MenuClickDerExpirada extends JPopupMenu {

    private Licencia lic;
    private JFrame ventana;

    public Licencia getLic() {
        return lic;
    }

    public void setLic(Licencia lic) {
        this.lic = lic;
    }
    
    public void setVentana(JFrame ventana){
    this.ventana = ventana;
    }
    public MenuClickDerExpirada(Licencia lic,JFrame ventana) {
       
        this.setLic(lic);
        this.setVentana(ventana);
        
        Font f = new Font("sans-serif", Font.BOLD, 12);

        JMenuItem item = new JMenuItem("LICENCIA EXPIRADA");
        item.setFont(f);
        item.setEnabled(false);
        this.add(item);
        
        item = new JMenuItem("Ver detalle");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                //comportamiento botón
            }
        });
        item.setEnabled(false);
        this.add(item);

        item = new JMenuItem("Emitir copia");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                //comportamiento botón
            }
        });
        item.setEnabled(false);
        this.add(item);

        item = new JMenuItem("Renovar licencia");
        item.addActionListener(new RenovarLicenciaActionListener(this.getLic(), ventana ));
        this.add(item);

        item = new JMenuItem("Modificar datos");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                //comportamiento botón
            }
        });
        item.setEnabled(false);
        this.add(item);
    }

    public class RenovarLicenciaActionListener implements ActionListener {
        
        private Licencia lic;
        private JFrame ventana;

        public Licencia getLic() {
            return lic;
        }

        public void setLic(Licencia lic) {
            this.lic = lic;
        }
        
        public void setVentana(JFrame ventana){
        this.ventana = ventana;
        }
        
        private RenovarLicenciaActionListener(Licencia lic, JFrame ventana) {
            this.setLic(lic);
            this.setVentana(ventana);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
           RenovarLicencia ventanaRenovar = new RenovarLicencia(this.getLic(), ventana);
           ventanaRenovar.setVisible(true);
           this.ventana.setVisible(false);
        }

    }

}
