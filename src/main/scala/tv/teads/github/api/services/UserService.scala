package tv.teads.github.api.services

import akka.actor.ActorRefFactory
import spray.httpx.RequestBuilding._
import tv.teads.github.api.GithubApiClientConfig
import tv.teads.github.api.model._
import tv.teads.github.api.util._

import scala.concurrent.{ExecutionContext, Future}

class UserService(config: GithubApiClientConfig) extends GithubService(config) with GithubApiCodecs {

  def getUserInfo(token: String)(implicit refFactory: ActorRefFactory, ec: ExecutionContext): Future[Option[User]] = {
    val url = s"${config.apiUrl}/user"
    baseRequest(Get(url), Map.empty, Some(token)).executeRequestInto[User]().map {
      case SuccessfulRequest(userInfo, _) ⇒ Some(userInfo)
      case FailedRequest(statusCode) ⇒
        logger.error(s"Getting user info failed, status code: ${statusCode.intValue}")
        None
    }
  }
}
