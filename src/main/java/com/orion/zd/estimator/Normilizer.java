package com.orion.zd.estimator;

import java.util.Arrays;

public class Normilizer {
	
	private final int MIN_TO_NORMILIZE = 0;
	private final int MAX_TO_NORMOLIZE = 1;
	private double[] minData;
	private double[] maxData;
	private double[][] data;
	
	public Normilizer(double[][] data){
		this.data = data;
		this.minData = new double[data[0].length];
		this.maxData = new double[data[0].length];
		calculMinMax();
	}
	public double[] normalize(double[] normalData){
		double[] normalizeData = new double[normalData.length];
		int i=0;
		for(double column : normalData){
			normalizeData[i] = ((column - this.minData[i]) / (this.maxData[i] - this.minData[i])) * ( this.MAX_TO_NORMOLIZE - this.MIN_TO_NORMILIZE ) + this.MIN_TO_NORMILIZE;
			i++;
		}
		return normalizeData;
	}
	public double[][] normalize(double[][] normalData){
		double[][] normalizeData = new double[normalData.length][];
		int i=0;
		for(double[] row : normalData){
			normalizeData[i] = this.normalize(row);
			i++;
		}
		return normalizeData;
	}
	public double[] denormalize(double[] normalizeData){
		double[] normalData = new double[normalizeData.length];
		int i=0;
		for(double column : normalizeData){
			normalData[i] = ((column - this.MIN_TO_NORMILIZE) / ( this.MAX_TO_NORMOLIZE - this.MIN_TO_NORMILIZE )) * (this.maxData[i] - this.minData[i]) + this.minData[i];
			i++;
		}
		return normalData;
	}
	public double denormalize(double output){
		return ((output - this.MIN_TO_NORMILIZE) / ( this.MAX_TO_NORMOLIZE - this.MIN_TO_NORMILIZE )) * (this.maxData[this.maxData.length-1] - this.minData[this.minData.length-1]) + this.minData[this.minData.length-1];
	}
	private void calculMinMax(){
		double[] min = new double[data[0].length];
		double[] max = new double[data[0].length];
	
		for(int i=0;i<data[0].length;i++){
			min[i] = data[0][i];
			max[i] = data[0][i];
		}
		
		for(int i=0;i<data[0].length;i++){
			for(int j=1;j<data.length;j++){
				if(min[i] > data[j][i]){
					min[i] = data[j][i];
				}
				if(max[i] < data[j][i]){
					max[i] = data[j][i];
				}
			}
		}
		
		this.minData = min;
		this.maxData = max;
	}
}
