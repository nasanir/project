package pers.nasanir.fountain.common.crypto.itf;

import java.security.NoSuchAlgorithmException;

public interface IEncoder {
    byte[] encode(byte[] message) throws NoSuchAlgorithmException;

    byte[] encode(String message) throws NoSuchAlgorithmException;

    String encode2Hex(byte[] message) throws NoSuchAlgorithmException;

    String encode2Hex(String message) throws NoSuchAlgorithmException;

    byte[] decode(byte[] message);

    byte[] decode(String message);

    String decode2Hex(byte[] message);

    String decode2Hex(String message);

    <T> boolean vaildate(T message, T sign);
}
