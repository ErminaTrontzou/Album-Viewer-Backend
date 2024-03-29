package com.example.albumviewerangularspring.controller;

import com.example.albumviewerangularspring.entities.Album;
import com.example.albumviewerangularspring.entities.AlbumsOfArtists;
import com.example.albumviewerangularspring.services.AlbumServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/album")
public class AlbumController {

    private final AlbumServiceImpl albumService;
    public AlbumController(AlbumServiceImpl albumService){
        this.albumService = albumService;
    }

    @GetMapping("")
    public ResponseEntity<List<AlbumsOfArtists>> listAllAlbums(){
        return albumService.getAllAlbums();
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> listCountOfAllAlbums() {
        return albumService.getCountOfAllAlbums();
    }

    @GetMapping("/artist-count")
    public ResponseEntity<List<Object[]>> countAlbumsByArtist() {
        return albumService.getCountAlbumsByArtist();
    }


    @GetMapping("/recent")
    public ResponseEntity<List<AlbumsOfArtists>> listTop5ByOrderByCreatedAtDesc(){
        return albumService.getTop5ByOrderByCreatedAtDesc();
    }

    @GetMapping("/artist_id/{id}")
    public ResponseEntity<List<AlbumsOfArtists>> listAlbumsByArtist(@PathVariable Integer id){
        return albumService.getAlbumsByArtist(id);
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<AlbumsOfArtists>> listAlbumsByGenre(@PathVariable String genre){
        return albumService.getAllAlbumsByGenre(genre);
    }

    @GetMapping("/specific/{id}")
    public ResponseEntity<List<AlbumsOfArtists>> listSpecificAlbum(@PathVariable Integer id){
        return albumService.getCustomAlbumById(id);
    }
}
