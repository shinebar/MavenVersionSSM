package org.system.api.pattern.bridge;

public class Black implements Color {

	@Override
	public void bepaint(String shape) {
        System.out.println("黑色的" + shape);
	}

}
