package com.kdkj.p2p.dao.loan;

import com.kdkj.p2p.utils.ParameterCheck;
import com.kdkj.p2p.entities.loan.TLoanVechicle;
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
public class TLoanVechicleDao extends CoreJdbcDaoSupport {

    private static Logger log = LoggerFactory.getLogger(TLoanVechicleDao.class);  

    private static String TABLE = "t_loan_vechicle";
	
	@Deprecated
	public Integer insert(TLoanVechicle tLoanVechicle) throws Exception {
		String sql = "insert into "+TABLE +"(loan_pid,vechicle_number,vechicle_year,engine_number,vechicle_miles,vechicle_modelType,apply_type)  values(?,?,?,?,?,?,?)";
		Object args[] = new Object[] { tLoanVechicle.getLoanPid(),tLoanVechicle.getVechicleNumber(),tLoanVechicle.getVechicleYear(),tLoanVechicle.getEngineNumber(),tLoanVechicle.getVechicleMiles(),tLoanVechicle.getVechicleModeltype(),tLoanVechicle.getApplyType() };
		if(log.isDebugEnabled()){
			log.debug("insertTLoanVechicle : SQL IS : " + sql + " : PARAM IS : " + args);
		}
		this.getJdbcTemplate().update(sql, args);
		tLoanVechicle.setLoanVechicleId(this.getJdbcTemplate().queryForInt("select last_insert_id()"));
        return tLoanVechicle.getLoanVechicleId();
	}

	
	
