package pers.nasanir.fountain.common.common.entity;

import java.util.ArrayList;
import java.util.List;

public class VOSet<T extends AbstractVO> {
	private String sql = null;
	private List<T> voList = new ArrayList<>();

	public boolean isEmpty() {
		if (voList.isEmpty() || voList == null) {
			return true;
		}
		return false;
	}

	public T getVO(int index) {
		if (this.isEmpty()) {
			return null;
		} else {
			return this.voList.get(index);
		}
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getSql() {
		return this.sql;
	}

	public List<T> getVoList() {
		return this.voList;
	}

	public void setVoList(List<T> voList) {
		this.voList = voList;
	}

	public void addVo(T vo){
		this.voList.add(vo);
	}
}
