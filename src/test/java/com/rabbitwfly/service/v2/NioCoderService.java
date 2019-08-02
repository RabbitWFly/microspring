package com.rabbitwfly.service.v2;

import com.rabbitwfly.dao.v2.AccountDao;
import com.rabbitwfly.dao.v2.ItemDao;

/**
 * @Author chentao
 * Date 2019/7/31
 * Description
 **/
public class NioCoderService {

    private AccountDao accountDao;

    private ItemDao itemDao;

    private String url;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public ItemDao getItemDao() {
        return itemDao;
    }

    public String getUrl() {
        return url;
    }
}

