<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>
    <title>居留外僑動態管理系統-統計報表作業</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/domtab.css"/>
    <script src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/domtab.js"></script>   
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>	
    
	<script type="text/javascript">
	$(function() {	
		
	});//$(function() {
	
	//表單送出事件
	function onSubmit(url){
		document.queryForm.action=url;
		document.queryForm.submit();
	}
	</script>
    
</head>

<body>
<div id="reportPosition" class="reportPosition">
<DIV><PRE style="line-height: 100%; word-spacing: 0; margin-top: 0; margin-bottom: 0"><FONT size="2" face="細明體">
                                                                                ＊警政署　自由檢索報表（按居留目的及職業分）

製表單位：警政署資訊室作業設計科
製表日期：2012/12/12                                                                                                                                                                              頁次：1 頁
┌──────────┬─────┬───────────┬───────────────────────────────────────────────────────────────────────┐
│                    │          │                      │                                                                    依                         親                                             │
│                    │          │                      ├───────────┬───────────────────────────────────────────────────────────┤
│                    │          │     合        計     │                      │                                            依       本       國       人                                             │
│   職    業    別   │ 總    計 │                      │     小        計     ├───────────┬───────────┬───────────┬───────────┬───────────┤
│                    │          │                      │                      │     小        計     │     依   配   偶     │     依   子   女     │     依   父   母     │     其        他     │
│                    │          ├─────┬─────┼─────┬─────┼─────┬─────┼─────┬─────┼─────┬─────┼─────┬─────┼─────┬─────┤
│                    │          │    男    │    女    │    男    │    女    │    男    │    女    │    男    │    女    │    男    │    女    │    男    │    女    │    男    │    女    │
├──────────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┤
│  合  計            │ 2,747,355│ 1,347,855│ 1,399,500│    47,943│   205,950│    30,264│   164,029│    17,758│   154,553│       100│       358│    12,128│     8,900│       278│       218│
│公務人員            │        72│        52│        20│         2│        11│         1│         8│         1│         8│         0│         0│         0│         0│         0│         0│
│商務人員            │    26,075│    23,530│     2,545│     1,379│       266│     1,223│       160│     1,211│       154│         3│         1│         8│         3│         1│         2│
│工程師              │    20,185│    19,428│       757│       675│        76│       599│        48│       598│        48│         1│         0│         0│         0│         0│         0│
│會計師              │        86│        51│        35│         8│        15│         7│         9│         7│         9│         0│         0│         0│         0│         0│         0│
│律師                │        73│        61│        12│        13│         4│        11│         2│        10│         2│         0│         0│         1│         0│         0│         0│
│記者                │       198│       150│        48│        15│         1│        15│         0│        15│         0│         0│         0│         0│         0│         0│         0│
│教師                │    33,566│    19,091│    14,475│     1,702│       520│     1,541│       266│     1,536│       262│         0│         0│         5│         4│         0│         0│
│醫師                │     1,085│       778│       307│        89│        38│        79│        29│        73│        28│         0│         0│         5│         1│         1│         0│
│護理人員            │        79│        18│        61│         2│        14│         2│         8│         2│         7│         0│         0│         0│         1│         0│         0│
│傳教士              │     8,263│     5,382│     2,881│        65│        76│        49│        26│        47│        23│         1│         0│         1│         3│         0│         0│
│技工技匠            │     3,558│     2,954│       604│       265│       506│       233│       494│       230│       494│         1│         0│         1│         0│         1│         0│
│　|小      計       │        14│         2│        12│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│
│　|營建業技工       │   210,411│   208,830│     1,581│         0│         4│         0│         4│         0│         4│         0│         0│         0│         0│         0│         0│
│外|製造業技工       │ 1,216,425│   854,539│   361,886│         2│        10│         2│         9│         2│         9│         0│         0│         0│         0│         0│         0│
│籍|家庭幫傭         │    58,484│     4,851│    53,633│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│
│勞|監護工           │   706,819│    14,709│   692,110│         0│         7│         0│         5│         0│         5│         0│         0│         0│         0│         0│         0│
│工|船員(外籍勞工)   │    27,242│    27,031│       211│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│
│　|其他(外籍勞工)   │    61,326│    49,256│    12,070│         2│        42│         1│        31│         0│        31│         0│         0│         1│         0│         0│         0│
│船員                │     2,365│     2,343│        22│         8│        11│         4│        10│         4│        10│         0│         0│         0│         0│         0│         0│
│其他(有業者)        │    88,001│    48,437│    39,564│    15,403│    29,247│    11,940│    22,482│    10,118│    20,939│        52│        81│     1,715│     1,420│        55│        42│
│失業                │    15,131│     8,438│     6,693│     7,856│     6,363│     5,239│     3,439│     3,104│     1,812│         0│         1│     2,066│     1,584│        69│        42│
│家務                │   157,165│         0│   157,165│         0│   151,854│         0│   130,441│         0│   130,110│         0│       218│         0│       104│         0│         9│
│學生                │    86,417│    44,530│    41,887│     7,330│     6,145│     4,005│     3,189│       444│       557│         0│         0│     3,513│     2,570│        48│        62│
│其他(無業者)        │       859│       633│       226│       494│       186│       401│        90│       352│        29│        42│        57│         5│         3│         2│         1│
│未滿十五足歲兒童    │    23,470│    12,763│    10,707│    12,633│    10,554│     4,912│     3,279│         4│        12│         0│         0│     4,807│     3,207│       101│        60│
└──────────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┘
</FONT></PRE></DIV>
<DIV style="page-break-before:always"><PRE style="line-height: 100%; word-spacing: 0; margin-top: 0; margin-bottom: 0"><FONT size="2" face="細明體">
                                                                                      ＊警政署　自由檢索報表（按居留目的及職業分）

