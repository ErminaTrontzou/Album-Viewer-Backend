//package com.example.albumviewerangularspring.controllers;
//
//import com.example.albumviewerangularspring.controller.ArtistController;
//import com.example.albumviewerangularspring.entities.Album;
//import com.example.albumviewerangularspring.entities.Artist;
//import com.example.albumviewerangularspring.services.ArtistServiceImpl;
//import org.hamcrest.Matchers;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.time.Year;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//@WebMvcTest(ArtistControllerTest.class)
//public class ArtistControllerTest {
//
//    @Mock
//    private ArtistServiceImpl artistService;
//
//    @InjectMocks
//    private ArtistController artistController;
//
//    private MockMvc mockMvc;
//
//    Artist firstArtist = new Artist(1,"Adam");
//    Artist secondArtist = new Artist(2, "Bob");
//    Artist thirdArtist = new Artist(3, "Calvin");
//
//    @Before
//    public void setUp(){
//        MockitoAnnotations.openMocks(this);
//        this.mockMvc = MockMvcBuilders.standaloneSetup(artistController).build();
//    }
//
//    @After
//    public void tearDown(){
//        this.mockMvc=null;
//    }
//
//    @Test
//    public void getAllMockArtistsFromService() throws Exception {
//        List<Artist> mockArtists = new ArrayList<>();
//        mockArtists.add(firstArtist);
//        mockArtists.add(secondArtist);
//        mockArtists.add(thirdArtist);
//
//        when(artistService.getAllArtists()).thenReturn(new ResponseEntity<>(mockArtists, HttpStatus.OK));
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("http://localhost:8080/api/v1/artist")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", Matchers.hasSize(3)));
//    }
//
//    @Test
//    public void getAllArtistIdFromService() throws Exception {
//        List<Object> mockArtistIds = new ArrayList<>();
//        mockArtistIds.add(firstArtist.getId());
//        mockArtistIds.add(secondArtist.getId());
//        mockArtistIds.add(thirdArtist.getId());
//
//        when(artistService.getAllArtistId()).thenReturn(new ResponseEntity<>(mockArtistIds, HttpStatus.OK));
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("http://localhost:8080/api/v1/artist/id")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", Matchers.hasSize(3)));
//    }
//
//
////    @Test
////    public void getAllAlbumOfArtistFromService() throws Exception{
////        Integer mockArtistId = 1;
////        List<Album> mockAlbums = new ArrayList<>();
////        mockAlbums.add(new Album(1, "Album 1", Year.of(2020), "path1"));
////        mockAlbums.add(new Album(2, "Album 2", Year.of(2021), "path2"));
////
////        when(artistService.getAlbumsByArtist(mockArtistId)).thenReturn(ResponseEntity.ok(mockAlbums));
////        mockMvc.perform(MockMvcRequestBuilders
////                        .get("http://localhost:8080/api/v1/artist/albums")
////                        .param("id", mockArtistId.toString()))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$[0].name").value("Album 1"))
////                .andExpect(jsonPath("$[1].name").value("Album 2"));
////    }
//}
