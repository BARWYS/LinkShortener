package com.example.demo.link;

import com.example.demo.LinkDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
class LinkEntity {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private String id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String targetUrl;

    private LocalDate expirationDate;

    private int visits;

    static LinkEntity fromDto(LinkDto link) {
        return new LinkEntity(
                link.id(),
                link.email(),
                link.targetUrl(),
                link.expirationDate(),
                link.visits()
        );
    }

    LinkDto toDto() {
        return new LinkDto(id, expirationDate, visits,email,targetUrl);
    }


}
