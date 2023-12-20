package com.cabexas

import cats.effect.ExitCode
import cats.effect.IO
import cats.effect.IOApp
import org.http4s.circe.CirceEntityDecoder._
import org.http4s.ember.client.EmberClientBuilder

object AwairExporter extends IOApp {

  val httpClient = EmberClientBuilder.default[IO].build

  override def run(args: List[String]): IO[ExitCode] =
    httpClient.use: client =>
      client
        .expect[AwairData]("http://172.20.30.202/air-data/latest")
        .as(ExitCode.Success)

}
