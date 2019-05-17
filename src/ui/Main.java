package ui;

import model.VoleibolEvent;

public class Main {

	public Main() {
		this.po = new VoleibolEvent();
		try {
		po.loadParticipants("data//MOCK_DATA.csv",",");
		}catch()
		
	}
	private VoleibolEvent po;
	
	public static void main(String[]args) {
		
		
	}
}
