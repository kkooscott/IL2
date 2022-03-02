// 檢查輸入是否為空
function validateNull(txtInput){
	txtInput = txtInput.trim();
	if( txtInput == "" ) return 0;
	return 1;
}

// 檢查輸入是否為四位英數字
function validate4digit(txtInput){
	txtInput = txtInput.trim();
	if( txtInput.length != 4 ) return 0;
	return 1;
}

/*
function validateRadio(r){
	if( r == false ) return 0;
	return 1;
}
*/