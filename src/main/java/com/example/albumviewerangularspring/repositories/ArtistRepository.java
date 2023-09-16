package com.example.albumviewerangularspring.repositories;

import com.example.albumviewerangularspring.entities.Album;
import com.example.albumviewerangularspring.entities.Artist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends CrudRepository<Artist,Integer> {

    @NonNull
    List<Artist> findAll();

    @Query("SELECT id,name FROM Artist")
    List<Object> findArtistId();


}
