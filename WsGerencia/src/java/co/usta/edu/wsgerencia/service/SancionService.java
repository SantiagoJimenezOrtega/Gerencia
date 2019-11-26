/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usta.edu.wsgerencia.service;

import co.usta.edu.wsgerencia.ejb.SancionFacade;
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
 * @author Chago
 */
@WebService(serviceName = "SancionService")
public class SancionService {

    @Resource
    WebServiceContext webServiceContext;
    @EJB
    private SancionFacade _ejbSancion;

    @WebMethod
    public String createSancion(@WebParam(name = "fechaSancion") String descripcion, @WebParam(name = "fechaEntrega") Integer valor, @WebParam(name = "apellido") String tipo,
            @WebParam(name = "codigoPersona") Persona codigoPersona) {
        String resultado;
        Sancion objSancion = new Sancion();
        objSancion.setCodigoPersona(codigoPersona);
        objSancion.setDescripcion(descripcion);
        objSancion.setTipo(tipo);
        objSancion.setValor(valor);
        this._ejbSancion.grabar(objSancion);

        if (objSancion.getCodigo() != null) {
            return resultado = "El Sancion fue creado con exito";
        }

        return resultado = "El Sancion no pudo crearse, es posible que algun dato este erroneo";
    }

    @WebMethod
    public boolean listarSancion() {
        List<Sancion> sancions = new ArrayList<>();
        sancions = this._ejbSancion.listar();
        if (this._ejbSancion.listar().size() > 0) {
            return true;
        }
        return false;

    }

    @WebMethod
    public boolean editarSancion(@WebParam(name = "codigo") Integer codigo, @WebParam(name = "fechaSancion") String descripcion, @WebParam(name = "fechaEntrega") Integer valor, @WebParam(name = "apellido") String tipo,
            @WebParam(name = "codigoPersona") Persona codigoPersona) {
        Sancion objSancion = _ejbSancion.buscar(codigo);
        
        objSancion.setCodigoPersona(codigoPersona);
        objSancion.setDescripcion(descripcion);
        objSancion.setTipo(tipo);
        objSancion.setValor(valor);

        if (objSancion != null) {
            _ejbSancion.actulizar(objSancion);
            return true;
        }
        return false;

    }

    @WebMethod
    public String borrarSancion(@WebParam(name = "codigo") int codigo) {
        String resultado;
        Sancion objSancion = _ejbSancion.buscar(codigo);
        if (objSancion != null) {
            _ejbSancion.borrar(objSancion);
            return resultado = "La sancion fue borrado con exito";
        }
        return resultado = "La sancion de borrado no pudo completarse";

    }
}
