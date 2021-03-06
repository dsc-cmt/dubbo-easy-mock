package com.cmt.des.compatible;

import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.cluster.Cluster;
import com.alibaba.dubbo.rpc.cluster.Directory;
import com.cmt.des.MockConfig;


/**
 * 采用SPI的包装类 包装Cluster扩展点
 * 如果开启easymock 直接走easymock的逻辑
 * @author shengchaojie
 * @date 2019-06-17
 **/
public class CompatibleEasyMockClusterWrapper implements Cluster {

    private Cluster cluster;

    public CompatibleEasyMockClusterWrapper(Cluster cluster) {
        this.cluster = cluster;
    }

    @Override
    public <T> Invoker<T> join(Directory<T> directory) throws RpcException {
        //防御性前置判断
        if(MockConfig.INSTANCE.isMockEnable()) {
            return new CompatibleEasyMockInvoker<>(directory, this.cluster.join(directory));
        }

        return this.cluster.join(directory);
    }
}
