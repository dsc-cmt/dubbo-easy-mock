package com.cmt.des;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @author shengchaojie
 * @date 2019-03-04
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrimitiveWrapper implements Serializable {

    private Object data;

}
