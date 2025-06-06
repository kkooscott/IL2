package tw.gov.npa.il.tranceData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import org.apache.log4j.Logger;
import tw.gov.npa.il.e0db.myDao.RelationDAO;
import tw.gov.npa.il.myDao.IL08A01DAO;

public class IL08A01 {
	public IL08A01DAO iL08A01 = new IL08A01DAO();
	public DataSource dataSource;
	private String zipName;

	private int id;

	private ArrayList<File> jpgList = new ArrayList<File>();

	private ArrayList<String> filePathList = new ArrayList<String>();

	private static final Logger logger = Logger.getLogger(IL08A01.class);

	private int h_nImpTot = 0;

	private int h_nImpOK = 0;

	private int h_nImpErr1 = 0;

	private int h_nImpErr2 = 0;

	private int h_nImpErr3 = 0;

	private int h_nImpErr4 = 0;

//	ResourceBundle rb = ResourceBundle.getBundle("config");

//	private String contextPath = this.rb.getString("ReportRoot").toString();
	private String contextPath = "ReportRoot=D\\:\\IL2\\";

//	private String filePath = this.rb.getString("zipPath").toString();
	private String filePath = "IL";

	private ArrayList<String> failList = new ArrayList<String>();

	private RelationDAO relationDAO;

	public RelationDAO getRelationDAO() {
		return this.relationDAO;
	}

	public void setRelationDAO(RelationDAO relationDAO) {
		this.relationDAO = relationDAO;
	}

	public IL08A01DAO getIl08A01Dao() {
		return this.iL08A01;
	}

	public void setIl08A01Dao(IL08A01DAO il08a01Dao) {
		this.iL08A01 = il08a01Dao;
	}

	public void il08a01Main(String date, String password, int id) {
		this.id = id;
		this.jpgList.clear();
		this.filePathList.clear();
		this.failList.clear();
		this.h_nImpTot = 0;
		this.h_nImpOK = 0;
		this.h_nImpErr1 = 0;
		this.h_nImpErr2 = 0;
		this.h_nImpErr3 = 0;
		this.h_nImpErr4 = 0;
		this.zipName = date.substring(0, 4) + "." + date.substring(4, 6);
		extractZip(password);
		getFileList();
		processJpg();
		writeLog();
	}

	private void processJpg() {
		logger.info("處理圖檔及新增");
		int insertCount = 0;
		int updateCount = 0;
		int failCount = 0;
		for (int i = 0; i < this.jpgList.size(); i++) {
			String fileName = ((File) this.jpgList.get(i)).getName().substring(0, 10);
			if (i % 1000 == 0)
				logger.info("處理進度:" + i + "/" + this.jpgList.size() + "新增筆數:" + insertCount + " 更新筆數:" + updateCount
						+ " 失敗筆數:" + failCount);
			if (this.iL08A01.queryData(fileName)) {
				int control = 0;
				int dbcount = this.iL08A01.queryImg(fileName);
				if (dbcount == 2) {
					try {
						control = 3;
						String finalPath = moveFile(this.jpgList.get(i), "1");
						control = 2;
						this.iL08A01.updateImg(fileName + "1-0.jpg");
						updateCount++;
					} catch (IOException e) {
						failCount++;
						if (control == 3) {
							this.h_nImpErr3++;
							logger.info("Move Fail");
							this.failList.add("3" + ((File) this.jpgList.get(i)).getPath()
									+ ((File) this.jpgList.get(i)).getName());
						} else if (control == 2) {
							this.h_nImpErr2++;
							logger.info("Update Fail");
							this.failList.add("2" + ((File) this.jpgList.get(i)).getPath()
									+ ((File) this.jpgList.get(i)).getName());
						}
					}
				} else if (dbcount == 1) {
					try {
						control = 3;
						String path = moveFile(this.jpgList.get(i), "1");
						control = 2;
						if (this.iL08A01.queryImgbyIdnoseq(fileName, "1") != 0) {
							this.iL08A01.updateImg(fileName + "1-0.jpg");
						} else {
							this.iL08A01.insertIMG(fileName + "1-0.jpg", this.contextPath + path, path, "1");
						}
						this.h_nImpOK++;
						insertCount++;
					} catch (IOException e) {
						failCount++;
						if (control == 3) {
							this.h_nImpErr3++;
							logger.info("Move Fail");
							this.failList.add("3" + ((File) this.jpgList.get(i)).getPath()
									+ ((File) this.jpgList.get(i)).getName());
						} else if (control == 2) {
							this.h_nImpErr2++;
							logger.info("Insert Fail");
							this.failList.add("2" + ((File) this.jpgList.get(i)).getPath()
									+ ((File) this.jpgList.get(i)).getName());
						}
					}
				} else if (dbcount == 0) {
					try {
						control = 3;
						String path = moveFile(this.jpgList.get(i), "0");
						control = 2;
						this.iL08A01.insertIMG(fileName + "0-0.jpg", this.contextPath + path, path, "0");
						this.h_nImpOK++;
						insertCount++;
					} catch (IOException e) {
						failCount++;
						if (control == 3) {
							this.h_nImpErr3++;
							logger.info("Move Fail");
							this.failList.add("3" + ((File) this.jpgList.get(i)).getPath()
									+ ((File) this.jpgList.get(i)).getName());
						} else if (control == 2) {
							this.h_nImpErr2++;
							logger.info("Insert Fail");
							this.failList.add("2" + ((File) this.jpgList.get(i)).getPath()
									+ ((File) this.jpgList.get(i)).getName());
						}
					}
				}
			} else {
				this.h_nImpErr4++;
				logger.info(((File) this.jpgList.get(i)).getName() + ":no data found");
				this.failList.add("4" + ((File) this.jpgList.get(i)).getName());
			}
			((File) this.jpgList.get(i)).delete();
		}
	}

