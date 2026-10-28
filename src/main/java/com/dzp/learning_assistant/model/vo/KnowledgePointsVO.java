package com.dzp.learning_assistant.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class KnowledgePointsVO {
    private Long id;
    private String name;
    private Long sortOrder;
    private String description;
    private Long createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
