package com.example.demo.link;

public class LinkNotFoundException extends Exception {
    public LinkNotFoundException(final String id) {
        super("Link with id " + id + " not found");
    }
}
