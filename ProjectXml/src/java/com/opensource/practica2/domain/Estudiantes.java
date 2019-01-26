/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opensource.practica2.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "estudiantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiantes.findAll", query = "SELECT e FROM Estudiantes e")
    , @NamedQuery(name = "Estudiantes.findById", query = "SELECT e FROM Estudiantes e WHERE e.id = :id")
    , @NamedQuery(name = "Estudiantes.findByCedulaEstudiante", query = "SELECT e FROM Estudiantes e WHERE e.cedulaEstudiante = :cedulaEstudiante")
    , @NamedQuery(name = "Estudiantes.findByMatriculaEstudiante", query = "SELECT e FROM Estudiantes e WHERE e.matriculaEstudiante = :matriculaEstudiante")
    , @NamedQuery(name = "Estudiantes.findByCarreraAbrev", query = "SELECT e FROM Estudiantes e WHERE e.carreraAbrev = :carreraAbrev")
    , @NamedQuery(name = "Estudiantes.findByCreditosTotal", query = "SELECT e FROM Estudiantes e WHERE e.creditosTotal = :creditosTotal")
    , @NamedQuery(name = "Estudiantes.findByCreditosCursados", query = "SELECT e FROM Estudiantes e WHERE e.creditosCursados = :creditosCursados")})
@XmlAccessorType(XmlAccessType.FIELD)
public class Estudiantes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "CedulaEstudiante")
    private String cedulaEstudiante;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "MatriculaEstudiante")
    private String matriculaEstudiante;

    @Size(max = 3)
    @Column(name = "CarreraAbrev")
    private String carreraAbrev;

    @Basic(optional = false)
    @NotNull
    @Column(name = "CreditosTotal")
    private short creditosTotal;

    @Basic(optional = false)
    @NotNull
    @Column(name = "CreditosCursados")
    private short creditosCursados;

    public Estudiantes() {
    }

    public Estudiantes(Integer id) {
        this.id = id;
    }

    public Estudiantes(Integer id, String cedulaEstudiante, String matriculaEstudiante, short creditosTotal, short creditosCursados) {
        this.id = id;
        this.cedulaEstudiante = cedulaEstudiante;
        this.matriculaEstudiante = matriculaEstudiante;
        this.creditosTotal = creditosTotal;
        this.creditosCursados = creditosCursados;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedulaEstudiante() {
        return cedulaEstudiante;
    }

    public void setCedulaEstudiante(String cedulaEstudiante) {
        this.cedulaEstudiante = cedulaEstudiante;
    }

    public String getMatriculaEstudiante() {
        return matriculaEstudiante;
    }

    public void setMatriculaEstudiante(String matriculaEstudiante) {
        this.matriculaEstudiante = matriculaEstudiante;
    }

    public String getCarreraAbrev() {
        return carreraAbrev;
    }

    public void setCarreraAbrev(String carreraAbrev) {
        this.carreraAbrev = carreraAbrev;
    }

    public short getCreditosTotal() {
        return creditosTotal;
    }

    public void setCreditosTotal(short creditosTotal) {
        this.creditosTotal = creditosTotal;
    }

    public short getCreditosCursados() {
        return creditosCursados;
    }

    public void setCreditosCursados(short creditosCursados) {
        this.creditosCursados = creditosCursados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiantes)) {
            return false;
        }
        Estudiantes other = (Estudiantes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estudiantes{" + "id=" + id + ", cedulaEstudiante=" + cedulaEstudiante + ", matriculaEstudiante=" + matriculaEstudiante + ", carreraAbrev=" + carreraAbrev + ", creditosTotal=" + creditosTotal + ", creditosCursados=" + creditosCursados + '}';
    }
}
