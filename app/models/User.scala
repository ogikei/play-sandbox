package models

import scalikejdbc._
import skinny.orm._

case class User(id: Option[Long] = None, email: String, password: String)

object User extends SkinnyCRUDMapper[User] {

  override def tableName: String = "users"

  override val columns = Seq("id", "email", "password")

  override def defaultAlias: Alias[User] = createAlias("u")

  override def extract(rs: WrappedResultSet, n: scalikejdbc.ResultName[User]): User =
    autoConstruct(rs, n)

  def create(user: User)(implicit session: DBSession): Long =
    createWithAttributes(toNamedValues(user): _*)

  private def toNamedValues(record: User): Seq[(Symbol, Any)] = Seq(
    'email -> record.email,
    'password -> record.password
  )

  def update(user: User)(implicit session: DBSession): Int =
    updateById(user.id.get).withAttributes(toNamedValues(user): _*)

  def createAll(userSeq: Seq[User])(implicit session: DBSession): Seq[Int] = {
    val c = column
    val batchParams = userSeq.map(e => Seq(e.email, e.password))
    withSQL {
      insertInto(User).namedValues(c.email -> sqls.?, c.password -> sqls.?)
    }.batch(batchParams: _*).apply()
  }

}
