package com.example.albumviewerangularspring.controller;

import com.example.albumviewerangularspring.entities.Song;
import com.example.albumviewerangularspring.services.SongServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/song")
public class SongController {

    private final SongServiceImpl songService;

    public SongController(SongServiceImpl songService){
        this.songService=songService;
    }

    @GetMapping("/specific-album/{id}")
    public ResponseEntity<List<Song>> listAllSongsOfSpecificAlbum(@PathVariable Integer id){
        return songService.getAllSongsFromSpecificAlbum(id);
    }
}
