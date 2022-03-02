// 檢查輸入是否為空
function validateNull(txtInput){
	var start = -1,
	end = txtInput.length;
	while (txtInput.charCodeAt(--end) < 33);
	while (txtInput.charCodeAt(++start) < 33);
	if( txtInput.slice(start, end + 1) == "" ) return 0;
	return 1;
}

//檢查輸入格式(a:字母位數   b:數字位數)
function validateFormat(txtInput, a, b){
	var len = a + b;
	var data = new Array(len);
	data = txtInput.split("");
	for(var i = 0; i < a; i++) if( data[i] == data[i].toLowerCase() ) return 0;
	for(var i = 0; i < a; i++) if( !isNaN(data[i]) ) return 0;
	for(var i = a; i < len; i++) if( isNaN(data[i]) ) return 0;
	return 1;
}