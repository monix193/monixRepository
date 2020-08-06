package com.monix.jobber.domains;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Student {
    
    private Long id;
    private String name;

}