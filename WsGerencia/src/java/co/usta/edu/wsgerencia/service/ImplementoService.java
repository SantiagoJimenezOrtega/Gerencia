/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usta.edu.wsgerencia.service;

import co.usta.edu.wsgerencia.ejb.*;
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
@WebService(serviceName = "ImplementoService")
public class ImplementoService {

    @Resource
    WebServiceContext webServiceContext;
    @EJB
    private ImplementoFacade _ejbImplemento;

    @WebMethod(operationName = "crearImplemento")
    public String createImplemento(@WebParam(name = "nombre") String nombre, @WebParam(name = "estado") boolean estado, @WebParam(name = "descripcion") String descripcion) {
        String resultado;
        Implemento objImplemento = new Implemento();
        objImplemento.setNombre(nombre);
        objImplemento.setEstado(estado);
        objImplemento.setDescripcion(descripcion);
        

        this._ejbImplemento.grabar(objImplemento);

        if (objImplemento.getNombre()!= null) {
            return resultado = "El implemento fue creado con exito";
        }

        return resultado = "El implemento no pudo crearse, es posible que algun dato este erroneo";
    }

    @WebMethod(operationName = "listarImplemento")
    public boolean listarImplemento() {
        List<Implemento> personas = new ArrayList<>();
        personas = this._ejbImplemento.listar();
        if (this._ejbImplemento.listar().size() > 0) {
            return true;
        }
        return false;

    }

    @WebMethod(operationName = "editarImplemento")
    public boolean editarImplemento(@WebParam(name = "codigo") Integer codigo,@WebParam(name = "nombre") String nombre, @WebParam(name = "estado") boolean estado, @WebParam(name = "descripcion") String descripcion) {
        Implemento objImplemento = _ejbImplemento.buscar(codigo);
        
        objImplemento.setNombre(nombre);
        objImplemento.setEstado(estado);
        objImplemento.setDescripcion(descripcion);

        if (objImplemento != null) {
            _ejbImplemento.actulizar(objImplemento);
            return true;
        }
        return false;

    }

    @WebMethod(operationName = "borrarImplemento")
    public String borrarImplemento(@WebParam(name = "codigo") int codigo) {
        String resultado;
        Implemento objImplemento = _ejbImplemento.buscar(codigo);
        if (objImplemento != null) {
            _ejbImplemento.borrar(objImplemento);
            return resultado = "El implemento fue borrado con exito";
        }
        return resultado = "El implemento de borrado no pudo completarse";

    }

}
