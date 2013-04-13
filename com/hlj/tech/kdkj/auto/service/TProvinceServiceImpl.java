
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
    
	public Short insertTProvinceSelective(TProvince tProvince) throws Exception {
	    return tProvinceDao.insertTProvinceSelective(tProvince);
	}
	
	public void deleteTProvinceById(Short id) throws Exception{
		tProvinceDao.deleteTProvinceById(id);
	}

	public void deleteTProvinceByBean(TProvince tProvince) throws Exception{
		tProvinceDao.deleteTProvinceByBean(tProvince);
	}	
	
	public void updateTProvince(TProvince tProvince) throws Exception{
		tProvinceDao.updateTProvince(tProvince);
	}

  	public void updateTProvinceSelective(TProvince tProvince) throws Exception {
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
    
	public Collection<TProvince> getAllTProvinceByBean(TProvince tProvince) {
		return tProvinceDao.getAllTProvinceByBean(tProvince);
	}

	
	public Pagination<TProvince> getPageAllTProvinceByCondition(Map<String, Object> map, int pageIndex,int pageSize){
		return tProvinceDao.getPageAllTProvinceByCondition(map,pageIndex,pageSize);	
	}
    
	public Pagination<TProvince> getPageAllTProvinceByBean(TProvince tProvince, int pageIndex, int pageSize) {
		return tProvinceDao.getPageAllTProvinceByBean(tProvince,pageIndex,pageSize);	
	}

	
	public Pagination<TProvince> getPageAllTProvince(int pageIndex,int pageSize){
		return tProvinceDao.getPageAllTProvince(pageIndex,pageSize);
	}

}
