package id.my.hendisantika.esdemo.controller;

import id.my.hendisantika.esdemo.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : elasticsearch-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/16/24
 * Time: 17:23
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;
}
