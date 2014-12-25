package org.cccgermantown.web.contact;

import org.cccgermantown.web.contact.dao.Daos;
import org.cccgermantown.web.contact.service.Services;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by LeOn on 11/30/14.
 */
@Configuration
@ComponentScan(basePackageClasses = {Daos.class, Services.class})
public class AppConfig {

}
