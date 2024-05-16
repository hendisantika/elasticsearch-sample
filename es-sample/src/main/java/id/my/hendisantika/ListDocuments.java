package id.my.hendisantika;

import id.my.hendisantika.model.Contact;
import id.my.hendisantika.util.Mapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Project : elasticsearch-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/16/24
 * Time: 17:11
 * To change this template use File | Settings | File Templates.
 */
public class ListDocuments {
    public static void main(String[] args) {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        try {
            BoolQueryBuilder boolQuery = QueryBuilders
                    .boolQuery()
                    .should(QueryBuilders.termQuery("name.keyword", "John Doe"));

            SearchRequest searchRequest = new SearchRequest();
            SearchSourceBuilder builder = new SearchSourceBuilder().query(boolQuery);
            searchRequest.source(builder);
            SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);

            for (SearchHit hit : response.getHits().getHits()) {
                Contact row = Mapper.fromString(hit.getSourceAsString());
                System.out.println("row = " + row.getName() + " - " + row.getEmail() + " - " + row.getAge());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
