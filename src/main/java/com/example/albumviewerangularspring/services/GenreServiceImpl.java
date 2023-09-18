package com.example.albumviewerangularspring.services;

import com.example.albumviewerangularspring.repositories.GenreRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService{

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    @Override
    public ResponseEntity<List<String>> getAllGenreNames(){
        return ResponseEntity.ok(genreRepository.findAllGenreNames());
    }
}
