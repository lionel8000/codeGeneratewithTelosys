package com.kdkj.p2p.dao.loan;

import com.kdkj.p2p.utils.ParameterCheck;
import com.kdkj.p2p.entities.loan.TLoan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import com.bstek.bdf.pagination.CoreJdbcDaoSupport;
import com.bstek.bdf.pagination.Pagination;
import com.bstek.bdf.context.ContextHolder;


/**
 * @author lionel.xu@bstek.com
 * @since 1.0
 */
@Repository
public class TLoanDao extends CoreJdbcDaoSupport {

    private static Logger log = LoggerFactory.getLogger(TLoanDao.class);  

    private static String TABLE = "t_loan";
	
	@Deprecated
	public Integer insert(TLoan tLoan) throws Exception {
		String sql = "insert into "+TABLE +"(customer_pid,userName_,loan_limit,loan_month,loan_returnType,loan_usage,loan_openTime,bank_account,bank_accountNo,bank_openName,bank_type,loan_bigType,loan_smallType,state,success,success_state,create_date,update_date,multi_borrower,loan_genNumber)  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object args[] = new Object[] { tLoan.getCustomerPid(),tLoan.getUsername(),tLoan.getLoanLimit(),tLoan.getLoanMonth(),tLoan.getLoanReturntype(),tLoan.getLoanUsage(),tLoan.getLoanOpentime(),tLoan.getBankAccount(),tLoan.getBankAccountno(),tLoan.getBankOpenname(),tLoan.getBankType(),tLoan.getLoanBigtype(),tLoan.getLoanSmalltype(),tLoan.getState(),tLoan.getSuccess(),tLoan.getSuccessState(),tLoan.getCreateDate(),tLoan.getUpdateDate(),tLoan.getMultiBorrower(),tLoan.getLoanGennumber() };
		if(log.isDebugEnabled()){
			log.debug("insertTLoan : SQL IS : " + sql + " : PARAM IS : " + args);
		}
		this.getJdbcTemplate().update(sql, args);
		tLoan.setLoanId(this.getJdbcTemplate().queryForInt("select last_insert_id()"));
        return tLoan.getLoanId();
	}

	
	
