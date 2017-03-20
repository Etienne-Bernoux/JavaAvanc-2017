package fr.ece.bernoux.lab1Basis.ex5;

import java.util.Calendar;

import fr.ece.bernoux.lab1Basis.ex4.Media;

public abstract class Item implements Media {

	private StateItem state;
	private int lawnerIdNumber;
	private int durationDay;
	private Calendar loanDate;

	private final static int DURATION = 7;

	public Item(StateItem state, int user_id, int durationDay, Calendar loanDate) {
		super();
		this.state = state;
		this.lawnerIdNumber = user_id;
		this.durationDay = durationDay;
		this.loanDate = loanDate;
	}

	public Item() {
		this.state = StateItem.AVAILABLE;
		this.lawnerIdNumber = -1;
		this.durationDay = DURATION;
		this.loanDate = null;
	}

	@Override
	public void setLoan(int lawnerIdNumber, int durationDay) {
		this.state = StateItem.AVAILABLE;
		this.lawnerIdNumber = lawnerIdNumber;
		this.durationDay = durationDay;
		this.loanDate = Calendar.getInstance();

	}

	public void setLoan(int lawnerIdNumber) {
		this.state = StateItem.AVAILABLE;
		this.lawnerIdNumber = lawnerIdNumber;
		this.loanDate = Calendar.getInstance();

	}

	@Override
	public void setAvailable() {
		this.state = StateItem.AVAILABLE;

	}

	public StateItem getState() {
		return state;
	}

	public void setState(StateItem state) {
		this.state = state;
	}

	public int getLawnerIdNumber() {
		return lawnerIdNumber;
	}

	public void setLawnerIdNumber(int lawnerIdNumber) {
		this.lawnerIdNumber = lawnerIdNumber;
	}

	public int getDurationDay() {
		return durationDay;
	}

	public Calendar getLoanDate() {
		return loanDate;
	}

	public static int getDuration() {
		return DURATION;
	}

}
