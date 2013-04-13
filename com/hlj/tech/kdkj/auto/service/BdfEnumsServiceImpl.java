
package com.hlj.tech.kdkj.auto.service ;

import com.hlj.tech.kdkj.auto.dao.BdfEnumsDao;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import com.hlj.tech.kdkj.auto.entities.BdfEnums;
import com.bstek.bdf.pagination.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;


@Component
public class BdfEnumsServiceImpl implements BdfEnumsService{
        
    @Resource
	BdfEnumsDao bdfEnumsDao;

	public String insertBdfEnums(BdfEnums bdfEnums) throws Exception{
	    return bdfEnumsDao.insertBdfEnums(bdfEnums);
	}

	public void deleteBdfEnumsById(String id) throws Exception{
		bdfEnumsDao.deleteBdfEnumsById(id);
	}

	public void updateBdfEnums(BdfEnums bdfEnums) throws Exception{
		bdfEnumsDao.updateBdfEnums(bdfEnums);
	}

	
	
	public BdfEnums getBdfEnumsById(String id){
		return bdfEnumsDao.getBdfEnumsById(id);
	}

	public List<BdfEnums> getAllBdfEnums(){
		return bdfEnumsDao.getAllBdfEnums();
	}

	public Collection<BdfEnums> getAllBdfEnums(Map<String, Object> parameter){
		return bdfEnumsDao.getAllBdfEnums(parameter);
	}

	public Pagination<BdfEnums> getPageAllBdfEnumsByCondition(Map<String, Object> map, int pageIndex,int pageSize){
		return bdfEnumsDao.getPageAllBdfEnumsByCondition(map,pageIndex,pageSize);	
	}

	public Pagination<BdfEnums> getPageAllBdfEnums(int pageIndex,int pageSize){
		return bdfEnumsDao.getPageAllBdfEnums(pageIndex,pageSize);
	}

}
