package com.gamza.nyangflix.domain.tag.service;

import com.gamza.nyangflix.domain.tag.repository.TagRepository;
import com.gamza.nyangflix.domain.tag.service.mapper.TagForCatMapper;
import com.gamza.nyangflix.domain.tag.service.model.TagForCatDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TagService {

    final private TagRepository tagRepository;

    public List<TagForCatDto> loadAll() {
        return TagForCatMapper.INSTANCE.toDtoList(tagRepository.findAll());
    }

    public void createOne(String tagName) {
        tagRepository.save(TagForCatMapper.INSTANCE.toTagForCat(tagName));
    }

}
