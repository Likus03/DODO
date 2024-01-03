package by.It.academy.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Worker {
    private Long idWorker;
    private String firstname;
    private String surname;
    private String phoneNumber;
    private String login;
    private String password;
    private WorkerType workerType;
}
