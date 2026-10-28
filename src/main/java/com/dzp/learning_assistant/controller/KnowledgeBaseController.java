package com.dzp.learning_assistant.controller;

import com.dzp.learning_assistant.model.dto.KnowledgeBaseDTO;
import com.dzp.learning_assistant.model.vo.KnowledgeBaseVO;
import com.dzp.learning_assistant.model.vo.Result;
import com.dzp.learning_assistant.service.KnowledgeBaseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/knowledgeBase")
@Tag(name = "知识库管理")
@AllArgsConstructor
public class KnowledgeBaseController {
    private final KnowledgeBaseService knowledgeBaseService;
    //添加知识库
    @PostMapping("/add")
    public Result<KnowledgeBaseVO> addKnowledgeBase(@Valid @NotNull @RequestBody
                                                    KnowledgeBaseDTO knowledgeBaseDTO) {
        return Result.success(knowledgeBaseService.addKnowledgeBase(knowledgeBaseDTO));
    }
}
