package com.example.albumviewerangularspring.services;

import com.example.albumviewerangularspring.entities.Album;
import com.example.albumviewerangularspring.repositories.AlbumRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService{

    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository){
        this.albumRepository = albumRepository;
    }

    @Override
    public ResponseEntity<List<Album>> getAllAlbums(){
        return ResponseEntity.ok(albumRepository.findAll());
    }

    @Override
    public ResponseEntity<List<Album>> getAlbumsByArtist(Integer id) {return ResponseEntity.ok(albumRepository.findAllByArtistId(id));};

    @Override
    public ResponseEntity<List<Album>> getAllAlbumsByGenre(String genre){
        return ResponseEntity.ok(albumRepository.findAllAlbumsByGenre(genre));
    }
}
