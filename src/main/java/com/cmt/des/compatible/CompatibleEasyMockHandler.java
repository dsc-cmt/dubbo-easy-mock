package com.cmt.des.compatible;

import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.fastjson.JSON;
import com.cmt.des.MockConfig;
import com.cmt.des.MockValueResolver;
import com.cmt.des.util.ClassHelper;
import com.cmt.des.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shengchaojie
 * @date 2019-06-17
 **/
@Slf4j
public class CompatibleEasyMockHandler<T> {

    public static <T> Result invoke(Invoker<T> invoker, Invocation invocation, String interfaceName, String methodName) {
        //mock总开关
        if (!MockConfig.INSTANCE.isMockEnable()) {
            return invoker.invoke(invocation);
        }

        if (MockConfig.INSTANCE.isMethodMockEnable(interfaceName, methodName)||
                MockConfig.INSTANCE.isInterfaceMockEnable(interfaceName)) {
            String mockUrl = MockConfig.INSTANCE.buildMockRequestUrl(interfaceName, methodName);
            log.debug("mockUrl:{}", mockUrl);
            try {
                //通过easymock返回mock数据
                String mockValue = HttpUtil.doGet(mockUrl);
                //通过反射拿到返回的类型
                Type[] returnTypes = ClassHelper.getReturnType(interfaceName, methodName, invocation.getParameterTypes());
                final Object result = MockValueResolver.resolve(mockValue, returnTypes[0], returnTypes.length > 1 ? returnTypes[1] : null);
                log.info("mock 返回值:{}", JSON.toJSONString(result));
                return new CompatibleResultAdaptor() {
                    @Override
                    public Object getValue() {
                        return result;
                    }

                    @Override
                    public Object recreate() throws Throwable {
                        return result;
                    }

                    @Override
                    public Map<String, String> getAttachments() {
                        return new HashMap<>(0);
                    }

                    @Override
                    public boolean hasException() {
                        return false;
                    }
                };
            } catch (Exception e) {
                // TODO: 2020-02-08 同样的异常处理
                log.error("interface:{} method:{}mock失败,转为正常调用", interfaceName, methodName, e);
            }
        }
        //正常调用
        return invoker.invoke(invocation);
    }

}
