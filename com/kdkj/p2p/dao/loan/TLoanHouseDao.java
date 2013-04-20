package com.kdkj.p2p.dao.loan;

import com.kdkj.p2p.utils.ParameterCheck;
import com.kdkj.p2p.entities.loan.TLoanHouse;
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
public class TLoanHouseDao extends CoreJdbcDaoSupport {

    private static Logger log = LoggerFactory.getLogger(TLoanHouseDao.class);  

    private static String TABLE = "t_loan_house";
	
	@Deprecated
	public Integer insert(TLoanHouse tLoanHouse) throws Exception {
		String sql = "insert into "+TABLE +"(loan_pid,apply_type,house_cardNo,house_owner,house_ownerGender,house_ownerCardNo,house_ownerAge,house_colloate,house_colloateGender,house_colloaterCardNo,house_colloateAge,house_address,house_square,house_value,house_lended,house_lendedMoney)  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object args[] = new Object[] { tLoanHouse.getLoanPid(),tLoanHouse.getApplyType(),tLoanHouse.getHouseCardno(),tLoanHouse.getHouseOwner(),tLoanHouse.getHouseOwnergender(),tLoanHouse.getHouseOwnercardno(),tLoanHouse.getHouseOwnerage(),tLoanHouse.getHouseColloate(),tLoanHouse.getHouseColloategender(),tLoanHouse.getHouseColloatercardno(),tLoanHouse.getHouseColloateage(),tLoanHouse.getHouseAddress(),tLoanHouse.getHouseSquare(),tLoanHouse.getHouseValue(),tLoanHouse.getHouseLended(),tLoanHouse.getHouseLendedmoney() };
		if(log.isDebugEnabled()){
			log.debug("insertTLoanHouse : SQL IS : " + sql + " : PARAM IS : " + args);
		}
		this.getJdbcTemplate().update(sql, args);
		tLoanHouse.setLoanHouseId(this.getJdbcTemplate().queryForInt("select last_insert_id()"));
        return tLoanHouse.getLoanHouseId();
	}

	
	
