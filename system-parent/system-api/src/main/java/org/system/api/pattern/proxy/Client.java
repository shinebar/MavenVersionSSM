package org.system.api.pattern.proxy;

public class Client {
	public static void main(String[] args) {
		BeautifulGirl mm = new BeautifulGirl("小屁孩...");
		HerChum chum = new HerChum(mm);
		chum.giveBook();
		chum.giveChocolate();
		chum.giveFlowers();
	}
}
