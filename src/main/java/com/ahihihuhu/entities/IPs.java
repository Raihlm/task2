package com.ahihihuhu.entities;

import com.ahihihuhu.repo.ApplicationRepository;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class IPs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String address;

    @ManyToOne
    @JoinColumn(name = "appId")
    @JsonBackReference
    private Application aplikasi;

    public IPs(Integer id, String address, Application aplikasi) {
        this.id = id;
        this.address = address;
        this.aplikasi = aplikasi;
    }

    public IPs() {

    }

    public Integer getId() {
        return id;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        IPs iPs = (IPs) o;
        return id == iPs.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Application getAplikasi() {
        return aplikasi;
    }

    public void setAplikasi(Application aplikasi) {
        this.aplikasi = aplikasi;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @JsonProperty("namaAplikasi")
    public String getAppName(){
        return (aplikasi.getName() == null) ? "Empty" : aplikasi.getName();
    }
}
