package co.usta.edu.wsgerencia.entity;

import co.usta.edu.wsgerencia.entity.Escenario;
import co.usta.edu.wsgerencia.entity.Implemento;
import co.usta.edu.wsgerencia.entity.Persona;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-25T20:09:03")
@StaticMetamodel(Prestamo.class)
public class Prestamo_ { 

    public static volatile SingularAttribute<Prestamo, Integer> codigo;
    public static volatile SingularAttribute<Prestamo, Boolean> estado;
    public static volatile SingularAttribute<Prestamo, Date> fechaDevolucion;
    public static volatile SingularAttribute<Prestamo, Date> fechaPrestamo;
    public static volatile SingularAttribute<Prestamo, Integer> implementoCodigo;
    public static volatile SingularAttribute<Prestamo, Escenario> escenarioCodigo;
    public static volatile SingularAttribute<Prestamo, Implemento> implemento;
    public static volatile SingularAttribute<Prestamo, Persona> personaCodigo;

}