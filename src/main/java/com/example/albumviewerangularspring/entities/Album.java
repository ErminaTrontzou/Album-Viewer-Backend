package com.example.albumviewerangularspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Year;
import java.util.Set;

@Entity
@Table(name="album")
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name = "release_date")
    private Year releaseDate;

    @Column(name = "image_path")
    private String imagePath;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "album")
    private Set<Song> songs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Artist artist;


    public Album(){}

    public Album(Integer id, String name, Year releaseDate, String imagePath) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.imagePath = imagePath;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Year getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(Year releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImagePath() {
        return imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Set<Song> getSongs() {
        return songs;
    }
    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    public Artist getArtist() {
        return artist;
    }
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

}
