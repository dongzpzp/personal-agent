package com.dzp.learning_assistant.service;

import com.dzp.learning_assistant.model.dto.LearningPlanDraftDTO;
import com.dzp.learning_assistant.model.dto.UpdateLearningPlanDraftRequest;
import com.dzp.learning_assistant.model.entity.LearningPlanDraft;
import com.dzp.learning_assistant.model.vo.LearningPlanDraftVO;

import java.util.List;

public interface LearningPlanDraftService {
    // 页面手动创建学习计划草案
    public LearningPlanDraftVO createManual(LearningPlanDraftDTO request);

    public List<LearningPlanDraftVO> listCurrentUser();

    public LearningPlanDraftVO getCurrentUserDraft(String draftRef);

    public LearningPlanDraftVO updateManual(String draftRef, UpdateLearningPlanDraftRequest request);

    public LearningPlanDraftVO activateManual(String draftRef, long expectedVersion);

    public LearningPlanDraft findActiveForUser(Long userId, String draftRef);

    public LearningPlanDraft findActiveForUserForUpdate(Long userId, String draftRef);

    public LearningPlanDraftVO updateAgent(String draftRef, UpdateLearningPlanDraftRequest request);

    public LearningPlanDraftVO activateAgent(String draftRef, long expectedVersion);

    public void validateAgentCreate(LearningPlanDraftDTO request);

    public void validateAgentUpdate(String draftRef, UpdateLearningPlanDraftRequest request);

    public void validateAgentActivation(String draftRef, long expectedVersion);


}
