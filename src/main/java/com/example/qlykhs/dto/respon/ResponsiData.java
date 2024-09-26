package com.example.qlykhs.dto.respon;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponsiData<T> {
    private String status;
    private String message;
    private T data;

    public ResponsiData(T data) {
        this.data = data;
    }
}
