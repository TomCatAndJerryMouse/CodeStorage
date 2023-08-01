package cn.ty.util.memcached;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;

public class MemcachedManger {
	public static void main(String[] args) {
		try {
			MemcachedClient mc = new  MemcachedClient(new InetSocketAddress("139.9.181.229",11211));
			 System.out.println("Connection to server sucessful.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
