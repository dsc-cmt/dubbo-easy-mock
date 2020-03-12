package com.alibaba.dubbo.rpc;

import com.alibaba.dubbo.common.Node;

/**
 * @author shengchaojie
 * @date 2020-03-12
 **/
public interface Invoker<T> extends Node {

    /**
     * get service interface.
     *
     * @return service interface.
     */
    Class<T> getInterface();

    /**
     * invoke.
     *
     * @param invocation
     * @return result
     * @throws RpcException
     */
    Result invoke(Invocation invocation) throws RpcException;

}
