package com.sales.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sales.dao.QueryDao;
import com.sales.entity.ConstantsEntity;

public final class ConstantCache {

	private static Map<String, List<ConstantsEntity>> constantMap=new HashMap<>();
	private static QueryDao queryDao=new QueryDao();
	private ConstantCache(){
		
	}
	
	/**
	 * MEthod to get the list of constant entity for given constant type
	 * @param constantType
	 * @return
	 */
	public static List<ConstantsEntity> getConstantsListFor(String constantType){
		if(!constantMap.containsKey(constantType)){
			List<ConstantsEntity>  constantsEntities=queryDao.getConstants(constantType);
			constantMap.put(constantType, constantsEntities);
		}
		
		return constantMap.get(constantType);
	}
	
	/**
	 * Method to get the constant entity for given constant type and constant id
	 * @param constantType
	 * @param constantId
	 * @return
	 */
	public static ConstantsEntity getConstantEntityFor(String constantType, String constantId){
		List<ConstantsEntity> constantsEntities= getConstantsListFor(constantType);
		ConstantsEntity constantsEntity1=null;
		for(ConstantsEntity constantsEntity:constantsEntities){
			if(constantsEntity.getConstantId().equals(constantId)){
				constantsEntity1=constantsEntity;
				break;
			}
		}
		return constantsEntity1;
	}
}

