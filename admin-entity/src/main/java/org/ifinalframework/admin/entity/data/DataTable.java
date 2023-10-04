package org.ifinalframework.admin.entity.data;

import org.ifinalframework.data.annotation.AbsRecord;

import lombok.Getter;
import lombok.Setter;

/**
 * DataTable
 *
 * @author mik
 * @since 1.5.5
 **/
@Setter
@Getter
public class DataTable extends AbsRecord {
    private String name;
    private String String;
}
