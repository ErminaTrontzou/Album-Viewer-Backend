package com.example.albumviewerangularspring.services;


import com.example.albumviewerangularspring.entities.Album;
import com.example.albumviewerangularspring.entities.Artist;
import com.example.albumviewerangularspring.repositories.ArtistRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ArtistServiceTest {

    @Mock
    private ArtistRepository artistRepository;

    @InjectMocks
    private ArtistServiceImpl artistService;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    Artist firstArtist = new Artist(1,"Adam");
    Artist secondArtist = new Artist(2, "Bob");
    Artist thirdArtist = new Artist(3, "Calvin");

    @Test
    public void testGetAllArtists(){
        List<Artist> mockArtists = new ArrayList<>();
        mockArtists.add(firstArtist);
        mockArtists.add(secondArtist);
        mockArtists.add(thirdArtist);

        when(artistRepository.findAll()).thenReturn(mockArtists);
        final ResponseEntity<List<Artist>> result = (ResponseEntity<List<Artist>>) artistService.getAllArtists();
        assertThat(result).isNotNull();
        assertEquals(200,result.getStatusCode().value());
        assertEquals(3, Objects.requireNonNull(result.getBody()).size());
        assertEquals("Bob",result.getBody().get(1).getName());
    }

    @Test
    public void testGetAllArtistId(){
        List<Object> mockArtistIds = new ArrayList<>();
        mockArtistIds.add(firstArtist.getId());
        mockArtistIds.add(secondArtist.getId());
        mockArtistIds.add(thirdArtist.getId());

        when(artistRepository.findArtistId()).thenReturn(mockArtistIds);
        final ResponseEntity<List<Object>> response = artistService.getAllArtistId();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockArtistIds, response.getBody());

    }

//    @Test
//    public void testGetAllAlbumsOfAnArtist(){
//        Integer mockArtistId = 1;
//        List<Album> mockAlbums = new ArrayList<>();
//        mockAlbums.add(new Album(1, "Album 1", Year.of(2020), "path1"));
//        mockAlbums.add(new Album(2, "Album 2", Year.of(2021), "path2"));
//
//        when(artistRepository.findAllByArtistId(mockArtistId)).thenReturn(mockAlbums);
//        final ResponseEntity<List<Album>> response = artistService.getAlbumsByArtist(mockArtistId);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(mockAlbums, response.getBody());
//    }
}
