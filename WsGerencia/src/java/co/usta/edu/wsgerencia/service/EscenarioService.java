/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usta.edu.wsgerencia.service;

import co.usta.edu.wsgerencia.ejb.EscenarioFacade;
import co.usta.edu.wsgerencia.entity.*;
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
@WebService(serviceName = "EscenarioService")
public class EscenarioService {

    @Resource
    WebServiceContext webServiceContext;
    @EJB
    private EscenarioFacade _ejbEscenario;

    @WebMethod(operationName = "EditarEscenario")
    public String editarEscenario(@WebParam(name = "codigoEscenario") Integer codigo) {
        Escenario miEscenario = null;
        miEscenario=_ejbEscenario.buscar(codigo);
        
        return miEscenario.getNombre();}
        
    }

