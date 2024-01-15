package org.ifinalframework.admin.model.antd;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


/**
 * Action
 *
 * @author mik
 * @since 1.5.5
 **/
@Getter
@Setter
public class Action implements Serializable {
    private String key;
    private String name;
    private String type;
    private String tips;
    private String eval;
}
