package address;

import java.io.Serializable;

public class User implements Serializable {
	private int id;
	private String password;
	private String loginId;
	private String name;
	private int age;
	private String comment;

	public User(int id, String loginId, String password, String name, int age, String comment) {
		this.id = id;
		this.loginId = loginId;
		this.password = password;
		this.name = name;
		this.age = age;
		this.comment = comment;
	}
	public User(String loginId, String password, String name, int age, String comment) {
		this.loginId = loginId;
		this.password = password;
		this.name = name;
		this.age = age;
		this.comment = comment;
	}

	public User() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getLoginId() {
		return loginId;
	}

	public String getComment() {
		return comment;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
