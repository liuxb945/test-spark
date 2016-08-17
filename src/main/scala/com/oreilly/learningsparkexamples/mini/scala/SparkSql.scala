package com.oreilly.learningsparkexamples.mini.scala

import org.apache.spark.SparkContext

object SparkSql {

  def main(args: Array[String]) {

    val sc = new SparkContext("local", "BasicMap", System.getenv("SPARK_HOME"))
    val sqlContext = new org.apache.spark.sql.SQLContext(sc)

    val df = sqlContext.jsonFile("/my-data/opt/learn-spark/people.json")

    // Displays the content of the DataFrame to stdout
    df.show()
  }
}