	public Integer insertSelective(TLoanHouse tLoanHouse) throws Exception {
		StringBuffer columns = new StringBuffer();
		StringBuffer questions = new StringBuffer(30);
		List<Object> params = new ArrayList<Object>();


		if(ParameterCheck.hasValue(tLoanHouse.getLoanPid())){
			params.add(tLoanHouse.getLoanPid());
			columns.append(",loan_pid");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getApplyType())){
			params.add(tLoanHouse.getApplyType());
			columns.append(",apply_type");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseCardno())){
			params.add(tLoanHouse.getHouseCardno());
			columns.append(",house_cardNo");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseOwner())){
			params.add(tLoanHouse.getHouseOwner());
			columns.append(",house_owner");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseOwnergender())){
			params.add(tLoanHouse.getHouseOwnergender());
			columns.append(",house_ownerGender");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseOwnercardno())){
			params.add(tLoanHouse.getHouseOwnercardno());
			columns.append(",house_ownerCardNo");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseOwnerage())){
			params.add(tLoanHouse.getHouseOwnerage());
			columns.append(",house_ownerAge");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseColloate())){
			params.add(tLoanHouse.getHouseColloate());
			columns.append(",house_colloate");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseColloategender())){
			params.add(tLoanHouse.getHouseColloategender());
			columns.append(",house_colloateGender");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseColloatercardno())){
			params.add(tLoanHouse.getHouseColloatercardno());
			columns.append(",house_colloaterCardNo");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseColloateage())){
			params.add(tLoanHouse.getHouseColloateage());
			columns.append(",house_colloateAge");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseAddress())){
			params.add(tLoanHouse.getHouseAddress());
			columns.append(",house_address");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseSquare())){
			params.add(tLoanHouse.getHouseSquare());
			columns.append(",house_square");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseValue())){
			params.add(tLoanHouse.getHouseValue());
			columns.append(",house_value");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseLended())){
			params.add(tLoanHouse.getHouseLended());
			columns.append(",house_lended");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseLendedmoney())){
			params.add(tLoanHouse.getHouseLendedmoney());
			columns.append(",house_lendedMoney");
			questions.append(",?");
		}
		String sql = "insert into " + TABLE + "(" + columns.toString().substring(1) + ") values(" + questions.toString().substring(1) +")";
		if(log.isDebugEnabled()){
			log.debug("insertTLoanHouseSelective : SQL IS : " + sql + " : PARAM IS : " + params.toArray());
		}
		this.getJdbcTemplate().update(sql, params.toArray());
		
		tLoanHouse.setLoanHouseId(this.getJdbcTemplate().queryForInt("select last_insert_id()"));
		return tLoanHouse.getLoanHouseId();
	}
	
	
	
	public void deleteByLoanHouseId(Integer loanHouseId) throws Exception {
		String sql = "delete from " +TABLE +" where  loan_house_id=?";
		Object args[] = new Object[] {loanHouseId};

		if(log.isDebugEnabled()){
			log.debug("deleteTLoanHouseByLoanHouseId : SQL IS : " + sql + " : PARAM IS : " + args);
		}
		this.getJdbcTemplate().update(sql, args);
	}
	
	
    
	public void deleteByBean(TLoanHouse tLoanHouse) throws Exception{
		List<Object> params = new ArrayList<Object>();
  		StringBuffer columns = new StringBuffer();
		if(ParameterCheck.hasValue(tLoanHouse.getLoanPid())){
			params.add(tLoanHouse.getLoanPid());
			columns.append("and loan_pid=? ");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getApplyType())){
			params.add(tLoanHouse.getApplyType());
			columns.append("and apply_type=? ");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseCardno())){
			params.add(tLoanHouse.getHouseCardno());
			columns.append("and house_cardNo=? ");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseOwner())){
			params.add(tLoanHouse.getHouseOwner());
			columns.append("and house_owner=? ");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseOwnergender())){
			params.add(tLoanHouse.getHouseOwnergender());
			columns.append("and house_ownerGender=? ");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseOwnercardno())){
			params.add(tLoanHouse.getHouseOwnercardno());
			columns.append("and house_ownerCardNo=? ");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseOwnerage())){
			params.add(tLoanHouse.getHouseOwnerage());
			columns.append("and house_ownerAge=? ");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseColloate())){
			params.add(tLoanHouse.getHouseColloate());
			columns.append("and house_colloate=? ");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseColloategender())){
			params.add(tLoanHouse.getHouseColloategender());
			columns.append("and house_colloateGender=? ");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseColloatercardno())){
			params.add(tLoanHouse.getHouseColloatercardno());
			columns.append("and house_colloaterCardNo=? ");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseColloateage())){
			params.add(tLoanHouse.getHouseColloateage());
			columns.append("and house_colloateAge=? ");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseAddress())){
			params.add(tLoanHouse.getHouseAddress());
			columns.append("and house_address=? ");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseSquare())){
			params.add(tLoanHouse.getHouseSquare());
			columns.append("and house_square=? ");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseValue())){
			params.add(tLoanHouse.getHouseValue());
			columns.append("and house_value=? ");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseLended())){
			params.add(tLoanHouse.getHouseLended());
			columns.append("and house_lended=? ");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseLendedmoney())){
			params.add(tLoanHouse.getHouseLendedmoney());
			columns.append("and house_lendedMoney=? ");
		}

		String sql = "delete from " +TABLE + " where " +columns.toString().substring(4);
		if(log.isDebugEnabled()){
			log.debug("deleteTLoanHouseByBean : SQL IS : " + sql + " : PARAM IS : " + params.toArray());
		}
	    this.getJdbcTemplate().update(sql,params.toArray());
	}
	
	
	@Deprecated
	public void update(TLoanHouse tLoanHouse) throws Exception {
		String sql = "update " +TABLE +" set loan_pid=?,apply_type=?,house_cardNo=?,house_owner=?,house_ownerGender=?,house_ownerCardNo=?,house_ownerAge=?,house_colloate=?,house_colloateGender=?,house_colloaterCardNo=?,house_colloateAge=?,house_address=?,house_square=?,house_value=?,house_lended=?,house_lendedMoney=? where  loan_house_id=?";
		Object args[] = new Object[] {tLoanHouse.getLoanPid(),tLoanHouse.getApplyType(),tLoanHouse.getHouseCardno(),tLoanHouse.getHouseOwner(),tLoanHouse.getHouseOwnergender(),tLoanHouse.getHouseOwnercardno(),tLoanHouse.getHouseOwnerage(),tLoanHouse.getHouseColloate(),tLoanHouse.getHouseColloategender(),tLoanHouse.getHouseColloatercardno(),tLoanHouse.getHouseColloateage(),tLoanHouse.getHouseAddress(),tLoanHouse.getHouseSquare(),tLoanHouse.getHouseValue(),tLoanHouse.getHouseLended(),tLoanHouse.getHouseLendedmoney(),tLoanHouse.getLoanHouseId()};
		if(log.isDebugEnabled()){
			log.debug("updateTLoanHouse : SQL IS : " + sql + " : PARAM IS : " + args);
		}
		this.getJdbcTemplate().update(sql, args);
	}
	
	
	
	public void updateSelective(TLoanHouse tLoanHouse) throws Exception {
		List<Object> params = new ArrayList<Object>();
        StringBuffer columns = new StringBuffer();
        String keys = "";
		if(ParameterCheck.hasValue(tLoanHouse.getLoanPid())){
			params.add(tLoanHouse.getLoanPid());
			columns.append(",loan_pid=?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getApplyType())){
			params.add(tLoanHouse.getApplyType());
			columns.append(",apply_type=?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseCardno())){
			params.add(tLoanHouse.getHouseCardno());
			columns.append(",house_cardNo=?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseOwner())){
			params.add(tLoanHouse.getHouseOwner());
			columns.append(",house_owner=?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseOwnergender())){
			params.add(tLoanHouse.getHouseOwnergender());
			columns.append(",house_ownerGender=?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseOwnercardno())){
			params.add(tLoanHouse.getHouseOwnercardno());
			columns.append(",house_ownerCardNo=?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseOwnerage())){
			params.add(tLoanHouse.getHouseOwnerage());
			columns.append(",house_ownerAge=?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseColloate())){
			params.add(tLoanHouse.getHouseColloate());
			columns.append(",house_colloate=?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseColloategender())){
			params.add(tLoanHouse.getHouseColloategender());
			columns.append(",house_colloateGender=?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseColloatercardno())){
			params.add(tLoanHouse.getHouseColloatercardno());
			columns.append(",house_colloaterCardNo=?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseColloateage())){
			params.add(tLoanHouse.getHouseColloateage());
			columns.append(",house_colloateAge=?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseAddress())){
			params.add(tLoanHouse.getHouseAddress());
			columns.append(",house_address=?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseSquare())){
			params.add(tLoanHouse.getHouseSquare());
			columns.append(",house_square=?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseValue())){
			params.add(tLoanHouse.getHouseValue());
			columns.append(",house_value=?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseLended())){
			params.add(tLoanHouse.getHouseLended());
			columns.append(",house_lended=?");
		}
		if(ParameterCheck.hasValue(tLoanHouse.getHouseLendedmoney())){
			params.add(tLoanHouse.getHouseLendedmoney());
			columns.append(",house_lendedMoney=?");
		}

		
		if(ParameterCheck.hasValue(tLoanHouse.getLoanHouseId())){
			params.add(tLoanHouse.getLoanHouseId());
			keys += "and loan_house_id=? ";
		}
		String sql = "update " + TABLE + " set " +columns.toString().substring(1)+" where "+keys.substring(4);
		if(log.isDebugEnabled()){
			log.debug("updateTLoanHouseSelective : SQL IS : " + sql + " : PARAM IS : " + params.toArray());
		}
		this.getJdbcTemplate().update(sql, params.toArray());
	}
	
	
		
	
	public TLoanHouse getByLoanHouseId(Integer loanHouseId) {
		String sql = "select TLoanHouse.loan_house_id as loanHouseId ,TLoanHouse.loan_pid as loanPid,TLoanHouse.apply_type as applyType,TLoanHouse.house_cardNo as houseCardno,TLoanHouse.house_owner as houseOwner,TLoanHouse.house_ownerGender as houseOwnergender,TLoanHouse.house_ownerCardNo as houseOwnercardno,TLoanHouse.house_ownerAge as houseOwnerage,TLoanHouse.house_colloate as houseColloate,TLoanHouse.house_colloateGender as houseColloategender,TLoanHouse.house_colloaterCardNo as houseColloatercardno,TLoanHouse.house_colloateAge as houseColloateage,TLoanHouse.house_address as houseAddress,TLoanHouse.house_square as houseSquare,TLoanHouse.house_value as houseValue,TLoanHouse.house_lended as houseLended,TLoanHouse.house_lendedMoney as houseLendedmoney from "+TABLE+" as TLoanHouse where  TLoanHouse.loan_house_id=?";
		if(log.isDebugEnabled()){
			log.debug("getTLoanHouseByLoanHouseId : SQL IS : " + sql + " : PARAM IS : " + loanHouseId);
		}
		List<TLoanHouse> tLoanHouseList = this.getJdbcTemplate().query(sql,new Object[]{loanHouseId}, ParameterizedBeanPropertyRowMapper.newInstance(TLoanHouse.class));
		return tLoanHouseList.size() > 0 ? tLoanHouseList.get(0) : null;
	}
	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public Collection<TLoanHouse> getAll(Map<String, Object> parameter) {
		return getAll(parameter ,"" ,false ,false);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public Collection<TLoanHouse> getAll(Map<String, Object> parameter ,String orderBy) {
		return getAll(parameter ,orderBy ,true ,true);
	}
	
	/**
	 * get the data by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public Collection<TLoanHouse> getAll(Map<String, Object> parameter ,String orderBy ,boolean asc) {
		return getAll(parameter ,orderBy ,asc ,true);

	}
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public Collection<TLoanHouse> getAll(Map<String, Object> parameter ,boolean orderFlag) {
		return getAll(parameter ,"" ,false ,false);
	}
	
	private Collection<TLoanHouse> getAll(Map<String, Object> parameter,String orderBy,boolean asc,boolean order) {
		String sql = "select TLoanHouse.loan_house_id as loanHouseId ,TLoanHouse.loan_pid as loanPid,TLoanHouse.apply_type as applyType,TLoanHouse.house_cardNo as houseCardno,TLoanHouse.house_owner as houseOwner,TLoanHouse.house_ownerGender as houseOwnergender,TLoanHouse.house_ownerCardNo as houseOwnercardno,TLoanHouse.house_ownerAge as houseOwnerage,TLoanHouse.house_colloate as houseColloate,TLoanHouse.house_colloateGender as houseColloategender,TLoanHouse.house_colloaterCardNo as houseColloatercardno,TLoanHouse.house_colloateAge as houseColloateage,TLoanHouse.house_address as houseAddress,TLoanHouse.house_square as houseSquare,TLoanHouse.house_value as houseValue,TLoanHouse.house_lended as houseLended,TLoanHouse.house_lendedMoney as houseLendedmoney from "+TABLE +" as TLoanHouse" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
		if(parameter != null){
            if(ParameterCheck.hasValue(parameter.get("loanHouseId"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.loan_house_id=? ");
				params.add(parameter.get("loanHouseId"));
			}

            if(ParameterCheck.hasValue(parameter.get("loanPid"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.loan_pid=? ");
				params.add(parameter.get("loanPid"));
			}

            if(ParameterCheck.hasValue(parameter.get("applyType"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.apply_type=? ");
				params.add(parameter.get("applyType"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseCardno"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_cardNo=? ");
				params.add(parameter.get("houseCardno"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseOwner"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_owner=? ");
				params.add(parameter.get("houseOwner"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseOwnergender"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_ownerGender=? ");
				params.add(parameter.get("houseOwnergender"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseOwnercardno"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_ownerCardNo=? ");
				params.add(parameter.get("houseOwnercardno"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseOwnerage"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_ownerAge=? ");
				params.add(parameter.get("houseOwnerage"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseColloate"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_colloate=? ");
				params.add(parameter.get("houseColloate"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseColloategender"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_colloateGender=? ");
				params.add(parameter.get("houseColloategender"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseColloatercardno"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_colloaterCardNo=? ");
				params.add(parameter.get("houseColloatercardno"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseColloateage"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_colloateAge=? ");
				params.add(parameter.get("houseColloateage"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseAddress"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_address=? ");
				params.add(parameter.get("houseAddress"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseSquare"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_square=? ");
				params.add(parameter.get("houseSquare"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseValue"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_value=? ");
				params.add(parameter.get("houseValue"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseLended"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_lended=? ");
				params.add(parameter.get("houseLended"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseLendedmoney"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_lendedMoney=? ");
				params.add(parameter.get("houseLendedmoney"));
			}
		}
		
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sb.append(" order by TLoanHouse." + orderSql);
		}
		
		if(log.isDebugEnabled()){
			log.debug("getAll : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
		}
		if(withParameter){
			return this.getJdbcTemplate().query(sql+ sb.toString(),params.toArray(), ParameterizedBeanPropertyRowMapper.newInstance(TLoanHouse.class));
		}else{
			return this.getJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(TLoanHouse.class));
		}
		
	}

	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public Collection<TLoanHouse> getAllByBean(TLoanHouse tLoanHouse) {
		return getAllByBean(tLoanHouse ,"" ,false ,false);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public Collection<TLoanHouse> getAllByBean(TLoanHouse tLoanHouse ,String orderBy) {
		return getAllByBean(tLoanHouse ,orderBy ,true ,true);
	}
	
	/**
	 * get the datat by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public Collection<TLoanHouse> getAllByBean(TLoanHouse tLoanHouse ,String orderBy ,boolean asc) {
		return getAllByBean(tLoanHouse ,orderBy ,asc ,true);
	}
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public Collection<TLoanHouse> getAllByBean(TLoanHouse tLoanHouse ,boolean orderFlag) {
		return getAllByBean(tLoanHouse ,"" ,false ,false);
	}
	

	
	private Collection<TLoanHouse> getAllByBean(TLoanHouse tLoanHouse,String orderBy,boolean asc,boolean order) {
		String sql = "select TLoanHouse.loan_house_id as loanHouseId ,TLoanHouse.loan_pid as loanPid,TLoanHouse.apply_type as applyType,TLoanHouse.house_cardNo as houseCardno,TLoanHouse.house_owner as houseOwner,TLoanHouse.house_ownerGender as houseOwnergender,TLoanHouse.house_ownerCardNo as houseOwnercardno,TLoanHouse.house_ownerAge as houseOwnerage,TLoanHouse.house_colloate as houseColloate,TLoanHouse.house_colloateGender as houseColloategender,TLoanHouse.house_colloaterCardNo as houseColloatercardno,TLoanHouse.house_colloateAge as houseColloateage,TLoanHouse.house_address as houseAddress,TLoanHouse.house_square as houseSquare,TLoanHouse.house_value as houseValue,TLoanHouse.house_lended as houseLended,TLoanHouse.house_lendedMoney as houseLendedmoney from "+TABLE +" as TLoanHouse" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
            
		if(ParameterCheck.hasValue(tLoanHouse.getLoanHouseId())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.loan_house_id=? ");
			params.add(tLoanHouse.getLoanHouseId());
		}

		if(ParameterCheck.hasValue(tLoanHouse.getLoanPid())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.loan_pid=? ");
			params.add(tLoanHouse.getLoanPid());
		}

		if(ParameterCheck.hasValue(tLoanHouse.getApplyType())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.apply_type=? ");
			params.add(tLoanHouse.getApplyType());
		}

		if(ParameterCheck.hasValue(tLoanHouse.getHouseCardno())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_cardNo=? ");
			params.add(tLoanHouse.getHouseCardno());
		}

		if(ParameterCheck.hasValue(tLoanHouse.getHouseOwner())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_owner=? ");
			params.add(tLoanHouse.getHouseOwner());
		}

		if(ParameterCheck.hasValue(tLoanHouse.getHouseOwnergender())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_ownerGender=? ");
			params.add(tLoanHouse.getHouseOwnergender());
		}

		if(ParameterCheck.hasValue(tLoanHouse.getHouseOwnercardno())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_ownerCardNo=? ");
			params.add(tLoanHouse.getHouseOwnercardno());
		}

		if(ParameterCheck.hasValue(tLoanHouse.getHouseOwnerage())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_ownerAge=? ");
			params.add(tLoanHouse.getHouseOwnerage());
		}

		if(ParameterCheck.hasValue(tLoanHouse.getHouseColloate())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_colloate=? ");
			params.add(tLoanHouse.getHouseColloate());
		}

		if(ParameterCheck.hasValue(tLoanHouse.getHouseColloategender())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_colloateGender=? ");
			params.add(tLoanHouse.getHouseColloategender());
		}

		if(ParameterCheck.hasValue(tLoanHouse.getHouseColloatercardno())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_colloaterCardNo=? ");
			params.add(tLoanHouse.getHouseColloatercardno());
		}

		if(ParameterCheck.hasValue(tLoanHouse.getHouseColloateage())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_colloateAge=? ");
			params.add(tLoanHouse.getHouseColloateage());
		}

		if(ParameterCheck.hasValue(tLoanHouse.getHouseAddress())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_address=? ");
			params.add(tLoanHouse.getHouseAddress());
		}

		if(ParameterCheck.hasValue(tLoanHouse.getHouseSquare())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_square=? ");
			params.add(tLoanHouse.getHouseSquare());
		}

		if(ParameterCheck.hasValue(tLoanHouse.getHouseValue())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_value=? ");
			params.add(tLoanHouse.getHouseValue());
		}

		if(ParameterCheck.hasValue(tLoanHouse.getHouseLended())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_lended=? ");
			params.add(tLoanHouse.getHouseLended());
		}

		if(ParameterCheck.hasValue(tLoanHouse.getHouseLendedmoney())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_lendedMoney=? ");
			params.add(tLoanHouse.getHouseLendedmoney());
		}
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sb.append(" order by TLoanHouse." + orderSql);
		}
		if(log.isDebugEnabled()){
			log.debug("getAllByBean : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
		}
		if(withParameter){
			return this.getJdbcTemplate().query(sql+ sb.toString(),params.toArray(), ParameterizedBeanPropertyRowMapper.newInstance(TLoanHouse.class));
		}else{
			return this.getJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(TLoanHouse.class));
		}		
	}
	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public Pagination<TLoanHouse> getPageAllByCondition(Map<String, Object> parameter, int pageIndex, int pageSize) {
		return getPageAllByCondition(parameter ,pageIndex ,pageSize ,"" ,false ,false);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public Pagination<TLoanHouse> getPageAllByCondition(Map<String, Object> parameter, int pageIndex, int pageSize, String orderBy) {
		return getPageAllByCondition(parameter ,pageIndex ,pageSize ,orderBy ,true ,true);
	}
	
	/**
	 * get the datat by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public Pagination<TLoanHouse> getPageAllByCondition(Map<String, Object> parameter, int pageIndex, int pageSize, String orderBy, boolean asc) {
		return getPageAllByCondition(parameter ,pageIndex ,pageSize ,orderBy ,asc ,true);
	}
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public Pagination<TLoanHouse> getPageAllByCondition(Map<String, Object> parameter, int pageIndex, int pageSize, boolean orderFlag) {
		return getPageAllByCondition(parameter ,pageIndex ,pageSize ,"" ,false ,false);
	}
	
	private Pagination<TLoanHouse> getPageAllByCondition(Map<String, Object> parameter, int pageIndex, int pageSize,String orderBy,boolean asc,boolean order) {
		String sql = "select TLoanHouse.loan_house_id as loanHouseId ,TLoanHouse.loan_pid as loanPid,TLoanHouse.apply_type as applyType,TLoanHouse.house_cardNo as houseCardno,TLoanHouse.house_owner as houseOwner,TLoanHouse.house_ownerGender as houseOwnergender,TLoanHouse.house_ownerCardNo as houseOwnercardno,TLoanHouse.house_ownerAge as houseOwnerage,TLoanHouse.house_colloate as houseColloate,TLoanHouse.house_colloateGender as houseColloategender,TLoanHouse.house_colloaterCardNo as houseColloatercardno,TLoanHouse.house_colloateAge as houseColloateage,TLoanHouse.house_address as houseAddress,TLoanHouse.house_square as houseSquare,TLoanHouse.house_value as houseValue,TLoanHouse.house_lended as houseLended,TLoanHouse.house_lendedMoney as houseLendedmoney from "+TABLE +" as TLoanHouse" +" where 1=1 ";
		String countSql = "select count(*) from "+TABLE +" as TLoanHouse" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
		if(parameter != null){

            if(ParameterCheck.hasValue(parameter.get("loanHouseId"))){
				withParameter = true;   
				sb.append(" and TLoanHouse.loan_house_id=? ");
				params.add(parameter.get("loanHouseId"));
			}

            if(ParameterCheck.hasValue(parameter.get("loanPid"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.loan_pid=? ");
				params.add(parameter.get("loanPid"));
			}

            if(ParameterCheck.hasValue(parameter.get("applyType"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.apply_type=? ");
				params.add(parameter.get("applyType"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseCardno"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_cardNo=? ");
				params.add(parameter.get("houseCardno"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseOwner"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_owner=? ");
				params.add(parameter.get("houseOwner"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseOwnergender"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_ownerGender=? ");
				params.add(parameter.get("houseOwnergender"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseOwnercardno"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_ownerCardNo=? ");
				params.add(parameter.get("houseOwnercardno"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseOwnerage"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_ownerAge=? ");
				params.add(parameter.get("houseOwnerage"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseColloate"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_colloate=? ");
				params.add(parameter.get("houseColloate"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseColloategender"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_colloateGender=? ");
				params.add(parameter.get("houseColloategender"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseColloatercardno"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_colloaterCardNo=? ");
				params.add(parameter.get("houseColloatercardno"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseColloateage"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_colloateAge=? ");
				params.add(parameter.get("houseColloateage"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseAddress"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_address=? ");
				params.add(parameter.get("houseAddress"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseSquare"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_square=? ");
				params.add(parameter.get("houseSquare"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseValue"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_value=? ");
				params.add(parameter.get("houseValue"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseLended"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_lended=? ");
				params.add(parameter.get("houseLended"));
			}

            if(ParameterCheck.hasValue(parameter.get("houseLendedmoney"))){
			    withParameter = true;    
				sb.append(" and TLoanHouse.house_lendedMoney=? ");
				params.add(parameter.get("houseLendedmoney"));
			}
		}
		Pagination<TLoanHouse> page = new Pagination<TLoanHouse>(pageIndex,pageSize);
		
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sb.append(" order by TLoanHouse." + orderSql);
		}
		if(log.isDebugEnabled()){
			log.debug("getPageAllTLoanHouseByCondition : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
			log.debug("pageIndex : " + pageIndex + "   pageSize:  " + pageSize);
		}
		if(withParameter){
			this.paginationQuery(sql + sb.toString(),countSql + sb.toString(), params.toArray(), page,ParameterizedBeanPropertyRowMapper.newInstance(TLoanHouse.class));
		}else{
		    this.paginationQuery(sql,countSql ,page,ParameterizedBeanPropertyRowMapper.newInstance(TLoanHouse.class));
		}
		return page;
	}
	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public Pagination<TLoanHouse> getPageAllByBean(TLoanHouse tLoanHouse, int pageIndex, int pageSize) {
		return getPageAllByBean(tLoanHouse ,pageIndex ,pageSize ,"" ,false ,false);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public Pagination<TLoanHouse> getPageAllByBean(TLoanHouse tLoanHouse, int pageIndex, int pageSize,String orderBy) {
		return  getPageAllByBean(tLoanHouse ,pageIndex ,pageSize ,orderBy ,true ,true);
	}
	
	/**
	 * get the datat by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public Pagination<TLoanHouse> getPageAllByBean(TLoanHouse tLoanHouse, int pageIndex, int pageSize,String orderBy,boolean asc) {
		return  getPageAllByBean(tLoanHouse ,pageIndex ,pageSize ,orderBy ,asc ,true);
	}
	
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public Pagination<TLoanHouse> getPageAllByBean(TLoanHouse tLoanHouse, int pageIndex, int pageSize,boolean orderFlag) {
		return  getPageAllByBean(tLoanHouse ,pageIndex ,pageSize ,"" ,false ,false);
	}
	
	private Pagination<TLoanHouse> getPageAllByBean(TLoanHouse tLoanHouse, int pageIndex, int pageSize,String orderBy,boolean asc,boolean order) {
		String sql = "select TLoanHouse.loan_house_id as loanHouseId ,TLoanHouse.loan_pid as loanPid,TLoanHouse.apply_type as applyType,TLoanHouse.house_cardNo as houseCardno,TLoanHouse.house_owner as houseOwner,TLoanHouse.house_ownerGender as houseOwnergender,TLoanHouse.house_ownerCardNo as houseOwnercardno,TLoanHouse.house_ownerAge as houseOwnerage,TLoanHouse.house_colloate as houseColloate,TLoanHouse.house_colloateGender as houseColloategender,TLoanHouse.house_colloaterCardNo as houseColloatercardno,TLoanHouse.house_colloateAge as houseColloateage,TLoanHouse.house_address as houseAddress,TLoanHouse.house_square as houseSquare,TLoanHouse.house_value as houseValue,TLoanHouse.house_lended as houseLended,TLoanHouse.house_lendedMoney as houseLendedmoney from "+TABLE +" as TLoanHouse" +" where 1=1 ";
		String countSql = "select count(*) from "+TABLE +" as TLoanHouse" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 

		if(ParameterCheck.hasValue(tLoanHouse.getLoanHouseId())){
			withParameter = true;   
			sb.append(" and TLoanHouse.loan_house_id=? ");
			params.add(tLoanHouse.getLoanHouseId());
		}
        
		if(ParameterCheck.hasValue(tLoanHouse.getLoanPid())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.loan_pid=? ");
			params.add(tLoanHouse.getLoanPid());
		}
        
		if(ParameterCheck.hasValue(tLoanHouse.getApplyType())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.apply_type=? ");
			params.add(tLoanHouse.getApplyType());
		}
        
		if(ParameterCheck.hasValue(tLoanHouse.getHouseCardno())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_cardNo=? ");
			params.add(tLoanHouse.getHouseCardno());
		}
        
		if(ParameterCheck.hasValue(tLoanHouse.getHouseOwner())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_owner=? ");
			params.add(tLoanHouse.getHouseOwner());
		}
        
		if(ParameterCheck.hasValue(tLoanHouse.getHouseOwnergender())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_ownerGender=? ");
			params.add(tLoanHouse.getHouseOwnergender());
		}
        
		if(ParameterCheck.hasValue(tLoanHouse.getHouseOwnercardno())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_ownerCardNo=? ");
			params.add(tLoanHouse.getHouseOwnercardno());
		}
        
		if(ParameterCheck.hasValue(tLoanHouse.getHouseOwnerage())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_ownerAge=? ");
			params.add(tLoanHouse.getHouseOwnerage());
		}
        
		if(ParameterCheck.hasValue(tLoanHouse.getHouseColloate())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_colloate=? ");
			params.add(tLoanHouse.getHouseColloate());
		}
        
		if(ParameterCheck.hasValue(tLoanHouse.getHouseColloategender())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_colloateGender=? ");
			params.add(tLoanHouse.getHouseColloategender());
		}
        
		if(ParameterCheck.hasValue(tLoanHouse.getHouseColloatercardno())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_colloaterCardNo=? ");
			params.add(tLoanHouse.getHouseColloatercardno());
		}
        
		if(ParameterCheck.hasValue(tLoanHouse.getHouseColloateage())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_colloateAge=? ");
			params.add(tLoanHouse.getHouseColloateage());
		}
        
		if(ParameterCheck.hasValue(tLoanHouse.getHouseAddress())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_address=? ");
			params.add(tLoanHouse.getHouseAddress());
		}
        
		if(ParameterCheck.hasValue(tLoanHouse.getHouseSquare())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_square=? ");
			params.add(tLoanHouse.getHouseSquare());
		}
        
		if(ParameterCheck.hasValue(tLoanHouse.getHouseValue())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_value=? ");
			params.add(tLoanHouse.getHouseValue());
		}
        
		if(ParameterCheck.hasValue(tLoanHouse.getHouseLended())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_lended=? ");
			params.add(tLoanHouse.getHouseLended());
		}
        
		if(ParameterCheck.hasValue(tLoanHouse.getHouseLendedmoney())){
		    withParameter = true;    
			sb.append(" and TLoanHouse.house_lendedMoney=? ");
			params.add(tLoanHouse.getHouseLendedmoney());
		}

		Pagination<TLoanHouse> page = new Pagination<TLoanHouse>(pageIndex,pageSize);
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sb.append(" order by TLoanHouse." + orderSql);
		}
		if(log.isDebugEnabled()){
			log.debug("getPageAllTLoanHouseByBean : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
			log.debug("pageIndex : " + pageIndex + "   pageSize:  " + pageSize);
		}
		if(withParameter){
			this.paginationQuery(sql + sb.toString(),countSql + sb.toString(), params.toArray(), page,ParameterizedBeanPropertyRowMapper.newInstance(TLoanHouse.class));
		}else{
		    this.paginationQuery(sql,countSql ,page,ParameterizedBeanPropertyRowMapper.newInstance(TLoanHouse.class));
		}
		return page;
	}
	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public List<TLoanHouse> getAll(){
		return getAll("" ,false ,false);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public List<TLoanHouse> getAll(String orderBy){
		return getAll(orderBy ,true ,true);
	}
	
	/**
	 * get the datat by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public List<TLoanHouse> getAll(String orderBy,boolean asc){
		return getAll(orderBy ,asc ,true);
	}
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public List<TLoanHouse> getAll(boolean orderFlag){
		return getAll("" ,false ,false);
	}
	
	private List<TLoanHouse> getAll(String orderBy,boolean asc,boolean order){
		String sql = "select TLoanHouse.loan_house_id as loanHouseId ,TLoanHouse.loan_pid as loanPid,TLoanHouse.apply_type as applyType,TLoanHouse.house_cardNo as houseCardno,TLoanHouse.house_owner as houseOwner,TLoanHouse.house_ownerGender as houseOwnergender,TLoanHouse.house_ownerCardNo as houseOwnercardno,TLoanHouse.house_ownerAge as houseOwnerage,TLoanHouse.house_colloate as houseColloate,TLoanHouse.house_colloateGender as houseColloategender,TLoanHouse.house_colloaterCardNo as houseColloatercardno,TLoanHouse.house_colloateAge as houseColloateage,TLoanHouse.house_address as houseAddress,TLoanHouse.house_square as houseSquare,TLoanHouse.house_value as houseValue,TLoanHouse.house_lended as houseLended,TLoanHouse.house_lendedMoney as houseLendedmoney from " + TABLE +" as TLoanHouse" ;	
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sql += (" order by TLoanHouse." + orderSql);
		}
		return this.getJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(TLoanHouse.class));	
	}
	
	/**
	 * if has updateDate or create Date then orderby them:  updateDate first
	 * if has no updateDate or createDate then has no order
	 * @param parameter
	 * @return
	 */
	public Pagination<TLoanHouse> getPageAll(int pageIndex, int pageSize) {
		return getPageAll(pageIndex ,pageSize ,"" ,false ,false);
	}
	
	/**
	 * get the data by oderBy ASC
	 * @param parameter
	 * @param orderBy
	 * @return
	 */
	public Pagination<TLoanHouse> getPageAll(int pageIndex, int pageSize,String orderBy) {
		return getPageAll(pageIndex ,pageSize ,orderBy ,true ,true);
	}
	
	/**
	 * get the datat by orderBy specify by the Asc true asc  false desc
	 * @param parameter
	 * @param orderBy
	 * @param asc
	 * @return
	 */
	public Pagination<TLoanHouse> getPageAll(int pageIndex, int pageSize,String orderBy,boolean asc) {
		return getPageAll(pageIndex ,pageSize ,orderBy ,asc ,true);
	}
	
	/**
	 * Has the updateDate and createDate and want to has no orderBy
	 * @param parameter
	 * @param orderFlag true or false has the same meaning : get the data without any order
	 * @return
	 */
	public Pagination<TLoanHouse> getPageAll(int pageIndex, int pageSize,boolean orderFlag) {
		return getPageAll(pageIndex ,pageSize ,"" ,false ,false);
	}
	
	
	
	private Pagination<TLoanHouse> getPageAll(int pageIndex, int pageSize,String orderBy,boolean asc,boolean order) {
		String sql ="select TLoanHouse.loan_house_id as loanHouseId ,TLoanHouse.loan_pid as loanPid,TLoanHouse.apply_type as applyType,TLoanHouse.house_cardNo as houseCardno,TLoanHouse.house_owner as houseOwner,TLoanHouse.house_ownerGender as houseOwnergender,TLoanHouse.house_ownerCardNo as houseOwnercardno,TLoanHouse.house_ownerAge as houseOwnerage,TLoanHouse.house_colloate as houseColloate,TLoanHouse.house_colloateGender as houseColloategender,TLoanHouse.house_colloaterCardNo as houseColloatercardno,TLoanHouse.house_colloateAge as houseColloateage,TLoanHouse.house_address as houseAddress,TLoanHouse.house_square as houseSquare,TLoanHouse.house_value as houseValue,TLoanHouse.house_lended as houseLended,TLoanHouse.house_lendedMoney as houseLendedmoney from " + TABLE +" as TLoanHouse" ;
		String countSql = "select count(*) from " + TABLE;
		
		if(order){
			String orderSql = orderBy + (asc ? " asc":" desc"); 
			sql += (" order by TLoanHouse." + orderSql);
		}
		Pagination<TLoanHouse> page = new Pagination<TLoanHouse>(pageIndex,pageSize);
		this.paginationQuery(sql,countSql, page,ParameterizedBeanPropertyRowMapper.newInstance(TLoanHouse.class));
		return page;
	}
	
	

	protected class TLoanHouseRowMapper implements RowMapper<TLoanHouse> {
		public TLoanHouse mapRow(ResultSet rs, int rowNum) throws SQLException {
			TLoanHouse tLoanHouse = new TLoanHouse();
        	tLoanHouse.setLoanHouseId(rs.getInt("loanHouseId"));
			tLoanHouse.setLoanPid(rs.getInt("loanPid"));
			tLoanHouse.setApplyType(rs.getString("applyType"));
			tLoanHouse.setHouseCardno(rs.getString("houseCardno"));
			tLoanHouse.setHouseOwner(rs.getString("houseOwner"));
			tLoanHouse.setHouseOwnergender(rs.getString("houseOwnergender"));
			tLoanHouse.setHouseOwnercardno(rs.getString("houseOwnercardno"));
			tLoanHouse.setHouseOwnerage(rs.getByte("houseOwnerage"));
			tLoanHouse.setHouseColloate(rs.getString("houseColloate"));
			tLoanHouse.setHouseColloategender(rs.getString("houseColloategender"));
			tLoanHouse.setHouseColloatercardno(rs.getString("houseColloatercardno"));
			tLoanHouse.setHouseColloateage(rs.getByte("houseColloateage"));
			tLoanHouse.setHouseAddress(rs.getString("houseAddress"));
			tLoanHouse.setHouseSquare(rs.getBigDecimal("houseSquare"));
			tLoanHouse.setHouseValue(rs.getBigDecimal("houseValue"));
			tLoanHouse.setHouseLended(rs.getByte("houseLended"));
			tLoanHouse.setHouseLendedmoney(rs.getBigDecimal("houseLendedmoney"));
			return tLoanHouse;
		}
	}
}