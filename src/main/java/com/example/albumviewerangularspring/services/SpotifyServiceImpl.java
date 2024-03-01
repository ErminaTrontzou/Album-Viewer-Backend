package com.example.albumviewerangularspring.services;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

@Service
public class SpotifyServiceImpl implements SpotifyService {

    private final HttpClient httpClient;

    private final String spotifyApiToken;

    public SpotifyServiceImpl(@Value("${SPOTIFY_API_TOKEN}") String spotifyApiToken) {
        this.httpClient = HttpClients.createDefault();
        this.spotifyApiToken = spotifyApiToken;
    }

    @Override
    public ResponseEntity<String> getArtistAlbums(String artistId, String includeGroups, String market, int limit, int offset) throws IOException {
        String url = "https://api.spotify.com/v1/artists/" + artistId + "/albums" +
                "?include_groups=" + includeGroups +
                "&market=" + market +
                "&limit=" + limit +
                "&offset=" + offset;

        HttpGet request = new HttpGet(url);
        request.addHeader("Authorization", "Bearer " + spotifyApiToken);

        HttpResponse response = httpClient.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();

        if (statusCode == HttpStatus.OK.value()) {
            InputStream inputStream = response.getEntity().getContent();
            String responseBody = convertStreamToString(inputStream);
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(responseBody);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected response code: " + statusCode);
        }
    }

    private String convertStreamToString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
        return scanner.hasNext() ? scanner.next() : "";
    }
}
