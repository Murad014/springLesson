package com.appsdeveloperblog.estore.service;

import com.appsdeveloperblog.estore.exceptions.UserServiceException;
import com.appsdeveloperblog.estore.data.UsersRepository;
import com.appsdeveloperblog.estore.model.User;

public class UserServiceImpl implements UserService {
    UsersRepository usersRepository;

    public UserServiceImpl(UsersRepository usersRepository){
        this.usersRepository = usersRepository;

    }
    @Override
    public User createUser(String firstName, String lastName, String email, String password, String repeatPassword) {
        if(firstName == null || firstName.trim().length() == 0)
            throw new IllegalArgumentException("User's first name is empty");
        if(lastName == null || lastName.trim().length() == 0)
            throw new IllegalArgumentException("User's last name is empty");

        User user = new User(firstName, lastName, email, password, repeatPassword, "1");
        boolean isUserCreated = false;

        try {
            isUserCreated = usersRepository.save(user);
        }catch (RuntimeException exp){
            throw new UserServiceException(exp.getMessage());
        }


        if(!isUserCreated)
            throw new UserServiceException("Could not create user");

        return user;
    }


}
