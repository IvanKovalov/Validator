package org.example;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.io.Serializable;

public class UserBean implements Serializable {
    private String name;
    private int age;

    public UserBean(){
        this.name = "";
        this.age = 0;
    }

    public UserBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName (String name){
        this.name = name;
    }

    public void setAge (int age){
        this.age = age;
    }

    @NotBlank(message = "BeanUser's Name must ne mot empty")
    @Pattern(regexp = "[a-z-A-Z]*", message = "BeanUser's First name has invalid characters")
    @Length(min = 1,max = 20,message = "Invalid BeanUser's Name, too many characters")
    public String getName (){
        return this.name;
    }

    @NotNull(message = "BeanUser's Age must be not null")
    @Min(value = 0, message = "BeanUser's Age must be > 0")
    @Max(value = 120, message = "BeanUser's Age must be less than 120")
    @Positive(message = "BeanUser's Age must be positive number")
    public int getAge () {
        return this.age;
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
        return o.equals(this);
    }

}
