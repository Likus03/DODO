package by.It.academy.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DECRIBE")
    private String describe;

    @Column(name = "COST")
    private Float cost;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "DELIVERYTIME")
    private LocalDateTime deliveryTime;

    @Column(name = "COMPLETED")
    private Boolean completed;
}
