/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Exceptions.ComprobanteDirectorioException;
import Exceptions.ComprobanteYaExisteException;
import Modelo.Licencia;
import com.itextpdf.barcodes.Barcode128;
import com.itextpdf.barcodes.Barcode39;

import com.itextpdf.io.IOException;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.filechooser.FileSystemView;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.barcodes.BarcodeEAN;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;




/**
 *
 * @author matij
 */
public class GestorArchivos {
    public static void imprimir(Licencia licencia) throws FileNotFoundException, ComprobanteYaExisteException, ComprobanteDirectorioException {
        
        File escritorioDelUsuario = FileSystemView.getFileSystemView().getHomeDirectory();
        
         //Crea el directorio de comprobantes en el escritorio
        File directorioDeComprobantes = new File(escritorioDelUsuario.getAbsolutePath()+"/Comprobantes");
        boolean sePudoCrear = false ;
        if (!directorioDeComprobantes.exists()) { //Si ya existe no se hace nada...
            sePudoCrear = directorioDeComprobantes.mkdirs();
        }
        
        if (sePudoCrear || (!sePudoCrear && directorioDeComprobantes.exists())) { //Si se pudo crear el directorio de comprobantes (o ya existe)...
        
            //Crea el nuevo comprobante
            String dest = escritorioDelUsuario.getAbsolutePath()+"\\Comprobantes\\Comprobante "+licencia.getUid()+".pdf";
            File file = new File(dest);
            System.out.println("Archivo = " + file.getAbsolutePath());
            
            if (!file.exists()) { //Si no hubo errores al crear el archivo...
                
                
                //Agregamos los datos y el formato al pdf
                PdfWriter writer = new PdfWriter(dest); //Explota con FileNotFoundException si "dest" es invalido
                PdfDocument pdf = new PdfDocument(writer);
                Document document = new Document(pdf);
                
                
                Paragraph text1 = new Paragraph("Comprobante de Pago");
                text1.setFontSize(24);
                text1.setTextAlignment(TextAlignment.CENTER);
                document.add(text1);
                
                Table table = new Table(2);
                table.setWidthPercent(70);
                table.setHorizontalAlignment(HorizontalAlignment.CENTER);
                
                table.addCell("DNI");
                table.addCell(Integer.toString(licencia.getTitular().getDni()));
                table.addCell("Apellido y Nombre");
                table.addCell(licencia.getTitular().getApellido() + " " + licencia.getTitular().getNombre());
                table.addCell("Domicilio");
                table.addCell(licencia.getTitular().getDomicilio().toString());
                table.addCell("Tipo de Licencia");
                table.addCell("Clase: "+ licencia.getClase());
                table.addCell("Costo");
                table.addCell("$ " + Float.toString(licencia.getCosto()));
                
                document.add(table);
                
                Paragraph text2 = new Paragraph("Visite su sitio de cobranzas con el siguiente código de barras para abonar la Licencia");
                text2.setTextAlignment(TextAlignment.CENTER);
                
                document.add(text2);
                
                
                document.add(crearCodigoDeBarras(String.format("%08d", licencia.getUid()), document).setHorizontalAlignment(HorizontalAlignment.CENTER).setWidth(180));
                
                document.close();
            } else {
                throw new ComprobanteYaExisteException();
            }
        } else {
            throw new ComprobanteDirectorioException();
        }
    }
    
    
    private static Image crearCodigoDeBarras(String code, Document pdfDoc) {
        Barcode39 barcode = new Barcode39(pdfDoc.getPdfDocument());
        barcode.setCodeType(Barcode39.ALIGN_CENTER);
        barcode.setCode(code);
        return new Image(barcode.createFormXObject(pdfDoc.getPdfDocument()));
    }
    
}
