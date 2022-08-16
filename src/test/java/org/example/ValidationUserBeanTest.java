package org.example;

import java.util.HashSet;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValidationUserBeanTest {

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    public ValidationUserBeanTest(){

    }



    @Test
    public void testBeanUserWithNoValues() {
        UserBean userBean = new UserBean();

        Set<ConstraintViolation<UserBean>> violations = validator.validate(userBean);
        assertEquals(violations.size(), 3);
    }

    @Test
    public void testBeanUserWithInvalidName() {
        UserBean userBean = new UserBean();
        userBean.setAge(23);
        userBean.setName("Jake123");

        Set<ConstraintViolation<UserBean>> violations = validator.validate(userBean);
        assertEquals(violations.size(), 1);
        assertEquals(
                "BeanUser's First name has invalid characters",
                violations.iterator().next().getMessage());
    }

    @Test
    public void testBeanUserWithLongName() {
        UserBean userBean = new UserBean();
        userBean.setAge(23);
        userBean.setName("JakobHenryNinaTomCruze");

        Set<ConstraintViolation<UserBean>> violations = validator.validate(userBean);
        assertEquals(violations.size(), 1);
        assertEquals(
                "Invalid BeanUser's Name, too many characters",
                violations.iterator().next().getMessage());
    }


    @Test
    public void testBeanUserWithExcessAge() {
        UserBean userBean = new UserBean();
        userBean.setAge(123);
        userBean.setName("Ivan");

        Set<ConstraintViolation<UserBean>> violations = validator.validate(userBean);
        assertEquals(violations.size(), 1);
        assertEquals(
                "BeanUser's Age must be less than 120",
                violations.iterator().next().getMessage());
    }

    @Test
    public void testBeanUserWithNoPositiveAge() {
        UserBean userBean = new UserBean();
        userBean.setAge(0);
        userBean.setName("Ivan");

        Set<ConstraintViolation<UserBean>> violations = validator.validate(userBean);
        assertEquals(violations.size(), 1);
        assertEquals(
                "BeanUser's Age must be positive number",
                violations.iterator().next().getMessage());
    }

}
