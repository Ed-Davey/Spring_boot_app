package com.example.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MessageUnitTest {
    //This is a start to testing
    //Unit test
    @Test
    void getMessage() {
        String expected = "Hello there!";
        String actual = Message.getMessage();
        assertEquals(expected, actual);
    }
}