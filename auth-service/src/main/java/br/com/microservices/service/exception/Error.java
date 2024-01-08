package br.com.microservices.service.exception;

import java.time.LocalDateTime;

public record Error(String menssage, int status, LocalDateTime timeTemp, String path) {
}
