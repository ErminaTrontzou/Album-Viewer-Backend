package com.example.albumviewerangularspring.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "artist")
public class Artist implements Serializable {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Getter
    @Column(name="name")
    private String name;

    @Getter
    @Column(name = "picture")
    private String picture;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "artist")
    private Set<Album> albums;


    public Artist() {}

    public Artist(Integer id, String name, String picture) {
        this.id = id;
        this.name = name;
        this.picture = picture;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPicture(String picture){ this.picture = picture;}

    @JsonManagedReference
    public Set<Album> getAlbums() {
        return albums;
    }
    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
}
