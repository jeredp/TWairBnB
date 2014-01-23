package com.twairbnb

class Address {

    static belongsTo = [user: User]
    String city
    String state
    String streetAddress
    String areaCode
    Date availableStartDate
    Date availableEndDate

    static constraints = {
        availableStartDate nullable: true
        availableEndDate nullable: true
    }
}
