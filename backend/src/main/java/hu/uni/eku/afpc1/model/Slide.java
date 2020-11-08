package hu.uni.eku.afpc1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComplexNumber {

    private String slideId;
    private String name;
    private double price;

}