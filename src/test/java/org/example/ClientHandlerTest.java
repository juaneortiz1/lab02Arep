package org.example;


import edu.escuelaing.arep.ASE.app.ClientHandler;
import org.junit.Test;

import java.io.*;
import java.net.Socket;

import static org.junit.Assert.assertTrue;

public class ClientHandlerTest {

    @Test
    public void testHandleGetRequest() throws IOException {
        ByteArrayInputStream input = new ByteArrayInputStream(
                "GET /test.html HTTP/1.1\r\nHost: localhost\r\n\r\n".getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        Socket socket = new Socket() {
            @Override
            public InputStream getInputStream() { return input; }
            @Override
            public OutputStream getOutputStream() { return output; }
        };

        ClientHandler handler = new ClientHandler(socket, "src/main/resources/");
        handler.run();

        String response = output.toString();
        assertTrue(response.contains("HTTP/1.1 200 OK"));
        assertTrue(response.contains("Content-Type: text/html"));
    }
}
