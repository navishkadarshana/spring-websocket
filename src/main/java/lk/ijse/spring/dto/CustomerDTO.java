package lk.ijse.spring.dto;


import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class CustomerDTO {

    private String id;
    private String name;
    private String address;
    private double salary;

}
