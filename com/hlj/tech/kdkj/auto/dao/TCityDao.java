/**
   BNAME                    : bean name with first letter Upcase
   BNAME_V                  : bean name with first letter LowerCase
   BNAME_DAO and BNAME_DAO_V   has relative same meaning for the BNAME
   KEYS                     : all keys concated with first letter Upcase
   KEYS_PAR                 : all keys with declare type
   KEYS_PAR_NODECLARE       : all keys with no declare type use as parameter
*/



package com.hlj.tech.kdkj.auto.dao;

import com.hlj.tech.kdkj.auto.entities.TCity;
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
public class TCityDao extends CoreJdbcDaoSupport {
    private static String TABLE = "t_city";
	public Short insertTCity(TCity tCity) throws Exception {
		String sql = "insert into "+TABLE +"(province_id,name)  values(?,?)";
		Object args[] = new Object[] { tCity.getProvinceId(),tCity.getName() };
		this.getJdbcTemplate().update(sql, args);
        return tCity.getId();
	}
	public Short insertTCitySelective(TCity tCity) throws Exception {
		StringBuffer columns = new StringBuffer();
		StringBuffer questions = new StringBuffer(30);
		List<Object> params = new ArrayList<Object>();
		if(tCity.getProvinceId() != null){
			params.add(tCity.getProvinceId());
			columns.append(",province_id");
			questions.append(",?");
		}
		if(tCity.getName() != null){
			params.add(tCity.getName());
			columns.append(",name");
			questions.append(",?");
		}
		String sql = "insert into " + TABLE + "(" + columns.toString().substring(1) + ") values(" + questions.toString().substring(1) +")";
		this.getJdbcTemplate().update(sql, params.toArray());
		return tCity.getId();
	}
	
	public void deleteTCityById(Short id) throws Exception {
		String sql = "delete from " +TABLE +" where  id=?";
		this.getJdbcTemplate().update(sql, new Object[] { id });
	}
    
	public void deleteTCityByBean(TCity tCity) throws Exception{
		List<Object> params = new ArrayList<Object>();
  		StringBuffer columns = new StringBuffer();
		if(tCity.getProvinceId() != null){
			params.add(tCity.getProvinceId());
			columns.append("and province_id=? ");
		}
		if(tCity.getName() != null){
			params.add(tCity.getName());
			columns.append("and name=? ");
		}

		String sql = "delete from " +TABLE + " where " +columns.toString().substring(4);
	    this.getJdbcTemplate().update(sql,params.toArray());
	}
	
	public void updateTCity(TCity tCity) throws Exception {
		String sql = "update " +TABLE +" set province_id=?,name=? where  id=?";
		Object args[] = new Object[] {tCity.getProvinceId(),tCity.getName(),tCity.getId()};
		this.getJdbcTemplate().update(sql, args);
	}
	
	public void updateTCitySelective(TCity tCity) throws Exception {
		List<Object> params = new ArrayList<Object>();
        StringBuffer columns = new StringBuffer();
        String keys = "";
		if(tCity.getProvinceId() != null){
			params.add(tCity.getProvinceId());
			columns.append(",province_id=?");
		}
		if(tCity.getName() != null){
			params.add(tCity.getName());
			columns.append(",name=?");
		}

		
		if(tCity.getId() != null){
			params.add(tCity.getId());
			keys += "and id=? ";
		}
		String sql = "update " + TABLE + " set " +columns.toString().substring(1)+" where "+keys.substring(4);
		this.getJdbcTemplate().update(sql, params.toArray());
	}
		
	
	public TCity getTCityById(Short id) {
		String sql = "select TCity.id as id ,TCity.province_id as provinceId,TCity.name as name from "+TABLE+" as TCity where  TCity.id=?";
		List<TCity> tCityList = this.getJdbcTemplate().query(sql,new Object[]{id}, new TCityRowMapper());
		return tCityList.size() > 0 ? tCityList.get(0) : null;

	}
	
	public Collection<TCity> getAllTCity(Map<String, Object> parameter) {
		String sql = "select TCity.id as id ,TCity.province_id as provinceId,TCity.name as name from "+TABLE +" as TCity" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
		if(parameter != null){
            
			if(parameter.get("id")!=null){
			    withParameter = true;    
				sb.append(" and TCity.id=? ");
				params.add(parameter.get("id"));
			}

			if(parameter.get("provinceId")!=null){
			    withParameter = true;    
				sb.append(" and TCity.province_id=? ");
				params.add(parameter.get("provinceId"));
			}

			if(parameter.get("name")!=null){
			    withParameter = true;    
				sb.append(" and TCity.name=? ");
				params.add(parameter.get("name"));
			}
		}
		if(withParameter){
			return this.getJdbcTemplate().query(sql+ sb.toString(),params.toArray(), new TCityRowMapper());
		}else{
			return this.getJdbcTemplate().query(sql, new TCityRowMapper());
		}
		
	}
	
