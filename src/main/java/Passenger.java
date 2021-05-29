
public class Passenger {
private int passengerID;
private int survived;
private int pClass;
private String name;
private String sex;
private double age;

Passenger(int passengerID, int survived, int pClass, String name, String sex, double age){
	this.passengerID=passengerID;
	this.survived=survived;
	this.pClass=pClass;
	this.name=name;
	this.sex=sex;
	this.age=age;
}
public int getPassengerID() {
	return passengerID;
}
public int getSurvived() {
	return survived;
}
public int getpClass() {
	return pClass;
}
public String getName() {
	return name;
}
public String getSex() {
	return sex;
}
public double getAge() {
	return age;
}
}
