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

    @Column(name = "DESCRIBE", nullable = false)
    private String describe;

    @Column(name = "COST", nullable = false)
    private Float cost;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "DELIVERYTIME", nullable = false)
    private LocalDateTime deliveryTime;

    @Column(name = "COMPLETED", nullable = false)
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
