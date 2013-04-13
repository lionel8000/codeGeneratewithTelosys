/**
   BNAME                    : bean name with first letter Upcase
   BNAME_V                  : bean name with first letter LowerCase
   BNAME_DAO and BNAME_DAO_V   has relative same meaning for the BNAME
   KEYS                     : all keys concated with first letter Upcase
   KEYS_PAR                 : all keys with declare type
   KEYS_PAR_NODECLARE       : all keys with no declare type use as parameter
*/



package com.hlj.tech.kdkj.auto.dao;

import com.hlj.tech.kdkj.auto.entities.BdfEnums;
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
public class BdfEnumsDao extends CoreJdbcDaoSupport {
    private static String TABLE = "bdf_enums";
	public String insertBdfEnums(BdfEnums bdfEnums) throws Exception {
		String sql = "insert into "+TABLE +"(ID_,NAME_,DESC_,CATEGORY_ID_,CREATE_USER_,UPDATE_USER_,CREATE_DATE_,UPDATE_DATE_,MEMO_)  values(?,?,?,?,?,?,?,?,?)";
		Object args[] = new Object[] { bdfEnums.getId(),bdfEnums.getName(),bdfEnums.getDesc(),bdfEnums.getCategoryId(),bdfEnums.getCreateUser(),bdfEnums.getUpdateUser(),bdfEnums.getCreateDate(),bdfEnums.getUpdateDate(),bdfEnums.getMemo() };
		this.getJdbcTemplate().update(sql, args);
        return bdfEnums.getId();
	}
	
	
	public void deleteBdfEnumsById(String id) throws Exception {
		String sql = "delete from " +TABLE +" where  ID_=?";
		this.getJdbcTemplate().update(sql, new Object[] { id });
	}
	



	public void updateBdfEnums(BdfEnums bdfEnums) throws Exception {
		String sql = "update " +TABLE +" set NAME_=?,DESC_=?,CATEGORY_ID_=?,CREATE_USER_=?,UPDATE_USER_=?,CREATE_DATE_=?,UPDATE_DATE_=?,MEMO_=? where  ID_=?";
		Object args[] = new Object[] {bdfEnums.getName(),bdfEnums.getDesc(),bdfEnums.getCategoryId(),bdfEnums.getCreateUser(),bdfEnums.getUpdateUser(),bdfEnums.getCreateDate(),bdfEnums.getUpdateDate(),bdfEnums.getMemo(),bdfEnums.getId()};
		this.getJdbcTemplate().update(sql, args);
	}
	
	
	
	
	public BdfEnums getBdfEnumsById(String id) {
		String sql = "select ID_ ,NAME_,DESC_,CATEGORY_ID_,CREATE_USER_,UPDATE_USER_,CREATE_DATE_,UPDATE_DATE_,MEMO_ from "+TABLE+" where  ID_=?";
		List<BdfEnums> bdfEnumsList = this.getJdbcTemplate().query(sql,new Object[]{id}, new BdfEnumsRowMapper());
		return bdfEnumsList.size() > 0 ? bdfEnumsList.get(0) : null;

	}
	
	public List<BdfEnums> getAllBdfEnums(){
		String sql = "select ID_ ,NAME_,DESC_,CATEGORY_ID_,CREATE_USER_,UPDATE_USER_,CREATE_DATE_,UPDATE_DATE_,MEMO_ from " + TABLE;		
		return this.getJdbcTemplate().query(sql, new BdfEnumsRowMapper());
		
	}

