package tw.gov.npa.il.report.data;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.log4j.Logger;
import tw.gov.npa.il.report.data.il04a01.Builder08A01P;
import tw.gov.npa.il.report.data.il04a01.Builder08A02P;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_01;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_02;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_03;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_04;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_05;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_06;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_07;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_08;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_09;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_10;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_11;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_12;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_13;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_14;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_15;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_16;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_17;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_18;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_19;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_20;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_21;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_22;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_23;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_24;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_25;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_26;
import tw.gov.npa.il.report.data.il04a01.Builder08A07P_27;
import tw.gov.npa.il.report.data.il04a01.Builder08A08P;
import tw.gov.npa.il.report.data.il04a01.Builder08A09P;
import tw.gov.npa.il.report.data.il04a01.Builder08A10P;
import tw.gov.npa.il.report.data.il04a01.Builder08A11P;
import tw.gov.npa.il.report.data.il04a01.Builder08A12P;
import tw.gov.npa.il.report.data.il04a01.Builder08A13P;
import tw.gov.npa.il.report.data.il04a01.Builder08A14P;
import tw.gov.npa.il.report.data.il04a01.Builder08A14_10P;
import tw.gov.npa.il.report.data.il04a01.Builder08A14_11P;
import tw.gov.npa.il.report.data.il04a01.Builder08A14_12P;
import tw.gov.npa.il.report.data.il04a01.Builder08A14_13P;
import tw.gov.npa.il.report.data.il04a01.Builder08A14_14P;
import tw.gov.npa.il.report.data.il04a01.Builder08A14_15P;
import tw.gov.npa.il.report.data.il04a01.Builder08A14_16P;
import tw.gov.npa.il.report.data.il04a01.Builder08A14_17P;
import tw.gov.npa.il.report.data.il04a01.Builder08A14_18P;
import tw.gov.npa.il.report.data.il04a01.Builder08A14_19P;
import tw.gov.npa.il.report.data.il04a01.Builder08A14_20P;
import tw.gov.npa.il.report.data.il04a01.Builder08A14_21P;
import tw.gov.npa.il.report.data.il04a01.Builder08A14_2P;
import tw.gov.npa.il.report.data.il04a01.Builder08A14_3P;
import tw.gov.npa.il.report.data.il04a01.Builder08A14_4P;
import tw.gov.npa.il.report.data.il04a01.Builder08A14_5P;
import tw.gov.npa.il.report.data.il04a01.Builder08A14_6P;
import tw.gov.npa.il.report.data.il04a01.Builder08A14_7P;
import tw.gov.npa.il.report.data.il04a01.Builder08A14_8P;
import tw.gov.npa.il.report.data.il04a01.Builder08A14_9P;
import tw.gov.npa.il.report.data.il04a01.Builder08A15P;
import tw.gov.npa.il.report.data.il04a01.Builder08A16P;
import tw.gov.npa.il.report.data.il04a01.Builder08A17P;
import tw.gov.npa.il.report.data.il04a01.Builder08A18P;
import tw.gov.npa.il.report.data.il04a01.Builder08A19P;
import tw.gov.npa.il.report.data.il04a01.Builder08A22P;
import tw.gov.npa.il.report.data.il04a01.Builder08A23P;
import tw.gov.npa.il.report.data.il04a01.Builder08A27P;
import tw.gov.npa.il.report.data.il04a01.Builder08A28P;
import tw.gov.npa.il.report.data.il04a01.Builder08A29P;
import tw.gov.npa.il.report.data.il04a01.Builder08A30P;
import tw.gov.npa.il.report.data.il04a01.Builder08A31P;
import tw.gov.npa.il.report.data.il04a01.Builder08A32P;
import tw.gov.npa.il.report.data.il04a01.Builder08A33P;

public class IL04A01ReportData {
	private static final Logger logger = Logger.getLogger(IL04A01ReportData.class);

	public static JRBeanCollectionDataSource buildDataSourceIL08A01P() {
		return Builder08A01P.build();
	}

	public static JRBeanCollectionDataSource buildDataSourceIL08A02P() {
		return Builder08A02P.build();
	}

	public static JRBeanCollectionDataSource buildDataSourceIL08A07P() {
		return Builder08A07P.build();
	}
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_01(){
		return Builder08A07P_01.build();
	}
	
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_02() {
		return Builder08A07P_02.build();
    }
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_03() {
		return Builder08A07P_03.build();
    }
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_04() {
		return Builder08A07P_04.build();
    }
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_05() {
		return Builder08A07P_05.build();
    }
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_06() {
		return Builder08A07P_06.build();
    }
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_07() {
		return Builder08A07P_07.build();
    }
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_08() {
		return Builder08A07P_08.build();
    }
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_09() {
		return Builder08A07P_09.build();
    }
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_10() {
		return Builder08A07P_10.build();
    }
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_11() {
		return Builder08A07P_11.build();
    }
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_12() {
		return Builder08A07P_12.build();
    }
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_13() {
		return Builder08A07P_13.build();
    }
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_14() {
		return Builder08A07P_14.build();
    }
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_15() {
		return Builder08A07P_15.build();
    }
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_16() {
		return Builder08A07P_16.build();
    }
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_17() {
		return Builder08A07P_17.build();
    }
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_18() {
		return Builder08A07P_18.build();
    }
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_19() {
		return Builder08A07P_19.build();
    }
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_20() {
		return Builder08A07P_20.build();
    }
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_21() {
		return Builder08A07P_21.build();
    }
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_22() {
		return Builder08A07P_22.build();
    }
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_23() {
		return Builder08A07P_23.build();
    }
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_24() {
		return Builder08A07P_24.build();
    }
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_25() {
		return Builder08A07P_25.build();
    }
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_26() {
		return Builder08A07P_26.build();
    }
	public static JRBeanCollectionDataSource buildDataSourceIL08A07P_27() {
		return Builder08A07P_27.build();
    }
	public static JRBeanCollectionDataSource buildDataSourceIL08A08P() {
		return Builder08A08P.build();
	}

