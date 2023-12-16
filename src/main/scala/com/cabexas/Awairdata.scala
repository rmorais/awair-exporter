package com.cabexas

import io.circe.Decoder
import io.circe.generic.semiauto._

final case class AwairData(
    timestamp: String,
    score: Int,
    dewPoint: Double,
    temperature: Double,
    humidity: Double
)

object AwairData {

  implicit val awairDataDecoder: Decoder[AwairData] = {
    Decoder.forProduct5(
      "timestamp",
      "score",
      "dew_point",
      "temp",
      "humid"
    ) { AwairData.apply }
  }
}

// {
//   "timestamp": "2023-12-15T22:28:50.175Z",
//   "score": 80,
//   "dew_point": 12.05,
//   "temp": 19.11,
//   "humid": 63.61,
//   "abs_humid": 10.41,
//   "co2": 926,
//   "co2_est": 808,
//   "co2_est_baseline": 36522,
//   "voc": 333,
//   "voc_baseline": 38906,
//   "voc_h2_raw": 25,
//   "voc_ethanol_raw": 35,
//   "pm25": 8,
//   "pm10_est": 9
// }
