package com.uosbanner.pages

/**
 * Created by tm1c14 on 09/11/2015.
 */
import geb.Page

class LoginPage extends Page {
    static String EXPECTED_STRING = 'Enter your user name and password, then click Sign In to continue.'
    static at = { loginText.text() ==  EXPECTED_STRING }

    static url = 'login/auth'

    static content = {
        loginText { $('.loginMsg') }
        usernameField { $('#j_username')}
        passwordField { $('#j_password')}
        signInButton  { $('#sign-in-btn') }
    }

    def doLogin() {
        usernameField.value('tm1c14')
        passwordField.value('Zinzi1ee')
        signInButton.click()
    }


}
