// Ver https://spark.apache.org/docs/latest/quick-start.html#self-contained-applications

spark-submit --class org.apache.spark.examples.SparkPi --master local[2] /path/to/examples.jar 100
spark-submit --class com.hopcroft.spark.mllib.StreamingKMeansTest.Main --master local[2] C:\Users\Ivan\IdeaProjects\advanced-analytics-spark\target\advanced-analytics-spark-1.0-SNAPSHOT.jar

// Package with sbt with 'sbt package' and run as
spark-submit --class "StreamingKMeansTest" --master local[2] target/scala-2.10/advanced-analytics-spark_2.10-1.0.jar

// Package with sbt with 'sbt package' and run as
spark-submit --class "StreamingLinearRegressionWithSGDTest" --master local[2] target/scala-2.10/advanced-analytics-spark_2.10-1.0.jar


// Avoid Warning logs in spark-shell
import org.apache.log4j.Logger
import org.apache.log4j.Level

Logger.getLogger("org").setLevel(Level.OFF)
Logger.getLogger("akka").setLevel(Level.OFF)