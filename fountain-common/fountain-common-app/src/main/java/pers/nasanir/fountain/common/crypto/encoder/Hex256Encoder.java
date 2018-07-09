package pers.nasanir.fountain.common.crypto.encoder;

import pers.nasanir.fountain.common.crypto.abst.AbstractEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hex256Encoder extends AbstractEncoder {

	@Override
	public byte[] encode(byte[] message) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		MessageDigest md=MessageDigest.getInstance("SHA-256");
		md.update(message);
		return md.digest();
	}

	@Override
	public byte[] decode(byte[] message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] decode(String message) {
		// TODO Auto-generated method stub
		return null;
	}

}
