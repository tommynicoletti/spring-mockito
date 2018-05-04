package com.baeldung;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @InjectMocks
    private UserService userService;
    @Mock
    private NameService nameService;

    @Test
    public void getUserSurname_ShouldCompile_WhenIdIsGiven() {
        //Mockito.when(nameService.getSurname("SomeId")).thenReturn("Mock surname value");
        // per il naming: https://dzone.com/articles/7-popular-unit-test-naming
        String testName = userService.getUserSurname("SomeId");
        verify(nameService).getSurname("SomeId");
    }

    @Test
    public void getUserAge_ShouldNotInvokeNameService_WhenIdIsGiven() {
        // per il naming: https://dzone.com/articles/7-popular-unit-test-naming
        int age = userService.getUserAge("SomeId");
        verifyNoMoreInteractions(nameService);
    }
}
