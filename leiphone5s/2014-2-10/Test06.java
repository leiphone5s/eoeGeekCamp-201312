package se2.day05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Test06 {
	public static void main(String[] args) {
		final ThreadPoolExecutor pools = (ThreadPoolExecutor) Executors
				.newCachedThreadPool();
		TalkTask talk = new TalkTask();
		ScanVirusTask scanVirus = new ScanVirusTask();
		pools.execute(talk);
		pools.execute(scanVirus);
		pools.execute(new DownloadTask());
		pools.execute(new Runnable() {
			@Override
			public void run() {
				int i = 1;
				while (true) {
					try {
						Thread.sleep(1000);
						i++;
						System.out.println("任务数:" + pools.getTaskCount());
						System.out.println("活动线程数量:" + pools.getActiveCount());
						System.out.println("线程池中的线程数量:" + pools.getPoolSize());
						System.out.println("执行完毕的线程数:"
								+ pools.getCompletedTaskCount());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	}

	static class TalkTask implements Runnable {

		@Override
		public void run() {
			while (true) {
				System.out.println("与客户聊天");
				try {
					Thread.sleep(1000 * 10);
					System.out.println("结束与客户的聊天");
					break;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	static class DownloadTask implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 50; i++) {
				try {
					Thread.sleep(100);
					System.out.println("下载文件...");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("下载文件结束");

		}
	}

	static class ScanVirusTask implements Runnable {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
