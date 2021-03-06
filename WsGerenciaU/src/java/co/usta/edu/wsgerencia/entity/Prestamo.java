/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usta.edu.wsgerencia.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chago
 */
@Entity
@Table(name = "prestamo ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamo.findAll", query = "SELECT p FROM Prestamo p"),
    @NamedQuery(name = "Prestamo.findByCodigo", query = "SELECT p FROM Prestamo p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Prestamo.findByFechaPrestamo", query = "SELECT p FROM Prestamo p WHERE p.fechaPrestamo = :fechaPrestamo"),
    @NamedQuery(name = "Prestamo.findByFechaDevolucion", query = "SELECT p FROM Prestamo p WHERE p.fechaDevolucion = :fechaDevolucion"),
    @NamedQuery(name = "Prestamo.findByEstado", query = "SELECT p FROM Prestamo p WHERE p.estado = :estado"),
    @NamedQuery(name = "Prestamo.findByImplementoCodigo", query = "SELECT p FROM Prestamo p WHERE p.implementoCodigo = :implementoCodigo")})
public class Prestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaPrestamo")
    @Temporal(TemporalType.DATE)
    private Date fechaPrestamo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaDevolucion")
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Column(name = "implementoCodigo")
    private Integer implementoCodigo;
    @JoinColumn(name = "escenarioCodigo", referencedColumnName = "codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private Escenario escenarioCodigo;
    @JoinColumn(name = "codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Implemento implemento;
    @JoinColumn(name = "personaCodigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona personaCodigo;

    public Prestamo() {
    }

    public Prestamo(Integer codigo) {
        this.codigo = codigo;
    }

    public Prestamo(Integer codigo, Date fechaPrestamo, Date fechaDevolucion, boolean estado) {
        this.codigo = codigo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Integer getImplementoCodigo() {
        return implementoCodigo;
    }

    public void setImplementoCodigo(Integer implementoCodigo) {
        this.implementoCodigo = implementoCodigo;
    }

    public Escenario getEscenarioCodigo() {
        return escenarioCodigo;
    }

    public void setEscenarioCodigo(Escenario escenarioCodigo) {
        this.escenarioCodigo = escenarioCodigo;
    }

    public Implemento getImplemento() {
        return implemento;
    }

    public void setImplemento(Implemento implemento) {
        this.implemento = implemento;
    }

    public Persona getPersonaCodigo() {
        return personaCodigo;
    }

    public void setPersonaCodigo(Persona personaCodigo) {
        this.personaCodigo = personaCodigo;
    }

}
