package net.kdigital.movies.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.kdigital.movies.dto.MovieDTO;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder

@Entity
@Table(name = "movie")
public class MovieEntity {
    @SequenceGenerator(
        name = "movie_seq"
        , sequenceName = "movie_seq"
        , initialValue = 1
        , allocationSize = 1
    )
    @Id
    @GeneratedValue(generator = "movie_seq")
    @Column(name = "movie_num")
    private Long movieNum;

    @Column(name = "movie_title", nullable = false)
    private String movieTitle;

    @Column(name = "movie_director", nullable = false)
    private String movieDirector;

    @Column(name = "movie_genre", nullable = false)
    private String movieGenre;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "photo_url")
    private String photoUrl;

    public static MovieEntity toEntity(MovieDTO movieDTO){
        return MovieEntity.builder()
                .movieNum(movieDTO.getMovieNum())
                .movieTitle(movieDTO.getMovieTitle())
                .movieDirector(movieDTO.getMovieDirector())
                .movieGenre(movieDTO.getMovieGenre())
                .releaseDate(movieDTO.getReleaseDate())
                .photoUrl(movieDTO.getPhotoUrl())
                .build();
    }
}
