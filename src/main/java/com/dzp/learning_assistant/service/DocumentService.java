package com.dzp.learning_assistant.service;

import com.dzp.learning_assistant.model.vo.DocumentDownload;
import com.dzp.learning_assistant.model.vo.DocumentVO;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {
    DocumentVO uploadDocument(MultipartFile file, Long kbId, String uploadRequestId);

    /**
     * 校验下载权限并准备文件流及响应元数据。
     */
    DocumentDownload prepareDownload(Long documentId);
}
