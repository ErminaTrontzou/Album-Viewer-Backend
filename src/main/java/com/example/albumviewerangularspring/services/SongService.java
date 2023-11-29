package com.example.albumviewerangularspring.services;

import com.example.albumviewerangularspring.entities.Song;
import com.example.albumviewerangularspring.entities.SongsOfAlbum;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SongService {

    public ResponseEntity<List<SongsOfAlbum>> getAllSongsFromSpecificAlbum(Integer id);
}
