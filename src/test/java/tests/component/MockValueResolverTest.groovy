package tests.component

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.TypeReference
import com.cmt.des.MockValueResolver
import com.cmt.des.PrimitiveWrapper
import spock.lang.Specification
import tests.model.QueryCurNeedRepayResponse
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

    def "test  Object"(){
        given:
        String s = "{\n" +
                "  \"code\": \"10000\",\n" +
                "  \"interest\": 1,\n" +
                "  \"msg\": \"成功\",\n" +
                "  \"principal\": 0,\n" +
                "  \"success\": true,\n" +
                "  \"totalAmount\": 0\n" +
                "}";
        when:
        def value = MockValueResolver.resolve(s, QueryCurNeedRepayResponse.class, null)
        then:
        Objects.equals(value, originValue)
    }


}