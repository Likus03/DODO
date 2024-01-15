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
@Table(name = "USERS")
@NamedQuery(name = "User.allUsers", query = "select w from User w")
public class User {
    @Id
    @Column(name = "ID")
    private Long idUser;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @OneToOne(cascade = {CascadeType.ALL})
    @MapsId
    private Worker worker;

    public User(String login, String password, Worker worker) {
        this.login = login;
        this.password = password;
        this.worker = worker;
    }

}
