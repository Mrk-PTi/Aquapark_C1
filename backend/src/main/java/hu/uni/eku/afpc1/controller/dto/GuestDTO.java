package hu.uni.eku.afpc1.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GuestDTO {
    private Integer guestId;
    private LocalDateTime arrivalDateTime;
}
