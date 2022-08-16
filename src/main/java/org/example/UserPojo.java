package org.example;
import javax.validation.constraints.*;

public class UserPojo {
    private int age;
    private String name;
    UserPojo(){
    }


    public void setAge(int age){
        this.age = age;
    }


    public void setName(String name){
        this.name = name;
    }

    @NotNull(message = "PojoUser's Age must be not null")
    @Min(value = 0, message = "PojoUser's Age must be > 0")
    @Max(value = 120, message = "PojoUser's Age must be less than 120")
    @Positive(message = "PojoUser's Age must be positive number")
    public int getUserAge(){
        return this.age;
    }

    @NotBlank(message = "PojoUser's Name must ne mot empty")
    @Pattern(regexp = "[a-z-A-Z]*", message = "PojoUser's First name has invalid characters")
    @Name
    public String getAge (){
        return this.name;
    }
}
