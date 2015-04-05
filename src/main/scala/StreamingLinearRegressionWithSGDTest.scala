import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.regression.StreamingLinearRegressionWithSGD

/**
 * Created by Ivan on 05/04/2015.
 */
object StreamingLinearRegressionWithSGDTest {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[2]").setAppName("StreamingLinearRegressionWithSGD")
    val ssc = new StreamingContext(conf, Seconds(10))
    val trainingData = ssc.textFileStream("/home/centos/data/training").map(LabeledPoint.parse).cache()
    val testData = ssc.textFileStream("/home/centos/data/testing").map(LabeledPoint.parse)

    val numFeatures = 3
    val model = new StreamingLinearRegressionWithSGD().setInitialWeights(Vectors.zeros(numFeatures))

    
    val file = "/tmp/primaryTypes.csv"
    model.trainOn(trainingData)
    val predictions = model.predictOnValues(testData.map(lp => (lp.label, lp.features)))

    //predictions.saveAsTextFile(file)
    predictions.print() 

    ssc.start()
    ssc.awaitTermination()
  }
}
