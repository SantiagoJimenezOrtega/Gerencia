/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usta.edu.wsgerencia.ejb;

import co.usta.edu.wsgerencia.entity.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Chago
 */
@Stateless
public class PersonaFacade extends AbstractGerencia<Persona> {
    
        @PersistenceContext(unitName = "WsGerenciaPU")
        private EntityManager _em;
        
        public PersonaFacade(){
            super(Persona.class);
        }
        
        @Override
        protected EntityManager getAdmEntidad(){
            return this._em;
        }
}
