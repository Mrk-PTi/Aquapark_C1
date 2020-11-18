package hu.uni.eku.afpc1.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GuestDTO {
    private String guestName;
    private Integer watchId;
    private Integer payId;
    private LocalDateTime arrivalDateTime;
}
