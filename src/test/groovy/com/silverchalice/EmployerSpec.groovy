package com.silverchalice

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Unroll

/**
 * Created by zak on 1/26/16.
 */

@TestMixin(GrailsUnitTestMixin)
class EmployerSpec {

    Employee employee1, employee2, employee3, employee4, employee5

    def setup() {
        employee1 = new Employee(name: 'Amy')
        employee2 = new Employee(name: 'Bob')
        employee3 = new Employee(name: 'Carol')
        employee4 = new Employee(name: 'Dick')
        employee5 = new Employee(name: 'Evelyn')
    }

    @Unroll
    void testPersonConstraints() {
        when: "set up an employer without name"
        def employer = new Employer(name: null, company: "ACME Boating",
                employees: [employee1, employee2, employee3, employee4, employee5])

        then:
        !employer.validate()

        when: "Give her a name"
        employer.name = "Bonnie"

        then:
        employer.validate()
    }

    @Unroll
    void testEmployerConstraints() {
        when:"set up an employer with valid props"
        def employer = new Employer(name: "Arnold", company: "ACME EZ-Pitch Tents",
                employees: [employee1, employee2, employee3, employee4, employee5])
        then:
        employer.validate()

        when: "Remove an employee"
        employer.employees.remove(0)//Employer constraints for min:5 employees

        then:
        !employer.validate()
        employer.errors.allErrors.each { println it }
    }


}
