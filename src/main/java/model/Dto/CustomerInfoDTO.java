package model.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerInfoDTO {
    private String name;
    private String age;
    private String id;
    private String phoneNo;
    private String address;
    private String email;
}
