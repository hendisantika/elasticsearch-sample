package id.my.hendisantika.esdemo.repository;

import id.my.hendisantika.esdemo.model.Contact;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : elasticsearch-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/16/24
 * Time: 17:20
 * To change this template use File | Settings | File Templates.
 */
public interface ContactRepository extends ElasticsearchRepository<Contact, String> {
    Optional<Contact> findByName(String name);
}
