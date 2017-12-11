package com.changqin.well.common.utils;

import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StandardBasicTypes;

/**
 * @author LiuTing
 * @version 2017年8月9日 下午9:00:27
 * 
 */
/**
 * 自定义Hibernate方言
 *
 */
public class RegMySQLDialect extends MySQLDialect{
     
     public RegMySQLDialect(){
          super();
          registerFunction("regexp", new SQLFunctionTemplate(StandardBasicTypes.STRING,"?1 regexp ?2"));
     }
}

