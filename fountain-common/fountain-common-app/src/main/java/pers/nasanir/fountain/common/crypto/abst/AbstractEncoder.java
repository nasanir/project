
import java.security.NoSuchAlgorithmException;

public abstract class AbstractEncoder implements IEncoder {

	@Override
	public abstract byte[] encode(byte[] message) throws NoSuchAlgorithmException;

	@Override
	public byte[] encode(String message) throws NoSuchAlgorithmException {
		return encode(message.getBytes());
	}

	@Override
	public String encode2Hex(byte[] message) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		return byte2Hex(encode(message));
	}

	@Override
	public String encode2Hex(String message) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		return byte2Hex(encode(message));
	}

	@Override
	public abstract byte[] decode(byte[] message);

	@Override
	public abstract byte[] decode(String message);

	@Override
	public String decode2Hex(byte[] message) {
		// TODO Auto-generated method stub
		return byte2Hex(decode(message));
	}

	@Override
	public String decode2Hex(String message) {
		// TODO Auto-generated method stub
		return byte2Hex(decode(message));
	}

	@Override
	public <T> boolean vaildate(T message, T sign) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String m;
		String s;
		if (message.getClass().isInstance(String.class)) {
			m = (String) message;
		} else {
			m = byte2Hex((byte[]) message);
		}

		if (sign.getClass().isInstance(String.class)) {
			s = (String) sign;
		} else {
			s = byte2Hex((byte[]) sign);
		}

		if (m.equals(s)) {
			flag = true;
		}

		return false;
	}

	public String byte2Hex(byte[] message) {
		StringBuilder result = new StringBuilder(message.length * 2);
		for (byte b : message) {
			result.append(CryptoContant.HEXDIGITS[b >>> 4 & 0xf]).append(CryptoContant.HEXDIGITS[b & 0xf]);
		}
		return result.toString();
	}

}
