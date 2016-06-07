package com.uosbanner.pages

import geb.Page

/**
 * Created by tm1c14 on 14/12/2015.
 */
class CrnAssignmentPage extends Page {

    static at = { title == 'SZAASGN-CRN Assignment' }

    static url = 'crnAssignment/index.zul'

    static content = {
        userIdTextField { $('#userIdTextField') }
        termCodeTextField { $('#termCodeTextField') }
        searchButton { $('#submit') }
        fullNameArea(required: false) { $('#serFullNameFieldWrapperInnerFields') }
        crnTextFields(required: false){  $('.sirasgnCrn') }
        sessionTextFields(required: false){  $('.sirasgnCategory') }
        subjectCodesTextFields(required: false) {  $('.ssbsectSubjCode') }
        courseNumberTextFields(required: false) {  $('.ssbsectCrseNumb') }
        addCrnButton(required: false) {  $('#addCrnButton') }

    }

    public doSearch(String bannerId, String termCode) {
        userIdTextField.value(bannerId)
        fullNameArea.click()
        termCodeTextField.value(termCode)
        searchButton.click()

    }
}
