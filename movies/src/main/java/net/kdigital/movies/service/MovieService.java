package net.kdigital.movies.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.kdigital.movies.dto.MovieDTO;
import net.kdigital.movies.entity.MovieEntity;
import net.kdigital.movies.repository.MovieRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;

    public MovieDTO selectMovie(Long movieNum) {
        Optional<MovieEntity> movieEntity = repository.findById(movieNum);
        if(movieEntity.isPresent()) {
            MovieEntity entity = movieEntity.get();
            return MovieDTO.toDTO(entity);
        }
        return null;
    }

    
    
}
