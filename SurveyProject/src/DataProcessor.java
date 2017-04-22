
public class DataProcessor {

	public double computeMean(String numData){
		String[] eachValues = numData.split(",");
		double total = 0;
		double mean = 0;
		for(int i = 0; i < eachValues.length; i++)
			total += Double.parseDouble(eachValues[i]);
		mean = total/eachValues.length;
		return mean;
	}
	
	public double computeSD(String numData, double mean){
		String[] eachValues = numData.split(",");
		double total = 0;
		for(int i = 0; i < eachValues.length; i++)
			total += Math.pow((Double.parseDouble(eachValues[i]) - mean), 2);
		double sd = Math.pow(total/eachValues.length, 2);
		return sd;
	}
}
