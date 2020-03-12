package io.github.shengchaojie.des;

import io.github.shengchaojie.des.util.ConfigUtils;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

/**
 * @author shengchaojie
 * @date 2020-02-07
 **/
@Slf4j
public class MockConfig {

    private static final String MOCK_FILE_NAME = "mock.properties";

    public static final MockConfig INSTANCE = new MockConfig();

    private static final String REQUEST_URL_FORMAT = "%s/%s/%s";

    private Boolean enable;

    @Getter
    private String mockServerUrl;

    private Map<String,Boolean> interfaceMockConfig = new HashMap<>();

    private MockConfig() {
        Properties mockProperties = ConfigUtils.loadProperties(MOCK_FILE_NAME);
        for(String key : mockProperties.stringPropertyNames()){
            String value = mockProperties.getProperty(key);
            if("easymock.enable".equals(key)){
                enable =  "true".equals(value);
            }else if("easymock.server.url".equals(key)){
                mockServerUrl = value;
            }else if(key.startsWith("easymock.")){
                interfaceMockConfig.put(key.substring(9),"true".equals(value));
            }else{
                log.info("无效配置项:key={},value={}",key,value);
            }
        }
    }

    public Boolean isMockEnable(){
        return Optional.ofNullable(enable).orElse(false);
    }

    public Boolean isInterfaceMockEnable(String interfaceName){
        return Optional.ofNullable(interfaceMockConfig.get(interfaceName)).orElse(false);
    }

    public Boolean isMethodMockEnable(String interfaceName, String methodName){
        return Optional.ofNullable(interfaceMockConfig.get(interfaceName+"."+methodName)).orElse(false);
    }

    public String buildMockRequestUrl(String interfaceName, String methodName){
        return String.format(REQUEST_URL_FORMAT,mockServerUrl,interfaceName,methodName);
    }
}
