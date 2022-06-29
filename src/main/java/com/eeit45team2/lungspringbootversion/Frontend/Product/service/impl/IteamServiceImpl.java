package com.eeit45team2.lungspringbootversion.Frontend.Product.service.impl;

import com.eeit45team2.lungspringbootversion.Frontend.Product.model.ItemBean;
import com.eeit45team2.lungspringbootversion.Frontend.Product.repo.ItemRepo;
import com.eeit45team2.lungspringbootversion.Frontend.Product.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IteamServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public List<ItemBean> findAll() {
        return itemRepo.findAll();
    }

    @Override
    public void save(ItemBean itemBean) {
        itemRepo.save(itemBean);
    }

    @Override
    public ItemBean FindById(Long itemId) {
        return itemRepo.findById(itemId).get();
    }

    @Override
    public void delete(Long itemId) {
        Long id = Long.valueOf(itemId);
        itemRepo.deleteById(id);
    }
}
