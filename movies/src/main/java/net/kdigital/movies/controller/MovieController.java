package net.kdigital.movies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.kdigital.movies.dto.MovieDTO;
import net.kdigital.movies.service.MovieService;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MovieController {
    
    public final MovieService service;

    @GetMapping("/movie/movieDetail")
    public String movieDetail(
        @RequestParam(name = "movieNum") Long movieNum,
        Model model
    ){
        log.info("==========movieDetail controller");

        MovieDTO movieDTO = service.selectMovie(movieNum);
        
        log.info("============> {}", movieDTO);
        model.addAttribute("movie", movieDTO);

        return "movieDetail";
    }
}
