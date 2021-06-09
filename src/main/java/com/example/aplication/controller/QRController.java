package com.example.aplication.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;


import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import com.example.aplication.entity.CodeGenerator;
import com.example.aplication.entity.Permiso;
import com.example.aplication.entity.PermisoDiario;
import com.example.aplication.entity.PermisoPeriodo;
import com.example.aplication.service.IPermisoService;
import com.example.aplication.entity.Lugar;


@RequestMapping("/views/barcode")
@RestController
public class QRController {

    @Autowired
    private IPermisoService permisoService;

    // PAGINA PARA SOLICITAR QR
    @GetMapping("/")
    public ModelAndView crear() {
        ModelAndView model = new ModelAndView();
        model.setViewName("views/qr/code_page");
        model.addObject("tipo", new String());
        model.addObject("permiso_id", new String());
        return model;
    }

    //ejemplo:
    //qr?permiso=permisoDiario&dni=12345678&fecha=2020-02-02&lugares=MonteGrande&lugares=Calamuchita&motivo=porque%20si&vacaciones=null&rodado=null
    //LO QUE SE VE EN EL QR
    @GetMapping("/qr")
    public ModelAndView crearBarcode() {

        return new ModelAndView("views/qr/webpage.html");
    }


    // supongo que deberiamos cambiar el String barcode
    @PostMapping(value = "/zxing/qrcode", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> zxingQRCode(@ModelAttribute("permiso_id") String permiso_id, @ModelAttribute("tipo") String tipo , RedirectAttributes attributes) throws Exception{

        Long permiso_id_long = Long.parseLong(permiso_id); 
        Permiso permiso = null;
        try {
            permiso = permisoService.buscarPorDniTipo(permiso_id_long, "Permiso" + tipo);
            
        } catch (Exception e) {
            attributes.addFlashAttribute("error", "No se encontraron permisos");
            throw new RuntimeException("No se encontraron permisos");
            
        }

        String web = generateWebString(permiso);

        return successResponse(CodeGenerator.generateQRCode("http://localhost:8080/views/barcode/qr"+ web));
    }

    private String generateWebString(Permiso permiso){

        PermisoPeriodo periodo = new PermisoPeriodo();
        PermisoDiario diario = new PermisoDiario();
        List<Lugar> stringsList = new ArrayList<>(permiso.getDesdeHasta());
        String web = new String();
        if(permiso instanceof PermisoDiario){
            diario = (PermisoDiario) permiso;
            web= "?permiso=permisoDiario" + "&dni=" + permiso.getId() + "&fecha=" + diario.getFecha() + "&lugares=" + stringsList.get(0).getLugar() + "&lugares=" + stringsList.get(1).getLugar() + "&motivo=" +diario.getMotivo();  
             //qr?permiso=permisoDiario&dni=12345678&fecha=2020-02-02&desde=MonteGrande&hasta=Calamuchita&motivo=porque%20si&vacaciones=null&rodado=null
        }else{

            periodo = (PermisoPeriodo)permiso;
            System.out.println(periodo.getCantDias());
            web= "?permiso=permisoPeriodo" + "&dni=" + permiso.getId() + "&fecha=" + permiso.getFecha() + "&lugares=" + stringsList.get(0).getLugar() + "&lugares=" + stringsList.get(1).getLugar() + "&vacaciones=" + periodo.isVacaciones() + "&rodado=" + periodo.getRodado().getDominio() + "&validez=" + permiso.getFecha().plusDays(periodo.getCantDias());  

        }
        return web;

    }

    private ResponseEntity<BufferedImage> successResponse(BufferedImage image) {
        return new ResponseEntity<>(image, HttpStatus.OK);
    }

    @Bean
    public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter() {
        return new BufferedImageHttpMessageConverter();
    }
    
}
