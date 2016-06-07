package com.uosbanner.pages

import geb.Page

/**
 * Created by tm1c14 on 14/12/2015.
 */
class CrnAssignmentFormPage extends Page{

    static at = { title == 'SZAASGN-CRN Assignment - Create' }
    static url = "crnAssignment/create"

    static content = {
        addCrnRecordButton { $('#addCrnRecordButton') }
        formMessage        { $('.form-message')}
    }
}
