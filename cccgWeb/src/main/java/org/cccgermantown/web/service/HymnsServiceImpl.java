package org.cccgermantown.web.service;

import org.cccgermantown.web.dao.HymnsDao;
import org.cccgermantown.web.model.HymnsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LeOn on 5/2/15.
 */
@Service
public class HymnsServiceImpl implements HymnsService
{
    @Autowired
    HymnsDao hymnsDao;

    @Override
    public List<HymnsEntity> getAllHymns()
    {
        return hymnsDao.findAll(HymnsEntity.class);
    }

}
