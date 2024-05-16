package id.my.hendisantika.esdemo.controller;

import id.my.hendisantika.esdemo.dto.ContactResponse;
import id.my.hendisantika.esdemo.model.Contact;
import id.my.hendisantika.esdemo.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/contacts/list")
    public ResponseEntity<ContactResponse> list() {
        ContactResponse response = new ContactResponse();
        try {
            List<Contact> result = contactService.list();
            response.setList(result);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setError(e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @GetMapping("/contacts/findById/{id}")
    public ResponseEntity<ContactResponse> findById(@PathVariable("id") String id) {
        ContactResponse response = new ContactResponse();
        try {
            Contact result = contactService.find(id);
            response.setRow(result);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setError(e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }
}
