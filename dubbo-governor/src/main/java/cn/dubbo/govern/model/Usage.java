package cn.dubbo.govern.model;

import java.io.Serializable;

public class Usage implements Serializable {
    
	private static final long serialVersionUID = -5089941055241092515L;

	private String remoteAddress;
    private Long count;

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
