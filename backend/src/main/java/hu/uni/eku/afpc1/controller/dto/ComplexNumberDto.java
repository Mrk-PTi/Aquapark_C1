package hu.uni.eku.afpc1.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ComplexNumberDTO {

    private double real;
    private double imaginary;
}
