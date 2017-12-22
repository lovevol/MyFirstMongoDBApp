import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDbJDBC {
    public static void main(String[] args) {
        try {
            MongoClient mongoClient = new MongoClient("localhost",27017);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mytest");
            MongoCollection<Document> collection = mongoDatabase.getCollection("users");
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> cursor = findIterable.iterator();
            while (cursor.hasNext()){
                System.out.println(cursor.next());
            }
            /*for (Document aFindIterable : findIterable) {
                System.out.println(aFindIterable);
            }*/
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
