package com.example.albumviewerangularspring.controller;

import com.example.albumviewerangularspring.entities.Album;
import com.example.albumviewerangularspring.services.AlbumServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/album")
public class AlbumController {

    private final AlbumServiceImpl albumService;
    public AlbumController(AlbumServiceImpl albumService){
        this.albumService = albumService;
    }

    @GetMapping("")
    public ResponseEntity<List<Album>> listAllAlbums(){
        return albumService.getAllAlbums();
    }

    @GetMapping("/recent")
    public ResponseEntity<List<Album>> listTop5ByOrderByCreatedAtDesc(){
        return albumService.getTop5ByOrderByCreatedAtDesc();
    }

    @GetMapping("/artist_id")
    public ResponseEntity<List<Album>> listAlbumsByArtist(@RequestParam Integer id){
        return albumService.getAlbumsByArtist(id);
    }

    @GetMapping("/genre")
    public ResponseEntity<List<Album>> listAlbumsByGenre(@RequestParam String name){
        return albumService.getAllAlbumsByGenre(name);
    }
}
