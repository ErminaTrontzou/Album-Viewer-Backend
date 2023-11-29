package com.example.albumviewerangularspring.repositories;

import com.example.albumviewerangularspring.entities.Song;
import com.example.albumviewerangularspring.entities.SongsOfAlbum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {

    @Query("Select s.id as id, s.album.id as albumId, s.name as name ,s.duration as duration, s.position as position " +
            "From Song  s" +
            " Where s.album.id = ?1")
    List<SongsOfAlbum> listAllSongsFromSpecificAlbum(Integer id);

}
