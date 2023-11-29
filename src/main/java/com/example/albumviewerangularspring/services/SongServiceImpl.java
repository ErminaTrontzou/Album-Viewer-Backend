package com.example.albumviewerangularspring.services;

import com.example.albumviewerangularspring.entities.Song;
import com.example.albumviewerangularspring.entities.SongsOfAlbum;
import com.example.albumviewerangularspring.repositories.SongRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository){
        this.songRepository = songRepository;
    }

    @Override
    public ResponseEntity<List<SongsOfAlbum>> getAllSongsFromSpecificAlbum(Integer id){
        return ResponseEntity.ok(songRepository.listAllSongsFromSpecificAlbum(id));
    }
}
