/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Exceptions.LicenciaDirectorioException;
import Exceptions.LicenciaYaExisteException;
import Gestores.GestorArchivos;
import Modelo.Licencia;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author Julian
 */
public class MenuClickDerExpirada extends JPopupMenu {

    private Licencia lic;
    private ListadoLicenciasExpirado ventanaExpirado;
    private ListadoPorCriterios ventanaCriterio;

    public Licencia getLic() {
        return lic;
    }

    public void setLic(Licencia lic) {
        this.lic = lic;
    }

    public MenuClickDerExpirada(Licencia lic, ListadoLicenciasExpirado ventanaExpirado, ListadoPorCriterios ventanaCriterio) {

        this.setLic(lic);
        this.ventanaCriterio = ventanaCriterio;
        this.ventanaExpirado = ventanaExpirado;

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
                try {
                    GestorArchivos.imprimirLicencia(lic);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MenuClickDerExpirada.class.getName()).log(Level.SEVERE, null, ex);
                } catch (LicenciaYaExisteException ex) {
                    Logger.getLogger(MenuClickDerExpirada.class.getName()).log(Level.SEVERE, null, ex);
                } catch (LicenciaDirectorioException ex) {
                    Logger.getLogger(MenuClickDerExpirada.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(MenuClickDerExpirada.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        item.setEnabled(false);
        this.add(item);

        item = new JMenuItem("Renovar licencia");
        item.addActionListener(new RenovarLicenciaActionListener(this.getLic(), ventanaExpirado, ventanaCriterio));
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
        private ListadoLicenciasExpirado ventanaExpirado;
        private ListadoPorCriterios ventanaCriterio;

        public Licencia getLic() {
            return lic;
        }

        public void setLic(Licencia lic) {
            this.lic = lic;
        }

        private RenovarLicenciaActionListener(Licencia lic, ListadoLicenciasExpirado ventanaExpirado, ListadoPorCriterios ventanaCriterio) {
            this.setLic(lic);
            this.ventanaCriterio = ventanaCriterio;
            this.ventanaExpirado = ventanaExpirado;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            RenovarLicencia ventanaRenovar = new RenovarLicencia(this.getLic(), ventanaExpirado, ventanaCriterio);
            ventanaRenovar.setVisible(true);
            if (ventanaCriterio != null) {
                ventanaCriterio.setVisible(false);
            } else {
                ventanaExpirado.setVisible(false);
            }
        }

    }

}
