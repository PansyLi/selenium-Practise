package com.testcase.testcase;

import com.testcase.page.ContactPage;
import com.testcase.page.MainPage;
import com.testcase.page.WeWork;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MemberTest {
    @Test
    void add(){
        String accountId="seveniruby_"+System.currentTimeMillis();
        //todo: 登录企业微信
        WeWork weWork = new WeWork();
        MainPage mainPage = weWork.login();
        //todo: 进入通讯录
        ContactPage contactPage = mainPage.toMemberAdd();
        //todo：添加成员  头像（有无）  姓名（中英文 特殊字符 长度） 帐号（唯一性、命名规则） 手机（正确 错误 重复） 部门（父子）
        //todo: 参数化 排列组合
        contactPage.add("seveniruby","seveniruby", "15600534700", null);
        //todo: 保存
        //todo: 判断结果 若干断言
        contactPage.search(accountId);
        String s = contactPage.getMember();
        assertThat(s, equalTo("123"));
    }

    @Test
    @ParameterizedTest
    @MethodSource("com.testcase.util.GetTestData#getUserInfoDataFromYaml")
    void addMember(List<HashMap<String, Object>> userInfo){
        userInfo.forEach(user -> {
            String username = user.get("username").toString();
            String accountId = user.get("accountId").toString();
            String mobile = user.get("mobile").toString();
            String res=new WeWork().startWeb().login().toMemberAdd().add(username, accountId, mobile, null
            ).search(accountId).getMember();
            //断言
            assertThat(res, equalTo(username));
        });
    }

    @Test
    void uploadAvatar(){

    }
    @Test
    void deleteMember(){

    }


}
