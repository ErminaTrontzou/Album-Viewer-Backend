package com.example.albumviewerangularspring.controller;


import com.example.albumviewerangularspring.entities.Artist;
import com.example.albumviewerangularspring.services.ArtistServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/artist")
public class ArtistController {

    private final ArtistServiceImpl artistService;

    public ArtistController(ArtistServiceImpl artistService){
        this.artistService=artistService;
    }

    @GetMapping("")
    @Transactional(readOnly = true)
    public ResponseEntity<List<Artist>> listAllArtists(){
        return artistService.getAllArtists();
    }

    @GetMapping("/id")
    public ResponseEntity<List<Object>> listAllArtistId(){
        return artistService.getAllArtistId();
    }
}
