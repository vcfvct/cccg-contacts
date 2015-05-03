package org.cccgermantown.web.controller;

import org.cccgermantown.web.model.HymnsEntity;
import org.cccgermantown.web.service.HymnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by LeOn on 5/2/15.
 */
@RestController
@RequestMapping("/api/hymns")
public class HmynsRestController
{
    @Autowired
    HymnsService hymnsService;

    @RequestMapping("/all")
    public List<HymnsEntity> getAllHymns()
    {
        return hymnsService.getAllHymns();
    }

}
