package com.example.albumviewerangularspring.repositories;

import com.example.albumviewerangularspring.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {

    @Query("Select s From Song  s Where s.album.id = ?1")
    List<Song> listAllSongsFromSpecificAlbum(Integer id);

}
