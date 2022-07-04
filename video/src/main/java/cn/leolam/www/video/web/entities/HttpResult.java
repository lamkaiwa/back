package cn.leolam.www.video.web.entities;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

@Data
public class HttpResult implements Serializable {

    // 响应业务状态
    private Integer code;

    // 响应消息
    private String message="fail";

    // 响应中的数据
    private Object data;

    public HttpResult() {
    }
    public HttpResult(Object data) {
        this.code = 200;
        this.message = "OK";
        this.data = data;
    }
    public HttpResult(String message, Object data) {
        this.code = 200;
        this.message = message;
        this.data = data;
    }

    public HttpResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public static HttpResult fail(Integer code,String message){
        return new HttpResult(code,message,null);
    }
    public static HttpResult ok() {
        return new HttpResult(null);
    }
    public static HttpResult ok(String message) {
        return new HttpResult(message, null);
    }
    public static HttpResult ok(Object data) {
        return new HttpResult(data);
    }
    public static HttpResult ok(String message, Object data) {
        return new HttpResult(message, data);
    }

    public static HttpResult build(Integer code, String message) {
        return new HttpResult(code, message, null);
    }

    public static HttpResult build(Integer code, String message, Object data) {
        return new HttpResult(code, message, data);
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }


    /**
     * JSON字符串转成 HttpResult 对象
     * @param json
     * @return
     */
    public static HttpResult format(String json) {
        try {
            return JSON.parseObject(json, HttpResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
