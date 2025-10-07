package model.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StaffDTO {
    private String name;
    private String age;
    private String id;
    private String phoneNo;
    private String address;
    private String email;
}
