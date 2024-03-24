package service;

import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class elasticsearchService {
    public void insert(String id, String body, RestHighLevelClient client, String index) throws IOException {
        IndexRequest indexRequest = new IndexRequest(index);
        indexRequest.id(id);
        indexRequest.source("body",body);
        client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println("Inserted data with id: " + id + ", body: " + body);
    }
    public boolean checkIfIndexExists(RestHighLevelClient client, String indexName) throws IOException {
        GetIndexRequest request = new GetIndexRequest();
        request.indices(indexName);
        return client.indices().exists(request, RequestOptions.DEFAULT);
    }
}
