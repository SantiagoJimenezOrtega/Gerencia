/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usta.edu.wsgerencia.service;

import co.usta.edu.wsgerencia.ejb.PrestamoFacade;
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
@WebService(serviceName = "PrestamoService")
public class PrestamoService {

    @Resource
    WebServiceContext webServiceContext;
    @EJB
    private PrestamoFacade _ejbPrestamo;

    @WebMethod
    public String createPrestamo(@WebParam(name = "fechaPrestamo") Date fechaPrestamo,@WebParam(name = "fechaEntrega") Date fechaEntrega, @WebParam(name = "apellido") Escenario escenarioCodigo,
            @WebParam(name = "codigoPersona") Persona codigoPersona, @WebParam(name = "cedula") Integer codigoImplemento) {
        String resultado;
        Prestamo objPrestamo = new Prestamo();
        objPrestamo.setFechaPrestamo(fechaPrestamo);
        objPrestamo.setFechaDevolucion(fechaEntrega);
        objPrestamo.setPersonaCodigo(codigoPersona);
        objPrestamo.setEscenarioCodigo(escenarioCodigo);
        objPrestamo.setImplementoCodigo(codigoImplemento);
        this._ejbPrestamo.grabar(objPrestamo);

        if (objPrestamo.getCodigo() != null) {
            return resultado = "El Prestamo fue creado con exito";
        }

        return resultado = "El Prestamo no pudo crearse, es posible que algun dato este erroneo";
    }

    @WebMethod
    public boolean listarPrestamo() {
        List<Prestamo> prestamos = new ArrayList<>();
        prestamos = this._ejbPrestamo.listar();
        if (this._ejbPrestamo.listar().size() > 0) {
            return true;
        }
        return false;

    }

    @WebMethod
    public boolean editarPrestamo(@WebParam(name = "codigo") int codigo, @WebParam(name = "fechaPrestamo") Date fechaPrestamo,@WebParam(name = "fechaEntrega") Date fechaEntrega, @WebParam(name = "apellido") Escenario escenarioCodigo,
            @WebParam(name = "codigoPersona") Persona codigoPersona, @WebParam(name = "cedula") Integer codigoImplemento) {
        Prestamo objPrestamo = _ejbPrestamo.buscar(codigo);
       objPrestamo.setFechaPrestamo(fechaPrestamo);
        objPrestamo.setFechaDevolucion(fechaEntrega);
        objPrestamo.setPersonaCodigo(codigoPersona);
        objPrestamo.setEscenarioCodigo(escenarioCodigo);
        objPrestamo.setImplementoCodigo(codigoImplemento);

        if (objPrestamo != null) {
            _ejbPrestamo.actulizar(objPrestamo);
            return true;
        }
        return false;

    }

    @WebMethod
    public String borrarPrestamo(@WebParam(name = "codigo") int codigo) {
        String resultado;
        Prestamo objPrestamo = _ejbPrestamo.buscar(codigo);
        if (objPrestamo != null) {
            _ejbPrestamo.borrar(objPrestamo);
            return resultado = "El prestamo fue borrado con exito";
        }
        return resultado = "El prestamo de borrado no pudo completarse";

    }
}
