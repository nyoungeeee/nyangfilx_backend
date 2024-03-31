package com.gamza.nyangflix.domain.tag.repository;

import com.gamza.nyangflix.domain.tag.entity.TagForCat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<TagForCat, Long> {
}
