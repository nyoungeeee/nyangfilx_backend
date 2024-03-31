package com.gamza.nyangflix.global;

import com.gamza.nyangflix.common.Messages;

public enum ResultCodeMessage {
    SUCCESS(2, Messages.get("code.success"), ResultMessage.SUCCESS),
    UNAUTHORIZED(3, Messages.get("code.unauthorized"), ResultMessage.UNAUTHORIZED),
    NOTFOUND(4, Messages.get("code.not_found"), ResultMessage.NOTFOUND),
    ERROR(5, Messages.get("code.error"), ResultMessage.ERROR);

    private final int code;
    private final String result;
    private final String resultMessage;

    ResultCodeMessage(final int code, final String result, final String resultMessage) {
        this.code = code;
        this.result = result;
        this.resultMessage = resultMessage;
    }

    public int getCode() {
        return this.code;
    }

    public String getResultMessage() {
        return this.resultMessage;
    }

    public String getResult() {
        return this.result;
    }

    public static class ResultMessage {
        static final String SUCCESS = Messages.get("msg.success");
        static final String UNAUTHORIZED = Messages.get("msg.unauthorized");
        static final String NOTFOUND = Messages.get("msg.not_found");
        static final String ERROR = Messages.get("msg.error");
    }
}
