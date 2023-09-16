package com.example.albumviewerangularspring.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.time.Year;
import java.util.Set;

@Entity
@Table(name="album")
public class Album implements Serializable {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Column(name="name")
    private String name;

    @Getter
    @Column(name = "release_date")
    private Year releaseDate;

    @Getter
    @Column(name = "image_path")
    private String imagePath;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    @JsonIgnore
    private Genre genreID;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "album")
    @JsonIgnore
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseDate(Year releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Genre getGenreID() {
        return genreID;
    }
    public void setGenreID(Genre genreID) {
        this.genreID = genreID;
    }

    @JsonBackReference
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
