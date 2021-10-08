package br.com.globallabs.springwebmvc.exception;

public class JediNotFoundException extends RuntimeException {
    public JediNotFoundException() {
        super("Jedi not found");
    }
}
