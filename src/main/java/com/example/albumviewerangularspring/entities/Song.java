package com.example.albumviewerangularspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Entity
@Table(name="song")
public class Song implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="duration")
    private Integer duration;

    @Column(name="position")
    private Integer position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="album_id", referencedColumnName = "id", nullable = false,unique = true)
    @JsonIgnore
    private Album album;

    public Song(){}

    public Song(Integer id, String name, Integer duration, Integer position) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.position = position;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
