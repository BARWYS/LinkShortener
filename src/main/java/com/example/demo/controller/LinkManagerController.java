package com.example.demo.controller;

import com.example.demo.LinkDto;
import com.example.demo.link.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/links")
class LinkManagerController {
    private final LinkService linkService;

    LinkManagerController(final LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    LinkDto createLink(@RequestBody CreateLinkDto link) {
        return linkService.createLink(link.toDto());

    }


}

