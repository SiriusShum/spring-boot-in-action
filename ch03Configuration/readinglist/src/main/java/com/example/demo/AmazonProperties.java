package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("amazon") // application.properties amazon.associateId=Jueee
public class AmazonProperties {

    private String associateId;

    public String getAssociateId() {
        return associateId;
    }

    public void setAssociateId(String associateId) {
        this.associateId = associateId;
    }
}
