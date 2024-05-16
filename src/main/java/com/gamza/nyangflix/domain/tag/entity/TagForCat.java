package com.gamza.nyangflix.domain.tag.entity;

import com.gamza.nyangflix.domain.tag.service.model.TagForCatDto;
import com.gamza.nyangflix.global.entity.TimeAttr;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tag_for_cat")
@Where(clause = "delete_date IS NULL")
@AllArgsConstructor
public class TagForCat extends TimeAttr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "태그명")
    private String tagName;

    public void update(TagForCatDto tagForCatDto) {
        this.id = tagForCatDto.getTagId();
        this.tagName = tagForCatDto.getTagName();
    }

    public void delete() {
        this.setDeleteDate(LocalDateTime.now());
    }

}
