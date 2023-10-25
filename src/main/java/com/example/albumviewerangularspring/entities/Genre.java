package com.example.albumviewerangularspring.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@Table(name = "genre")
public class Genre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "picture")
    private String picture;

    @OneToMany(mappedBy = "genreID", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Album> albums;


    public Genre(){}
    public Genre(Integer id, String name, String picture) {
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

    public void setPicture(String picture){ this.picture = picture; }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
}
