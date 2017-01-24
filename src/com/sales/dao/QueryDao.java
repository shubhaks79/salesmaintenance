package com.sales.dao;

import java.util.List;

import com.sales.entity.ConstantsEntity;
import com.sales.util.ResourceGetter;

public class QueryDao extends BaseDao {

	public List<ConstantsEntity> getConstants(String constantType1){
		List<?> lst =null;
		StringBuilder hql = new StringBuilder(ResourceGetter.getInstance().getSqlPropertyText("constant.list"));
		hql.append(" where bo.constantType = '");
		hql.append(constantType1);
		hql.append("'");
		lst = hdlr.search(hql.toString());
		System.out.println("in dao: "+lst);
		return (List<ConstantsEntity>)lst;
	}
}
