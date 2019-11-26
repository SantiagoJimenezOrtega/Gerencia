/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usta.edu.wsgerencia.service;

import co.usta.edu.wsgerencia.ejb.*;
import co.usta.edu.wsgerencia.entity.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceContext;

/**
 *
 * @author JUANSE
 */
@WebService(serviceName = "ServicioPersona")
public class PersonaService {

    @Resource
    WebServiceContext webServiceContext;
    @EJB
    private PersonaFacade _ejbPersona;

    @WebMethod
    public String createPersona(@WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "cedula") Integer cedula, @WebParam(name = "correo") String email, @WebParam(name = "Tipo") String tipo) {
        String resultado;
        Persona objPersona = new Persona();
        objPersona.setNombre(nombre);
        objPersona.setApellido(apellido);
        objPersona.setCedula(cedula);
        objPersona.setCorreo(email);
        objPersona.setTipo(tipo);

        this._ejbPersona.grabar(objPersona);

        if (objPersona.getNombre()!= null) {
            return resultado="El estudiante fue creado con exito";
        }

        return resultado="El estudiante no pudo crearse, es posible que algun dato este erroneo";
    }

    @WebMethod
    public boolean listarPersona() {
        List<Persona> personas = new ArrayList<>();
        personas = this._ejbPersona.listar();
        if (this._ejbPersona.listar().size() > 0) {
            return true;
        }
        return false;

    }
    
    @WebMethod
    public boolean editarPersona(@WebParam(name = "codigo") Integer codigo,@WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "cedula") Integer cedula, @WebParam(name = "correo") String email, @WebParam(name = "Tipo") String tipo){
        Persona objPersona=_ejbPersona.buscar(codigo);
        objPersona.setNombre(nombre);
        objPersona.setApellido(apellido);
        objPersona.setCedula(cedula);
        objPersona.setCorreo(email);
        objPersona.setTipo(tipo);
        
        if (objPersona!=null) {
            _ejbPersona.actulizar(objPersona);
            return true;
        }
       return false;
        
    }
    @WebMethod
    public String borrarPersona (@WebParam(name = "codigo")int codigo){
        String resultado;
        Persona objPersona=_ejbPersona.buscar(codigo);
        if (objPersona!=null) {
            _ejbPersona.borrar(objPersona);
            return resultado="El estudiante fue borrado con exito";
        }
        return resultado="El proceso de borrado no pudo completarse";
        
    }
}
