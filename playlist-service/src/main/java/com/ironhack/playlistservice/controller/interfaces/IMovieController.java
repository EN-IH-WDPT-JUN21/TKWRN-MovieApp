package com.ironhack.playlistservice.controller.interfaces;

import com.ironhack.playlistservice.controller.dto.MovieDetailDTO;

public interface IMovieController {

    MovieDetailDTO getByTitle(String title);
}
