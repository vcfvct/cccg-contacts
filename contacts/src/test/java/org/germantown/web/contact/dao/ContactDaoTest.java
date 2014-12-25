package org.germantown.web.contact.dao;

import org.cccgermantown.web.contact.AppConfig;
import org.cccgermantown.web.contact.PersistenceJPAConfig;
import org.cccgermantown.web.contact.dao.ContactDao;
import org.cccgermantown.web.contact.model.CntctEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by LeOn on 11/30/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {AppConfig.class, PersistenceJPAConfig.class})
public class ContactDaoTest {
    @Autowired
    ContactDao contactDao;

    @Test
    public void testFindAllContacts() {
        List<CntctEntity> result = contactDao.findAll(CntctEntity.class);
        assertThat("should not be empty", result.size() == 0, is(false));
    }
}