	public static JRBeanCollectionDataSource buildDataSourceIL08A09P() {
		return Builder08A09P.build();
	}

	public static JRBeanCollectionDataSource buildDataSourceIL08A10P() {
		return Builder08A10P.build();
	}

	public static JRBeanCollectionDataSource buildDataSourceIL08A11P() {
		return Builder08A11P.build();
	}

	public static JRBeanCollectionDataSource buildDataSourceIL08A12P() {
		return Builder08A12P.build();
	}

	public static JRBeanCollectionDataSource buildDataSourceIL08A13P() {
		return Builder08A13P.build();
	}

	public static JRBeanCollectionDataSource buildDataSourceIL08A14P() {
		return Builder08A14P.build();
	}

	public static JRBeanCollectionDataSource buildDataSourceIL08A14_2P() {
		return Builder08A14_2P.build();
	}

	public static JRBeanCollectionDataSource buildDataSourceIL08A14_3P() {
		return Builder08A14_3P.build();
	}

	public static JRBeanCollectionDataSource buildDataSourceIL08A14_4P() {
		return Builder08A14_4P.build();
	}

	public static JRBeanCollectionDataSource buildDataSourceIL08A14_5P(){
		return Builder08A14_5P.build();
	}
	public static JRBeanCollectionDataSource buildDataSourceIL08A14_6P(){
		return Builder08A14_6P.build();
	}
	public static JRBeanCollectionDataSource buildDataSourceIL08A14_7P(){
		return Builder08A14_7P.build();
	}
	public static JRBeanCollectionDataSource buildDataSourceIL08A14_8P(){
		return Builder08A14_8P.build();
	}
	public static JRBeanCollectionDataSource buildDataSourceIL08A14_9P(){
		return Builder08A14_9P.build();
	}
	public static JRBeanCollectionDataSource buildDataSourceIL08A14_10P(){
		return Builder08A14_10P.build();
	}
	public static JRBeanCollectionDataSource buildDataSourceIL08A14_11P(){
		return Builder08A14_11P.build();
	}
	public static JRBeanCollectionDataSource buildDataSourceIL08A14_12P(){
		return Builder08A14_12P.build();
	}
	public static JRBeanCollectionDataSource buildDataSourceIL08A14_13P(){
		return Builder08A14_13P.build();
	}
	public static JRBeanCollectionDataSource buildDataSourceIL08A14_14P(){
		return Builder08A14_14P.build();
	}
	public static JRBeanCollectionDataSource buildDataSourceIL08A14_15P(){
		return Builder08A14_15P.build();
	}
	public static JRBeanCollectionDataSource buildDataSourceIL08A14_16P(){
		return Builder08A14_16P.build();
	}
	public static JRBeanCollectionDataSource buildDataSourceIL08A14_17P(){
		return Builder08A14_17P.build();
	}
	public static JRBeanCollectionDataSource buildDataSourceIL08A14_18P(){
		return Builder08A14_18P.build();
	}
	public static JRBeanCollectionDataSource buildDataSourceIL08A14_19P(){
		return Builder08A14_19P.build();
	}
	public static JRBeanCollectionDataSource buildDataSourceIL08A14_20P(){
		return Builder08A14_20P.build();
	}
	
	public static JRBeanCollectionDataSource buildDataSourceIL08A14_21P(){
		return Builder08A14_21P.build();
	}
	
	public static JRBeanCollectionDataSource buildDataSourceIL08A15P() {
		return Builder08A15P.build();
	}

	public static JRBeanCollectionDataSource buildDataSourceIL08A16P() {
		return Builder08A16P.build();
	}

	public static JRBeanCollectionDataSource buildDataSourceIL08A17P() {
		return Builder08A17P.build();
	}

	public static JRBeanCollectionDataSource buildDataSourceIL08A18P() {
		return Builder08A18P.build();
	}

	public static JRBeanCollectionDataSource buildDataSourceIL08A19P() {
		return Builder08A19P.build();
	}

	public static JRBeanCollectionDataSource buildDataSourceIL08A29P() {
		return Builder08A29P.build();
	}

	public static JRBeanCollectionDataSource buildDataSourceIL08A22P() {
		return Builder08A22P.build();
	}

	public static JRBeanCollectionDataSource buildDataSourceIL08A23P() {
		return Builder08A23P.build();
	}

	public static JRBeanCollectionDataSource buildDataSourceIL08A27P() {
		return Builder08A27P.build();
	}

	public static JRBeanCollectionDataSource buildDataSourceIL08A30P() {
		return Builder08A30P.build();
	}

	public static JRBeanCollectionDataSource buildDataSourceIL08A28P() {
		return Builder08A28P.build();
	}

	public static JRBeanCollectionDataSource buildDataSourceIL08A33P() {
		return Builder08A33P.build();
	}

	public static JRBeanCollectionDataSource buildDataSourceIL08A31P() {
		return Builder08A31P.build();
	}

	public static JRBeanCollectionDataSource buildDataSourceIL08A32P() {
		return Builder08A32P.build();
	}

	public static void main(String[] args) throws JRException {
		buildDataSourceIL08A01P();
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\data\
 * IL04A01ReportData.class Java compiler version: 5 (49.0) JD-Core Version:
 * 1.1.3
 */