package com.gamza.nyangflix.global;

import com.gamza.nyangflix.common.Messages;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@ToString
@Builder
@AllArgsConstructor
@Schema(name = "[Response] 응답구조체", description = "API전역에서 사용하는 응답 구조체 입니다.")
public class Response {
    @Schema(description = "응답코드입니다. 2:정상, 3:인증실패, 4:찾을수없음, 5:서버오류")
    private int resultCode;
    @Schema(description = "응답상태입니다. success, unauthorized, not_found, error")
    private String result;
    @Schema(description = "응답상태메시지입니다. 정상, 인증실패, 찾을수없음, 서버오류(개발서버에서는 오류메시지로 대체됩니다.)")
    private Object message;
    @Schema(description = "응답데이터입니다.")
    private Object data;
    @Schema(description = "서버시간 기준 응답시간 입니다. Unix-Timestamp 체계입니다.")
    private Long timestamp;

    public static ResponseEntity<Response> success(final Object data) {
        return success(ResultCodeMessage.SUCCESS.getResultMessage(), data);

    }

    public static ResponseEntity<Response> success(final String message, final Object data) {
        return new ResponseEntity<>(Response.builder()
                .resultCode(ResultCodeMessage.SUCCESS.getCode())
                .result(ResultCodeMessage.SUCCESS.getResult())
                .message(message)
                .data(data)
                .timestamp(System.currentTimeMillis())
                .build(), HttpStatus.OK);
    }

    public static ResponseEntity<Response> error() {
        return error(ResultCodeMessage.ERROR.getResultMessage());
    }

    public static ResponseEntity<Response> error(final Object message) {
        return error(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseEntity<Response> error(final Object message, final HttpStatus status) {
        return new ResponseEntity<>(Response.builder()
                .resultCode(ResultCodeMessage.ERROR.getCode())
                .result(ResultCodeMessage.ERROR.getResult())
                .message(message)
                .data(null)
                .timestamp(System.currentTimeMillis())
                .build(), status);
    }

    public static ResponseEntity<Response> unauthenticated() {
        return unauthenticated(ResultCodeMessage.UNAUTHORIZED.getResultMessage());
    }

    public static ResponseEntity<Response> unauthenticated(final Object message) {
        return unauthenticated(message, null);
    }

    public static ResponseEntity<Response> unauthenticated(final Object message, final Object data) {
        return unauthenticated(message, data, HttpStatus.UNAUTHORIZED);
    }

    public static ResponseEntity<Response> unauthenticated(final Object message, final Object data, final HttpStatus status) {
        return unauthenticated(message, data, ResultCodeMessage.UNAUTHORIZED.getResult(), status);
    }

    public static ResponseEntity<Response> unauthenticated(final Object message, final Object data, String result, final HttpStatus status) {
        return new ResponseEntity<>(Response.builder()
                .resultCode(ResultCodeMessage.UNAUTHORIZED.getCode())
                .result(result)
                .message(message)
                .data(data)
                .timestamp(System.currentTimeMillis())
                .build(), status);
    }

    public static ResponseEntity<Response> dataNotFound() {
        return dataNotFound(ResultCodeMessage.NOTFOUND.getResultMessage());
    }

    public static ResponseEntity<Response> dataNotFound(final Object message) {
        return new ResponseEntity<>(Response.builder()
                .resultCode(ResultCodeMessage.NOTFOUND.getCode())
                .result(ResultCodeMessage.NOTFOUND.getResult())
                .message(message)
                .data(null)
                .timestamp(System.currentTimeMillis())
                .build(), HttpStatus.OK);
    }

    public static ResponseEntity<Response> notFoundApi() {
        return notFoundApi(ResultCodeMessage.NOTFOUND.getResultMessage());
    }

    public static ResponseEntity<Response> notFoundApi(final Object message) {
        return new ResponseEntity<>(Response.builder()
                .resultCode(ResultCodeMessage.NOTFOUND.getCode())
                .result(ResultCodeMessage.NOTFOUND.getResult())
                .message(message)
                .data(null)
                .timestamp(System.currentTimeMillis())
                .build(), HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<Response> invalidRequest() {
        return notFoundApi("올바르지않은요청");
    }

    public static ResponseEntity<Response> invalidRequest(final Object message) {
        return invalidRequest(message, null, Messages.get("code.invalid_request"), HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<Response> invalidRequest(final Object message, final Object data) {
        return invalidRequest(message, data, Messages.get("code.invalid_request"), HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<Response> invalidRequest(final Object message, final Object data, String result) {
        return invalidRequest(message, data, result, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<Response> invalidRequest(final Object message, final Object data, String result, final HttpStatus status) {
        return new ResponseEntity<>(Response.builder()
                .resultCode(ResultCodeMessage.UNAUTHORIZED.getCode())
                .result(result)
                .message(message)
                .data(data)
                .timestamp(System.currentTimeMillis())
                .build(), status);
    }
}
