package CheckMePlease

import scalaz._
import Scalaz._

object Application {
  type Va[+A] = ValidationNel[String, A]

  def v[A](field: String, validations: Va[A]*): (String, Va[List[A]]) = {
    (field, validations.toList.sequence)
  }

  def vv[A](validations: Va[A]*): Va[List[A]] = {
    validations.toList.sequence
  }
}
