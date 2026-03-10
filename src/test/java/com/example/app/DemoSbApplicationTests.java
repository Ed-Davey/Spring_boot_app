package com.example.app;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class DemoSbApplicationUnitTests {
    //This is a start to testing
    //Unit test
    @Test
    void getMessage() {
        String expected = "Hello there!";
        String actual = Message.getMessage();
        assertEquals(expected, actual);
    }
}

@SpringBootTest
@AutoConfigureMockMvc
class DemoSbApplicationIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    //Integration test
    @Test
    void IntegrationTestGetMessage() throws Exception{
        try (MockedStatic<Message> mock = Mockito.mockStatic(Message.class)){
            mock.when(Message::getMessage).thenReturn("Mocked!");
            mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.ALL)).andExpect(status().isOk());
            mock.verify(Message::getMessage);
        }
    }
}

