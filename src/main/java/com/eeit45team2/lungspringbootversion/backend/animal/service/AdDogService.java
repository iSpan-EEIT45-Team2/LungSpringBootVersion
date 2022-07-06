package com.eeit45team2.lungspringbootversion.backend.animal.service;

import com.eeit45team2.lungspringbootversion.backend.animal.model.AbDogBean;
import com.eeit45team2.lungspringbootversion.backend.animal.model.AdDogBean;
import com.eeit45team2.lungspringbootversion.backend.animal.repository.AbDogRepository;
import com.eeit45team2.lungspringbootversion.backend.animal.repository.AdDogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdDogService {



	@Autowired
	private AdDogRepository addogrepo;

	//findAll搜尋SQL無條件
	//findById條件式 get

//	public Page<AbDogBean> listAll(int pageNum) {
//		int pageSize = 7;//一頁7筆
//		//頁數 - 1 電腦0 開始 所以頁數 - 1
//		Pageable pageable =   PageRequest.of(pageNum - 1, pageSize);
//		//sql裡面叫limit 總筆數count		return abdogrepo.findAll();//指令 查詢用法
//		return abdogrepo.findAll(pageable);
//
//	}
public List<AdDogBean> addoglistAll(){
	return addogrepo.findAll();//指令 查詢用法
}

		public void save(AdDogBean addog) {
			addogrepo.save(addog);
		}


	public AdDogBean get(long adid) {
		return addogrepo.findById(adid).get();//找到這筆資料 回傳 更正用法
	}

	public void delete (long adid) {
		addogrepo.deleteById(adid);//命令
	}


}
