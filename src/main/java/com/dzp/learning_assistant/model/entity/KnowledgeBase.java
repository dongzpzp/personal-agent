package com.dzp.learning_assistant.model.entity;

import com.dzp.learning_assistant.enums.OwnerType;
import com.dzp.learning_assistant.enums.VisibilityEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class KnowledgeBase {
    private Long id;
    private Long courseId;
    private String name;
    private String description;
    private OwnerType ownerType;
    private VisibilityEnum visibility;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
