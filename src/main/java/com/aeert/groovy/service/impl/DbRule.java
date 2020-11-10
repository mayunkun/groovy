package com.aeert.groovy.service.impl;

import com.aeert.groovy.common.utils.SpringUtils;
import com.aeert.groovy.service.GroovyRuleService;
import com.aeert.groovy.service.IRule;

/**
 * @Author l'amour solitaire
 * @Description DbRule
 * @Date 2020/11/10 上午11:10
 **/
public class DbRule implements IRule {

    @Override
    public int getType() {
        return GROOVY_DB_TYPE;
    }

    @Override
    public String printInfo(String parm) {
        return SpringUtils.getBean(GroovyRuleService.class).getByName(parm).getRule();
    }
}
