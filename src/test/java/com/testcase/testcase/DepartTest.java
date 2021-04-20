package com.testcase.testcase;

import com.testcase.page.WeWork;
import org.junit.jupiter.api.Test;

public class DepartTest {
    //todo: add department
    @Test
    void departAdd(){
        String departName="dx5_" + System.currentTimeMillis();
        new WeWork().startWeb().login().toContactPage().addDepart(departName, "panpan");
    }
    //todo: delete department
    //todo: modify department
    //todo: search department
}
