package org.jtester.module.spring.annotations;

import mockit.Mocked;

import org.jtester.fortest.hibernate.AddressService;
import org.jtester.fortest.hibernate.UserService;
import org.jtester.junit.JTester;
import org.jtester.module.inject.annotations.Inject;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
@SpringContext({ "classpath:/org/jtester/fortest/hibernate/project.xml" })
public class UserServiceTest_Mock2 implements JTester {
    @SpringBeanByName("userService")
    private UserService    userService1;

    @Mocked
    @Inject(targets = "userService1")
    private AddressService addressService1;

    @Test
    public void findAddress() {
        want.object(addressService1).notNull();
        want.object(userService1).notNull();
        new Expectations() {
            {
                when(addressService1.findAddress()).thenReturn("文三路131#");
            }
        };
        String address = userService1.findAddress();
        want.string(address).contains("131#");
    }
}
