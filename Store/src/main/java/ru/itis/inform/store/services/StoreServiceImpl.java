package ru.itis.inform.store.services;

import ru.itis.inform.store.dao.ItemsDao;
import ru.itis.inform.store.dao.ItemsDaoFileBasedImpl;

import java.io.FileNotFoundException;

public class StoreServiceImpl implements StoreService {

    ItemsDao itemsDao;

    public StoreServiceImpl(ItemsDao itemsDao) {
        this.itemsDao = itemsDao;
    }

    public void buy(String itemName) {
        itemsDao.delete(itemName);
    }

    public boolean isExist(String itemName) {
        return itemsDao.select(itemName) != null;
    }
public static void main(String [] args) throws FileNotFoundException {
    ItemsDaoFileBasedImpl idfi = new ItemsDaoFileBasedImpl("/Users/Moskieva/IdeaProjects/Store/src/main/java/ru/itis/inform/store/services/list.txt");
    idfi.read();
    System.out.println(idfi.select("товар1")); 

 }
}