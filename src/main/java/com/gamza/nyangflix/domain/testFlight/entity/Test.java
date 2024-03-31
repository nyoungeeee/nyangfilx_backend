package com.gamza.nyangflix.domain.testFlight.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id", nullable = false, unique = true)
    private Long id;

    @Comment("테스트 메모")
    private String memo;

    @Comment("테스트 랭킹")
    private Integer rankNo;
}