	private void writeLog() {
		logger.info("writeLog");
		String headerValue = "ERRTP    FILENAME \n";
		String computeValue = "--------------------------------------------------\nERRTP1:" + this.h_nImpErr1 + "\n"
				+ "ERRTP2:" + this.h_nImpErr2 + "\n" + "ERRTP3:" + this.h_nImpErr3 + "\n" + "ERRTP4:" + this.h_nImpErr4
				+ "\n" + "ImpOK :" + this.h_nImpOK + "\n" + "ImpTot:" + this.h_nImpTot + "\n";
		String tailValue = "--------------------------------------------------\nERRTP1:解壓縮失敗 \nERRTP2:新增/更新失敗\nERRTP3:檔案搬移/更新 失敗(磁碟空間不足或損毀)\nERRTP4: ILTB01主檔無資料";
		try {
			BufferedWriter bw = new BufferedWriter(
					new FileWriter(this.filePath + this.zipName + "_" + this.id + "_err.txt"));
			if (bw != null) {
				bw.write(headerValue);
				for (int i = 0; i < this.failList.size(); i++) {
					bw.write(((String) this.failList.get(i)).substring(0, 1) + "        "
							+ ((String) this.failList.get(i)).substring(1));
					bw.newLine();
				}
			}
			bw.write(computeValue);
			bw.write(tailValue);
			bw.close();
			logger.info("writeLog done");
		} catch (IOException e) {
			e.printStackTrace();
			logger.info(e.toString());
		}
	}

	private void extractZip(String password) {
		logger.info("開始解壓縮!! 執行時間:" + new Date());
		try {
			ZipFile zipFile = new ZipFile(this.filePath + this.zipName + ".zip");
			if (zipFile.isEncrypted())
				zipFile.setPassword(password);
			List<FileHeader> fileHeaderList = zipFile.getFileHeaders();
			for (int i = 0; i < fileHeaderList.size(); i++) {
				FileHeader fileHeader = fileHeaderList.get(i);
				if (i % 1000 == 0)
					logger.info("處理進度:" + i + "/" + fileHeaderList.size());
				if (fileHeader.getFileName().endsWith(".jpg") || fileHeader.getFileName().endsWith(".JPG"))
					try {
						zipFile.extractFile(fileHeader, this.filePath);
					} catch (ZipException e) {
						this.h_nImpErr1++;
						logger.info(fileHeader.getFileName() + " 無法解壓縮 請確定密碼是否正確或檔案是否完整");
						this.failList.add("1" + fileHeader.getFileName());
					}
			}
		} catch (ZipException e) {
			logger.info("解壓縮失敗 請確定密碼是否正確或檔案是否存在");
		}
		logger.info("解壓縮完畢!! 結束時間:" + new Date());
	}

	private String moveFile(File oldFile, String fileseq) throws IOException {
		String fileName = oldFile.getName();
		String movePath = "\\PICTURES\\\\FR\\\\" + fileName.substring(0, 1) + "\\\\" + fileName.substring(1, 2) + "\\\\"
				+ fileName.substring(2, 5) + "\\\\" + fileName.substring(5, 8) + "\\\\";
		File newFile = new File(this.contextPath + movePath + fileName.substring(0, 10) + fileseq + "-0.jpg");
		if (!newFile.exists()) {
			newFile.getParentFile().mkdirs();
			newFile.createNewFile();
		}
		InputStream in = new FileInputStream(oldFile);
		OutputStream out = new FileOutputStream(newFile);
		byte[] buf = new byte[1024];
		int len;
		while ((len = in.read(buf)) > 0)
			out.write(buf, 0, len);
		in.close();
		out.close();
		oldFile.delete();
		return movePath;
	}

	private void getFileList() {
		File fileList = new File(this.filePath);
		logger.info("取得檔案清單");
		File[] fileNameList = fileList.listFiles();
		for (int i = 0; i < fileNameList.length; i++) {
			if (fileNameList[i].isFile()
					&& (fileNameList[i].getName().endsWith(".jpg") || fileNameList[i].getName().endsWith(".JPG"))) {
				this.h_nImpTot++;
				logger.info(Integer.valueOf(this.h_nImpTot));
				if (!searchFailList(fileNameList[i].getName()))
					this.jpgList.add(fileNameList[i]);
			} else if (fileNameList[i].isDirectory()) {
				getFile(fileNameList[i].getPath());
			}
		}
	}

	private boolean searchFailList(String name) {
		for (int i = 0; i < this.failList.size(); i++) {
			if (name.trim().equals(((String) this.failList.get(i)).substring(1).trim()))
				return true;
		}
		return false;
	}

	private void getFile(String path) {
		try {
			File name = new File(path);
			File[] directory = name.listFiles();
			for (File f : directory) {
				if ((f.isFile() && f.getName().endsWith(".jpg")) || f.getName().endsWith(".JPG")) {
					this.h_nImpTot++;
					if (!searchFailList(f.getName()))
						this.jpgList.add(f);
				} else if (f.isDirectory()) {
					getFile(f.getPath());
				}
			}
		} catch (Exception e) {
		}
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\tranceData\IL08A01.
 * class Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */