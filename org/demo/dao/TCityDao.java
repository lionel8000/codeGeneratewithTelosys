//-----------------------------------------------------------
// This is a generated class. Avoid customizing code here !
// Generated by Telosys Tools Generator - version : 2.0.3
// Date : 12 ���� 2013 - Time 22:36:12
//-----------------------------------------------------------
// This class was generated by the standard template
// Template name    : vo_dao.vm
// Template author  : Laurent GUERIN 
// Template version : 1.0.0 ( February 20 - 2009 ) 
//-----------------------------------------------------------
// With AutoIncremented KEY management
//-----------------------------------------------------------

package org.demo.dao ;

import java.sql.Connection;
import java.util.List;

import org.objectweb.telosys.common.TelosysException;
import org.objectweb.telosys.dal.dao.DatabaseSession;
import org.objectweb.telosys.dal.dao.ListQuery;
import org.objectweb.telosys.dal.dao.QueryContext;
import org.objectweb.telosys.dal.dao.SqlRequests;
import org.objectweb.telosys.dal.dao.StandardDAO;

import com.hlj.tech.kdkj.auto.entities.TCity;

/**
 * D.A.O. for entity table t_city
 * 
 *
 * @author TELOSYS-GENERATOR
 *
 */
public class TCityDAO extends StandardDAO
{
    private final static String      TABLE          = "t_city";

    private final static String      KEY_COLUMNS[]  = { "id" };

    private final static String      DATA_COLUMNS[] = { "province_id", "name" };

    //--- Auto-incremented primary key : "id"
    private final static SqlRequests SQL_REQUESTS   = new SqlRequests(TABLE, KEY_COLUMNS, DATA_COLUMNS, "id");

    /**
     *  Constructs a DAO for the Value Object TCity
     */
    public TCityDAO()
    {
        super(TCity.class, SQL_REQUESTS );
    }
  
    //============================================================================
    // ABSTRACT METHODS IMPLEMENTATION : callback methods (called from super class)
    //============================================================================

    //============================================================================
    // Set the Primary Key parameters from the VO Bean values ( for SELECT & DELETE )
    //============================================================================
    protected void setPrimaryKey( QueryContext queryContext, Object entity ) throws TelosysException
    {
        TCity vo = (TCity) entity ;
        int i = 0;
        //--- Set the SQL WHERE criteria ( Primary Key columns )
        queryContext.setParamShort(++i, vo.getId()); // short : id
    }
  
    //============================================================================
    // Mapping : from SQL Table (ResultSet) to VO Bean ( for LOAD/SELECT )
    //============================================================================
    protected int tableToBean( QueryContext queryContext, Object entity ) throws TelosysException
    {
        TCity vo = (TCity) entity ;
        int i = 0;
        //--- Data ( without the Primary Key )
        vo.setProvinceId( queryContext.getResultShortObject(++i) ); // java.lang.Short : province_id
        vo.setName( queryContext.getResultString(++i) ); // java.lang.String : name
        //--- Primary Key 
        vo.setId( queryContext.getResultShort(++i) ); // short : id
        //--- Return columns count
        return i ;
    }
  
    //============================================================================
    // Mapping : from SQL Table (ResultSet) to VO Bean 
    //============================================================================
    protected int beanToTable (QueryContext queryContext, Object entity ) throws TelosysException
    {
        TCity vo = (TCity) entity ;
        int i = 0;
        //--- Data ( without the Primary Key )
        queryContext.setParamShort(++i, vo.getProvinceId()); // java.lang.Short : province_id
        queryContext.setParamString(++i, vo.getName()); // java.lang.String : name
        //--- Primary Key 
        queryContext.setParamShort(++i, vo.getId()); // short : id
        //--- Return columns count
        return i ;
    }

    //============================================================================
    // Special mapping for tables with auto-incremented Primary Key ( for INSERT )
    //============================================================================
    protected int beanToTableWithoutAutoInc (QueryContext queryContext, Object entity ) throws TelosysException
    {
        TCity vo = (TCity) entity ;
        int i = 0;
        //--- Data ( without the Primary Key )
        queryContext.setParamShort(++i, vo.getProvinceId()); // java.lang.Short : province_id
        queryContext.setParamString(++i, vo.getName()); // java.lang.String : name
        //--- Primary Key not set in the SQL REQUEST 
        // Column : id
        //--- Return columns count
        return i ;
    }

