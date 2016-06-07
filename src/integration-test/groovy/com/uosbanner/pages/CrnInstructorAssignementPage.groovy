package com.uosbanner.pages
import  com.uosbanner.pages.GrailsPage
/**
 * Created by tm1c14 on 10/11/2015.
 */
class CrnInstructorAssignementPage extends GrailsPage {

     static pageTitle = 'SZCRNIN-CRN Instructor Assignment'

     static url = 'crnInstructorAssignement/index.zul'

     static at = { title == pageTitle }

    static content = {
        termCodeTextField            { $('#termCodeTextField')}
        crnTextField                 { $('#crnTextField') }
        searchForCRNButton           { $('#searchForCRNButton') }
        searchCrnAndTermcodeButton    { $('#submit')}
        crnSearchSubjectText(required: false) { $('.crnSearchSubjectText') }
        crnSearchCourseText(required: false) { $('.crnSearchCourseText') }
        crnSearchTitleText(required: false) { $('.crnSearchTitleText') }
        addAnInstructorButton  { $('#addAnInstructorButton')}
        infoOrErrorMessage(required: false) { $('.updateAndDeleteQueriesResultMessage .form-message') }
        primaryIndicatorCheckbox(required: false) { $('#sirasgnPrimaryInd')}
        crnAssignmentUpdateButton(required: false) { $('.crnAssignmentUpdateButton')}

    }

    def searchForCrnInstructorAssignment(String termCode, String crn) {
        termCodeTextField.value(termCode)
        crnTextField.value(crn)
        searchCrnAndTermcodeButton.click()
    }



}
