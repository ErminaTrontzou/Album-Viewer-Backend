package com.example.albumviewerangularspring.repositories;

import com.example.albumviewerangularspring.entities.Album;
import lombok.NonNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends CrudRepository<Album,Integer> {

    @NonNull
    List<Album> findAll();

    @Query("SELECT a FROM Album a WHERE a.artist.id = ?1")
    List<Album> findAllByArtistId(Integer artistId);

    @Query("Select a from Album a where a.genreID.name  = ?1")
    List<Album> findAllAlbumsByGenre(String genreName);
}
