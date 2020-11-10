package hu.uni.eku.afpc1.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SlideDTO {
    private int slide_id;
    private int slide_expense;
}