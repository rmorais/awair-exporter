package com.cabexas

import io.circe.Codec

final case class AwairData(
    timestamp: String,
    score: Int,
    dewPoint: Double,
    temperature: Double,
    humidity: Double
)

object AwairData {

  implicit val awairDataCodec: Codec[AwairData] =
    Codec.forProduct5("timestamp", "score", "dew_point", "temp", "humid")(
      AwairData.apply
    )(d => (d.timestamp, d.score, d.dewPoint, d.temperature, d.humidity))
}
