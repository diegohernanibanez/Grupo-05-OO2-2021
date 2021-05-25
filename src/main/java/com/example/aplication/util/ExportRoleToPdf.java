package com.example.aplication.util;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.aplication.entity.Role;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

@Component("/views/roles/listar")
public class ExportRoleToPdf extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        @SuppressWarnings("unchecked")
        List<Role> listadoRoles = (List<Role>) model.get("role");
        // Tabla titulos de los atributos de la tabla - cambiar 6 por la cantidad de
        // columnas correspondientes
        PdfPTable tablaRole = new PdfPTable(1);

        // Fuentes y tamaños para las secciones
        Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, Color.BLUE);
        Font fuenteCeldas = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Color.black);
        Font fuenteContenidoData = FontFactory.getFont(FontFactory.COURIER, 12, Color.black);

        //  document viene por parametro

        document.setPageSize(PageSize.A4);
        document.setMargins(-10, -10, 30, 20);
        document.open();

        //  objeto null que va a servir para crear el resto de celdas del documento
        PdfPCell celda = null;

        //  Tabla para el titulo
        PdfPTable tablaTitulo = new PdfPTable(1);

        //  ( new Phrase ("texto a mostrar",fuente)) en caso de fuente estar vacio usar una fuente por defecto
        celda = new PdfPCell(new Phrase("Listado de Roles", fuenteTitulo));

        // // La celda no tendra bordes
        celda.setBackgroundColor(new Color(40, 190, 138));
        celda.setBorder(0);
        celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setPadding(20);
        tablaTitulo.addCell(celda);

        // // espacio despues de la celda
        tablaTitulo.setSpacingAfter(30);

        // // en los float se puede poner ajustar el ancho de cada columnna, agregar o
        // // quitar floats segun la cantidad de columnas

        tablaRole.setWidths(new float[] { 2 });

        // Repetir este bloque para cada columna del pdf
        celda = new PdfPCell(new Phrase("Roles", fuenteCeldas));
        celda.setBackgroundColor(new Color(40, 190, 138));
        celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setPadding(3);
        tablaRole.addCell(celda);

        listadoRoles.forEach(role -> {

            PdfPCell celda1 = null;

            celda1 = new PdfPCell(new Phrase(role.getTipo(), fuenteContenidoData));
            celda1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            celda1.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
            celda1.setPadding(5);
            tablaRole.addCell(celda1);

        });

        document.add(tablaTitulo);
        document.add(tablaRole);

    }

}
