package service;

import model.Van;

public class VanManager {

	public static final int VAN_COUNT = 4;
	private static int slottedVanCount=0;
	public static Van getVan() {
		// TODO Auto-generated method stub
		if(slottedVanCount<VAN_COUNT)
		{
			slottedVanCount++;
			return new Van();
		}
		return null;
	}

}
