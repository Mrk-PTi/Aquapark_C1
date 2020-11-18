package hu.uni.eku.afpc1.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuestCreateRequestDTO {
    private String guestName;
    private Integer watchId;
    private Integer payId;
    private LocalDateTime arrivalDateTime;
}
