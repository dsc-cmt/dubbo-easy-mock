package io.github.shengchaojie.des;

import com.alibaba.fastjson.JSON;
import io.github.shengchaojie.des.util.ClassHelper;

import java.lang.reflect.Type;

/**
 * @author shengchaojie
 * @date 2020-02-09
 **/
public class MockValueResolver {

    public static Object resolve(String mockValue, Type type,Type genericType) {
        if (Void.TYPE.isAssignableFrom((Class<?>) type)) {
            return null;
        }

        Object value = null;
        if (ClassHelper.isPrimitive((Class<?>) type)) {
            //处理内置类型
            //解决easymock不支持基本类型返回的问题
            PrimitiveWrapper primitiveWrapper = JSON.parseObject(mockValue, PrimitiveWrapper.class);
            value = JSON.parseObject(primitiveWrapper.getData().toString(),type);
        } else if (mockValue.startsWith("{") || mockValue.startsWith("[")) {
            //处理普通对象
            value = JSON.parseObject(mockValue, genericType!=null?genericType:type);
        } else {
            // TODO: 2020-02-08 走到这边代表出错了 考虑错误如何处理
            value = mockValue;
        }

        return value;
    }

}
