package cn.dubbo.govern.model;

import java.io.Serializable;

public abstract class BaseInfo implements Serializable {

	private static final long serialVersionUID = 7340734403532057486L;

	private Long maxElapsed;
    private Long maxConcurrent;
    private Integer maxFault;
    private Integer maxSuccess;

    public Long getMaxElapsed() {
        return maxElapsed;
    }

    public void setMaxElapsed(Long maxElapsed) {
        this.maxElapsed = maxElapsed;
    }

    public Long getMaxConcurrent() {
        return maxConcurrent;
    }

    public void setMaxConcurrent(Long maxConcurrent) {
        this.maxConcurrent = maxConcurrent;
    }

    public Integer getMaxFault() {
        return maxFault;
    }

    public void setMaxFault(Integer maxFault) {
        this.maxFault = maxFault;
    }

    public Integer getMaxSuccess() {
        return maxSuccess;
    }

    public void setMaxSuccess(Integer maxSuccess) {
        this.maxSuccess = maxSuccess;
    }
    
}
