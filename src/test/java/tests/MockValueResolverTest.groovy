package tests

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.TypeReference
import io.github.shengchaojie.des.MockValueResolver
import io.github.shengchaojie.des.PrimitiveWrapper
import spock.lang.Specification
import tests.model.Result

/**
 * @author shengchaojie* @date 2020-02-09
 * */
class MockValueResolverTest extends Specification {

    def "test parse primitive"() {
        when:
        def value = MockValueResolver.resolve(JSON.toJSONString(new PrimitiveWrapper(originValue)), type, genericType)
        then:
        Objects.equals(value, originValue)
        where:
        originValue | type    | genericType
        1           | Integer | null
    }

    def "test parse not primitive"() {
        when:
        def value = MockValueResolver.resolve(JSON.toJSONString(originValue), type, genericType)
        then:
        Objects.equals(value, originValue)
        where:
        originValue                                           | type   | genericType
        new Result<Integer>(123)                              | Result | new TypeReference<Result<Integer>>() {}.type
        new Result<Result<Integer>>(new Result<Integer>(123)) | Result | new TypeReference<Result<Result<Integer>>>() {
        }.type
    }


}