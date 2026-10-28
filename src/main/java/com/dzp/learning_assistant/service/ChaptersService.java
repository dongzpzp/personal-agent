package com.dzp.learning_assistant.service;

import com.dzp.learning_assistant.model.dto.ChaptersDTO;
import com.dzp.learning_assistant.model.vo.ChaptersVO;
import lombok.NonNull;

import java.util.List;

public interface ChaptersService {
    //批量添加章节
    List<ChaptersVO> createChapters(@NonNull List<ChaptersDTO> chaptersDTOList);

    //根据课程ID获取章节列表
    List<ChaptersVO> getChaptersByCourseId(@NonNull Long courseId);

    //根据章节ID批量获取当前用户可查看的章节
    List<ChaptersVO> getChaptersByIds(@NonNull List<Long> ids);

    //修改章节列表
    List<ChaptersVO> updateChapters(@NonNull List<ChaptersDTO> chaptersDTOList);

    //删除章节列表
    void deleteChaptersByIds(@NonNull List<Long> ids);
}
