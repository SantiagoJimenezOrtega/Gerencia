/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usta.edu.wsgerencia.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chago
 */
@Entity
@Table(name = "implemento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Implemento.findAll", query = "SELECT i FROM Implemento i"),
    @NamedQuery(name = "Implemento.findByCodigo", query = "SELECT i FROM Implemento i WHERE i.codigo = :codigo"),
    @NamedQuery(name = "Implemento.findByNombre", query = "SELECT i FROM Implemento i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Implemento.findByEstado", query = "SELECT i FROM Implemento i WHERE i.estado = :estado"),
    @NamedQuery(name = "Implemento.findByDescripcion", query = "SELECT i FROM Implemento i WHERE i.descripcion = :descripcion")})
public class Implemento implements Serializable {

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
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "implemento", fetch = FetchType.LAZY)
    private Prestamo prestamo;

    public Implemento() {
    }

    public Implemento(Integer codigo) {
        this.codigo = codigo;
    }

    public Implemento(Integer codigo, String nombre, boolean estado, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
        this.descripcion = descripcion;
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

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

}
