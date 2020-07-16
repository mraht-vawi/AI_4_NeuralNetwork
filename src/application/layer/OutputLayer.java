package application.layer;

import application.network.Digit;
import application.network.Neuron;

public class OutputLayer extends Layer {
	public OutputLayer(int id) {
		super(id);
	}

	public Neuron getMostActiveNeuron() {
		Neuron mostActiveNeuron = this.neuronList.get(0);
		for (int i = 1; i < this.neuronList.size(); i++) {
			if (this.neuronList.get(i).getActivationValue() > mostActiveNeuron.getActivationValue()) {
				mostActiveNeuron = this.neuronList.get(i);
			}
		}

		return mostActiveNeuron;
	}

	public double getCost(Digit digit) {
		double cost = 0.0;

		for (Neuron neuron : this.neuronList) {
			double resultBias = 0.0;
			if (neuron.getId() == digit.getLabel()) {
				resultBias = 1.0;
			}

			cost += Math.pow((neuron.getActivationValue() - resultBias), 2);
		}

		return cost;
	}

	public void calculateProbability() {
		double total = 0.0;

		for (Neuron neuron : this.neuronList) {
			total += Math.exp(neuron.getActivationValue());
		}

		for (Neuron neuron : this.neuronList) {
			neuron.setProbability(Math.exp(neuron.getActivationValue()) / total);
		}
	}
}
