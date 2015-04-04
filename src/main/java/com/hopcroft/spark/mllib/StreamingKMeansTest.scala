package com.hopcroft.spark.mllib

import org.apache.spark._
import org.apache.spark.streaming._
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.clustering.StreamingKMeans

/**
 * Created by Ivan on 04/04/2015.
 */
object StreamingKMeansTest {
  def main(args: Array[String]) {

    val conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount")
    val ssc = new StreamingContext(conf, Seconds(10))
    val trainingData = ssc.textFileStream("C:\\data\\linear\\training").map(Vectors.parse).cache()
    val testData = ssc.textFileStream("C:\\data\\linear\\testing").map(LabeledPoint.parse)

    trainingData.count()
    testData.count()

    val numDimensions = 3
    val numClusters = 2
    val model = new StreamingKMeans().setK(numClusters).setDecayFactor(1.0).setRandomCenters(numDimensions, 0.0)

    model.trainOn(trainingData)
    model.predictOnValues(testData.map(lp => (lp.label, lp.features))).print()

    ssc.start()
    ssc.awaitTermination()
  }
}

