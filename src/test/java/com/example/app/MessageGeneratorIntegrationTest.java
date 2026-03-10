package com.example.app;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;

@Disabled("Requires local server on port 9000")
class MessageGeneratorIntegrationTest {

    @Test
    void testGeneratedMessage() throws Exception {
        IHttpLib httpLib = new HttpLib();
        MessageGenerator generator = new MessageGenerator(httpLib);

        String msg = generator.generateMessage("http://localhost:9000/?personName=Amir");
        int hours = LocalDateTime.now().getHour();

        if (hours < 12) {
            assertEquals("Morning message received: 'Good morning Amir'", msg);
        } else if (hours < 18) {
            assertEquals("Afternoon message received: 'Good afternoon Amir'", msg);
        } else {
            assertEquals("Out of hours message received - look in the morning", msg);
        }
    }
}