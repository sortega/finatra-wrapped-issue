package finatraissue

import com.twitter.finatra.http.{Controller, HttpServer}
import com.twitter.finatra.http.routing.HttpRouter
import com.twitter.inject.domain.WrappedValue

final case class Name(value: String) extends AnyVal with WrappedValue[String]

final case class Person(name: Name)

class PersonController extends Controller {
  put("/person") { person: Person =>
    response.ok.json(person)
  }
}

object Launcher extends HttpServer {
  override protected def configureHttp(router: HttpRouter): Unit = {
    router.add[PersonController]
  }
}
