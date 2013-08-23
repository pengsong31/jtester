package org.jtester.spec;

/**
 * JSpec接口类
 * 
 * @author darui.wudr 2013-1-10 下午4:15:50
 */
public interface ISpec {

    /**
     * 返回指定Steps的实例
     * 
     * @param clazzName
     * @return
     */
    Steps getStepsInstance(String stepClazzName);
}
