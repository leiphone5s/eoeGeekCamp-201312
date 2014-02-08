package se2.day04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test05 {
	private static final String SRC_PATH = "d:/se2/day03";
	private static final String DEST_PATH = "d:/se2/day04";
	private static ArrayList<String> taskList = new ArrayList<String>();
	private static ArrayList<String> tasks = new ArrayList<String>();
	private static boolean isFinish = false;

	public static void main(String[] args) {
		initTaskList();
		final DownloadTask downloadTask = new DownloadTask();
		downloadTask.start();
		Thread controllThread = new Thread() {
			@Override
			public void run() {
				Scanner scanner = new Scanner(System.in);
				while (true) {
					showTaskList();
					int select;
					do {
						select = scanner.nextInt();
					} while (select < 1 || select > taskList.size());
					if (select == taskList.size()) {
						isFinish = true;
						System.out.println("下载结束");
					} else {
						tasks.add(taskList.remove(select - 1));
					}
					synchronized (downloadTask) {
						downloadTask.notify();
					}
				}
			}

			private void showTaskList() {
				for (int i = 0; i < taskList.size(); i++) {
					System.out.println(1 + i + "" + taskList.get(i));
				}
			}
		};
		controllThread.setDaemon(true);
		controllThread.start();
	}

	private static void initTaskList() {
		taskList.add("adt-bundle-windows-x86_64-20130522.zip");
		taskList.add("NewOffice2003.rar");
		taskList.add("sources.rar");
		taskList.add("quit");
	}

	static class DownloadTask extends Thread {
		
		@Override
		public void run() {
			while (!isFinish) {
				while (tasks.size() > 0) {
					download(tasks.remove(0));
				}
				synchronized (this) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

		private void download(String fileName) {
			System.out.println("正在下载......");
			FileInputStream fis = null;
			FileOutputStream fos = null;
			File srcFile = new File(SRC_PATH, fileName);
			if (!srcFile.exists()) {
				System.out.println("文件不存在");
				return;
			}
			try {
				fis = new FileInputStream(srcFile);
				File destFile = new File(DEST_PATH, fileName);
				fos=new FileOutputStream(destFile);
				byte[] buffer = new byte[1024];
				long startTime=System.currentTimeMillis();
				int len;
				while ((len = fis.read(buffer)) != -1) {
					fos.write(buffer, 0, len);
				}
				long endTime=System.currentTimeMillis();
				long cost=(endTime-startTime)/1000;
				System.out.println("耗时"+cost+"秒");
				System.out.println(fileName + "文件复制完毕");
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
