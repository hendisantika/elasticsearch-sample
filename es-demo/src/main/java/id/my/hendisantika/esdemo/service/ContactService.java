package id.my.hendisantika.esdemo.service;

import id.my.hendisantika.esdemo.model.Contact;
import id.my.hendisantika.esdemo.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by IntelliJ IDEA.
 * Project : elasticsearch-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/16/24
 * Time: 17:21
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public List<Contact> list() {
        return StreamSupport.stream(contactRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    public void delete(Contact contact) {
        contactRepository.delete(contact);
    }
}
