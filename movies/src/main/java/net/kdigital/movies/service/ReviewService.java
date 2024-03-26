package net.kdigital.movies.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.kdigital.movies.dto.ReviewDTO;
import net.kdigital.movies.entity.MovieEntity;
import net.kdigital.movies.entity.ReviewEntity;
import net.kdigital.movies.repository.MovieRepository;
import net.kdigital.movies.repository.ReviewRepository;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;

    public ReviewDTO insertReview(ReviewDTO reviewDTO) {
        
        // 리뷰의 부모인 게시글이 존재하는지 확인 !
        Optional<MovieEntity> movieEntity = movieRepository.findById(reviewDTO.getMovieNum());

        if(movieEntity.isPresent()){
            MovieEntity entity = movieEntity.get();
            ReviewEntity reviewEntity = ReviewEntity.toEntity(reviewDTO, entity);

            ReviewDTO resultDTO = ReviewDTO.toDTO(reviewRepository.save(reviewEntity), reviewDTO.getMovieNum());

            return resultDTO;
        } else{
            return null;
        }
    }

    public List<ReviewDTO> reviewAll(Long movieNum) {
        MovieEntity movieEntity = movieRepository.findById(movieNum).get();

        // 부모 엔티티를 넘겨 해당 부모 엔티티에 속한 자식 엔티티들 가져오기
        List<ReviewEntity> reviewEntityList = reviewRepository.findAllByMovieEntityOrderByReviewNumDesc(movieEntity);
        
        List<ReviewDTO> reviewDTOList = new ArrayList<>();
        
        reviewEntityList.forEach((entity) -> reviewDTOList.add(ReviewDTO.toDTO(entity, movieNum)));
        
        return reviewDTOList;
    }


    
}
