package com.dzp.learning_assistant.model.entity;

import com.dzp.learning_assistant.enums.CoursesTypeEnum;
import com.dzp.learning_assistant.enums.OwnerType;
import com.dzp.learning_assistant.enums.VisibilityEnum;
import lombok.Data;

@Data
public class UploadFileVerifyInfo {
    private Long userId;//知识库所属的课程是谁
    private OwnerType ownerType;//知识库是否是系统的
    private VisibilityEnum visibilityEnum;//知识库的可见性
    private CoursesTypeEnum coursesTypeEnum;//课程是否可操作
}
