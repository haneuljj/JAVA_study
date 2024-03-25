package net.kdigital.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.kdigital.movies.entity.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity, Long>{
    
}
