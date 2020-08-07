package com.monix.jobber.domains;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Student {

	private Long id;
    private String name;

    public Student() {
    }

    public Student(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

   
    @Override
    public boolean equals(final Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Student)) {
            return false;
        }
        final Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }


}
