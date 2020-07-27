package application.neuron;

import java.util.ArrayList;

import application.layer.Layer;
import application.network.Connection;

public class ConnectableNeuron extends Neuron {	
	private double bias = 0.0;

	public double getBias() {
		return bias;
	}

	public void setBias(double bias) {
		this.bias = bias;
	}
	
	private double targetValue = 0.0;
	
	public double getTargetValue() {
		return targetValue;
	}

	public void setTargetValue(double targetValue) {
		this.targetValue = targetValue;
	}

	private double error = 0.0;
	
	public double getError() {
		return error;
	}

	public void setError(double error) {
		this.error = error;
	}

	// OPT Replace inboundConnectionList by previousLayer.getNeuronList();
	private Layer previousLayer;
	
	public Layer getPreviousLayer() {
		return previousLayer;
	}

	public void setPreviousLayer(Layer previousLayer) {
		this.previousLayer = previousLayer;
	}
	
	private ArrayList<Connection> inboundConnectionList = new ArrayList<Connection>();

	public ArrayList<Connection> getInboundConnectionList() {
		return inboundConnectionList;
	}

	public void setInboundConnectionList(ArrayList<Connection> inboundConnectionList) {
		this.inboundConnectionList = inboundConnectionList;
	}
}