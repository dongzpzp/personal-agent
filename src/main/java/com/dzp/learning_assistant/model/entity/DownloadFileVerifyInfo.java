package com.dzp.learning_assistant.model.entity;

import com.dzp.learning_assistant.enums.OwnerType;
import com.dzp.learning_assistant.enums.VisibilityEnum;
import lombok.Data;

@Data
//用户下载文件时所需要的校验信息
public class DownloadFileVerifyInfo {
    private Long uploadUserId;//上传文件的用户的id
    private OwnerType ownerType;//知识库是否是系统的
    private VisibilityEnum visibilityEnum;//知识库的可见性
    private String filename;//文件原始名称
    private String objectName;//文件在minIO中的对象名
    private String mimeType;//文件的mime类型
}
