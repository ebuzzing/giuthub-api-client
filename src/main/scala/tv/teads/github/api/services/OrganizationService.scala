package tv.teads.github.api.services

import scala.concurrent.{ExecutionContext, Future}

import akka.actor.ActorRefFactory
import tv.teads.github.api.model._
import tv.teads.github.api.GithubApiClientConfig

class OrganizationService(config: GithubApiClientConfig) extends GithubService(config) with GithubApiCodecs {

  def fetchOrg(implicit refFactory: ActorRefFactory, ec: ExecutionContext): Future[Option[Organization]] =
    fetchOptional[Organization](s"orgs/${config.owner}", s"Fetching organization ${config.owner} failed")

  def fetchUserOrgs(user: String)(implicit refFactory: ActorRefFactory, ec: ExecutionContext): Future[List[Org]] =
    fetchMultiple[Org](s"users/$user/orgs", s"Fetching organizations for user $user failed")

}
