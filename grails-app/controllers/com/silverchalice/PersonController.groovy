package com.silverchalice

class PersonController {

    def index() {

        def employee1 = new Employee(name: 'Amy')
        def employee2 = new Employee(name: 'Bob')
        def employee3 = new Employee(name: 'Carol')
        def employee4 = new Employee(name: 'Dick')
        def employee5 = new Employee(name: 'Evelyn')


        def employer1 = new Employer(name: null, company: "ACME Boating",
                employees: [employee1, employee2, employee3, employee4, employee5])
        def employer2 = new Employer(name: "Arnold", company: "ACME EZ-Pitch Tents",
                employees: [employee1, employee2, employee3, employee4, employee5])
        def employer3 = new Employer(name: "Bonnie", company: "ACME EZ-Pitch Tents",
                employees: [employee1, employee2])

        println "Employer1: ${employer1.validate()}"
        println "Employer2: ${employer2.validate()}"
        println "Employer3: ${employer3.validate()}"

        render "Done"

    }
}
