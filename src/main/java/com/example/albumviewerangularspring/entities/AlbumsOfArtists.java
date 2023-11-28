package com.example.albumviewerangularspring.entities;

import java.time.Year;
import java.util.List;

public interface AlbumsOfArtists {

    Integer getId();

    Integer getArtistId();

    Integer getGenreId();
    String getName();
    Year getReleaseDate();
    String getImagePath();
    String getArtistName();


}
