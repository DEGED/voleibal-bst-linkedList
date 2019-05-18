package ui;

import java.io.IOException;

import model.VoleibolEvent;

public class Main {

	public Main() {
		
	
	}
	
	
	public static void main(String[]args) throws IOException {
		Main x = new Main();
		VoleibolEvent po = new VoleibolEvent();
		po.loadParticipants("data//MOCK_DATA (2).csv",",");
		System.out.println(po.preOrder());
		try {
			po.loadParticipants("data//MOCK_DATA (2).csv",",");
			po.preOrder();
			po.findTeamCountry("thailand");
		}catch(IOException oe){
			oe.printStackTrace();
		}

	}
}
