package se2.day05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.naming.ldap.SortResponseControl;

public class Test07 {
	private static final String SRC_PATH = "d:/se2/day03/";
	private static final String DEST_PATH = "d:/se2/day04/";
	static ArrayList<String> taskList = new ArrayList<String>();
	static ExecutorService pools;

	public static void main(String[] args) {
		initTaskList();
		pools = Executors.newSingleThreadExecutor();

		new Thread() {
			@Override
			public void run() {
				while (true) {
					showTaskList();
					Scanner scanner = new Scanner(System.in);
					int select = scanner.nextInt();
					if (select == taskList.size()) {
						System.out.println("文件复制结束");
						pools.shutdown();
						break;
					}
					String fileName = taskList.remove(select - 1);
					pools.execute(new CopyTask(fileName));
				}
			}

		}.start();

	}

	private static void showTaskList() {
		for (int i = 0; i < taskList.size(); i++) {
			System.out.println(i + 1 + "-" + taskList.get(i));
		}
	}

	private static void initTaskList() {
		taskList.add("adt-bundle-windows-x86_64-20130522.zip");
		taskList.add("NewOffice2003.rar");
		taskList.add("sources.rar");
		taskList.add("quit");
	}

	static class CopyTask implements Runnable {
		String fileName;

		public CopyTask(String fileName) {
			this.fileName = fileName;
		}

		@Override
		public void run() {
			FileInputStream fis = null;
			FileOutputStream fos = null;
			try {
				fis = new FileInputStream(SRC_PATH + fileName);
				fos = new FileOutputStream(DEST_PATH + fileName);
				int len;
				byte[] buffer = new byte[1024 * 10];
				while ((len = fis.read(buffer)) != -1) {
					fos.write(buffer, 0, len);
				}
				System.out.println(fileName + "复制完毕！！！");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (fis != null) {
						fis.close();
					}
					if (fos != null) {
						fos.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