    //============================================================================
    //  EXISTS
    //============================================================================
    /**
     * Tests if the Primary Key of the given Value Object exists in the database, <br>
     * using the default database
     * @param vo : the Value Object containing the Primary Key
     * @return : true if the primary key exists (else false)
     * @throws TelosysException
     */
    public boolean exists( TCity vo) throws TelosysException
    {
        return super.doExists(vo);
    }
    
    /**
     * Tests if the Primary Key of the given Value Object exists in the database, <br>
     * using a specific database id  
     * @param vo : the Value Object containing the Primary Key
     * @param dbId : the database id to use
     * @return : true if the primary key exists (else false)
     * @throws TelosysException
     */
    public boolean exists( TCity vo, int dbId ) throws TelosysException
    {
        return super.doExists(vo, dbId);
    }
    
    /**
     * Tests if the Primary Key of the given Value Object exists in the database, <br>
     * using a specific database connection  
     * @param vo : the Value Object containing the Primary Key
     * @param con : the connection to use
     * @return : true if the primary key exists (else false)
     * @throws TelosysException
     */
    public boolean exists( TCity vo, Connection con) throws TelosysException
    {
        return super.doExists(vo, con);
    }
    
    /**
     * Tests if the Primary Key of the given Value Object exists in the database, <br>
     * using a specific database session  
     * @param vo : the Value Object containing the Primary Key
     * @param dbSession : the database session to use
     * @return : true if the primary key exists (else false)
     * @throws TelosysException
     */
    public boolean exists( TCity vo, DatabaseSession dbSession) throws TelosysException
    {
        return super.doExists(vo, dbSession);
    }

    //============================================================================
    //  LOAD
    //============================================================================
    /**
     * Loads an single Value Object from the database ( with SQL select )<br>
     * using the default database
     * @param  vo  : the Value Object to load
     * @return The number of bean loaded ( 1 or 0 if not found )
     * @throws TelosysException
     */
    public int load( TCity vo) throws TelosysException
    {
        return super.doLoad(vo);
    }

    /**
     * Loads an single Value Object from the database ( with SQL select )<br>
     * with an optional SQL Select Clause ( ie "FOR UPDATE" ) <br>
     * using the default database
     * @param  vo  : the Value Object to load
     * @param  optionalClause : the optional clause ( ie "FOR UPDATE" )
     * @return The number of bean loaded ( 1 or 0 if not found )
     * @throws TelosysException
     */
    public int load( TCity vo, String optionalClause) throws TelosysException
    {
        return super.doLoad(vo, optionalClause);
    }

    //------------------------------------------------------------------------------
    
    /**
     * Loads a single Value Object from the database ( with SQL select ) <br>
     * using a specific database id  
     * @param  vo  : the Value Object to load
     * @param  dbId : the database id to use
     * @return The number of bean loaded ( 1 or 0 if not found )
     * @throws TelosysException
     */
    public int load( TCity vo, int dbId ) throws TelosysException
    {
        return super.doLoad(vo, dbId);
    }
  
    /**
     * Loads a single Value Object from the database ( with SQL select ) <br>
     * with an optional SQL Select Clause ( ie "FOR UPDATE" ) <br>
     * using a specific database id  
     * @param  vo  : the Value Object to load
     * @param  optionalClause : the optional clause ( ie "FOR UPDATE" )
     * @param  dbId : the database id to use
     * @return The number of bean loaded ( 1 or 0 if not found )
     * @throws TelosysException
     */
    public int load( TCity vo, String optionalClause, int dbId ) throws TelosysException
    {
        return super.doLoad(vo, optionalClause, dbId);
    }
  
    //------------------------------------------------------------------------------
    
