package com.hlj.tech.kdkj.customer.manager;

import com.hlj.tech.kdkj.customer.entities.TLoan;
import com.hlj.tech.kdkj.customer.service.TLoanService;
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


@Component("loanManagerPR")
public class TLoanManagerPR{
   
   private static Logger log = LoggerFactory.getLogger(TLoanManagerPR.class);  

	@Autowired
	private TLoanDao tLoanDao;
	
	/**
	 * 
	 * 
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	//loanManagerPR#getAll
	@DataProvider
	public Collection<TLoan> getAll(Map<String, Object> parameter) throws Exception{
		if(!this.hasParameter(parameter)){
			return tLoanDao.getAll();
		}else{
			return tLoanDao.getAll(parameter);
		}
	}
	
   	//loanManagerPR#getPageAll
	@DataProvider
	public void getPageAll(Page<TLoan> page, Map<String, Object> parameter) throws Exception{

	    Pagination<TLoan> p = null;
		if(!this.hasParameter(parameter)){
			p=tLoanDao.getPageAll( page.getPageNo(), page.getPageSize());
		}else{
			p=tLoanDao.getPageAllByCondition(parameter,page.getPageNo(), page.getPageSize());	
		}
		page.setEntities(p.getResults());
		page.setEntityCount(p.getTotalCount());
	}

	//loanManagerPR#saveAll
	@DataResolver
	public void saveAll(Collection<TLoan> coll) throws Exception{
		
		@SuppressWarnings("unchecked")
		Iterator<TLoan> iter=EntityUtils.getIterator(coll, FilterType.DIRTY);
		while(iter.hasNext()){
			TLoan tLoan=iter.next();
			EntityState state=EntityUtils.getState(tLoan);
			if(state.equals(EntityState.NEW)){
				tLoanDao.insertSelective(tLoan);
			}
			if(state.equals(EntityState.MODIFIED)){
				tLoanDao.updateSelective(tLoan);
			}
			if(state.equals(EntityState.DELETED)){
				tLoanDao.deleteByLoanId(tLoan.getLoanId());
			}
		}
	}
	
	private boolean hasParameter(Map parameter){
		return parameter!=null;		
	}	
}
