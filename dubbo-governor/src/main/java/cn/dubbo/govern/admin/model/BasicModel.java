package cn.dubbo.govern.admin.model;

public abstract class BasicModel {

	public BasicModel(long id) {
		this.id = id;
	}

	public BasicModel() {
	}

	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@java.lang.Override
	public String toString() {
		return "BasicModel{" + "id=" + id + '}';
	}
}
