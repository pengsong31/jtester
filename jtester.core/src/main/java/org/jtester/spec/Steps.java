package org.jtester.spec;

import org.jtester.module.ICore;
import org.jtester.module.database.IDatabase;
import org.jtester.module.jmockit.IMockict;
import org.jtester.module.spring.ISpring;

/**
 * JSpec步骤定义文件接口 <br>
 * 标识接口
 * 
 * @author darui.wudr 2013-6-3 下午7:04:36
 */
public interface Steps extends ICore, IMockict, ISpring, IDatabase {

}
