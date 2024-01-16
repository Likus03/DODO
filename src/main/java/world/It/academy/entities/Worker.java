package world.It.academy.entities;

import world.It.academy.WorkerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.EnumType.STRING;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "WORKERS")
@NamedQuery(name = "Worker.allWorkers", query = "select w from Worker w")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long idWorker;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "PHONENUMBER")
    private String phoneNumber;

    @Column(name = "WORKERTYPE")
    @Enumerated(STRING)
    private WorkerType workerType;

    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL)
    private List<Order> orders;

    public Worker(String firstname, String surname, String phoneNumber, WorkerType workerType, List<Order> orders) {
        this.firstname = firstname;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.workerType = workerType;
        this.orders = orders;
    }
}
