import org.apache.spark.{SparkContext, SparkConf}

object AveragePassenger {

  def main(args: Array[String]) {
    val master = args(0)
    val flightData = args(1)
    val conf = new SparkConf().setAppName("AveragePassenger").setMaster(master)
    val sc = new SparkContext(conf)
    val inputFile = sc.textFile(flightData)

    // Pull out total passengers and number of flights
    val res = inputFile.map(line => (Integer.parseInt(line.split("\t")(4)), Integer.parseInt(line.split("\t")(6)))).aggregate((0, 0))(
      // Accumulator to sum passengers and total fights
      (accumulator, tuple) => (accumulator._1 + tuple._1, accumulator._2 + tuple._2),
      // Accumulator to merge accumulators
      (accumulator1, accumulator2) => (accumulator1._1 + accumulator2._1, accumulator1._2 + accumulator2._2))

    val totalPassengers: Int = res._1
    val totalFlights: Double = res._2.toDouble
    val averagePassengers: Double = totalPassengers / totalFlights
    printf("Average passengers: %s", averagePassengers)
    println()
  }

}
