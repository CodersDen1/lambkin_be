package com.example.lambkin_be.commons.dtos;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
private String message;
}
