


package com.hlj.tech.kdkj.auto.manager;
import com.hlj.tech.kdkj.auto.entities.TProvince;

import com.hlj.tech.kdkj.auto.service.TProvinceService;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Component;

import com.bstek.bdf.pagination.Pagination;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.entity.FilterType;
import com.bstek.dorado.data.provider.Page;


@Component("provinceManagerPR")
public class TProvinceManagerPR{
	
	@Autowired
	private TProvinceService tProvinceService;
	
	/**
	 * 
	 * 
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	//provinceManagerPR#getAllTProvince
	@DataProvider
	public Collection<TProvince> getAllTProvince(Map<String, Object> parameter) throws Exception{
		if(!this.hasParameter(parameter)){
			return tProvinceService.getAllTProvince();
		}else{
			return tProvinceService.getAllTProvince(parameter);
		}
	}
	
   	//provinceManagerPR#getPageAllTProvince
	@DataProvider
	public void getPageAllTProvince(Page<TProvince> page, Map<String, Object> parameter) throws Exception{

	    Pagination<TProvince> p = null;
		if(!this.hasParameter(parameter)){
			p=tProvinceService.getPageAllTProvince( page.getPageNo(), page.getPageSize());
		}else{
			p=tProvinceService.getPageAllTProvinceByCondition(parameter,page.getPageNo(), page.getPageSize());	
		}
		page.setEntities(p.getResults());
		page.setEntityCount(p.getTotalCount());
	}

	//provinceManagerPR#saveAllTProvince
	@DataResolver
	public void saveAllTProvince(Collection<TProvince> coll) throws Exception{
		
		@SuppressWarnings("unchecked")
		Iterator<TProvince> iter=EntityUtils.getIterator(coll, FilterType.DIRTY);
		while(iter.hasNext()){
			TProvince tProvince=iter.next();
			EntityState state=EntityUtils.getState(tProvince);
			if(state.equals(EntityState.NEW)){
				tProvinceService.insertTProvince(tProvince);
			}
			if(state.equals(EntityState.MODIFIED)){
				tProvinceService.updateTProvince(tProvince);
			}
			if(state.equals(EntityState.DELETED)){
				tProvinceService.deleteTProvinceById(tProvince.getId());
			}
		}
	}
	
	private boolean hasParameter(Map parameter){
		return parameter!=null;		
	}	
}
