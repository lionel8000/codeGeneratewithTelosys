//-----------------------------------------------------------
// This is a generated class. Avoid customizing code here !
// Generated by Telosys Tools Generator - version : 2.0.3
// Date : 12 ���� 2013 - Time 23:25:16
//-----------------------------------------------------------
// This class was generated by the standard template
// Template name    : vo_bean.vm
// Template author  : Stephane LABBE 
// Template version : 1.0.0 ( Aout 17 - 2011 ) 
//-----------------------------------------------------------

package com.hlj.tech.kdkj.auto.entities;

import java.io.Serializable;



import java.util.List;
import javax.persistence.*;


@Entity
@Table(name="t_province", catalog="bdf" )
public class TProvince implements Serializable
{
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY ATTRIBUTES 
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private short      id            ;
    
    @Column(name="code", length=10)
    private String     code          ;
    
    @Column(name="name", length=15)
    private String     name          ;
    

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="tProvince", targetEntity=TCity.class)
    private List<TCity> listOfTCity ;
    

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TProvince()
    {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR ENTITY FIELDS
    //----------------------------------------------------------------------
    //--- DB PRIMARY KEY : id ( smallint ) 
    public void setId( short value )
    {
        this.id = value;
    }
    public short getId()
    {
        return this.id;
    }

    //--- DB COLUMN : code ( varchar ) 
    public void setCode( String value )
    {
        this.code = value;
    }
    public String getCode()
    {
        return this.code;
    }

    //--- DB COLUMN : name ( varchar ) 
    public void setName( String value )
    {
        this.name = value;
    }
    public String getName()
    {
        return this.name;
    }


    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfTCity( List<TCity> value )
    {
        this.listOfTCity = value;
    }
    public List<TCity> getListOfTCity()
    {
        return this.listOfTCity;
    }



}