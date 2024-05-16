package com.gamza.nyangflix.domain.tag.repository;

import com.gamza.nyangflix.domain.tag.entity.TagForCat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagRepository extends JpaRepository<TagForCat, Long> {

    Boolean existsByTagName(String tagName);

    List<TagForCat> findAllByTagNameContaining(String keyword);
}
