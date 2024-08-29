package edu.escuelaing.arep.ASE.app;

@FunctionalInterface
public interface Route {
    String handle(Request request, Response response);
}
