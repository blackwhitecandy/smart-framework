package org.smart4j.framework.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;



/**
 * request entity
 */
public  class Request {

    private String requestMethod;
    private String requestPath;

    public Request(String requestMethod, String requestBody) {
        this.requestMethod = requestMethod;
        this.requestPath = requestBody;
    }

    public String getRequestMethod(){
        return this.requestMethod;
    }


    public String getRequestPath(){
        return this.requestPath;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }


}
