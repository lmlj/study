package lml.domain;

import java.io.Serializable;

/**
 * @Auther: Lmlj
 * @Date: 2016/2/14.
 */
public class ResponseJSON implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Boolean isSuccess;

    private Object data;

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseJSON() {
    }

    public ResponseJSON(Boolean isSuccess, Object data) {
        this.isSuccess = isSuccess;
        this.data = data;
    }
}
