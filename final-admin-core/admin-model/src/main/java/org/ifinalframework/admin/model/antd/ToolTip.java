package org.ifinalframework.admin.model.antd;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * ToolTip
 *
 * @author mik
 * @since 1.5.5
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToolTip implements Serializable {
    private String title;
    private String icon;
}
