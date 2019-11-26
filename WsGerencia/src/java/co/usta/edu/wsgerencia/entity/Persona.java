/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usta.edu.wsgerencia.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "persona ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    
    @Column(name = "codigo")
    private Integer codigo;
    
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombreestudiante;
    
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellido")
    private String apellidoestudiante;
    
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cedula")
    private Integer documento;
    
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "correo")
    private String email;
    
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "tipo")
    private String tipo;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaCodigo")
    private Collection<Prestamo> prestamoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoPersona")
    private Collection<Sancion> sancionCollection;
    @JoinColumn(name = "sancionCodigo", referencedColumnName = "codigo")
    @ManyToOne
    private Integer sancionCodigo;

    public Persona() {
    }

    public Persona(Integer codigo) {
        this.codigo = codigo;
    }

    public Persona(Integer codigo, String nombre, String apellido, Integer cedula, String correo, String tipo) {
        this.codigo = codigo;
        this.nombreestudiante = nombre;
        this.apellidoestudiante = apellido;
        this.documento = cedula;
        this.email = correo;
        this.tipo = tipo;
        this.sancionCodigo = 0;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombreestudiante;
    }

    public void setNombre(String nombre) {
        this.nombreestudiante = nombre;
    }

    public String getApellido() {
        return apellidoestudiante;
    }

    public void setApellido(String apellido) {
        this.apellidoestudiante = apellido;
    }

    public int getCedula() {
        return documento;
    }

    public void setCedula(int cedula) {
        this.documento = cedula;
    }

    public String getCorreo() {
        return email;
    }

    public void setCorreo(String correo) {
        this.email = correo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Prestamo> getPrestamoCollection() {
        return prestamoCollection;
    }

    public void setPrestamoCollection(Collection<Prestamo> prestamoCollection) {
        this.prestamoCollection = prestamoCollection;
    }

    @XmlTransient
    public Collection<Sancion> getSancionCollection() {
        return sancionCollection;
    }

    public void setSancionCollection(Collection<Sancion> sancionCollection) {
        this.sancionCollection = sancionCollection;
    }

    public Integer getSancionCodigo() {
        return sancionCodigo;
    }

    public void setSancionCodigo(Integer sancionCodigo) {
        this.sancionCodigo = sancionCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.usta.edu.wsgerencia.entity.Persona[ codigo=" + codigo + " ]";
    }
    
}
