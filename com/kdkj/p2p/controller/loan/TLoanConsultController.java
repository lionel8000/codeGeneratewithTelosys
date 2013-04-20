;
;
package com.kdkj.p2p.controller.loan;

import com.kdkj.p2p.utils.ParameterCheck;
import com.kdkj.p2p.entities.loan.TLoanConsult;
import com.kdkj.p2p.dao.loan.TLoanConsultDao;

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


@Component("loanConsultController")
public class TLoanConsultController{
   
   private static Logger log = LoggerFactory.getLogger(TLoanConsultController.class);  

	@Autowired
	private TLoanConsultDao loanConsultDao;
	
	/**
	 * 
	 * 
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	//loanConsultController#getAll
	@DataProvider
	public Collection<TLoanConsult> getAll(Map<String, Object> parameter) throws Exception{
		if(ParameterCheck.hasValue(parameter)){
			return loanConsultDao.getAll(parameter);
		}else{
			return loanConsultDao.getAll();
		}
	}
	
   	//loanConsultController#getPageAll
	@DataProvider
	public void getPageAll(Page<TLoanConsult> page, Map<String, Object> parameter) throws Exception{

	    Pagination<TLoanConsult> p = null;
		if(ParameterCheck.hasValue(parameter)){
			p=loanConsultDao.getPageAll(parameter ,page.getPageNo(), page.getPageSize());
		}else{
			p=loanConsultDao.getPageAllByCondition(page.getPageNo(), page.getPageSize());	
		}
		page.setEntities(p.getResults());
		page.setEntityCount(p.getTotalCount());
	}

	//loanConsultController#saveAll
	@DataResolver
	public void saveAll(Collection<TLoanConsult> coll) throws Exception{
		
		@SuppressWarnings("unchecked")
		Iterator<TLoanConsult> iter=EntityUtils.getIterator(coll, FilterType.DIRTY);
		while(iter.hasNext()){
			TLoanConsult loanConsult=iter.next();
			EntityState state=EntityUtils.getState(loanConsult);
			if(state.equals(EntityState.NEW)){
				loanConsultDao.insertSelective(loanConsult);
			}
			if(state.equals(EntityState.MODIFIED)){
				loanConsultDao.updateSelective(loanConsult);
			}
			if(state.equals(EntityState.DELETED)){
				loanConsultDao.deleteByLoanConsultid(loanConsult.getLoanConsultid());
			}
		}
	}
}
