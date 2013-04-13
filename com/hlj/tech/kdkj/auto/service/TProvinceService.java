


package com.hlj.tech.kdkj.auto.service ;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.hlj.tech.kdkj.auto.entities.TProvince;
import com.bstek.bdf.pagination.Pagination;

public interface TProvinceService {


	public Short insertTProvince(TProvince tProvince) throws Exception;

	public Short insertTProvinceSelective(TProvince tProvince) throws Exception;

	public void deleteTProvinceById(Short id) throws Exception;
	
	public void deleteTProvinceByBean(TProvince tProvince) throws Exception;

	public void updateTProvince(TProvince tProvince) throws Exception;

   	public void updateTProvinceSelective(TProvince tProvince) throws Exception;
  	
	public TProvince getTProvinceById(Short id);

	public List<TProvince> getAllTProvince();

	public Collection<TProvince> getAllTProvince(	Map<String, Object> parameter);

	public Collection<TProvince> getAllTProvinceByBean(TProvince tProvince);

	public Pagination<TProvince> getPageAllTProvinceByCondition(Map<String, Object> map,int pageIndex,int pageSize);

	public Pagination<TProvince> getPageAllTProvinceByBean(TProvince tProvince, int pageIndex, int pageSize);

	public Pagination<TProvince> getPageAllTProvince(int pageIndex,int pageSize);


}
