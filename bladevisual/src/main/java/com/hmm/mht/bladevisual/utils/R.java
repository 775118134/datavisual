package com.hmm.mht.bladevisual.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * 响应信息主体
 */
@Builder
@Accessors(chain = true)
@ApiModel(value = "响应信息主体")
@Data
//@AllArgsConstructor
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;

//    @Tolerate
//    public R() {
//
//    }

    @ApiModelProperty(value = "返回标记：成功标记=1，失败标记=0")
    @Builder.Default
    private int status = ResultStatus.SUCCESS.status;

    @ApiModelProperty(value = "http状态码")
    @Builder.Default
    private int code = HttpStatus.OK.value();

    @ApiModelProperty(value = "描述信息")
    @Builder.Default
    private String msg = "success";

    @ApiModelProperty(value = "数据")
    private T data;

    @ApiModelProperty(value = "当前时间戳")
    @Builder.Default
    private long timestamp = System.currentTimeMillis();

    public static <T> R<T> ok() {
        return R.<T>builder().build();
    }

    public static <T> R<T> ok(T data) {
        return R.<T>builder().data(data).build();
    }

    public static <T> R<T> ok(T data, String msg) {
        return R.<T>builder().data(data).msg(msg).build();
    }

    public static <T> R<T> failed() {
        return R.<T>builder().status(ResultStatus.FAIL.status).build();
    }

    public static <T> R<T> failed(String msg) {
        return R.<T>builder().status(ResultStatus.FAIL.status).msg(msg).build();
    }

    public static <T> R<T> failed(T data) {
        return R.<T>builder().status(ResultStatus.FAIL.status).data(data).build();
    }

    public static <T> R<T> failed(T data, String msg) {
        return R.<T>builder().status(ResultStatus.FAIL.status).msg(msg).data(data).build();
    }

    public static <T> R<T> result(int status, int code, T data, String msg) {
        return R.<T>builder().status(status).code(code).data(data).msg(msg).build();
    }

    @AllArgsConstructor
    private enum ResultStatus {
        SUCCESS(1), FAIL(0);

        private int status;

    }

}
