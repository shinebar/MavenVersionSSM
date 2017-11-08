package org.system.api.pattern.builder;

public class Client {
	
	public static void main(String[] args) {
		// 服务员
		KFCWaiter waiter = new KFCWaiter();
		// 套餐A
		MealA a = new MealA();
		// 服务员准备套餐A
		waiter.setMealBuilder(a);
		// 获得套餐
		Meal mealA = waiter.construct();

		System.out.print("套餐A的组成部分:");
		System.out.println(mealA.getFood() + "---" + mealA.getDrink());
	}
}
