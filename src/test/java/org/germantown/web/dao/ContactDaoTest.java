package org.germantown.web.dao;

import org.cccgermantown.web.AppConfig;
import org.cccgermantown.web.PersistenceJPAConfig;
import org.cccgermantown.web.dao.ContactDao;
import org.cccgermantown.web.model.CntctEntity;
import org.junit.Ignore;
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

    @Ignore
    @Test
    public void testFindAllContacts() {
        List<CntctEntity> result = contactDao.findAll(CntctEntity.class);
        assertThat("should not be empty", result.size() == 0, is(false));
    }
}