    /**
     * Loads a single Value Object from the database ( with SQL select ) <br>
     * using a specific database connection  
     * @param  vo  : the Value Object to load
     * @param  con : the connection to use
     * @return The number of bean loaded ( 1 or 0 if not found )
     * @throws TelosysException
     */
    public int load( TCity vo, Connection con) throws TelosysException
    {
        return super.doLoad(vo, con);
    }

    /**
     * Loads a single Value Object from the database ( with SQL select ) <br>
     * with an optional SQL Select Clause ( ie "FOR UPDATE" ) <br>
     * using a specific database connection  
     * @param  vo  : the Value Object to load
     * @param  optionalClause : the optional clause ( ie "FOR UPDATE" )
     * @param  con : the connection to use
     * @return The number of bean loaded ( 1 or 0 if not found )
     * @throws TelosysException
     */
    public int load( TCity vo, String optionalClause, Connection con) throws TelosysException
    {
        return super.doLoad(vo, optionalClause, con);
    }
  
    //------------------------------------------------------------------------------
    
    /**
     * Loads a single Value Object from the database ( with SQL select ) <br>
     * using a specific database session  
     * @param  vo  : the Value Object to load
     * @param  dbSession : the database session to use
     * @return The number of bean loaded ( 1 or 0 if not found )
     * @throws TelosysException
     */
    public int load( TCity vo, DatabaseSession dbSession) throws TelosysException
    {
        return super.doLoad(vo, dbSession);
    }
  
    /**
     * Loads a single Value Object from the database ( with SQL select ) <br>
     * with an optional SQL Select Clause ( ie "FOR UPDATE" ) <br>
     * using a specific database session  
     * @param  vo  : the Value Object to load
     * @param  optionalClause : the optional clause ( ie "FOR UPDATE" )
     * @param  dbSession : the database session to use
     * @return The number of bean loaded ( 1 or 0 if not found )
     * @throws TelosysException
     */
    public int load( TCity vo, String optionalClause, DatabaseSession dbSession) throws TelosysException
    {
        return super.doLoad(vo, optionalClause, dbSession);
    }
  
    //============================================================================
    //  SAVE
    //============================================================================
    /**
     * Saves a single Value Object in the database ( with SQL insert or update )<br>
     * using the default database
     * @param  vo : the Value Object to save
     * @return the JDBC return value ( number of rows that were affected ) : allways 1
     * @throws TelosysException
     */
    public int save( TCity vo) throws TelosysException
    {
        return super.doSave(vo);
    }
  
    /**
     * Saves a single Value Object in the database ( with SQL insert or update ) <br>
     * using a specific database id
     * @param  vo : the Value Object to save
     * @param  dbId : the database Id to use
     * @return the JDBC return value ( number of rows that were affected ) : allways 1
     * @throws TelosysException
     */
    public int save( TCity vo, int dbId) throws TelosysException
    {
        return super.doSave(vo, dbId);
    }
  
    /**
     * Saves a single Value Object in the database ( with SQL insert or update ) <br>
     * using a specific database connection
     * @param  vo : the Value Object to save
     * @param  con : the connection to use
     * @return the JDBC return value ( number of rows that were affected ) : allways 1
     * @throws TelosysException
     */
    public int save( TCity vo, Connection con) throws TelosysException
    {
        return super.doSave(vo, con);
    }
  
    /**
     * Saves a single Value Object in the database ( with SQL insert or update ) <br>
     * using a specific database session
     * @param  vo : the Value Object to save
     * @param  dbSession : the database session to use
     * @return the JDBC return value ( number of rows that were affected ) : allways 1
     * @throws TelosysException
     */
    public int save( TCity vo, DatabaseSession session) throws TelosysException
    {
        return super.doSave(vo, session);
    }
  
    //============================================================================
    //  INSERT
    //============================================================================
    private void setAutoIncrementedKey( TCity vo, Long key) 
    {
        vo.setId( key.shortValue() );
    }
	
    /**
     * Inserts a single Value Object in the database ( with SQL insert )<br>
     * using the default database
     * @param  vo : the Value Object to insert
     * @return the JDBC return value ( number of rows that were affected )
     * @throws TelosysException
     */
    public int insert( TCity vo) throws TelosysException
    {
        Long key = super.doInsertKeyGen(vo);
        setAutoIncrementedKey(vo, key);
        return 1 ;		
    }
  
