package org.ifinalframework.nezha.entity.k8s;

import org.ifinalframework.data.annotation.AbsRecord;

import lombok.Getter;
import lombok.Setter;

/**
 * Deployment
 *
 * @author mik
 * @since 1.5.2
 **/
@Setter
@Getter
public class Deployment extends AbsRecord {
    private String name;
}
