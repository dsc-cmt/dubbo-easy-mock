package io.github.shengchaojie.des.util;


import org.apache.dubbo.common.utils.ReflectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @author shengchaojie
 * @date 2019-03-04
 **/
public class ClassHelper {

    private static final Logger logger = LoggerFactory.getLogger(ClassHelper.class);

    public static boolean isPrimitive(Class<?> type) {
        return type.isPrimitive()
                || type == String.class
                || type == Character.class
                || type == Boolean.class
                || type == Byte.class
                || type == Short.class
                || type == Integer.class
                || type == Long.class
                || type == Float.class
                || type == Double.class
                || type == Object.class;
    }

    public static Type[] getReturnType(String interfaceName,String methodName,Class<?>[] parameterTypes){
        Class<?> cls = ReflectUtils.forName(interfaceName);
        Method method = null;
        try {
            method = cls.getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e) {
            logger.error("反射获取返回类型失败",e);
            return null;
        }
        return new Type[]{method.getReturnType(), method.getGenericReturnType()};
    }

}
