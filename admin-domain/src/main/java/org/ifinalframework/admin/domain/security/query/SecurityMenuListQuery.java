package org.ifinalframework.admin.domain.security.query;

import org.ifinalframework.data.annotation.criterion.Equal;
import org.ifinalframework.data.query.PageQuery;

import lombok.Getter;
import lombok.Setter;

/**
 * SecurityMenuListQuery
 *
 * @author mik
 * @since 1.5.4
 **/
@Setter
@Getter
public class SecurityMenuListQuery extends PageQuery {
    @Equal
    private Long parentId;
}
