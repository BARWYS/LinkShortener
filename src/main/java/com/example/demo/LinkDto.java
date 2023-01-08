package com.example.demo;

import java.time.LocalDate;

record LinkDto(String id, LocalDate expirationDate, int visits, String email, String targetUrl) {
}
