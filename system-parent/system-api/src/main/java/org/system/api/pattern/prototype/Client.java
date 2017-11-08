package org.system.api.pattern.prototype;

public class Client {

	public static void main(String[] args) {
		//原型A对象
        Resume a = new Resume("小李子");
        a.setPersonInfo("2.16", "男", "XX大学");
        a.setWorkExperience("2012.09.05", "XX科技有限公司");
        
        //克隆B对象
        Resume b = (Resume) a.clone();
        
        //输出A和B对象
        System.out.println("----------------A--------------");
        a.display();
        System.out.println("----------------B--------------");
        b.display();
        
        /*
         * 测试A==B?
         * 对任何的对象x，都有x.clone() !=x，即克隆对象与原对象不是同一个对象
         */
        System.out.print("A==B?");
        System.out.println( a == b);
        
        /*
         * 对任何的对象x，都有x.clone().getClass()==x.getClass()，即克隆对象与原对象的类型一样。
         */
        System.out.print("A.getClass()==B.getClass()?");
        System.out.println(a.getClass() == b.getClass());
    }

}
