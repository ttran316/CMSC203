/*
 * The purpose of this class is to model a television
 * Thomas Tran 4/6/21
 */
public class Television {
	private final String manufacturer;
	private final int screenSize;
	private boolean powerOn;
	private int channel, volume;
	
	//Constructor that intializes the current variables
	public Television(String manufacturer, int screenSize) {
		this.manufacturer = manufacturer;
		this.screenSize = screenSize;
		powerOn = false;
		volume = 20;
		channel = 2;
	}
	
	//Return current channel
	public int getChannel() {
		return channel;
	}
	
	//Return current volume
	public int getVolume() {
		return volume;
	}
	
	//Return the manufacturer
	public String getManufacturer() {
		return manufacturer;
	}
	
	//Return screenSize
	public int getScreenSize() {
		return screenSize;
	}
	
	//Change the channel to the parameter value
	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	//Turns power the opposite of what it was
	public void power() {
		powerOn = !powerOn;
	}
	
	//Increase volume by 1
	public void increaseVolume() {
		volume++;
	}
	
	//Decrease volume by 1
	public void decreaseVolume() {
		volume--;
	}
}
