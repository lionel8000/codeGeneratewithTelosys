package com.hlj.tech.kdkj.auto.manager;

import com.hlj.tech.kdkj.auto.entities.TStudent;
import com.hlj.tech.kdkj.auto.service.TStudentService;
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


@Component("studentManagerPR")
public class TStudentManagerPR{
   
   private static Logger log = LoggerFactory.getLogger(TStudentManagerPR.class);  

	@Autowired
	private TStudentService tStudentService;
	
	/**
	 * 
	 * 
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	//studentManagerPR#getAllTStudent
	@DataProvider
	public Collection<TStudent> getAllTStudent(Map<String, Object> parameter) throws Exception{
		if(!this.hasParameter(parameter)){
			return tStudentService.getAllTStudent();
		}else{
			return tStudentService.getAllTStudent(parameter);
		}
	}
	
   	//studentManagerPR#getPageAllTStudent
	@DataProvider
	public void getPageAllTStudent(Page<TStudent> page, Map<String, Object> parameter) throws Exception{

	    Pagination<TStudent> p = null;
		if(!this.hasParameter(parameter)){
			p=tStudentService.getPageAllTStudent( page.getPageNo(), page.getPageSize());
		}else{
			p=tStudentService.getPageAllTStudentByCondition(parameter,page.getPageNo(), page.getPageSize());	
		}
		page.setEntities(p.getResults());
		page.setEntityCount(p.getTotalCount());
	}

	//studentManagerPR#saveAllTStudent
	@DataResolver
	public void saveAllTStudent(Collection<TStudent> coll) throws Exception{
		
		@SuppressWarnings("unchecked")
		Iterator<TStudent> iter=EntityUtils.getIterator(coll, FilterType.DIRTY);
		while(iter.hasNext()){
			TStudent tStudent=iter.next();
			EntityState state=EntityUtils.getState(tStudent);
			if(state.equals(EntityState.NEW)){
				tStudentService.insertTStudentSelective(tStudent);
			}
			if(state.equals(EntityState.MODIFIED)){
				tStudentService.updateTStudentSelective(tStudent);
			}
			if(state.equals(EntityState.DELETED)){
				tStudentService.deleteTStudentByStudentId(tStudent.getStudentId());
			}
		}
	}
	
	private boolean hasParameter(Map parameter){
		return parameter!=null;		
	}	
}
