package com.aeert.groovy.controller;

import com.aeert.groovy.common.config.GroovyFactory;
import com.aeert.groovy.common.utils.R;
import com.aeert.groovy.common.utils.SpringUtils;
import com.aeert.groovy.entity.GroovyRuleEntity;
import com.aeert.groovy.service.GroovyRuleService;
import com.aeert.groovy.service.IRule;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation("DB")
    @GetMapping("/getByDb")
    public R getByDb(@RequestParam String ruleName) throws Exception {
        GroovyRuleEntity groovyRuleEntity = groovyRuleService.getByName(ruleName);
        Assert.notNull(groovyRuleEntity, "规则不存在！");
        IRule groovyDb = GroovyFactory.getInstance().getIRuleFromCode(groovyRuleEntity.getRule());
        return R.ok(groovyDb.printInfo(ruleName));
    }

    @ApiOperation("test")
    @GetMapping("/test")
    public R test() throws Exception {
        return R.ok(SpringUtils.getBean(GroovyRuleService.class).getByName("test"));
    }

}
