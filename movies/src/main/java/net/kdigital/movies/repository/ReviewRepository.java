package net.kdigital.movies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.kdigital.movies.entity.MovieEntity;
import net.kdigital.movies.entity.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long>{

    List<ReviewEntity> findAllByMovieEntityOrderByReviewNumDesc(MovieEntity movieEntity);

}