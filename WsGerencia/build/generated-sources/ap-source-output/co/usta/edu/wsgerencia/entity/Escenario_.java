package co.usta.edu.wsgerencia.entity;

import co.usta.edu.wsgerencia.entity.Prestamo;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-25T20:09:03")
@StaticMetamodel(Escenario.class)
public class Escenario_ { 

    public static volatile SingularAttribute<Escenario, String> descripcion;
    public static volatile SingularAttribute<Escenario, String> deportePermitido;
    public static volatile SingularAttribute<Escenario, Integer> codigo;
    public static volatile SingularAttribute<Escenario, Boolean> estado;
    public static volatile CollectionAttribute<Escenario, Prestamo> prestamoCollection;
    public static volatile SingularAttribute<Escenario, String> nombre;

}