package com.example.albumviewerangularspring.services;

import com.example.albumviewerangularspring.entities.Album;
import com.example.albumviewerangularspring.entities.AlbumsOfArtists;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AlbumService {

    public  ResponseEntity<Integer> getCountOfAllAlbums();

    public ResponseEntity<List<Object[]>> getCountAlbumsByArtist();

    public ResponseEntity<List<AlbumsOfArtists>> getAllAlbums();

    public ResponseEntity<List<AlbumsOfArtists>> getTop5ByOrderByCreatedAtDesc();

    public ResponseEntity<List<AlbumsOfArtists>> getAlbumsByArtist(Integer id);

    public ResponseEntity<List<AlbumsOfArtists>> getAllAlbumsByGenre(String genreName);

//    public ResponseEntity<SingleAlbum> findCustomAlbumById(Integer id);

}
