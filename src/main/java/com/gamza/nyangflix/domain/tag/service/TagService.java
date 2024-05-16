package com.gamza.nyangflix.domain.tag.service;

import com.gamza.nyangflix.common.exception.DataNotFoundException;
import com.gamza.nyangflix.domain.tag.repository.TagRepository;
import com.gamza.nyangflix.domain.tag.service.mapper.TagForCatMapper;
import com.gamza.nyangflix.domain.tag.service.model.TagForCatDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TagService {

    final private TagRepository tagRepository;

    public List<TagForCatDto> loadAll() {
        return TagForCatMapper.INSTANCE.toDtoList(tagRepository.findAll());
    }

    public void createOne(String tagName) {
        if (tagRepository.existsByTagName(tagName)) throw new IllegalArgumentException("이미 해당 태그명이 존재합니다.");
        tagRepository.save(TagForCatMapper.INSTANCE.toTagForCat(TagForCatDto.builder().tagName(tagName).build()));
    }

    @Transactional
    public void deleteOne(Long tagId) {
        tagRepository.findById(tagId).orElseThrow(DataNotFoundException::new).delete();
    }

    public TagForCatDto loadOne(Long tagId) {
        return TagForCatMapper.INSTANCE.toDto(tagRepository.findById(tagId).orElseThrow(DataNotFoundException::new));
    }

    @Transactional
    public void update(List<TagForCatDto> tagForCatDtoList) {
        tagForCatDtoList.stream().toList().forEach(tagForCatDto -> {
            tagRepository.findById(tagForCatDto.getTagId()).orElseThrow(DataNotFoundException::new).update(tagForCatDto);
        });
    }

    public List<TagForCatDto> search(String keyword) {
        return tagRepository.findAllByTagNameContaining(keyword).stream().map(TagForCatMapper.INSTANCE::toDto).toList();
    }

}
