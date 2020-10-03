package default1;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class HelloWorldJava {

	public HelloWorldJava() {
		
	}

	public static void main(String[] args) {
		SparkSession spark = SparkSession
				  .builder()
				  .appName("Java Spark SQL basic example")
				  .master("local[*]")
				  .config("hello", true)
				.getOrCreate(); 
		

//		SparkSession spark1 = SparkSession.builder().appName("Simple Application").getOrCreate();
	//	Dataset<Row> customers = spark.read().option("header",true).csv("C://Users/lenovo/Desktop/customers.csv");
		//Dataset<Row> orders = spark.read().option("header",true).csv("C://Users/lenovo/Desktop/orders.csv");
	  
	
	}

}
