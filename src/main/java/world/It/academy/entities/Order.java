package world.It.academy.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(name = "DESCRIBE")
    private String describe;

    @Column(name = "COST")
    private Float cost;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "DELIVERYTIME")
    private LocalDateTime deliveryTime;

    @Column(name = "COMPLETED")
    private Boolean completed;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    public Order(String describe, Float cost, String address, LocalDateTime deliveryTime, Boolean completed, Worker worker) {
        this.describe = describe;
        this.cost = cost;
        this.address = address;
        this.deliveryTime = deliveryTime;
        this.completed = completed;
        this.worker = worker;
    }
}
