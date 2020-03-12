package com.alibaba.dubbo.common;

/**
 * @author shengchaojie
 * @date 2020-03-12
 **/
public interface Node {

    /**
     * get url.
     *
     * @return url.
     */
    URL getUrl();

    /**
     * is available.
     *
     * @return available.
     */
    boolean isAvailable();

    /**
     * destroy.
     */
    void destroy();

}
