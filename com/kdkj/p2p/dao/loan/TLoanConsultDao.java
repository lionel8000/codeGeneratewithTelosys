package com.kdkj.p2p.dao.loan;

import com.kdkj.p2p.utils.ParameterCheck;
import com.kdkj.p2p.entities.loan.TLoanConsult;
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
public class TLoanConsultDao extends CoreJdbcDaoSupport {

    private static Logger log = LoggerFactory.getLogger(TLoanConsultDao.class);  

    private static String TABLE = "t_loan_consult";
	
	@Deprecated
	public Integer insert(TLoanConsult tLoanConsult) throws Exception {
		String sql = "insert into "+TABLE +"(loan_pid,comment,consult_username,update_date,create_date)  values(?,?,?,?,?)";
		Object args[] = new Object[] { tLoanConsult.getLoanPid(),tLoanConsult.getComment(),tLoanConsult.getConsultUsername(),tLoanConsult.getUpdateDate(),tLoanConsult.getCreateDate() };
		if(log.isDebugEnabled()){
			log.debug("insertTLoanConsult : SQL IS : " + sql + " : PARAM IS : " + args);
		}
		this.getJdbcTemplate().update(sql, args);
		tLoanConsult.setLoanConsultid(this.getJdbcTemplate().queryForInt("select last_insert_id()"));
        return tLoanConsult.getLoanConsultid();
	}

	
	
