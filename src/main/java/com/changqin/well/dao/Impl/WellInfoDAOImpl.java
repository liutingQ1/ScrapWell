package com.changqin.well.dao.Impl;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.changqin.well.common.config.Department;
import com.changqin.well.common.config.InfoState;
import com.changqin.well.dao.WellInfoDAO;
import com.changqin.well.entry.WellInfo;

/**
 * @author LiuTing
 * @version 2017年8月9日 下午8:13:20
 * 
 */
@Repository
public class WellInfoDAOImpl extends BaseDAOImpl<WellInfo> implements WellInfoDAO {
	@Override
	public List<WellInfo> selectLike(WellInfo wellInfo) {
		String sql = this.getSql(wellInfo);
		Query query = getSession().createQuery(sql);
		List<WellInfo> result = query.list();
		return result;
	}
	private String getSql(WellInfo wellInfo) {
		String sql = "from WellInfo ";
		boolean flag = true;
		try {
			Field[] fields = WellInfo.class.getDeclaredFields();
			for(int i=0;i<fields.length;i++){
			     PropertyDescriptor pd = new PropertyDescriptor(fields[i].getName(), WellInfo.class);
			     Method method = pd.getReadMethod();
			     Object invoke = method.invoke(wellInfo);
			     if(invoke==null)
			    	 continue;
			     String value = "";
			     if(fields[i].getName().equals("department")){
			    	 Department dep = (Department)invoke;
			    	 value = dep.name();
			     }else if(fields[i].getName().equals("operator")){
			    	 Department ope = (Department)invoke;
			    	 value = ope.name();
			     }else if((fields[i].getName().equals("state"))){
			    	 InfoState state = (InfoState)invoke;
			    	 value = state.name();
			     }else{
			    	 value = invoke.toString();
			     }
			     if(!value.equals("")){
			    	if(flag){
	                     sql = sql + "where "+fields[i].getName()+" like '%"+value.toString()+"%' ";
	                     flag = false;
			    	}else
	                     sql = sql + "and "+fields[i].getName()+" like '%"+value.toString()+"%' ";
			     }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flag)
			return "";
		return sql;
	}
}
