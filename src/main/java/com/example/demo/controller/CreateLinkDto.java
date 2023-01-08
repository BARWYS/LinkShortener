package com.example.demo.controller;

import com.example.demo.LinkDto;

import java.time.LocalDate;

record CreateLinkDto(String email, String targetUrl, LocalDate expirationDate, String id) {
    public LinkDto toDto() {
        return new LinkDto(id, expirationDate,0,email,targetUrl);
    }
}
