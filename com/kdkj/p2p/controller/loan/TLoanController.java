;
;
package com.kdkj.p2p.controller.loan;

import com.kdkj.p2p.utils.ParameterCheck;
import com.kdkj.p2p.entities.loan.TLoan;
import com.kdkj.p2p.dao.loan.TLoanDao;

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


@Component("loanController")
public class TLoanController{
   
   private static Logger log = LoggerFactory.getLogger(TLoanController.class);  

	@Autowired
	private TLoanDao loanDao;
	
	/**
	 * 
	 * 
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	//loanController#getAll
	@DataProvider
	public Collection<TLoan> getAll(Map<String, Object> parameter) throws Exception{
		if(ParameterCheck.hasValue(parameter)){
			return loanDao.getAll(parameter);
		}else{
			return loanDao.getAll();
		}
	}
	
   	//loanController#getPageAll
	@DataProvider
	public void getPageAll(Page<TLoan> page, Map<String, Object> parameter) throws Exception{

	    Pagination<TLoan> p = null;
		if(ParameterCheck.hasValue(parameter)){
			p=loanDao.getPageAllByCondition(parameter ,page.getPageNo(), page.getPageSize());
		}else{
			p=loanDao.getPageAll(page.getPageNo(), page.getPageSize());	
		}
		page.setEntities(p.getResults());
		page.setEntityCount(p.getTotalCount());
	}

	//loanController#saveAll
	@DataResolver
	public void saveAll(Collection<TLoan> coll) throws Exception{
		
		@SuppressWarnings("unchecked")
		Iterator<TLoan> iter=EntityUtils.getIterator(coll, FilterType.DIRTY);
		while(iter.hasNext()){
			TLoan loan=iter.next();
			EntityState state=EntityUtils.getState(loan);
			if(state.equals(EntityState.NEW)){
				loanDao.insertSelective(loan);
			}
			if(state.equals(EntityState.MODIFIED)){
				loanDao.updateSelective(loan);
			}
			if(state.equals(EntityState.DELETED)){
				loanDao.deleteByLoanId(loan.getLoanId());
			}
		}
	}
}
