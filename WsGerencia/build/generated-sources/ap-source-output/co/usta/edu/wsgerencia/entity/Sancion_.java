package co.usta.edu.wsgerencia.entity;

import co.usta.edu.wsgerencia.entity.Persona;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-25T20:09:03")
@StaticMetamodel(Sancion.class)
public class Sancion_ { 

    public static volatile SingularAttribute<Sancion, String> descripcion;
    public static volatile SingularAttribute<Sancion, Integer> codigo;
    public static volatile SingularAttribute<Sancion, String> tipo;
    public static volatile CollectionAttribute<Sancion, Persona> personaCollection;
    public static volatile SingularAttribute<Sancion, BigInteger> valor;
    public static volatile SingularAttribute<Sancion, Persona> codigoPersona;

}