製表單位：警政署資訊室作業設計科
製表日期：2012/12/12                                                                                                                                                                                          頁次：2 頁
┌──────────┬───────────────────────────────────────────────────────────┬───────────┬───────────┬───────────┐
│                    │                                            依                         親                                             │                      │                      │                      │
│                    ├───────────────────────────────────────────────────────────┤                      │                      │                      │
│                    │                                            依       外       國       人                                             │    就         學     │    應          聘    │    投          資    │
│   職    業    別   ├───────────┬───────────┬───────────┬───────────┬───────────┤                      │                      │                      │
│                    │    小         計     │     依   配   偶     │     依   子   女     │     依   父   母     │     其        他     │                      │                      │                      │
│                    ├─────┬─────┼─────┬─────┼─────┬─────┼─────┬─────┼─────┬─────┼─────┬─────┼─────┬─────┼─────┬─────┤
│                    │    男    │    女    │    男    │    女    │    男    │    女    │    男    │    女    │    男    │    女    │    男    │    女    │    男    │    女    │    男    │    女    │
├──────────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┤
│  合  計            │    17,679│    41,921│        36│       411│         0│         2│       241│       225│    17,402│    41,283│    36,991│    35,965│    87,275│    23,068│       809│       105│
│公務人員            │         1│         3│         0│         0│         0│         0│         0│         0│         1│         3│         4│         5│        16│         3│         0│         0│
│商務人員            │       156│       106│         1│         0│         0│         0│         0│         0│       155│       106│        52│        15│    20,407│     1,978│       599│        55│
│工程師              │        76│        28│         1│         1│         0│         0│         0│         0│        75│        27│        28│         3│    18,045│       626│        15│         0│
│會計師              │         1│         6│         0│         1│         0│         0│         0│         0│         1│         5│         1│         0│        36│        13│         0│         0│
│律師                │         2│         2│         0│         0│         0│         0│         0│         0│         2│         2│         0│         1│        47│         6│         0│         1│
│記者                │         0│         1│         0│         0│         0│         0│         0│         0│         0│         1│         2│         1│       126│        40│         0│         0│
│教師                │       161│       254│         1│         9│         0│         0│         0│         0│       160│       245│       142│       143│    16,328│    13,431│         1│         1│
│醫師                │        10│         9│         0│         1│         0│         0│         0│         0│        10│         8│        28│        10│       353│       138│         4│         0│
│護理人員            │         0│         6│         0│         0│         0│         0│         0│         0│         0│         6│         0│         0│        14│        31│         0│         0│
│傳教士              │        16│        50│         0│         2│         0│         0│         0│         0│        16│        48│        48│        59│        63│        21│         3│         1│
│技工技匠            │        32│        12│         1│         1│         0│         0│         0│         0│        31│        11│         2│         1│     2,568│        60│         3│         0│
│　|小      計       │         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│
│　|營建業技工       │         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         2│         0│         0│         0│
│外|製造業技工       │         0│         1│         0│         0│         0│         0│         0│         0│         0│         1│         1│         1│         4│         1│         0│         0│
│籍|家庭幫傭         │         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         2│        17│         0│         0│
│勞|監護工           │         0│         2│         0│         0│         0│         0│         0│         0│         0│         2│         1│         0│         0│         1│         0│         0│
│工|船員(外籍勞工)   │         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         6│         0│         0│         0│
│　|其他(外籍勞工)   │         1│        11│         0│         0│         0│         0│         0│         0│         1│        11│         6│        10│        16│        14│         0│         0│
│船員                │         4│         1│         0│         0│         0│         0│         0│         0│         4│         1│         2│         1│     2,323│         7│         0│         0│
│其他(有業者)        │     3,463│     6,765│        15│       137│         0│         1│        41│        38│     3,407│     6,589│     1,540│     1,190│    25,779│     5,645│       176│        39│
│失業                │     2,617│     2,924│        13│        25│         0│         0│        11│        21│     2,593│     2,878│        99│        75│       136│        40│         1│         0│
│家務                │         0│    21,413│         0│       232│         0│         1│         0│         0│         0│    21,180│         0│       191│         0│       303│         0│         5│
│學生                │     3,325│     2,956│         3│         1│         0│         0│        34│        26│     3,288│     2,929│    34,958│    34,183│       984│       684│         6│         3│
│其他(無業者)        │        93│        96│         0│         1│         0│         0│         0│         0│        93│        95│         0│         1│        16│         1│         1│         0│
│未滿十五足歲兒童    │     7,721│     7,275│         1│         0│         0│         0│       155│       140│     7,565│     7,135│        77│        75│         4│         8│         0│         0│
└──────────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┘
</FONT></PRE></DIV>
<DIV style="page-break-before:always"><PRE style="line-height: 100%; word-spacing: 0; margin-top: 0; margin-bottom: 0"><FONT size="2" face="細明體">
                                                                                      ＊警政署　自由檢索報表（按居留目的及職業分）

