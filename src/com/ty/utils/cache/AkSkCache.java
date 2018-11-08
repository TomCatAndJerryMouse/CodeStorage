package com.ty.utils.cache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * AKSK缓存类型
 * @author Administrator
 *
 */
public class AkSkCache extends Cache {

	/**
	 * 缓存类型构造函数
	 * @param type
	 */
	public AkSkCache(String type)
	{
		super.setType(type);
		super.setDatas(new ConcurrentHashMap<String,String>());
	}
	
	/**
	 * 向AKSK缓存添加缓存数据
	 * @param key
	 * @param value
	 */
	@SuppressWarnings("unchecked")
	public void put(String key,String value) {
		((ConcurrentHashMap<String, String>)getDatas()).put(key, value);
	}
	/**
	 * 通过Key从AKSK缓存数据获取数据
	 * @param key
	 * @param value
	 */
	@SuppressWarnings("unchecked")
	public String get(String key) {
		return ((ConcurrentHashMap<String, String>)getDatas()).get(key);
	}
}
