package com.ty.utils.emun;
/**
 * 枚举测试类
 * 构造函数于枚举中的字段参数列表顺序保持一致
 * @author Administrator
 *
 */
public enum Testemun {
    RED("红色",1),GREEN("绿色",2),YELLOW("黄色",3);
    // 成员变量
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