package com.example.albumviewerangularspring.controller;

import com.example.albumviewerangularspring.services.SpotifyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/spotify/artist")
public class SpotifyController {

    private final SpotifyServiceImpl spotifyService;

    @Autowired
    public SpotifyController(SpotifyServiceImpl spotifyService) {
        this.spotifyService = spotifyService;
    }

    @GetMapping("/albums")
    public ResponseEntity<String> getArtistAlbums(
            @RequestParam String artistId,
            @RequestParam String includeGroups,
            @RequestParam String market,
            @RequestParam int limit,
            @RequestParam int offset) throws IOException {

        return spotifyService.getArtistAlbums(artistId, includeGroups, market, limit, offset);
    }
}
