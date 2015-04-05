# Installation 
This project is managed with sbt and maven:   
1) To package it with maven, run `mvn clean package -DskipTest`  
2) To package it with sbt, run `sbt package`   

# Running standalone application
[Spark self contained applications](https://spark.apache.org/docs/latest/quick-start.html#self-contained-applications)

## Running streaming KMeanst package from the project root directory
`spark-submit --class "StreamingKMeansTest" --master local[2] target/scala-2.10/advanced-analytics-spark_2.10-1.0.jar`

## Running streaming linear regression from the project root directory 
`spark-submit --class "StreamingLinearRegressionWithSGDTest" --master local[2] target/scala-2.10/advanced-analytics-spark_2.10-1.0.jar`

# Other considerations

## Avoid Warning logs in spark-shell
```java
import org.apache.log4j.Logger  
import org.apache.log4j.Level  
Logger.getLogger("org").setLevel(Level.OFF)  
Logger.getLogger("akka").setLevel(Level.OFF)
```

