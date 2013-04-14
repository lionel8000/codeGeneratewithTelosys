package com.hlj.tech.kdkj.auto.service ;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.hlj.tech.kdkj.auto.entities.TStudent;
import com.bstek.bdf.pagination.Pagination;

public interface TStudentService {

	public Integer insertTStudent(TStudent tStudent) throws Exception;

	public Integer insertTStudentSelective(TStudent tStudent) throws Exception;

	public void deleteTStudentByStudentId(Integer studentId) throws Exception;
	
	public void deleteTStudentByBean(TStudent tStudent) throws Exception;

	public void updateTStudent(TStudent tStudent) throws Exception;

   	public void updateTStudentSelective(TStudent tStudent) throws Exception;
  	
	public TStudent getTStudentByStudentId(Integer studentId);

	public List<TStudent> getAllTStudent();

	public Collection<TStudent> getAllTStudent(	Map<String, Object> parameter);

	public Collection<TStudent> getAllTStudentByBean(TStudent tStudent);

	public Pagination<TStudent> getPageAllTStudentByCondition(Map<String, Object> map,int pageIndex,int pageSize);

	public Pagination<TStudent> getPageAllTStudentByBean(TStudent tStudent, int pageIndex, int pageSize);

	public Pagination<TStudent> getPageAllTStudent(int pageIndex,int pageSize);

}
