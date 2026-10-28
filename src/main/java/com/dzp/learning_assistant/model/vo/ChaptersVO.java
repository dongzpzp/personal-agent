package com.dzp.learning_assistant.model.vo;

import lombok.Data;

@Data
public class ChaptersVO {
    private Long id;
    private Long courseId;
    private String title;
    private Long sortOrder;
}
