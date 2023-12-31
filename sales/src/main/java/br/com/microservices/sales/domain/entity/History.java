package br.com.microservices.sales.domain.entity;

import java.time.LocalDateTime;

public interface History {

    String getSource();
    String getStatus();
    String getMessage();
    LocalDateTime getCreateAt();

}
