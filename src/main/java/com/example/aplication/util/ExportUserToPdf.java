package com.example.aplication.util;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.aplication.entity.User;
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

@Component("/views/users/listar")
public class ExportUserToPdf extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        @SuppressWarnings("unchecked")
        List<User> listadoUsers = (List<User>) model.get("user");
        // Tabla titulos de los atributos de la tabla - cambiar 6 por la cantidad de
        // columnas correspondientes
        PdfPTable tablaUsers = new PdfPTable(7);

        // Fuentes y tamaños para las secciones
        Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, Color.BLUE);
        Font fuenteCeldas = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Color.black);
        Font fuenteContenidoData = FontFactory.getFont(FontFactory.COURIER, 12, Color.black);

        // document viene por parametro

        document.setPageSize(PageSize.A4.rotate());
        document.setMargins(-10, -10, 30, 20);
        document.open();

        // objeto null que va a servir para crear el resto de celdas del documento
        PdfPCell celda = null;

        // Tabla para el titulo
        PdfPTable tablaTitulo = new PdfPTable(1);

        // ( new Phrase ("texto a mostrar",fuente)) en caso de fuente estar vacio usar
        // una fuente por defecto
        celda = new PdfPCell(new Phrase("Listado de usuarios", fuenteTitulo));
        // celda = new PdfPCell(new Phrase("Listado de usuarios"));

        // La celda no tendra bordes
        celda.setBackgroundColor(new Color(40, 190, 138));
        celda.setBorder(0);
        celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setPadding(20);
        tablaTitulo.addCell(celda);

        // espacio despues de la celda
        tablaTitulo.setSpacingAfter(30);

        // en los float se puede poner ajustar el ancho de cada columnna, agregar o
        // quitar floats segun la cantidad de columnas
        // tablaUsers.setWidths(relativeWidths);
        tablaUsers.setWidths(new float[] { 2.9f, 2.5f, 3.4f, 3f, 3f, 8f  ,3f});

        // Repetir este bloque para cada columna del pdf
        celda = new PdfPCell(new Phrase("Apellido", fuenteCeldas));
        celda.setBackgroundColor(new Color(40, 190, 138));
        celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setPadding(5);
        tablaUsers.addCell(celda);

        celda = new PdfPCell(new Phrase("Nombre", fuenteCeldas));
        celda.setBackgroundColor(new Color(40, 190, 138));
        celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setPadding(5);
        tablaUsers.addCell(celda);

        celda = new PdfPCell(new Phrase("Username", fuenteCeldas));
        celda.setBackgroundColor(new Color(40, 190, 138));
        celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setPadding(5);
        tablaUsers.addCell(celda);

        celda = new PdfPCell(new Phrase("T.Doc", fuenteCeldas));
        celda.setBackgroundColor(new Color(40, 190, 138));
        celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setPadding(5);
        tablaUsers.addCell(celda);

        celda = new PdfPCell(new Phrase("DNI", fuenteCeldas));
        celda.setBackgroundColor(new Color(40, 190, 138));
        celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setPadding(5);
        tablaUsers.addCell(celda);

        celda = new PdfPCell(new Phrase("Email", fuenteCeldas));
        celda.setBackgroundColor(new Color(40, 190, 138));
        celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setPadding(5);
        tablaUsers.addCell(celda);

        celda = new PdfPCell(new Phrase("Rol", fuenteCeldas));
        celda.setBackgroundColor(new Color(40, 190, 138));
        celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setPadding(5);
        tablaUsers.addCell(celda);

        listadoUsers.forEach(user -> {

            PdfPCell celda1 = null;

            celda1 = new PdfPCell(new Phrase(user.getApellido(), fuenteContenidoData));
            celda1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            celda1.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
            celda1.setPadding(5);
            tablaUsers.addCell(celda1);

            celda1 = new PdfPCell(new Phrase(user.getNombre(), fuenteContenidoData));
            celda1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            celda1.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
            celda1.setPadding(5);
            tablaUsers.addCell(celda1);

            celda1 = new PdfPCell(new Phrase(user.getUsername(), fuenteContenidoData));
            celda1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            celda1.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
            celda1.setPadding(5);
            tablaUsers.addCell(celda1);

            celda1 = new PdfPCell(new Phrase(user.getTipoDocumento(), fuenteContenidoData));
            celda1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            celda1.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
            celda1.setPadding(5);
            tablaUsers.addCell(celda1);

            celda1 = new PdfPCell(new Phrase(user.getDni(), fuenteContenidoData));
            celda1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            celda1.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
            celda1.setPadding(5);
            tablaUsers.addCell(celda1);

            celda1 = new PdfPCell(new Phrase(user.getEmail(), fuenteContenidoData));
            celda1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            celda1.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
            celda1.setPadding(5);
            tablaUsers.addCell(celda1);

            celda1 = new PdfPCell(new Phrase(user.getRole().getTipo(), fuenteContenidoData));
            celda1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            celda1.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
            celda1.setPadding(5);
            tablaUsers.addCell(celda1);

        });

        document.add(tablaTitulo);
        document.add(tablaUsers);

    }

}
