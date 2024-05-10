package com.gamza.nyangflix.global.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class TimeAttr {

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime updateDate;

    @Setter
    @JsonIgnore
    private LocalDateTime deleteDate;

}
