package com.dzp.learning_assistant.model.entity;

import com.dzp.learning_assistant.enums.CoursesTypeEnum;
import com.dzp.learning_assistant.exception.CreateErrorException;
import com.dzp.learning_assistant.exception.ViolationOperationException;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
public class Courses {
    private Long id;
    private Long userId;
    private String courseName;
    private Long difficultyLevel;
    private Long publisherId;
    private String learningOutline;
    private CoursesTypeEnum courseType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //课程发布，只能由课程创建者进行操作
    public void publishCourse(Courses courses, Long currentUserId) {
        if (!Objects.equals(courses.getUserId(), currentUserId)) {
            throw new ViolationOperationException("无权限，非法操作");
        }
        transition(courses, CoursesTypeEnum.PRIVATE, CoursesTypeEnum.PENDING);
    }

    //课程审核通过，管理员操作
    public void passCourse(Courses courses) {
        transition(courses,
                CoursesTypeEnum.PENDING,
                CoursesTypeEnum.PUBLISHED);
    }

    //课程驳回或下架，管理员操作
    public void rejectCourse(Courses courses) {
        CoursesTypeEnum currentStatus = courses.getCourseType();
        if (currentStatus != CoursesTypeEnum.PENDING && currentStatus != CoursesTypeEnum.PUBLISHED) {
            throw new ViolationOperationException("当前课程状态不允许驳回或下架");
        }
        courses.setCourseType(CoursesTypeEnum.PRIVATE);
    }

    //课程状态转换
    private void transition(Courses courses, CoursesTypeEnum expectedStatus,
                            CoursesTypeEnum targetStatus) {
        if (courses.getCourseType() != expectedStatus) {
            throw new ViolationOperationException("当前课程状态不允许该操作");
        }
        courses.setCourseType(targetStatus);
    }

    //课程创建者或课程发布者可操作
    public void userCoursesOrPublished(Courses courses, Long currentUserId) {
        if (Objects.equals(courses.getUserId(), currentUserId) || courses.getCourseType() == CoursesTypeEnum.PUBLISHED) {
            return;
        }
        throw new CreateErrorException("非法创建");
    }
}
