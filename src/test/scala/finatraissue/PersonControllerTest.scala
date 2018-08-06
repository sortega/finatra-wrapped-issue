package finatraissue

import com.twitter.finagle.http.{Request, Status}
import com.twitter.finatra.http.{EmbeddedHttpServer, HttpServer, HttpTest}
import com.twitter.finatra.http.filters.ExceptionMappingFilter
import com.twitter.finatra.http.routing.HttpRouter
import com.twitter.inject.server.FeatureTest
import org.scalatest.Matchers

class PersonControllerTest extends FeatureTest with HttpTest with Matchers {
  override protected def server: EmbeddedHttpServer =
    new EmbeddedHttpServer(new HttpServer {
      override def configureHttp(router: HttpRouter): Unit = {
        router
          .filter[ExceptionMappingFilter[Request]]
          .add[PersonController]
      }
    })

  test("put") {
    server.httpPut(path = "/person",
                   putBody = """{ "name": "paco" }""",
                   andExpect = Status.Ok)
  }
}
