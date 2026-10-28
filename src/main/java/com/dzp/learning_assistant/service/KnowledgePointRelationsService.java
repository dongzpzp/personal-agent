package com.dzp.learning_assistant.service;

import com.dzp.learning_assistant.model.dto.KnowledgePointRelationsDTO;
import com.dzp.learning_assistant.model.vo.KnowledgePointRelationsVO;

import java.util.List;

public interface KnowledgePointRelationsService {

    // 创建知识点关系并返回创建结果。
    KnowledgePointRelationsVO createRelations(KnowledgePointRelationsDTO relationDTO);

    // 根据关系 ID 列表批量删除知识点关系。
    void deleteRelationsByIds(List<Long> ids);
}
