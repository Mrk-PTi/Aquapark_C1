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
    private int guest_id;
    private LocalDateTime arrivalDateTime;
}
