package default1;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.functions;

public class SparkJarDeployTest {

	public SparkJarDeployTest() {
	
	}

	public static void main(String[] args) {
	org.apache.spark.sql.SparkSession spark=org.apache.spark.sql.SparkSession.builder().appName("hello").config("spark.master", "local").getOrCreate();
	
		
		SQLContext sqlContext = new org.apache.spark.sql.SQLContext(spark);
			
		Dataset<Row> logData = spark.read().option("header","true").format("com.databricks.spark.csv")
				.csv("C:\\Users\\lenovo\\Downloads\\new.csv");
		
		
		Dataset<Row> logData1 = spark.read().option("header","true").format("com.databricks.spark.csv").csv("C:\\Users\\lenovo\\Downloads\\new2.csv");

		final Dataset<Row> allDataFamilyDf = logData1.withColumn("FamilySize",
			    functions.col("id").plus(functions.col("name")));
		
		allDataFamilyDf.show();
		
		
		logData1.filter("name=='tushar'").show();
		
		logData.printSchema();
		
		logData.show();
		
	
		
		sqlContext.registerDataFrameAsTable(logData,"new12");
		
		sqlContext.registerDataFrameAsTable(logData1,"new123");
		
		
		Dataset<Row> logData123=sqlContext.sql("select id,name from new12");
		
		Dataset<Row> logData1234=sqlContext.sql("select id,name from new123");
		
		logData1234.col("id").equalTo(logData1234.col("id"));
		
		logData123.show();
		
		logData123.registerTempTable("logData1234");
		logData1234.registerTempTable("dfprofile");
		
	Dataset<Row> logData12345=sqlContext.sql("SELECT * FROM  logData1234 INNER JOIN  dfprofile ON logData1234.id == dfprofile.id");
		
		
		Dataset<Row> logData4321=sqlContext.sql("SELECT * FROM  logData1234 LEFT JOIN  dfprofile ON logData1234.id == dfprofile.id");
		
		
		Dataset<Row> logData432=sqlContext.sql("SELECT * FROM  logData1234 RIGHT JOIN  dfprofile ON logData1234.id == dfprofile.id");
		
		Dataset<Row> logData43=sqlContext.sql("SELECT * FROM  logData1234 RIGHT OUTER JOIN  dfprofile ON logData1234.id == dfprofile.id");
		
		Dataset<Row> logData4=sqlContext.sql("SELECT * FROM  logData1234 LEFT OUTER JOIN  dfprofile ON logData1234.id == dfprofile.id");
		
		/*
		 * logData.coalesce(1). write(). format("com.databricks.spark.csv").
		 * option("header", "true"). save("myfile123.csv");
		 */
	
//		 
//		
//		logData.coalesce(1).write().format("com.databricks.spark.csv").mode("overwrite")
//		.option("header","true").csv("C:/Users/lenovo/git/data_engineering_and_life/Hello1/a.csv");
//		
		
		
		logData12345.show();
		
		logData4321.show();
		
		 logData43.show();
		 
		 logData4.show();
		 
	}

}
