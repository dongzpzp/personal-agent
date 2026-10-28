package com.dzp.learning_assistant.model.entity;

import com.dzp.learning_assistant.enums.KnowledgePointRelationSourceEnum;
import com.dzp.learning_assistant.enums.KnowledgePointRelationStatusEnum;
import com.dzp.learning_assistant.enums.KnowledgePointRelationTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class KnowledgePointRelations {
    private Long id;
    private Long fromPointId;
    private Long toPointId;
    private KnowledgePointRelationTypeEnum relationType;
    private KnowledgePointRelationSourceEnum source;
    private KnowledgePointRelationStatusEnum status;
    private Long createdBy;
    private Long reviewedBy;
    private LocalDateTime reviewedAt;
    private LocalDateTime createdAt;
}
