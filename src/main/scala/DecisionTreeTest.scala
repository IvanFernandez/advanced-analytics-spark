import org.apache.spark._
import org.apache.spark.mllib.clustering.StreamingKMeans
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.streaming._
import org.apache.spark.mllib.tree.DecisionTree
import org.apache.spark.mllib.tree.model.DecisionTreeModel
import org.apache.spark.mllib.util.MLUtils

/**
 * Created by Ivan on 04/04/2015.
 */
object DecisionTreeTest {
  def main(args: Array[String]) {

    val conf = new SparkConf().setMaster("local[2]").setAppName("StreamingKMeansTest")




  }
}


