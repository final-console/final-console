package org.ifinalframework.admin.domain.resource.query;

import org.ifinalframework.admin.repository.resource.query.QMenu;
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
public class MenuListQuery extends PageQuery {
    @Equal
    private Long parentId;

    public MenuListQuery() {
        addOrder(QMenu.sortValue.asc().toString());
    }
}
