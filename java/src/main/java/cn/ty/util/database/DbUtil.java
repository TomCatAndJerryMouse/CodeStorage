package cn.ty.util.database;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.rowset.serial.SerialBlob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ty.util.path.PathUtil;

public class DbUtil {
	
	private static final  String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";
//	
//	private static final String URL = "jdbc:oracle:thin:@192.168.92.137:1521:orcl";
	
//	private static final  String DRIVERNAME = "sgcc.nds.jdbc.driver.NdsDriver";
	
	private static final String URL = "jdbc:oracle:thin:@215.30.62.147:1521:orcl";
	
	private static Connection con = null;
	
	private final static Logger log = LoggerFactory.getLogger(DbUtil.class);
	
	static {
		try {
			Class.forName(DRIVERNAME).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnetion(){
		
		try {
			if (null == con){
//				con = DriverManager.getConnection(URL, "C##esp", "esp");
				con = DriverManager.getConnection(URL, "hldzxy", "hldzxy");
			} else {
				
			}
			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void test (){
		long starttime;
		String uuid2 = "1234";
		String selectSqlStr = "select * from test1";
//		String delSqlStr = "delete from file_binary_data t where t.uuid=?";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String dateString = simpleDateFormat.format(new Date());
//		String insertSqlStr = "insert into file_binary_data (version,binary_data,date_created,last_updated, uuid) values (?,?,to_date ( '"+dateString+"' , 'YYYY-MM-DD HH24:MI:SS' ),to_date ( '"+dateString+"' , 'YYYY-MM-DD HH24:MI:SS' ),?)";
		PreparedStatement preparedStatement = null;
		FileInputStream filein = null;
		try {	
			Connection connection = getConnetion();
			preparedStatement = connection.prepareStatement(selectSqlStr);
//			preparedStatement.setString(1,uuid2);
//			log.info("查询开始。");
			System.out.println("查询开始。");
			starttime = System.currentTimeMillis();
		    ResultSet srt = preparedStatement.executeQuery();
		    while (srt.next()) {
		    	String s = srt.getString("uuid");
//		    	log.info("查询结束结果： " + s);
		    	System.out.println("查询结束结果： " + s);
//		    	preparedStatement = connection.prepareStatement(delSqlStr);
//				preparedStatement.setString(1,s);
//				log.info("删除开始。");
//				starttime = System.currentTimeMillis();
//				preparedStatement.executeUpdate();
//				connection.commit();
//				log.info("删除结束。" + (System.currentTimeMillis()-starttime));
			}
//		    log.info("查询结束。" + (System.currentTimeMillis()-starttime));
		    System.out.println("查询结束。" + (System.currentTimeMillis()-starttime));
//		    File file = new File(PathUtil.getRootPath("test.pdf"));
//		    filein = new FileInputStream(file);
//		    byte[] bs = new byte[(int) file.length()];
//		    new FileInputStream(file).read(bs);
////		    InputStream input = new ByteArrayInputStream(bs);
//		    preparedStatement = connection.prepareStatement(insertSqlStr);
//		    preparedStatement.setInt(1,0);
//		    Blob blob = new SerialBlob(bs);
//		    preparedStatement.setBlob(2,blob);
//		    preparedStatement.setString(3, uuid2);
//		    log.info("插入开始。");
//		    starttime = System.currentTimeMillis();
//		    preparedStatement.executeUpdate();
//		    connection.commit();
//		    log.info("插入结束。" + (System.currentTimeMillis()-starttime));
		 } catch (Exception e) {
		     System.out.println(e.getMessage());
		 } finally {
			 if (null != filein){
				 try {
					filein.close();
					System.out.println("FileInputStream close. ");
				} catch (IOException e) {
					e.printStackTrace();
				}
			 } else if (preparedStatement != null) {
		         try {
					preparedStatement.close();
					System.out.println("PreparedStatement close. ");
				} catch (SQLException e) {
					e.printStackTrace();
				}
		     }
		 }
		System.out.println("Execute over! " );
	}
	
	public static void main(String[] args) {
		DbUtil du = new DbUtil();
		while (true) {
			du.test();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
