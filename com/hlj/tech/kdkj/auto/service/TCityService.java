package com.hlj.tech.kdkj.auto.service ;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.hlj.tech.kdkj.auto.entities.TCity;
import com.bstek.bdf.pagination.Pagination;

public interface TCityService {

	public Short insertTCity(TCity tCity) throws Exception;

	public Short insertTCitySelective(TCity tCity) throws Exception;

	public void deleteTCityById(Short id) throws Exception;
	
	public void deleteTCityByBean(TCity tCity) throws Exception;

	public void updateTCity(TCity tCity) throws Exception;

   	public void updateTCitySelective(TCity tCity) throws Exception;
  	
	public TCity getTCityById(Short id);

	public List<TCity> getAllTCity();

	public Collection<TCity> getAllTCity(	Map<String, Object> parameter);

	public Collection<TCity> getAllTCityByBean(TCity tCity);

	public Pagination<TCity> getPageAllTCityByCondition(Map<String, Object> map,int pageIndex,int pageSize);

	public Pagination<TCity> getPageAllTCityByBean(TCity tCity, int pageIndex, int pageSize);

	public Pagination<TCity> getPageAllTCity(int pageIndex,int pageSize);

}
