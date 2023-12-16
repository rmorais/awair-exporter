import com.cabexas.AwairData
import io.circe.parser.decode

// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class MySuite extends munit.FunSuite {
  test("example test that succeeds") {

    val input =
      """{"timestamp":"2023-12-15T22:28:50.175Z","score":80,"dew_point":12.05,"temp":19.11,"humid":63.61,"abs_humid":10.41,"co2":926,"co2_est":808,"co2_est_baseline":36522,"voc":333,"voc_baseline":38906,"voc_h2_raw":25,"voc_ethanol_raw":35,"pm25":8,"pm10_est":9}"""
    val expected =
      AwairData("2023-12-15T22:28:50.175Z", 80, 12.05, 19.11, 63.61)
    assertEquals(decode[AwairData](input), Right(expected))
  }
}
