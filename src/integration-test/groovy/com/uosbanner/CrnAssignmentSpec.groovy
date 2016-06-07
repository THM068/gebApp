package com.uosbanner
import com.uosbanner.BaseSpec
import com.uosbanner.pages.CrnAssignmentFormPage
import com.uosbanner.pages.CrnAssignmentPage
import com.uosbanner.pages.CrnInstructorAssignementPage
import com.uosbanner.pages.HomePage
import com.uosbanner.pages.LoginPage
import grails.test.mixin.integration.Integration

/**
 * Created by tm1c14 on 14/12/2015.
 */
@Integration
class CrnAssignmentSpec extends BaseSpec  {


    def 'The crn assignment list page is displayed'() {
        given:
            to LoginPage
            assert at(LoginPage)
            doLogin()
            assert at(HomePage)
        when:
            crnAssignmentLink.click()
        then:
            at(CrnAssignmentPage)
    }

    def 'We can search for the crns an instructor is assigned to'() {
        given:''
            gotoCrnInstructorAssignementPage()
        when:
            doSearch(bannerId, termcode)
        then:
            waitFor { crnTextFields.value() == '31127' }
            sessionTextFields.value() == '01'
            subjectCodesTextFields.value() == 'PAIR'
            courseNumberTextFields.value() == '6008'
        where:
            bannerId = '2587033'
            termcode  = '201415'
    }

    def 'A CRN assignment form can be displayed'() {
        given:
            gotoCrnInstructorAssignementPage()
            doSearch(bannerId, termcode)
        when:
            addCrnButton.click()
        then:
            at CrnAssignmentFormPage
        where:
            bannerId = '2587033'
            termcode  = '201415'
    }

    def 'An error message is displayed when a compulsory field is not completed'() {
        given:
            gotoCrnInstructorAssignementPage()
            doSearch(bannerId, termcode)
            addCrnButton.click()
            at CrnAssignmentFormPage
        when:
            addCrnRecordButton.click()
        then:
            waitFor { formMessage.text() == expectedMessage}
        where:
            bannerId = '2587033'
            termcode  = '201415'
            expectedMessage = 'Compulsary params cannot have null value'

    }

    public void gotoCrnInstructorAssignementPage() {
        to LoginPage
        assert at(LoginPage)
        doLogin()
        assert at(HomePage)
        crnAssignmentLink.click()
        assert at(CrnAssignmentPage)
    }
}
