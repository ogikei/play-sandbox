package controllers

import javax.inject._

import forms.Login
import play.api.data.Forms._
import play.api.data._
import play.api.i18n._
import play.api.mvc._
import play.api.Logger

@Singleton
class LoginController @Inject()(components: ControllerComponents)
    extends AbstractController(components) with I18nSupport {

  private val form = Form(
    mapping(
      "email" -> email,
      "password" -> nonEmptyText
    )(Login.apply)(Login.unapply)
  )

  // ログインページを描画(GET)
  def index = Action { implicit request =>
    Ok(views.html.login(form))
  }

  // ログインする(POST)
  def login = Action { implicit request =>
    form.bindFromRequest().fold({ formWithErrors =>
      BadRequest(views.html.login(formWithErrors))
    }, {
      login =>
        Logger.info(s"Logged In: $login")
        Redirect(routes.LoginController.index())
    })
  }

}
