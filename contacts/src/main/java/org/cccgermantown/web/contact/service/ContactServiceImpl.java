package org.cccgermantown.web.contact.service;

import org.cccgermantown.web.contact.dao.ContactDao;
import org.cccgermantown.web.contact.model.CntctEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by LeOn on 12/25/14.
 */
@Service
@Transactional
public class ContactServiceImpl implements ContactService
{
    @Autowired
    private ContactDao contactDao;

    @Override
    public List<CntctEntity> getAllContacts()
    {
        return contactDao.findAll(CntctEntity.class);
    }
}
