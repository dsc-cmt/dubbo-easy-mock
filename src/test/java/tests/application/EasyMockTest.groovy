package tests.application


import org.apache.dubbo.config.ApplicationConfig
import org.apache.dubbo.config.ReferenceConfig
import org.apache.dubbo.config.RegistryConfig
import spock.lang.*
import tests.HelloService

/**
 * @author shengchaojie
 * @date 2019-06-17
 **/
class EasyMockTest extends Specification {

    private static HelloService helloService;

    def setupSpec(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("test-consumer");

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");

        ReferenceConfig<HelloService> referenceConfig = new ReferenceConfig<HelloService>();
        referenceConfig.setInterface(HelloService.class);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setCheck(false);
        helloService = referenceConfig.get();
    }

    def "test long"() {
        when :
            println helloService.testLong1()
        then:
            noExceptionThrown()
        when:
            helloService.testLong2()
        then:
            noExceptionThrown()
    }

}
