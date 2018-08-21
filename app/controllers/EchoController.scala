package controllers

import javax.inject._

import play.api.mvc._

@Singleton
class EchoController @Inject()(components: ControllerComponents)
    extends AbstractController(components) {

  def echo: Action[AnyContent] = Action { request =>
    val message = request.queryString("message").head
    Ok(views.html.echo(message))
  }

}
