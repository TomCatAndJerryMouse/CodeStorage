package cn.ty.util.yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.yaml.snakeyaml.Yaml;

/**
 * yml文件读取类
 * @author teng
 *
 */
public class ConfigReder {
	
	/**
	 * 实列对象引用
	 */
	private static ConfigReder yr;
	
	/**
	 * yaml配置文件内容映射
	 */
	private Map<String,Object> yamlMaps;
	
	/**
	 * 配置文件路径
	 */
	private String configPath;
	
	/**
	 * 获取实列
	 * @return
	 */
	public static ConfigReder getInstance(){
		if (null == yr) {
			yr = new ConfigReder();
		}
		return yr;
	}

	public String getConfigPath() {
		return configPath;
	}

	public void setConfigPath(String configPath) {
		this.configPath = configPath;
	}
	
	/**
	 * 构造函数加载配置文件
	 */
	public ConfigReder() {
		super();
		try {
			configPath = URLDecoder.decode(ConfigReder.class.getClassLoader().getResource(Constant.CONFIGNAME).getPath().toString(),"UTF-8");
			if (System.getProperty("os.name").toLowerCase().contains("windows")) {
				configPath = configPath.substring(1);
			}
			System.out.println(configPath);
			FileInputStream yamlFileIn = new FileInputStream(new File(configPath));
			Yaml yml = new Yaml();
			yamlMaps = yml.load(yamlFileIn);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("Loading config sucess!");
	}

	/**
	 * 通过节点key获取节点数据，key值至少包含一层子集
	 * @param key
	 * @return
	 */
	public String getValueByKeys(String keystr) {
		String [] keys  = keystr.split("\\.");
		Map<String,Object> map = yamlMaps;
		String ret = "";
		for (int i=0;i < keys.length ; i++){
			if (i == keys.length - 1 && null != map.get(keys[i])){
				ret = map.get(keys[i]).toString();
				return ret;
			}
			map = getNodeMap(map,keys[i]);
			// 每个节点必须找到数据，否则直接返回
			if (map.size() == 0) {
				return ret;
			}
		}
		return ret;
	}
	
	/**
	 * 通过节点key获取最终数据,key值需要指向最后一层
	 * @param key
	 * @return
	 */
	public NodeObject getNodeObjectByKeys(String keystr) {
		String [] keys  = keystr.split("\\.");
		Map<String,Object> map = yamlMaps;
		for (String key : keys){
			map = getNodeMap(map,key);
			// 每个节点必须找到数据，否则直接返回
			if (map.size() == 0) {
				return new NodeObject();
			}
		}
		return new NodeObject(map);
	}
	
	/**
	 * 通过某一层次节点key获取该层次下映射
	 * @param key
	 * @return
	 */
	private Map<String,Object> getNodeMap(Map<String,Object> map,String nodeKey) {
		Map<String,Object> maps = new HashMap<String,Object>();
		Set<Map.Entry<String, Object>> sets = map.entrySet();
		for (Map.Entry<String, Object> entry : sets) {
			if (entry.getValue() instanceof Map && entry.getKey().equals(nodeKey)) {
				return (Map)entry.getValue();
			} else if (entry.getValue() instanceof Map) {
				maps = getNodeMap((Map)entry.getValue(),nodeKey);
				if (0 == maps.size()) {
					continue;
				}
				return maps;
			} 
		}
		return maps;
	}
}
