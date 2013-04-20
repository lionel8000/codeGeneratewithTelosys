package com.kdkj.p2p.dao.loan;

import com.kdkj.p2p.utils.ParameterCheck;
import com.kdkj.p2p.entities.loan.TLoanBoss;
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
public class TLoanBossDao extends CoreJdbcDaoSupport {

    private static Logger log = LoggerFactory.getLogger(TLoanBossDao.class);  

    private static String TABLE = "t_loan_boss";
	
	@Deprecated
	public Integer insert(TLoanBoss tLoanBoss) throws Exception {
		String sql = "insert into "+TABLE +"(loan_pid,company_years,company_square,company_openMoney)  values(?,?,?,?)";
		Object args[] = new Object[] { tLoanBoss.getLoanPid(),tLoanBoss.getCompanyYears(),tLoanBoss.getCompanySquare(),tLoanBoss.getCompanyOpenmoney() };
		if(log.isDebugEnabled()){
			log.debug("insertTLoanBoss : SQL IS : " + sql + " : PARAM IS : " + args);
		}
		this.getJdbcTemplate().update(sql, args);
		tLoanBoss.setLoanBossId(this.getJdbcTemplate().queryForInt("select last_insert_id()"));
        return tLoanBoss.getLoanBossId();
	}

	
	
