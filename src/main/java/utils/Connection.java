package utils;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.settings.Settings;

import java.io.IOException;

public class Connection {

    public RestHighLevelClient createConnection(){
        String hostname = "localhost"; String scheme = "http"; int port = 9200;
        System.out.println("Connecting to server at " + hostname + ", port : " + port );
        return new RestHighLevelClient(RestClient.builder(new HttpHost(hostname, port, scheme)));
    }
    public void createIndex(RestHighLevelClient client, String index) throws IOException {
        CreateIndexRequest request = new CreateIndexRequest(index);
        request.settings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 1));
        client.indices().create(request, RequestOptions.DEFAULT);
    }

    //not used
    public GetIndexResponse getConnectionWithIndex(RestHighLevelClient client, String index) throws IOException {
        GetIndexRequest request = new GetIndexRequest(index);
        return client.indices().get(request, RequestOptions.DEFAULT);
    }



}
