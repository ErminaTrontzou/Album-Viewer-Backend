package com.example.albumviewerangularspring.services;


import com.example.albumviewerangularspring.entities.Genre;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GenreService {

    public ResponseEntity<List<Genre>> getAllGenre();
}
