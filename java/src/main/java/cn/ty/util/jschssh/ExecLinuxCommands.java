package cn.ty.util.jschssh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class ExecLinuxCommands {
	//用来执行命令
	//Session表示传递连接对话,commands表示传递命令集合
	public List<String> getCmdResult(Session session , List<String> commands){
	    //用来存放命令的返回值
	    List<String> cmdResult = new ArrayList<>();
	    for (String command : commands) {
	        Channel channel = null;
	        try {
	            //创建执行通道
	            channel = session.openChannel("exec");
	            //设置命令
	            ((ChannelExec) channel).setCommand(command);
	            //连接通道
	            channel.connect();
	            //读取通道的输出
	            InputStream in = channel.getInputStream();
	            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	            //存放命令的执行结果，如果结果有很多行，则每次line的值不同
	            String line;
	            //lines用来拼接line结果
	            StringBuffer lines = new StringBuffer();
	            while ((line = reader.readLine()) != null) {
	                //去除头尾的空格
	                line.trim();
	                lines = lines.append(line);
	            }
	            //如果命令执行没有返回值，则直接输出没有返回值
	            if (String.valueOf(lines).equals("")){
	                cmdResult.add("命令["+command+"]执行成功,但没有返回值");
	            }else {
	                //否则将每行返回直接存入到list中
	                cmdResult.add(String.valueOf(lines));
	            }
	            reader.close();
	            channel.disconnect();
	        } catch (JSchException e) {
	            throw new RuntimeException(e);
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	    }
	    return cmdResult;
	}

}
