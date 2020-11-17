package hu.uni.eku.afpc1.dao.entity;

import lombok.*;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @Column
    private Integer guestId;
    @Column
    private LocalDateTime arrivalDateTime;
}
