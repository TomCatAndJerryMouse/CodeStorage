package cn.ty.util.ssh;

import java.io.IOException;

import org.apache.sshd.client.SshClient;
import org.apache.sshd.client.session.ClientSession;

public class SshExample {

    public static void main(String[] args) throws IOException {
    	SshClient client = SshClient.setUpDefaultClient();
    	client.start();
    	ClientSession session = client.connect("2323", "2323", 22)
                .verify(...timeout...)
                .getSession()
    }
    }
}