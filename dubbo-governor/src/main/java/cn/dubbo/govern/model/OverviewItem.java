package cn.dubbo.govern.model;

import java.io.Serializable;

public class OverviewItem implements Serializable {

	private static final long serialVersionUID = 6928874699040454875L;

	private Long concurrent;
    private Long elapsed;
    private Long fault;
    private Long success;

    public Long getConcurrent() {
        return concurrent;
    }

    public void setConcurrent(Long concurrent) {
        this.concurrent = concurrent;
    }

    public Long getElapsed() {
        return elapsed;
    }

    public void setElapsed(Long elapsed) {
        this.elapsed = elapsed;
    }

    public Long getFault() {
        return fault;
    }

    public void setFault(Long fault) {
        this.fault = fault;
    }

    public Long getSuccess() {
        return success;
    }

    public void setSuccess(Long success) {
        this.success = success;
    }
}
