package org.example;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class UserDTO {

    @NotNull(message = "DTOUser's Age must be not null")
    @Min(value = 0, message = "DTOUser's Age must be > 0")
    @Max(value = 120, message = "DTOUser's Age must be less than 120")
    @Positive(message = "DTOUser's Age must be positive number")
    private int age;

    @NotBlank(message = "DTOUser's Name must ne mot empty")
    @Pattern(regexp = "[a-z-A-Z]*", message = "DTOUser's First name has invalid characters")
    @Name
    private String name;
}
