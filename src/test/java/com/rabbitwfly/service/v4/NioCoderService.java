package com.rabbitwfly.service.v4;

import com.rabbitwfly.dao.v4.AccountDao;
import com.rabbitwfly.dao.v4.ItemDao;
import com.rabbitwfly.stereotype.Autowired;
import com.rabbitwfly.stereotype.Component;

/**
 * @Author chentao
 * Date 2019/8/6
 * Description
 **/
@Component(value = "nioCoder")
public class NioCoderService {
    @Autowired
    private AccountDao accountDao;

    @Autowired
    private ItemDao itemDao;

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public ItemDao getItemDao() {
        return itemDao;
    }
}

