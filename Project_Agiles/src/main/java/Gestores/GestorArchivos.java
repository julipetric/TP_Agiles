/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Exceptions.BusquedaDirectorioException;
import Exceptions.BusquedaYaExisteException;
import Exceptions.ComprobanteDirectorioException;
import Exceptions.ComprobanteYaExisteException;
import Exceptions.LicenciaDirectorioException;
import Exceptions.LicenciaYaExisteException;
import Modelo.Licencia;
import com.itextpdf.barcodes.Barcode39;
import com.itextpdf.io.image.ImageDataFactory;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.filechooser.FileSystemView;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.property.VerticalAlignment;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

    public static void imprimirBusqueda(ArrayList<Licencia> licencias) throws FileNotFoundException, BusquedaYaExisteException, BusquedaDirectorioException {
        File escritorioDelUsuario = FileSystemView.getFileSystemView().getHomeDirectory();
        
         //Crea el directorio de busquedas en el escritorio
        File directorioDeBusquedas = new File(escritorioDelUsuario.getAbsolutePath()+"/Busquedas");
        boolean sePudoCrear = false ;
        if (!directorioDeBusquedas.exists()) { //Si ya existe no se hace nada...
            sePudoCrear = directorioDeBusquedas.mkdirs();
        }
        
        if (sePudoCrear || (!sePudoCrear && directorioDeBusquedas.exists())) { //Si se pudo crear el directorio de busquedas (o ya existe)...
            
            //Obtiene el momento de la busqueda
            DateFormat formato = new SimpleDateFormat("yyyy-MM-dd (hh.mm.ss a)");
            Date hoy = new Date();
        
            //Crea el nuevo archivo de busqueda
            String dest = escritorioDelUsuario.getAbsolutePath()+"\\Busquedas\\Busqueda "+formato.format(hoy)+".pdf";
            File file = new File(dest);
            System.out.println("Archivo = " + file.getAbsolutePath());
            
            if (!file.exists()) { //Si no hubo errores al crear el archivo...
                
                //Agregamos los datos y el formato al pdf
                PdfWriter writer = new PdfWriter(dest); //Explota con FileNotFoundException si "dest" es invalido
                PdfDocument pdf = new PdfDocument(writer);
                Document document = new Document(pdf);
                
                Paragraph text1 = new Paragraph("Registro de busqueda de licencias");
                text1.setFontSize(24);
                text1.setTextAlignment(TextAlignment.CENTER);
                document.add(text1);
                
                Table table = new Table(UnitValue.createPercentArray(new float[]{2,2,2,7,1,1,1}));
                table.setWidth(UnitValue.createPercentValue(100));
                
                table.setHorizontalAlignment(HorizontalAlignment.CENTER);
                
                Cell cell;
                
                cell = new Cell().add(new Paragraph("Apellido").setFontSize(10).setBold()).setBackgroundColor(Color.ORANGE, 0.5f).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(cell);
                cell = new Cell().add(new Paragraph("Nombre").setFontSize(10).setBold()).setBackgroundColor(Color.ORANGE, 0.5f).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(cell);
                cell = new Cell().add(new Paragraph("DNI").setFontSize(10).setBold()).setBackgroundColor(Color.ORANGE, 0.5f).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(cell);
                cell = new Cell().add(new Paragraph("Domicilio").setFontSize(10).setBold()).setBackgroundColor(Color.ORANGE, 0.5f).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(cell);
                cell = new Cell().add(new Paragraph("Clase").setFontSize(10).setBold()).setBackgroundColor(Color.ORANGE, 0.5f).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(cell);
                cell = new Cell().add(new Paragraph("Vencimiento").setFontSize(10).setBold()).setBackgroundColor(Color.ORANGE, 0.5f).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(cell);
                cell = new Cell().add(new Paragraph("Grupo y factor").setFontSize(10).setBold()).setBackgroundColor(Color.ORANGE, 0.5f).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(cell);
                
                DateFormat formatoVencimiento = new SimpleDateFormat("yyyy-MM-dd");
                
                
                for (Licencia l : licencias) {
                    
                    cell = new Cell().add(new Paragraph(l.getTitular().getApellido()).setFontSize(9));
                    table.addCell(cell);
                    cell = new Cell().add(new Paragraph(l.getTitular().getNombre()).setFontSize(9));
                    table.addCell(cell);
                    cell = new Cell().add(new Paragraph(Integer.toString(l.getTitular().getDni())).setFontSize(9));
                    table.addCell(cell);
                    cell = new Cell().add(new Paragraph(l.getTitular().getDomicilio().toString()).setFontSize(9));
                    table.addCell(cell);
                    cell = new Cell().add(new Paragraph(l.getClase()).setFontSize(9));
                    table.addCell(cell);
                    cell = new Cell().add(new Paragraph(formatoVencimiento.format(l.getFechaExpiracion())).setFontSize(9));
                    table.addCell(cell);
                    cell = new Cell().add(new Paragraph(l.getTitular().getGrupoSanguineo()+" "+ (("Positivo".equals(l.getTitular().getFactorRh())) ? "+" : "-")   ).setFontSize(9));
                    table.addCell(cell);
                }
                
                document.add(table);
                
                document.close();
            } else {
                throw new BusquedaYaExisteException();
            }
        } else {
            throw new BusquedaDirectorioException();
        }
    }
    
    public static void imprimirLicencia(Licencia licencia) throws FileNotFoundException, LicenciaYaExisteException, LicenciaDirectorioException, MalformedURLException {
        File escritorioDelUsuario = FileSystemView.getFileSystemView().getHomeDirectory();
        
         //Crea el directorio de busquedas en el escritorio
        File directorioDeLicencias = new File(escritorioDelUsuario.getAbsolutePath()+"/Licencias");
        boolean sePudoCrear = false ;
        if (!directorioDeLicencias.exists()) { //Si ya existe no se hace nada...
            sePudoCrear = directorioDeLicencias.mkdirs();
        }
        
        if (sePudoCrear || (!sePudoCrear && directorioDeLicencias.exists())) { //Si se pudo crear el directorio de busquedas (o ya existe)...
            
            //Obtiene el momento de la busqueda
            DateFormat formato = new SimpleDateFormat("yyyy-MM-dd (hh.mm.ss a)");
            Date hoy = new Date();
        
            //Crea el nuevo archivo de busqueda
            String dest = escritorioDelUsuario.getAbsolutePath()+"\\Licencias\\Licencia "+formato.format(hoy)+" - id "+licencia.getUid() +".pdf";
            File file = new File(dest);
            System.out.println("Archivo = " + file.getAbsolutePath());
            
            if (!file.exists()) { //Si no hubo errores al crear el archivo...
                
                String carita = "./src/main/resources/icon/avatar.png";
                
                Image caritax = new Image(ImageDataFactory.create(carita));
                
                Table thebig = new Table(1);
                thebig.setWidth(UnitValue.createPercentValue(100));
                thebig.setVerticalAlignment(VerticalAlignment.MIDDLE);
                thebig.setHorizontalAlignment(HorizontalAlignment.CENTER);
                
                

                Table table = new Table(UnitValue.createPercentArray(new float[]{2.5f,1f,2f,1f,1.3f}));
                table.setWidth(UnitValue.createPercentValue(100));
                

                Cell cell = new Cell(4, 1).add(caritax.setAutoScale(true)).setVerticalAlignment(VerticalAlignment.MIDDLE).setBackgroundColor(Color.BLUE, 0.5f);
                table.addCell(cell);
                
                cell = new Cell().add(new Paragraph("DNI").setFontSize(13)
                        .setMarginBottom(0f)
                        .setMarginLeft(0f)
                        .setMarginRight(0f)
                        .setMarginTop(0f))
                        .setVerticalAlignment(VerticalAlignment.MIDDLE)
                        .setTextAlignment(TextAlignment.CENTER);
                table.addCell(cell);
                cell = new Cell().add(new Paragraph(Integer.toString(licencia.getTitular().getDni())).setFontSize(13)
                        .setMarginBottom(0f)
                        .setMarginLeft(0f)
                        .setMarginRight(0f)
                        .setMarginTop(0f))
                        .setVerticalAlignment(VerticalAlignment.MIDDLE)
                        .setTextAlignment(TextAlignment.CENTER);
                table.addCell(cell);
                
                cell = new Cell().add(new Paragraph("Fecha de Nacimiento").setFontSize(13)
                        .setMarginBottom(0f)
                        .setMarginLeft(0f)
                        .setMarginRight(0f)
                        .setMarginTop(0f))
                        .setVerticalAlignment(VerticalAlignment.MIDDLE)
                        .setTextAlignment(TextAlignment.CENTER);
                table.addCell(cell);
                DateFormat formato1 = new SimpleDateFormat("dd-MM-yyyy");
                cell = new Cell().add(new Paragraph(formato1.format(licencia.getTitular().getFechaNacimiento())).setFontSize(13)
                        .setMarginBottom(0f)
                        .setMarginLeft(0f)
                        .setMarginRight(0f)
                        .setMarginTop(0f))
                        .setVerticalAlignment(VerticalAlignment.MIDDLE)
                        .setTextAlignment(TextAlignment.CENTER);
                table.addCell(cell);
                
                cell = new Cell().add(new Paragraph("Apellido").setFontSize(13)
                        .setMarginBottom(0f)
                        .setMarginLeft(0f)
                        .setMarginRight(0f)
                        .setMarginTop(0f))
                        .setVerticalAlignment(VerticalAlignment.MIDDLE)
                        .setTextAlignment(TextAlignment.CENTER);
                table.addCell(cell);
                cell = new Cell().add(new Paragraph(licencia.getTitular().getApellido()).setFontSize(tamanioLetra(licencia.getTitular().getApellido()))
                        .setMarginBottom(0f)
                        .setMarginLeft(0f)
                        .setMarginRight(0f)
                        .setMarginTop(0f))
                        .setVerticalAlignment(VerticalAlignment.MIDDLE)
                        .setTextAlignment(TextAlignment.CENTER);
                table.addCell(cell);
                
                cell = new Cell().add(new Paragraph("Fecha de Trámite").setFontSize(13)
                        .setMarginBottom(0f)
                        .setMarginLeft(0f)
                        .setMarginRight(0f)
                        .setMarginTop(0f))
                        .setVerticalAlignment(VerticalAlignment.MIDDLE)
                        .setTextAlignment(TextAlignment.CENTER);
                table.addCell(cell);
                cell = new Cell().add(new Paragraph(formato1.format(licencia.getFechaTramite())).setFontSize(13)
                        .setMarginBottom(0f)
                        .setMarginLeft(0f)
                        .setMarginRight(0f)
                        .setMarginTop(0f))
                        .setVerticalAlignment(VerticalAlignment.MIDDLE)
                        .setTextAlignment(TextAlignment.CENTER);
                table.addCell(cell);
                
                cell = new Cell().add(new Paragraph("Nombre").setFontSize(13)
                        .setMarginBottom(0f)
                        .setMarginLeft(0f)
                        .setMarginRight(0f)
                        .setMarginTop(0f))
                        .setVerticalAlignment(VerticalAlignment.MIDDLE)
                        .setTextAlignment(TextAlignment.CENTER);
                table.addCell(cell);
                cell = new Cell().add(new Paragraph(licencia.getTitular().getNombre()).setFontSize(tamanioLetra(licencia.getTitular().getNombre()))
                        .setMarginBottom(0f)
                        .setMarginLeft(0f)
                        .setMarginRight(0f)
                        .setMarginTop(0f))
                        .setVerticalAlignment(VerticalAlignment.MIDDLE)
                        .setTextAlignment(TextAlignment.CENTER);
                table.addCell(cell);
                
                cell = new Cell().add(new Paragraph("Fecha de Vencimiento").setFontSize(13)
                        .setMarginBottom(0f)
                        .setMarginLeft(0f)
                        .setMarginRight(0f)
                        .setMarginTop(0f))
                        .setVerticalAlignment(VerticalAlignment.MIDDLE)
                        .setTextAlignment(TextAlignment.CENTER);
                table.addCell(cell);
                cell = new Cell().add(new Paragraph(formato1.format(licencia.getFechaExpiracion())).setFontSize(13)
                        .setMarginBottom(0f)
                        .setMarginLeft(0f)
                        .setMarginRight(0f)
                        .setMarginTop(0f))
                        .setVerticalAlignment(VerticalAlignment.MIDDLE)
                        .setTextAlignment(TextAlignment.CENTER);
                table.addCell(cell);
                
                cell = new Cell().add(new Paragraph("Domicilio").setFontSize(13)
                        .setMarginBottom(0f)
                        .setMarginLeft(0f)
                        .setMarginRight(0f)
                        .setMarginTop(0f))
                        .setVerticalAlignment(VerticalAlignment.MIDDLE)
                        .setTextAlignment(TextAlignment.CENTER);
                table.addCell(cell);
                cell = new Cell().add(new Paragraph(licencia.getTitular().getDomicilio().getCalle() + "\n"  
                                                    + "Nro: " + licencia.getTitular().getDomicilio().getNumero() + "\n" 
                                                    +"P: "+licencia.getTitular().getDomicilio().getPiso() + " D: " + licencia.getTitular().getDomicilio().getDepartamento()+ "\n" 
                                                    + licencia.getTitular().getDomicilio().getCiudad())
                        .setFontSize(10)
                        .setFixedLeading(10*1.15f)
                        .setMarginBottom(0f)
                        .setMarginLeft(0f)
                        .setMarginRight(0f)
                        .setMarginTop(0f))
                        .setVerticalAlignment(VerticalAlignment.MIDDLE)
                        .setTextAlignment(TextAlignment.CENTER);
                table.addCell(cell);
                
                cell = new Cell().add(new Paragraph("Clase").setFontSize(13)
                        .setMarginBottom(0f)
                        .setMarginLeft(0f)
                        .setMarginRight(0f)
                        .setMarginTop(0f))
                        .setVerticalAlignment(VerticalAlignment.MIDDLE)
                        .setTextAlignment(TextAlignment.CENTER);
                table.addCell(cell);
                cell = new Cell().add(new Paragraph(licencia.getClase()).setFontSize(13)
                        .setMarginBottom(0f)
                        .setMarginLeft(0f)
                        .setMarginRight(0f)
                        .setMarginTop(0f))
                        .setVerticalAlignment(VerticalAlignment.MIDDLE)
                        .setTextAlignment(TextAlignment.CENTER);
                        
                table.addCell(cell);
                
                thebig.addCell(table.setVerticalAlignment(VerticalAlignment.MIDDLE).setHorizontalAlignment(HorizontalAlignment.CENTER)).setBackgroundColor(Color.LIGHT_GRAY);
                
                
                PdfWriter writer = new PdfWriter(dest); //Explota con FileNotFoundException si "dest" es invalido
                PdfDocument pdf = new PdfDocument(writer);
                Document document = new Document(pdf, new PageSize(596,193));
                document.setLeftMargin(1f);
                document.setRightMargin(1f);
                document.setHorizontalAlignment(HorizontalAlignment.CENTER);
                document.setBottomMargin(1f);
                document.setTopMargin(1f);
                document.add(thebig);
                
                document.close();
            } else {
                throw new LicenciaYaExisteException();
            }
        } else {
            throw new LicenciaDirectorioException();
        }
    }
    private static float tamanioLetra(String campo){
        float tamanio= 0f;
        
        if(campo.length() > 20 && campo.length() <=23){
            tamanio = (float) (100 / (campo.length()*0.4));
        }if(campo.length() > 23){
            tamanio = (float) (100 / (campo.length()*0.385));
        }else{
            tamanio = 13f;
        }
        
        return tamanio;
    }
}
