package com.dzp.learning_assistant.service;

import com.dzp.learning_assistant.model.dto.KnowledgeBaseDTO;
import com.dzp.learning_assistant.model.vo.KnowledgeBaseVO;

public interface KnowledgeBaseService {
    KnowledgeBaseVO addKnowledgeBase(KnowledgeBaseDTO knowledgeBaseDTO);
}

