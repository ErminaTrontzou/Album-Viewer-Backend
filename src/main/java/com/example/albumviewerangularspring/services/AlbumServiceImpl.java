package com.example.albumviewerangularspring.services;

import com.example.albumviewerangularspring.entities.*;
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
    public ResponseEntity<Integer> getCountOfAllAlbums() {
        return ResponseEntity.ok(albumRepository.countAllAlbums());
    }

    @Override
    public ResponseEntity<List<Object[]>> getCountAlbumsByArtist() {
        return ResponseEntity.ok(albumRepository.countAlbumsByArtist());
    }


    @Override
    public ResponseEntity<List<AlbumsOfArtists>> getAllAlbums(){
        return ResponseEntity.ok(albumRepository.findAllAlbums());
    }

    @Override
    public ResponseEntity<List<AlbumsOfArtists>> getTop5ByOrderByCreatedAtDesc(){
        return ResponseEntity.ok(albumRepository.findTop6ByOrderByReleaseDateDesc());
    }

    @Override
    public ResponseEntity<List<AlbumsOfArtists>> getAlbumsByArtist(Integer id) {return ResponseEntity.ok(albumRepository.findAllByArtistId(id));};

    @Override
    public ResponseEntity<List<AlbumsOfArtists>> getAllAlbumsByGenre(String genreName){
        return ResponseEntity.ok(albumRepository.findAllAlbumsByGenre(genreName));
    }

//    @Override
//    public ResponseEntity<SingleAlbum> getSpecificAlbumById(Integer id){
//        return ResponseEntity.ok(albumRepository.findCustomAlbumById(id));
//    }

    public ResponseEntity<List<AlbumsOfArtists>> getCustomAlbumById(Integer id) {
        return ResponseEntity.ok(albumRepository.findSingleAlbumByID(id));
    }

}