	public Integer insertSelective(TLoan tLoan) throws Exception {
		StringBuffer columns = new StringBuffer();
		StringBuffer questions = new StringBuffer(30);
		List<Object> params = new ArrayList<Object>();


		if(ParameterCheck.hasValue(tLoan.getCustomerPid())){
			params.add(tLoan.getCustomerPid());
			columns.append(",customer_pid");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoan.getUsername())){
			params.add(tLoan.getUsername());
			columns.append(",userName_");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoan.getLoanLimit())){
			params.add(tLoan.getLoanLimit());
			columns.append(",loan_limit");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoan.getLoanMonth())){
			params.add(tLoan.getLoanMonth());
			columns.append(",loan_month");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoan.getLoanReturntype())){
			params.add(tLoan.getLoanReturntype());
			columns.append(",loan_returnType");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoan.getLoanUsage())){
			params.add(tLoan.getLoanUsage());
			columns.append(",loan_usage");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoan.getLoanOpentime())){
			params.add(tLoan.getLoanOpentime());
			columns.append(",loan_openTime");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoan.getBankAccount())){
			params.add(tLoan.getBankAccount());
			columns.append(",bank_account");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoan.getBankAccountno())){
			params.add(tLoan.getBankAccountno());
			columns.append(",bank_accountNo");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoan.getBankOpenname())){
			params.add(tLoan.getBankOpenname());
			columns.append(",bank_openName");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoan.getBankType())){
			params.add(tLoan.getBankType());
			columns.append(",bank_type");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoan.getLoanBigtype())){
			params.add(tLoan.getLoanBigtype());
			columns.append(",loan_bigType");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoan.getLoanSmalltype())){
			params.add(tLoan.getLoanSmalltype());
			columns.append(",loan_smallType");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoan.getState())){
			params.add(tLoan.getState());
			columns.append(",state");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoan.getSuccess())){
			params.add(tLoan.getSuccess());
			columns.append(",success");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoan.getSuccessState())){
			params.add(tLoan.getSuccessState());
			columns.append(",success_state");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoan.getCreateDate())){
			params.add(tLoan.getCreateDate());
			columns.append(",create_date");
			questions.append(",?");
		}else{
			columns.append(",create_date");
			questions.append(",now()");
		}
		if(ParameterCheck.hasValue(tLoan.getUpdateDate())){
			params.add(tLoan.getUpdateDate());
			columns.append(",update_date");
			questions.append(",?");
		}else{
			columns.append(",update_date");
			questions.append(",now()");
		}
		if(ParameterCheck.hasValue(tLoan.getMultiBorrower())){
			params.add(tLoan.getMultiBorrower());
			columns.append(",multi_borrower");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoan.getLoanGennumber())){
			params.add(tLoan.getLoanGennumber());
			columns.append(",loan_genNumber");
			questions.append(",?");
		}
		String sql = "insert into " + TABLE + "(" + columns.toString().substring(1) + ") values(" + questions.toString().substring(1) +")";
		if(log.isDebugEnabled()){
			log.debug("insertTLoanSelective : SQL IS : " + sql + " : PARAM IS : " + params.toArray());
		}
		this.getJdbcTemplate().update(sql, params.toArray());
		
		tLoan.setLoanId(this.getJdbcTemplate().queryForInt("select last_insert_id()"));
		return tLoan.getLoanId();
	}
	
	
	
	public void deleteByLoanId(Integer loanId) throws Exception {
		String sql = "delete from " +TABLE +" where  loan_id=?";
		Object args[] = new Object[] {loanId};

		if(log.isDebugEnabled()){
			log.debug("deleteTLoanByLoanId : SQL IS : " + sql + " : PARAM IS : " + args);
		}
		this.getJdbcTemplate().update(sql, args);
	}
	
	
    
	public void deleteByBean(TLoan tLoan) throws Exception{
		List<Object> params = new ArrayList<Object>();
  		StringBuffer columns = new StringBuffer();
		if(ParameterCheck.hasValue(tLoan.getCustomerPid())){
			params.add(tLoan.getCustomerPid());
			columns.append("and customer_pid=? ");
		}
		if(ParameterCheck.hasValue(tLoan.getUsername())){
			params.add(tLoan.getUsername());
			columns.append("and userName_=? ");
		}
		if(ParameterCheck.hasValue(tLoan.getLoanLimit())){
			params.add(tLoan.getLoanLimit());
			columns.append("and loan_limit=? ");
		}
		if(ParameterCheck.hasValue(tLoan.getLoanMonth())){
			params.add(tLoan.getLoanMonth());
			columns.append("and loan_month=? ");
		}
		if(ParameterCheck.hasValue(tLoan.getLoanReturntype())){
			params.add(tLoan.getLoanReturntype());
			columns.append("and loan_returnType=? ");
		}
		if(ParameterCheck.hasValue(tLoan.getLoanUsage())){
			params.add(tLoan.getLoanUsage());
			columns.append("and loan_usage=? ");
		}
		if(ParameterCheck.hasValue(tLoan.getLoanOpentime())){
			params.add(tLoan.getLoanOpentime());
			columns.append("and loan_openTime=? ");
		}
		if(ParameterCheck.hasValue(tLoan.getBankAccount())){
			params.add(tLoan.getBankAccount());
			columns.append("and bank_account=? ");
		}
		if(ParameterCheck.hasValue(tLoan.getBankAccountno())){
			params.add(tLoan.getBankAccountno());
			columns.append("and bank_accountNo=? ");
		}
		if(ParameterCheck.hasValue(tLoan.getBankOpenname())){
			params.add(tLoan.getBankOpenname());
			columns.append("and bank_openName=? ");
		}
		if(ParameterCheck.hasValue(tLoan.getBankType())){
			params.add(tLoan.getBankType());
			columns.append("and bank_type=? ");
		}
		if(ParameterCheck.hasValue(tLoan.getLoanBigtype())){
			params.add(tLoan.getLoanBigtype());
			columns.append("and loan_bigType=? ");
		}
		if(ParameterCheck.hasValue(tLoan.getLoanSmalltype())){
			params.add(tLoan.getLoanSmalltype());
			columns.append("and loan_smallType=? ");
		}
		if(ParameterCheck.hasValue(tLoan.getState())){
			params.add(tLoan.getState());
			columns.append("and state=? ");
		}
		if(ParameterCheck.hasValue(tLoan.getSuccess())){
			params.add(tLoan.getSuccess());
			columns.append("and success=? ");
		}
		if(ParameterCheck.hasValue(tLoan.getSuccessState())){
			params.add(tLoan.getSuccessState());
			columns.append("and success_state=? ");
		}
		if(ParameterCheck.hasValue(tLoan.getCreateDate())){
			params.add(tLoan.getCreateDate());
			columns.append("and create_date=? ");
		}
		if(ParameterCheck.hasValue(tLoan.getUpdateDate())){
			params.add(tLoan.getUpdateDate());
			columns.append("and update_date=? ");
		}
		if(ParameterCheck.hasValue(tLoan.getMultiBorrower())){
			params.add(tLoan.getMultiBorrower());
			columns.append("and multi_borrower=? ");
		}
		if(ParameterCheck.hasValue(tLoan.getLoanGennumber())){
			params.add(tLoan.getLoanGennumber());
			columns.append("and loan_genNumber=? ");
		}

		String sql = "delete from " +TABLE + " where " +columns.toString().substring(4);
		if(log.isDebugEnabled()){
			log.debug("deleteTLoanByBean : SQL IS : " + sql + " : PARAM IS : " + params.toArray());
		}
	    this.getJdbcTemplate().update(sql,params.toArray());
	}
	
	
	@Deprecated
	public void update(TLoan tLoan) throws Exception {
		String sql = "update " +TABLE +" set customer_pid=?,userName_=?,loan_limit=?,loan_month=?,loan_returnType=?,loan_usage=?,loan_openTime=?,bank_account=?,bank_accountNo=?,bank_openName=?,bank_type=?,loan_bigType=?,loan_smallType=?,state=?,success=?,success_state=?,create_date=?,update_date=?,multi_borrower=?,loan_genNumber=? where  loan_id=?";
		Object args[] = new Object[] {tLoan.getCustomerPid(),tLoan.getUsername(),tLoan.getLoanLimit(),tLoan.getLoanMonth(),tLoan.getLoanReturntype(),tLoan.getLoanUsage(),tLoan.getLoanOpentime(),tLoan.getBankAccount(),tLoan.getBankAccountno(),tLoan.getBankOpenname(),tLoan.getBankType(),tLoan.getLoanBigtype(),tLoan.getLoanSmalltype(),tLoan.getState(),tLoan.getSuccess(),tLoan.getSuccessState(),tLoan.getCreateDate(),tLoan.getUpdateDate(),tLoan.getMultiBorrower(),tLoan.getLoanGennumber(),tLoan.getLoanId()};
		if(log.isDebugEnabled()){
			log.debug("updateTLoan : SQL IS : " + sql + " : PARAM IS : " + args);
		}
		this.getJdbcTemplate().update(sql, args);
	}
	
	
	
	public void updateSelective(TLoan tLoan) throws Exception {
		List<Object> params = new ArrayList<Object>();
        StringBuffer columns = new StringBuffer();
        String keys = "";
		if(ParameterCheck.hasValue(tLoan.getCustomerPid())){
			params.add(tLoan.getCustomerPid());
			columns.append(",customer_pid=?");
		}
		if(ParameterCheck.hasValue(tLoan.getUsername())){
			params.add(tLoan.getUsername());
			columns.append(",userName_=?");
		}
		if(ParameterCheck.hasValue(tLoan.getLoanLimit())){
			params.add(tLoan.getLoanLimit());
			columns.append(",loan_limit=?");
		}
		if(ParameterCheck.hasValue(tLoan.getLoanMonth())){
			params.add(tLoan.getLoanMonth());
			columns.append(",loan_month=?");
		}
		if(ParameterCheck.hasValue(tLoan.getLoanReturntype())){
			params.add(tLoan.getLoanReturntype());
			columns.append(",loan_returnType=?");
		}
		if(ParameterCheck.hasValue(tLoan.getLoanUsage())){
			params.add(tLoan.getLoanUsage());
			columns.append(",loan_usage=?");
		}
		if(ParameterCheck.hasValue(tLoan.getLoanOpentime())){
			params.add(tLoan.getLoanOpentime());
			columns.append(",loan_openTime=?");
		}
		if(ParameterCheck.hasValue(tLoan.getBankAccount())){
			params.add(tLoan.getBankAccount());
			columns.append(",bank_account=?");
		}
		if(ParameterCheck.hasValue(tLoan.getBankAccountno())){
			params.add(tLoan.getBankAccountno());
			columns.append(",bank_accountNo=?");
		}
		if(ParameterCheck.hasValue(tLoan.getBankOpenname())){
			params.add(tLoan.getBankOpenname());
			columns.append(",bank_openName=?");
		}
		if(ParameterCheck.hasValue(tLoan.getBankType())){
			params.add(tLoan.getBankType());
			columns.append(",bank_type=?");
		}
		if(ParameterCheck.hasValue(tLoan.getLoanBigtype())){
			params.add(tLoan.getLoanBigtype());
			columns.append(",loan_bigType=?");
		}
		if(ParameterCheck.hasValue(tLoan.getLoanSmalltype())){
			params.add(tLoan.getLoanSmalltype());
			columns.append(",loan_smallType=?");
		}
		if(ParameterCheck.hasValue(tLoan.getState())){
			params.add(tLoan.getState());
			columns.append(",state=?");
		}
		if(ParameterCheck.hasValue(tLoan.getSuccess())){
			params.add(tLoan.getSuccess());
			columns.append(",success=?");
		}
		if(ParameterCheck.hasValue(tLoan.getSuccessState())){
			params.add(tLoan.getSuccessState());
			columns.append(",success_state=?");
		}
		if(ParameterCheck.hasValue(tLoan.getCreateDate())){
			params.add(tLoan.getCreateDate());
			columns.append(",create_date=?");
		}
		if(ParameterCheck.hasValue(tLoan.getUpdateDate())){
			params.add(tLoan.getUpdateDate());
			columns.append(",update_date=?");
		}else{
   			columns.append(",update_date=now()");
		}
		if(ParameterCheck.hasValue(tLoan.getMultiBorrower())){
			params.add(tLoan.getMultiBorrower());
			columns.append(",multi_borrower=?");
		}
		if(ParameterCheck.hasValue(tLoan.getLoanGennumber())){
			params.add(tLoan.getLoanGennumber());
			columns.append(",loan_genNumber=?");
		}

		
		if(ParameterCheck.hasValue(tLoan.getLoanId())){
			params.add(tLoan.getLoanId());
			keys += "and loan_id=? ";
		}
		String sql = "update " + TABLE + " set " +columns.toString().substring(1)+" where "+keys.substring(4);
		if(log.isDebugEnabled()){
			log.debug("updateTLoanSelective : SQL IS : " + sql + " : PARAM IS : " + params.toArray());
		}
		this.getJdbcTemplate().update(sql, params.toArray());
	}
	
	
		
	
	public TLoan getByLoanId(Integer loanId) {
		String sql = "select TLoan.loan_id as loanId ,TLoan.customer_pid as customerPid,TLoan.userName_ as username,TLoan.loan_limit as loanLimit,TLoan.loan_month as loanMonth,TLoan.loan_returnType as loanReturntype,TLoan.loan_usage as loanUsage,TLoan.loan_openTime as loanOpentime,TLoan.bank_account as bankAccount,TLoan.bank_accountNo as bankAccountno,TLoan.bank_openName as bankOpenname,TLoan.bank_type as bankType,TLoan.loan_bigType as loanBigtype,TLoan.loan_smallType as loanSmalltype,TLoan.state as state,TLoan.success as success,TLoan.success_state as successState,TLoan.create_date as createDate,TLoan.update_date as updateDate,TLoan.multi_borrower as multiBorrower,TLoan.loan_genNumber as loanGennumber from "+TABLE+" as TLoan where  TLoan.loan_id=?";
		if(log.isDebugEnabled()){
			log.debug("getTLoanByLoanId : SQL IS : " + sql + " : PARAM IS : " + loanId);
		}
		List<TLoan> tLoanList = this.getJdbcTemplate().query(sql,new Object[]{loanId}, ParameterizedBeanPropertyRowMapper.newInstance(TLoan.class));
		return tLoanList.size() > 0 ? tLoanList.get(0) : null;
	}
	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public Collection<TLoan> getAll(Map<String, Object> parameter) {
		return getAll(parameter ,"updateDate" ,false ,true);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public Collection<TLoan> getAll(Map<String, Object> parameter ,String orderBy) {
		return getAll(parameter ,orderBy ,true ,true);
	}
	
	/**
	 * get the data by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public Collection<TLoan> getAll(Map<String, Object> parameter ,String orderBy ,boolean asc) {
		return getAll(parameter ,orderBy ,asc ,true);

	}
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public Collection<TLoan> getAll(Map<String, Object> parameter ,boolean orderFlag) {
		return getAll(parameter ,"" ,false ,false);
	}
	
	private Collection<TLoan> getAll(Map<String, Object> parameter,String orderBy,boolean asc,boolean order) {
		String sql = "select TLoan.loan_id as loanId ,TLoan.customer_pid as customerPid,TLoan.userName_ as username,TLoan.loan_limit as loanLimit,TLoan.loan_month as loanMonth,TLoan.loan_returnType as loanReturntype,TLoan.loan_usage as loanUsage,TLoan.loan_openTime as loanOpentime,TLoan.bank_account as bankAccount,TLoan.bank_accountNo as bankAccountno,TLoan.bank_openName as bankOpenname,TLoan.bank_type as bankType,TLoan.loan_bigType as loanBigtype,TLoan.loan_smallType as loanSmalltype,TLoan.state as state,TLoan.success as success,TLoan.success_state as successState,TLoan.create_date as createDate,TLoan.update_date as updateDate,TLoan.multi_borrower as multiBorrower,TLoan.loan_genNumber as loanGennumber from "+TABLE +" as TLoan" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
		if(parameter != null){
            if(ParameterCheck.hasValue(parameter.get("loanId"))){
			    withParameter = true;    
				sb.append(" and TLoan.loan_id=? ");
				params.add(parameter.get("loanId"));
			}

            if(ParameterCheck.hasValue(parameter.get("customerPid"))){
			    withParameter = true;    
				sb.append(" and TLoan.customer_pid=? ");
				params.add(parameter.get("customerPid"));
			}

            if(ParameterCheck.hasValue(parameter.get("username"))){
			    withParameter = true;    
				sb.append(" and TLoan.userName_=? ");
				params.add(parameter.get("username"));
			}

            if(ParameterCheck.hasValue(parameter.get("loanLimit"))){
			    withParameter = true;    
				sb.append(" and TLoan.loan_limit=? ");
				params.add(parameter.get("loanLimit"));
			}

            if(ParameterCheck.hasValue(parameter.get("loanMonth"))){
			    withParameter = true;    
				sb.append(" and TLoan.loan_month=? ");
				params.add(parameter.get("loanMonth"));
			}

            if(ParameterCheck.hasValue(parameter.get("loanReturntype"))){
			    withParameter = true;    
				sb.append(" and TLoan.loan_returnType=? ");
				params.add(parameter.get("loanReturntype"));
			}

            if(ParameterCheck.hasValue(parameter.get("loanUsage"))){
			    withParameter = true;    
				sb.append(" and TLoan.loan_usage=? ");
				params.add(parameter.get("loanUsage"));
			}

            if(ParameterCheck.hasValue(parameter.get("loanOpentime"))){
			    withParameter = true;    
				sb.append(" and TLoan.loan_openTime=? ");
				params.add(parameter.get("loanOpentime"));
			}

            if(ParameterCheck.hasValue(parameter.get("bankAccount"))){
			    withParameter = true;    
				sb.append(" and TLoan.bank_account=? ");
				params.add(parameter.get("bankAccount"));
			}

            if(ParameterCheck.hasValue(parameter.get("bankAccountno"))){
			    withParameter = true;    
				sb.append(" and TLoan.bank_accountNo=? ");
				params.add(parameter.get("bankAccountno"));
			}

            if(ParameterCheck.hasValue(parameter.get("bankOpenname"))){
			    withParameter = true;    
				sb.append(" and TLoan.bank_openName=? ");
				params.add(parameter.get("bankOpenname"));
			}

            if(ParameterCheck.hasValue(parameter.get("bankType"))){
			    withParameter = true;    
				sb.append(" and TLoan.bank_type=? ");
				params.add(parameter.get("bankType"));
			}

            if(ParameterCheck.hasValue(parameter.get("loanBigtype"))){
			    withParameter = true;    
				sb.append(" and TLoan.loan_bigType=? ");
				params.add(parameter.get("loanBigtype"));
			}

            if(ParameterCheck.hasValue(parameter.get("loanSmalltype"))){
			    withParameter = true;    
				sb.append(" and TLoan.loan_smallType=? ");
				params.add(parameter.get("loanSmalltype"));
			}

            if(ParameterCheck.hasValue(parameter.get("state"))){
			    withParameter = true;    
				sb.append(" and TLoan.state=? ");
				params.add(parameter.get("state"));
			}

            if(ParameterCheck.hasValue(parameter.get("success"))){
			    withParameter = true;    
				sb.append(" and TLoan.success=? ");
				params.add(parameter.get("success"));
			}

            if(ParameterCheck.hasValue(parameter.get("successState"))){
			    withParameter = true;    
				sb.append(" and TLoan.success_state=? ");
				params.add(parameter.get("successState"));
			}

            if(ParameterCheck.hasValue(parameter.get("createDate"))){
			    withParameter = true;    
				sb.append(" and TLoan.create_date=? ");
				params.add(parameter.get("createDate"));
			}

            if(ParameterCheck.hasValue(parameter.get("updateDate"))){
			    withParameter = true;    
				sb.append(" and TLoan.update_date=? ");
				params.add(parameter.get("updateDate"));
			}

            if(ParameterCheck.hasValue(parameter.get("multiBorrower"))){
			    withParameter = true;    
				sb.append(" and TLoan.multi_borrower=? ");
				params.add(parameter.get("multiBorrower"));
			}

            if(ParameterCheck.hasValue(parameter.get("loanGennumber"))){
			    withParameter = true;    
				sb.append(" and TLoan.loan_genNumber=? ");
				params.add(parameter.get("loanGennumber"));
			}
		}
		
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sb.append(" order by TLoan." + orderSql);
		}
		
		if(log.isDebugEnabled()){
			log.debug("getAll : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
		}
		if(withParameter){
			return this.getJdbcTemplate().query(sql+ sb.toString(),params.toArray(), ParameterizedBeanPropertyRowMapper.newInstance(TLoan.class));
		}else{
			return this.getJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(TLoan.class));
		}
		
	}

	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public Collection<TLoan> getAllByBean(TLoan tLoan) {
		return getAllByBean(tLoan ,"updateDate" ,false ,true);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public Collection<TLoan> getAllByBean(TLoan tLoan ,String orderBy) {
		return getAllByBean(tLoan ,orderBy ,true ,true);
	}
	
	/**
	 * get the datat by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public Collection<TLoan> getAllByBean(TLoan tLoan ,String orderBy ,boolean asc) {
		return getAllByBean(tLoan ,orderBy ,asc ,true);
	}
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public Collection<TLoan> getAllByBean(TLoan tLoan ,boolean orderFlag) {
		return getAllByBean(tLoan ,"" ,false ,false);
	}
	

	
	private Collection<TLoan> getAllByBean(TLoan tLoan,String orderBy,boolean asc,boolean order) {
		String sql = "select TLoan.loan_id as loanId ,TLoan.customer_pid as customerPid,TLoan.userName_ as username,TLoan.loan_limit as loanLimit,TLoan.loan_month as loanMonth,TLoan.loan_returnType as loanReturntype,TLoan.loan_usage as loanUsage,TLoan.loan_openTime as loanOpentime,TLoan.bank_account as bankAccount,TLoan.bank_accountNo as bankAccountno,TLoan.bank_openName as bankOpenname,TLoan.bank_type as bankType,TLoan.loan_bigType as loanBigtype,TLoan.loan_smallType as loanSmalltype,TLoan.state as state,TLoan.success as success,TLoan.success_state as successState,TLoan.create_date as createDate,TLoan.update_date as updateDate,TLoan.multi_borrower as multiBorrower,TLoan.loan_genNumber as loanGennumber from "+TABLE +" as TLoan" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
            
		if(ParameterCheck.hasValue(tLoan.getLoanId())){
		    withParameter = true;    
			sb.append(" and TLoan.loan_id=? ");
			params.add(tLoan.getLoanId());
		}

		if(ParameterCheck.hasValue(tLoan.getCustomerPid())){
		    withParameter = true;    
			sb.append(" and TLoan.customer_pid=? ");
			params.add(tLoan.getCustomerPid());
		}

		if(ParameterCheck.hasValue(tLoan.getUsername())){
		    withParameter = true;    
			sb.append(" and TLoan.userName_=? ");
			params.add(tLoan.getUsername());
		}

		if(ParameterCheck.hasValue(tLoan.getLoanLimit())){
		    withParameter = true;    
			sb.append(" and TLoan.loan_limit=? ");
			params.add(tLoan.getLoanLimit());
		}

		if(ParameterCheck.hasValue(tLoan.getLoanMonth())){
		    withParameter = true;    
			sb.append(" and TLoan.loan_month=? ");
			params.add(tLoan.getLoanMonth());
		}

		if(ParameterCheck.hasValue(tLoan.getLoanReturntype())){
		    withParameter = true;    
			sb.append(" and TLoan.loan_returnType=? ");
			params.add(tLoan.getLoanReturntype());
		}

		if(ParameterCheck.hasValue(tLoan.getLoanUsage())){
		    withParameter = true;    
			sb.append(" and TLoan.loan_usage=? ");
			params.add(tLoan.getLoanUsage());
		}

		if(ParameterCheck.hasValue(tLoan.getLoanOpentime())){
		    withParameter = true;    
			sb.append(" and TLoan.loan_openTime=? ");
			params.add(tLoan.getLoanOpentime());
		}

		if(ParameterCheck.hasValue(tLoan.getBankAccount())){
		    withParameter = true;    
			sb.append(" and TLoan.bank_account=? ");
			params.add(tLoan.getBankAccount());
		}

		if(ParameterCheck.hasValue(tLoan.getBankAccountno())){
		    withParameter = true;    
			sb.append(" and TLoan.bank_accountNo=? ");
			params.add(tLoan.getBankAccountno());
		}

		if(ParameterCheck.hasValue(tLoan.getBankOpenname())){
		    withParameter = true;    
			sb.append(" and TLoan.bank_openName=? ");
			params.add(tLoan.getBankOpenname());
		}

		if(ParameterCheck.hasValue(tLoan.getBankType())){
		    withParameter = true;    
			sb.append(" and TLoan.bank_type=? ");
			params.add(tLoan.getBankType());
		}

		if(ParameterCheck.hasValue(tLoan.getLoanBigtype())){
		    withParameter = true;    
			sb.append(" and TLoan.loan_bigType=? ");
			params.add(tLoan.getLoanBigtype());
		}

		if(ParameterCheck.hasValue(tLoan.getLoanSmalltype())){
		    withParameter = true;    
			sb.append(" and TLoan.loan_smallType=? ");
			params.add(tLoan.getLoanSmalltype());
		}

		if(ParameterCheck.hasValue(tLoan.getState())){
		    withParameter = true;    
			sb.append(" and TLoan.state=? ");
			params.add(tLoan.getState());
		}

		if(ParameterCheck.hasValue(tLoan.getSuccess())){
		    withParameter = true;    
			sb.append(" and TLoan.success=? ");
			params.add(tLoan.getSuccess());
		}

		if(ParameterCheck.hasValue(tLoan.getSuccessState())){
		    withParameter = true;    
			sb.append(" and TLoan.success_state=? ");
			params.add(tLoan.getSuccessState());
		}

		if(ParameterCheck.hasValue(tLoan.getCreateDate())){
		    withParameter = true;    
			sb.append(" and TLoan.create_date=? ");
			params.add(tLoan.getCreateDate());
		}

		if(ParameterCheck.hasValue(tLoan.getUpdateDate())){
		    withParameter = true;    
			sb.append(" and TLoan.update_date=? ");
			params.add(tLoan.getUpdateDate());
		}

		if(ParameterCheck.hasValue(tLoan.getMultiBorrower())){
		    withParameter = true;    
			sb.append(" and TLoan.multi_borrower=? ");
			params.add(tLoan.getMultiBorrower());
		}

		if(ParameterCheck.hasValue(tLoan.getLoanGennumber())){
		    withParameter = true;    
			sb.append(" and TLoan.loan_genNumber=? ");
			params.add(tLoan.getLoanGennumber());
		}
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sb.append(" order by TLoan." + orderSql);
		}
		if(log.isDebugEnabled()){
			log.debug("getAllByBean : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
		}
		if(withParameter){
			return this.getJdbcTemplate().query(sql+ sb.toString(),params.toArray(), ParameterizedBeanPropertyRowMapper.newInstance(TLoan.class));
		}else{
			return this.getJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(TLoan.class));
		}		
	}
	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public Pagination<TLoan> getPageAllByCondition(Map<String, Object> parameter, int pageIndex, int pageSize) {
		return getPageAllByCondition(parameter ,pageIndex ,pageSize ,"updateDate" ,false ,true);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public Pagination<TLoan> getPageAllByCondition(Map<String, Object> parameter, int pageIndex, int pageSize, String orderBy) {
		return getPageAllByCondition(parameter ,pageIndex ,pageSize ,orderBy ,true ,true);
	}
	
	/**
	 * get the datat by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public Pagination<TLoan> getPageAllByCondition(Map<String, Object> parameter, int pageIndex, int pageSize, String orderBy, boolean asc) {
		return getPageAllByCondition(parameter ,pageIndex ,pageSize ,orderBy ,asc ,true);
	}
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public Pagination<TLoan> getPageAllByCondition(Map<String, Object> parameter, int pageIndex, int pageSize, boolean orderFlag) {
		return getPageAllByCondition(parameter ,pageIndex ,pageSize ,"" ,false ,false);
	}
	
	private Pagination<TLoan> getPageAllByCondition(Map<String, Object> parameter, int pageIndex, int pageSize,String orderBy,boolean asc,boolean order) {
		String sql = "select TLoan.loan_id as loanId ,TLoan.customer_pid as customerPid,TLoan.userName_ as username,TLoan.loan_limit as loanLimit,TLoan.loan_month as loanMonth,TLoan.loan_returnType as loanReturntype,TLoan.loan_usage as loanUsage,TLoan.loan_openTime as loanOpentime,TLoan.bank_account as bankAccount,TLoan.bank_accountNo as bankAccountno,TLoan.bank_openName as bankOpenname,TLoan.bank_type as bankType,TLoan.loan_bigType as loanBigtype,TLoan.loan_smallType as loanSmalltype,TLoan.state as state,TLoan.success as success,TLoan.success_state as successState,TLoan.create_date as createDate,TLoan.update_date as updateDate,TLoan.multi_borrower as multiBorrower,TLoan.loan_genNumber as loanGennumber from "+TABLE +" as TLoan" +" where 1=1 ";
		String countSql = "select count(*) from "+TABLE +" as TLoan" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
		if(parameter != null){

            if(ParameterCheck.hasValue(parameter.get("loanId"))){
				withParameter = true;   
				sb.append(" and TLoan.loan_id=? ");
				params.add(parameter.get("loanId"));
			}

            if(ParameterCheck.hasValue(parameter.get("customerPid"))){
			    withParameter = true;    
				sb.append(" and TLoan.customer_pid=? ");
				params.add(parameter.get("customerPid"));
			}

            if(ParameterCheck.hasValue(parameter.get("username"))){
			    withParameter = true;    
				sb.append(" and TLoan.userName_=? ");
				params.add(parameter.get("username"));
			}

            if(ParameterCheck.hasValue(parameter.get("loanLimit"))){
			    withParameter = true;    
				sb.append(" and TLoan.loan_limit=? ");
				params.add(parameter.get("loanLimit"));
			}

            if(ParameterCheck.hasValue(parameter.get("loanMonth"))){
			    withParameter = true;    
				sb.append(" and TLoan.loan_month=? ");
				params.add(parameter.get("loanMonth"));
			}

            if(ParameterCheck.hasValue(parameter.get("loanReturntype"))){
			    withParameter = true;    
				sb.append(" and TLoan.loan_returnType=? ");
				params.add(parameter.get("loanReturntype"));
			}

            if(ParameterCheck.hasValue(parameter.get("loanUsage"))){
			    withParameter = true;    
				sb.append(" and TLoan.loan_usage=? ");
				params.add(parameter.get("loanUsage"));
			}

            if(ParameterCheck.hasValue(parameter.get("loanOpentime"))){
			    withParameter = true;    
				sb.append(" and TLoan.loan_openTime=? ");
				params.add(parameter.get("loanOpentime"));
			}

            if(ParameterCheck.hasValue(parameter.get("bankAccount"))){
			    withParameter = true;    
				sb.append(" and TLoan.bank_account=? ");
				params.add(parameter.get("bankAccount"));
			}

            if(ParameterCheck.hasValue(parameter.get("bankAccountno"))){
			    withParameter = true;    
				sb.append(" and TLoan.bank_accountNo=? ");
				params.add(parameter.get("bankAccountno"));
			}

            if(ParameterCheck.hasValue(parameter.get("bankOpenname"))){
			    withParameter = true;    
				sb.append(" and TLoan.bank_openName=? ");
				params.add(parameter.get("bankOpenname"));
			}

            if(ParameterCheck.hasValue(parameter.get("bankType"))){
			    withParameter = true;    
				sb.append(" and TLoan.bank_type=? ");
				params.add(parameter.get("bankType"));
			}

            if(ParameterCheck.hasValue(parameter.get("loanBigtype"))){
			    withParameter = true;    
				sb.append(" and TLoan.loan_bigType=? ");
				params.add(parameter.get("loanBigtype"));
			}

            if(ParameterCheck.hasValue(parameter.get("loanSmalltype"))){
			    withParameter = true;    
				sb.append(" and TLoan.loan_smallType=? ");
				params.add(parameter.get("loanSmalltype"));
			}

            if(ParameterCheck.hasValue(parameter.get("state"))){
			    withParameter = true;    
				sb.append(" and TLoan.state=? ");
				params.add(parameter.get("state"));
			}

            if(ParameterCheck.hasValue(parameter.get("success"))){
			    withParameter = true;    
				sb.append(" and TLoan.success=? ");
				params.add(parameter.get("success"));
			}

            if(ParameterCheck.hasValue(parameter.get("successState"))){
			    withParameter = true;    
				sb.append(" and TLoan.success_state=? ");
				params.add(parameter.get("successState"));
			}

            if(ParameterCheck.hasValue(parameter.get("createDate"))){
			    withParameter = true;    
				sb.append(" and TLoan.create_date=? ");
				params.add(parameter.get("createDate"));
			}

            if(ParameterCheck.hasValue(parameter.get("updateDate"))){
			    withParameter = true;    
				sb.append(" and TLoan.update_date=? ");
				params.add(parameter.get("updateDate"));
			}

            if(ParameterCheck.hasValue(parameter.get("multiBorrower"))){
			    withParameter = true;    
				sb.append(" and TLoan.multi_borrower=? ");
				params.add(parameter.get("multiBorrower"));
			}

            if(ParameterCheck.hasValue(parameter.get("loanGennumber"))){
			    withParameter = true;    
				sb.append(" and TLoan.loan_genNumber=? ");
				params.add(parameter.get("loanGennumber"));
			}
		}
		Pagination<TLoan> page = new Pagination<TLoan>(pageIndex,pageSize);
		
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sb.append(" order by TLoan." + orderSql);
		}
		if(log.isDebugEnabled()){
			log.debug("getPageAllTLoanByCondition : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
			log.debug("pageIndex : " + pageIndex + "   pageSize:  " + pageSize);
		}
		if(withParameter){
			this.paginationQuery(sql + sb.toString(),countSql + sb.toString(), params.toArray(), page,ParameterizedBeanPropertyRowMapper.newInstance(TLoan.class));
		}else{
		    this.paginationQuery(sql,countSql ,page,ParameterizedBeanPropertyRowMapper.newInstance(TLoan.class));
		}
		return page;
	}
	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public Pagination<TLoan> getPageAllByBean(TLoan tLoan, int pageIndex, int pageSize) {
		return getPageAllByBean(tLoan ,pageIndex ,pageSize ,"updateDate" ,false ,true);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public Pagination<TLoan> getPageAllByBean(TLoan tLoan, int pageIndex, int pageSize,String orderBy) {
		return  getPageAllByBean(tLoan ,pageIndex ,pageSize ,orderBy ,true ,true);
	}
	
	/**
	 * get the datat by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public Pagination<TLoan> getPageAllByBean(TLoan tLoan, int pageIndex, int pageSize,String orderBy,boolean asc) {
		return  getPageAllByBean(tLoan ,pageIndex ,pageSize ,orderBy ,asc ,true);
	}
	
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public Pagination<TLoan> getPageAllByBean(TLoan tLoan, int pageIndex, int pageSize,boolean orderFlag) {
		return  getPageAllByBean(tLoan ,pageIndex ,pageSize ,"" ,false ,false);
	}
	
	private Pagination<TLoan> getPageAllByBean(TLoan tLoan, int pageIndex, int pageSize,String orderBy,boolean asc,boolean order) {
		String sql = "select TLoan.loan_id as loanId ,TLoan.customer_pid as customerPid,TLoan.userName_ as username,TLoan.loan_limit as loanLimit,TLoan.loan_month as loanMonth,TLoan.loan_returnType as loanReturntype,TLoan.loan_usage as loanUsage,TLoan.loan_openTime as loanOpentime,TLoan.bank_account as bankAccount,TLoan.bank_accountNo as bankAccountno,TLoan.bank_openName as bankOpenname,TLoan.bank_type as bankType,TLoan.loan_bigType as loanBigtype,TLoan.loan_smallType as loanSmalltype,TLoan.state as state,TLoan.success as success,TLoan.success_state as successState,TLoan.create_date as createDate,TLoan.update_date as updateDate,TLoan.multi_borrower as multiBorrower,TLoan.loan_genNumber as loanGennumber from "+TABLE +" as TLoan" +" where 1=1 ";
		String countSql = "select count(*) from "+TABLE +" as TLoan" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 

		if(ParameterCheck.hasValue(tLoan.getLoanId())){
			withParameter = true;   
			sb.append(" and TLoan.loan_id=? ");
			params.add(tLoan.getLoanId());
		}
        
		if(ParameterCheck.hasValue(tLoan.getCustomerPid())){
		    withParameter = true;    
			sb.append(" and TLoan.customer_pid=? ");
			params.add(tLoan.getCustomerPid());
		}
        
		if(ParameterCheck.hasValue(tLoan.getUsername())){
		    withParameter = true;    
			sb.append(" and TLoan.userName_=? ");
			params.add(tLoan.getUsername());
		}
        
		if(ParameterCheck.hasValue(tLoan.getLoanLimit())){
		    withParameter = true;    
			sb.append(" and TLoan.loan_limit=? ");
			params.add(tLoan.getLoanLimit());
		}
        
		if(ParameterCheck.hasValue(tLoan.getLoanMonth())){
		    withParameter = true;    
			sb.append(" and TLoan.loan_month=? ");
			params.add(tLoan.getLoanMonth());
		}
        
		if(ParameterCheck.hasValue(tLoan.getLoanReturntype())){
		    withParameter = true;    
			sb.append(" and TLoan.loan_returnType=? ");
			params.add(tLoan.getLoanReturntype());
		}
        
		if(ParameterCheck.hasValue(tLoan.getLoanUsage())){
		    withParameter = true;    
			sb.append(" and TLoan.loan_usage=? ");
			params.add(tLoan.getLoanUsage());
		}
        
		if(ParameterCheck.hasValue(tLoan.getLoanOpentime())){
		    withParameter = true;    
			sb.append(" and TLoan.loan_openTime=? ");
			params.add(tLoan.getLoanOpentime());
		}
        
		if(ParameterCheck.hasValue(tLoan.getBankAccount())){
		    withParameter = true;    
			sb.append(" and TLoan.bank_account=? ");
			params.add(tLoan.getBankAccount());
		}
        
		if(ParameterCheck.hasValue(tLoan.getBankAccountno())){
		    withParameter = true;    
			sb.append(" and TLoan.bank_accountNo=? ");
			params.add(tLoan.getBankAccountno());
		}
        
		if(ParameterCheck.hasValue(tLoan.getBankOpenname())){
		    withParameter = true;    
			sb.append(" and TLoan.bank_openName=? ");
			params.add(tLoan.getBankOpenname());
		}
        
		if(ParameterCheck.hasValue(tLoan.getBankType())){
		    withParameter = true;    
			sb.append(" and TLoan.bank_type=? ");
			params.add(tLoan.getBankType());
		}
        
		if(ParameterCheck.hasValue(tLoan.getLoanBigtype())){
		    withParameter = true;    
			sb.append(" and TLoan.loan_bigType=? ");
			params.add(tLoan.getLoanBigtype());
		}
        
		if(ParameterCheck.hasValue(tLoan.getLoanSmalltype())){
		    withParameter = true;    
			sb.append(" and TLoan.loan_smallType=? ");
			params.add(tLoan.getLoanSmalltype());
		}
        
		if(ParameterCheck.hasValue(tLoan.getState())){
		    withParameter = true;    
			sb.append(" and TLoan.state=? ");
			params.add(tLoan.getState());
		}
        
		if(ParameterCheck.hasValue(tLoan.getSuccess())){
		    withParameter = true;    
			sb.append(" and TLoan.success=? ");
			params.add(tLoan.getSuccess());
		}
        
		if(ParameterCheck.hasValue(tLoan.getSuccessState())){
		    withParameter = true;    
			sb.append(" and TLoan.success_state=? ");
			params.add(tLoan.getSuccessState());
		}
        
		if(ParameterCheck.hasValue(tLoan.getCreateDate())){
		    withParameter = true;    
			sb.append(" and TLoan.create_date=? ");
			params.add(tLoan.getCreateDate());
		}
        
		if(ParameterCheck.hasValue(tLoan.getUpdateDate())){
		    withParameter = true;    
			sb.append(" and TLoan.update_date=? ");
			params.add(tLoan.getUpdateDate());
		}
        
		if(ParameterCheck.hasValue(tLoan.getMultiBorrower())){
		    withParameter = true;    
			sb.append(" and TLoan.multi_borrower=? ");
			params.add(tLoan.getMultiBorrower());
		}
        
		if(ParameterCheck.hasValue(tLoan.getLoanGennumber())){
		    withParameter = true;    
			sb.append(" and TLoan.loan_genNumber=? ");
			params.add(tLoan.getLoanGennumber());
		}

		Pagination<TLoan> page = new Pagination<TLoan>(pageIndex,pageSize);
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sb.append(" order by TLoan." + orderSql);
		}
		if(log.isDebugEnabled()){
			log.debug("getPageAllTLoanByBean : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
			log.debug("pageIndex : " + pageIndex + "   pageSize:  " + pageSize);
		}
		if(withParameter){
			this.paginationQuery(sql + sb.toString(),countSql + sb.toString(), params.toArray(), page,ParameterizedBeanPropertyRowMapper.newInstance(TLoan.class));
		}else{
		    this.paginationQuery(sql,countSql ,page,ParameterizedBeanPropertyRowMapper.newInstance(TLoan.class));
		}
		return page;
	}
	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public List<TLoan> getAll(){
		return getAll("updateDate" ,false ,true);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public List<TLoan> getAll(String orderBy){
		return getAll(orderBy ,true ,true);
	}
	
	/**
	 * get the datat by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public List<TLoan> getAll(String orderBy,boolean asc){
		return getAll(orderBy ,asc ,true);
	}
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public List<TLoan> getAll(boolean orderFlag){
		return getAll("" ,false ,false);
	}
	
	private List<TLoan> getAll(String orderBy,boolean asc,boolean order){
		String sql = "select TLoan.loan_id as loanId ,TLoan.customer_pid as customerPid,TLoan.userName_ as username,TLoan.loan_limit as loanLimit,TLoan.loan_month as loanMonth,TLoan.loan_returnType as loanReturntype,TLoan.loan_usage as loanUsage,TLoan.loan_openTime as loanOpentime,TLoan.bank_account as bankAccount,TLoan.bank_accountNo as bankAccountno,TLoan.bank_openName as bankOpenname,TLoan.bank_type as bankType,TLoan.loan_bigType as loanBigtype,TLoan.loan_smallType as loanSmalltype,TLoan.state as state,TLoan.success as success,TLoan.success_state as successState,TLoan.create_date as createDate,TLoan.update_date as updateDate,TLoan.multi_borrower as multiBorrower,TLoan.loan_genNumber as loanGennumber from " + TABLE +" as TLoan" ;	
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sql += (" order by TLoan." + orderSql);
		}
		return this.getJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(TLoan.class));	
	}
	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public Pagination<TLoan> getPageAll(int pageIndex, int pageSize) {
		return getPageAll(pageIndex ,pageSize ,"updateDate" ,false ,true);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public Pagination<TLoan> getPageAll(int pageIndex, int pageSize,String orderBy) {
		return getPageAll(pageIndex ,pageSize ,orderBy ,true ,true);
	}
	
	/**
	 * get the datat by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public Pagination<TLoan> getPageAll(int pageIndex, int pageSize,String orderBy,boolean asc) {
		return getPageAll(pageIndex ,pageSize ,orderBy ,asc ,true);
	}
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public Pagination<TLoan> getPageAll(int pageIndex, int pageSize,boolean orderFlag) {
		return getPageAll(pageIndex ,pageSize ,"" ,false ,false);
	}
	
	
	
	private Pagination<TLoan> getPageAll(int pageIndex, int pageSize,String orderBy,boolean asc,boolean order) {
		String sql ="select TLoan.loan_id as loanId ,TLoan.customer_pid as customerPid,TLoan.userName_ as username,TLoan.loan_limit as loanLimit,TLoan.loan_month as loanMonth,TLoan.loan_returnType as loanReturntype,TLoan.loan_usage as loanUsage,TLoan.loan_openTime as loanOpentime,TLoan.bank_account as bankAccount,TLoan.bank_accountNo as bankAccountno,TLoan.bank_openName as bankOpenname,TLoan.bank_type as bankType,TLoan.loan_bigType as loanBigtype,TLoan.loan_smallType as loanSmalltype,TLoan.state as state,TLoan.success as success,TLoan.success_state as successState,TLoan.create_date as createDate,TLoan.update_date as updateDate,TLoan.multi_borrower as multiBorrower,TLoan.loan_genNumber as loanGennumber from " + TABLE +" as TLoan" ;
		String countSql = "select count(*) from " + TABLE;
		
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sql += (" order by TLoan." + orderSql);
		}
		Pagination<TLoan> page = new Pagination<TLoan>(pageIndex,pageSize);
		this.paginationQuery(sql,countSql, page,ParameterizedBeanPropertyRowMapper.newInstance(TLoan.class));
		return page;
	}
	
	

	protected class TLoanRowMapper implements RowMapper<TLoan> {
		public TLoan mapRow(ResultSet rs, int rowNum) throws SQLException {
			TLoan tLoan = new TLoan();
        	tLoan.setLoanId(rs.getInt("loanId"));
			tLoan.setCustomerPid(rs.getInt("customerPid"));
			tLoan.setUsername(rs.getString("username"));
			tLoan.setLoanLimit(rs.getBigDecimal("loanLimit"));
			tLoan.setLoanMonth(rs.getInt("loanMonth"));
			tLoan.setLoanReturntype(rs.getString("loanReturntype"));
			tLoan.setLoanUsage(rs.getString("loanUsage"));
			tLoan.setLoanOpentime(rs.getDate("loanOpentime"));
			tLoan.setBankAccount(rs.getString("bankAccount"));
			tLoan.setBankAccountno(rs.getString("bankAccountno"));
			tLoan.setBankOpenname(rs.getString("bankOpenname"));
			tLoan.setBankType(rs.getString("bankType"));
			tLoan.setLoanBigtype(rs.getString("loanBigtype"));
			tLoan.setLoanSmalltype(rs.getString("loanSmalltype"));
			tLoan.setState(rs.getString("state"));
			tLoan.setSuccess(rs.getByte("success"));
			tLoan.setSuccessState(rs.getString("successState"));
			tLoan.setCreateDate(rs.getDate("createDate"));
			tLoan.setUpdateDate(rs.getDate("updateDate"));
			tLoan.setMultiBorrower(rs.getByte("multiBorrower"));
			tLoan.setLoanGennumber(rs.getString("loanGennumber"));
			return tLoan;
		}
	}
}