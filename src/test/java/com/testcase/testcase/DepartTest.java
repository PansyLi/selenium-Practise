package com.testcase.testcase;

import com.testcase.page.BasePage;
import com.testcase.page.WeWork;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class DepartTest {
    //todo: add department
    @ParameterizedTest
    @MethodSource("com.testcase.util.GetTestData#getDepartmentName")
    void departAdd(String departName){
        String message = new WeWork().startWeb().login().toContactPage().addDepart(departName, "panpan");
        assertThat(message,equalTo("Department Created"));

    }

    //todo: delete department
    //todo: modify department
    //todo: search department

}
