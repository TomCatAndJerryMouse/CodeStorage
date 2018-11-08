package com.ty.utils.cache;
/**
 * 缓存管理器
 * @author Administrator
 *
 */
public class CacheManager {
	
	/**
	 * session缓存类型标识
	 */
	public final static String SESSION = "SESSION";
	
	/**
	 * AKSK缓存类型标识
	 */
	public final static String AKSK = "AKSK";
	
	/**
	 * 缓存类型容器
	 */
	private CacheContainer cacheContainer = new CacheContainer();
	
	/**
	 * 缓存管理器引用
	 */
	private static CacheManager cacheManager;
	
	/**
	 * 获取缓存管理器实例，单例
	 * @return
	 */
	public static CacheManager getInsstance(){
		if (null == cacheManager)
		{
			cacheManager = new CacheManager();
			cacheManager.getCacheContainer().add(new AkSkCache(AKSK));
			return cacheManager;
		}
		return cacheManager;
	}

	/**
	 * 获取缓存容器
	 * @return
	 */
	public CacheContainer getCacheContainer() {
		return cacheContainer;
	}

	/**
	 * 设置缓存容器
	 * @param cacheContainer
	 */
	public void setCacheContainer(CacheContainer cacheContainer) {
		this.cacheContainer = cacheContainer;
	}
	
}