package com.orion.zd.estimator;

import java.util.List;

public class GenericClass {

	private Class theClass;
	private List<String> attributes;
	
	public GenericClass(Class theClass,List<String> attributes){
		this.theClass = theClass;
		this.attributes = attributes;
	}
	
	public double[] convert(Object classInstance){
		int i=0;
		double[] array = new double[attributes.size()];
		for(String attribute : this.attributes){
			array[i] = getData(classInstance,attribute);
			i++;
		}
		return array;
	}
	
	private double getData(Object classInstance,String attributeName){
		try {
			return Double.parseDouble(this.theClass.getMethod(getMethodName(attributeName), null).invoke(classInstance, null).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	private String getMethodName(String attributeName){
		String methodName = "get";
		methodName += Character.toUpperCase(attributeName.charAt(0));
		methodName += attributeName.substring(1);
		return methodName;
	}
}
