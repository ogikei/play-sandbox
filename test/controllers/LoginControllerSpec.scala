package controllers

import org.scalatest._
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.test._
import play.api.test.CSRFTokenHelper._
import play.api.test.Helpers._

class LoginControllerSpec extends FunSpec
    with MustMatchers with GuiceOneAppPerSuite {

  describe("controller spec") {
    describe("LoginController#index") {
      it("should be valid") {
        val loginController = app.injector.instanceOf[LoginController]
        val result = loginController.index.apply(FakeRequest().withCSRFToken)
        status(result) mustBe OK
      }
    }
    describe("LoginController#login") {
      it("should be valid") {
        val loginController = app.injector.instanceOf[LoginController]
        val result = loginController.login.apply(
          FakeRequest()
              .withFormUrlEncodedBody("email" -> "test1@test.com", "password" -> "test1")
              .withCSRFToken
        )
        status(result) mustBe SEE_OTHER
      }
    }
  }

  describe("route spec") {
    describe("route of LoginController#index") {
      it("should be valid") {
        val result = route(app, FakeRequest(GET, routes.LoginController.index().toString)).get
        status(result) mustBe OK
      }
    }
    describe("route of LoginController#login") {
      it("should be valid") {
        val result = route(app,
          FakeRequest(POST,
            routes.LoginController.login().toString)
              .withFormUrlEncodedBody("email" -> "test1@test.com", "password" -> "test1")).get
        status(result) mustBe SEE_OTHER
      }
    }
  }

}
