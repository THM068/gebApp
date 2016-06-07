package com.uosbanner

import grails.test.mixin.integration.Integration
import com.uosbanner.BaseSpec
import com.uosbanner.pages.LoginPage
import com.uosbanner.pages.HomePage

/**
 * Created by tm1c14 on 09/11/2015.
 */
@Integration
class LoginSpec extends BaseSpec {
    static String EXPECTED_STRING = 'Enter your user name and password, then click Sign In to continue.'

    def "Login page is displayed"() {
        when:
            to LoginPage
        then:
            at(LoginPage)
    }

    def 'A user can log into the intructor role project'() {
        when:
            to LoginPage
        then:
            at(LoginPage)
        when:
            doLogin()
        then:
            at(HomePage)
    }

    def 'A user can click on the log signout button'() {
        given:
            gotoHomePage()
        when:
            clickSignout()
        then:
            at LoginPage
    }


    private void gotoHomePage(){
        to LoginPage
        assert at(LoginPage)
        doLogin()
        assert at(HomePage)
    }


}