	public Integer insertSelective(TLoanConsult tLoanConsult) throws Exception {
		StringBuffer columns = new StringBuffer();
		StringBuffer questions = new StringBuffer(30);
		List<Object> params = new ArrayList<Object>();


		if(ParameterCheck.hasValue(tLoanConsult.getLoanPid())){
			params.add(tLoanConsult.getLoanPid());
			columns.append(",loan_pid");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanConsult.getComment())){
			params.add(tLoanConsult.getComment());
			columns.append(",comment");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanConsult.getConsultUsername())){
			params.add(tLoanConsult.getConsultUsername());
			columns.append(",consult_username");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanConsult.getUpdateDate())){
			params.add(tLoanConsult.getUpdateDate());
			columns.append(",update_date");
			questions.append(",?");
		}else{
			columns.append(",update_date");
			questions.append(",now()");
		}
		if(ParameterCheck.hasValue(tLoanConsult.getCreateDate())){
			params.add(tLoanConsult.getCreateDate());
			columns.append(",create_date");
			questions.append(",?");
		}else{
			columns.append(",create_date");
			questions.append(",now()");
		}
		String sql = "insert into " + TABLE + "(" + columns.toString().substring(1) + ") values(" + questions.toString().substring(1) +")";
		if(log.isDebugEnabled()){
			log.debug("insertTLoanConsultSelective : SQL IS : " + sql + " : PARAM IS : " + params.toArray());
		}
		this.getJdbcTemplate().update(sql, params.toArray());
		
		tLoanConsult.setLoanConsultid(this.getJdbcTemplate().queryForInt("select last_insert_id()"));
		return tLoanConsult.getLoanConsultid();
	}
	
	
	
	public void deleteByLoanConsultid(Integer loanConsultid) throws Exception {
		String sql = "delete from " +TABLE +" where  loan_consultId=?";
		Object args[] = new Object[] {loanConsultid};

		if(log.isDebugEnabled()){
			log.debug("deleteTLoanConsultByLoanConsultid : SQL IS : " + sql + " : PARAM IS : " + args);
		}
		this.getJdbcTemplate().update(sql, args);
	}
	
	
    
	public void deleteByBean(TLoanConsult tLoanConsult) throws Exception{
		List<Object> params = new ArrayList<Object>();
  		StringBuffer columns = new StringBuffer();
		if(ParameterCheck.hasValue(tLoanConsult.getLoanPid())){
			params.add(tLoanConsult.getLoanPid());
			columns.append("and loan_pid=? ");
		}
		if(ParameterCheck.hasValue(tLoanConsult.getComment())){
			params.add(tLoanConsult.getComment());
			columns.append("and comment=? ");
		}
		if(ParameterCheck.hasValue(tLoanConsult.getConsultUsername())){
			params.add(tLoanConsult.getConsultUsername());
			columns.append("and consult_username=? ");
		}
		if(ParameterCheck.hasValue(tLoanConsult.getUpdateDate())){
			params.add(tLoanConsult.getUpdateDate());
			columns.append("and update_date=? ");
		}
		if(ParameterCheck.hasValue(tLoanConsult.getCreateDate())){
			params.add(tLoanConsult.getCreateDate());
			columns.append("and create_date=? ");
		}

		String sql = "delete from " +TABLE + " where " +columns.toString().substring(4);
		if(log.isDebugEnabled()){
			log.debug("deleteTLoanConsultByBean : SQL IS : " + sql + " : PARAM IS : " + params.toArray());
		}
	    this.getJdbcTemplate().update(sql,params.toArray());
	}
	
	
	@Deprecated
	public void update(TLoanConsult tLoanConsult) throws Exception {
		String sql = "update " +TABLE +" set loan_pid=?,comment=?,consult_username=?,update_date=?,create_date=? where  loan_consultId=?";
		Object args[] = new Object[] {tLoanConsult.getLoanPid(),tLoanConsult.getComment(),tLoanConsult.getConsultUsername(),tLoanConsult.getUpdateDate(),tLoanConsult.getCreateDate(),tLoanConsult.getLoanConsultid()};
		if(log.isDebugEnabled()){
			log.debug("updateTLoanConsult : SQL IS : " + sql + " : PARAM IS : " + args);
		}
		this.getJdbcTemplate().update(sql, args);
	}
	
	
	
	public void updateSelective(TLoanConsult tLoanConsult) throws Exception {
		List<Object> params = new ArrayList<Object>();
        StringBuffer columns = new StringBuffer();
        String keys = "";
		if(ParameterCheck.hasValue(tLoanConsult.getLoanPid())){
			params.add(tLoanConsult.getLoanPid());
			columns.append(",loan_pid=?");
		}
		if(ParameterCheck.hasValue(tLoanConsult.getComment())){
			params.add(tLoanConsult.getComment());
			columns.append(",comment=?");
		}
		if(ParameterCheck.hasValue(tLoanConsult.getConsultUsername())){
			params.add(tLoanConsult.getConsultUsername());
			columns.append(",consult_username=?");
		}
		if(ParameterCheck.hasValue(tLoanConsult.getUpdateDate())){
			params.add(tLoanConsult.getUpdateDate());
			columns.append(",update_date=?");
		}else{
   			columns.append(",update_date=now()");
		}
		if(ParameterCheck.hasValue(tLoanConsult.getCreateDate())){
			params.add(tLoanConsult.getCreateDate());
			columns.append(",create_date=?");
		}

		
		if(ParameterCheck.hasValue(tLoanConsult.getLoanConsultid())){
			params.add(tLoanConsult.getLoanConsultid());
			keys += "and loan_consultId=? ";
		}
		String sql = "update " + TABLE + " set " +columns.toString().substring(1)+" where "+keys.substring(4);
		if(log.isDebugEnabled()){
			log.debug("updateTLoanConsultSelective : SQL IS : " + sql + " : PARAM IS : " + params.toArray());
		}
		this.getJdbcTemplate().update(sql, params.toArray());
	}
	
	
		
	
	public TLoanConsult getByLoanConsultid(Integer loanConsultid) {
		String sql = "select TLoanConsult.loan_consultId as loanConsultid ,TLoanConsult.loan_pid as loanPid,TLoanConsult.comment as comment,TLoanConsult.consult_username as consultUsername,TLoanConsult.update_date as updateDate,TLoanConsult.create_date as createDate from "+TABLE+" as TLoanConsult where  TLoanConsult.loan_consultId=?";
		if(log.isDebugEnabled()){
			log.debug("getTLoanConsultByLoanConsultid : SQL IS : " + sql + " : PARAM IS : " + loanConsultid);
		}
		List<TLoanConsult> tLoanConsultList = this.getJdbcTemplate().query(sql,new Object[]{loanConsultid}, ParameterizedBeanPropertyRowMapper.newInstance(TLoanConsult.class));
		return tLoanConsultList.size() > 0 ? tLoanConsultList.get(0) : null;
	}
	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public Collection<TLoanConsult> getAll(Map<String, Object> parameter) {
		return getAll(parameter ,"updateDate" ,false ,true);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public Collection<TLoanConsult> getAll(Map<String, Object> parameter ,String orderBy) {
		return getAll(parameter ,orderBy ,true ,true);
	}
	
	/**
	 * get the data by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public Collection<TLoanConsult> getAll(Map<String, Object> parameter ,String orderBy ,boolean asc) {
		return getAll(parameter ,orderBy ,asc ,true);

	}
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public Collection<TLoanConsult> getAll(Map<String, Object> parameter ,boolean orderFlag) {
		return getAll(parameter ,"" ,false ,false);
	}
	
	private Collection<TLoanConsult> getAll(Map<String, Object> parameter,String orderBy,boolean asc,boolean order) {
		String sql = "select TLoanConsult.loan_consultId as loanConsultid ,TLoanConsult.loan_pid as loanPid,TLoanConsult.comment as comment,TLoanConsult.consult_username as consultUsername,TLoanConsult.update_date as updateDate,TLoanConsult.create_date as createDate from "+TABLE +" as TLoanConsult" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
		if(parameter != null){
            if(ParameterCheck.hasValue(parameter.get("loanConsultid"))){
			    withParameter = true;    
				sb.append(" and TLoanConsult.loan_consultId=? ");
				params.add(parameter.get("loanConsultid"));
			}

            if(ParameterCheck.hasValue(parameter.get("loanPid"))){
			    withParameter = true;    
				sb.append(" and TLoanConsult.loan_pid=? ");
				params.add(parameter.get("loanPid"));
			}

            if(ParameterCheck.hasValue(parameter.get("comment"))){
			    withParameter = true;    
				sb.append(" and TLoanConsult.comment=? ");
				params.add(parameter.get("comment"));
			}

            if(ParameterCheck.hasValue(parameter.get("consultUsername"))){
			    withParameter = true;    
				sb.append(" and TLoanConsult.consult_username=? ");
				params.add(parameter.get("consultUsername"));
			}

            if(ParameterCheck.hasValue(parameter.get("updateDate"))){
			    withParameter = true;    
				sb.append(" and TLoanConsult.update_date=? ");
				params.add(parameter.get("updateDate"));
			}

            if(ParameterCheck.hasValue(parameter.get("createDate"))){
			    withParameter = true;    
				sb.append(" and TLoanConsult.create_date=? ");
				params.add(parameter.get("createDate"));
			}
		}
		
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sb.append(" order by TLoanConsult." + orderSql);
		}
		
		if(log.isDebugEnabled()){
			log.debug("getAll : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
		}
		if(withParameter){
			return this.getJdbcTemplate().query(sql+ sb.toString(),params.toArray(), ParameterizedBeanPropertyRowMapper.newInstance(TLoanConsult.class));
		}else{
			return this.getJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(TLoanConsult.class));
		}
		
	}

	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public Collection<TLoanConsult> getAllByBean(TLoanConsult tLoanConsult) {
		return getAllByBean(tLoanConsult ,"updateDate" ,false ,true);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public Collection<TLoanConsult> getAllByBean(TLoanConsult tLoanConsult ,String orderBy) {
		return getAllByBean(tLoanConsult ,orderBy ,true ,true);
	}
	
	/**
	 * get the datat by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public Collection<TLoanConsult> getAllByBean(TLoanConsult tLoanConsult ,String orderBy ,boolean asc) {
		return getAllByBean(tLoanConsult ,orderBy ,asc ,true);
	}
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public Collection<TLoanConsult> getAllByBean(TLoanConsult tLoanConsult ,boolean orderFlag) {
		return getAllByBean(tLoanConsult ,"" ,false ,false);
	}
	

	
	private Collection<TLoanConsult> getAllByBean(TLoanConsult tLoanConsult,String orderBy,boolean asc,boolean order) {
		String sql = "select TLoanConsult.loan_consultId as loanConsultid ,TLoanConsult.loan_pid as loanPid,TLoanConsult.comment as comment,TLoanConsult.consult_username as consultUsername,TLoanConsult.update_date as updateDate,TLoanConsult.create_date as createDate from "+TABLE +" as TLoanConsult" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
            
		if(ParameterCheck.hasValue(tLoanConsult.getLoanConsultid())){
		    withParameter = true;    
			sb.append(" and TLoanConsult.loan_consultId=? ");
			params.add(tLoanConsult.getLoanConsultid());
		}

		if(ParameterCheck.hasValue(tLoanConsult.getLoanPid())){
		    withParameter = true;    
			sb.append(" and TLoanConsult.loan_pid=? ");
			params.add(tLoanConsult.getLoanPid());
		}

		if(ParameterCheck.hasValue(tLoanConsult.getComment())){
		    withParameter = true;    
			sb.append(" and TLoanConsult.comment=? ");
			params.add(tLoanConsult.getComment());
		}

		if(ParameterCheck.hasValue(tLoanConsult.getConsultUsername())){
		    withParameter = true;    
			sb.append(" and TLoanConsult.consult_username=? ");
			params.add(tLoanConsult.getConsultUsername());
		}

		if(ParameterCheck.hasValue(tLoanConsult.getUpdateDate())){
		    withParameter = true;    
			sb.append(" and TLoanConsult.update_date=? ");
			params.add(tLoanConsult.getUpdateDate());
		}

		if(ParameterCheck.hasValue(tLoanConsult.getCreateDate())){
		    withParameter = true;    
			sb.append(" and TLoanConsult.create_date=? ");
			params.add(tLoanConsult.getCreateDate());
		}
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sb.append(" order by TLoanConsult." + orderSql);
		}
		if(log.isDebugEnabled()){
			log.debug("getAllByBean : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
		}
		if(withParameter){
			return this.getJdbcTemplate().query(sql+ sb.toString(),params.toArray(), ParameterizedBeanPropertyRowMapper.newInstance(TLoanConsult.class));
		}else{
			return this.getJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(TLoanConsult.class));
		}		
	}
	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public Pagination<TLoanConsult> getPageAllByCondition(Map<String, Object> parameter, int pageIndex, int pageSize) {
		return getPageAllByCondition(parameter ,pageIndex ,pageSize ,"updateDate" ,false ,true);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public Pagination<TLoanConsult> getPageAllByCondition(Map<String, Object> parameter, int pageIndex, int pageSize, String orderBy) {
		return getPageAllByCondition(parameter ,pageIndex ,pageSize ,orderBy ,true ,true);
	}
	
	/**
	 * get the datat by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public Pagination<TLoanConsult> getPageAllByCondition(Map<String, Object> parameter, int pageIndex, int pageSize, String orderBy, boolean asc) {
		return getPageAllByCondition(parameter ,pageIndex ,pageSize ,orderBy ,asc ,true);
	}
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public Pagination<TLoanConsult> getPageAllByCondition(Map<String, Object> parameter, int pageIndex, int pageSize, boolean orderFlag) {
		return getPageAllByCondition(parameter ,pageIndex ,pageSize ,"" ,false ,false);
	}
	
	private Pagination<TLoanConsult> getPageAllByCondition(Map<String, Object> parameter, int pageIndex, int pageSize,String orderBy,boolean asc,boolean order) {
		String sql = "select TLoanConsult.loan_consultId as loanConsultid ,TLoanConsult.loan_pid as loanPid,TLoanConsult.comment as comment,TLoanConsult.consult_username as consultUsername,TLoanConsult.update_date as updateDate,TLoanConsult.create_date as createDate from "+TABLE +" as TLoanConsult" +" where 1=1 ";
		String countSql = "select count(*) from "+TABLE +" as TLoanConsult" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
		if(parameter != null){

            if(ParameterCheck.hasValue(parameter.get("loanConsultid"))){
				withParameter = true;   
				sb.append(" and TLoanConsult.loan_consultId=? ");
				params.add(parameter.get("loanConsultid"));
			}

            if(ParameterCheck.hasValue(parameter.get("loanPid"))){
			    withParameter = true;    
				sb.append(" and TLoanConsult.loan_pid=? ");
				params.add(parameter.get("loanPid"));
			}

            if(ParameterCheck.hasValue(parameter.get("comment"))){
			    withParameter = true;    
				sb.append(" and TLoanConsult.comment=? ");
				params.add(parameter.get("comment"));
			}

            if(ParameterCheck.hasValue(parameter.get("consultUsername"))){
			    withParameter = true;    
				sb.append(" and TLoanConsult.consult_username=? ");
				params.add(parameter.get("consultUsername"));
			}

            if(ParameterCheck.hasValue(parameter.get("updateDate"))){
			    withParameter = true;    
				sb.append(" and TLoanConsult.update_date=? ");
				params.add(parameter.get("updateDate"));
			}

            if(ParameterCheck.hasValue(parameter.get("createDate"))){
			    withParameter = true;    
				sb.append(" and TLoanConsult.create_date=? ");
				params.add(parameter.get("createDate"));
			}
		}
		Pagination<TLoanConsult> page = new Pagination<TLoanConsult>(pageIndex,pageSize);
		
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sb.append(" order by TLoanConsult." + orderSql);
		}
		if(log.isDebugEnabled()){
			log.debug("getPageAllTLoanConsultByCondition : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
			log.debug("pageIndex : " + pageIndex + "   pageSize:  " + pageSize);
		}
		if(withParameter){
			this.paginationQuery(sql + sb.toString(),countSql + sb.toString(), params.toArray(), page,ParameterizedBeanPropertyRowMapper.newInstance(TLoanConsult.class));
		}else{
		    this.paginationQuery(sql,countSql ,page,ParameterizedBeanPropertyRowMapper.newInstance(TLoanConsult.class));
		}
		return page;
	}
	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public Pagination<TLoanConsult> getPageAllByBean(TLoanConsult tLoanConsult, int pageIndex, int pageSize) {
		return getPageAllByBean(tLoanConsult ,pageIndex ,pageSize ,"updateDate" ,false ,true);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public Pagination<TLoanConsult> getPageAllByBean(TLoanConsult tLoanConsult, int pageIndex, int pageSize,String orderBy) {
		return  getPageAllByBean(tLoanConsult ,pageIndex ,pageSize ,orderBy ,true ,true);
	}
	
	/**
	 * get the datat by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public Pagination<TLoanConsult> getPageAllByBean(TLoanConsult tLoanConsult, int pageIndex, int pageSize,String orderBy,boolean asc) {
		return  getPageAllByBean(tLoanConsult ,pageIndex ,pageSize ,orderBy ,asc ,true);
	}
	
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public Pagination<TLoanConsult> getPageAllByBean(TLoanConsult tLoanConsult, int pageIndex, int pageSize,boolean orderFlag) {
		return  getPageAllByBean(tLoanConsult ,pageIndex ,pageSize ,"" ,false ,false);
	}
	
	private Pagination<TLoanConsult> getPageAllByBean(TLoanConsult tLoanConsult, int pageIndex, int pageSize,String orderBy,boolean asc,boolean order) {
		String sql = "select TLoanConsult.loan_consultId as loanConsultid ,TLoanConsult.loan_pid as loanPid,TLoanConsult.comment as comment,TLoanConsult.consult_username as consultUsername,TLoanConsult.update_date as updateDate,TLoanConsult.create_date as createDate from "+TABLE +" as TLoanConsult" +" where 1=1 ";
		String countSql = "select count(*) from "+TABLE +" as TLoanConsult" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 

		if(ParameterCheck.hasValue(tLoanConsult.getLoanConsultid())){
			withParameter = true;   
			sb.append(" and TLoanConsult.loan_consultId=? ");
			params.add(tLoanConsult.getLoanConsultid());
		}
        
		if(ParameterCheck.hasValue(tLoanConsult.getLoanPid())){
		    withParameter = true;    
			sb.append(" and TLoanConsult.loan_pid=? ");
			params.add(tLoanConsult.getLoanPid());
		}
        
		if(ParameterCheck.hasValue(tLoanConsult.getComment())){
		    withParameter = true;    
			sb.append(" and TLoanConsult.comment=? ");
			params.add(tLoanConsult.getComment());
		}
        
		if(ParameterCheck.hasValue(tLoanConsult.getConsultUsername())){
		    withParameter = true;    
			sb.append(" and TLoanConsult.consult_username=? ");
			params.add(tLoanConsult.getConsultUsername());
		}
        
		if(ParameterCheck.hasValue(tLoanConsult.getUpdateDate())){
		    withParameter = true;    
			sb.append(" and TLoanConsult.update_date=? ");
			params.add(tLoanConsult.getUpdateDate());
		}
        
		if(ParameterCheck.hasValue(tLoanConsult.getCreateDate())){
		    withParameter = true;    
			sb.append(" and TLoanConsult.create_date=? ");
			params.add(tLoanConsult.getCreateDate());
		}

		Pagination<TLoanConsult> page = new Pagination<TLoanConsult>(pageIndex,pageSize);
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sb.append(" order by TLoanConsult." + orderSql);
		}
		if(log.isDebugEnabled()){
			log.debug("getPageAllTLoanConsultByBean : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
			log.debug("pageIndex : " + pageIndex + "   pageSize:  " + pageSize);
		}
		if(withParameter){
			this.paginationQuery(sql + sb.toString(),countSql + sb.toString(), params.toArray(), page,ParameterizedBeanPropertyRowMapper.newInstance(TLoanConsult.class));
		}else{
		    this.paginationQuery(sql,countSql ,page,ParameterizedBeanPropertyRowMapper.newInstance(TLoanConsult.class));
		}
		return page;
	}
	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public List<TLoanConsult> getAll(){
		return getAll("updateDate" ,false ,true);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public List<TLoanConsult> getAll(String orderBy){
		return getAll(orderBy ,true ,true);
	}
	
	/**
	 * get the datat by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public List<TLoanConsult> getAll(String orderBy,boolean asc){
		return getAll(orderBy ,asc ,true);
	}
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public List<TLoanConsult> getAll(boolean orderFlag){
		return getAll("" ,false ,false);
	}
	
	private List<TLoanConsult> getAll(String orderBy,boolean asc,boolean order){
		String sql = "select TLoanConsult.loan_consultId as loanConsultid ,TLoanConsult.loan_pid as loanPid,TLoanConsult.comment as comment,TLoanConsult.consult_username as consultUsername,TLoanConsult.update_date as updateDate,TLoanConsult.create_date as createDate from " + TABLE +" as TLoanConsult" ;	
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sql += (" order by TLoanConsult." + orderSql);
		}
		return this.getJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(TLoanConsult.class));	
	}
	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public Pagination<TLoanConsult> getPageAll(int pageIndex, int pageSize) {
		return getPageAll(pageIndex ,pageSize ,"updateDate" ,false ,true);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public Pagination<TLoanConsult> getPageAll(int pageIndex, int pageSize,String orderBy) {
		return getPageAll(pageIndex ,pageSize ,orderBy ,true ,true);
	}
	
	/**
	 * get the datat by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public Pagination<TLoanConsult> getPageAll(int pageIndex, int pageSize,String orderBy,boolean asc) {
		return getPageAll(pageIndex ,pageSize ,orderBy ,asc ,true);
	}
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public Pagination<TLoanConsult> getPageAll(int pageIndex, int pageSize,boolean orderFlag) {
		return getPageAll(pageIndex ,pageSize ,"" ,false ,false);
	}
	
	
	
	private Pagination<TLoanConsult> getPageAll(int pageIndex, int pageSize,String orderBy,boolean asc,boolean order) {
		String sql ="select TLoanConsult.loan_consultId as loanConsultid ,TLoanConsult.loan_pid as loanPid,TLoanConsult.comment as comment,TLoanConsult.consult_username as consultUsername,TLoanConsult.update_date as updateDate,TLoanConsult.create_date as createDate from " + TABLE +" as TLoanConsult" ;
		String countSql = "select count(*) from " + TABLE;
		
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sql += (" order by TLoanConsult." + orderSql);
		}
		Pagination<TLoanConsult> page = new Pagination<TLoanConsult>(pageIndex,pageSize);
		this.paginationQuery(sql,countSql, page,ParameterizedBeanPropertyRowMapper.newInstance(TLoanConsult.class));
		return page;
	}
	
	

	protected class TLoanConsultRowMapper implements RowMapper<TLoanConsult> {
		public TLoanConsult mapRow(ResultSet rs, int rowNum) throws SQLException {
			TLoanConsult tLoanConsult = new TLoanConsult();
        	tLoanConsult.setLoanConsultid(rs.getInt("loanConsultid"));
			tLoanConsult.setLoanPid(rs.getInt("loanPid"));
			tLoanConsult.setComment(rs.getString("comment"));
			tLoanConsult.setConsultUsername(rs.getString("consultUsername"));
			tLoanConsult.setUpdateDate(rs.getDate("updateDate"));
			tLoanConsult.setCreateDate(rs.getDate("createDate"));
			return tLoanConsult;
		}
	}
}