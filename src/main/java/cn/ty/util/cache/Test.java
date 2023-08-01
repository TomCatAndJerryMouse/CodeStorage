package cn.ty.util.cache;


public class Test {
	public static void main(String[] args) {
		CacheContainer cct = CacheManager.getInsstance().getCacheContainer();
		AkSkCache asc = (AkSkCache) cct.getCacheByType(CacheManager.AKSK);
		asc.put("JHGHJGJHGHJ1", "123123123");
		asc.put("JHGHJGJHGHJ2", "123123123");
		asc.put("JHGHJGJHGHJ3", "123123123");
		System.out.println(asc.getDatas());
	}
}
