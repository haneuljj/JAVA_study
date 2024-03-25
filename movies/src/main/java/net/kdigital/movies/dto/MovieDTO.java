package net.kdigital.movies.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.kdigital.movies.entity.MovieEntity;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class MovieDTO {
    private Long movieNum;
    private String movieTitle;
    private String movieDirector;
    private String movieGenre;
    private LocalDate releaseDate;
    private String photoUrl;

    public static MovieDTO toDTO(MovieEntity movieEntity){
        return MovieDTO.builder()
                .movieNum(movieEntity.getMovieNum())
                .movieTitle(movieEntity.getMovieTitle())
                .movieDirector(movieEntity.getMovieDirector())
                .movieGenre(movieEntity.getMovieGenre())
                .releaseDate(movieEntity.getReleaseDate())
                .photoUrl(movieEntity.getPhotoUrl())
                .build();
    }

}
