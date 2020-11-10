package hu.uni.eku.afpc1.dao.entity;

import lombok.*;
import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Slide {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Coloumn
    private String slideId;
    @Coloumn
    private String name;
    @Coloumn
    private double price;
}
