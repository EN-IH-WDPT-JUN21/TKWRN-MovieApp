package com.ironhack.playlistservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.playlistservice.controller.dto.PlaylistRequestDTO;
import com.ironhack.playlistservice.dao.Playlist;
import com.ironhack.playlistservice.enums.PlaylistType;
import com.ironhack.playlistservice.repository.PlaylistRepository;
import com.ironhack.playlistservice.service.PlaylistService;
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
    PlaylistService playlistService;

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
        playlist = new Playlist("Playlist 1", "user1");
        playlist1 = new Playlist("Playlist 2", "user2", PlaylistType.PRIVATE);
        playlists = playlistRepository.saveAll(List.of(playlist, playlist1));
    }

    @AfterEach
    public void tearDown() {
//        playlistRepository.deleteAll();
    }

    @Test
    void findPlaylistById() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/api/playlists/get/" + playlist.getId())
        ).andDo(print()).andExpect(status().isOk()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Playlist 1"));
    }

    @Test
    void getPlaylists() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/playlists/get")).andDo(print()).andExpect(status().isOk()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Playlist 1"));
        assertTrue(result.getResponse().getContentAsString().contains("Playlist 2"));
    }

    @Test
    void create() throws Exception {
        PlaylistRequestDTO playlistRequestDTO = new PlaylistRequestDTO("Playlist3", 0, "user3", PlaylistType.PUBLIC.toString());
        String body = objectMapper.writeValueAsString(playlistRequestDTO);
        MvcResult result = mockMvc.perform(post("/api/playlists/new").content(body)
                .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Playlist3"));
    }

    @Test
    void updateName() throws Exception {
        PlaylistRequestDTO playlistRequestDTO = new PlaylistRequestDTO("New Playlist name");
        String body = objectMapper.writeValueAsString(playlistRequestDTO);
        MvcResult result = mockMvc.perform(put("/api/playlists/update/" + playlist1.getId()).content(body)
                .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isNoContent()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("New Playlist name"));
    }
}
