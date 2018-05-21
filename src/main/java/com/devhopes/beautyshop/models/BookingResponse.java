package com.devhopes.beautyshop.models;

import com.devhopes.beautyshop.enums.Booking_Status;
import com.devhopes.beautyshop.enums.Remarks_String;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
public class BookingResponse {

    /**
     * Unique id of the booking response
     */
    @NonNull
    @Id
    String id;

    /**
     * The id of the booking
     */
    @NonNull
    String bookingId;

    /**
     * Status of the booking made
     */
    @NonNull
    String bookingStatus;

    /**
     * Reasons or remarks if any
     */
    String remarks;

    public static BookingResponse build(String bookingId, Booking_Status bookingStatus, Remarks_String remarks) {
        return BookingResponse.builder()
                .id(UUID.randomUUID().toString())
                .bookingId(bookingId)
                .bookingStatus(bookingStatus.value)
                .remarks(remarks.value)
                .build();
    }

}