    /**
     * Inserts a single Value Object in the database ( with SQL insert ) <br>
     * using a specific database id
     * @param  vo : the Value Object to insert
     * @param  dbId : the database id to use
     * @return the JDBC return value ( number of rows that were affected )
     * @throws TelosysException
     */
    public int insert( TCity vo, int dbId ) throws TelosysException
    {
        Long key = super.doInsertKeyGen(vo, dbId);
        setAutoIncrementedKey(vo, key);
        return 1 ;
    }
    
    /**
     * Inserts a single Value Object in the database ( with SQL insert ) <br>
     * using a specific database connection
     * @param  vo : the Value Object to insert
     * @param  con : the connection to use
     * @return the JDBC return value ( number of rows that were affected )
     * @throws TelosysException
     */
    public int insert( TCity vo, Connection con) throws TelosysException
    {
        Long key = super.doInsertKeyGen(vo, con);
        setAutoIncrementedKey(vo, key);
        return 1 ;
    }
     
    /**
     * Inserts a single Value Object in the database ( with SQL insert ) <br>
     * using a specific database session
     * @param  vo : the Value Object to insert
     * @param  dbSession : the database session to use
     * @return the JDBC return value ( number of rows that were affected )
     * @throws TelosysException
     */
    public int insert( TCity vo, DatabaseSession dbSession) throws TelosysException
    {
        Long key = super.doInsertKeyGen(vo, dbSession);
        setAutoIncrementedKey(vo, key);
        return 1 ;
    }

    //============================================================================
    //  INSERT WITH KEY GENERATION
    //============================================================================
    /**
     * Inserts a single Value Object in the database ( with SQL insert ) <br>
     * using the default database
     * and returns the value of the auto-generated key 
     * @param  vo : the Value Object to insert
     * @return the generated key ( wrapped in a Long object ) or null if none
     * @throws TelosysException
     */
    public Long insertKeyGen( TCity vo) throws TelosysException
    {
        return super.doInsertKeyGen(vo);
    }
  
    /**
     * Inserts a single Value Object in the database ( with SQL insert ) <br>
     * using a specific database id
     * and returns the value of the auto-generated key 
     * @param  vo : the Value Object to insert
     * @param  dbId : the database id to use
     * @return the generated key ( wrapped in a Long object ) or null if none
     * @throws TelosysException
     */
    public Long insertKeyGen( TCity vo, int dbId ) throws TelosysException
    {
        return super.doInsertKeyGen(vo, dbId);
    }
    
    /**
     * Inserts a single Value Object in the database ( with SQL insert ) <br>
     * using a specific database connection
     * and returns the value of the auto-generated key 
     * @param  vo : the Value Object to insert
     * @param  con : the connection to use
     * @return the generated key ( wrapped in a Long object ) or null if none
     * @throws TelosysException
     */
    public Long insertKeyGen( TCity vo, Connection con) throws TelosysException
    {
        return super.doInsertKeyGen(vo, con);
    }
     
    /**
     * Inserts a single Value Object in the database ( with SQL insert ) <br>
     * using a specific database session
     * and returns the value of the auto-generated key 
     * @param  vo : the Value Object to insert
     * @param  dbSession : the database session to use
     * @return the generated key ( wrapped in a Long object ) or null if none
     * @throws TelosysException
     */
    public Long insertKeyGen( TCity vo, DatabaseSession dbSession) throws TelosysException
    {
        return super.doInsertKeyGen(vo, dbSession);
    }
    
    //============================================================================
    //  UPDATE
    //============================================================================
    /**
     * Updates a single Value Object in the database ( with SQL update )<br>
     * using the default database
     * @param  vo : the Value Object to update
     * @return the JDBC return value ( number of rows that were affected )
     * @throws TelosysException
     */
    public int update( TCity vo) throws TelosysException
    {
        return super.doUpdate(vo); 
    }
    
