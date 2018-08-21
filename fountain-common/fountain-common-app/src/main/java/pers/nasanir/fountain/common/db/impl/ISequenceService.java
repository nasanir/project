package pers.nasanir.fountain.common.db.impl;

public interface ISequenceService {
    public Long generator();
    public Long generator(String sequenceCode);
}
