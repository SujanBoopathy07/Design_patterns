package com.dp.abstractfactory;

import java.util.Scanner;

interface GUIFactory{
	public Button createButton();
	public Checkbox createCheckbox();
}

interface Button{
	public void paint();
}

class WinButton implements Button{
	@Override
	public void paint() {
		System.out.println("Windows Button : +++ - created");
	}
}

class MacButton implements Button{
	@Override
	public void paint() {
		System.out.println("Mac Button : +-+ - created");
	}
}

interface Checkbox{
	public void paint();
}

class WinCheckbox implements Checkbox{
	@Override
	public void paint() {
		System.out.println("Windows Checkbox |-| - created");
	}
}

class MacCheckbox implements Checkbox{
	@Override
	public void paint() {
		System.out.println("Mac Checkbox |_| - created");
	}
}

class WinFactory implements GUIFactory{

	@Override
	public Button createButton() {
		// TODO Auto-generated method stub
		return new WinButton();
	}

	@Override
	public Checkbox createCheckbox() {
		// TODO Auto-generated method stub
		return new WinCheckbox();
	}
	
}


class MacFactory implements GUIFactory{

	@Override
	public Button createButton() {
		// TODO Auto-generated method stub
		return new MacButton();
	}

	@Override
	public Checkbox createCheckbox() {
		// TODO Auto-generated method stub
		return new MacCheckbox();
	}
	
}

class Application {
	private GUIFactory factory;
	private Button button;
	
	public Application(GUIFactory factory) {
		this.factory = factory;
	}
	
	public void createUI() {
		this.button = factory.createButton();
	}
	
	public void paint() {
		button.paint();
	}
}
public class AbstractFactory {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter windows or mac :");
		String config = sc.next();
		System.out.println("Enterred input is "+config);
		GUIFactory factory;
		if(config.equals("windows")) {
			factory = new WinFactory();
		}
		else if(config.equals("mac")) {
			factory = new MacFactory();
		}
		else {
			throw new Exception("factory is not available for this type");
		}
		Application app = new Application(factory);
		app.createUI();
		app.paint();
	}
}





