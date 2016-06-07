package com.uosbanner.pages

import geb.Page
class HomePage extends GrailsPage {

    static url ="/"

    static at = { title == 'Banner'}

    static content = {

        crnInstructorAssignmentLink { $('#crnInstructorAssignmentLink') }
        crnAssignmentLink { $('#crnAssignmentLink') }
    }

}
