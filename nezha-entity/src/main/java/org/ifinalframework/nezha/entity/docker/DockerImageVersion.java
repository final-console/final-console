package org.ifinalframework.nezha.entity.docker;

import org.ifinalframework.data.annotation.AbsRecord;

import lombok.Getter;
import lombok.Setter;

/**
 * DockerImageVersion
 *
 * @author mik
 * @since 1.5.2
 **/
@Setter
@Getter
public class DockerImageVersion extends AbsRecord {
    private String name;
    private String imageVersion;
}
