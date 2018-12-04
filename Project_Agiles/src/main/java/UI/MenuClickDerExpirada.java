/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Modelo.Licencia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author Julian
 */
public class MenuClickDerExpirada extends JPopupMenu {

    public Licencia lic;

    public Licencia getLic() {
        return lic;
    }

    public void setLic(Licencia lic) {
        this.lic = lic;
    }
    
    public MenuClickDerExpirada(Licencia lic) {
       
        this.setLic(lic);
         
        JMenuItem item = new JMenuItem("Ver detalle");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                //comportamiento botón
            }
        });
        this.add(item);

        item = new JMenuItem("Emitir copia");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                //comportamiento botón
            }
        });
        this.add(item);

        item = new JMenuItem("Renovar licencia");
        item.addActionListener(new RenovarLicenciaActionListener(this.getLic()));
        this.add(item);

        item = new JMenuItem("Modificar datos");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                //comportamiento botón
            }
        });
        this.add(item);
    }

    public class RenovarLicenciaActionListener implements ActionListener {
        
        Licencia lic;

        public Licencia getLic() {
            return lic;
        }

        public void setLic(Licencia lic) {
            this.lic = lic;
        }
        
        private RenovarLicenciaActionListener(Licencia lic) {
            this.setLic(lic);
           
        }

        @Override
        public void actionPerformed(ActionEvent e) {
           RenovarLicencia ventana = new RenovarLicencia(this.getLic());
           ventana.setVisible(true);

        }

    }

}
