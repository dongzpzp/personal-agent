package com.dzp.learning_assistant.exception;

/**
 * LearningAssServiceException
 * Assistant 业务异常
 */
public class LearningAssServiceException extends RuntimeException {
    public LearningAssServiceException(String message) {
        super(message);
    }

    public LearningAssServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
