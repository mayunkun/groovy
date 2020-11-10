package com.aeert.groovy.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author l'amour solitaire
 * @Description groovy规则表
 * @Date 2020/11/10 上午9:57
 **/
@Data
@TableName("tb_groovy_rule")
public class GroovyRuleEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    private Integer id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 规则名称
     */
    private String name;
    /**
     * 规则内容
     */
    private String rule;
    /**
     * 状态(0:禁用 1:启用)
     */
    private Boolean status;

}