    /**
     * Updates a single Value Object in the database ( with SQL update )<br>
     * using a specific database id
     * @param  vo : the Value Object to update
     * @param  dbId : the database id to use
     * @return the JDBC return value ( number of rows that were affected )
     * @throws TelosysException
     */
    public int update( TCity vo, int dbId) throws TelosysException
    {
        return super.doUpdate(vo, dbId); 
    }
    
    /**
     * Updates a single Value Object in the database ( with SQL update ) <br>
     * using a specific database connection
     * @param  vo : the Value Object to update
     * @param  con : the database connection to use
     * @return the JDBC return value ( number of rows that were affected )
     * @throws TelosysException
     */
    public int update( TCity vo, Connection con) throws TelosysException
    {
        return super.doUpdate(vo, con);
    }
    
    /**
     * Updates a single Value Object in the database ( with SQL update ) <br>
     * using a specific database session
     * @param  vo : the Value Object to update
     * @param  dbSession : the database session to use
     * @return the JDBC return value ( number of rows that were affected )
     * @throws TelosysException
     */
    public int update( TCity vo, DatabaseSession dbSession) throws TelosysException
    {
        return super.doUpdate(vo, dbSession);
    }

    //============================================================================
    //  DELETE
    //============================================================================
    /**
     * Deletes a single Value Object in the database ( with SQL delete ) <br>
     * using the default database
     * @param  vo : the Value Object to delete
     * @return the JDBC return value ( number of rows that were affected )
     * @throws TelosysException
     */
    public int delete( TCity vo) throws TelosysException
    {
        return super.doDelete(vo);
    }
  
    /**
     * Deletes a single Value Object in the database ( with SQL delete ) <br>
     * using a specific database id
     * @param  vo : the Value Object to delete
     * @param  dbId : the database id to use
     * @return the JDBC return value ( number of rows that were affected )
     * @throws TelosysException
     */
    public int delete(TCity vo, int dbId) throws TelosysException
    {
        return super.doDelete(vo, dbId); 
    }
  
    /**
     * Deletes a single Value Object in the database ( with SQL delete ) <br>
     * using a specific database connection
     * @param  vo : the Value Object to delete
     * @param  con : the database connection to use
     * @return the JDBC return value ( number of rows that were affected )
     * @throws TelosysException
     */
    public int delete(TCity vo, Connection con) throws TelosysException
    {
        return super.doDelete(vo, con); 
    }
  
    /**
     * Deletes a single Value Object in the database ( with SQL delete ) <br>
     * using a specific database session
     * @param  vo : the Value Object to delete
     * @param  dbSession : the database session to use
     * @return the JDBC return value ( number of rows that were affected )
     * @throws TelosysException
     */
    public int delete(TCity vo, DatabaseSession dbSession) throws TelosysException
    {
        return super.doDelete(vo, dbSession); 
    }

    //============================================================================
    //   LOAD LIST ( SELECT )
    //============================================================================
    /**
     * Loads a list of Value Objects according with the given query <br>
     * using the default database
     * @param query
     * @param list
     * @return
     * @throws TelosysException
     */
    public int loadList(ListQuery query, TCityList list) throws TelosysException
    {
        return super.doLoadList(query, list);
    }

    /**
     * Loads a list of Value Objects according with the given query <br>
     * using a specific database id
     * @param query
     * @param list
     * @param dbId
     * @return
     * @throws TelosysException
     */
    public int loadList(ListQuery query, TCityList list, int dbId) throws TelosysException
    {
        return super.doLoadList(query, list, dbId);
    }
    
    /**
     * Loads a list of Value Objects according with the given query <br>
     * using a specific database connection
     * @param query
     * @param list
     * @param dbConnection
     * @return
     * @throws TelosysException
     */
    public int loadList(ListQuery query, TCityList list, Connection dbConnection) throws TelosysException
    {
        return super.doLoadList(query, list, dbConnection);
    }
    
    /**
     * Loads a list of Value Objects according with the given query <br>
     * using a specific database session
     * @param query
     * @param list
     * @param dbSession
     * @return
     * @throws TelosysException
     */
    public int loadList(ListQuery query, TCityList list, DatabaseSession dbSession) throws TelosysException
    {
        return super.doLoadList(query, list, dbSession);
    }

