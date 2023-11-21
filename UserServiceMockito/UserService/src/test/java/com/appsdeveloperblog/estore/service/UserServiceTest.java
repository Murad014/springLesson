package com.appsdeveloperblog.estore.service;

import com.appsdeveloperblog.estore.data.UsersRepository;
import com.appsdeveloperblog.estore.exceptions.UserServiceException;
import com.appsdeveloperblog.estore.model.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
//import org.testng.annotations.Test;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UsersRepository usersRepository;


    String firstName;
    String lastName;
    String email;
    String password;
    String repeatPassword;



    @BeforeEach
    void init(){
        firstName = "Sergey";
        lastName = "Karga";
        email = "test@test.com";
        password = "123456789";
        repeatPassword = "123456789";

    }

    @Test
    @DisplayName("User object created.")
    void testCreateUser_whenUserDetailsProvided_returnsUserObject(){
        // Arrange
        Mockito.lenient().when(usersRepository.save(Mockito.any(User.class)))
                .thenReturn(true);

        // Act
        User user = userService.createUser(firstName,
                lastName,
                email,
                password,
                repeatPassword);

        // Assert
        assertNotNull(user, "The createUser() should not have returned null");
        assertEquals(firstName, user.getFirstName(), "User's first name is incorrect.");
        assertEquals(lastName, user.getLastname(), "User's last name is incorrect.");
        assertEquals(email, user.getEmail(), "User's email is incorrect.");
        assertNotNull(user.getId(), "User id is missing.");
        Mockito.verify(usersRepository, Mockito.times(1)).save(Mockito.any(User.class));
    }

    @DisplayName("If save() method causes RuntimeException, a UserServiceException is throwm.")
    @Test
    void testCreateUser_whenSaveMethodThrowsException_thenThrowsUserServiceException(){
        Mockito.when(usersRepository.save(Mockito.any(User.class))).thenThrow(RuntimeException.class);
        assertThrows(UserServiceException.class, () -> {
            userService.createUser(firstName, lastName, email,password, repeatPassword);
        }, "Exception expected.");

    }




//    @Test
//    void testCreateUser_whenUserDetailsProvided_returnUserObject(){
//        // Arrange
//        UserService userService = new UserServiceImpl();
//        String firstName = "Sergey";
//        String lastName = "Karga";
//        String email = "test@test.com";
//        String password = "123456789";
//        String repeatPassword = "123456789";
//
//        // Act
//        User user = userService.createUser(firstName, lastName, email, password, repeatPassword);
//
//
//        // Assert
//        assertNotNull(user, "The createUser() should not have returned null");
//    }
//
//    @Test
//    void testCreateUser_whenUserCreated_returnedUserObjectContainsSameFirstName(){
//        // Arrange
//        UserService userService = new UserServiceImpl();
//        String firstName = "Sergey";
//        String lastName = "Karga";
//        String email = "test@test.com";
//        String password = "123456789";
//        String repeatPassword = "123456789";
//        // Act
//        User user = userService.createUser(firstName, lastName, email, password, repeatPassword);
//
//        // Assert
//        assertEquals(firstName, user.getFirstName());
//    }
//



}
