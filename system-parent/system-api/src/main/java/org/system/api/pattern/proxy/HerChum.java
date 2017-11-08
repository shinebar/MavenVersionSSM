package org.system.api.pattern.proxy;

public class HerChum implements GiveGift {

	You you;

	public HerChum(BeautifulGirl mm) {
		you = new You(mm);
	}

	public void giveBook() {
		you.giveBook();
	}

	public void giveChocolate() {
		you.giveChocolate();
	}

	public void giveFlowers() {
		you.giveFlowers();
	}

}
