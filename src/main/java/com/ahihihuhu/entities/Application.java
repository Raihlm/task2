package com.ahihihuhu.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appId;

    private String name;
    private String description;

    @OneToMany(mappedBy = "aplikasi", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonProperty("iPsList")
    private List<IPs> iPsList;

    public Application() {}


    public Application(String name, String description, List<IPs> iPsList) {
        this.name = name;
        this.description = description;
        this.iPsList = iPsList;
    }


    public Integer getAppId() { return appId; }
    public void setAppId(Integer appId) { this.appId = appId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<IPs> getiPsList() { return iPsList; }
    public void setiPsList(List<IPs> iPsList) { this.iPsList = iPsList; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return Objects.equals(appId, that.appId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appId);
    }
}
