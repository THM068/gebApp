package com.uosbanner

import com.uosbanner.pages.CrnInstructorAssignementPage
import com.uosbanner.pages.HomePage
import com.uosbanner.pages.LoginPage

/**
 * Created by tm1c14 on 09/11/2015.
 */
import geb.spock.GebSpec
class BaseSpec extends GebSpec {


    def setup() {
        getBrowser().setBaseUrl("http://localhost:9090/")
    }


}
