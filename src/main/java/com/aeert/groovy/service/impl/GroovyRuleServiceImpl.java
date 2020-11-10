package com.aeert.groovy.service.impl;

import com.aeert.groovy.dao.GroovyRuleDao;
import com.aeert.groovy.entity.GroovyRuleEntity;
import com.aeert.groovy.service.GroovyRuleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service("groovyRuleService")
public class GroovyRuleServiceImpl extends ServiceImpl<GroovyRuleDao, GroovyRuleEntity> implements GroovyRuleService {

    @Override
    @Cacheable(key = "targetClass + methodName + ':' + #p0", value = "getRuleByName")
    public GroovyRuleEntity getRuleByName(String name) {
        return baseMapper.selectOne(new QueryWrapper<GroovyRuleEntity>().lambda().eq(GroovyRuleEntity::getName, name));
    }
}
