package com.orion.zd.estimator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.neuroph.core.data.DataSet;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.MomentumBackpropagation;
import org.neuroph.util.TransferFunctionType;

import com.orion.zd.domain.SoldListing;

public class ZoomEstimator {
	
	private final int INPUT_SIZE = 6;
	private MultiLayerPerceptron neuralNetwork;
	private double[][] data;
	private Normilizer normalizer;
	
	public ZoomEstimator(List<SoldListing> soldListings){
		System.out.println(soldListings.size()+" examples");
		this.data = this.convertData(soldListings);
		this.normalizer = new Normilizer(this.data);
		neuralNetwork = new MultiLayerPerceptron(TransferFunctionType.SIGMOID, INPUT_SIZE, INPUT_SIZE+2,1);
	}
	private double[][] convertData(List<SoldListing> soldListings){
		double[][] data = new double[soldListings.size()][];
		GenericClass converter = new GenericClass(SoldListing.class,new ArrayList(Arrays.asList("year","acres","bed","bath","sqft","garage","soldPrice"))); 
		int i=0;
		for(SoldListing listing : soldListings){
			data[i] = converter.convert(listing);
			i++;		
		}
		return data;
	}
	public void learn(){
		double[][] normilizedData = this.normalizer.normalize(this.data);
		DataSet trainingSet = new DataSet(INPUT_SIZE,1);
		for(double[] row : normilizedData){
			double[] input = Arrays.copyOf(row, INPUT_SIZE);
			double[] output = new double[]{row[row.length-1]};
			trainingSet.addRow(input,output);
		}
		neuralNetwork.randomizeWeights();
		MomentumBackpropagation learningRule = (MomentumBackpropagation) neuralNetwork.getLearningRule();
        learningRule.setLearningRate(0.45);
        learningRule.setMomentum(0.9);
        System.out.println("Begin learning");
		neuralNetwork.learn(trainingSet,learningRule);
		System.out.println("End learning");
	}
	
	public double getPrice(double[] input){
		neuralNetwork.setInput(this.normalizer.normalize(input));
		neuralNetwork.calculate();
        double[] output = neuralNetwork.getOutput();
        return this.normalizer.denormalize(output[0]);
	}	
}
