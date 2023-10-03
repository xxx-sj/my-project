package com.demo.myproject.dto.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString(of = {"data"})
@Getter
@AllArgsConstructor
public class Result<T> {

    private T data;
}
