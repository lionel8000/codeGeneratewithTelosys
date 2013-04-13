/*
 * Java bean class for entity table bdf_enums 
 * Created on 13 ���� 2013 ( Time 05:51:58 )
 * Generated by Telosys Tools Generator ( version 2.0.3 )
 */

package com.hlj.tech.kdkj.auto.entities ;

import java.io.Serializable;

import java.util.Date;

/**
 * Entity bean for table "bdf_enums"
 * 
 * @author Telosys Tools Generator
 *
 */
public class BdfEnums implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String     id           ; // Primary Key

    private String     name         ;
    private String     desc         ;
    private String     categoryId   ;
    private String     createUser   ;
    private String     updateUser   ;
    private Date       createDate   ;
    private Date       updateDate   ;
    private String     memo         ;
    private BdfEnumCategorys bdfEnumCategorys;
    /**
     * Default constructor
     */
    public BdfEnums()
    {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTER(S) & SETTER(S) FOR THE PRIMARY KEY 
    //----------------------------------------------------------------------
    /**
     * Set the "id" field value
     * This field is mapped on the database column "ID_" ( type "varchar", ) 
     * @param id
     */
	public void setId( String id )
    {
        this.id = id ;
    }
    /**
     * Get the "id" field value
     * This field is mapped on the database column "ID_" ( type "varchar", ) 
     * @return the field value
     */
	public String getId()
    {
        return this.id;
    }

    //----------------------------------------------------------------------
    // GETTER(S) & SETTER(S) FOR DATA FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : NAME_ ( varchar ) 
    /**
     * Set the "name" field value
     * This field is mapped on the database column "NAME_" ( type "varchar" ) 
     * @param name
     */
    public void setName( String name )
    {
        this.name = name;
    }
    /**
     * Get the "name" field value
     * This field is mapped on the database column "NAME_" ( type "varchar" ) 
     * @return the field value
     */
    public String getName()
    {
        return this.name;
    }

    //--- DATABASE MAPPING : DESC_ ( varchar ) 
    /**
     * Set the "desc" field value
     * This field is mapped on the database column "DESC_" ( type "varchar" ) 
     * @param desc
     */
    public void setDesc( String desc )
    {
        this.desc = desc;
    }
    /**
     * Get the "desc" field value
     * This field is mapped on the database column "DESC_" ( type "varchar" ) 
     * @return the field value
     */
    public String getDesc()
    {
        return this.desc;
    }

    //--- DATABASE MAPPING : CATEGORY_ID_ ( varchar ) 
    /**
     * Set the "categoryId" field value
     * This field is mapped on the database column "CATEGORY_ID_" ( type "varchar" ) 
     * @param categoryId
     */
    public void setCategoryId( String categoryId )
    {
        this.categoryId = categoryId;
    }
    /**
     * Get the "categoryId" field value
     * This field is mapped on the database column "CATEGORY_ID_" ( type "varchar" ) 
     * @return the field value
     */
    public String getCategoryId()
    {
        return this.categoryId;
    }

    //--- DATABASE MAPPING : CREATE_USER_ ( varchar ) 
    /**
     * Set the "createUser" field value
     * This field is mapped on the database column "CREATE_USER_" ( type "varchar" ) 
     * @param createUser
     */
    public void setCreateUser( String createUser )
    {
        this.createUser = createUser;
    }
    /**
     * Get the "createUser" field value
     * This field is mapped on the database column "CREATE_USER_" ( type "varchar" ) 
     * @return the field value
     */
    public String getCreateUser()
    {
        return this.createUser;
    }

    //--- DATABASE MAPPING : UPDATE_USER_ ( varchar ) 
    /**
     * Set the "updateUser" field value
     * This field is mapped on the database column "UPDATE_USER_" ( type "varchar" ) 
     * @param updateUser
     */
    public void setUpdateUser( String updateUser )
    {
        this.updateUser = updateUser;
    }
    /**
     * Get the "updateUser" field value
     * This field is mapped on the database column "UPDATE_USER_" ( type "varchar" ) 
     * @return the field value
     */
    public String getUpdateUser()
    {
        return this.updateUser;
    }

    //--- DATABASE MAPPING : CREATE_DATE_ ( datetime ) 
    /**
     * Set the "createDate" field value
     * This field is mapped on the database column "CREATE_DATE_" ( type "datetime" ) 
     * @param createDate
     */
    public void setCreateDate( Date createDate )
    {
        this.createDate = createDate;
    }
    /**
     * Get the "createDate" field value
     * This field is mapped on the database column "CREATE_DATE_" ( type "datetime" ) 
     * @return the field value
     */
    public Date getCreateDate()
    {
        return this.createDate;
    }

    //--- DATABASE MAPPING : UPDATE_DATE_ ( datetime ) 
    /**
     * Set the "updateDate" field value
     * This field is mapped on the database column "UPDATE_DATE_" ( type "datetime" ) 
     * @param updateDate
     */
    public void setUpdateDate( Date updateDate )
    {
        this.updateDate = updateDate;
    }
    /**
     * Get the "updateDate" field value
     * This field is mapped on the database column "UPDATE_DATE_" ( type "datetime" ) 
     * @return the field value
     */
    public Date getUpdateDate()
    {
        return this.updateDate;
    }

    //--- DATABASE MAPPING : MEMO_ ( varchar ) 
    /**
     * Set the "memo" field value
     * This field is mapped on the database column "MEMO_" ( type "varchar" ) 
     * @param memo
     */
    public void setMemo( String memo )
    {
        this.memo = memo;
    }
    /**
     * Get the "memo" field value
     * This field is mapped on the database column "MEMO_" ( type "varchar" ) 
     * @return the field value
     */
    public String getMemo()
    {
        return this.memo;
    }

    public void setBdfEnumCategorys( BdfEnumCategorys bdfEnumCategorys )
    {
        this.bdfEnumCategorys = bdfEnumCategorys;
    }
    public BdfEnumCategorys getBdfEnumCategorys()
    {
        return this.bdfEnumCategorys;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString()
    {
        StringBuffer sb = new StringBuffer(); 
        sb.append(id); 
        sb.append("|"); 
        sb.append(name); 
        sb.append( "|" ); 
        sb.append(desc); 
        sb.append( "|" ); 
        sb.append(categoryId); 
        sb.append( "|" ); 
        sb.append(createUser); 
        sb.append( "|" ); 
        sb.append(updateUser); 
        sb.append( "|" ); 
        sb.append(createDate); 
        sb.append( "|" ); 
        sb.append(updateDate); 
        sb.append( "|" ); 
        sb.append(memo); 
        return sb.toString();
    }

}