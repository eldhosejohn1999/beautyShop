package com.devhopes.beautyshop.models;

import com.devhopes.beautyshop.enums.Ratings;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(toBuilder = true)
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
