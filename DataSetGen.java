/*
 * CMSC 204 Generic Lag
 * DataSetGen class
 * @author Jonathan Mariano
 * 
 * Generic version of the DataSet class.
 * @param <T> the type of the DataSet to be inserted.
 */
public class DataSetGen<T> implements Measurable{
	private double sum;
	//private Measurable maximum; //From DataSet.java
	private T maximum; //Converted to generic
	private int count;

	   /**
	      Constructs an empty data set.
	   */
	   public DataSetGen(){
	      sum = 0;
	      count = 0;
	      maximum = null;//
	   }

	   /**
	      Adds a data value to the data set.
	      @param x a data value
	      No instead of taking in type Measurable it will be a generic type T
	   */
	   public void add(T x){
	      sum = sum + ((Measurable) x).getMeasure();
	      if (count == 0 || ((Measurable) maximum).getMeasure() < ((Measurable) x).getMeasure()) //Cast advised by Eclipse
	         maximum = x;
	      count++;
	   }

	   /**
	      Gets the average of the added data.
	      @return the average or 0 if no data has been added
	   */
	   public double getAverage(){
	      if (count == 0) return 0;
	      else return sum / count;
	   }

	   /**
	      Gets the largest of the added data.
	      @return the maximum or 0 if no data has been added
	   */
	   /*public Measurable getMaximum(){
	      return maximum;//
	   }*/
	   public T getMaximum() {
		   return maximum;
	   }
	   
	   //Implement getMeasure() from Interface Measurable
	   public double getMeasure() {
		   return sum;
	   }

}