    //============================================================================
    //   SAVE LIST ( DELETE ALL + INSERT ALL )
    //============================================================================
    /**
     * Saves a list of Value Objects by deleting all the existing items (according with the given query) <br>
     * and inserting all the items of the given list <br>
     * using the default database
     * @param query
     * @param list
     * @return
     * @throws TelosysException
     */
    public int saveList(ListQuery query, TCityList list) throws TelosysException
    {
        return super.doSaveList(query, list);
    }
    
    /**
     * Saves a list of Value Objects by deleting all the existing items (according with the given query) <br>
     * and inserting all the items of the given list <br>
     * using a specific database id  
     * @param query
     * @param list
     * @param dbId
     * @return
     * @throws TelosysException
     */
    public int saveList(ListQuery query, TCityList list, int dbId) throws TelosysException
    {
        return super.doSaveList(query, list, dbId);
    }
    
    /**
     * Saves a list of Value Objects by deleting all the existing items (according with the given query) <br>
     * and inserting all the items of the given list <br>
     * using a specific database connection  
     * @param query
     * @param list
     * @param dbConnection
     * @return
     * @throws TelosysException
     */
    public int saveList(ListQuery query, TCityList list, Connection dbConnection) throws TelosysException
    {
        return super.doSaveList(query, list, dbConnection);
    }
    
    /**
     * Saves a list of Value Objects by deleting all the existing items (according with the given query) <br>
     * and inserting all the items of the given list <br>
     * using a specific database session
     * @param query
     * @param list
     * @param dbSession
     * @return
     * @throws TelosysException
     */
    public int saveList(ListQuery query, TCityList list, DatabaseSession dbSession) throws TelosysException
    {
        return super.doSaveList(query, list, dbSession);
    }
    
    //============================================================================
    //   DELETE LIST BY QUERY CRITERIA
    //============================================================================
    /**
     * Deletes a list of records according with the given query criteria, <br>
     * using the default database
     * @param query
     * @return
     * @throws TelosysException
     */
    public int deleteList(ListQuery query) throws TelosysException
    {
        return super.doDeleteList(query);
    }

    /**
     * Deletes a list of records according with the given query criteria, <br>
     * using a specific database id  
     * @param query
     * @param dbId
     * @return
     * @throws TelosysException
     */
    public int deleteList(ListQuery query, int dbId) throws TelosysException
    {
        return super.doDeleteList(query, dbId);
    }

    /**
     * Deletes a list of records according with the given query criteria, <br>
     * using a specific database connection  
     * @param query
     * @param dbConnection
     * @return
     * @throws TelosysException
     */
    public int deleteList(ListQuery query, Connection dbConnection) throws TelosysException
    {
        return super.doDeleteList(query, dbConnection);
    }
    
    /**
     * Deletes a list of records according with the given query criteria, <br>
     * using a specific database session
     * @param query
     * @param dbSession
     * @return
     * @throws TelosysException
     */
    public int deleteList(ListQuery query, DatabaseSession dbSession) throws TelosysException
    {
        return super.doDeleteList(query, dbSession);
    }

    //============================================================================
    //   INSERT VO-LIST ITEMS
    //============================================================================
    /**
     * Inserts each Value Object of the given list (item by item), <br>
     * using the default database
     * @param list
     * @return
     * @throws TelosysException
     */
    public int insertList(TCityList list) throws TelosysException
    {
        return super.doInsertListItems(list);
    }
    
    /**
     * Inserts each Value Object of the given list (item by item), <br>
     * using a specific database id  
     * @param list
     * @param dbId
     * @return
     * @throws TelosysException
     */
    public int insertList(TCityList list, int dbId) throws TelosysException
    {
        return super.doInsertListItems(list, dbId);
    }
    
    /**
     * Inserts each Value Object of the given list (item by item), <br>
     * using a specific database connection  
     * @param list
     * @param dbConnection
     * @return
     * @throws TelosysException
     */
    public int insertList(TCityList list, Connection dbConnection) throws TelosysException
    {
        return super.doInsertListItems(list, dbConnection);
    }
    
