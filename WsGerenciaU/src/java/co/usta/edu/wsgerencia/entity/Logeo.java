/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usta.edu.wsgerencia.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chago
 */
@Entity
@Table(name = "logeo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logeo.findAll", query = "SELECT l FROM Logeo l"),
    @NamedQuery(name = "Logeo.findByUsuario", query = "SELECT l FROM Logeo l WHERE l.usuario = :usuario"),
    @NamedQuery(name = "Logeo.findByContrase\u00f1a", query = "SELECT l FROM Logeo l WHERE l.contrase\u00f1a = :contrase\u00f1a")})
public class Logeo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario")
    private Integer usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "contrase\u00f1a")
    private String contraseña;

    public Logeo() {
    }

    public Logeo(Integer usuario) {
        this.usuario = usuario;
    }

    public Logeo(Integer usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}
