package com.dp.factory;

import java.util.Scanner;

interface Button{
	public void render();
	public void onClick();
}

class WinButton implements Button{

	@Override
	public void render() {
		// TODO Auto-generated method stub
		System.out.println("Windows button render");
	}

	@Override
	public void onClick() {
		// TODO Auto-generated method stub
		System.out.println("windows button is clicked");
	}
	
}

class HtmlButton implements Button{

	@Override
	public void render() {
		// TODO Auto-generated method stub
		System.out.println("Html button render");
	}

	@Override
	public void onClick() {
		// TODO Auto-generated method stub
		System.out.println("Html button is clicked");
	}
	
}

abstract class Dialog {
	abstract public Button createButton();
	
	public void render() {
		Button button = createButton();
		button.onClick();
		button.render();
	}
}

class WinDialog extends Dialog{

	@Override
	public Button createButton() {
		// TODO Auto-generated method stub
		return new WinButton();
	}
	
}
class WebDialog extends Dialog{

	@Override
	public Button createButton() {
		// TODO Auto-generated method stub
		return new HtmlButton();
	}
	
}

public class FactoryDemo {
	public Dialog dialog;
	public void initialize() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter type : ");
		String config = sc.next();
		if(config.equals("windows")) {
			dialog = new WinDialog();
		}
		else if(config.equals("web")) {
			dialog = new WebDialog();
		}
		else {
			throw new Exception("Error occurred");
		}
	}
	public static void main(String args[]) throws Exception {
		FactoryDemo factory = new FactoryDemo();
		factory.initialize();
		try {
			factory.dialog.render();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
