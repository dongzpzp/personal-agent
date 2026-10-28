package com.dzp.learning_assistant.model.vo;

import com.dzp.learning_assistant.enums.KnowledgePointRelationSourceEnum;
import com.dzp.learning_assistant.enums.KnowledgePointRelationStatusEnum;
import com.dzp.learning_assistant.enums.KnowledgePointRelationTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class KnowledgePointRelationsVO {
    private Long id;
    private Long fromPointId;
    private Long toPointId;
    private KnowledgePointRelationTypeEnum relationType;
    private KnowledgePointRelationStatusEnum status;
    private KnowledgePointRelationSourceEnum source;
    private LocalDateTime createdAt;
}
