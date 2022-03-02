function myBestTrim(str){
  var start = -1,
  end = str.length;
  while (str.charCodeAt(--end) < 33);
  while (str.charCodeAt(++start) < 33);
  return str.slice(start, end + 1);
}

function sleep( seconds ) {
	var timer = new Date();
	var time = timer.getTime();
	do
		timer = new Date();
	while( (timer.getTime() - time) < (seconds * 1000) );
}

/**
檢查E-mail格式
返回值：0：不是 ; 1：是
**/
function chkemail(a){ 
	var i=a.length;     
	var temp = a.indexOf('@');     
	var tempd = a.indexOf('.');     
	if (temp > 1) {     
		if ((i-temp) > 3){     
			if ((i-tempd)>0){     
				return 1;     
			}     
		}     
	}     
	return 0;     
}

/**限定表單項不能輸入的字元**/
function contain(str,charset){// 字串包含測試函數 
	var i;
	for(i=0;i<charset.length;i++){
		if(str.indexOf(charset.charAt(i))>=0){
			return true;
		}			
	}
	return false;
}  

/**數字驗證**/
function isNumber(name){  
	if(name.length == 0){
		return false;
	}
	for(i = 0;i<name.length;i++){  
		if(name.charAt(i) < "0" || name.charAt(i) > "9"){
			return false;
		}
	}
	return true;
}