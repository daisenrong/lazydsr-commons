package com.lazydsr.commons.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * BasqQuery
 *
 * @author: daisenrong
 * @since: 2020/6/15 10:43 下午
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseQuery extends PageInfo implements Serializable {

    private String orderBy;

}
