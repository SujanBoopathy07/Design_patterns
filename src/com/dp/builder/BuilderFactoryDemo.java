package com.dp.builder;

class Car{
	private int noOfSeats;
	private String engine;
	private String gps;
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getGps() {
		return gps;
	}
	public void setGps(String gps) {
		this.gps = gps;
	}
}

class Manual{
	private int noOfSeats;
	private String engine;
	private String gps;
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getGps() {
		return gps;
	}
	public void setGps(String gps) {
		this.gps = gps;
	}
}

interface Builder{
	public void reset();
	public void setSeats(int count);
	public void setEngine(String type);
	public void setGPS(String gps);
}

class CarBuilder implements Builder{
	private Car car;
	
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		this.car = new Car();
	}

	@Override
	public void setSeats(int count) {
		// TODO Auto-generated method stub
		car.setNoOfSeats(count);
	}

	@Override
	public void setEngine(String type) {
		// TODO Auto-generated method stub
		car.setEngine(type);
	}

	@Override
	public void setGPS(String gps) {
		// TODO Auto-generated method stub
		car.setGps(gps);
	}
	
	public Car getProduct() {
		this.reset();
		return this.car;
	}
	
}

class ManualBuilder implements Builder{
	private Manual manual;
	
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		this.manual = new Manual();
	}

	@Override
	public void setSeats(int count) {
		// TODO Auto-generated method stub
		manual.setNoOfSeats(count);
	}

	@Override
	public void setEngine(String type) {
		// TODO Auto-generated method stub
		manual.setEngine(type);
	}

	@Override
	public void setGPS(String gps) {
		// TODO Auto-generated method stub
		manual.setGps(gps);
	}
	
	public Manual getProduct() {
		this.reset();
		return this.manual;
	}
	
}
class Director {
	public void constructSportCar(Builder builder) {
		builder.reset();
		builder.setEngine("sport engine- super fast");
		builder.setGPS("new es30 gps");
		builder.setSeats(2);
	}
	
	public void constructSUV(Builder builder) {
		builder.reset();
		builder.setEngine("normal engine - casual");
		builder.setGPS("gsi 12 gps");
		builder.setSeats(4);
	}
}

class Application {
	public void makeCar(String config) {
		Director director = new Director();
		
		if(config.equals("sports")) {
			CarBuilder builder = new CarBuilder();
			director.constructSportCar(builder);
			Car car = builder.getProduct();
			printCarSpecs(car);
		}
		else {
			ManualBuilder builder = new ManualBuilder();
			director.constructSUV(builder);
			Manual manual = builder.getProduct();
			printManualSpecs(manual);
		}
	}
	
	public void printCarSpecs(Car car) {
		System.out.println("Specs : "+car.getEngine()+" - "+car.getNoOfSeats()+" - "+car.getGps());
	}
	public void printManualSpecs(Manual manual) {
		System.out.println("Specs : "+manual.getEngine()+" - "+manual.getNoOfSeats()+" - "+manual.getGps());
	}
}

public class BuilderFactoryDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Application().makeCar("sports");
	}

}
