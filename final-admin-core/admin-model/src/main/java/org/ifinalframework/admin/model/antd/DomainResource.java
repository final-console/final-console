package org.ifinalframework.admin.model.antd;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;


/**
 * DomainResource
 *
 * @author mik
 * @since 1.5.5
 **/
@Getter
@Setter
public class DomainResource implements Serializable {
    private List<Action> actions;
    private Map<String, List<ProColumns>> columns;
}
