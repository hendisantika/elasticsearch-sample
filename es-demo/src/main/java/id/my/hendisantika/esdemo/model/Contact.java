package id.my.hendisantika.esdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by IntelliJ IDEA.
 * Project : elasticsearch-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/16/24
 * Time: 17:19
 * To change this template use File | Settings | File Templates.
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "contacts")
public class Contact {
    @Id
    String id;
    String name;
    String email;
    Integer age;
}