	public Collection<TCity> getAllTCityByBean(TCity tCity) {
		String sql = "select TCity.id as id ,TCity.province_id as provinceId,TCity.name as name from "+TABLE +" as TCity" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
            
	    if(tCity.getId() != null){
		    withParameter = true;    
			sb.append(" and TCity.id=? ");
			params.add(tCity.getId());
		}

		if(tCity.getProvinceId() != null){
		    withParameter = true;    
			sb.append(" and TCity.province_id=? ");
			params.add(tCity.getProvinceId());
		}

		if(tCity.getName() != null){
		    withParameter = true;    
			sb.append(" and TCity.name=? ");
			params.add(tCity.getName());
		}
		if(withParameter){
			return this.getJdbcTemplate().query(sql+ sb.toString(),params.toArray(), new TCityRowMapper());
		}else{
			return this.getJdbcTemplate().query(sql, new TCityRowMapper());
		}
		
	}
	
	public Pagination<TCity> getPageAllTCityByCondition(Map<String, Object> parameter, int pageIndex, int pageSize) {
		String sql = "select TCity.id as id ,TCity.province_id as provinceId,TCity.name as name from "+TABLE +" as TCity" +" where 1=1 ";
		String countSql = "select count(*) from "+TABLE +" as TCity" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
		if(parameter != null){

			if(parameter.get("id")!=null){
				withParameter = true;   
				sb.append(" and TCity.id=? ");
				params.add(parameter.get("id"));
			}

			if(parameter.get("provinceId")!=null){
			    withParameter = true;    
				sb.append(" and TCity.province_id=? ");
				params.add(parameter.get("provinceId"));
			}

			if(parameter.get("name")!=null){
			    withParameter = true;    
				sb.append(" and TCity.name=? ");
				params.add(parameter.get("name"));
			}
		}
		Pagination<TCity> page = new Pagination<TCity>(pageIndex,pageSize);
		if(withParameter){
			this.paginationQuery(sql + sb.toString(),countSql + sb.toString(), params.toArray(), page,new TCityRowMapper());
		}else{
		    this.paginationQuery(sql,countSql ,page,new TCityRowMapper());
		}
		return page;
	}
	
	public Pagination<TCity> getPageAllTCityByBean(TCity tCity, int pageIndex, int pageSize) {
		String sql = "select TCity.id as id ,TCity.province_id as provinceId,TCity.name as name from "+TABLE +" as TCity" +" where 1=1 ";
		String countSql = "select count(*) from "+TABLE +" as TCity" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 

		if(tCity.getId() != null){
			withParameter = true;   
			sb.append(" and TCity.id=? ");
			params.add(tCity.getId());
		}

		if(tCity.getProvinceId() != null){
		    withParameter = true;    
			sb.append(" and TCity.province_id=? ");
			params.add(tCity.getProvinceId());
		}

		if(tCity.getName() != null){
		    withParameter = true;    
			sb.append(" and TCity.name=? ");
			params.add(tCity.getName());
		}

		Pagination<TCity> page = new Pagination<TCity>(pageIndex,pageSize);
		if(withParameter){
			this.paginationQuery(sql + sb.toString(),countSql + sb.toString(), params.toArray(), page,new TCityRowMapper());
		}else{
		    this.paginationQuery(sql,countSql ,page,new TCityRowMapper());
		}
		return page;
	}
	
	public List<TCity> getAllTCity(){
		String sql = "select TCity.id as id ,TCity.province_id as provinceId,TCity.name as name from " + TABLE +" as TCity" ;		
		return this.getJdbcTemplate().query(sql, new TCityRowMapper());
		
	}
	
	public Pagination<TCity> getPageAllTCity(int pageIndex, int pageSize) {
		String sql ="select TCity.id as id ,TCity.province_id as provinceId,TCity.name as name from " + TABLE +" as TCity" ;
		String countSql = "select count(*) from " + TABLE;
		Pagination<TCity> page = new Pagination<TCity>(pageIndex,pageSize);
		this.paginationQuery(sql,countSql, page,new TCityRowMapper());
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