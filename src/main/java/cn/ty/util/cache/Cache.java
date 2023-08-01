package cn.ty.util.cache;

/**
 * 缓存类型基类
 * @author Administrator
 *
 */
public class Cache {
	
	/**
	 * 当前缓存缓存创建时间
	 */
	private long date;
	/**
	 * 当前缓存类型
	 */
	private String type;
	/**
	 * 当前类型缓存数据集合,定义为Object类型，每一种缓存类型的缓存数据可以保存为任意对象。
	 */
	private Object datas;
	
	/**
	 * 无参构造函数，初始化缓存类型创建时间
	 */
	public Cache() {
		this.date = System.currentTimeMillis();
	}
	/**
	 * 获取缓存类型
	 * @return
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置缓存类型
	 * @return
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取缓存创建时间
	 * @return
	 */
	public long getDate() {
		return date;
	}
	/**
	 * 设置缓存创建时间
	 * @return
	 */
	public void setDate(long date) {
		this.date = date;
	}
	/**
	 * 获取当前缓存类型缓存数据
	 * @return
	 */
	public Object getDatas() {
		return datas;
	}
	/**
	 * 设置当前缓存类型缓存数据
	 * @return
	 */
	public void setDatas(Object datas) {
		this.datas = datas;
	}
}