package com.dzp.learning_assistant.model.vo;

import com.dzp.learning_assistant.enums.OwnerType;
import com.dzp.learning_assistant.enums.VisibilityEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class KnowledgeBaseVO {
    private Long id;
    private String name;
    private String description;
    private OwnerType ownerType;
    private VisibilityEnum visibility;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
