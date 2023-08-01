package main.java.cn.ty.util.yaml;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Admin
 *
 */
public class NodeObject {
	
	private Map<String,Object> nodeMap = new HashMap<String,Object>();
	
	public NodeObject() {
		super();
	}
	
	public NodeObject(Map map) {
		super();
		this.nodeMap = map;
	}

	public String getStringValue (String key) {
		return null == nodeMap.get(key) ?  "" : nodeMap.get(key).toString();
	}

	public Map<String, Object> getNodeMap() {
		return nodeMap;
	}

	public void setNodeMap(Map<String, Object> nodeMap) {
		this.nodeMap = nodeMap;
	}
	
}
