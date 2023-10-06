package org.ifinalframework.admin.model.core;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


/**
 * Tip
 *
 * @author mik
 * @since 1.5.5
 **/
@Getter
@Setter
public class Tip implements Serializable {
    private String title;
    private String icon;
}
