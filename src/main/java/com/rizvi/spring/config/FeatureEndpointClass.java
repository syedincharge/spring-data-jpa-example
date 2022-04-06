package com.rizvi.spring.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Component
@Endpoint(id = "features")
public class FeatureEndpointClass {


    private final Map<String, Feature> featueMap = new ConcurrentHashMap<>();


    public FeatureEndpointClass() {

        featueMap.put("Department", new Feature( true));
        featueMap.put("User", new Feature( false));
        featueMap.put("Authentication", new Feature( false));
    }

    @ReadOperation
    public Map<String, Feature> features(){
        return  featueMap;
    }


    @ReadOperation
    public Feature feature(@Selector String featureName){
        return featueMap.get(featureName);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Feature {

        private boolean isEnabled;
    }
}
