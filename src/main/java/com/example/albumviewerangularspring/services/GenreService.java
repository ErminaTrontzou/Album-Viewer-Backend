package com.example.albumviewerangularspring.services;


import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GenreService {

    public ResponseEntity<List<String>> getAllGenreNames();
}
