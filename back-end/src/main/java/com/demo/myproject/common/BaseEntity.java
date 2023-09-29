package com.demo.myproject.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    private long createBy;
    private long modeBy;
    private LocalDateTime createDate;
    private LocalDateTime modDate;
}
