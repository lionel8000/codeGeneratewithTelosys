
package com.hlj.tech.kdkj.auto.service ;

import com.hlj.tech.kdkj.auto.dao.TProvinceDao;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import com.hlj.tech.kdkj.auto.entities.TProvince;
import com.bstek.bdf.pagination.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;


@Component
public class TProvinceServiceImpl implements TProvinceService{
        
    @Resource
	TProvinceDao tProvinceDao;

	public Short insertTProvince(TProvince tProvince) throws Exception{
	    return tProvinceDao.insertTProvince(tProvince);
	}

	public void deleteTProvinceById(Short id) throws Exception{
		tProvinceDao.deleteTProvinceById(id);
	}

	public void updateTProvince(TProvince tProvince) throws Exception{
		tProvinceDao.updateTProvince(tProvince);
	}

	
	
	public TProvince getTProvinceById(Short id){
		return tProvinceDao.getTProvinceById(id);
	}

	public List<TProvince> getAllTProvince(){
		return tProvinceDao.getAllTProvince();
	}

	public Collection<TProvince> getAllTProvince(Map<String, Object> parameter){
		return tProvinceDao.getAllTProvince(parameter);
	}

	public Pagination<TProvince> getPageAllTProvinceByCondition(Map<String, Object> map, int pageIndex,int pageSize){
		return tProvinceDao.getPageAllTProvinceByCondition(map,pageIndex,pageSize);	
	}

	public Pagination<TProvince> getPageAllTProvince(int pageIndex,int pageSize){
		return tProvinceDao.getPageAllTProvince(pageIndex,pageSize);
	}

}
