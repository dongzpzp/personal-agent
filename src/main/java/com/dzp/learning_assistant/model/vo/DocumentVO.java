package com.dzp.learning_assistant.model.vo;

import com.dzp.learning_assistant.enums.DocumentEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DocumentVO {
    private Long id;
    private String filename;
    private String objectName;
    private Long fileSize;
    private DocumentEnum status;
    private Integer chunkCount;
    private String parseError;
    private String mimeType;
    private LocalDateTime updatedAt;
}
