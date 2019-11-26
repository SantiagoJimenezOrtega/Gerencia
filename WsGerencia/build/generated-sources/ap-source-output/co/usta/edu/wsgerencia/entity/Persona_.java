package co.usta.edu.wsgerencia.entity;

import co.usta.edu.wsgerencia.entity.Prestamo;
import co.usta.edu.wsgerencia.entity.Sancion;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-25T20:09:03")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, Integer> codigo;
    public static volatile SingularAttribute<Persona, String> tipo;
    public static volatile CollectionAttribute<Persona, Sancion> sancionCollection;
    public static volatile CollectionAttribute<Persona, Prestamo> prestamoCollection;
    public static volatile SingularAttribute<Persona, Integer> cedula;
    public static volatile SingularAttribute<Persona, Sancion> sancionCodigo;
    public static volatile SingularAttribute<Persona, String> apellido;
    public static volatile SingularAttribute<Persona, String> correo;
    public static volatile SingularAttribute<Persona, String> nombre;

}