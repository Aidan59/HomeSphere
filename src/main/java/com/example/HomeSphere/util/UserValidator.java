package com.example.HomeSphere.util;

import com.example.HomeSphere.models.User;
import com.example.HomeSphere.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Service
public class UserValidator implements Validator {

    UserRepository userRepository;

    @Autowired
    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        Optional<User> userOptional = userRepository.findById(user.getId());
        if (userOptional.isPresent()) {
                errors.rejectValue("username", "", "User id already exists");
        }
    }
}
