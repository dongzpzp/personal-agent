package com.dzp.learning_assistant.model.entity;

import com.dzp.learning_assistant.enums.DocumentTaskStatus;
import lombok.Data;

import java.time.LocalDateTime;

// 文档处理任务实体，对应 document_tasks 表。
@Data
public class DocumentTask {
    private Long id;
    private Long documentId;
    private Long userId;
    private String taskType;
    private DocumentTaskStatus status;
    private Integer retryCount;
    private Integer maxRetries;
    private String errorMessage;
    private LocalDateTime startedAt;
    private LocalDateTime completedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
