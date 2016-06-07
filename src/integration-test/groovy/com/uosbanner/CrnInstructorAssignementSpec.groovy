package com.uosbanner
import grails.test.mixin.integration.Integration
import com.uosbanner.BaseSpec
import com.uosbanner.pages.LoginPage
import com.uosbanner.pages.HomePage
import com.uosbanner.pages.CrnInstructorAssignementPage
import com.uosbanner.pages.CrnInstructorAssignementFormPage
/**
 * Created by tm1c14 on 09/11/2015.
 */
@Integration
class CrnInstructorAssignementSpec extends BaseSpec {

    def 'CrnInstructorAssignement page can be displayed'() {
        given:
            to LoginPage
            assert at(LoginPage)
            doLogin()
            assert at(HomePage)
            println crnInstructorAssignmentLink
        when:
            crnInstructorAssignmentLink.click()
        then:
            at(CrnInstructorAssignementPage)
    }

    def 'You can search for a crn given a term and crn'() {
        given:
            gotoCrnInstructorAssignementPage()
        when:
            searchForCrnInstructorAssignment(termCode,crn)
        then:
            at CrnInstructorAssignementPage
        and:
            crnSearchSubjectText.text() == expectedSubject
            crnSearchCourseText.text() ==   expectedCourse
            crnSearchTitleText.text() == expectedTitle

        where:
            termCode = '201415'
            crn = "31446"
            expectedSubject = 'PSYC'
            expectedCourse = '3056'
            expectedTitle = 'Psychooncology & Pain Research'

    }

    def 'Only one primary indicator can be assigned'() {
        given:
            gotoCrnInstructorAssignementPage()
        when:
            searchForCrnInstructorAssignment(termCode,crn)
        then:
            at CrnInstructorAssignementPage
        and:
            crnSearchSubjectText.text() == expectedSubject
            crnSearchCourseText.text() ==   expectedCourse
            crnSearchTitleText.text() == expectedTitle

        when:
            primaryIndicatorCheckbox[0].click()
            crnAssignmentUpdateButton[0].click()
        then:
            waitFor { infoOrErrorMessage.text() == expectedErrorMessage }

        where:
            termCode = '201415'
            crn = "31446"
            expectedSubject = 'PSYC'
            expectedCourse = '3056'
            expectedTitle = 'Psychooncology & Pain Research'
            expectedErrorMessage = 'An instructor already exists with Primary Indicator selected. Please amend that record before updating the primary indicator'
    }

    def 'A create CrnInstructorAssignement form  can be opened'() {
        given:
            gotoCrnInstructorAssignementPage()
            when:
            searchForCrnInstructorAssignment(termCode,crn)
        then:
            at CrnInstructorAssignementPage
        and:
            crnSearchSubjectText.text() == expectedSubject
            crnSearchCourseText.text() == expectedCourse
            crnSearchTitleText.text() == expectedTitle

        when:
            addAnInstructorButton.click()
        then:
            waitFor  { at CrnInstructorAssignementFormPage }

        where:
            termCode = '201415'
            crn = "31446"
            expectedSubject = 'PSYC'
            expectedCourse = '3056'
            expectedTitle = 'Psychooncology & Pain Research'
    }

    def 'An error message is displayed  when you save an new form without completing all the mandatory fields'() {
        given:
            gotoCrnInstructorAssignementPage()
        when:
            searchForCrnInstructorAssignment(termCode,crn)
        then:
            at CrnInstructorAssignementPage
        and:
            crnSearchSubjectText.text() == expectedSubject
            crnSearchCourseText.text() == expectedCourse
            crnSearchTitleText.text() == expectedTitle

        when:
            addAnInstructorButton.click()
        then:
            waitFor  { at CrnInstructorAssignementFormPage }

        when:
            crnInstructorAddButton.click()
        then:
            waitFor { formMessage.text().contains(expectedMessage) }

        where:
            termCode = '201415'
            crn = "31446"
            expectedSubject = 'PSYC'
            expectedCourse = '3056'
            expectedTitle = 'Psychooncology & Pain Research'
            expectedMessage  = 'Compulsary params cannot have null value'
    }

    def 'An alert box is displayed if you open CrnInstructorAssignement form without a crn and termcode'() {
        given:
            gotoCrnInstructorAssignementPage()
        expect:
            withAlert(wait: true) { addAnInstructorButton.click() } == expectedMessage
        where:
            expectedMessage = "Please enter a CRN and Term Code, and click Search"
    }


    private void gotoCrnInstructorAssignementPage() {
        to LoginPage
        assert at(LoginPage)
        doLogin()
        assert at(HomePage)
        crnInstructorAssignmentLink.click()
        assert at(CrnInstructorAssignementPage)
    }
}
