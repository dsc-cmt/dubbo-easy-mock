package io.github.shengchaojie.des;

import io.github.shengchaojie.des.util.ClassHelper;
import io.github.shengchaojie.des.util.HttpUtil;
import org.apache.dubbo.rpc.AppResponse;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;

/**
 * @author shengchaojie
 * @date 2019-06-17
 **/
public class EasyMockHandler<T> {

    private static final Logger logger = LoggerFactory.getLogger(EasyMockHandler.class);


    public static <T> Result invoke(Invoker<T> invoker, Invocation invocation, String interfaceName, String methodName) {
        //mock总开关
        if (!MockConfig.INSTANCE.isMockEnable()) {
            return invoker.invoke(invocation);
        }

        if (MockConfig.INSTANCE.isMethodMockEnable(interfaceName, methodName)||
                MockConfig.INSTANCE.isInterfaceMockEnable(interfaceName)) {
            String mockUrl = MockConfig.INSTANCE.buildMockRequestUrl(interfaceName, methodName);
            logger.debug("mockUrl:{}", mockUrl);
            try {
                //通过easymock返回mock数据
                String mockValue = HttpUtil.doGet(mockUrl);
                //通过反射拿到返回的类型
                Type[] returnTypes = ClassHelper.getReturnType(interfaceName, methodName, invocation.getParameterTypes());
                return new AppResponse(MockValueResolver.resolve(mockValue, returnTypes[0], returnTypes.length > 1 ? returnTypes[1] : null));
            } catch (Exception e) {
                // TODO: 2020-02-08 同样的异常处理
                logger.error("interface:{} method:{}mock失败,转为正常调用", interfaceName, methodName, e);
            }
        }
        //正常调用
        return invoker.invoke(invocation);
    }

}
