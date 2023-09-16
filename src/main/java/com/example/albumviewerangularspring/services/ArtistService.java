package com.example.albumviewerangularspring.services;

import com.example.albumviewerangularspring.entities.Album;
import com.example.albumviewerangularspring.entities.Artist;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ArtistService {

    public ResponseEntity<List<Artist>> getAllArtists();

    public ResponseEntity<List<Object>> getAllArtistId();
}
