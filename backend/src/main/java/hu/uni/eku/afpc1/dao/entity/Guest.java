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
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int guest_id;
    @Column
    private Watch watch;
    @Column
    private Transaction transaction;
    @Column
    private LocalDateTime arrivalDateTime;
}
