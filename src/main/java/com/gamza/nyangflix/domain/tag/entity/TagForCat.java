package com.gamza.nyangflix.domain.tag.entity;

import com.gamza.nyangflix.global.entity.TimeAttr;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

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

}
