package model;

import java.util.List;

public class Van {
	private long id;
	private List<Carton> cartonList;
	private boolean isFull;
	private static final int MAX_PERMITTED=20;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Carton> getCartonList() {
		return cartonList;
	}

	public void setCartonList(List<Carton> cartonList) {
		this.cartonList = cartonList;
	}

	public boolean isFull() {
		return isFull;
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}
	
	public void addCarton(Carton carton){
		if(!isFull){
			cartonList.add(carton);
			if(cartonList.size()==MAX_PERMITTED){
				isFull=true;
			}
			
		}else{
			//throw VanFullException
		}
		
	}
}
