package com.devhopes.beautyshop.models;

import com.devhopes.beautyshop.enums.Ratings;
import lombok.*;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(toBuilder = true)
@Embeddable
public class Rating {
    /**
     * The user ratings
     */
    Ratings userRating;
    /**
     * Not more than 5
     */
    Integer starsOutOfFive;

    /**
     * Review comments users has given
     */
    String review;
}
