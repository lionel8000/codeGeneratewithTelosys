
package com.hlj.tech.kdkj.auto.service ;

import com.hlj.tech.kdkj.auto.dao.TCityDao;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import com.hlj.tech.kdkj.auto.entities.TCity;
import com.bstek.bdf.pagination.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;


@Component
public class TCityServiceImpl implements TCityService{
        
    @Resource
	TCityDao tCityDao;

	public Short insertTCity(TCity tCity) throws Exception{
	    return tCityDao.insertTCity(tCity);
	}
    
	public Short insertTCitySelective(TCity tCity) throws Exception {
	    return tCityDao.insertTCitySelective(tCity);
	}
	
	public void deleteTCityById(Short id) throws Exception{
		tCityDao.deleteTCityById(id);
	}

	public void deleteTCityByBean(TCity tCity) throws Exception{
		tCityDao.deleteTCityByBean(tCity);
	}	
	
	public void updateTCity(TCity tCity) throws Exception{
		tCityDao.updateTCity(tCity);
	}

  	public void updateTCitySelective(TCity tCity) throws Exception {
    }
	
	public TCity getTCityById(Short id){
		return tCityDao.getTCityById(id);
	}

	public List<TCity> getAllTCity(){
		return tCityDao.getAllTCity();
	}

	public Collection<TCity> getAllTCity(Map<String, Object> parameter){
		return tCityDao.getAllTCity(parameter);
	}
    
	public Collection<TCity> getAllTCityByBean(TCity tCity) {
		return tCityDao.getAllTCityByBean(tCity);
	}

	
	public Pagination<TCity> getPageAllTCityByCondition(Map<String, Object> map, int pageIndex,int pageSize){
		return tCityDao.getPageAllTCityByCondition(map,pageIndex,pageSize);	
	}
    
	public Pagination<TCity> getPageAllTCityByBean(TCity tCity, int pageIndex, int pageSize) {
		return tCityDao.getPageAllTCityByBean(tCity,pageIndex,pageSize);	
	}

	
	public Pagination<TCity> getPageAllTCity(int pageIndex,int pageSize){
		return tCityDao.getPageAllTCity(pageIndex,pageSize);
	}

}
