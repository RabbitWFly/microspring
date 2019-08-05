package com.rabbitwfly.service.v3;

import com.rabbitwfly.dao.v2.AccountDao;
import com.rabbitwfly.dao.v2.ItemDao;

/**
 * @Author chentao
 * Date 2019/8/5
 * Description
 **/
public class NioCoderService {

    private AccountDao accountDao;

    private ItemDao itemDao;

    private int version;

    public NioCoderService(){}

    public NioCoderService(AccountDao accountDao, ItemDao itemDao) {
        this.accountDao = accountDao;
        this.itemDao = itemDao;
    }

    public NioCoderService(AccountDao accountDao, ItemDao itemDao, int version) {
        this.accountDao = accountDao;
        this.itemDao = itemDao;
        this.version = version;
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public ItemDao getItemDao() {
        return itemDao;
    }

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}

