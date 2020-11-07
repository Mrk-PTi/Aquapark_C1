package hu.uni.eku.afpc1.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SlideDTO {
    private String slideId;
    private String name;
    private double price;
}