package org.example;


import edu.escuelaing.arep.ASE.app.Request;
import edu.escuelaing.arep.ASE.app.Route;
import edu.escuelaing.arep.ASE.app.RouteManager;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RouteManagerTest {

    @Test
    public void testGetRoute() {
        Route testRoute = (request, response) -> "Test Response";
        RouteManager.get("/test", testRoute);
        Route route = RouteManager.getRoute("/test");
        assertNotNull(route);
        assertEquals("Test Response", route.handle(new Request("GET", "/test"), null));
    }
}