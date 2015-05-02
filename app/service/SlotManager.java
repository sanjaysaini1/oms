package service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import model.Slot;
import model.Van;

public abstract class SlotManager {

	private static List<Slot> slotList = new ArrayList<Slot>();

	static {
		slotList.add(new Slot(Time.valueOf(LocalTime.of(9, 0))));
		slotList.add(new Slot(Time.valueOf(LocalTime.of(11, 0))));
		slotList.add(new Slot(Time.valueOf(LocalTime.of(2, 0))));
		slotList.add(new Slot(Time.valueOf(LocalTime.of(4, 0))));
	}

	public static Slot getSlot(Slot s) {

		Time currentTime = Time.valueOf(LocalTime.now());
		List<Slot> timeAvailableSlots = new ArrayList<Slot>();
		for (Slot slot : slotList) {
			if (slot.getStartTime().after(currentTime)) {
				timeAvailableSlots.add(slot);
			}
		}
		int index=0;
		if (s != null)
			index = timeAvailableSlots.indexOf(s);
		
		for (int i=index;i<timeAvailableSlots.size();i++) {
			Slot slot=timeAvailableSlots.get(i);
			if (slot == s)
				continue;
			if (slot.getSlotVans().isEmpty()) {
				Van van = VanManager.getVan();
				if (van != null) {
					slot.addVan(van);
					return slot;
				}
			}
			Van van = getNotFullVan(slot);
			if (van != null) {
				return slot;
			}
			if (slot.getSlotVans().size() == VanManager.VAN_COUNT) {
				getSlot(slot);
			} else if (slot.getSlotVans().size() < VanManager.VAN_COUNT) {
				Van van1 = VanManager.getVan();
				if (van1 != null) {
					slot.addVan(van1);
					return slot;
				}

			}
		}
		return null;
	}

	private static Van getNotFullVan(Slot slot) {
		for (Van van : slot.getSlotVans()) {
			if (!van.isFull())
				return van;
		}
		return null;
	}
}
