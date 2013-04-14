package com.hlj.tech.kdkj.auto.dao;

import com.hlj.tech.kdkj.common.ParameterCheck;
import com.hlj.tech.kdkj.auto.entities.TStudent;
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
public class TStudentDao extends CoreJdbcDaoSupport {

    private static Logger log = LoggerFactory.getLogger(TStudentDao.class);  

    private static String TABLE = "t_student";

	public Integer insertTStudent(TStudent tStudent) throws Exception {
		String sql = "insert into "+TABLE +"(name,email,birthday)  values(?,?,?)";
		Object args[] = new Object[] { tStudent.getName(),tStudent.getEmail(),tStudent.getBirthday() };
		if(log.isDebugEnabled()){
			log.debug("insertTStudent : SQL IS : " + sql + " : PARAM IS : " + args);
		}
		this.getJdbcTemplate().update(sql, args);		
        return tStudent.getStudentId();
	}

	
	
	public Integer insertTStudentSelective(TStudent tStudent) throws Exception {
		StringBuffer columns = new StringBuffer();
		StringBuffer questions = new StringBuffer(30);
		List<Object> params = new ArrayList<Object>();
		if(ParameterCheck.hasValue(tStudent.getName())){
			params.add(tStudent.getName());
			columns.append(",name");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tStudent.getEmail())){
			params.add(tStudent.getEmail());
			columns.append(",email");
			questions.append(",?");
		}
		if(ParameterCheck.hasValue(tStudent.getBirthday())){
			params.add(tStudent.getBirthday());
			columns.append(",birthday");
			questions.append(",?");
		}
		String sql = "insert into " + TABLE + "(" + columns.toString().substring(1) + ") values(" + questions.toString().substring(1) +")";
		if(log.isDebugEnabled()){
			log.debug("insertTStudentSelective : SQL IS : " + sql + " : PARAM IS : " + params.toArray());
		}
		this.getJdbcTemplate().update(sql, params.toArray());
		return tStudent.getStudentId();
	}
	
	
	
	public void deleteTStudentByStudentId(Integer studentId) throws Exception {
		String sql = "delete from " +TABLE +" where  student_id=?";
		Object args[] = new Object[] {studentId};

		if(log.isDebugEnabled()){
			log.debug("deleteTStudentByStudentId : SQL IS : " + sql + " : PARAM IS : " + args);
		}
		this.getJdbcTemplate().update(sql, args);
	}
	
	
    
	public void deleteTStudentByBean(TStudent tStudent) throws Exception{
		List<Object> params = new ArrayList<Object>();
  		StringBuffer columns = new StringBuffer();
		if(ParameterCheck.hasValue(tStudent.getName())){
			params.add(tStudent.getName());
			columns.append("and name=? ");
		}
		if(ParameterCheck.hasValue(tStudent.getEmail())){
			params.add(tStudent.getEmail());
			columns.append("and email=? ");
		}
		if(ParameterCheck.hasValue(tStudent.getBirthday())){
			params.add(tStudent.getBirthday());
			columns.append("and birthday=? ");
		}

		String sql = "delete from " +TABLE + " where " +columns.toString().substring(4);
		if(log.isDebugEnabled()){
			log.debug("deleteTStudentByBean : SQL IS : " + sql + " : PARAM IS : " + params.toArray());
		}
	    this.getJdbcTemplate().update(sql,params.toArray());
	}
	
	
	
	public void updateTStudent(TStudent tStudent) throws Exception {
		String sql = "update " +TABLE +" set name=?,email=?,birthday=? where  student_id=?";
		Object args[] = new Object[] {tStudent.getName(),tStudent.getEmail(),tStudent.getBirthday(),tStudent.getStudentId()};
		if(log.isDebugEnabled()){
			log.debug("updateTStudent : SQL IS : " + sql + " : PARAM IS : " + args);
		}
		this.getJdbcTemplate().update(sql, args);
	}
	
	
	
	public void updateTStudentSelective(TStudent tStudent) throws Exception {
		List<Object> params = new ArrayList<Object>();
        StringBuffer columns = new StringBuffer();
        String keys = "";
		if(ParameterCheck.hasValue(tStudent.getName())){
			params.add(tStudent.getName());
			columns.append(",name=?");
		}
		if(ParameterCheck.hasValue(tStudent.getEmail())){
			params.add(tStudent.getEmail());
			columns.append(",email=?");
		}
		if(ParameterCheck.hasValue(tStudent.getBirthday())){
			params.add(tStudent.getBirthday());
			columns.append(",birthday=?");
		}

		
		if(ParameterCheck.hasValue(tStudent.getStudentId())){
			params.add(tStudent.getStudentId());
			keys += "and student_id=? ";
		}
		String sql = "update " + TABLE + " set " +columns.toString().substring(1)+" where "+keys.substring(4);
		if(log.isDebugEnabled()){
			log.debug("updateTStudentSelective : SQL IS : " + sql + " : PARAM IS : " + params.toArray());
		}
		this.getJdbcTemplate().update(sql, params.toArray());
	}
	
	
		
	
	public TStudent getTStudentByStudentId(Integer studentId) {
		String sql = "select TStudent.student_id as studentId ,TStudent.name as name,TStudent.email as email,TStudent.birthday as birthday from "+TABLE+" as TStudent where  TStudent.student_id=?";
		if(log.isDebugEnabled()){
			log.debug("getTStudentByStudentId : SQL IS : " + sql + " : PARAM IS : " + studentId);
		}
		List<TStudent> tStudentList = this.getJdbcTemplate().query(sql,new Object[]{studentId}, new TStudentRowMapper());
		return tStudentList.size() > 0 ? tStudentList.get(0) : null;

	}
	
	
	
	public Collection<TStudent> getAllTStudent(Map<String, Object> parameter) {
		String sql = "select TStudent.student_id as studentId ,TStudent.name as name,TStudent.email as email,TStudent.birthday as birthday from "+TABLE +" as TStudent" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
		if(parameter != null){
            if(ParameterCheck.hasValue(parameter.get("studentId"))){
			    withParameter = true;    
				sb.append(" and TStudent.student_id=? ");
				params.add(parameter.get("studentId"));
			}

            if(ParameterCheck.hasValue(parameter.get("name"))){
			    withParameter = true;    
				sb.append(" and TStudent.name=? ");
				params.add(parameter.get("name"));
			}

            if(ParameterCheck.hasValue(parameter.get("email"))){
			    withParameter = true;    
				sb.append(" and TStudent.email=? ");
				params.add(parameter.get("email"));
			}

            if(ParameterCheck.hasValue(parameter.get("birthday"))){
			    withParameter = true;    
				sb.append(" and TStudent.birthday=? ");
				params.add(parameter.get("birthday"));
			}
		}
		if(log.isDebugEnabled()){
			log.debug("getAllTStudent : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
		}
		if(withParameter){
			return this.getJdbcTemplate().query(sql+ sb.toString(),params.toArray(), new TStudentRowMapper());
		}else{
			return this.getJdbcTemplate().query(sql, new TStudentRowMapper());
		}
		
	}
	
	
	
	public Collection<TStudent> getAllTStudentByBean(TStudent tStudent) {
		String sql = "select TStudent.student_id as studentId ,TStudent.name as name,TStudent.email as email,TStudent.birthday as birthday from "+TABLE +" as TStudent" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
            
		if(ParameterCheck.hasValue(tStudent.getStudentId())){
		    withParameter = true;    
			sb.append(" and TStudent.student_id=? ");
			params.add(tStudent.getStudentId());
		}

		if(ParameterCheck.hasValue(tStudent.getName())){
		    withParameter = true;    
			sb.append(" and TStudent.name=? ");
			params.add(tStudent.getName());
		}

		if(ParameterCheck.hasValue(tStudent.getEmail())){
		    withParameter = true;    
			sb.append(" and TStudent.email=? ");
			params.add(tStudent.getEmail());
		}

		if(ParameterCheck.hasValue(tStudent.getBirthday())){
		    withParameter = true;    
			sb.append(" and TStudent.birthday=? ");
			params.add(tStudent.getBirthday());
		}
		if(log.isDebugEnabled()){
			log.debug("getAllTStudentByBean : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
		}
		if(withParameter){
			return this.getJdbcTemplate().query(sql+ sb.toString(),params.toArray(), new TStudentRowMapper());
		}else{
			return this.getJdbcTemplate().query(sql, new TStudentRowMapper());
		}
		
	}
	
	
	
	public Pagination<TStudent> getPageAllTStudentByCondition(Map<String, Object> parameter, int pageIndex, int pageSize) {
		String sql = "select TStudent.student_id as studentId ,TStudent.name as name,TStudent.email as email,TStudent.birthday as birthday from "+TABLE +" as TStudent" +" where 1=1 ";
		String countSql = "select count(*) from "+TABLE +" as TStudent" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 
		if(parameter != null){

            if(ParameterCheck.hasValue(parameter.get("studentId"))){
				withParameter = true;   
				sb.append(" and TStudent.student_id=? ");
				params.add(parameter.get("studentId"));
			}

            if(ParameterCheck.hasValue(parameter.get("name"))){
			    withParameter = true;    
				sb.append(" and TStudent.name=? ");
				params.add(parameter.get("name"));
			}

            if(ParameterCheck.hasValue(parameter.get("email"))){
			    withParameter = true;    
				sb.append(" and TStudent.email=? ");
				params.add(parameter.get("email"));
			}

            if(ParameterCheck.hasValue(parameter.get("birthday"))){
			    withParameter = true;    
				sb.append(" and TStudent.birthday=? ");
				params.add(parameter.get("birthday"));
			}
		}
		Pagination<TStudent> page = new Pagination<TStudent>(pageIndex,pageSize);
		if(log.isDebugEnabled()){
			log.debug("getPageAllTStudentByCondition : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
			log.debug("pageIndex : " + pageIndex + "   pageSize:  " + pageSize);
		}
		if(withParameter){
			this.paginationQuery(sql + sb.toString(),countSql + sb.toString(), params.toArray(), page,new TStudentRowMapper());
		}else{
		    this.paginationQuery(sql,countSql ,page,new TStudentRowMapper());
		}
		return page;
	}
	
	
	
	public Pagination<TStudent> getPageAllTStudentByBean(TStudent tStudent, int pageIndex, int pageSize) {
		String sql = "select TStudent.student_id as studentId ,TStudent.name as name,TStudent.email as email,TStudent.birthday as birthday from "+TABLE +" as TStudent" +" where 1=1 ";
		String countSql = "select count(*) from "+TABLE +" as TStudent" +" where 1=1 ";
		StringBuffer sb = new StringBuffer(" ");
		List<Object> params = new ArrayList<Object>();
		boolean withParameter = false; 

		if(ParameterCheck.hasValue(tStudent.getStudentId())){
			withParameter = true;   
			sb.append(" and TStudent.student_id=? ");
			params.add(tStudent.getStudentId());
		}
        
		if(ParameterCheck.hasValue(tStudent.getName())){
		    withParameter = true;    
			sb.append(" and TStudent.name=? ");
			params.add(tStudent.getName());
		}
        
		if(ParameterCheck.hasValue(tStudent.getEmail())){
		    withParameter = true;    
			sb.append(" and TStudent.email=? ");
			params.add(tStudent.getEmail());
		}
        
		if(ParameterCheck.hasValue(tStudent.getBirthday())){
		    withParameter = true;    
			sb.append(" and TStudent.birthday=? ");
			params.add(tStudent.getBirthday());
		}

		Pagination<TStudent> page = new Pagination<TStudent>(pageIndex,pageSize);
		if(log.isDebugEnabled()){
			log.debug("getPageAllTStudentByBean : SQL IS : " + sql + sb.toString()+ " : PARAM IS : " + params.toArray());
			log.debug("pageIndex : " + pageIndex + "   pageSize:  " + pageSize);
		}
		if(withParameter){
			this.paginationQuery(sql + sb.toString(),countSql + sb.toString(), params.toArray(), page,new TStudentRowMapper());
		}else{
		    this.paginationQuery(sql,countSql ,page,new TStudentRowMapper());
		}
		return page;
	}
	
	
	
	public List<TStudent> getAllTStudent(){
		String sql = "select TStudent.student_id as studentId ,TStudent.name as name,TStudent.email as email,TStudent.birthday as birthday from " + TABLE +" as TStudent" ;			
		return this.getJdbcTemplate().query(sql, new TStudentRowMapper());
		
	}
	
	
	
	public Pagination<TStudent> getPageAllTStudent(int pageIndex, int pageSize) {
		String sql ="select TStudent.student_id as studentId ,TStudent.name as name,TStudent.email as email,TStudent.birthday as birthday from " + TABLE +" as TStudent" ;
		String countSql = "select count(*) from " + TABLE;
		Pagination<TStudent> page = new Pagination<TStudent>(pageIndex,pageSize);
		this.paginationQuery(sql,countSql, page,new TStudentRowMapper());
		return page;
	}
	
	

	public class TStudentRowMapper implements RowMapper<TStudent> {
		public TStudent mapRow(ResultSet rs, int rowNum) throws SQLException {
			TStudent tStudent = new TStudent();
        	tStudent.setStudentId(rs.getInt("studentId"));
			tStudent.setName(rs.getString("name"));
			tStudent.setEmail(rs.getString("email"));
			tStudent.setBirthday(rs.getDate("birthday"));
			return tStudent;
		}
	}
}