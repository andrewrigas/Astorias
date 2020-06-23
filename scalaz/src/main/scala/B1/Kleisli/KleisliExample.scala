package B1.Kleisli

import scalaz.Kleisli

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
object KleisliExample extends App {

  val id: String = "7"

  val response: Int = 3

  val requestFromDatabase: String => Future[Int] =
    (id: String) =>
      Future {
        //Boilerplate
        response
      }
  val processRequest: Int => Future[Int] =
    (res: Int) =>
      Future {
        res + 1
      }
  val writeToDatabase: Int => Future[Boolean] =
    (value: Int) =>
      Future {
        //Boilerplate
        true
      }

  val compoFlatMap: String => Future[Boolean] =
    id => {
      requestFromDatabase(id).flatMap(response => processRequest(response).flatMap(processed => writeToDatabase(processed)))
    }

  //Syntactic sugar
  val compoForLoop =
    for {
      response <- requestFromDatabase(id)
      processed <- processRequest(response)
      cassandraResponse <- writeToDatabase(processed)
    } yield cassandraResponse

  //Kleisli
  val requestFromDatabaseKleisli: Kleisli[Future, String, Int] = Kleisli(requestFromDatabase)
  val processRequestKleisli: Kleisli[Future, Int, Int] = Kleisli(processRequest)
  val writeToDatabaseKleisli: Kleisli[Future, Int, Boolean] = Kleisli(writeToDatabase)

  val compoKleisli: String => Future[Boolean] = ???
  //requestFromDatabaseKleisli andThen processRequestKleisli andThen writeToDatabaseKleisli

  //val kleisliRequest: Kleisli[Future, Unit, Boolean] = requestCassandra andThenK processRequest andThenK updateCassandra

}
