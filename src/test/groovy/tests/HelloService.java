package tests;

import tests.model.Person;
import tests.model.Result;

import java.util.Map;

/**
 * @author shengchaojie
 * @date 2019-06-17
 **/
public interface HelloService {

    String helloWorld();

    Long testLong1();

    long testLong2();

    void empty();

    Result<String> genericMethod();

    Result<Person> genericMethod2();

    Person complexObjcet();

    Map<String,Integer> returnMapMethod();
}
