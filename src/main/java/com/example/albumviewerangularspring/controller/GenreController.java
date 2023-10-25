package com.example.albumviewerangularspring.controller;

import com.example.albumviewerangularspring.entities.Genre;
import com.example.albumviewerangularspring.services.GenreServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/genre")
public class GenreController {

    private final GenreServiceImpl genreService;

    public GenreController(GenreServiceImpl genreService){
        this.genreService = genreService;
    }

    @GetMapping("")
    public ResponseEntity<List<Genre>> listAllGenre(){
        return genreService.getAllGenre();
    }
}
