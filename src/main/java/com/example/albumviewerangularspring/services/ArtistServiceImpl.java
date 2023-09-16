package com.example.albumviewerangularspring.services;

import com.example.albumviewerangularspring.entities.Album;
import com.example.albumviewerangularspring.entities.Artist;
import com.example.albumviewerangularspring.repositories.ArtistRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository){
        this.artistRepository=artistRepository;
    }

    @Override
    public  ResponseEntity<List<Artist>> getAllArtists(){
        return ResponseEntity.ok(artistRepository.findAll());
    }

    @Override
    public  ResponseEntity<List<Object>> getAllArtistId(){
        return ResponseEntity.ok(artistRepository.findArtistId());
    }


}
