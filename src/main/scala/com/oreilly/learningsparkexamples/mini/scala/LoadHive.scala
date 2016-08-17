/**
 * Illustrates loading Hive data using Spark SQL
 */
package com.oreilly.learningsparkexamples.scala

import org.apache.spark._
import org.apache.spark.sql.hive.HiveContext


object LoadHive {
  def main(args: Array[String]) {
//    if (args.length < 2) {
//      println("Usage: [sparkmaster] [tablename]")
//      return
//    }
//    val master = args(0)
//    val tableName = args(1)
    val sc = new SparkContext("local", "LoadHive", System.getenv("SPARK_HOME"))
    val hiveCtx = new HiveContext(sc)
    val input = hiveCtx.sql("FROM test SELECT a, b")
    val data = input.map(_.getInt(1))
    println(data.collect().toList)
    }
}
