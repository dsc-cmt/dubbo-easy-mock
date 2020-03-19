package com.cmt.des.compatible;


import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.cluster.Directory;
import lombok.extern.slf4j.Slf4j;

/**
 * @author shengchaojie
 * @date 2019-06-17
 **/
@Slf4j
public class CompatibleEasyMockInvoker<T> implements Invoker<T> {

    private final Directory<T> directory;

    private final Invoker<T> invoker;

    public CompatibleEasyMockInvoker(Directory<T> directory, Invoker<T> invoker) {
        this.directory = directory;
        this.invoker = invoker;
    }

    @Override
    public Class<T> getInterface() {
        return directory.getInterface();
    }

    @Override
    public Result invoke(Invocation invocation) throws RpcException {
        String interfaceName = invoker.getInterface().getCanonicalName();
        String methodName = invocation.getMethodName();
        return CompatibleEasyMockHandler.invoke(invoker, invocation, interfaceName, methodName);
    }

    @Override
    public URL getUrl() {
        return directory.getUrl();
    }

    @Override
    public boolean isAvailable() {
        //这边返回true 让check=true的情况也通过
        return true;
    }

    @Override
    public void destroy() {
        this.invoker.destroy();
    }
}
