package controllers

import javax.inject._

import models.Message
import play.api.mvc._

@Singleton
class MessageController @Inject()(components: ControllerComponents)
    extends AbstractController(components) {

  def index: Action[AnyContent] = Action {
    val messageSeq =
      Seq(Message("挨拶", "こんにちは", "山田 太郎"), Message("Greeting", "Hello", "Taro Yamada"))
    Ok(views.html.message(messageSeq))
  }
}
