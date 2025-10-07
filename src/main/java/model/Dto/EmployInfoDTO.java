package model.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployInfoDTO {
    private String name ;
    private String age;
    private String id;
    private String phoneNo;
    private String address;
    private double Salary;
}
