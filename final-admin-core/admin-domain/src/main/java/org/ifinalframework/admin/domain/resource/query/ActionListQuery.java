package org.ifinalframework.admin.domain.resource.query;


import org.ifinalframework.data.annotation.criterion.Equal;
import org.ifinalframework.data.query.PageQuery;

import lombok.Getter;
import lombok.Setter;

/**
 * ActionListQuery
 *
 * @author mik
 * @since 1.5.5
 **/
@Setter
@Getter
public class ActionListQuery extends PageQuery {
    @Equal
    private String resource;
}
