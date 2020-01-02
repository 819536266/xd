package com.xd.common.Exception;

import lombok.Data;

/**
 * @author huboxin
 * @title: CommonException
 * @projectName bk
 * @description: 公共异常
 * @date 2019/12/3114:31
 */
public class CommonException extends RuntimeException {

    public CommonException(String msg) {
        super(msg);
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonException(Throwable cause) {
        super(cause);
    }
}