	public Integer insertSelective(TLoanBoss tLoanBoss) throws Exception {
		StringBuffer columns = new StringBuffer();
		StringBuffer questions = new StringBuffer(30);
		List<Object> params = new ArrayList<Object>();


		if(ParameterCheck.hasValue(tLoanBoss.getLoanPid())){
			params.add(tLoanBoss.getLoanPid());
			columns.append(",loan_pid");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanBoss.getCompanyYears())){
			params.add(tLoanBoss.getCompanyYears());
			columns.append(",company_years");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanBoss.getCompanySquare())){
			params.add(tLoanBoss.getCompanySquare());
			columns.append(",company_square");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanBoss.getCompanyOpenmoney())){
			params.add(tLoanBoss.getCompanyOpenmoney());
			columns.append(",company_openMoney");
			questions.append(",?");
		}
		String sql = "insert into " + TABLE + "(" + columns.toString().substring(1) + ") values(" + questions.toString().substring(1) +")";
		if(log.isDebugEnabled()){
			log.debug("insertTLoanBossSelective : SQL IS : " + sql + " : PARAM IS : " + params.toArray());
		}
		this.getJdbcTemplate().update(sql, params.toArray());
		
		tLoanBoss.setLoanBossId(this.getJdbcTemplate().queryForInt("select last_insert_id()"));
		return tLoanBoss.getLoanBossId();
	}
	
	
	
	public void deleteByLoanBossId(Integer loanBossId) throws Exception {
		String sql = "delete from " +TABLE +" where  loan_boss_id=?";
		Object args[] = new Object[] {loanBossId};

		if(log.isDebugEnabled()){
			log.debug("deleteTLoanBossByLoanBossId : SQL IS : " + sql + " : PARAM IS : " + args);
		}
		this.getJdbcTemplate().update(sql, args);
	}
	
	
    
	public void deleteByBean(TLoanBoss tLoanBoss) throws Exception{
		List<Object> params = new ArrayList<Object>();
  		StringBuffer columns = new StringBuffer();
		if(ParameterCheck.hasValue(tLoanBoss.getLoanPid())){
			params.add(tLoanBoss.getLoanPid());
			columns.append("and loan_pid=? ");
		}
		if(ParameterCheck.hasValue(tLoanBoss.getCompanyYears())){
			params.add(tLoanBoss.getCompanyYears());
			columns.append("and company_years=? ");
		}
		if(ParameterCheck.hasValue(tLoanBoss.getCompanySquare())){
			params.add(tLoanBoss.getCompanySquare());
			columns.append("and company_square=? ");
		}
		if(ParameterCheck.hasValue(tLoanBoss.getCompanyOpenmoney())){
			params.add(tLoanBoss.getCompanyOpenmoney());
			columns.append("and company_openMoney=? ");
		}

		String sql = "delete from " +TABLE + " where " +columns.toString().substring(4);
		if(log.isDebugEnabled()){
			log.debug("deleteTLoanBossByBean : SQL IS : " + sql + " : PARAM IS : " + params.toArray());
		}
	    this.getJdbcTemplate().update(sql,params.toArray());
	}
	
	
	@Deprecated
	public void update(TLoanBoss tLoanBoss) throws Exception {
		String sql = "update " +TABLE +" set loan_pid=?,company_years=?,company_square=?,company_openMoney=? where  loan_boss_id=?";
		Object args[] = new Object[] {tLoanBoss.getLoanPid(),tLoanBoss.getCompanyYears(),tLoanBoss.getCompanySquare(),tLoanBoss.getCompanyOpenmoney(),tLoanBoss.getLoanBossId()};
		if(log.isDebugEnabled()){
			log.debug("updateTLoanBoss : SQL IS : " + sql + " : PARAM IS : " + args);
		}
		this.getJdbcTemplate().update(sql, args);
	}
	
	
	
	public void updateSelective(TLoanBoss tLoanBoss) throws Exception {
		List<Object> params = new ArrayList<Object>();
        StringBuffer columns = new StringBuffer();
        String keys = "";
		if(ParameterCheck.hasValue(tLoanBoss.getLoanPid())){
			params.add(tLoanBoss.getLoanPid());
			columns.append(",loan_pid=?");
		}
		if(ParameterCheck.hasValue(tLoanBoss.getCompanyYears())){
			params.add(tLoanBoss.getCompanyYears());
			columns.append(",company_years=?");
		}
		if(ParameterCheck.hasValue(tLoanBoss.getCompanySquare())){
			params.add(tLoanBoss.getCompanySquare());
			columns.append(",company_square=?");
		}
		if(ParameterCheck.hasValue(tLoanBoss.getCompanyOpenmoney())){
			params.add(tLoanBoss.getCompanyOpenmoney());
			columns.append(",company_openMoney=?");
		}

		
		if(ParameterCheck.hasValue(tLoanBoss.getLoanBossId())){
			params.add(tLoanBoss.getLoanBossId());
			keys += "and loan_boss_id=? ";
		}
		String sql = "update " + TABLE + " set " +columns.toString().substring(1)+" where "+keys.substring(4);
		if(log.isDebugEnabled()){
			log.debug("updateTLoanBossSelective : SQL IS : " + sql + " : PARAM IS : " + params.toArray());
		}
		this.getJdbcTemplate().update(sql, params.toArray());
	}
	
	
		
	
	public TLoanBoss getByLoanBossId(Integer loanBossId) {
		String sql = "select TLoanBoss.loan_boss_id as loanBossId ,TLoanBoss.loan_pid as loanPid,TLoanBoss.company_years as companyYears,TLoanBoss.company_square as companySquare,TLoanBoss.company_openMoney as companyOpenmoney from "+TABLE+" as TLoanBoss where  TLoanBoss.loan_boss_id=?";
		if(log.isDebugEnabled()){
			log.debug("getTLoanBossByLoanBossId : SQL IS : " + sql + " : PARAM IS : " + loanBossId);
		}
		List<TLoanBoss> tLoanBossList = this.getJdbcTemplate().query(sql,new Object[]{loanBossId}, ParameterizedBeanPropertyRowMapper.newInstance(TLoanBoss.class));
		return tLoanBossList.size() > 0 ? tLoanBossList.get(0) : null;
	}
	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public Collection<TLoanBoss> getAll(Map<String, Object> parameter) {
		return getAll(parameter ,"" ,false ,false);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public Collection<TLoanBoss> getAll(Map<String, Object> parameter ,String orderBy) {
		return getAll(parameter ,orderBy ,true ,true);
	}
	
	/**
	 * get the data by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public Collection<TLoanBoss> getAll(Map<String, Object> parameter ,String orderBy ,boolean asc) {
		return getAll(parameter ,orderBy ,asc ,true);

	}
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public Collection<TLoanBoss> getAll(Map<String, Object> parameter ,boolean orderFlag) {
		return getAll(parameter ,"" ,false ,false);
	}
	
	private Collection<TLoanBoss> getAll(Map<String, Object> parameter,String orderBy,boolean asc,boolean order) {
		String sql = "select TLoanBoss.loan_boss_id as loanBossId ,TLoanBoss.loan_pid as loanPid,TLoanBoss.company_years as companyYears,TLoanBoss.company_square as companySquare,TLoanBoss.company_openMoney as companyOpenmoney from "+TABLE +" as TLoanBoss" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
		if(parameter != null){
            if(ParameterCheck.hasValue(parameter.get("loanBossId"))){
			    withParameter = true;    
				sb.append(" and TLoanBoss.loan_boss_id=? ");
				params.add(parameter.get("loanBossId"));
			}

            if(ParameterCheck.hasValue(parameter.get("loanPid"))){
			    withParameter = true;    
				sb.append(" and TLoanBoss.loan_pid=? ");
				params.add(parameter.get("loanPid"));
			}

            if(ParameterCheck.hasValue(parameter.get("companyYears"))){
			    withParameter = true;    
				sb.append(" and TLoanBoss.company_years=? ");
				params.add(parameter.get("companyYears"));
			}

            if(ParameterCheck.hasValue(parameter.get("companySquare"))){
			    withParameter = true;    
				sb.append(" and TLoanBoss.company_square=? ");
				params.add(parameter.get("companySquare"));
			}

            if(ParameterCheck.hasValue(parameter.get("companyOpenmoney"))){
			    withParameter = true;    
				sb.append(" and TLoanBoss.company_openMoney=? ");
				params.add(parameter.get("companyOpenmoney"));
			}
		}
		
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sb.append(" order by TLoanBoss." + orderSql);
		}
		
		if(log.isDebugEnabled()){
			log.debug("getAll : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
		}
		if(withParameter){
			return this.getJdbcTemplate().query(sql+ sb.toString(),params.toArray(), ParameterizedBeanPropertyRowMapper.newInstance(TLoanBoss.class));
		}else{
			return this.getJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(TLoanBoss.class));
		}
		
	}

	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public Collection<TLoanBoss> getAllByBean(TLoanBoss tLoanBoss) {
		return getAllByBean(tLoanBoss ,"" ,false ,false);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public Collection<TLoanBoss> getAllByBean(TLoanBoss tLoanBoss ,String orderBy) {
		return getAllByBean(tLoanBoss ,orderBy ,true ,true);
	}
	
	/**
	 * get the datat by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public Collection<TLoanBoss> getAllByBean(TLoanBoss tLoanBoss ,String orderBy ,boolean asc) {
		return getAllByBean(tLoanBoss ,orderBy ,asc ,true);
	}
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public Collection<TLoanBoss> getAllByBean(TLoanBoss tLoanBoss ,boolean orderFlag) {
		return getAllByBean(tLoanBoss ,"" ,false ,false);
	}
	

	
	private Collection<TLoanBoss> getAllByBean(TLoanBoss tLoanBoss,String orderBy,boolean asc,boolean order) {
		String sql = "select TLoanBoss.loan_boss_id as loanBossId ,TLoanBoss.loan_pid as loanPid,TLoanBoss.company_years as companyYears,TLoanBoss.company_square as companySquare,TLoanBoss.company_openMoney as companyOpenmoney from "+TABLE +" as TLoanBoss" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
            
		if(ParameterCheck.hasValue(tLoanBoss.getLoanBossId())){
		    withParameter = true;    
			sb.append(" and TLoanBoss.loan_boss_id=? ");
			params.add(tLoanBoss.getLoanBossId());
		}

		if(ParameterCheck.hasValue(tLoanBoss.getLoanPid())){
		    withParameter = true;    
			sb.append(" and TLoanBoss.loan_pid=? ");
			params.add(tLoanBoss.getLoanPid());
		}

		if(ParameterCheck.hasValue(tLoanBoss.getCompanyYears())){
		    withParameter = true;    
			sb.append(" and TLoanBoss.company_years=? ");
			params.add(tLoanBoss.getCompanyYears());
		}

		if(ParameterCheck.hasValue(tLoanBoss.getCompanySquare())){
		    withParameter = true;    
			sb.append(" and TLoanBoss.company_square=? ");
			params.add(tLoanBoss.getCompanySquare());
		}

		if(ParameterCheck.hasValue(tLoanBoss.getCompanyOpenmoney())){
		    withParameter = true;    
			sb.append(" and TLoanBoss.company_openMoney=? ");
			params.add(tLoanBoss.getCompanyOpenmoney());
		}
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sb.append(" order by TLoanBoss." + orderSql);
		}
		if(log.isDebugEnabled()){
			log.debug("getAllByBean : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
		}
		if(withParameter){
			return this.getJdbcTemplate().query(sql+ sb.toString(),params.toArray(), ParameterizedBeanPropertyRowMapper.newInstance(TLoanBoss.class));
		}else{
			return this.getJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(TLoanBoss.class));
		}		
	}
	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public Pagination<TLoanBoss> getPageAllByCondition(Map<String, Object> parameter, int pageIndex, int pageSize) {
		return getPageAllByCondition(parameter ,pageIndex ,pageSize ,"" ,false ,false);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public Pagination<TLoanBoss> getPageAllByCondition(Map<String, Object> parameter, int pageIndex, int pageSize, String orderBy) {
		return getPageAllByCondition(parameter ,pageIndex ,pageSize ,orderBy ,true ,true);
	}
	
	/**
	 * get the datat by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public Pagination<TLoanBoss> getPageAllByCondition(Map<String, Object> parameter, int pageIndex, int pageSize, String orderBy, boolean asc) {
		return getPageAllByCondition(parameter ,pageIndex ,pageSize ,orderBy ,asc ,true);
	}
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public Pagination<TLoanBoss> getPageAllByCondition(Map<String, Object> parameter, int pageIndex, int pageSize, boolean orderFlag) {
		return getPageAllByCondition(parameter ,pageIndex ,pageSize ,"" ,false ,false);
	}
	
	private Pagination<TLoanBoss> getPageAllByCondition(Map<String, Object> parameter, int pageIndex, int pageSize,String orderBy,boolean asc,boolean order) {
		String sql = "select TLoanBoss.loan_boss_id as loanBossId ,TLoanBoss.loan_pid as loanPid,TLoanBoss.company_years as companyYears,TLoanBoss.company_square as companySquare,TLoanBoss.company_openMoney as companyOpenmoney from "+TABLE +" as TLoanBoss" +" where 1=1 ";
		String countSql = "select count(*) from "+TABLE +" as TLoanBoss" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
		if(parameter != null){

            if(ParameterCheck.hasValue(parameter.get("loanBossId"))){
				withParameter = true;   
				sb.append(" and TLoanBoss.loan_boss_id=? ");
				params.add(parameter.get("loanBossId"));
			}

            if(ParameterCheck.hasValue(parameter.get("loanPid"))){
			    withParameter = true;    
				sb.append(" and TLoanBoss.loan_pid=? ");
				params.add(parameter.get("loanPid"));
			}

            if(ParameterCheck.hasValue(parameter.get("companyYears"))){
			    withParameter = true;    
				sb.append(" and TLoanBoss.company_years=? ");
				params.add(parameter.get("companyYears"));
			}

            if(ParameterCheck.hasValue(parameter.get("companySquare"))){
			    withParameter = true;    
				sb.append(" and TLoanBoss.company_square=? ");
				params.add(parameter.get("companySquare"));
			}

            if(ParameterCheck.hasValue(parameter.get("companyOpenmoney"))){
			    withParameter = true;    
				sb.append(" and TLoanBoss.company_openMoney=? ");
				params.add(parameter.get("companyOpenmoney"));
			}
		}
		Pagination<TLoanBoss> page = new Pagination<TLoanBoss>(pageIndex,pageSize);
		
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sb.append(" order by TLoanBoss." + orderSql);
		}
		if(log.isDebugEnabled()){
			log.debug("getPageAllTLoanBossByCondition : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
			log.debug("pageIndex : " + pageIndex + "   pageSize:  " + pageSize);
		}
		if(withParameter){
			this.paginationQuery(sql + sb.toString(),countSql + sb.toString(), params.toArray(), page,ParameterizedBeanPropertyRowMapper.newInstance(TLoanBoss.class));
		}else{
		    this.paginationQuery(sql,countSql ,page,ParameterizedBeanPropertyRowMapper.newInstance(TLoanBoss.class));
		}
		return page;
	}
	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public Pagination<TLoanBoss> getPageAllByBean(TLoanBoss tLoanBoss, int pageIndex, int pageSize) {
		return getPageAllByBean(tLoanBoss ,pageIndex ,pageSize ,"" ,false ,false);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public Pagination<TLoanBoss> getPageAllByBean(TLoanBoss tLoanBoss, int pageIndex, int pageSize,String orderBy) {
		return  getPageAllByBean(tLoanBoss ,pageIndex ,pageSize ,orderBy ,true ,true);
	}
	
	/**
	 * get the datat by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public Pagination<TLoanBoss> getPageAllByBean(TLoanBoss tLoanBoss, int pageIndex, int pageSize,String orderBy,boolean asc) {
		return  getPageAllByBean(tLoanBoss ,pageIndex ,pageSize ,orderBy ,asc ,true);
	}
	
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public Pagination<TLoanBoss> getPageAllByBean(TLoanBoss tLoanBoss, int pageIndex, int pageSize,boolean orderFlag) {
		return  getPageAllByBean(tLoanBoss ,pageIndex ,pageSize ,"" ,false ,false);
	}
	
	private Pagination<TLoanBoss> getPageAllByBean(TLoanBoss tLoanBoss, int pageIndex, int pageSize,String orderBy,boolean asc,boolean order) {
		String sql = "select TLoanBoss.loan_boss_id as loanBossId ,TLoanBoss.loan_pid as loanPid,TLoanBoss.company_years as companyYears,TLoanBoss.company_square as companySquare,TLoanBoss.company_openMoney as companyOpenmoney from "+TABLE +" as TLoanBoss" +" where 1=1 ";
		String countSql = "select count(*) from "+TABLE +" as TLoanBoss" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 

		if(ParameterCheck.hasValue(tLoanBoss.getLoanBossId())){
			withParameter = true;   
			sb.append(" and TLoanBoss.loan_boss_id=? ");
			params.add(tLoanBoss.getLoanBossId());
		}
        
		if(ParameterCheck.hasValue(tLoanBoss.getLoanPid())){
		    withParameter = true;    
			sb.append(" and TLoanBoss.loan_pid=? ");
			params.add(tLoanBoss.getLoanPid());
		}
        
		if(ParameterCheck.hasValue(tLoanBoss.getCompanyYears())){
		    withParameter = true;    
			sb.append(" and TLoanBoss.company_years=? ");
			params.add(tLoanBoss.getCompanyYears());
		}
        
		if(ParameterCheck.hasValue(tLoanBoss.getCompanySquare())){
		    withParameter = true;    
			sb.append(" and TLoanBoss.company_square=? ");
			params.add(tLoanBoss.getCompanySquare());
		}
        
		if(ParameterCheck.hasValue(tLoanBoss.getCompanyOpenmoney())){
		    withParameter = true;    
			sb.append(" and TLoanBoss.company_openMoney=? ");
			params.add(tLoanBoss.getCompanyOpenmoney());
		}

		Pagination<TLoanBoss> page = new Pagination<TLoanBoss>(pageIndex,pageSize);
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sb.append(" order by TLoanBoss." + orderSql);
		}
		if(log.isDebugEnabled()){
			log.debug("getPageAllTLoanBossByBean : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
			log.debug("pageIndex : " + pageIndex + "   pageSize:  " + pageSize);
		}
		if(withParameter){
			this.paginationQuery(sql + sb.toString(),countSql + sb.toString(), params.toArray(), page,ParameterizedBeanPropertyRowMapper.newInstance(TLoanBoss.class));
		}else{
		    this.paginationQuery(sql,countSql ,page,ParameterizedBeanPropertyRowMapper.newInstance(TLoanBoss.class));
		}
		return page;
	}
	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public List<TLoanBoss> getAll(){
		return getAll("" ,false ,false);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public List<TLoanBoss> getAll(String orderBy){
		return getAll(orderBy ,true ,true);
	}
	
	/**
	 * get the datat by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public List<TLoanBoss> getAll(String orderBy,boolean asc){
		return getAll(orderBy ,asc ,true);
	}
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public List<TLoanBoss> getAll(boolean orderFlag){
		return getAll("" ,false ,false);
	}
	
	private List<TLoanBoss> getAll(String orderBy,boolean asc,boolean order){
		String sql = "select TLoanBoss.loan_boss_id as loanBossId ,TLoanBoss.loan_pid as loanPid,TLoanBoss.company_years as companyYears,TLoanBoss.company_square as companySquare,TLoanBoss.company_openMoney as companyOpenmoney from " + TABLE +" as TLoanBoss" ;	
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sql += (" order by TLoanBoss." + orderSql);
		}
		return this.getJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(TLoanBoss.class));	
	}
	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public Pagination<TLoanBoss> getPageAll(int pageIndex, int pageSize) {
		return getPageAll(pageIndex ,pageSize ,"" ,false ,false);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public Pagination<TLoanBoss> getPageAll(int pageIndex, int pageSize,String orderBy) {
		return getPageAll(pageIndex ,pageSize ,orderBy ,true ,true);
	}
	
	/**
	 * get the datat by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public Pagination<TLoanBoss> getPageAll(int pageIndex, int pageSize,String orderBy,boolean asc) {
		return getPageAll(pageIndex ,pageSize ,orderBy ,asc ,true);
	}
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public Pagination<TLoanBoss> getPageAll(int pageIndex, int pageSize,boolean orderFlag) {
		return getPageAll(pageIndex ,pageSize ,"" ,false ,false);
	}
	
	
	
	private Pagination<TLoanBoss> getPageAll(int pageIndex, int pageSize,String orderBy,boolean asc,boolean order) {
		String sql ="select TLoanBoss.loan_boss_id as loanBossId ,TLoanBoss.loan_pid as loanPid,TLoanBoss.company_years as companyYears,TLoanBoss.company_square as companySquare,TLoanBoss.company_openMoney as companyOpenmoney from " + TABLE +" as TLoanBoss" ;
		String countSql = "select count(*) from " + TABLE;
		
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sql += (" order by TLoanBoss." + orderSql);
		}
		Pagination<TLoanBoss> page = new Pagination<TLoanBoss>(pageIndex,pageSize);
		this.paginationQuery(sql,countSql, page,ParameterizedBeanPropertyRowMapper.newInstance(TLoanBoss.class));
		return page;
	}
	
	

	protected class TLoanBossRowMapper implements RowMapper<TLoanBoss> {
		public TLoanBoss mapRow(ResultSet rs, int rowNum) throws SQLException {
			TLoanBoss tLoanBoss = new TLoanBoss();
        	tLoanBoss.setLoanBossId(rs.getInt("loanBossId"));
			tLoanBoss.setLoanPid(rs.getInt("loanPid"));
			tLoanBoss.setCompanyYears(rs.getByte("companyYears"));
			tLoanBoss.setCompanySquare(rs.getBigDecimal("companySquare"));
			tLoanBoss.setCompanyOpenmoney(rs.getBigDecimal("companyOpenmoney"));
			return tLoanBoss;
		}
	}
}