	public Integer insertSelective(TLoanVechicle tLoanVechicle) throws Exception {
		StringBuffer columns = new StringBuffer();
		StringBuffer questions = new StringBuffer(30);
		List<Object> params = new ArrayList<Object>();


		if(ParameterCheck.hasValue(tLoanVechicle.getLoanPid())){
			params.add(tLoanVechicle.getLoanPid());
			columns.append(",loan_pid");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanVechicle.getVechicleNumber())){
			params.add(tLoanVechicle.getVechicleNumber());
			columns.append(",vechicle_number");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanVechicle.getVechicleYear())){
			params.add(tLoanVechicle.getVechicleYear());
			columns.append(",vechicle_year");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanVechicle.getEngineNumber())){
			params.add(tLoanVechicle.getEngineNumber());
			columns.append(",engine_number");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanVechicle.getVechicleMiles())){
			params.add(tLoanVechicle.getVechicleMiles());
			columns.append(",vechicle_miles");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanVechicle.getVechicleModeltype())){
			params.add(tLoanVechicle.getVechicleModeltype());
			columns.append(",vechicle_modelType");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanVechicle.getApplyType())){
			params.add(tLoanVechicle.getApplyType());
			columns.append(",apply_type");
			questions.append(",?");
		}
		String sql = "insert into " + TABLE + "(" + columns.toString().substring(1) + ") values(" + questions.toString().substring(1) +")";
		if(log.isDebugEnabled()){
			log.debug("insertTLoanVechicleSelective : SQL IS : " + sql + " : PARAM IS : " + params.toArray());
		}
		this.getJdbcTemplate().update(sql, params.toArray());
		
		tLoanVechicle.setLoanVechicleId(this.getJdbcTemplate().queryForInt("select last_insert_id()"));
		return tLoanVechicle.getLoanVechicleId();
	}
	
	
	
	public void deleteByLoanVechicleId(Integer loanVechicleId) throws Exception {
		String sql = "delete from " +TABLE +" where  loan_vechicle_id=?";
		Object args[] = new Object[] {loanVechicleId};

		if(log.isDebugEnabled()){
			log.debug("deleteTLoanVechicleByLoanVechicleId : SQL IS : " + sql + " : PARAM IS : " + args);
		}
		this.getJdbcTemplate().update(sql, args);
	}
	
	
    
	public void deleteByBean(TLoanVechicle tLoanVechicle) throws Exception{
		List<Object> params = new ArrayList<Object>();
  		StringBuffer columns = new StringBuffer();
		if(ParameterCheck.hasValue(tLoanVechicle.getLoanPid())){
			params.add(tLoanVechicle.getLoanPid());
			columns.append("and loan_pid=? ");
		}
		if(ParameterCheck.hasValue(tLoanVechicle.getVechicleNumber())){
			params.add(tLoanVechicle.getVechicleNumber());
			columns.append("and vechicle_number=? ");
		}
		if(ParameterCheck.hasValue(tLoanVechicle.getVechicleYear())){
			params.add(tLoanVechicle.getVechicleYear());
			columns.append("and vechicle_year=? ");
		}
		if(ParameterCheck.hasValue(tLoanVechicle.getEngineNumber())){
			params.add(tLoanVechicle.getEngineNumber());
			columns.append("and engine_number=? ");
		}
		if(ParameterCheck.hasValue(tLoanVechicle.getVechicleMiles())){
			params.add(tLoanVechicle.getVechicleMiles());
			columns.append("and vechicle_miles=? ");
		}
		if(ParameterCheck.hasValue(tLoanVechicle.getVechicleModeltype())){
			params.add(tLoanVechicle.getVechicleModeltype());
			columns.append("and vechicle_modelType=? ");
		}
		if(ParameterCheck.hasValue(tLoanVechicle.getApplyType())){
			params.add(tLoanVechicle.getApplyType());
			columns.append("and apply_type=? ");
		}

		String sql = "delete from " +TABLE + " where " +columns.toString().substring(4);
		if(log.isDebugEnabled()){
			log.debug("deleteTLoanVechicleByBean : SQL IS : " + sql + " : PARAM IS : " + params.toArray());
		}
	    this.getJdbcTemplate().update(sql,params.toArray());
	}
	
	
	@Deprecated
	public void update(TLoanVechicle tLoanVechicle) throws Exception {
		String sql = "update " +TABLE +" set loan_pid=?,vechicle_number=?,vechicle_year=?,engine_number=?,vechicle_miles=?,vechicle_modelType=?,apply_type=? where  loan_vechicle_id=?";
		Object args[] = new Object[] {tLoanVechicle.getLoanPid(),tLoanVechicle.getVechicleNumber(),tLoanVechicle.getVechicleYear(),tLoanVechicle.getEngineNumber(),tLoanVechicle.getVechicleMiles(),tLoanVechicle.getVechicleModeltype(),tLoanVechicle.getApplyType(),tLoanVechicle.getLoanVechicleId()};
		if(log.isDebugEnabled()){
			log.debug("updateTLoanVechicle : SQL IS : " + sql + " : PARAM IS : " + args);
		}
		this.getJdbcTemplate().update(sql, args);
	}
	
	
	
	public void updateSelective(TLoanVechicle tLoanVechicle) throws Exception {
		List<Object> params = new ArrayList<Object>();
        StringBuffer columns = new StringBuffer();
        String keys = "";
		if(ParameterCheck.hasValue(tLoanVechicle.getLoanPid())){
			params.add(tLoanVechicle.getLoanPid());
			columns.append(",loan_pid=?");
		}
		if(ParameterCheck.hasValue(tLoanVechicle.getVechicleNumber())){
			params.add(tLoanVechicle.getVechicleNumber());
			columns.append(",vechicle_number=?");
		}
		if(ParameterCheck.hasValue(tLoanVechicle.getVechicleYear())){
			params.add(tLoanVechicle.getVechicleYear());
			columns.append(",vechicle_year=?");
		}
		if(ParameterCheck.hasValue(tLoanVechicle.getEngineNumber())){
			params.add(tLoanVechicle.getEngineNumber());
			columns.append(",engine_number=?");
		}
		if(ParameterCheck.hasValue(tLoanVechicle.getVechicleMiles())){
			params.add(tLoanVechicle.getVechicleMiles());
			columns.append(",vechicle_miles=?");
		}
		if(ParameterCheck.hasValue(tLoanVechicle.getVechicleModeltype())){
			params.add(tLoanVechicle.getVechicleModeltype());
			columns.append(",vechicle_modelType=?");
		}
		if(ParameterCheck.hasValue(tLoanVechicle.getApplyType())){
			params.add(tLoanVechicle.getApplyType());
			columns.append(",apply_type=?");
		}

		
		if(ParameterCheck.hasValue(tLoanVechicle.getLoanVechicleId())){
			params.add(tLoanVechicle.getLoanVechicleId());
			keys += "and loan_vechicle_id=? ";
		}
		String sql = "update " + TABLE + " set " +columns.toString().substring(1)+" where "+keys.substring(4);
		if(log.isDebugEnabled()){
			log.debug("updateTLoanVechicleSelective : SQL IS : " + sql + " : PARAM IS : " + params.toArray());
		}
		this.getJdbcTemplate().update(sql, params.toArray());
	}
	
	
		
	
	public TLoanVechicle getByLoanVechicleId(Integer loanVechicleId) {
		String sql = "select TLoanVechicle.loan_vechicle_id as loanVechicleId ,TLoanVechicle.loan_pid as loanPid,TLoanVechicle.vechicle_number as vechicleNumber,TLoanVechicle.vechicle_year as vechicleYear,TLoanVechicle.engine_number as engineNumber,TLoanVechicle.vechicle_miles as vechicleMiles,TLoanVechicle.vechicle_modelType as vechicleModeltype,TLoanVechicle.apply_type as applyType from "+TABLE+" as TLoanVechicle where  TLoanVechicle.loan_vechicle_id=?";
		if(log.isDebugEnabled()){
			log.debug("getTLoanVechicleByLoanVechicleId : SQL IS : " + sql + " : PARAM IS : " + loanVechicleId);
		}
		List<TLoanVechicle> tLoanVechicleList = this.getJdbcTemplate().query(sql,new Object[]{loanVechicleId}, ParameterizedBeanPropertyRowMapper.newInstance(TLoanVechicle.class));
		return tLoanVechicleList.size() > 0 ? tLoanVechicleList.get(0) : null;
	}
	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public Collection<TLoanVechicle> getAll(Map<String, Object> parameter) {
		return getAll(parameter ,"" ,false ,false);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public Collection<TLoanVechicle> getAll(Map<String, Object> parameter ,String orderBy) {
		return getAll(parameter ,orderBy ,true ,true);
	}
	
	/**
	 * get the data by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public Collection<TLoanVechicle> getAll(Map<String, Object> parameter ,String orderBy ,boolean asc) {
		return getAll(parameter ,orderBy ,asc ,true);

	}
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public Collection<TLoanVechicle> getAll(Map<String, Object> parameter ,boolean orderFlag) {
		return getAll(parameter ,"" ,false ,false);
	}
	
	private Collection<TLoanVechicle> getAll(Map<String, Object> parameter,String orderBy,boolean asc,boolean order) {
		String sql = "select TLoanVechicle.loan_vechicle_id as loanVechicleId ,TLoanVechicle.loan_pid as loanPid,TLoanVechicle.vechicle_number as vechicleNumber,TLoanVechicle.vechicle_year as vechicleYear,TLoanVechicle.engine_number as engineNumber,TLoanVechicle.vechicle_miles as vechicleMiles,TLoanVechicle.vechicle_modelType as vechicleModeltype,TLoanVechicle.apply_type as applyType from "+TABLE +" as TLoanVechicle" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
		if(parameter != null){
            if(ParameterCheck.hasValue(parameter.get("loanVechicleId"))){
			    withParameter = true;    
				sb.append(" and TLoanVechicle.loan_vechicle_id=? ");
				params.add(parameter.get("loanVechicleId"));
			}

            if(ParameterCheck.hasValue(parameter.get("loanPid"))){
			    withParameter = true;    
				sb.append(" and TLoanVechicle.loan_pid=? ");
				params.add(parameter.get("loanPid"));
			}

            if(ParameterCheck.hasValue(parameter.get("vechicleNumber"))){
			    withParameter = true;    
				sb.append(" and TLoanVechicle.vechicle_number=? ");
				params.add(parameter.get("vechicleNumber"));
			}

            if(ParameterCheck.hasValue(parameter.get("vechicleYear"))){
			    withParameter = true;    
				sb.append(" and TLoanVechicle.vechicle_year=? ");
				params.add(parameter.get("vechicleYear"));
			}

            if(ParameterCheck.hasValue(parameter.get("engineNumber"))){
			    withParameter = true;    
				sb.append(" and TLoanVechicle.engine_number=? ");
				params.add(parameter.get("engineNumber"));
			}

            if(ParameterCheck.hasValue(parameter.get("vechicleMiles"))){
			    withParameter = true;    
				sb.append(" and TLoanVechicle.vechicle_miles=? ");
				params.add(parameter.get("vechicleMiles"));
			}

            if(ParameterCheck.hasValue(parameter.get("vechicleModeltype"))){
			    withParameter = true;    
				sb.append(" and TLoanVechicle.vechicle_modelType=? ");
				params.add(parameter.get("vechicleModeltype"));
			}

            if(ParameterCheck.hasValue(parameter.get("applyType"))){
			    withParameter = true;    
				sb.append(" and TLoanVechicle.apply_type=? ");
				params.add(parameter.get("applyType"));
			}
		}
		
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sb.append(" order by TLoanVechicle." + orderSql);
		}
		
		if(log.isDebugEnabled()){
			log.debug("getAll : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
		}
		if(withParameter){
			return this.getJdbcTemplate().query(sql+ sb.toString(),params.toArray(), ParameterizedBeanPropertyRowMapper.newInstance(TLoanVechicle.class));
		}else{
			return this.getJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(TLoanVechicle.class));
		}
		
	}

	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public Collection<TLoanVechicle> getAllByBean(TLoanVechicle tLoanVechicle) {
		return getAllByBean(tLoanVechicle ,"" ,false ,false);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public Collection<TLoanVechicle> getAllByBean(TLoanVechicle tLoanVechicle ,String orderBy) {
		return getAllByBean(tLoanVechicle ,orderBy ,true ,true);
	}
	
	/**
	 * get the datat by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public Collection<TLoanVechicle> getAllByBean(TLoanVechicle tLoanVechicle ,String orderBy ,boolean asc) {
		return getAllByBean(tLoanVechicle ,orderBy ,asc ,true);
	}
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public Collection<TLoanVechicle> getAllByBean(TLoanVechicle tLoanVechicle ,boolean orderFlag) {
		return getAllByBean(tLoanVechicle ,"" ,false ,false);
	}
	

	
	private Collection<TLoanVechicle> getAllByBean(TLoanVechicle tLoanVechicle,String orderBy,boolean asc,boolean order) {
		String sql = "select TLoanVechicle.loan_vechicle_id as loanVechicleId ,TLoanVechicle.loan_pid as loanPid,TLoanVechicle.vechicle_number as vechicleNumber,TLoanVechicle.vechicle_year as vechicleYear,TLoanVechicle.engine_number as engineNumber,TLoanVechicle.vechicle_miles as vechicleMiles,TLoanVechicle.vechicle_modelType as vechicleModeltype,TLoanVechicle.apply_type as applyType from "+TABLE +" as TLoanVechicle" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
            
		if(ParameterCheck.hasValue(tLoanVechicle.getLoanVechicleId())){
		    withParameter = true;    
			sb.append(" and TLoanVechicle.loan_vechicle_id=? ");
			params.add(tLoanVechicle.getLoanVechicleId());
		}

		if(ParameterCheck.hasValue(tLoanVechicle.getLoanPid())){
		    withParameter = true;    
			sb.append(" and TLoanVechicle.loan_pid=? ");
			params.add(tLoanVechicle.getLoanPid());
		}

		if(ParameterCheck.hasValue(tLoanVechicle.getVechicleNumber())){
		    withParameter = true;    
			sb.append(" and TLoanVechicle.vechicle_number=? ");
			params.add(tLoanVechicle.getVechicleNumber());
		}

		if(ParameterCheck.hasValue(tLoanVechicle.getVechicleYear())){
		    withParameter = true;    
			sb.append(" and TLoanVechicle.vechicle_year=? ");
			params.add(tLoanVechicle.getVechicleYear());
		}

		if(ParameterCheck.hasValue(tLoanVechicle.getEngineNumber())){
		    withParameter = true;    
			sb.append(" and TLoanVechicle.engine_number=? ");
			params.add(tLoanVechicle.getEngineNumber());
		}

		if(ParameterCheck.hasValue(tLoanVechicle.getVechicleMiles())){
		    withParameter = true;    
			sb.append(" and TLoanVechicle.vechicle_miles=? ");
			params.add(tLoanVechicle.getVechicleMiles());
		}

		if(ParameterCheck.hasValue(tLoanVechicle.getVechicleModeltype())){
		    withParameter = true;    
			sb.append(" and TLoanVechicle.vechicle_modelType=? ");
			params.add(tLoanVechicle.getVechicleModeltype());
		}

		if(ParameterCheck.hasValue(tLoanVechicle.getApplyType())){
		    withParameter = true;    
			sb.append(" and TLoanVechicle.apply_type=? ");
			params.add(tLoanVechicle.getApplyType());
		}
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sb.append(" order by TLoanVechicle." + orderSql);
		}
		if(log.isDebugEnabled()){
			log.debug("getAllByBean : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
		}
		if(withParameter){
			return this.getJdbcTemplate().query(sql+ sb.toString(),params.toArray(), ParameterizedBeanPropertyRowMapper.newInstance(TLoanVechicle.class));
		}else{
			return this.getJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(TLoanVechicle.class));
		}		
	}
	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public Pagination<TLoanVechicle> getPageAllByCondition(Map<String, Object> parameter, int pageIndex, int pageSize) {
		return getPageAllByCondition(parameter ,pageIndex ,pageSize ,"" ,false ,false);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public Pagination<TLoanVechicle> getPageAllByCondition(Map<String, Object> parameter, int pageIndex, int pageSize, String orderBy) {
		return getPageAllByCondition(parameter ,pageIndex ,pageSize ,orderBy ,true ,true);
	}
	
	/**
	 * get the datat by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public Pagination<TLoanVechicle> getPageAllByCondition(Map<String, Object> parameter, int pageIndex, int pageSize, String orderBy, boolean asc) {
		return getPageAllByCondition(parameter ,pageIndex ,pageSize ,orderBy ,asc ,true);
	}
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public Pagination<TLoanVechicle> getPageAllByCondition(Map<String, Object> parameter, int pageIndex, int pageSize, boolean orderFlag) {
		return getPageAllByCondition(parameter ,pageIndex ,pageSize ,"" ,false ,false);
	}
	
	private Pagination<TLoanVechicle> getPageAllByCondition(Map<String, Object> parameter, int pageIndex, int pageSize,String orderBy,boolean asc,boolean order) {
		String sql = "select TLoanVechicle.loan_vechicle_id as loanVechicleId ,TLoanVechicle.loan_pid as loanPid,TLoanVechicle.vechicle_number as vechicleNumber,TLoanVechicle.vechicle_year as vechicleYear,TLoanVechicle.engine_number as engineNumber,TLoanVechicle.vechicle_miles as vechicleMiles,TLoanVechicle.vechicle_modelType as vechicleModeltype,TLoanVechicle.apply_type as applyType from "+TABLE +" as TLoanVechicle" +" where 1=1 ";
		String countSql = "select count(*) from "+TABLE +" as TLoanVechicle" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
		if(parameter != null){

            if(ParameterCheck.hasValue(parameter.get("loanVechicleId"))){
				withParameter = true;   
				sb.append(" and TLoanVechicle.loan_vechicle_id=? ");
				params.add(parameter.get("loanVechicleId"));
			}

            if(ParameterCheck.hasValue(parameter.get("loanPid"))){
			    withParameter = true;    
				sb.append(" and TLoanVechicle.loan_pid=? ");
				params.add(parameter.get("loanPid"));
			}

            if(ParameterCheck.hasValue(parameter.get("vechicleNumber"))){
			    withParameter = true;    
				sb.append(" and TLoanVechicle.vechicle_number=? ");
				params.add(parameter.get("vechicleNumber"));
			}

            if(ParameterCheck.hasValue(parameter.get("vechicleYear"))){
			    withParameter = true;    
				sb.append(" and TLoanVechicle.vechicle_year=? ");
				params.add(parameter.get("vechicleYear"));
			}

            if(ParameterCheck.hasValue(parameter.get("engineNumber"))){
			    withParameter = true;    
				sb.append(" and TLoanVechicle.engine_number=? ");
				params.add(parameter.get("engineNumber"));
			}

            if(ParameterCheck.hasValue(parameter.get("vechicleMiles"))){
			    withParameter = true;    
				sb.append(" and TLoanVechicle.vechicle_miles=? ");
				params.add(parameter.get("vechicleMiles"));
			}

            if(ParameterCheck.hasValue(parameter.get("vechicleModeltype"))){
			    withParameter = true;    
				sb.append(" and TLoanVechicle.vechicle_modelType=? ");
				params.add(parameter.get("vechicleModeltype"));
			}

            if(ParameterCheck.hasValue(parameter.get("applyType"))){
			    withParameter = true;    
				sb.append(" and TLoanVechicle.apply_type=? ");
				params.add(parameter.get("applyType"));
			}
		}
		Pagination<TLoanVechicle> page = new Pagination<TLoanVechicle>(pageIndex,pageSize);
		
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sb.append(" order by TLoanVechicle." + orderSql);
		}
		if(log.isDebugEnabled()){
			log.debug("getPageAllTLoanVechicleByCondition : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
			log.debug("pageIndex : " + pageIndex + "   pageSize:  " + pageSize);
		}
		if(withParameter){
			this.paginationQuery(sql + sb.toString(),countSql + sb.toString(), params.toArray(), page,ParameterizedBeanPropertyRowMapper.newInstance(TLoanVechicle.class));
		}else{
		    this.paginationQuery(sql,countSql ,page,ParameterizedBeanPropertyRowMapper.newInstance(TLoanVechicle.class));
		}
		return page;
	}
	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public Pagination<TLoanVechicle> getPageAllByBean(TLoanVechicle tLoanVechicle, int pageIndex, int pageSize) {
		return getPageAllByBean(tLoanVechicle ,pageIndex ,pageSize ,"" ,false ,false);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public Pagination<TLoanVechicle> getPageAllByBean(TLoanVechicle tLoanVechicle, int pageIndex, int pageSize,String orderBy) {
		return  getPageAllByBean(tLoanVechicle ,pageIndex ,pageSize ,orderBy ,true ,true);
	}
	
	/**
	 * get the datat by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public Pagination<TLoanVechicle> getPageAllByBean(TLoanVechicle tLoanVechicle, int pageIndex, int pageSize,String orderBy,boolean asc) {
		return  getPageAllByBean(tLoanVechicle ,pageIndex ,pageSize ,orderBy ,asc ,true);
	}
	
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public Pagination<TLoanVechicle> getPageAllByBean(TLoanVechicle tLoanVechicle, int pageIndex, int pageSize,boolean orderFlag) {
		return  getPageAllByBean(tLoanVechicle ,pageIndex ,pageSize ,"" ,false ,false);
	}
	
	private Pagination<TLoanVechicle> getPageAllByBean(TLoanVechicle tLoanVechicle, int pageIndex, int pageSize,String orderBy,boolean asc,boolean order) {
		String sql = "select TLoanVechicle.loan_vechicle_id as loanVechicleId ,TLoanVechicle.loan_pid as loanPid,TLoanVechicle.vechicle_number as vechicleNumber,TLoanVechicle.vechicle_year as vechicleYear,TLoanVechicle.engine_number as engineNumber,TLoanVechicle.vechicle_miles as vechicleMiles,TLoanVechicle.vechicle_modelType as vechicleModeltype,TLoanVechicle.apply_type as applyType from "+TABLE +" as TLoanVechicle" +" where 1=1 ";
		String countSql = "select count(*) from "+TABLE +" as TLoanVechicle" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 

		if(ParameterCheck.hasValue(tLoanVechicle.getLoanVechicleId())){
			withParameter = true;   
			sb.append(" and TLoanVechicle.loan_vechicle_id=? ");
			params.add(tLoanVechicle.getLoanVechicleId());
		}
        
		if(ParameterCheck.hasValue(tLoanVechicle.getLoanPid())){
		    withParameter = true;    
			sb.append(" and TLoanVechicle.loan_pid=? ");
			params.add(tLoanVechicle.getLoanPid());
		}
        
		if(ParameterCheck.hasValue(tLoanVechicle.getVechicleNumber())){
		    withParameter = true;    
			sb.append(" and TLoanVechicle.vechicle_number=? ");
			params.add(tLoanVechicle.getVechicleNumber());
		}
        
		if(ParameterCheck.hasValue(tLoanVechicle.getVechicleYear())){
		    withParameter = true;    
			sb.append(" and TLoanVechicle.vechicle_year=? ");
			params.add(tLoanVechicle.getVechicleYear());
		}
        
		if(ParameterCheck.hasValue(tLoanVechicle.getEngineNumber())){
		    withParameter = true;    
			sb.append(" and TLoanVechicle.engine_number=? ");
			params.add(tLoanVechicle.getEngineNumber());
		}
        
		if(ParameterCheck.hasValue(tLoanVechicle.getVechicleMiles())){
		    withParameter = true;    
			sb.append(" and TLoanVechicle.vechicle_miles=? ");
			params.add(tLoanVechicle.getVechicleMiles());
		}
        
		if(ParameterCheck.hasValue(tLoanVechicle.getVechicleModeltype())){
		    withParameter = true;    
			sb.append(" and TLoanVechicle.vechicle_modelType=? ");
			params.add(tLoanVechicle.getVechicleModeltype());
		}
        
		if(ParameterCheck.hasValue(tLoanVechicle.getApplyType())){
		    withParameter = true;    
			sb.append(" and TLoanVechicle.apply_type=? ");
			params.add(tLoanVechicle.getApplyType());
		}

		Pagination<TLoanVechicle> page = new Pagination<TLoanVechicle>(pageIndex,pageSize);
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sb.append(" order by TLoanVechicle." + orderSql);
		}
		if(log.isDebugEnabled()){
			log.debug("getPageAllTLoanVechicleByBean : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
			log.debug("pageIndex : " + pageIndex + "   pageSize:  " + pageSize);
		}
		if(withParameter){
			this.paginationQuery(sql + sb.toString(),countSql + sb.toString(), params.toArray(), page,ParameterizedBeanPropertyRowMapper.newInstance(TLoanVechicle.class));
		}else{
		    this.paginationQuery(sql,countSql ,page,ParameterizedBeanPropertyRowMapper.newInstance(TLoanVechicle.class));
		}
		return page;
	}
	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public List<TLoanVechicle> getAll(){
		return getAll("" ,false ,false);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public List<TLoanVechicle> getAll(String orderBy){
		return getAll(orderBy ,true ,true);
	}
	
	/**
	 * get the datat by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public List<TLoanVechicle> getAll(String orderBy,boolean asc){
		return getAll(orderBy ,asc ,true);
	}
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public List<TLoanVechicle> getAll(boolean orderFlag){
		return getAll("" ,false ,false);
	}
	
	private List<TLoanVechicle> getAll(String orderBy,boolean asc,boolean order){
		String sql = "select TLoanVechicle.loan_vechicle_id as loanVechicleId ,TLoanVechicle.loan_pid as loanPid,TLoanVechicle.vechicle_number as vechicleNumber,TLoanVechicle.vechicle_year as vechicleYear,TLoanVechicle.engine_number as engineNumber,TLoanVechicle.vechicle_miles as vechicleMiles,TLoanVechicle.vechicle_modelType as vechicleModeltype,TLoanVechicle.apply_type as applyType from " + TABLE +" as TLoanVechicle" ;	
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sql += (" order by TLoanVechicle." + orderSql);
		}
		return this.getJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(TLoanVechicle.class));	
	}
	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public Pagination<TLoanVechicle> getPageAll(int pageIndex, int pageSize) {
		return getPageAll(pageIndex ,pageSize ,"" ,false ,false);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public Pagination<TLoanVechicle> getPageAll(int pageIndex, int pageSize,String orderBy) {
		return getPageAll(pageIndex ,pageSize ,orderBy ,true ,true);
	}
	
	/**
	 * get the datat by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public Pagination<TLoanVechicle> getPageAll(int pageIndex, int pageSize,String orderBy,boolean asc) {
		return getPageAll(pageIndex ,pageSize ,orderBy ,asc ,true);
	}
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public Pagination<TLoanVechicle> getPageAll(int pageIndex, int pageSize,boolean orderFlag) {
		return getPageAll(pageIndex ,pageSize ,"" ,false ,false);
	}
	
	
	
	private Pagination<TLoanVechicle> getPageAll(int pageIndex, int pageSize,String orderBy,boolean asc,boolean order) {
		String sql ="select TLoanVechicle.loan_vechicle_id as loanVechicleId ,TLoanVechicle.loan_pid as loanPid,TLoanVechicle.vechicle_number as vechicleNumber,TLoanVechicle.vechicle_year as vechicleYear,TLoanVechicle.engine_number as engineNumber,TLoanVechicle.vechicle_miles as vechicleMiles,TLoanVechicle.vechicle_modelType as vechicleModeltype,TLoanVechicle.apply_type as applyType from " + TABLE +" as TLoanVechicle" ;
		String countSql = "select count(*) from " + TABLE;
		
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sql += (" order by TLoanVechicle." + orderSql);
		}
		Pagination<TLoanVechicle> page = new Pagination<TLoanVechicle>(pageIndex,pageSize);
		this.paginationQuery(sql,countSql, page,ParameterizedBeanPropertyRowMapper.newInstance(TLoanVechicle.class));
		return page;
	}
	
	

	protected class TLoanVechicleRowMapper implements RowMapper<TLoanVechicle> {
		public TLoanVechicle mapRow(ResultSet rs, int rowNum) throws SQLException {
			TLoanVechicle tLoanVechicle = new TLoanVechicle();
        	tLoanVechicle.setLoanVechicleId(rs.getInt("loanVechicleId"));
			tLoanVechicle.setLoanPid(rs.getInt("loanPid"));
			tLoanVechicle.setVechicleNumber(rs.getString("vechicleNumber"));
			tLoanVechicle.setVechicleYear(rs.getByte("vechicleYear"));
			tLoanVechicle.setEngineNumber(rs.getString("engineNumber"));
			tLoanVechicle.setVechicleMiles(rs.getShort("vechicleMiles"));
			tLoanVechicle.setVechicleModeltype(rs.getString("vechicleModeltype"));
			tLoanVechicle.setApplyType(rs.getString("applyType"));
			return tLoanVechicle;
		}
	}
}