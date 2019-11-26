/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usta.edu.wsgerencia.service;

import co.usta.edu.wsgerencia.ejb.EscenarioFacade;
import co.usta.edu.wsgerencia.ejb.LogeoFacade;
import co.usta.edu.wsgerencia.entity.*;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceContext;

/**
 *
 * @author Chago
 */
@WebService(serviceName = "LogeoService")
public class LogeoService {

    @Resource
    WebServiceContext webServiceContext;
    @EJB
    private LogeoFacade _ejbLogeo;

    @WebMethod(operationName = "crearLogeo")
    public String createLogeo(@WebParam(name = "nombre") Integer usuario, @WebParam(name = "estado") String contrasenia) {
        String resultado;
        Logeo objLogeo = new Logeo();
        objLogeo.setUsuario(usuario);
        objLogeo.setContraseña(contrasenia);

        this._ejbLogeo.grabar(objLogeo);

        if (objLogeo.getUsuario() != null) {
            return resultado = "El usuario fue creado con exito";
        }

        return resultado = "El usuario no pudo crearse, es posible que algun dato este erroneo";
    }

    @WebMethod(operationName = "listarLogeo")
    public boolean listarLogeo() {
        List<Logeo> personas = new ArrayList<>();
        personas = this._ejbLogeo.listar();
        if (this._ejbLogeo.listar().size() > 0) {
            return true;
        }
        return false;

    }

    @WebMethod(operationName = "editarLogeo")
    public boolean editarLogeo(@WebParam(name = "nombre") Integer usuario, @WebParam(name = "estado") String contrasenia) {
        Logeo objLogeo = _ejbLogeo.buscar(usuario);

        objLogeo.setUsuario(_ejbLogeo.buscar(usuario).getUsuario());
        objLogeo.setContraseña(contrasenia);

        if (objLogeo != null) {
            _ejbLogeo.actulizar(objLogeo);
            return true;
        }
        return false;

    }

    @WebMethod(operationName = "borrarLogeo")
    public String borrarLogeo(@WebParam(name = "usuario") Integer usuario) {
        String resultado;
        Logeo objLogeo = _ejbLogeo.buscar(usuario);
        if (objLogeo != null) {
            _ejbLogeo.borrar(objLogeo);
            return resultado = "El implemento fue borrado con exito";
        }
        return resultado = "El implemento de borrado no pudo completarse";

    }

}
