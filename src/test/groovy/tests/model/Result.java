package tests.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author shengchaojie
 * @date 2020-02-07
 **/
@Data
@AllArgsConstructor
public class Result<T> {

    private T data;

}
