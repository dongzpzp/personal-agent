package com.dzp.learning_assistant.model.entity;

import com.dzp.learning_assistant.enums.DocumentEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Documents {
    private Long id;
    private Long kbId;
    private String filename;
    private String objectName;
    private String uploadRequestId;
    private DocumentEnum status;
    private Integer chunkCount;
    private String parseError;
    private Long fileSize;
    private String mimeType;
    private Long uploadUserId;
    private LocalDateTime deletedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
