import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.*;

public class MongoDbJDBC {
    public static void main(String[] args) {
        try {
            //连接客户端并获取集合
            MongoClient mongoClient = new MongoClient("localhost",27017);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mytest");
            MongoCollection<Document> collection = mongoDatabase.getCollection("users");

            //查询所有文档
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> cursor = findIterable.iterator();
            while (cursor.hasNext()){
                System.out.println(cursor.next());
            }

            //插入文档
            //Document favorites = new Document("food", Arrays.asList('a','b','c','d')).append("other",Arrays.asList('1','2','3','4'));//文档作为值
            //Document document = new Document("username","lh555").append("age",555).append("favorites",favorites);
            //List<Document> documents = new ArrayList<Document>();
            //documents.add(document);
            //collection.insertMany(documents);



            //更新文档
            //collection.updateMany(Filters.eq("username","lh555"),new Document("$set",new Document("age","22")));
            //删除文档
            collection.deleteOne(Filters.eq("username","lh"));
            collection.deleteMany(Filters.eq("username","lh555"));
            findIterable = collection.find();
            for (Document adocument:findIterable){
                System.out.println(adocument);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
