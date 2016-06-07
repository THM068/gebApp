package com.uosbanner.pages
import geb.Page
/**
 * Created by tm1c14 on 10/11/2015.
 */
class GrailsPage extends Page {

    static content = {
        signoutLink { $('#signOutText')}
    }

    def clickSignout() {
        signoutLink.click()
    }
}
