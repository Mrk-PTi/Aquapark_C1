package hu.uni.eku.afpc1.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GuestDTO {
    private int ID;
    private WatchDTO watch;
    private TransactionDTO transaction;
    private LocalDateTime arrivalDateTime;
}