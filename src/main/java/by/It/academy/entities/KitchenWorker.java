package by.It.academy.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KitchenWorker {
    private String firstname;
    private String surname;
    private String phoneNumber;
    private String typeEmployee;
}
