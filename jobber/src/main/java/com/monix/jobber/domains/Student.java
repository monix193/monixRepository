package com.monix.jobber.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Student {
    
    public Student(int i, String string) {
	}
	private Long id;
    private String name;

}