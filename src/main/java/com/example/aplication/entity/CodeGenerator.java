package com.example.aplication.entity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {

    public static BufferedImage generateQRCode(String urlText) throws Exception {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(urlText, BarcodeFormat.QR_CODE, 200, 200);

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    public static String generateWebString(Permiso permiso){

        PermisoPeriodo periodo = new PermisoPeriodo();
        PermisoDiario diario = new PermisoDiario();
        List<Lugar> stringsList = new ArrayList<>(permiso.getDesdeHasta());
        String web = new String();
        if(permiso instanceof PermisoDiario){
            diario = (PermisoDiario) permiso;
            web= "?permiso=permisoDiario" + "&dni=" + permiso.getPedido().getDni()+ "&fecha=" + diario.getFecha() + "&desde=" + stringsList.get(0).getLugar() + "&hasta=" + stringsList.get(1).getLugar() + "&motivo=" +diario.getMotivo();  
             //qr?permiso=permisoDiario&dni=12345678&fecha=2020-02-02&desde=MonteGrande&hasta=Calamuchita&motivo=porque%20si&vacaciones=null&rodado=null
        }else{

            periodo = (PermisoPeriodo)permiso;
            System.out.println(periodo.getCantDias());
            web= "?permiso=permisoPeriodo" + "&dni=" + permiso.getPedido().getDni()+ "&fecha=" + permiso.getFecha() + "&desde=" + stringsList.get(0).getLugar() + "&hasta=" + stringsList.get(1).getLugar() + "&vacaciones=" + periodo.isVacaciones() + "&rodado=" + periodo.getRodado().getDominio() + "&validez=" + permiso.getFecha().plusDays(periodo.getCantDias());  

        }
        return web;

    }
    
    
}
