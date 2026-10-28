package com.dzp.learning_assistant.controller;

import com.dzp.learning_assistant.exception.DataIllegalException;
import com.dzp.learning_assistant.model.dto.ActivateLearningPlanDraftDTO;
import com.dzp.learning_assistant.model.dto.LearningPlanDraftDTO;
import com.dzp.learning_assistant.model.dto.UpdateLearningPlanDraftRequest;
import com.dzp.learning_assistant.model.vo.LearningPlanDraftVO;
import com.dzp.learning_assistant.model.vo.Result;
import com.dzp.learning_assistant.service.LearningPlanDraftService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 提供学习计划草案的手动入口；接口和 Agent 最终共用同一份草案数据。
@RestController
@RequestMapping("/learning-agent/learning-plans/drafts")
@RequiredArgsConstructor
@Tag(name = "学习计划草案")
public class LearningPlanDraftController {
    private final LearningPlanDraftService service;

    // 手动创建草案；来源固定为 MANUAL，不能由请求体伪造。
    @PostMapping
    @Operation(summary = "创建学习计划草案")
    public Result<LearningPlanDraftVO> create(@Valid @RequestBody LearningPlanDraftDTO request) {
        return Result.success(service.createManual(request));
    }

    // 返回当前登录用户的全部未生效草案。
    @GetMapping
    @Operation(summary = "查看学习计划草案列表")
    public Result<List<LearningPlanDraftVO>> list() {
        return Result.success(service.listCurrentUser());
    }

    // 返回一份草案的主体和完整步骤。
    @GetMapping("/{draftRef}")
    @Operation(summary = "查看学习计划草案")
    public Result<LearningPlanDraftVO> get(@PathVariable String draftRef) {
        return Result.success(service.getCurrentUserDraft(draftRef));
    }

    // 手动更新必须携带 expectedVersion，防止覆盖 Agent 或其他页面刚保存的版本。
    @PutMapping("/{draftRef}")
    @Operation(summary = "更新学习计划草案")
    public Result<LearningPlanDraftVO> update(@PathVariable String draftRef,
                                              @Valid @RequestBody UpdateLearningPlanDraftRequest request) {
        if (request.getDraftRef() != null && !request.getDraftRef().isBlank()
                && !request.getDraftRef().equals(draftRef)) {
            throw new DataIllegalException("请求体中的 draftRef 与路径不一致");
        }
        return Result.success(service.updateManual(draftRef, request));
    }

    // 用户在页面明确点击确认时直接生效；这不是模型代替用户的授权。
    @PostMapping("/{draftRef}/activate")
    @Operation(summary = "确认学习计划草案正式生效")
    public Result<LearningPlanDraftVO> activate(@PathVariable String draftRef,
                                                @Valid @RequestBody ActivateLearningPlanDraftDTO request) {
        return Result.success(service.activateManual(draftRef, request.getExpectedVersion()));
    }
}
