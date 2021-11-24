package com.ironhack.playlistservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.playlistservice.controller.dto.MovieDTO;
import com.ironhack.playlistservice.controller.dto.PlaylistRequestDTO;
import com.ironhack.playlistservice.dao.Movie;
import com.ironhack.playlistservice.dao.Playlist;
import com.ironhack.playlistservice.repository.PlaylistRepository;
import org.junit.jupiter.api.AfterAll;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
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
    private Playlist playlist2;
    private List<Playlist> playlists;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        playlist = new Playlist("Playlist 1", 0, "user1");
        playlist1 = new Playlist("Playlist 2", 0, "user2");
        playlist2 = new Playlist("Playlist 3", 0, "user2");
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
    public  void tearDown() {
        playlistRepository.deleteAll();
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
        PlaylistRequestDTO playlistRequestDTO = new PlaylistRequestDTO("Playlist4", 0, "newUser");
        String body = objectMapper.writeValueAsString(playlistRequestDTO);
        MvcResult result = mockMvc.perform(post("/api/playlists/new").content(body)
                .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Playlist4"));
    }

    @Test
    void addNewMovie() throws Exception {
        Long id = playlist.getId();
        int movielistLength = playlist.getMovies().size();
        URI movieURI = URI.create("http://m.media-amazon.com/images/M/MV5BODllNWE0Mm…yXkFqcGdeQXVyNTc1NTQxODI@._V1_Ratio0.6791_AL_.jpg");
        MovieDTO movie = new MovieDTO(1, "tt2377", movieURI, "Pulp Fiction", "sdfdsasd" );
        String body = objectMapper.writeValueAsString(movie);
        MvcResult result = mockMvc.perform(put("/api/playlists/addmovie/" + id).content(body)
                .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isNoContent()).andReturn();
        int newMovieListLength = playlist.getMovies().size();
        assertEquals(movielistLength++, newMovieListLength);
    }

    @Test
    void getPlaylistsByUser() throws Exception {
        List<Playlist> userPlaylists = new ArrayList<>();
        MvcResult result = mockMvc.perform(
                get("/api/playlists/get/" + "user2")
        ).andDo(print()).andExpect(status().isOk()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Playlist 2"));
    }

}
