package com.ironhack.playlistservice.proxy;

import com.ironhack.playlistservice.controller.dto.MovieReceiptDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("movie-service")
public interface MovieProxy {

    @GetMapping("/api/movies/get/{id}")
    MovieReceiptDTO getMovie(@PathVariable(name = "id") long id);
}
