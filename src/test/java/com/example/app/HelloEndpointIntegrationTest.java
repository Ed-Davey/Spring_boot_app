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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloEndpointIntegrationTest {
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