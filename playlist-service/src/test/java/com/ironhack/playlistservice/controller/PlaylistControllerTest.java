package com.ironhack.playlistservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.playlistservice.controller.dto.MovieDTO;
import com.ironhack.playlistservice.controller.dto.PlaylistRequestDTO;
import com.ironhack.playlistservice.dao.Movie;
import com.ironhack.playlistservice.dao.Playlist;
import com.ironhack.playlistservice.repository.PlaylistRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class PlaylistControllerTest {

    @Autowired
    PlaylistRepository playlistRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private Playlist playlist;
    private Playlist playlist1;
    private List<Playlist> playlists;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        playlist = new Playlist("Playlist 1", 0, 1);
        playlist1 = new Playlist("Playlist 2", 0, 2);
        URI movieURI = URI.create("http://m.media-amazon.com/images/M/MV5BODllNWE0Mm…yXkFqcGdeQXVyNTc1NTQxODI@._V1_Ratio0.6791_AL_.jpg");
        Movie movie = new Movie("tt2323", movieURI, "Kill Bill", "sdfdsasd" );
        Movie movie1 = new Movie("tt1111", movieURI, "Weekend at Bernie's", "i don't have time for this" );
        Movie movie2 = new Movie("tt66666", movieURI, "Withnail and I", "or for that" );
        List<Movie> moviesList = new ArrayList<>();
        moviesList.add(movie);
        moviesList.add(movie1);
        moviesList.add(movie2);
        playlist1.setMovies(moviesList);
        playlists = playlistRepository.saveAll(List.of(playlist, playlist1));
    }

    @AfterEach
    public void tearDown() {
//        playlistRepository.deleteAll();
    }

    @Test
    void findPlaylistById() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/api/playlists/" + playlist.getId())
        ).andDo(print()).andExpect(status().isOk()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Playlist 1"));
    }

    @Test
    void getPlaylists() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/playlists")).andDo(print()).andExpect(status().isOk()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Playlist 1"));
        assertTrue(result.getResponse().getContentAsString().contains("Playlist 2"));
    }

    @Test
    void create() throws Exception {
        PlaylistRequestDTO playlistRequestDTO = new PlaylistRequestDTO("Playlist3", 0, 3);
        String body = objectMapper.writeValueAsString(playlistRequestDTO);
        MvcResult result = mockMvc.perform(post("/api/playlists/new").content(body)
                .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Playlist3"));
    }

    @Test
    void addNewMovie() throws Exception {
        Long id = playlist.getId();
        URI movieURI = URI.create("http://m.media-amazon.com/images/M/MV5BODllNWE0Mm…yXkFqcGdeQXVyNTc1NTQxODI@._V1_Ratio0.6791_AL_.jpg");
        MovieDTO movie = new MovieDTO("tt2323", movieURI, "Kill Bill", "sdfdsasd" );
        String body = objectMapper.writeValueAsString(movie);
        MvcResult result = mockMvc.perform(put("/api/playlists/addmovie/" + id).content(body)
                .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isNoContent()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Kill Bill"));
    }

//    @Test
//    void getMoviesByPlaylist() throws Exception {
//        Long id = playlist1.getId();
//        MvcResult result = mockMvc.perform(
//                get("/api/playlists/movies/" + id)
//        ).andDo(print()).andExpect(status().isOk()).andReturn();
//        assertTrue(result.getResponse().getContentAsString().contains("Kill Bill"));
//    }


}
