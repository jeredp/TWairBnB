package com.twairbnb

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured

class AddressController {

    SpringSecurityService springSecurityService

    @Secured(['ROLE_USER'])
    def index() {
        User currentUser = springSecurityService.currentUser
        def myAddresses = Address.findAllByUser(currentUser)
        [myAddresses: myAddresses]
    }

    @Secured(['ROLE_USER'])
    def search() {
        def results = []
        if(params.city || params.state || params.state) {
            def criteria = Address.createCriteria()
            results = criteria.list{
                and {
                    if(params.city) {
                        ilike("city", params.city as String)
                    }
                    if(params.areaCode) {
                        eq("areaCode", params.areaCode as String)
                    }
                    if(params.state) {
                        ilike("state", params.state as String)
                    }
                }
            }
        }
        [addresses: results]
    }

    @Secured(['ROLE_USER'])
    def show(Address address) {
        [address:address]
    }
}
