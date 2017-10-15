package com.dubboclub.dk.web.model;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.utils.StringUtils;

import java.util.Map;

public class WeightOverrideInfo extends  OverrideInfo{

    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    public static WeightOverrideInfo valueOf(com.dubboclub.dk.admin.model.Override override){
        String weight = null;
        if(!StringUtils.isEmpty(override.getParams())){
            Map<String,String> parameters = StringUtils.parseQueryString(override.getParams());
            weight=parameters.get(Constants.WEIGHT_KEY);
            if(StringUtils.isEmpty(weight)||"null".equals(weight)){
                return null;
            }
        }
        WeightOverrideInfo overrideInfo = new WeightOverrideInfo();
        overrideInfo.setAddress(override.getAddress());
        overrideInfo.setApplication(override.getApplication()==null?Constants.ANY_VALUE:override.getApplication());
        overrideInfo.setEnable(override.isEnabled());
        overrideInfo.setId(override.getId());
        overrideInfo.setParameters(override.getParams());
        if(!StringUtils.isEmpty(weight)){
            overrideInfo.setWeight(Integer.parseInt(weight));
        }
        return overrideInfo;
    }
    
}
