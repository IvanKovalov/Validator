package org.example;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import javax.persistence.*;

@Entity
@Table
public class UserEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id")
    private int id;
    @Column (name = "NAME")
    private String name;

    @Column(name = "age")
    private int age;


    public UserEntity() {
    }

    public UserEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @NotNull(message = "EntityUser's id must be not null")
    @Min(value = 0, message = "EntityUser's id must be > 0")
    @Positive(message = "EntityUser's id must be positive number")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @NotBlank(message = "EntityUser's Name must ne mot empty")
    @Pattern(regexp = "[a-z-A-Z]*", message = "EntityUser's First name has invalid characters")
    @Length(min = 1,max = 20,message = "Invalid EntityUser's Name, too many characters")
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    @NotNull(message = "EntityUser's Age must be not null")
    @Min(value = 0, message = "EntityUser's Age must be > 0")
    @Max(value = 120, message = "EntityUser's Age must be less than 120")
    @Positive(message = "EntityUser's Age must be positive number")
    public int getAge(){
        return age;
    }


    @Override
    public String toString() {
        return "EntityUser:\n" +
                "id: " + id +
                "\nFirst Name: " + name + "\n" ;
    }

    @Override
    public int hashCode() {
        return 12345;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        return o.equals(this.id);
    }


}
