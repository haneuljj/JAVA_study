package net.kdigital.movies.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.kdigital.movies.dto.ReviewDTO;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder

@Entity
@Table(name = "review")
public class ReviewEntity {
    @SequenceGenerator(
        name = "review_seq"
        , sequenceName = "review_seq"
        , allocationSize = 1
        , initialValue = 1
    )
    @Id
    @GeneratedValue(generator = "review_seq")
    @Column(name = "review_num")
    private Long reviewNum;

    @Column(name = "userid", nullable = false)
    private String userId;

    @Column(name = "review_content", nullable = false)
    private String reviewContent;

    @Column(name = "create_date")
    @CreationTimestamp // 자동으로 날짜 세팅
    private LocalDate createDate;

    /* MovieEntity와의 관계 설정 */
    // 1:m  =>  movieEntity : ReviewEntity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_num")
    private MovieEntity movieEntity;

    // DTO --> Entity
    public static ReviewEntity toEntity(ReviewDTO reviewDTO, MovieEntity movieEntity){
        return ReviewEntity.builder()
                .reviewNum(reviewDTO.getReiviewNum())
                .userId(reviewDTO.getUserId())
                .reviewContent(reviewDTO.getReviewContent())
                .movieEntity(movieEntity)
                .build();
    }
}
