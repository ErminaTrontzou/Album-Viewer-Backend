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


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "artist")
    @JsonIgnore
    private Set<Album> albums;


    public Artist() {}

    public Artist(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonManagedReference
    public Set<Album> getAlbums() {
        return albums;
    }
    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
}
