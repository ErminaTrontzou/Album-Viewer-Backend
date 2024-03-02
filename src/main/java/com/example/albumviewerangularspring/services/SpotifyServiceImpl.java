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

        return executeRequest(url);
    }

    @Override
    public ResponseEntity<String> getNewReleases(int limit, int offset) throws IOException {
        String url = "https://api.spotify.com/v1/browse/new-releases" +
                "?limit=" + limit +
                "&offset=" + offset;

        return executeRequest(url);
    }

    private ResponseEntity<String> executeRequest(String url) throws IOException {
        HttpGet request = new HttpGet(url);
        request.addHeader("Authorization", "Bearer " + spotifyApiToken);

        try {
            HttpResponse response = httpClient.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == HttpStatus.OK.value()) {
                InputStream inputStream = response.getEntity().getContent();
                String responseBody = convertStreamToString(inputStream);
                return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(responseBody);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected response code: " + statusCode);
            }
        } finally {
            request.abort();
        }
    }

    /**
     * Converts an InputStream to a String.
     *
     * @param inputStream The InputStream containing the data to be converted.
     * @return The content of the InputStream as a String.
     */
    private String convertStreamToString(InputStream inputStream) {
        // Create a Scanner object to read from the inputStream
        // Set the delimiter to "\\A", which matches the beginning of the input,
        // effectively telling the scanner to read the entire stream until the end.
        Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");

        // Check if there is another token available in the scanner (i.e., if there is content in the stream)
        if (scanner.hasNext()) {
            // If content is available, read the entire content of the stream as a single token (due to the "\\A" delimiter)
            // and return it as a string.
            return scanner.next();
        } else {
            // If there's no content in the stream, return an empty string.
            return "";
        }
    }
}
