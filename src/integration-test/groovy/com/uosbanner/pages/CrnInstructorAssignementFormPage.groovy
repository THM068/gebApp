package com.uosbanner.pages
import geb.Page
class CrnInstructorAssignementFormPage extends GrailsPage {

    static at = { title == 'SZCRNIN-CRN Assignment - Create'}

    static url = 'crnInstructorAssignement/create'

    static content = {
        formMessage(required: false) { $('.form-message') }
        crnInstructorAddButton { $('.crnInstructorAddButton') }
    }
}
