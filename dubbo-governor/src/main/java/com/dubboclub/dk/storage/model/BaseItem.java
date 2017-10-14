package com.dubboclub.dk.storage.model;

import java.io.Serializable;

public class BaseItem implements Serializable{

	private static final long serialVersionUID = 7405183443938322270L;

	private String method;
    private String service;
    private Long timestamp;
    private String remoteType;

    public String getRemoteType() {
        return remoteType;
    }

    public void setRemoteType(String remoteType) {
        this.remoteType = remoteType;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
    
}
