/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ktp;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ican
 */
@Entity
@Table(name = "dataktp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dataktp.findAll", query = "SELECT d FROM Dataktp d"),
    @NamedQuery(name = "Dataktp.findById", query = "SELECT d FROM Dataktp d WHERE d.id = :id"),
    @NamedQuery(name = "Dataktp.findByNik", query = "SELECT d FROM Dataktp d WHERE d.nik = :nik"),
    @NamedQuery(name = "Dataktp.findByNama", query = "SELECT d FROM Dataktp d WHERE d.nama = :nama"),
    @NamedQuery(name = "Dataktp.findByTgllahir", query = "SELECT d FROM Dataktp d WHERE d.tgllahir = :tgllahir"),
    @NamedQuery(name = "Dataktp.findByAlamat", query = "SELECT d FROM Dataktp d WHERE d.alamat = :alamat"),
    @NamedQuery(name = "Dataktp.findByJkelamin", query = "SELECT d FROM Dataktp d WHERE d.jkelamin = :jkelamin"),
    @NamedQuery(name = "Dataktp.findByAgama", query = "SELECT d FROM Dataktp d WHERE d.agama = :agama"),
    @NamedQuery(name = "Dataktp.findByStatus", query = "SELECT d FROM Dataktp d WHERE d.status = :status"),
    @NamedQuery(name = "Dataktp.findByPerkerjaan", query = "SELECT d FROM Dataktp d WHERE d.perkerjaan = :perkerjaan"),
    @NamedQuery(name = "Dataktp.findByWnegara", query = "SELECT d FROM Dataktp d WHERE d.wnegara = :wnegara"),
    @NamedQuery(name = "Dataktp.findByBhingga", query = "SELECT d FROM Dataktp d WHERE d.bhingga = :bhingga")})
public class Dataktp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id; 
    @Column(name = "nik")       
    private String nik;
    @Column(name = "nama")
    private String nama;
    @Column(name = "tgllahir")
    @Temporal(TemporalType.DATE)
    private Date tgllahir;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "jkelamin")
    private String jkelamin;
    @Column(name = "agama")
    private String agama;
    @Column(name = "status")
    private String status;
    @Column(name = "perkerjaan")
    private String perkerjaan;
    @Column(name = "wnegara")
    private String wnegara;
    @Column(name = "bhingga")
    private String bhingga;
    @Lob
    @Column(name = "foto")
    private byte[] foto;

    public Dataktp() {
    }

    public Dataktp(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTgllahir() {
        return tgllahir;
    }

    public void setTgllahir(Date tgllahir) {
        this.tgllahir = tgllahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJkelamin() {
        return jkelamin;
    }

    public void setJkelamin(String jkelamin) {
        this.jkelamin = jkelamin;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPerkerjaan() {
        return perkerjaan;
    }

    public void setPerkerjaan(String perkerjaan) {
        this.perkerjaan = perkerjaan;
    }

    public String getWnegara() {
        return wnegara;
    }

    public void setWnegara(String wnegara) {
        this.wnegara = wnegara;
    }

    public String getBhingga() {
        return bhingga;
    }

    public void setBhingga(String bhingga) {
        this.bhingga = bhingga;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
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
        if (!(object instanceof Dataktp)) {
            return false;
        }
        Dataktp other = (Dataktp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }    
}
