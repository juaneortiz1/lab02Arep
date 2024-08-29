package org.example;

import edu.escuelaing.arep.ASE.app.Request;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class RequestTest {

    @Test
    public void testAddQueryParam() {
        Request request = new Request("GET", "/test");
        request.addQueryParam("key1", "value1");
        assertEquals("value1", request.getValues("key1"));
    }

    @Test
    public void testGetValues() {
        Request request = new Request("GET", "/test");
        request.addQueryParam("key2", "value2");
        assertEquals("value2", request.getValues("key2"));
    }
}
