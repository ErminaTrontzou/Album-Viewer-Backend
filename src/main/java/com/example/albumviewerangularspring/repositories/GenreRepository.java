package com.example.albumviewerangularspring.repositories;

import com.example.albumviewerangularspring.entities.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends CrudRepository< Genre, Integer> {

    @Query("Select g from Genre g")
    List<Genre> findAllGenre();
}
