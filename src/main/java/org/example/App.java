package org.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;


public class App 
{
    static final Logger logger = LoggerFactory.getLogger(org.example.App.class.getName());
    public static void main( String[] args )
    {

        UserPojo user = new UserPojo();
        logger.info("Created PojoUser");

        user.setName("Ivan");
        user.setAge(18);

        UserBean userBean = new UserBean();
        logger.info("Created BeanUser");

        userBean.setAge(20);
        userBean.setName("Mike");

        UserDTO userDTO = new UserDTO();
        logger.info("Created DTOUser");

        userDTO.setAge(50);
        userDTO.setName("Ruslan");

        UserEntity userEntity = new UserEntity();
        userEntity.setAge(23);
        userEntity.setName("Anna");
        userEntity.setId(12);

       ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<UserPojo>> violations = validator.validate(user);
        for (ConstraintViolation<UserPojo> violation : violations) {
            logger.error(violation.getMessage());
        }
        logger.info("Checked PojoUser");

        Set<ConstraintViolation<UserBean>> violationsBean = validator.validate(userBean);
        for (ConstraintViolation<UserBean> violation : violationsBean) {
            logger.error(violation.getMessage());
        }
        logger.info("Checked BeanUser");

        Set<ConstraintViolation<UserDTO>> violationsDTO = validator.validate(userDTO);
        for (ConstraintViolation<UserDTO> violation : violationsDTO) {
            logger.error(violation.getMessage());
        }
        logger.info("Checked DTOUser");

        Set<ConstraintViolation<UserEntity>> violationsEntity = validator.validate(userEntity);
        for (ConstraintViolation<UserEntity> violation : violationsEntity) {
            logger.error(violation.getMessage());
        }
        logger.info("Checked EntityUser");
    }
}
