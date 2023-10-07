package com.example.albumviewerangularspring.entities;

import java.time.Year;
import java.util.List;

public interface AlbumsOfArtists {

    Integer getId();
    String getName();
    Year getReleaseDate();
    String getImagePath();
    String getArtistName();


}
