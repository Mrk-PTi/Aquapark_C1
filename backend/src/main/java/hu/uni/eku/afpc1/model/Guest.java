package hu.uni.eku.afpc1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guest {
    private int guest_id;
    private Watch watch;
    private Transaction transaction;
    private LocalDateTime arrivalDateTime;
}
