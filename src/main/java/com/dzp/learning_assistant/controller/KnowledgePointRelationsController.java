package com.dzp.learning_assistant.controller;

import com.dzp.learning_assistant.annotation.AdminAnnotation;
import com.dzp.learning_assistant.model.dto.KnowledgePointRelationsDTO;
import com.dzp.learning_assistant.model.vo.KnowledgePointRelationsVO;
import com.dzp.learning_assistant.model.vo.Result;
import com.dzp.learning_assistant.service.KnowledgePointRelationsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/knowledgePointRelations")
@RequiredArgsConstructor
@Validated
@Tag(name = "知识点关系接口")
public class KnowledgePointRelationsController {
    private final KnowledgePointRelationsService knowledgePointRelationsService;

    @PostMapping("/createKnowledgePointRelations")
    @Operation(summary = "创建知识点关系")
    public Result<KnowledgePointRelationsVO> createRelations(
            @Valid @RequestBody KnowledgePointRelationsDTO relationDTO) {
        // 调用知识点关系服务，创建一批关系并返回创建结果。
        return Result.success(knowledgePointRelationsService.createRelations(relationDTO));
    }

    @DeleteMapping("/deleteKnowledgePointRelations/{ids}")
    @Operation(summary = "删除知识点关系")
    @AdminAnnotation
    public Result<Void> deleteRelationsByIds(
            @PathVariable List<@Positive(message = "知识点关系 ID 必须大于 0") Long> ids) {
        // 调用知识点关系服务，根据关系 ID 列表批量删除。
        knowledgePointRelationsService.deleteRelationsByIds(ids);
        return Result.success();
    }

    //TODO 管理员审核知识点关系
}
