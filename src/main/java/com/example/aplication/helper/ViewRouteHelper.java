package com.example.aplication.helper;

public class ViewRouteHelper {

    /**** Views ****/
	//HOME
    public final static String LISTAR = "/views/users/listar";
    public final static String CREAR = "/views/users/frmCrear";

	
	//USER
    public final static String LOGIN = "/user/login";

    //ROLE
    public final static String LISTAR_ROL = "/views/roles/listar";
    public final static String CREAR_ROL = "/views/roles/frmCrear";
	
	// /**** Redirects ****/
    public final static String HOME_ROOT = "/home";
    public final static String REDIRECT_CLIENTE = "redirect:/views/users/";
    public final static String REDIRECT_ROL = "redirect:/views/roles/";

	
    
}
