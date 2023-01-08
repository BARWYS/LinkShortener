package com.example.demo.link;

import com.example.demo.LinkDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;


@Component
class LinkServiceImpl implements LinkService {

    private final LinkRepository linkRepository;

    LinkServiceImpl(final LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }


    @Override
    public LinkDto createLink(final LinkDto toDto) {
        linkRepository.save(LinkEntity.fromDto(toDto));
        return toDto;
    }

    @Transactional
    @Override
    public LinkDto getLinkAndIncrementVisits(final String id) throws LinkNotFoundException {
        final LinkEntity linkEntity = linkRepository.findById(id).orElseThrow(() -> new LinkNotFoundException(id));
        linkEntity.setVisits(linkEntity.getVisits() + 1);
        return linkEntity.toDto();
    }
}
