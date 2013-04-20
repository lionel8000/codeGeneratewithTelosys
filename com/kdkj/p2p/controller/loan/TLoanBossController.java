;
;
package com.kdkj.p2p.controller.loan;

import com.kdkj.p2p.utils.ParameterCheck;
import com.kdkj.p2p.entities.loan.TLoanBoss;
import com.kdkj.p2p.dao.loan.TLoanBossDao;

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


@Component("loanBossController")
public class TLoanBossController{
   
   private static Logger log = LoggerFactory.getLogger(TLoanBossController.class);  

	@Autowired
	private TLoanBossDao loanBossDao;
	
	/**
	 * 
	 * 
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	//loanBossController#getAll
	@DataProvider
	public Collection<TLoanBoss> getAll(Map<String, Object> parameter) throws Exception{
		if(ParameterCheck.hasValue(parameter)){
			return loanBossDao.getAll(parameter);
		}else{
			return loanBossDao.getAll();
		}
	}
	
   	//loanBossController#getPageAll
	@DataProvider
	public void getPageAll(Page<TLoanBoss> page, Map<String, Object> parameter) throws Exception{

	    Pagination<TLoanBoss> p = null;
		if(ParameterCheck.hasValue(parameter)){
			p=loanBossDao.getPageAll(parameter ,page.getPageNo(), page.getPageSize());
		}else{
			p=loanBossDao.getPageAllByCondition(page.getPageNo(), page.getPageSize());	
		}
		page.setEntities(p.getResults());
		page.setEntityCount(p.getTotalCount());
	}

	//loanBossController#saveAll
	@DataResolver
	public void saveAll(Collection<TLoanBoss> coll) throws Exception{
		
		@SuppressWarnings("unchecked")
		Iterator<TLoanBoss> iter=EntityUtils.getIterator(coll, FilterType.DIRTY);
		while(iter.hasNext()){
			TLoanBoss loanBoss=iter.next();
			EntityState state=EntityUtils.getState(loanBoss);
			if(state.equals(EntityState.NEW)){
				loanBossDao.insertSelective(loanBoss);
			}
			if(state.equals(EntityState.MODIFIED)){
				loanBossDao.updateSelective(loanBoss);
			}
			if(state.equals(EntityState.DELETED)){
				loanBossDao.deleteByLoanBossId(loanBoss.getLoanBossId());
			}
		}
	}
}
