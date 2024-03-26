package net.kdigital.movies.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.kdigital.movies.entity.ReviewEntity;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class ReviewDTO {
    private Long reiviewNum;
    private Long movieNum;
    private String userId;
    private String reviewContent;
    private LocalDate createDate;

    public static ReviewDTO toDTO(ReviewEntity reviewEntity, Long movieNum){
        return ReviewDTO.builder()
                .reiviewNum(reviewEntity.getReviewNum())
                .movieNum(movieNum)
                .userId(reviewEntity.getUserId())
                .reviewContent(reviewEntity.getReviewContent())
                .createDate(reviewEntity.getCreateDate())
                .build();
    }
}
