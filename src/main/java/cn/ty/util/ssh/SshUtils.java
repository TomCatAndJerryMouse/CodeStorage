//package main.java.cn.ty.util.ssh;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.util.EnumSet;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//import org.apache.sshd.client.SshClient;
//import org.apache.sshd.client.channel.ChannelExec;
//import org.apache.sshd.client.channel.ChannelShell;
//import org.apache.sshd.client.channel.ClientChannelEvent;
//import org.apache.sshd.client.future.ConnectFuture;
//import org.apache.sshd.client.session.ClientSession;
//
//import com.sun.xml.internal.ws.util.NoCloseInputStream;
//import com.sun.xml.internal.ws.util.NoCloseOutputStream;
//
//
//
//public final class SshUtils {
//
//  public static SshResponse runCommand(SshConnection conn, String cmd, long timeout)
//      throws IOException {
//    SshClient client = SshClient.setUpDefaultClient();
//
//    try {
//      // Open the client
//      client.start();
//
//      // Connect to the server
//      ClientSession  cf = client.connect(conn.getUsername(), conn.getHostname(), 22);
//      ClientSession session = cf.verify().getSession();
//      session.addPasswordIdentity(conn.getPassword());
//      session.auth().verify(TimeUnit.SECONDS.toMillis(timeout));
//
//      // Create the exec and channel its output/error streams
//      ChannelExec ce = session.createExecChannel(cmd);
//      ByteArrayOutputStream out = new ByteArrayOutputStream();
//      ByteArrayOutputStream err = new ByteArrayOutputStream();
//      ce.setOut(out);
//      ce.setErr(err);
//
////       Execute and wait
//      ce.open();
//      Set<ClientChannelEvent> events =
//              ce.waitFor(EnumSet.of(ClientChannelEvent.CLOSED), TimeUnit.SECONDS.toMillis(timeout));
//      session.close(false);
//
////       Check if timed out
//      if (events.contains(ClientChannelEvent.TIMEOUT)) {
//        throw new SshTimeoutException(cmd, conn.getHostname(), timeout);
//      }
//
//      return new SshResponse(out.toString(), err.toString(), ce.getExitStatus());
//
//    } finally {
//      client.stop();
//    }
//
//  }
//
//  /**
//   * 交互式命令发送
//   * @param conn
//   * @param timeout
//   * @throws SshTimeoutException
//   * @throws IOException
//   */
//  public static void runCommandForInteractive(SshConnection conn, long timeout)
//          throws SshTimeoutException, IOException {
//    SshClient client = SshClient.setUpDefaultClient();
//
//    try {
//      // Open the client
//      client.start();
//
//      // Connect to the server
//      ConnectFuture cf = client.connect(conn.getUsername(), conn.getHostname(), 22);
//      ClientSession session = cf.verify().getSession();
//      session.addPasswordIdentity(conn.getPassword());
//      session.auth().verify(TimeUnit.SECONDS.toMillis(timeout));
//
//
//      // Create the shell and channel its output/error streams
//      ChannelShell cs  = session.createShellChannel();
//      cs.setOut(new NoCloseOutputStream(System.out));
//      cs.setErr(new NoCloseOutputStream(System.err));
//      cs.setIn(new NoCloseInputStream(System.in));
//
////    Execute and wait
//      cs.open();
//      cs.waitFor(EnumSet.of(ClientChannelEvent.CLOSED), 0);
//      cs.close(false);
//      session.close(false);
//    } finally {
//      client.stop();
//    }
//
//  }
//
//  public static void main(String[] args) throws Exception{
////    String hostName = "192.168.11.100";
//    String hostName = "192.168.11.71";
//    String userName = "root";
//    String pwd = "password";
//    SshConnection  conn  = new SshConnection(userName,pwd,hostName);
////    &&-表示前面命令执行成功在执行后面命令; ||表示前面命令执行失败了在执行后面命令; ";"表示一次执行两条命令
//    String cmd = "pwd && ps  -ef|grep tomcat";
//    SshResponse  response = runCommand(conn,cmd,15);
//    System.out.println("==error=>"+response.getErrOutput());
//    System.out.println("===return==>"+response.getReturnCode());
//    System.out.println("===stdOut===>"+response.getStdOutput());
//
//
////    runCommandForInteractive(conn,15);
//  }
//}
//
