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

    @GetMapping("/recent")
    public ResponseEntity<List<AlbumsOfArtists>> listTop5ByOrderByCreatedAtDesc(){
        return albumService.getTop5ByOrderByCreatedAtDesc();
    }

    @GetMapping("/artist_id")
    public ResponseEntity<List<Album>> listAlbumsByArtist(@RequestParam Integer id){
        return albumService.getAlbumsByArtist(id);
    }

    @GetMapping("/genre")
    public ResponseEntity<List<AlbumsOfArtists>> listAlbumsByGenre(@RequestParam String name){
        return albumService.getAllAlbumsByGenre(name);
    }

    @GetMapping("/specific/{id}")
    public ResponseEntity<List<AlbumsOfArtists>> listSpecificAlbum(@PathVariable Integer id){
        return albumService.getCustomAlbumById(id);
    }
}