    /**
     * Inserts each Value Object of the given list (item by item), <br>
     * using a specific database session
     * @param list
     * @param dbSession
     * @return
     * @throws TelosysException
     */
    public int insertList(TCityList list, DatabaseSession dbSession) throws TelosysException
    {
        return super.doInsertListItems(list, dbSession);
    }

    //============================================================================
    //   INSERT GENERIC LIST ITEMS
    //============================================================================
    /**
     * Inserts each Value Object of the given list (item by item), <br>
     * using the default database
     * @param list
     * @return
     * @throws TelosysException
     */
    public int insertList(List<TCity> list) throws TelosysException
    {
        return super.doInsertListItems(list);
    }
    
    /**
     * Inserts each Value Object of the given list (item by item), <br>
     * using a specific database id  
     * @param list
     * @param dbId
     * @return
     * @throws TelosysException
     */
    public int insertList(List<TCity> list, int dbId) throws TelosysException
    {
        return super.doInsertListItems(list, dbId);
    }
    
    /**
     * Inserts each Value Object of the given list (item by item), <br>
     * using a specific database connection  
     * @param list
     * @param dbConnection
     * @return
     * @throws TelosysException
     */
    public int insertList(List<TCity> list, Connection dbConnection) throws TelosysException
    {
        return super.doInsertListItems(list, dbConnection);
    }
    
    /**
     * Inserts each Value Object of the given list (item by item), <br>
     * using a specific database session
     * @param list
     * @param dbSession
     * @return
     * @throws TelosysException
     */
    public int insertList(List<TCity> list, DatabaseSession dbSession) throws TelosysException
    {
        return super.doInsertListItems(list, dbSession);
    }

    //============================================================================
    //   UPDATE VO-LIST ITEMS
    //============================================================================
    /**
     * Updates each Value Object of the given list (item by item), <br>
     * using the default database
     * @param list
     * @return
     * @throws TelosysException
     */
    public int updateList(TCityList list) throws TelosysException
    {
        return super.doUpdateListItems(list);
    }
    
    /**
     * Updates each Value Object of the given list (item by item), <br>
     * using a specific database id  
     * @param list
     * @param dbId
     * @return
     * @throws TelosysException
     */
    public int updateList(TCityList list, int dbId) throws TelosysException
    {
        return super.doUpdateListItems(list, dbId);
    }
    
    /**
     * Updates each Value Object of the given list (item by item), <br>
     * using a specific database connection  
     * @param list
     * @param dbConnection
     * @return
     * @throws TelosysException
     */
    public int updateList(TCityList list, Connection dbConnection) throws TelosysException
    {
        return super.doUpdateListItems(list, dbConnection);
    }
    
    /**
     * Updates each Value Object of the given list (item by item), <br>
     * using a specific database session
     * @param list
     * @param dbSession
     * @return
     * @throws TelosysException
     */
    public int updateList(TCityList list, DatabaseSession dbSession) throws TelosysException
    {
        return super.doUpdateListItems(list, dbSession);
    }
    
    //============================================================================
    //   UPDATE GENERIC LIST ITEMS
    //============================================================================
    /**
     * Updates each Value Object of the given list (item by item), <br>
     * using the default database
     * @param list
     * @return
     * @throws TelosysException
     */
    public int updateList(List<TCity> list) throws TelosysException
    {
        return super.doUpdateListItems(list);
    }
    
    /**
     * Updates each Value Object of the given list (item by item), <br>
     * using a specific database id  
     * @param list
     * @param dbId
     * @return
     * @throws TelosysException
     */
    public int updateList(List<TCity> list, int dbId) throws TelosysException
    {
        return super.doUpdateListItems(list, dbId);
    }
    
    /**
     * Updates each Value Object of the given list (item by item), <br>
     * using a specific database connection  
     * @param list
     * @param dbConnection
     * @return
     * @throws TelosysException
     */
    public int updateList(List<TCity> list, Connection dbConnection) throws TelosysException
    {
        return super.doUpdateListItems(list, dbConnection);
    }
    
