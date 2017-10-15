package com.dubboclub.dk.storage.model;

public class ServiceInfo extends BaseInfo {

	private static final long serialVersionUID = -7813940762202029490L;

	private String name;
    private String remoteType;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemoteType() {
        return remoteType;
    }

    public void setRemoteType(String remoteType) {
        this.remoteType = remoteType;
    }
}
