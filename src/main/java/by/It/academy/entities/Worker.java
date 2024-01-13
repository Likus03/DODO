package by.It.academy.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "WORKER")
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

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "WORKERTYPE")
    private WorkerType workerType;

    public Worker(String firstname, String surname, String phoneNumber, String login, String password) {
        this.firstname = firstname;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.login = login;
        this.password = password;
    }
//    public Worker(Long idWorker, String firstname, String surname, String phoneNumber, String login, String password, WorkerType workerType) {
//        this.idWorker = idWorker;
//        this.firstname = firstname;
//        this.surname = surname;
//        this.phoneNumber = phoneNumber;
//        this.login = login;
//        this.password = password;
//        this.workerType = workerType;
//    }
}
