package com.twairbnb

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(AddressController)
@Mock([Address, User])
class AddressControllerSpec extends Specification {

    def aUser

    def setup() {
        aUser = new User(username: 'me', password: '1234')
    }

    def cleanup() {
    }

    void "should search by city"() {
        given: "there is an address with the city Lewiston"
            def address = new Address(city: 'lewiston', state: 'ME', streetAddress: '8 Dill st', areaCode: '04240', user: aUser)
            def address2 = new Address(city: 'chicago', state: 'IL', streetAddress: '201 Randolf', areaCode: '60614', user: aUser)
            address.save(flush: true, failOnError: true)
            address2.save(flush: true, failOnError: true)
        when: "the user searches for addresses in lewiston"
            params.city = 'lewiston'
            def result = controller.search()
        then: "the user sees the one address"
            result.addresses.size() == 1
    }

    void "should search by area code"() {
        given: "there are 2 addresses with the are code 04240"
            def address = new Address(city: 'lewiston', state: 'ME', streetAddress: '8 Dill st', areaCode: '04240', user: aUser)
            def address2 = new Address(city: 'chicago', state: 'IL', streetAddress: '201 Randolf', areaCode: '60614', user: aUser)
            def address3 = new Address(city: 'lewiston', state: 'ME', streetAddress: 'Blah st', areaCode: '04240', user: aUser)
            address.save(flush: true, failOnError: true)
            address2.save(flush: true, failOnError: true)
            address3.save(flush: true, failOnError: true)
        when: "the user searches for addresses in area code 04240"
        params.areaCode = '04240'
            def result = controller.search()
            then: "the user sees the two address"
        result.addresses.size() == 2
    }

    //this test passes yet it is not true in real life : real life it will return all Addresses
    void "should not show results"() {
        given: "there are 3 addresses"
        def address = new Address(city: 'lewiston', state: 'ME', streetAddress: '8 Dill st', areaCode: '04240', user: aUser)
        def address2 = new Address(city: 'chicago', state: 'IL', streetAddress: '201 Randolf', areaCode: '60614', user: aUser)
        def address3 = new Address(city: 'lewiston', state: 'ME', streetAddress: 'Blah st', areaCode: '04240', user: aUser)
        address.save(flush: true, failOnError: true)
        address2.save(flush: true, failOnError: true)
        address3.save(flush: true, failOnError: true)
        when: "the user navigates to search"
        def result = controller.search()
        then: "the user sees the no addresses"
        result.addresses.size() == 0
    }

}
