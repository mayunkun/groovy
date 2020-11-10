package com.aeert.groovy.controller;

import com.aeert.groovy.common.config.GroovyFactory;
import com.aeert.groovy.common.utils.R;
import com.aeert.groovy.entity.GroovyRuleEntity;
import com.aeert.groovy.service.GroovyRuleService;
import com.aeert.groovy.service.IRule;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * @Author l'amour solitaire
 * @Description groovy相关
 * @Date 2020/11/10 上午10:01
 **/
@Slf4j
@Api(tags = "groovy相关")
@RestController
@RequestMapping("/groovy")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class GroovyController {

    private final GroovyRuleService groovyRuleService;

    @ApiOperation("更新规则")
    @PostMapping("/updateDbRule")
    @CacheEvict(value = {"getRuleByName"}, allEntries = true)
    public R updateDbRule(@RequestParam String ruleName, @RequestBody String rule) throws Exception {
        GroovyRuleEntity groovyRuleEntity = groovyRuleService.getRuleByName(ruleName);
        groovyRuleService.update(new UpdateWrapper<GroovyRuleEntity>().lambda()
                .eq(GroovyRuleEntity::getId, groovyRuleEntity.getId()).set(GroovyRuleEntity::getRule, rule));
//        groovyRuleService.updateById(groovyRuleEntity.setRule(rule));
        return R.ok(groovyRuleEntity);
    }

    @ApiOperation("打印出当前规则信息")
    @GetMapping("/getRuleByDb")
    public R getRuleByDb(@RequestParam String ruleName) throws Exception {
        GroovyRuleEntity groovyRuleEntity = groovyRuleService.getRuleByName(ruleName);
        Assert.notNull(groovyRuleEntity, "规则不存在！");
        IRule groovyDb = GroovyFactory.getInstance().getIRuleFromCode(groovyRuleEntity.getRule());
        return R.ok(groovyDb.printInfo(ruleName));
    }

}
