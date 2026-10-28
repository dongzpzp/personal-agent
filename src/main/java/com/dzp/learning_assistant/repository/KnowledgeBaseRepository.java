package com.dzp.learning_assistant.repository;

import com.dzp.learning_assistant.model.entity.UploadFileVerifyInfo;
import org.apache.ibatis.annotations.*;
import com.dzp.learning_assistant.model.entity.KnowledgeBase;

@Mapper
public interface KnowledgeBaseRepository {
    // 插入知识库
    @Insert("insert into knowledge_base (course_id, name, description, owner_type, visibility, created_at, updated_at) " +
            "values (#{knowledgeBase.courseId}, #{knowledgeBase.name}, #{knowledgeBase.description}, #{knowledgeBase.ownerType}, #{knowledgeBase.visibility}, #{knowledgeBase.createdAt}, #{knowledgeBase.updatedAt})")
    @Options(useGeneratedKeys = true, keyProperty = "knowledgeBase.id", keyColumn = "id")
    int save(@Param("knowledgeBase") KnowledgeBase knowledgeBase);

    // 根据id获取知识库
    @Select("select * from knowledge_base where id = #{id}")
    KnowledgeBase findById(@Param("id") Long id);

    UploadFileVerifyInfo getUploadFileVerifyInfo(@Param("kbId") Long kbId);
}
