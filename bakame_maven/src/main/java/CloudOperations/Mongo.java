package CloudOperations;

import com.mongodb.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

public class Mongo {

	 public static void main(String[] args) {
		
		//System.setProperty("jdk.tls.trustNameService", "true");

		MongoClient mongoClient = MongoClients.create("mongodb+srv://MaxBrillant:maxbr-37@cluster1.r5iln.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
				MongoDatabase database = mongoClient.getDatabase("myFirstDatabase");			
				MongoCollection<Document> collection = database.getCollection("students");
				Document yoyo = collection.find().first();
				System.out.println(yoyo.toJson());
			


}
	 
}
