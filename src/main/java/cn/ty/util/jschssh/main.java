package main.java.cn.ty.util.jschssh;

import java.util.ArrayList;
import java.util.List;

import com.jcraft.jsch.Session;

public class main {
	public static void main(String[] args) {
	    String ip = "192.168.92.161";
	     int port = 22;
	     String userName = "root";
	     String password = "Root@123";
	     List<String> cmds = new ArrayList<>();
	     cmds.add("ls -l");
	     GetLinuxConnection GLC = new GetLinuxConnection();
	     Session session = GLC.getJSchSession(ip,port,userName,password);
	     ExecLinuxCommands ELC = new ExecLinuxCommands();
	     List<String> result = ELC.getCmdResult(session, cmds);
	     result.forEach((x)-> System.out.println(x));
	     GLC.closeJSchSession(session);
	}

}
