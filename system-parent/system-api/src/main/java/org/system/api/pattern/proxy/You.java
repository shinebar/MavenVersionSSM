package org.system.api.pattern.proxy;

public class You implements GiveGift {

	BeautifulGirl mm; // 美女

	public You(BeautifulGirl mm) {
		this.mm = mm;
	}

	public void giveBook() {
		System.out.println(mm.getName() + ",送你一本书....");
	}

	public void giveChocolate() {
		System.out.println(mm.getName() + ",送你一盒巧克力....");
	}

	public void giveFlowers() {
		System.out.println(mm.getName() + ",送你一束花....");
	}

}
