package hu.uni.eku.afpc1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guest {
    private Integer guestId;
    private LocalDateTime arrivalDateTime;
}
