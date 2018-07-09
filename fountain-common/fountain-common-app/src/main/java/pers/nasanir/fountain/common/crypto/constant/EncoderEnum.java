package pers.nasanir.fountain.common.crypto.constant;

public enum EncoderEnum {
	HEX256("Hex256Encoder");

	private String className;

	EncoderEnum(String className) {
		this.className = className;
	}
	
	public String getClassName(){
		return this.className;
	}
}
