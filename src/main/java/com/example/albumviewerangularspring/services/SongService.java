package com.example.albumviewerangularspring.services;

import com.example.albumviewerangularspring.entities.Song;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SongService {

    public ResponseEntity<List<Song>> getAllSongsFromSpecificAlbum(Integer id);
}
