import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexResponse;
import service.elasticsearchService;
import utils.Connection;

import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        String id = "3";
        String body = "hello";
        String index = "demo";

        //Connecting to elastic service.
        Connection connection= new Connection();
        RestHighLevelClient client = connection.createConnection();

        elasticsearchService elasticsearchservice = new elasticsearchService();
        if(!elasticsearchservice.checkIfIndexExists(client, index)) {
            System.out.println("Index does not exist: " + index);
            connection.createIndex(client, index);
        }

        elasticsearchservice.insert(id, body, client, index);

        }
}