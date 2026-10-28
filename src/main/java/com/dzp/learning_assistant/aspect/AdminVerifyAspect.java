package com.dzp.learning_assistant.aspect;

import com.dzp.learning_assistant.annotation.AdminAnnotation;
import com.dzp.learning_assistant.common.context.BaseContext;
import com.dzp.learning_assistant.enums.UserRoleEnum;
import com.dzp.learning_assistant.exception.ViolationOperationException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class AdminVerifyAspect {
    @Before("@annotation(adminAnnotation)")
    public void checkAdmin(AdminAnnotation adminAnnotation) {
        UserRoleEnum userRole = BaseContext.getCurrentRole();
        if (userRole != UserRoleEnum.ADMIN) {
            log.warn("[权限] 非管理员用户尝试访问管理员接口 userId={}", BaseContext.getCurrentId());
            throw new ViolationOperationException("需要管理员权限");
        }
        log.info("[权限] 管理员用户访问管理员接口 userId={}", BaseContext.getCurrentId());
    }
}
