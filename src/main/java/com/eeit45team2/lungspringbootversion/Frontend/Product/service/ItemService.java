package com.eeit45team2.lungspringbootversion.Frontend.Product.service;

import com.eeit45team2.lungspringbootversion.Frontend.Product.model.ItemBean;

import java.util.List;

public interface ItemService {
    public List<ItemBean> findAll();

    public void save(ItemBean itemBean);

    public ItemBean FindById(Long itemId);

    public void delete(Long itemId);

}
