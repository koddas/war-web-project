//package koddas.web.war;

//import java.io.Serializable;

/**
 * MrBean is a simple example of a Java bean; a small class that encapsulates a
 * number of values. It exposes an empty constructor and has a number of
 * members that are accessible through getters and setters.
 * 
 * @author Johan Holmberg
 */
public class MrBean implements Serializable {
	/**
	 * Being a serializable class, the bean needs a unique identification
	 * number in order for the Java system to recreate saved objects.
	 */
	private static final long serialVersionUID = -3168349974480377280L;
	
	private String name;
	private int age;
	private String nationality;
	private String carBrand;
	
	/**
	 * Empty constructor.
	 * 
	 * Gson uses reflection to construct beans. In order to be able to do so, a
	 * bean must expose a constructor that doesn't take any arguments. Its
	 * attributes will be set by Gson upon object creation.
	 */
	public MrBean() {
		// Let's just give the class members some standard values
		name = "Rowan Atkinson";
		age = 60;
		nationality = "British";
		carBrand = "Leyland Mini";
	}

	/**
	 * Returns the name of the bean.
	 * 
	 * @return The name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gives the bean a new name.
	 * 
	 * @param name The new name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the age of the bean.
	 * 
	 * @return The age.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Gives the bean a new age.
	 * 
	 * @param age The new age.
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Returns the nationality of the bean.
	 * 
	 * @return The nationality.
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * Gives the bean a new nationality.
	 * 
	 * @param nationality The new nationality.
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * Returns the car brand of the bean.
	 * 
	 * @return The car brand.
	 */
	public String getCarBrand() {
		return carBrand;
	}

	/**
	 * Gives the bean a new car brand.
	 * 
	 * @param carBrand The new car brand.
	 */
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
}
