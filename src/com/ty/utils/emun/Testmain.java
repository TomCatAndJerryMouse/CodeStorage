package com.ty.utils.emun;

public class Testmain {
	public static void main(String[] args) {
		System.out.println(Testemun.YELLOW.getName());
		Testemun [] tm = Testemun.values();
		for (int i = 0; i < tm.length; i++) {
			System.out.println(tm[i].getName());
			System.out.println(tm[i].getIndex());
		}
	}
}
