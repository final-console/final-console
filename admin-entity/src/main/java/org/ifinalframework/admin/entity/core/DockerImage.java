package org.ifinalframework.admin.entity.core;

import org.ifinalframework.data.annotation.AbsRecord;

import lombok.Getter;
import lombok.Setter;

/**
 * DockerImage
 *
 * @author mik
 * @since 1.5.2
 **/
@Setter
@Getter
public class DockerImage extends AbsRecord {
    private String name;
    private Long version;
}
