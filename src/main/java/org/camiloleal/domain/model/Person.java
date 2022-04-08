package org.camiloleal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private Integer id;
    private String dni;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int age;
    private String city;
    private String idImage;
}
