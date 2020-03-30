package org.tony.carrentalservice.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tony.chenjy
 * @date 2020-03-31
 */
public class R {

    private String code;
    private String message;
    private Object data;

    public R(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public R(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static R success() {
        return new R("0000", "success");
    }

    public static R success(Object data) {
        return new R("200", "success", data);
    }

    public static R error() {
        return new R("9999", "error");
    }

    public static R error(String message) {
        return new R("9999", message);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
