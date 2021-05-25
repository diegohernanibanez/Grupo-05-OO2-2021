// package com.example.aplication.util;

// import java.awt.Color;
// import java.util.List;
// import java.util.Map;

// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import com.example.aplication.entity.User;
// import com.lowagie.text.Document;
// import com.lowagie.text.Font;
// import com.lowagie.text.FontFactory;
// import com.lowagie.text.PageSize;
// import com.lowagie.text.Phrase;
// import com.lowagie.text.pdf.PdfPCell;
// import com.lowagie.text.pdf.PdfPTable;
// import com.lowagie.text.pdf.PdfWriter;

// import org.springframework.stereotype.Component;
// import org.springframework.web.servlet.view.document.AbstractPdfView;

// //Cambiar la ruta de component por la ruta donde este la lista de users
// @Component("/views/users/listar")
// public class ListarUsersPdf extends AbstractPdfView {

//     @Override
//     protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
//             HttpServletRequest request, HttpServletResponse response) throws Exception {

//         // Cargar todos los users dentro de una lista.
//         // el objeto del get correspondeal que venga del controller por model
//         @SuppressWarnings("unchecked")
//         List<User> listadoUsers = (List<User>) model.get("users");

//         // Fuentes y tamaños para las secciones
//         Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD,20,Color.BLUE);
//         Font fuenteCeldas = FontFactory.getFont(FontFactory.TIMES_ROMAN,20,Color.black);


//         // document viene por parametro
//         document.setPageSize(PageSize.A4.rotate());
//         document.setMargins(-20, -20, 30, 20);
//         document.open();

//         // objeto null que va a servir para crear el resto de celdas del documento
//         PdfPCell celda = null;

//         // Tabla para el titulo
//         PdfPTable tablaTitulo = new PdfPTable(1);

//         // ( new Phrase ("texto a mostrar",fuente)) en caso de fuente estar vacio usar
//         // una fuente por defecto
//         celda = new PdfPCell(new Phrase("Listado de users",fuenteTitulo));

//         // La celda no tendra bordes
//         celda.setBackgroundColor(new Color(40,190,138));
//         celda.setBorder(0);
//         celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//         celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
//         celda.setPadding(20);
//         tablaTitulo.addCell(celda);
        
//         // espacio despues de la celda
//         tablaTitulo.setSpacingAfter(30);

//         // Tabla titulos de los atributos de la tabla - cambiar 6 por la cantidad de
//         // columnas correspondientes

//         PdfPTable tablaUsers = new PdfPTable(5);
//         // en los float se puede poner ajustar el ancho de cada columnna, agregar o
//         // quitar floats segun la cantidad de columnas
//         tablaUsers.setWidths(new float []{3f,3f,3f,3f,3f});

//         // Repetir este bloque para cada columna del pdf
//         celda = new PdfPCell(new Phrase("Apellido",fuenteCeldas));
//         celda.setBackgroundColor(new Color(40,190,138));
//         celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//         celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
//         celda.setPadding(10);
//         tablaUsers.addCell(celda);

//         celda = new PdfPCell(new Phrase("Nombre",fuenteCeldas));
//         celda.setBackgroundColor(new Color(40,190,138));
//         celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//         celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
//         celda.setPadding(10);
//         tablaUsers.addCell(celda);

//         celda = new PdfPCell(new Phrase("Email",fuenteCeldas));
//         celda.setBackgroundColor(new Color(40,190,138));
//         celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//         celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
//         celda.setPadding(10);
//         tablaUsers.addCell(celda);

//         celda = new PdfPCell(new Phrase("Telefono",fuenteCeldas));
//         celda.setBackgroundColor(new Color(40,190,138));
//         celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//         celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
//         celda.setPadding(10);
//         tablaUsers.addCell(celda);

//         celda = new PdfPCell(new Phrase("Ciudad",fuenteCeldas));
//         celda.setBackgroundColor(new Color(40,190,138));
//         celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//         celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
//         celda.setPadding(10);
//         tablaUsers.addCell(celda);



//         // Bucle For each,

//         celda = null;

//         listadoUsers.forEach(user -> {

//             PdfPCell celda1 = null;

//             // Repetir y cambiar los get segun la cantidad de columnas, en caso de que no
//             // sea un string agregar .toString despues del get

//             celda1 = new PdfPCell(new Phrase(user.getApellidos()));
//             celda1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//             celda1.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
//             celda1.setPadding(5);
//             tablaUsers.addCell(celda1);

//             celda1 = new PdfPCell(new Phrase(user.getNombres()));
//             celda1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//             celda1.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
//             celda1.setPadding(5);
//             tablaUsers.addCell(celda1);

//             celda1 = new PdfPCell(new Phrase(user.getEmail()));
//             celda1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//             celda1.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
//             celda1.setPadding(5);
//             tablaUsers.addCell(celda1);

//             celda1 = new PdfPCell(new Phrase(user.getTelefono()));
//             celda1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//             celda1.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
//             celda1.setPadding(5);
//             tablaUsers.addCell(celda1);

//             celda1 = new PdfPCell(new Phrase(user.getCiudad().getCiudad()));
//             celda1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//             celda1.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
//             celda1.setPadding(5);
//             tablaUsers.addCell(celda1);

//             //
//             // celda = new PdfPCell(new Phrase(client.getNombre));
//             // celda.setPadding(5);
//             // tablaUsers.addCell(celda);

//         });
//         // document viene por parametro
//         document.add(tablaTitulo);
//         document.add(tablaUsers);

//     }

// }
