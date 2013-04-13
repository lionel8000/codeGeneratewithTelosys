


package com.hlj.tech.kdkj.auto.service ;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.hlj.tech.kdkj.auto.entities.BdfEnums;
import com.bstek.bdf.pagination.Pagination;

/**
* ?б└???????ии??
*/
public interface BdfEnumsService {

	public String insertBdfEnums(BdfEnums bdfEnums) throws Exception;

	public void deleteBdfEnumsById(String id) throws Exception;

	public void updateBdfEnums(BdfEnums bdfEnums) throws Exception;
		
	public BdfEnums getBdfEnumsById(String id);

	public List<BdfEnums> getAllBdfEnums();

	public Collection<BdfEnums> getAllBdfEnums(	Map<String, Object> parameter);

	public Pagination<BdfEnums> getPageAllBdfEnumsByCondition(Map<String, Object> map,int pageIndex,int pageSize);

	public Pagination<BdfEnums> getPageAllBdfEnums(int pageIndex,int pageSize);


}
