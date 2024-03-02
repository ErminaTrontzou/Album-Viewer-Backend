package com.example.albumviewerangularspring.services;

import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface SpotifyService {

   public ResponseEntity<String> getArtistAlbums(String artistId, String includeGroups, String market, int limit, int offset) throws IOException;

   public ResponseEntity<String> getNewReleases(int limit, int offset) throws IOException;
}
