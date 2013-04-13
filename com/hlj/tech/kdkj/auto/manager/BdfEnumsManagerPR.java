


package com.hlj.tech.kdkj.auto.manager;
import com.hlj.tech.kdkj.auto.entities.BdfEnums;

import com.hlj.tech.kdkj.auto.service.BdfEnumsService;
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


@Component("dfEnumsManagerPR")
public class BdfEnumsManagerPR{
	
	@Autowired
	private BdfEnumsService bdfEnumsService;
	
	/**
	 * 
	 * 
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	//dfEnumsManagerPR#getAllBdfEnums
	@DataProvider
	public Collection<BdfEnums> getAllBdfEnums(Map<String, Object> parameter) throws Exception{
		if(!this.hasParameter(parameter)){
			return bdfEnumsService.getAllBdfEnums();
		}else{
			return bdfEnumsService.getAllBdfEnums(parameter);
		}
	}
	
   	//dfEnumsManagerPR#getPageAllBdfEnums
	@DataProvider
	public void getPageAllBdfEnums(Page<BdfEnums> page, Map<String, Object> parameter) throws Exception{

	    Pagination<BdfEnums> p = null;
		if(!this.hasParameter(parameter)){
			p=bdfEnumsService.getPageAllBdfEnums( page.getPageNo(), page.getPageSize());
		}else{
			p=bdfEnumsService.getPageAllBdfEnumsByCondition(parameter,page.getPageNo(), page.getPageSize());	
		}
		page.setEntities(p.getResults());
		page.setEntityCount(p.getTotalCount());
	}

	//dfEnumsManagerPR#saveAllBdfEnums
	@DataResolver
	public void saveAllBdfEnums(Collection<BdfEnums> coll) throws Exception{
		
		@SuppressWarnings("unchecked")
		Iterator<BdfEnums> iter=EntityUtils.getIterator(coll, FilterType.DIRTY);
		while(iter.hasNext()){
			BdfEnums bdfEnums=iter.next();
			EntityState state=EntityUtils.getState(bdfEnums);
			if(state.equals(EntityState.NEW)){
				bdfEnumsService.insertBdfEnums(bdfEnums);
			}
			if(state.equals(EntityState.MODIFIED)){
				bdfEnumsService.updateBdfEnums(bdfEnums);
			}
			if(state.equals(EntityState.DELETED)){
				bdfEnumsService.deleteBdfEnumsById(bdfEnums.getId());
			}
		}
	}
	
	private boolean hasParameter(Map parameter){
		return parameter!=null;		
	}	
}
