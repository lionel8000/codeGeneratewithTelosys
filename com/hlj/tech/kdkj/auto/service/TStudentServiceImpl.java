package com.hlj.tech.kdkj.auto.service ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.hlj.tech.kdkj.auto.dao.TStudentDao;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import com.hlj.tech.kdkj.auto.entities.TStudent;
import com.bstek.bdf.pagination.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class TStudentServiceImpl implements TStudentService{

    private static Logger log = LoggerFactory.getLogger(TStudentServiceImpl.class);    

    @Resource
	TStudentDao tStudentDao;

	public Integer insertTStudent(TStudent tStudent) throws Exception{
	    return tStudentDao.insertTStudent(tStudent);
	}
    
	public Integer insertTStudentSelective(TStudent tStudent) throws Exception {
	    return tStudentDao.insertTStudentSelective(tStudent);
	}
	
	public void deleteTStudentByStudentId(Integer studentId) throws Exception{
		tStudentDao.deleteTStudentByStudentId(studentId);
	}

	public void deleteTStudentByBean(TStudent tStudent) throws Exception{
		tStudentDao.deleteTStudentByBean(tStudent);
	}	
	
	public void updateTStudent(TStudent tStudent) throws Exception{
		tStudentDao.updateTStudent(tStudent);
	}

  	public void updateTStudentSelective(TStudent tStudent) throws Exception {
	    tStudentDao.updateTStudentSelective(tStudent);
    }
	
	public TStudent getTStudentByStudentId(Integer studentId){
		return tStudentDao.getTStudentByStudentId(studentId);
	}

	public List<TStudent> getAllTStudent(){
		return tStudentDao.getAllTStudent();
	}

	public Collection<TStudent> getAllTStudent(Map<String, Object> parameter){
		return tStudentDao.getAllTStudent(parameter);
	}
    
	public Collection<TStudent> getAllTStudentByBean(TStudent tStudent) {
		return tStudentDao.getAllTStudentByBean(tStudent);
	}

	
	public Pagination<TStudent> getPageAllTStudentByCondition(Map<String, Object> map, int pageIndex,int pageSize){
		return tStudentDao.getPageAllTStudentByCondition(map,pageIndex,pageSize);	
	}
    
	public Pagination<TStudent> getPageAllTStudentByBean(TStudent tStudent, int pageIndex, int pageSize) {
		return tStudentDao.getPageAllTStudentByBean(tStudent,pageIndex,pageSize);	
	}

	
	public Pagination<TStudent> getPageAllTStudent(int pageIndex,int pageSize){
		return tStudentDao.getPageAllTStudent(pageIndex,pageSize);
	}

}
