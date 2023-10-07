package com.example.albumviewerangularspring.repositories;

import com.example.albumviewerangularspring.entities.Album;
import com.example.albumviewerangularspring.entities.AlbumsOfArtists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Integer> {

    @Query("SELECT a.id as id, a.name AS name, a.releaseDate AS releaseDate, a.imagePath AS imagePath, ar.name AS artistName " +
                  "FROM Album a " +
            "INNER JOIN a.artist ar ")
    List<AlbumsOfArtists> findAllAlbums();

    @Query("SELECT a.id as id, a.name AS name, a.releaseDate AS releaseDate, a.imagePath AS imagePath, ar.name AS artistName " +
            "FROM Album a " +
            "INNER JOIN a.artist ar " +
            "order by releaseDate " +
            "desc limit 6")
    List<AlbumsOfArtists> findTop6ByOrderByReleaseDateDesc();

    @Query("SELECT a FROM Album a WHERE a.artist.id = ?1")
    List<Album> findAllByArtistId(Integer artistId);

    @Query("Select a.id as id, a.name AS name, a.releaseDate AS releaseDate, a.imagePath AS imagePath, ar.name AS artistName" +
            " from Album a " +
            "inner join a.artist ar " +
            "where a.genreID.name  = ?1")
    List<AlbumsOfArtists> findAllAlbumsByGenre(String genreName);

    @Query("SELECT a.id as id, a.name as name, a.imagePath as imagePath, a.releaseDate as releaseDate, a.artist.name as artistName  " +
            "from Album a " +
            "where a.id = ?1")
    List<AlbumsOfArtists> findSingleAlbumByID(@Param("id") Integer id);
}
