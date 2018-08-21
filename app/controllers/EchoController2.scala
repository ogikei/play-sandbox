package controllers

import javax.inject._

import play.api.mvc._

@Singleton
class EchoController2 @Inject()(components: ControllerComponents)
    extends AbstractController(components) {

  def echo4: Action[AnyContent] = Action { request =>
    val message = request.queryString("message").head
    Ok(views.html.echo(message))
  }

}
