package id.my.hendisantika.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.my.hendisantika.model.Contact;

/**
 * Created by IntelliJ IDEA.
 * Project : elasticsearch-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/16/24
 * Time: 17:07
 * To change this template use File | Settings | File Templates.
 */
public class Mapper {
    public static ObjectMapper mapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    public static String toJson(Object input) throws JsonProcessingException {
        return mapper().writeValueAsString(input);
    }

    public static Contact fromString(String input) throws JsonProcessingException {
        return mapper().readValue(input, Contact.class);
    }
}
