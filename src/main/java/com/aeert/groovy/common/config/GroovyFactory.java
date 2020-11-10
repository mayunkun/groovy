package com.aeert.groovy.common.config;

import com.aeert.groovy.service.IRule;
import groovy.lang.GroovyClassLoader;

public class GroovyFactory {
    private static GroovyFactory groovyFactory = new GroovyFactory();
    private GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
    private static volatile GroovyFactory singleton = null;

    public static GroovyFactory getInstance() {
        if (singleton == null) {
            synchronized (GroovyFactory.class) {
                if (singleton == null) {
                    singleton = new GroovyFactory();
                }
            }
        }
        return singleton;
    }

    public IRule getIRuleFromCode(String code) throws Exception {
        Class<?> clazz = groovyClassLoader.parseClass(code);
        if (clazz != null) {
            Object instance = clazz.newInstance();
            if (instance != null) {
                if (instance instanceof IRule) {
                    return (IRule) instance;
                }
            }
        }
        throw new IllegalArgumentException("读取groovy脚本异常");
    }
}
