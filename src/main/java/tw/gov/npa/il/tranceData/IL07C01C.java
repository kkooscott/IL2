package tw.gov.npa.il.tranceData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import tw.gov.npa.il.myDao.IL07C01CDao;

public class IL07C01C {
	private static final Logger logger = Logger.getLogger(IL07C01C.class);

//	ResourceBundle rb = ResourceBundle.getBundle("config");

//	private String contextPath = this.rb.getString("IL07C01CFileRoot").toString();

	public IL07C01CDao il07C01CDao;
	String contextPath;

	public IL07C01CDao getIl07C01CDao() {
		return this.il07C01CDao;
	}

	public void setIl07C01CDao(IL07C01CDao il07c01cDao) {
		this.il07C01CDao = il07c01cDao;
	}

	public static void main(String[] args) {

		IL07C01C test= new IL07C01C();
		test.contextPath = args[0];
		test.il07C01cMain();
	}
	
	public void il07C01cMain() {
		File dirPath = new File(contextPath);
		System.out.println(contextPath);
		File[] files;
		System.out.println(dirPath.isDirectory());
		if (dirPath.isDirectory()) {
			files = dirPath.listFiles();
			System.out.println(files.length);
			if (files.length > 0) {
				for(File file:files) {
					startJob(file, file.getName());
				}
			}
		}

	}

	private int startJob(File file, String fileName) {
		logger.info(contextPath + "\\" + fileName + "讀檔開始");

		int count = 0;
		int success = 0;
		List<Integer> failedNo = new ArrayList<Integer>();
		boolean result;
		if (file.exists()) {
			try {
				BufferedReader in = new BufferedReader(
						new InputStreamReader(new FileInputStream(file.getPath()), "ISO-8859-1"));

				while (in.ready()) {
					String str = in.readLine();
					count++;
					logger.info(count + " : " + str);

					if (!str.contains("%#")) {
						logger.error("第" + count + "行分隔號錯誤。");
						continue;
					}

					String[] strs = str.split("%#");

					if (strs.length != 7) {
						logger.error("第" + count + "行欄位數錯誤。");
						continue;
					}

					result = il07C01CDao.updateData(strs[1], strs[2], strs[3]);

					if (result) {
						success++;
					} else {
						failedNo.add(count);
					}

				}
				logger.info(contextPath + "\\" + fileName + "讀檔結束");
				logger.info("總共" + count + "筆，成功" + success + "筆");
				if (count != success) {
					for (Integer no : failedNo) {
						logger.error("第" + no + "筆失敗");
					}
				}
			} catch (Exception e) {
				logger.error(e.getStackTrace());
			}
		} else {
			logger.error(contextPath + "\\" + fileName + " 檔案不存在");
		}
		logger.info(contextPath + "\\" + fileName + "讀檔結束");

		return count;
	}
}
