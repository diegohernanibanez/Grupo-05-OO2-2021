package com.example.aplication.helper;

public class ViewRouteHelper {

    /**** Views ****/
	//HOME
    public final static String LISTAR = "/views/users/listar";
    public final static String CREAR = "/views/users/frmCrear";

	
	//USER
    public final static String LOGIN = "/user/login";

    //ROLES
    public final static String LISTAR_ROLES = "/views/roles/listar";
    public final static String CREAR_ROLES = "/views/roles/frmCrear";

    //PERSONAS
    public final static String LISTAR_PERSONAS = "/views/personas/listar";
    public final static String CREAR_PERSONAS = "/views/personas/frmCrear";
    
    //PERMISOS
    public final static String SELECCION_PERMISO = "/views/permiso/EleccionPermiso";
    public final static String CREAR_PERMISO_PERIODO = "/views/permiso/FormularioPermisoP";
    public final static String CREAR_PERMISO_DIARIO = "/views/permiso/FormularioPermisoD";
	
    public final static String PERMISO_D1_MATI = "/views/permiso/FormularioPermisoDmatias";
    
	// /**** Redirects ****/
    public final static String HOME_ROOT = "/home";
    public final static String REDIRECT_CLIENTE = "redirect:/views/users/";
    public final static String REDIRECT_ROLE = "redirect:/views/roles/";
    public final static String REDIRECT_PERSONA = "redirect:/views/personas/";

	
    
}
