package com.example.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageGeneratorUnitTest {
    @Test
    void testGeneratedMessageMorning() throws Exception {
        IHttpLib httpLib = new MockHttpLib(9);
        MessageGenerator generator = new MessageGenerator(httpLib);
        String msg = generator.generateMessage("http://localhost:9000/?personName=Mark");
        assertEquals("Morning message received: 'Good morning Mark'", msg);
    }

    @Test
    void testGeneratedMessageAfternoon() throws Exception {
        IHttpLib httpLib = new MockHttpLib(14);
        MessageGenerator generator = new MessageGenerator(httpLib);
        String msg = generator.generateMessage("http://localhost:9000/?personName=Mark");
        assertEquals("Afternoon message received: 'Good afternoon Mark'", msg);
    }

    @Test
    void testGeneratedMessageEvening() throws Exception {
        IHttpLib httpLib = new MockHttpLib(21);
        MessageGenerator generator = new MessageGenerator(httpLib);
        String msg = generator.generateMessage("http://localhost:9000/?personName=Mark");
        assertEquals("Out of hours message received - look in the morning", msg);
    }
}