package com.hlj.tech.kdkj.auto.manager;

import com.hlj.tech.kdkj.auto.entities.TCity;
import com.hlj.tech.kdkj.auto.service.TCityService;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


@Component("cityManagerPR")
public class TCityManagerPR{
   
   private static Logger log = LoggerFactory.getLogger(TCityManagerPR.class);  

	@Autowired
	private TCityService tCityService;
	
	/**
	 * 
	 * 
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	//cityManagerPR#getAllTCity
	@DataProvider
	public Collection<TCity> getAllTCity(Map<String, Object> parameter) throws Exception{
		if(!this.hasParameter(parameter)){
			return tCityService.getAllTCity();
		}else{
			return tCityService.getAllTCity(parameter);
		}
	}
	
   	//cityManagerPR#getPageAllTCity
	@DataProvider
	public void getPageAllTCity(Page<TCity> page, Map<String, Object> parameter) throws Exception{

	    Pagination<TCity> p = null;
		if(!this.hasParameter(parameter)){
			p=tCityService.getPageAllTCity( page.getPageNo(), page.getPageSize());
		}else{
			p=tCityService.getPageAllTCityByCondition(parameter,page.getPageNo(), page.getPageSize());	
		}
		page.setEntities(p.getResults());
		page.setEntityCount(p.getTotalCount());
	}

	//cityManagerPR#saveAllTCity
	@DataResolver
	public void saveAllTCity(Collection<TCity> coll) throws Exception{
		
		@SuppressWarnings("unchecked")
		Iterator<TCity> iter=EntityUtils.getIterator(coll, FilterType.DIRTY);
		while(iter.hasNext()){
			TCity tCity=iter.next();
			EntityState state=EntityUtils.getState(tCity);
			if(state.equals(EntityState.NEW)){
				tCityService.insertTCitySelective(tCity);
			}
			if(state.equals(EntityState.MODIFIED)){
				tCityService.updateTCitySelective(tCity);
			}
			if(state.equals(EntityState.DELETED)){
				tCityService.deleteTCityById(tCity.getId());
			}
		}
	}
	
	private boolean hasParameter(Map parameter){
		return parameter!=null;		
	}	
}
