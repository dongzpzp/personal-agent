package com.dzp.learning_assistant.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@Data
@AllArgsConstructor
public class DocumentDownload {
    private String filename;
    private String mimeType;
    private StreamingResponseBody responseBody;
}
