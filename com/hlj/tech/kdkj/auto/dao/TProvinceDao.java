/**
   BNAME                    : bean name with first letter Upcase
   BNAME_V                  : bean name with first letter LowerCase
   BNAME_DAO and BNAME_DAO_V   has relative same meaning for the BNAME
   KEYS                     : all keys concated with first letter Upcase
   KEYS_PAR                 : all keys with declare type
   KEYS_PAR_NODECLARE       : all keys with no declare type use as parameter
*/



package com.hlj.tech.kdkj.auto.dao;

import com.hlj.tech.kdkj.auto.entities.TProvince;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
public class TProvinceDao extends CoreJdbcDaoSupport {
    private static String TABLE = "t_province";
	public Short insertTProvince(TProvince tProvince) throws Exception {
		String sql = "insert into "+TABLE +"(code,name)  values(?,?)";
		Object args[] = new Object[] { tProvince.getCode(),tProvince.getName() };
		this.getJdbcTemplate().update(sql, args);
        return tProvince.getId();
	}
	
	
	public void deleteTProvinceById(Short id) throws Exception {
		String sql = "delete from " +TABLE +" where  id=?";
		this.getJdbcTemplate().update(sql, new Object[] { id });
	}
	



	public void updateTProvince(TProvince tProvince) throws Exception {
		String sql = "update " +TABLE +" set code=?,name=? where  id=?";
		Object args[] = new Object[] {tProvince.getCode(),tProvince.getName(),tProvince.getId()};
		this.getJdbcTemplate().update(sql, args);
	}
	
	
	
	
	public TProvince getTProvinceById(Short id) {
		String sql = "select id ,code,name from "+TABLE+" where  id=?";
		List<TProvince> tProvinceList = this.getJdbcTemplate().query(sql,new Object[]{id}, new TProvinceRowMapper());
		return tProvinceList.size() > 0 ? tProvinceList.get(0) : null;

	}
	
	public List<TProvince> getAllTProvince(){
		String sql = "select id ,code,name from " + TABLE;		
		return this.getJdbcTemplate().query(sql, new TProvinceRowMapper());
		
	}

	public Collection<TProvince> getAllTProvince(Map<String, Object> parameter) {
		String sql = "select id ,code,name from "+TABLE+" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
		if(parameter != null){
	            
			if(parameter.get("id")!=null){
			    withParameter = true;    
				sb.append(" and id=? ");
				params.add(parameter.get("id"));
			}
            	
			if(parameter.get("code")!=null){
			    withParameter = true;    
				sb.append(" and code=? ");
				params.add(parameter.get("code"));
			}

			if(parameter.get("name")!=null){
			    withParameter = true;    
				sb.append(" and name=? ");
				params.add(parameter.get("name"));
			}
		}
		if(withParameter){
			return this.getJdbcTemplate().query(sql+ sb.toString(),params.toArray(), new TProvinceRowMapper());
		}else{
			return this.getJdbcTemplate().query(sql, new TProvinceRowMapper());
		}
		
	}
	
	
	public Pagination<TProvince> getPageAllTProvinceByCondition(Map<String, Object> parameter, int pageIndex, int pageSize) {
		String sql = "select id ,code,name from "+TABLE+" where 1=1 ";
		String countSql = "select count(*) from "+TABLE+" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
		if(parameter != null){
	
			if(parameter.get("id")!=null){
				withParameter = true;   
				sb.append(" and id=? ");
				params.add(parameter.get("id"));
			}
            	
			if(parameter.get("code")!=null){
			    withParameter = true;    
				sb.append(" and code=? ");
				params.add(parameter.get("code"));
			}

			if(parameter.get("name")!=null){
			    withParameter = true;    
				sb.append(" and name=? ");
				params.add(parameter.get("name"));
			}
		}
		Pagination<TProvince> page = new Pagination<TProvince>(pageIndex,pageSize);
		if(withParameter){
			this.paginationQuery(sql + sb.toString(),countSql + sb.toString(), params.toArray(), page,new TProvinceRowMapper());
		}else{
		    this.paginationQuery(sql,countSql ,page,new TProvinceRowMapper());
		}
		return page;
	}
	
	
	public Pagination<TProvince> getPageAllTProvince(int pageIndex, int pageSize) {
		String sql ="select id ,code,name from " + TABLE;
		String countSql = "select count(*) from " + TABLE;
		Pagination<TProvince> page = new Pagination<TProvince>(pageIndex,pageSize);
		this.paginationQuery(sql,countSql,new Object[]{}, page,	new TProvinceRowMapper());
		return page;
	}

	public class TProvinceRowMapper implements RowMapper<TProvince> {
		public TProvince mapRow(ResultSet rs, int rowNum) throws SQLException {
			TProvince tProvince = new TProvince();
        	tProvince.setId(rs.getShort("id"));
			tProvince.setCode(rs.getString("code"));
			tProvince.setName(rs.getString("name"));
			return tProvince;
		}
	}
}