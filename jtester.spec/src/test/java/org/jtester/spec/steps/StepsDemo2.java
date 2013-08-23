package org.jtester.spec.steps;

import org.jtester.spec.Steps;
import org.jtester.spec.annotations.Step;

/**
 * @author darui.wudr 2013-8-22 下午2:40:54
 */
public class StepsDemo2 implements Steps {

    @Step
    public void printSomething() {
        System.out.println("print something");
    }
}
