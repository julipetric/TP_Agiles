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
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;

/**
 *
 * @author Julian
 */
class MenuClickDerVigente extends JPopupMenu {

    Licencia lic;

    public Licencia getLic() {
        return lic;
    }

    public void setLic(Licencia lic) {
        this.lic = lic;
    }

    public MenuClickDerVigente(Licencia lic) {

        this.setLic(lic);

        Font f = new Font("sans-serif", Font.BOLD, 12);

        JMenuItem item = new JMenuItem("LICENCIA VIGENTE");
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
        item.addActionListener(new RenovarLicenciaActionListener(this.getLic()));
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
