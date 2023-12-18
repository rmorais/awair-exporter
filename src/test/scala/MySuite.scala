import cats.Eq
import com.cabexas.AwairData
import io.circe._
import io.circe.parser._
import io.circe.testing.ArbitraryInstances
import io.circe.testing.CodecTests
import munit.DisciplineSuite
import org.scalacheck.Arbitrary
import org.scalacheck.Gen

import java.time.Instant

// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class MySuite extends DisciplineSuite {
  implicit val eqAwairData: Eq[AwairData] = Eq.fromUniversalEquals
  //this test should be replaced by circe-golden
  test("roundtrip encoding decoding") {
    val input =
      """{"timestamp":"2023-12-15T22:28:50.175Z","score":80,"dew_point":12.05,"temp":19.11,"humid":63.61,"abs_humid":10.41,"co2":926,"co2_est":808,"co2_est_baseline":36522,"voc":333,"voc_baseline":38906,"voc_h2_raw":25,"voc_ethanol_raw":35,"pm25":8,"pm10_est":9}"""
    val expected =
      AwairData("2023-12-15T22:28:50.175Z", 80, 12.05, 19.11, 63.61)
    assertEquals(decode[AwairData](input), Right(expected))
  }

  object Implicits extends ArbitraryInstances {

    implicit val arbAwairdata: Arbitrary[AwairData] = Arbitrary {
      for {
        timestamp <- Gen.const(Instant.now.toString())
        score <- Gen.chooseNum(1, 100)
        dewPoint <- Gen.posNum[Double]
        temp <- Gen.posNum[Double]
        humidity <- Gen.posNum[Double]

      } yield AwairData(timestamp, score, dewPoint, temp, humidity)
    }
  }

  import Implicits._

  checkAll("Awair", CodecTests[AwairData].codec)

}
