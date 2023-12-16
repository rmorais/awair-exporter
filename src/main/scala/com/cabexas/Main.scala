package com.cabexas

import org.http4s.ember.client.EmberClientBuilder
import cats.effect.IO
import cats.effect.IOApp
import cats.effect.ExitCode
import io.circe.parser.decode

object AwairExporter extends IOApp {

  val httpClient = EmberClientBuilder.default[IO].build

  override def run(args: List[String]): IO[ExitCode] =
    httpClient.use: client =>
      client
        .expect[String]("http://172.20.30.202/air-data/latest")
        .flatMap { d => IO.println(decode[AwairData](d)) }
        .as(ExitCode.Success)

}
