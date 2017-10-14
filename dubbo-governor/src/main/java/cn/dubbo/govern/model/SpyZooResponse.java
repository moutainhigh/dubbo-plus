package cn.dubbo.govern.model;

import java.util.List;

public class SpyZooResponse {
    
    private List<SpyZooNode> nodeList;
    private State state = State.SUCCESS;

    public List<SpyZooNode> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<SpyZooNode> nodeList) {
        this.nodeList = nodeList;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public static enum State{
        SUCCESS,FAILED,REMOTE_ERROR
    }
}