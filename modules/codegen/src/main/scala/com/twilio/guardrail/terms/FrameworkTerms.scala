package com.twilio.guardrail
package terms.framework

import _root_.io.swagger.models.{ModelImpl, Operation, Path}
import cats.InjectK
import cats.data.NonEmptyList
import cats.free.Free
import com.twilio.guardrail.generators.ScalaParameter

import scala.meta._

class FrameworkTerms[F[_]](implicit I: InjectK[FrameworkTerm, F]) {
  def getFrameworkImports(tracing: Boolean): Free[F, List[Import]] =
    Free.inject(GetFrameworkImports(tracing))
  def getFrameworkImplicits(): Free[F, Defn.Object] =
    Free.inject(GetFrameworkImplicits())
}

object FrameworkTerms {
  implicit def serverTerms[F[_]](implicit I: InjectK[FrameworkTerm, F]): FrameworkTerms[F] = new FrameworkTerms[F]
}
