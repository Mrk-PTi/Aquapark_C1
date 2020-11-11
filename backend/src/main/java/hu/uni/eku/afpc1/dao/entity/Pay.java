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
public class Pay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @Column
    private int pay_id;
}