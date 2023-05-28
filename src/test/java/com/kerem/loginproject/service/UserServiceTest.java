package com.kerem.loginproject.service;

import com.kerem.loginproject.model.User;
import com.kerem.loginproject.repository.RoleRepository;
import com.kerem.loginproject.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceTest {

    private UserService userService;
    private User user;
    @Mock
    private UserRepository userRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Before
    public void setUp(){
        initMocks(this);
        userService = new UserService(userRepository, roleRepository, bCryptPasswordEncoder);
        user = User.builder()
                .id(1)
                .email("test@test.com")
                .firstName("kerem")
                .lastName("doe")
                .build();

        Mockito.when(userRepository.save(any()))
                .thenReturn(user);
        Mockito.when(userRepository.findByEmail(anyString()))
                .thenReturn(user);
    }
    @Test
    public void testFindUserByEmail() {
        // Setup
        final String email = "test@test.com";

        // Run the test
        final User result = userService.findUserByEmail(email);

        // Verify the results
        assertEquals(email, result.getEmail());
    }
    @Test
    public void testSaveUser() {
        // Setup
        final String email = "test@test.com";

        // Run the test
        User result = userService.saveUser(User.builder().build());

        // Verify the results
        assertEquals(email, result.getEmail());
    }

}