    /**
     * Updates each Value Object of the given list (item by item), <br>
     * using a specific database session
     * @param list
     * @param dbSession
     * @return
     * @throws TelosysException
     */
    public int updateList(List<TCity> list, DatabaseSession dbSession) throws TelosysException
    {
        return super.doUpdateListItems(list, dbSession);
    }

    //============================================================================
    //   DELETE VO-LIST ITEMS
    //============================================================================
    /**
     * Deletes each Value Object of the given list (item by item), <br>
     * using the default database
     * @param list
     * @return
     * @throws TelosysException
     */
    public int deleteList(TCityList list) throws TelosysException
    {
        return super.doDeleteListItems(list);
    }
    
    /**
     * Deletes each Value Object of the given list (item by item), <br>
     * using a specific database id  
     * @param list
     * @param dbId
     * @return
     * @throws TelosysException
     */
    public int deleteList(TCityList list, int dbId) throws TelosysException
    {
        return super.doDeleteListItems(list, dbId);
    }
    
    /**
     * Deletes each Value Object of the given list (item by item), <br>
     * using a specific database connection  
     * @param list
     * @param dbConnection
     * @return
     * @throws TelosysException
     */
    public int deleteList(TCityList list, Connection dbConnection) throws TelosysException
    {
        return super.doDeleteListItems(list, dbConnection);
    }
    
    /**
     * Deletes each Value Object of the given list (item by item), <br>
     * using a specific database session
     * @param list
     * @param dbSession
     * @return
     * @throws TelosysException
     */
    public int deleteList(TCityList list, DatabaseSession dbSession) throws TelosysException
    {
        return super.doDeleteListItems(list, dbSession);
    }

    //============================================================================
    //   DELETE GENERIC LIST ITEMS
    //============================================================================
    /**
     * Deletes each Value Object of the given list (item by item), <br>
     * using the default database
     * @param list
     * @return
     * @throws TelosysException
     */
    public int deleteList(List<TCity> list) throws TelosysException
    {
        return super.doDeleteListItems(list);
    }
    
    /**
     * Deletes each Value Object of the given list (item by item), <br>
     * using a specific database id  
     * @param list
     * @param dbId
     * @return
     * @throws TelosysException
     */
    public int deleteList(List<TCity> list, int dbId) throws TelosysException
    {
        return super.doDeleteListItems(list, dbId);
    }
    
    /**
     * Deletes each Value Object of the given list (item by item), <br>
     * using a specific database connection  
     * @param list
     * @param dbConnection
     * @return
     * @throws TelosysException
     */
    public int deleteList(List<TCity> list, Connection dbConnection) throws TelosysException
    {
        return super.doDeleteListItems(list, dbConnection);
    }
    
    /**
     * Deletes each Value Object of the given list (item by item), <br>
     * using a specific database session
     * @param list
     * @param dbSession
     * @return
     * @throws TelosysException
     */
    public int deleteList(List<TCity> list, DatabaseSession dbSession) throws TelosysException
    {
        return super.doDeleteListItems(list, dbSession);
    }

    //============================================================================
    //   COUNT
    //============================================================================
    /**
     * Counts the number of records according with the given query, <br>
     * using the default database
     * @param query
     * @return
     * @throws TelosysException
     */
    public int count(ListQuery query) throws TelosysException
    {
        return super.doCount(query);
    }
    
    /**
     * Counts the number of records according with the given query, <br>
     * using a specific database id  
     * @param query
     * @param dbId
     * @return
     * @throws TelosysException
     */
    public int count(ListQuery query, int dbId) throws TelosysException
    {
        return super.doCount(query, dbId);
    }
    
    /**
     * Counts the number of records according with the given query, <br>
     * using a specific database connection  
     * @param query
     * @param dbConnection
     * @return
     * @throws TelosysException
     */
    public int count(ListQuery query, Connection dbConnection) throws TelosysException
    {
        return super.doCount(query, dbConnection);
    }
    
    /**
     * Counts the number of records according with the given query, <br>
     * using a specific database session
     * @param query
     * @param dbSession
     * @return
     * @throws TelosysException
     */
    public int count(ListQuery query, DatabaseSession dbSession) throws TelosysException
    {
        return super.doCount(query, dbSession);
    }

}