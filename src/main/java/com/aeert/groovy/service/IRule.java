package com.aeert.groovy.service;

/**
 * @Author l'amour solitaire
 * @Description 自定义规则
 * @Date 2020/11/10 上午10:10
 **/
public interface IRule {
    static final int NORMAL_TYPE = 0;
    static final int GROOVY_FILE_TYPE = 1;
    static final int GROOVY_DB_TYPE = 2;
    static final int GROOVY_SPRING_TYPE = 3;

    int getType();

    String printInfo(String parm);
}