製表單位：警政署資訊室作業設計科
製表日期：2012/12/12                                                                                                                                                                                          頁次：3 頁
┌──────────┬───────────┬───────────┬───────────┬───────────────────────────────────────────────────────────┐
│                    │                      │                      │                      │                                                                                                                      │
│                    │                      │                      │                      │                                                  永  久  居  留                                                      │
│                    │    傳          教    │    外  籍  勞  工    │    其          他    │                                                                                                                      │
│   職    業    別   │                      │                      │                      ├───────────┬───────────┬───────────┬───────────┬───────────┤
│                    │                      │                      │                      │     合        計     │   連 續 居 留 七 年  │  居 留 五 年 配 偶   │  依 親 五 年 子 女   │ 依 親 居 住 十 五 年 │
│                    ├─────┬─────┼─────┬─────┼─────┬─────┼─────┬─────┼─────┬─────┼─────┬─────┼─────┬─────┼─────┬─────┤
│                    │    男    │    女    │    男    │    女    │    男    │    女    │    男    │    女    │    男    │    女    │    男    │    女    │    男    │    女    │    男    │    女    │
├──────────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┤
│  合  計            │     5,341│     2,822│ 1,159,191│ 1,121,402│     6,284│     7,436│     4,021│     2,752│     2,480│       885│     1,338│     1,748│        23│        22│        22│        13│
│公務人員            │         0│         0│         0│         0│        30│         1│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│
│商務人員            │         5│         0│         0│         0│       276│       123│       812│       108│       602│        80│       194│        23│         2│         3│         4│         0│
│工程師              │         9│         4│         0│         0│       216│         2│       440│        46│       349│        38│        76│         7│         2│         0│         0│         0│
│會計師              │         0│         0│         0│         0│         2│         2│         4│         5│         4│         2│         0│         3│         0│         0│         0│         0│
│律師                │         0│         0│         0│         0│         0│         0│         1│         0│         0│         0│         1│         0│         0│         0│         0│         0│
│記者                │         0│         0│         0│         0│         3│         0│         4│         6│         2│         5│         1│         1│         0│         0│         0│         0│
│教師                │        31│        30│         0│         0│        99│        90│       788│       260│       538│       184│       213│        64│         1│         0│         2│         0│
│醫師                │         1│         0│         0│         0│       159│        52│       144│        69│       111│        62│        27│         5│         0│         0│         0│         0│
│護理人員            │         0│         0│         0│         0│         1│         6│         1│        10│         0│         9│         0│         0│         0│         0│         0│         0│
│傳教士              │     4,893│     2,495│         0│         0│        57│        74│       253│       155│       210│       137│         8│         0│         0│         0│         0│         0│
│技工技匠            │         0│         0│         0│         0│        75│        24│        41│        13│        14│         1│        23│        12│         0│         0│         0│         0│
│　|小      計       │         0│         0│         0│         0│         2│        12│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│
│　|營建業技工       │         0│         0│   208,828│     1,577│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│
│外|製造業技工       │         0│         0│   854,532│   361,874│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│
│籍|家庭幫傭         │         0│         0│     4,849│    53,615│         0│         1│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│
│勞|監護工           │         0│         0│    14,708│   692,094│         0│         8│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│
│工|船員(外籍勞工)   │         0│         0│    27,025│       211│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│
│　|其他(外籍勞工)   │         0│         0│    49,230│    12,001│         2│         3│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│
│船員                │         0│         1│         0│         0│         9│         2│         1│         0│         0│         0│         1│         0│         0│         0│         0│         0│
│其他(有業者)        │       337│       188│         1│         2│     3,984│     2,599│     1,217│       654│       589│       221│       570│       403│         6│         2│         7│         3│
│失業                │        10│         7│         0│         0│       158│       174│       178│        34│        10│         4│       163│        27│         1│         1│         0│         0│
│家務                │         0│        39│         0│         0│         0│     3,429│         0│     1,344│         0│       128│         0│     1,184│         0│         7│         0│         5│
│學生                │        51│        58│         0│         0│     1,109│       767│        92│        47│        45│        13│        23│        19│        11│         9│         9│         5│
│其他(無業者)        │         2│         0│         0│         0│        75│        37│        45│         1│         6│         1│        38│         0│         0│         0│         0│         0│
│未滿十五足歲兒童    │         2│         0│        18│        28│        29│        42│         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│
└──────────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┘
</FONT></PRE></DIV>
<DIV style="page-break-before:always"><PRE style="line-height: 100%; word-spacing: 0; margin-top: 0; margin-bottom: 0"><FONT size="2" face="細明體">
                                                                                      ＊警政署　自由檢索報表（按居留目的及職業分）

