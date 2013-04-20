;
;
package com.kdkj.p2p.controller.loan;

import com.kdkj.p2p.utils.ParameterCheck;
import com.kdkj.p2p.entities.loan.TLoanHouse;
import com.kdkj.p2p.dao.loan.TLoanHouseDao;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bstek.bdf.pagination.Pagination;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.entity.FilterType;
import com.bstek.dorado.data.provider.Page;


@Component("loanHouseController")
public class TLoanHouseController{
   
   private static Logger log = LoggerFactory.getLogger(TLoanHouseController.class);  

	@Autowired
	private TLoanHouseDao loanHouseDao;
	
	/**
	 * 
	 * 
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	//loanHouseController#getAll
	@DataProvider
	public Collection<TLoanHouse> getAll(Map<String, Object> parameter) throws Exception{
		if(ParameterCheck.hasValue(parameter)){
			return loanHouseDao.getAll(parameter);
		}else{
			return loanHouseDao.getAll();
		}
	}
	
   	//loanHouseController#getPageAll
	@DataProvider
	public void getPageAll(Page<TLoanHouse> page, Map<String, Object> parameter) throws Exception{

	    Pagination<TLoanHouse> p = null;
		if(ParameterCheck.hasValue(parameter)){
			p=loanHouseDao.getPageAll(parameter ,page.getPageNo(), page.getPageSize());
		}else{
			p=loanHouseDao.getPageAllByCondition(page.getPageNo(), page.getPageSize());	
		}
		page.setEntities(p.getResults());
		page.setEntityCount(p.getTotalCount());
	}

	//loanHouseController#saveAll
	@DataResolver
	public void saveAll(Collection<TLoanHouse> coll) throws Exception{
		
		@SuppressWarnings("unchecked")
		Iterator<TLoanHouse> iter=EntityUtils.getIterator(coll, FilterType.DIRTY);
		while(iter.hasNext()){
			TLoanHouse loanHouse=iter.next();
			EntityState state=EntityUtils.getState(loanHouse);
			if(state.equals(EntityState.NEW)){
				loanHouseDao.insertSelective(loanHouse);
			}
			if(state.equals(EntityState.MODIFIED)){
				loanHouseDao.updateSelective(loanHouse);
			}
			if(state.equals(EntityState.DELETED)){
				loanHouseDao.deleteByLoanHouseId(loanHouse.getLoanHouseId());
			}
		}
	}
}
