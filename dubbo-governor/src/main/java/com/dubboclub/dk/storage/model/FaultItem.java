package com.dubboclub.dk.storage.model;

public class FaultItem extends  BaseItem{

	private static final long serialVersionUID = -772144986966532699L;
	
	private Integer fault;

    public Integer getFault() {
        return fault;
    }

    public void setFault(Integer fault) {
        this.fault = fault;
    }
    
}
