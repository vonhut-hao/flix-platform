package com.flix.flixintegrationtest.identity.api.auth

import com.flix.common.enums.Role
import com.flix.flixintegrationtest.common.BaseITSpec
import com.flix.flixintegrationtest.identity.config.BaseIT
import io.restassured.RestAssured
import org.springframework.http.HttpStatus

class AuthItSpec extends BaseITSpec {

    //Login Tests

    def "should login successfully with valid credentials"() {
        given:
        createAdminUser()

        when:
        def response = RestAssured.given()
                .body([username: "admin@flix.com", password: "Admin@123"])
                .post(BaseIT.LOGIN_API)

        then:
        response.statusCode() == 200
        response.body().jsonPath().getString("data.accessToken") != null
    }

    def "should fail login with invalid credentials"() {
        when:
        def response = RestAssured.given()
                .body([username: "asdasd", password: "asdasd"])
                .post(BaseIT.LOGIN_API)
        then:
        response.statusCode() == 401
        response.body().jsonPath().getString("detail").equalsIgnoreCase("Invalid username or password")
    }

    //Register Tests

    def "should register normal successfully with valid data"() {
        given:
        def userData = [username: "test",
                        email   : "test@gmail.com",
                        password: "Test@123",]

        when:
        def response = RestAssured.given()
                .body(userData)
                .post(BaseIT.REGISTER_NORMAL_API)

        then:
        def userSaved = userRepository.findByEmail("test@gmail.com").get()

        response.statusCode() == HttpStatus.CREATED.value()
        response.body().jsonPath().getString("data.accessToken") != null
        userSaved.username == userData.username
        userSaved.email == userData.email
        userSaved.password != userData.password
        userSaved.isEnabled == false
        userSaved.isVerified == false
        userSaved.roles.contains(Role.USER)
    }
}