package org.system.api.pattern.prototype;

/**
 * 简历：Resume.java
 * 
 * @author shinebar 所谓原型模式就是用原型实例指定创建对象的种类，并且通过复制这些原型创建新的对象。
 *         所发动创建的对象只需要知道原型对象的类型就可以获得更多的原型实例对象，至于这些原型对象时如何创建的根本不需要关心。
 *         
 *         讲到原型模式了，我们就不得不区分两个概念：深拷贝、浅拷贝。
 *         浅拷贝：使用一个已知实例对新创建实例的成员变量逐个赋值，这个方式被称为浅拷贝。
 *         深拷贝：当一个类的拷贝构造方法，不仅要复制对象的所有非引用成员变量值，还要为引用类型的成员变量创建新的实例，并且初始化为形式参数实例值。
 */
public class Resume implements Cloneable {
	private String name;
	private String birthday;
	private String sex;
	private String school;
	private String timeArea;
	private String company;

	/**
	 * 构造函数：初始化简历赋值姓名
	 */
	public Resume(String name) {
		this.name = name;
	}

	/**
	 * @desc 设定个人基本信息
	 * @param birthday
	 *            生日
	 * @param sex
	 *            性别
	 * @param school
	 *            毕业学校
	 * @return void
	 */
	public void setPersonInfo(String birthday, String sex, String school) {
		this.birthday = birthday;
		this.sex = sex;
		this.school = school;
	}

	/**
	 * @desc 设定工作经历
	 * @param timeArea
	 *            工作年限
	 * @param company
	 *            所在公司
	 * @return void
	 */
	public void setWorkExperience(String timeArea, String company) {
		this.timeArea = timeArea;
		this.company = company;
	}

	/**
	 * 克隆该实例
	 */
	public Object clone() {
		Resume resume = null;
		try {
			resume = (Resume) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return resume;
	}

	public void display() {
		System.out.println("姓名：" + name);
		System.out.println("生日:" + birthday + ",性别:" + sex + ",毕业学校：" + school);
		System.out.println("工作年限:" + timeArea + ",公司:" + company);
	}

}
