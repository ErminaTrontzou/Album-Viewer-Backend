package com.example.albumviewerangularspring.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Entity
@Table(name = "genre")
public class Genre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "genreID")
    private Album album;

    public Genre(){}
    public Genre(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
