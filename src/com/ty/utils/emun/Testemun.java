package com.ty.utils.emun;
/**
 * ö�ٲ�����
 * ���캯����ö���е��ֶβ����б�˳�򱣳�һ��
 * @author Administrator
 *
 */
public enum Testemun {
    RED("��ɫ",1),GREEN("��ɫ",2),YELLOW("��ɫ",3);
    // ��Ա����
	private int index;
    private String name;
    
    private Testemun(String name,int index) {
        this.name = name;
        this.index = index;
	}
    
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
}