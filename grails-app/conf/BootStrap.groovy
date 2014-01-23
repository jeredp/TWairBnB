import com.twairbnb.Address
import com.twairbnb.Role
import com.twairbnb.User
import com.twairbnb.UserRole

class BootStrap {

    def init = { servletContext ->

        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

        def testUser = new User(username: 'jphilipp@thoughtworks.com', password: 'password', name: 'Jered')
        def testUser2 = new User(username: 'abelozer@thoughtworks.com', password: 'password', name: 'Anastasia')
        def testUser3 = new User(username: 'doh@thoughtworks.com', password: 'password', name: 'David')

        createAddressesForUser(testUser, testUser2, testUser3)
        testUser.save(flush: true)
        testUser2.save(flush: true)
        testUser3.save(flush: true)

        UserRole.create testUser, userRole, true

        assert User.count() == 3
        assert Role.count() == 1
        assert UserRole.count() == 1
    }

    def destroy = {
    }

    def createAddressesForUser(User user1, user2, user3) {
        user1.addToAddresses(new Address(city: 'Lewiston', state: 'ME', streetAddress: '8 Dill st', areaCode: '04240'))
        user1.addToAddresses(new Address(city: 'Chicago', state: 'IL', streetAddress: '201 Randolf st', areaCode: '60614'))
        user1.addToAddresses(new Address(city: 'Chicago', state: 'IL', streetAddress: '202 Randolf st', areaCode: '60614'))
        user2.addToAddresses(new Address(city: 'Chicago', state: 'IL', streetAddress: '203 Randolf st', areaCode: '60614'))
        user2.addToAddresses(new Address(city: 'Chicago', state: 'IL', streetAddress: '204 Randolf st', areaCode: '60614'))
        user2.addToAddresses(new Address(city: 'Chicago', state: 'IL', streetAddress: '205 Randolf st', areaCode: '60614'))
        user2.addToAddresses(new Address(city: 'New York', state: 'NY', streetAddress: '56 st', areaCode: '10019'))
        user3.addToAddresses(new Address(city: 'New York', state: 'NY', streetAddress: '57 st', areaCode: '10019'))
        user3.addToAddresses(new Address(city: 'New York', state: 'NY', streetAddress: '58 st', areaCode: '10019'))
        user3.addToAddresses(new Address(city: 'New York', state: 'NY', streetAddress: '59 st', areaCode: '10019'))
        user3.addToAddresses(new Address(city: 'New York', state: 'NY', streetAddress: '60 st', areaCode: '10019'))
    }
}
