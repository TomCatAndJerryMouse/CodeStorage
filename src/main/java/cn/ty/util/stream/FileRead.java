package cn.ty.util.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * �ļ���ȡ
 * @author Administrator
 */
public class FileRead
{
    String[] keys = {
	    		"/esp/contract/combinationSignAsync",
//	    		"/esp/contract/combinationSign",
//	    		"/esp/contract/get",
//				"/esp/user/create",
//				"/esp/template/get",
//	    		"/esp/template/getProductInfo"
			};
    /**
     * ���
     * @param args
     */
    public static void main(String[] args)
    {
        try
        {
        	InputStream in = new FileInputStream("C:\\Users\\Administrator\\workspace\\Practice\\src\\com\\ty\\utils\\stream\\test.txt");
            byte[] b = new byte[1024];
            int readByte;
            StringBuilder stringBuilder = new StringBuilder();
            while ((readByte = in.read(b)) > 0)
            {
                stringBuilder.append(new String(b, 0, readByte));
            }
            System.out.println(stringBuilder.toString());

        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
 
    @Test// 字符流
    public void  rederTest() {
    	Map<String, List<String>> m = new HashMap<String, List<String>>();
    	try {  
//			FileReader fd = new FileReader(new File("E:\\0_Project\\04 华龙证券\\电子合同\\问题\\20220919抢购业务超时\\nginx\\esp.access\\log\\esp.access.log.151"));
//			FileReader fd = new FileReader(new File("C:\\Users\\Admin\\Desktop\\esp.access.log"));
			FileReader fd = new FileReader(new File("C:\\Users\\Admin\\Desktop\\esp.access.log"));
			BufferedReader bReader = new BufferedReader(fd);
			String line = null;
			while ((line=bReader.readLine()) !=null) {
				String[] strs = line.split(" ");
//				System.out.println(Arrays.toString(strs));
				for (String s:strs){
					if(Arrays.asList(keys).contains(s)){
						List<String> ret = null;
						if((ret=m.get(s)) != null){
							ret.add(strs[3]);
						} else {
							List<String> list = new ArrayList<String>();
							list.add(strs[3]);
							m.put(s,list);
						}
					}
				}
			}
			Set<String> set = m.keySet();
			Iterator<String> iterator = set.iterator();
			File file = new File("D:\\tongji2.txt");
			FileWriter fWriter = new FileWriter(file);
			while (iterator.hasNext()) {
				String key = iterator.next();
				List<String> sList = m.get(key);
				System.out.println(key + " : "+ sList.size());
				int count = 0;
				String timeNode = "";
				for (String s : sList) {
					if (timeNode.equals(s)) {
						count ++;
					} else {
						StringBuffer sBuffer = new StringBuffer();
						sBuffer.append("接口"+key+":" +timeNode+"] ");
						for(int i=0;i<count;i++){
							sBuffer.append("#");
						}
						sBuffer.append("-"+count).append("\r\n");
//						sBuffer.append("("+count+")次被调用").append("\r\n");
						fWriter.write(sBuffer.toString());
						timeNode = s;
						count = 1;
					}
				}
				
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
    @Test// 统计西南失败协议
    public void  tongjiFaiXieyi() {
    	Map<String, String> m = new HashMap<String, String>();
    	try {  
//			FileReader fd = new FileReader(new File("E:\\0_Project\\04 华龙证券\\电子合同\\问题\\20220919抢购业务超时\\nginx\\esp.access\\log\\esp.access.log.151"));
			FileReader fd = new FileReader(new File("H:\\01 项目发布\\S16112-B-西南证券股份有限公司集中电子签约平台升级融合定制化改造\\03-需求\\01 问题处理\\01 协议推送问题\\2023-03-06 09_57_19\\changwairet.txt"));
			BufferedReader bReader = new BufferedReader(fd);
			String line = null;
			int count =0;
			while ((line=bReader.readLine()) !=null) {
				String[] strs = line.split(" ");
			
				for (String s:strs){
					if(s.contains("pdf")){
						String key = s.split("_")[5];
						if (m.containsKey(key)){
							if (m.get(key).equals(key)) {
								m.put(key, "1");
								count ++;
							}
							continue;
						} else {
							m.put(key, key);
						}
					}
				}
			}
			System.out.println(count);
//			Set<String> set = m.keySet();
//			Iterator<String> iterator = set.iterator();
//			File file = new File("D:\\tongji.txt");
//			FileWriter fWriter = new FileWriter(file);
//			while (iterator.hasNext()) {
//				String key = iterator.next();
//				List<String> sList = m.get(key);
//				System.out.println(key + " : "+ sList.size());
//				int count = 0;
//				String timeNode = "";
//				for (String s : sList) {
//					if (timeNode.equals(s)) {
//						count ++;
//					} else {
//						StringBuffer sBuffer = new StringBuffer();
//						sBuffer.append("接口"+key+":" +timeNode+"] ");
//						for(int i=0;i<count;i++){
//							sBuffer.append("#");
//						}
//						sBuffer.append("-"+count).append("\r\n");
////						sBuffer.append("("+count+")次被调用").append("\r\n");
//						fWriter.write(sBuffer.toString());
//						timeNode = s;
//						count = 1;
//					}
//				}
//				
//				
//			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
}
