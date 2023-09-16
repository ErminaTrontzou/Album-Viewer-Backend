package com.example.albumviewerangularspring.services;

import com.example.albumviewerangularspring.entities.Album;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AlbumService {

    public ResponseEntity<List<Album>> getAllAlbums();

    public ResponseEntity<List<Album>> getAlbumsByArtist(Integer id);

    public ResponseEntity<List<Album>> getAllAlbumsByGenre(String genre);
}
