package cn.ty.util.cache;

import java.util.ArrayList;
import java.util.List;

/**
 * 缓存容器
 * @author Administrator
 *
 */
public class CacheContainer {
	
	/**
	 * 保存分类缓存集合
	 */
	private List<Cache> caches = new ArrayList<Cache>();

	/**
	 * 获取所有类型缓存
	 * @return
	 */
	public List<Cache> getCaches() {
		return caches;
	}
	
	/**
	 * 分类保存缓存到容器集合中
	 * @param cache
	 */
	public void add(Cache cache) {
		caches.add(cache);
	}
	
	/**
	 * 从缓存容器中移除某一类型缓存
	 * @param cache
	 */
	public void remove(Cache cache) {
		caches.remove(cache);
	}
	
	/**
	 * 通过缓存类型标识从容器中获取某一类型的缓存
	 * @param type
	 * @return
	 */
	public Cache getCacheByType(String type) {
		for (Cache cache : caches)
		{
			if (null != type && cache.getType().equals(type))
			{
				return cache;
			}
		}
		return null;
	}
}