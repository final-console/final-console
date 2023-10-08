package org.ifinalframework.admin.entity.resource;

import org.ifinalframework.core.ISort;
import org.ifinalframework.core.lang.Default;
import org.ifinalframework.data.annotation.AbsRecord;
import org.ifinalframework.data.annotation.DomainResource;

import jakarta.validation.constraints.NotBlank;

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
@DomainResource("actions")
public class Action extends AbsRecord implements ISort {
    @NotBlank
    private String resource;
    @NotBlank
    private String code;
    @NotBlank
    private String name;
    @NotBlank
    private String type;
    @Default
    private Integer sortValue;
    private String tips;

    private String eval;
}
