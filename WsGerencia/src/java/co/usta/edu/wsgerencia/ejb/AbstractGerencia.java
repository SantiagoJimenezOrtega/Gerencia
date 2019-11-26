/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usta.edu.wsgerencia.ejb;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public abstract class AbstractGerencia<T> {

    private final Class<T> entidad;

    protected abstract EntityManager getAdmEntidad();

    public AbstractGerencia(Class<T> entidad) {
        this.entidad = entidad;
    }

    public void grabar(T entidad) {
        getAdmEntidad().persist(entidad);
    }

    public List<T> listar(){
        CriteriaBuilder cd = getAdmEntidad().getCriteriaBuilder();
        CriteriaQuery<T> cq = cd.createQuery(entidad);
        cq.select(cq.from(entidad));
        List<T> allData =getAdmEntidad().createQuery(cq).getResultList();
        return allData;
    }  
    public void borrar(T entidad){
        getAdmEntidad().remove(getAdmEntidad().merge(entidad));
    }
    public void actulizar(T entidad){
        getAdmEntidad().merge(entidad);
    }
    public T buscar(Object id){
        return getAdmEntidad().find(entidad, id);
    }
}