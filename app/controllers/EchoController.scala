package controllers

import javax.inject._

import play.api.mvc._

@Singleton
class EchoController @Inject()(components: ControllerComponents)
    extends AbstractController(components) {

  def echo: Action[AnyContent] = Action { request =>
    if (request.queryString.contains("message")) {
      val message = request.queryString("message").head
      Ok(views.html.echo(message))
    } else {
      BadRequest("require message parameter")
    }
  }

}
