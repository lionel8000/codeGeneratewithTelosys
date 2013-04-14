package com.hlj.tech.kdkj.auto.dao;

import com.hlj.tech.kdkj.common.ParameterCheck;
import com.hlj.tech.kdkj.auto.entities.TCity;
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

/**
 * @author lionel.xu@bstek.com
 * @since 1.0
 */
@Repository
public class TCityDao extends CoreJdbcDaoSupport {

    private static Logger log = LoggerFactory.getLogger(TCityDao.class);  

    private static String TABLE = "t_city";

	public Short insertTCity(TCity tCity) throws Exception {
		String sql = "insert into "+TABLE +"(province_id,name)  values(?,?)";
		Object args[] = new Object[] { tCity.getProvinceId(),tCity.getName() };
		if(log.isDebugEnabled()){
			log.debug("insertTCity : SQL IS : " + sql + " : PARAM IS : " + args);
		}
		this.getJdbcTemplate().update(sql, args);		
        return tCity.getId();
	}

	
	
	public Short insertTCitySelective(TCity tCity) throws Exception {
		StringBuffer columns = new StringBuffer();
		StringBuffer questions = new StringBuffer(30);
		List<Object> params = new ArrayList<Object>();
		if(ParameterCheck.hasValue(tCity.getProvinceId())){
			params.add(tCity.getProvinceId());
			columns.append(",province_id");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tCity.getName())){
			params.add(tCity.getName());
			columns.append(",name");
			questions.append(",?");
		}
		String sql = "insert into " + TABLE + "(" + columns.toString().substring(1) + ") values(" + questions.toString().substring(1) +")";
		if(log.isDebugEnabled()){
			log.debug("insertTCitySelective : SQL IS : " + sql + " : PARAM IS : " + params.toArray());
		}
		this.getJdbcTemplate().update(sql, params.toArray());
		return tCity.getId();
	}
	
	
	
	public void deleteTCityById(Short id) throws Exception {
		String sql = "delete from " +TABLE +" where  id=?";
		Object args[] = new Object[] {id};

		if(log.isDebugEnabled()){
			log.debug("deleteTCityById : SQL IS : " + sql + " : PARAM IS : " + args);
		}
		this.getJdbcTemplate().update(sql, args);
	}
	
	
    
	public void deleteTCityByBean(TCity tCity) throws Exception{
		List<Object> params = new ArrayList<Object>();
  		StringBuffer columns = new StringBuffer();
		if(ParameterCheck.hasValue(tCity.getProvinceId())){
			params.add(tCity.getProvinceId());
			columns.append("and province_id=? ");
		}
		if(ParameterCheck.hasValue(tCity.getName())){
			params.add(tCity.getName());
			columns.append("and name=? ");
		}

		String sql = "delete from " +TABLE + " where " +columns.toString().substring(4);
		if(log.isDebugEnabled()){
			log.debug("deleteTCityByBean : SQL IS : " + sql + " : PARAM IS : " + params.toArray());
		}
	    this.getJdbcTemplate().update(sql,params.toArray());
	}
	
	
	
	public void updateTCity(TCity tCity) throws Exception {
		String sql = "update " +TABLE +" set province_id=?,name=? where  id=?";
		Object args[] = new Object[] {tCity.getProvinceId(),tCity.getName(),tCity.getId()};
		if(log.isDebugEnabled()){
			log.debug("updateTCity : SQL IS : " + sql + " : PARAM IS : " + args);
		}
		this.getJdbcTemplate().update(sql, args);
	}
	
	
	
	public void updateTCitySelective(TCity tCity) throws Exception {
		List<Object> params = new ArrayList<Object>();
        StringBuffer columns = new StringBuffer();
        String keys = "";
		if(ParameterCheck.hasValue(tCity.getProvinceId())){
			params.add(tCity.getProvinceId());
			columns.append(",province_id=?");
		}
		if(ParameterCheck.hasValue(tCity.getName())){
			params.add(tCity.getName());
			columns.append(",name=?");
		}

		
		if(ParameterCheck.hasValue(tCity.getId())){
			params.add(tCity.getId());
			keys += "and id=? ";
		}
		String sql = "update " + TABLE + " set " +columns.toString().substring(1)+" where "+keys.substring(4);
		if(log.isDebugEnabled()){
			log.debug("updateTCitySelective : SQL IS : " + sql + " : PARAM IS : " + params.toArray());
		}
		this.getJdbcTemplate().update(sql, params.toArray());
	}
	
	
		
	
	public TCity getTCityById(Short id) {
		String sql = "select TCity.id as id ,TCity.province_id as provinceId,TCity.name as name from "+TABLE+" as TCity where  TCity.id=?";
		if(log.isDebugEnabled()){
			log.debug("getTCityById : SQL IS : " + sql + " : PARAM IS : " + id);
		}
		List<TCity> tCityList = this.getJdbcTemplate().query(sql,new Object[]{id}, ParameterizedBeanPropertyRowMapper.newInstance(TCity.class));
		return tCityList.size() > 0 ? tCityList.get(0) : null;

	}
	
	
	
	public Collection<TCity> getAllTCity(Map<String, Object> parameter) {
		String sql = "select TCity.id as id ,TCity.province_id as provinceId,TCity.name as name from "+TABLE +" as TCity" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
		if(parameter != null){
            if(ParameterCheck.hasValue(parameter.get("id"))){
			    withParameter = true;    
				sb.append(" and TCity.id=? ");
				params.add(parameter.get("id"));
			}

            if(ParameterCheck.hasValue(parameter.get("provinceId"))){
			    withParameter = true;    
				sb.append(" and TCity.province_id=? ");
				params.add(parameter.get("provinceId"));
			}

            if(ParameterCheck.hasValue(parameter.get("name"))){
			    withParameter = true;    
				sb.append(" and TCity.name=? ");
				params.add(parameter.get("name"));
			}
		}
		if(log.isDebugEnabled()){
			log.debug("getAllTCity : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
		}
		if(withParameter){
			return this.getJdbcTemplate().query(sql+ sb.toString(),params.toArray(), ParameterizedBeanPropertyRowMapper.newInstance(TCity.class));
		}else{
			return this.getJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(TCity.class));
		}
		
	}
	
	
	
	public Collection<TCity> getAllTCityByBean(TCity tCity) {
		String sql = "select TCity.id as id ,TCity.province_id as provinceId,TCity.name as name from "+TABLE +" as TCity" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
            
		if(ParameterCheck.hasValue(tCity.getId())){
		    withParameter = true;    
			sb.append(" and TCity.id=? ");
			params.add(tCity.getId());
		}

		if(ParameterCheck.hasValue(tCity.getProvinceId())){
		    withParameter = true;    
			sb.append(" and TCity.province_id=? ");
			params.add(tCity.getProvinceId());
		}

		if(ParameterCheck.hasValue(tCity.getName())){
		    withParameter = true;    
			sb.append(" and TCity.name=? ");
			params.add(tCity.getName());
		}
		if(log.isDebugEnabled()){
			log.debug("getAllTCityByBean : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
		}
		if(withParameter){
			return this.getJdbcTemplate().query(sql+ sb.toString(),params.toArray(), ParameterizedBeanPropertyRowMapper.newInstance(TCity.class));
		}else{
			return this.getJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(TCity.class));
		}
		
	}
	
	
	
	public Pagination<TCity> getPageAllTCityByCondition(Map<String, Object> parameter, int pageIndex, int pageSize) {
		String sql = "select TCity.id as id ,TCity.province_id as provinceId,TCity.name as name from "+TABLE +" as TCity" +" where 1=1 ";
		String countSql = "select count(*) from "+TABLE +" as TCity" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
		if(parameter != null){

            if(ParameterCheck.hasValue(parameter.get("id"))){
				withParameter = true;   
				sb.append(" and TCity.id=? ");
				params.add(parameter.get("id"));
			}

            if(ParameterCheck.hasValue(parameter.get("provinceId"))){
			    withParameter = true;    
				sb.append(" and TCity.province_id=? ");
				params.add(parameter.get("provinceId"));
			}

            if(ParameterCheck.hasValue(parameter.get("name"))){
			    withParameter = true;    
				sb.append(" and TCity.name=? ");
				params.add(parameter.get("name"));
			}
		}
		Pagination<TCity> page = new Pagination<TCity>(pageIndex,pageSize);
		if(log.isDebugEnabled()){
			log.debug("getPageAllTCityByCondition : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
			log.debug("pageIndex : " + pageIndex + "   pageSize:  " + pageSize);
		}
		if(withParameter){
			this.paginationQuery(sql + sb.toString(),countSql + sb.toString(), params.toArray(), page,ParameterizedBeanPropertyRowMapper.newInstance(TCity.class));
		}else{
		    this.paginationQuery(sql,countSql ,page,ParameterizedBeanPropertyRowMapper.newInstance(TCity.class));
		}
		return page;
	}
	
	
	
	public Pagination<TCity> getPageAllTCityByBean(TCity tCity, int pageIndex, int pageSize) {
		String sql = "select TCity.id as id ,TCity.province_id as provinceId,TCity.name as name from "+TABLE +" as TCity" +" where 1=1 ";
		String countSql = "select count(*) from "+TABLE +" as TCity" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 

		if(ParameterCheck.hasValue(tCity.getId())){
			withParameter = true;   
			sb.append(" and TCity.id=? ");
			params.add(tCity.getId());
		}
        
		if(ParameterCheck.hasValue(tCity.getProvinceId())){
		    withParameter = true;    
			sb.append(" and TCity.province_id=? ");
			params.add(tCity.getProvinceId());
		}
        
		if(ParameterCheck.hasValue(tCity.getName())){
		    withParameter = true;    
			sb.append(" and TCity.name=? ");
			params.add(tCity.getName());
		}

		Pagination<TCity> page = new Pagination<TCity>(pageIndex,pageSize);
		if(log.isDebugEnabled()){
			log.debug("getPageAllTCityByBean : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
			log.debug("pageIndex : " + pageIndex + "   pageSize:  " + pageSize);
		}
		if(withParameter){
			this.paginationQuery(sql + sb.toString(),countSql + sb.toString(), params.toArray(), page,ParameterizedBeanPropertyRowMapper.newInstance(TCity.class));
		}else{
		    this.paginationQuery(sql,countSql ,page,ParameterizedBeanPropertyRowMapper.newInstance(TCity.class));
		}
		return page;
	}
	
	
	
	public List<TCity> getAllTCity(){
		String sql = "select TCity.id as id ,TCity.province_id as provinceId,TCity.name as name from " + TABLE +" as TCity" ;			
		return this.getJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(TCity.class));
		
	}
	
	
	
	public Pagination<TCity> getPageAllTCity(int pageIndex, int pageSize) {
		String sql ="select TCity.id as id ,TCity.province_id as provinceId,TCity.name as name from " + TABLE +" as TCity" ;
		String countSql = "select count(*) from " + TABLE;
		Pagination<TCity> page = new Pagination<TCity>(pageIndex,pageSize);
		this.paginationQuery(sql,countSql, page,ParameterizedBeanPropertyRowMapper.newInstance(TCity.class));
		return page;
	}
	
	

	public class TCityRowMapper implements RowMapper<TCity> {
		public TCity mapRow(ResultSet rs, int rowNum) throws SQLException {
			TCity tCity = new TCity();
        	tCity.setId(rs.getShort("id"));
			tCity.setProvinceId(rs.getShort("provinceId"));
			tCity.setName(rs.getString("name"));
			return tCity;
		}
	}
}