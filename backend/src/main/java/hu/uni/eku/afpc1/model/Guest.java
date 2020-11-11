package hu.uni.eku.afpc1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guest {
    private int guest_id;
    //private Watch watch;
    //private Pay pay;
    private LocalDateTime arrivalDateTime;
}