	public Collection<BdfEnums> getAllBdfEnums(Map<String, Object> parameter) {
		String sql = "select ID_ ,NAME_,DESC_,CATEGORY_ID_,CREATE_USER_,UPDATE_USER_,CREATE_DATE_,UPDATE_DATE_,MEMO_ from "+TABLE+" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
		if(parameter != null){
	            
			if(parameter.get("id")!=null){
			    withParameter = true;    
				sb.append(" and ID_=? ");
				params.add(parameter.get("id"));
			}
            	
			if(parameter.get("name")!=null){
			    withParameter = true;    
				sb.append(" and NAME_=? ");
				params.add(parameter.get("name"));
			}

			if(parameter.get("desc")!=null){
			    withParameter = true;    
				sb.append(" and DESC_=? ");
				params.add(parameter.get("desc"));
			}

			if(parameter.get("categoryId")!=null){
			    withParameter = true;    
				sb.append(" and CATEGORY_ID_=? ");
				params.add(parameter.get("categoryId"));
			}

			if(parameter.get("createUser")!=null){
			    withParameter = true;    
				sb.append(" and CREATE_USER_=? ");
				params.add(parameter.get("createUser"));
			}

			if(parameter.get("updateUser")!=null){
			    withParameter = true;    
				sb.append(" and UPDATE_USER_=? ");
				params.add(parameter.get("updateUser"));
			}

			if(parameter.get("createDate")!=null){
			    withParameter = true;    
				sb.append(" and CREATE_DATE_=? ");
				params.add(parameter.get("createDate"));
			}

			if(parameter.get("updateDate")!=null){
			    withParameter = true;    
				sb.append(" and UPDATE_DATE_=? ");
				params.add(parameter.get("updateDate"));
			}

			if(parameter.get("memo")!=null){
			    withParameter = true;    
				sb.append(" and MEMO_=? ");
				params.add(parameter.get("memo"));
			}
		}
		if(withParameter){
			return this.getJdbcTemplate().query(sql+ sb.toString(),params.toArray(), new BdfEnumsRowMapper());
		}else{
			return this.getJdbcTemplate().query(sql, new BdfEnumsRowMapper());
		}
		
	}
	
	
	public Pagination<BdfEnums> getPageAllBdfEnumsByCondition(Map<String, Object> parameter, int pageIndex, int pageSize) {
		String sql = "select ID_ ,NAME_,DESC_,CATEGORY_ID_,CREATE_USER_,UPDATE_USER_,CREATE_DATE_,UPDATE_DATE_,MEMO_ from "+TABLE+" where 1=1 ";
		String countSql = "select count(*) from "+TABLE+" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
		if(parameter != null){
	
			if(parameter.get("id")!=null){
				withParameter = true;   
				sb.append(" and ID_=? ");
				params.add(parameter.get("id"));
			}
            	
			if(parameter.get("name")!=null){
			    withParameter = true;    
				sb.append(" and NAME_=? ");
				params.add(parameter.get("name"));
			}

			if(parameter.get("desc")!=null){
			    withParameter = true;    
				sb.append(" and DESC_=? ");
				params.add(parameter.get("desc"));
			}

			if(parameter.get("categoryId")!=null){
			    withParameter = true;    
				sb.append(" and CATEGORY_ID_=? ");
				params.add(parameter.get("categoryId"));
			}

			if(parameter.get("createUser")!=null){
			    withParameter = true;    
				sb.append(" and CREATE_USER_=? ");
				params.add(parameter.get("createUser"));
			}

			if(parameter.get("updateUser")!=null){
			    withParameter = true;    
				sb.append(" and UPDATE_USER_=? ");
				params.add(parameter.get("updateUser"));
			}

			if(parameter.get("createDate")!=null){
			    withParameter = true;    
				sb.append(" and CREATE_DATE_=? ");
				params.add(parameter.get("createDate"));
			}

			if(parameter.get("updateDate")!=null){
			    withParameter = true;    
				sb.append(" and UPDATE_DATE_=? ");
				params.add(parameter.get("updateDate"));
			}

			if(parameter.get("memo")!=null){
			    withParameter = true;    
				sb.append(" and MEMO_=? ");
				params.add(parameter.get("memo"));
			}
		}
		Pagination<BdfEnums> page = new Pagination<BdfEnums>(pageIndex,pageSize);
		if(withParameter){
			this.paginationQuery(sql + sb.toString(),countSql + sb.toString(), params.toArray(), page,new BdfEnumsRowMapper());
		}else{
		    this.paginationQuery(sql,countSql ,page,new BdfEnumsRowMapper());
		}
		return page;
	}
	
	
	public Pagination<BdfEnums> getPageAllBdfEnums(int pageIndex, int pageSize) {
		String sql ="select ID_ ,NAME_,DESC_,CATEGORY_ID_,CREATE_USER_,UPDATE_USER_,CREATE_DATE_,UPDATE_DATE_,MEMO_ from " + TABLE;
		String countSql = "select count(*) from " + TABLE;
		Pagination<BdfEnums> page = new Pagination<BdfEnums>(pageIndex,pageSize);
		this.paginationQuery(sql,countSql,new Object[]{}, page,	new BdfEnumsRowMapper());
		return page;
	}

	public class BdfEnumsRowMapper implements RowMapper<BdfEnums> {
		public BdfEnums mapRow(ResultSet rs, int rowNum) throws SQLException {
			BdfEnums bdfEnums = new BdfEnums();
        	bdfEnums.setId(rs.getString("ID_"));
			bdfEnums.setName(rs.getString("NAME_"));
			bdfEnums.setDesc(rs.getString("DESC_"));
			bdfEnums.setCategoryId(rs.getString("CATEGORY_ID_"));
			bdfEnums.setCreateUser(rs.getString("CREATE_USER_"));
			bdfEnums.setUpdateUser(rs.getString("UPDATE_USER_"));
			bdfEnums.setCreateDate(rs.getDate("CREATE_DATE_"));
			bdfEnums.setUpdateDate(rs.getDate("UPDATE_DATE_"));
			bdfEnums.setMemo(rs.getString("MEMO_"));
			return bdfEnums;
		}
	}
}