package org.cccgermantown.web.contact.controller;

import org.cccgermantown.web.contact.model.CntctEntity;
import org.cccgermantown.web.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by LeOn on 11/29/14.
 */
@RestController
@RequestMapping("/rest/contact")
public class ContactRestController {
    @Autowired
    private ContactService contactService;

    @RequestMapping("/all")
    public List<CntctEntity> getAllContacts()
    {
       return contactService.getAllContacts();
    }
}
