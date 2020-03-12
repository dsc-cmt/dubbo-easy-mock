package io.github.shengchaojie.des;

import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.cluster.Cluster;
import org.apache.dubbo.rpc.cluster.Directory;


/**
 * 采用SPI的包装类 包装Cluster扩展点
 * 如果开启easymock 直接走easymock的逻辑
 * @author shengchaojie
 * @date 2019-06-17
 **/
public class EasyMockClusterWrapper implements Cluster {

    private Cluster cluster;

    public EasyMockClusterWrapper(Cluster cluster) {
        this.cluster = cluster;
    }

    @Override
    public <T> Invoker<T> join(Directory<T> directory) throws RpcException {
        //防御性前置判断
        if(MockConfig.INSTANCE.isMockEnable()) {
            return new EasyMockInvoker<>(directory, this.cluster.join(directory));
        }

        return this.cluster.join(directory);
    }
}
