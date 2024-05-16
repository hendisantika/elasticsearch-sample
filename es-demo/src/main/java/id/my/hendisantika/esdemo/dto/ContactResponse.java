package id.my.hendisantika.esdemo.dto;

import id.my.hendisantika.esdemo.model.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : elasticsearch-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/16/24
 * Time: 17:22
 * To change this template use File | Settings | File Templates.
 */

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ContactResponse {
    List<Contact> list;
    Contact row;
    String error;
}
