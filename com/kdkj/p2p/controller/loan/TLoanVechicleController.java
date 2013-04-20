;
;
package com.kdkj.p2p.controller.loan;

import com.kdkj.p2p.utils.ParameterCheck;
import com.kdkj.p2p.entities.loan.TLoanVechicle;
import com.kdkj.p2p.dao.loan.TLoanVechicleDao;

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


@Component("loanVechicleController")
public class TLoanVechicleController{
   
   private static Logger log = LoggerFactory.getLogger(TLoanVechicleController.class);  

	@Autowired
	private TLoanVechicleDao loanVechicleDao;
	
	/**
	 * 
	 * 
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	//loanVechicleController#getAll
	@DataProvider
	public Collection<TLoanVechicle> getAll(Map<String, Object> parameter) throws Exception{
		if(ParameterCheck.hasValue(parameter)){
			return loanVechicleDao.getAll(parameter);
		}else{
			return loanVechicleDao.getAll();
		}
	}
	
   	//loanVechicleController#getPageAll
	@DataProvider
	public void getPageAll(Page<TLoanVechicle> page, Map<String, Object> parameter) throws Exception{

	    Pagination<TLoanVechicle> p = null;
		if(ParameterCheck.hasValue(parameter)){
			p=loanVechicleDao.getPageAll(parameter ,page.getPageNo(), page.getPageSize());
		}else{
			p=loanVechicleDao.getPageAllByCondition(page.getPageNo(), page.getPageSize());	
		}
		page.setEntities(p.getResults());
		page.setEntityCount(p.getTotalCount());
	}

	//loanVechicleController#saveAll
	@DataResolver
	public void saveAll(Collection<TLoanVechicle> coll) throws Exception{
		
		@SuppressWarnings("unchecked")
		Iterator<TLoanVechicle> iter=EntityUtils.getIterator(coll, FilterType.DIRTY);
		while(iter.hasNext()){
			TLoanVechicle loanVechicle=iter.next();
			EntityState state=EntityUtils.getState(loanVechicle);
			if(state.equals(EntityState.NEW)){
				loanVechicleDao.insertSelective(loanVechicle);
			}
			if(state.equals(EntityState.MODIFIED)){
				loanVechicleDao.updateSelective(loanVechicle);
			}
			if(state.equals(EntityState.DELETED)){
				loanVechicleDao.deleteByLoanVechicleId(loanVechicle.getLoanVechicleId());
			}
		}
	}
}
