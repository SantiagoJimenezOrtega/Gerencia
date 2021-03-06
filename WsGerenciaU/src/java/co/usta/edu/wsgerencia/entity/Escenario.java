/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usta.edu.wsgerencia.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Chago
 */
@Entity
@Table(name = "escenario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escenario.findAll", query = "SELECT e FROM Escenario e"),
    @NamedQuery(name = "Escenario.findByCodigo", query = "SELECT e FROM Escenario e WHERE e.codigo = :codigo"),
    @NamedQuery(name = "Escenario.findByNombre", query = "SELECT e FROM Escenario e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Escenario.findByDeportePermitido", query = "SELECT e FROM Escenario e WHERE e.deportePermitido = :deportePermitido"),
    @NamedQuery(name = "Escenario.findByDescripcion", query = "SELECT e FROM Escenario e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Escenario.findByEstado", query = "SELECT e FROM Escenario e WHERE e.estado = :estado")})
public class Escenario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "deportePermitido")
    private String deportePermitido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @OneToMany(mappedBy = "escenarioCodigo", fetch = FetchType.LAZY)
    private Collection<Prestamo> prestamoCollection;

    public Escenario() {
    }

    public Escenario(Integer codigo) {
        this.codigo = codigo;
    }

    public Escenario(Integer codigo, String nombre, String deportePermitido, String descripcion, boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.deportePermitido = deportePermitido;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDeportePermitido() {
        return deportePermitido;
    }

    public void setDeportePermitido(String deportePermitido) {
        this.deportePermitido = deportePermitido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
