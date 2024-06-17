package com.example.ToolManagment.api.contactPerson;

import com.example.ToolManagment.api.contactPerson.dto.ContactPersonDtoAdd;
import com.example.ToolManagment.domain.contactperson.ContactPerson;
import com.example.ToolManagment.domain.contactperson.ContactPersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactperson")
public class ContactPersonController {
    final ContactPersonRepository contactPersonRepository;

    public ContactPersonController(ContactPersonRepository contactPersonRepository) {
        this.contactPersonRepository = contactPersonRepository;
    }

    @GetMapping("/all")
    public List<ContactPerson> getAllContactPersons() {
        return contactPersonRepository.findAll();
    }

    @GetMapping("/{id}")
    ContactPerson getById(@PathVariable Integer id) {
        return contactPersonRepository.findById(id).get();
    }

    @PostMapping("/add")
    ContactPerson add(@RequestBody ContactPersonDtoAdd commandDto) {
        ContactPerson contactPersonToBeSaved = new ContactPerson();
        contactPersonToBeSaved.setName(commandDto.getName());
        contactPersonToBeSaved.setSurname(commandDto.getSurname());
        contactPersonToBeSaved.setPhoneNumber(commandDto.getPhoneNumber());
        return contactPersonRepository.save(contactPersonToBeSaved);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> delete(@PathVariable Integer id) {
        ContactPerson contactPersonToDelete = contactPersonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("The Person with the id " + id + " does not exist"));
        contactPersonRepository.delete(contactPersonToDelete);
        return ResponseEntity.ok("The person entry has been deleted");
    }
}
