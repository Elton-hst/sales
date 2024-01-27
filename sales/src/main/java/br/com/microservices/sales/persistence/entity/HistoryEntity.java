package br.com.microservices.sales.persistence.entity;

import br.com.microservices.sales.application.common.CommonHistory;
import br.com.microservices.sales.persistence.entity.basic.BasicEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@SuperBuilder
@NoArgsConstructor
public class HistoryEntity extends BasicEntity{

    private String source;
    private String status;
    private String message;
    private LocalDateTime createdAt;

    public CommonHistory toHistory() {
        return CommonHistory.builder()
                .source(source)
                .status(status)
                .message(message)
                .createdAt(createdAt)
                .build();
    }

}
