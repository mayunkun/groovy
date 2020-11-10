package com.aeert.groovy.service;


import com.aeert.groovy.entity.GroovyRuleEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Author l'amour solitaire
 * @Description groovy规则表 规则建议走缓存，为了清晰，本例不展示
 * @Date 2020/11/10 上午9:58
 **/
public interface GroovyRuleService extends IService<GroovyRuleEntity> {

    /**
     * 根据规则名称获取规则信息
     **/
    GroovyRuleEntity getRuleByName(String name);

}