製表單位：警政署資訊室作業設計科
製表日期：2012/12/12                                                                                                                                                                                          頁次：4 頁
┌──────────┬───────────────────────────────────────────────────────────┐
│                    │                                                                                                                      │
│                    │                                                  永  久  居  留                                                      │
│                    │                                                                                                                      │
│   職    業    別   ├───────────┬───────────┬───────────┬───────────┬───────────┤
│                    │   依 親 居 住 十 年  │   居 住 二 十 年 者  │    高 科 技 人 士    │    特 殊 貢 獻 者    │      其      他      │
│                    ├─────┬─────┼─────┬─────┼─────┬─────┼─────┬─────┼─────┬─────┤
│                    │    男    │    女    │    男    │    女    │    男    │    女    │    男    │    女    │    男    │    女    │
├──────────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┤
│  合  計            │        26│        20│        33│        19│         1│         1│        11│         7│        87│        37│
│公務人員            │         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│
│商務人員            │         4│         0│         2│         1│         0│         0│         0│         0│         4│         1│
│工程師              │         1│         0│         1│         0│         0│         1│         0│         0│        11│         0│
│會計師              │         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│
│律師                │         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│
│記者                │         0│         0│         0│         0│         0│         0│         1│         0│         0│         0│
│教師                │         3│         1│         2│         0│         0│         0│         2│         0│        27│        11│
│醫師                │         0│         0│         0│         0│         0│         0│         0│         0│         6│         2│
│護理人員            │         0│         0│         0│         0│         0│         0│         0│         0│         1│         1│
│傳教士              │         0│         0│        22│        12│         0│         0│         4│         5│         9│         1│
│技工技匠            │         1│         0│         1│         0│         0│         0│         0│         0│         2│         0│
│　|小      計       │         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│
│　|營建業技工       │         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│
│外|製造業技工       │         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│
│籍|家庭幫傭         │         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│
│勞|監護工           │         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│
│工|船員(外籍勞工)   │         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│
│　|其他(外籍勞工)   │         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│
│船員                │         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│
│其他(有業者)        │         9│         3│         5│         6│         1│         0│         4│         1│        26│        15│
│失業                │         3│         1│         0│         0│         0│         0│         0│         0│         1│         1│
│家務                │         0│        14│         0│         0│         0│         0│         0│         1│         0│         5│
│學生                │         4│         1│         0│         0│         0│         0│         0│         0│         0│         0│
│其他(無業者)        │         1│         0│         0│         0│         0│         0│         0│         0│         0│         0│
│未滿十五足歲兒童    │         0│         0│         0│         0│         0│         0│         0│         0│         0│         0│
└──────────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┘
</FONT></PRE></DIV>
</div>
</body>
</html>