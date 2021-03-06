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
public class ImplementoFacade extends AbstractGerencia<Implemento> {
    
        @PersistenceContext(unitName = "WsGerenciaPU")
        private EntityManager _em;
        
        public ImplementoFacade(){
            super(Implemento.class);
        }
        
        @Override
        protected EntityManager getAdmEntidad(){
            return this._em;
        }
}
