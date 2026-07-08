package com.paulo.menumaster.exception;

import com.paulo.menumaster.dto.response.ErrorResponseDto;
import com.paulo.menumaster.exception.custom.CepNotReturnedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(CepNotReturnedException.class)
    public ResponseEntity<ErrorResponseDto> cepNotReturnd(CepNotReturnedException e) {
        log.warn("Resource not returned  exception triggred: {}", e.getMessage());
        ErrorResponseDto responseDto = toResponse(HttpStatus.BAD_REQUEST, "CEP NOT  RETURND", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
    }

    private static ErrorResponseDto toResponse(HttpStatus status, String erro, String message) {
        return new ErrorResponseDto(LocalDateTime.now().toString(), status.value(), erro, message);
    }
}
