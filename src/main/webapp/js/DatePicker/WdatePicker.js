/*
 * My97 DatePicker 4.8 Beta3
 * License: http://www.my97.net/dp/license.asp
 */
var $dp,WdatePicker;(function(){
var $={
	$langList:[
		{name:"en",charset:"UTF-8"},
		{name:"zh-cn",charset:"UTF-8"},
		{name:"zh-tw",charset:"UTF-8"}
	],
	$skinList:[
		{name:"default",charset:"gb2312"},
		{name:"whyGreen",charset:"gb2312"},
		{name:"blue",charset:"gb2312"},
		{name:"ext",charset:"gb2312"},
		{name:"twoer",charset:"gb2312"}],
	$wdate:true,
	$crossFrame:true,
	$preLoad:false,
	$dpPath:"",
	doubleCalendar:false,
	enableKeyboard:true,
	enableInputMask:true,
	autoUpdateOnChanged:null,
	weekMethod:"ISO8601",
	position:{},
	lang:"auto",
	skin:"default",
	dateFmt:"yyyy-MM-dd",
	realDateFmt:"yyyy-MM-dd",
	realTimeFmt:"HH:mm:ss",
	realFullFmt:"%Date %Time",
	minDate:"1911-01-01 00:00:00",
	maxDate:"2099-12-31 23:59:59",
	startDate:"",
	alwaysUseStartDate:false,
	yearOffset:1911,
	firstDayOfWeek:0,
	isShowWeek:false,
	highLineWeekDay:true,
	isShowClear:true,
	isShowToday:true,
	isShowOK:true,
	isShowOthers:true,
	readOnly:false,
	errDealMode:0,
	autoPickDate:null,
	qsEnabled:true,
	autoShowQS:false,
	specialDates:null,
	specialDays:null,
	disabledDates:null,
	disabledDays:null,
	opposite:false,
	onpicking:null,
	onpicked:null,
	onclearing:null,
	oncleared:null,
	ychanging:null,
	ychanged:null,
	Mchanging:null,
	Mchanged:null,
	dchanging:null,
	dchanged:null,
	Hchanging:null,
	Hchanged:null,
	mchanging:null,
	mchanged:null,
	schanging:null,
	schanged:null,
	eCont:null,
	vel:null,
	elProp:"",
	errMsg:"",
	quickSel:[],
	has:{},
	getRealLang:function(){
		var _=$.$langList;
		for(var A=0;A<_.length;A++)
			if(_[A].name==this.lang)return _[A];return _[0]
	}
};

WdatePicker=T;

var X=window,S={innerHTML:""},M="document",H="documentElement",C="getElementsByTagName",U,A,R,G,a,W=navigator.appName;

if(W=="Microsoft Internet Explorer")R=true;
else if(W=="Opera")a=true;
else G=true;

A=$.$dpPath||J();

if($.$wdate)
	K(A+"skin/WdatePicker.css");
U=X;

if($.$crossFrame){
    try{
        while(U.parent!=U&&U.parent[M][C]("frameset").length==0)
            U=U.parent
    }catch(N){}
}
if(!U.$dp)
	U.$dp={ff:G,ie:R,opera:a,status:0,defMinDate:$.minDate,defMaxDate:$.maxDate};
B();
if($.$preLoad&&$dp.status==0)
	E(X,"onload",function(){T(null,true)});
if(!X[M].docMD){
    E(X[M],"onmousedown",D);
    X[M].docMD=true
}
if(!U[M].docMD){
    E(U[M],"onmousedown",D);
    U[M].docMD=true
}

E(X,"onunload",function(){if($dp.dd)O($dp.dd,"none")});

function B(){
    try{
        U[M],U.$dp=U.$dp||{}
    }catch($){
        U=X;
        $dp=$dp||{}
    }
    var A={
		win:X,
		$:function($){
			return(typeof $=="string")?X[M].getElementById($):$
		},
		$D:function($,_){
			return this.$DV(this.$($).value,_)
		},
		$DV:function(_,$){
			if(_!=""){
				this.dt=$dp.cal.splitDate(_,$dp.cal.dateFmt);
				if($)
					for(var B in $)
						if(this.dt[B]===undefined)
							this.errMsg="invalid property:"+B;
						else{
							this.dt[B]+=$[B];
							if(B=="M"){
								var C=$["M"]>0?1:0,A=new Date(this.dt["y"],this.dt["M"],0).getDate();
								this.dt["d"]=Math.min(A+C,this.dt["d"])
							}
						}
					if(this.dt.refresh())return this.dt
			}return ""
		},
		show:function(){
			var A=U[M].getElementsByTagName("div"),$=100000;
			for(var B=0;B<A.length;B++){
				var _=parseInt(A[B].style.zIndex);
				if(_>$)
					$=_
			}this.dd.style.zIndex=$+2;
			O(this.dd,"block")
		},
		hide:function(){
			O(this.dd,"none")
		},
		attachEvent:E
	};
    for(var _ in A)U.$dp[_]=A[_];$dp=U.$dp
}

function E(A,$,_){
	if(R)
		A.attachEvent($,_);
	else if(_){
		var B=$.replace(/on/,"");
		_._ieEmuEventHandler=function($){return _($)};
		A.addEventListener(B,_._ieEmuEventHandler,false)
	}
}
									
function J(){
	var _,A,$=X[M][C]("script");
	for(var B=0;B<$.length;B++){
		_=$[B].getAttribute("src")||"";
		_=_.substr(0,_.toLowerCase().indexOf("wdatepicker.js"));
		A=_.lastIndexOf("/");
		if(A>0)_=_.substring(0,A+1);
		if(_)break
	}
	return _
}
function K(A,$,B){
	var D=X[M][C]("HEAD").item(0),_=X[M].createElement("link");
	if(D){
		_.href=A;
		_.rel="stylesheet";
		_.type="text/css";
		if($)_.title=$;
		if(B)_.charset=B;
		D.appendChild(_)
	}
}
function F($){
	$=$||U;
	var A=0,_=0;
	while($!=U){
		var D=$.parent[M][C]("iframe");
		for(var F=0;F<D.length;F++){
			try{
				if(D[F].contentWindow==$){
					var E=V(D[F]);
					A+=E.left;
					_+=E.top;
					break
				}
			}catch(B){}
		}
		$=$.parent
	}
	return{"leftM":A,"topM":_}
}
function V(G,F){
	if(G.getBoundingClientRect)
		return G.getBoundingClientRect();
	else{
		var A={
			ROOT_TAG:/^body|html$/i,
			OP_SCROLL:/^(?:inline|table-row)$/i},
			E=false,
			I=null,
			_=G.offsetTop,
			H=G.offsetLeft,
			D=G.offsetWidth,
			B=G.offsetHeight,
			C=G.offsetParent;
			if(C!=G)
				while(C){
					H+=C.offsetLeft;
					_+=C.offsetTop;
					if(Q(C,"position").toLowerCase()=="fixed")
						E=true;
					else if(C.tagName.toLowerCase()=="body")
						I=C.ownerDocument.defaultView;
					C=C.offsetParent
				}
			C=G.parentNode;
			while(C.tagName&&!A.ROOT_TAG.test(C.tagName)){
				if(C.scrollTop||C.scrollLeft)
					if(!A.OP_SCROLL.test(O(C)))
						if(!a||C.style.overflow!=="visible"){
							H-=C.scrollLeft;
							_-=C.scrollTop
						}
				C=C.parentNode
			}
			if(!E){
				var $=Z(I);
				H-=$.left;
				_-=$.top
			}
			D+=H;
			B+=_;
			return{"left":H,"top":_,"right":D,"bottom":B}
	}
}
function L($){
	$=$||U;
	var B=$[M],
	A=($.innerWidth)?$.innerWidth:(B[H]&&B[H].clientWidth)?B[H].clientWidth:B.body.offsetWidth,_=($.innerHeight)?$.innerHeight:(B[H]&&B[H].clientHeight)?B[H].clientHeight:B.body.offsetHeight;
	return{"width":A,"height":_}
}
function Z($){
	$=$||U;
	var B=$[M],A=B[H],_=B.body;
	B=(A&&A.scrollTop!=null&&(A.scrollTop>_.scrollTop||A.scrollLeft>_.scrollLeft))?A:_;
	return{"top":B.scrollTop,"left":B.scrollLeft}
}
function D($){
	try{
		var _=$?($.srcElement||$.target):null;
		if($dp.cal&&!$dp.eCont&&$dp.dd&&_!=$dp.el&&$dp.dd.style.display=="block")
			$dp.cal.close()
	}catch($){}
}
function Y(){$dp.status=2}
var P,_;
function T(N,F){
	if(!$dp)return;
	B();
	N=N||{};
	for(var K in $)
		if(K.substring(0,1)!="$"&&N[K]===undefined)
			N[K]=$[K];
		if(F){
			if(!L()){
				_=_||setInterval(function(){
					if(U[M].readyState=="complete")
						clearInterval(_);
						T(null,true)
				},50);
				return
			}
			if($dp.status==0){
				$dp.status=1;
				N.el=S;
				I(N,true)
			}
			else return
		}else if(N.eCont){
			N.eCont=$dp.$(N.eCont);
			N.el=S;
			N.autoPickDate=true;
			N.qsEnabled=false;
			I(N)
		}else{
			if($.$preLoad&&$dp.status!=2)return;
			var J=H();
			if(X.event===J||J){
				N.srcEl=J.srcElement||J.target;
				J.cancelBubble=true
			}
			N.el=N.el=$dp.$(N.el||N.srcEl);
			if(!N.el||N.el["My97Mark"]===true||N.el.disabled||($dp.dd&&O($dp.dd)!="none"&&$dp.dd.style.left!="-970px")){
				try{
					if(N.el["My97Mark"])N.el["My97Mark"]=false
				}catch(C){}
					return
				}
				if(J&&N.el.nodeType==1&&N.el["My97Mark"]===undefined){
					var A,D;
					if(J.type=="focus")
						E(N.el,"onclick",function(){T(N)});
					else E(N.el,"onfocus",function(){T(N)})
				}
				I(N)
			}
			function L(){
				if(R&&U!=X&&U[M].readyState!="complete")
					return false;
				return true
			}
			function H(){
				if(G){
					func=H.caller;
					while(func!=null){
						var $=func.arguments[0];
						if($&&($+"").indexOf("Event")>=0)
							return $;
						func=func.caller
					}
					return null
				}
				return event
			}
	}
function Q(_,$){
	return _.currentStyle?_.currentStyle[$]:document.defaultView.getComputedStyle(_,false)[$]
}
function O(_,$){
	if(_)
		if($!=null)_.style.display=$;
		else return Q(_,"display")
}
function I(G,_){
	var D=G.el?G.el.nodeName:"INPUT";
	if(_||G.eCont||new RegExp(/input|textarea|div|span|p|a/ig).test(D))
		G.elProp=D=="INPUT"?"value":"innerHTML";
	else return;
	if(G.lang=="auto")
		G.lang=R?navigator.browserLanguage.toLowerCase():navigator.language.toLowerCase();
	if(!G.eCont)
		for(var C in G)
			$dp[C]=G[C];
	if(!$dp.dd||G.eCont||($dp.dd&&(G.getRealLang().name!=$dp.dd.lang||G.skin!=$dp.dd.skin))){
		if(G.eCont)
			E(G.eCont,G);
		else{
			$dp.dd=U[M].createElement("DIV");
			$dp.dd.style.cssText="position:absolute";
			U[M].body.appendChild($dp.dd);E($dp.dd,G);
			if(_)
				$dp.dd.style.left=$dp.dd.style.top="-970px";
			else{
				$dp.show();
				B($dp)
			}
		}
	}else if($dp.cal){
		$dp.show();
		$dp.cal.init();
		if(!$dp.eCont)
			B($dp)
	}
	function E(I,H){
		var G=X[M].domain,E=false;
		I.innerHTML="<iframe hideFocus=true width=9 height=7 frameborder=0 border=0 scrolling=no src=\"about:blank\"></iframe>";
		var _=$.$langList,C=$.$skinList,F;
		try{
			F=I.lastChild.contentWindow[M]
		}catch(D){
			E=true;
			I.lastChild.src="javascript:void((function(){document.open();document.domain='"+G+"';})())";
			F=I.lastChild.contentWindow[M]
		}
		var K=H.getRealLang();
		I.lang=K.name;
		I.skin=H.skin;
		var J=["<head><script>","","var $d, $dp, $cfg=document.cfg, $pdp = parent.$dp, $dt, $tdt, $sdt, $lastInput, $IE=$pdp.ie, $FF = $pdp.ff,$OPERA=$pdp.opera, $ny, $cMark = false;","if($cfg.eCont){$dp = {};for(var p in $pdp)$dp[p]=$pdp[p];}else{$dp=$pdp;};for(var p in $cfg){$dp[p]=$cfg[p];}","document.oncontextmenu=function(){try{$c._fillQS(!$dp.has.d,1);showB($d.qsDivSel);}catch(e){};return false;};","</script><script src=",A,"lang/",K.name,".js charset=",K.charset,"></script>"];
		if(E)
			J[1]="document.domain=\""+G+"\";";
		for(var L=0;L<C.length;L++)
			if(C[L].name==H.skin)
				J.push("<link rel=\"stylesheet\" type=\"text/css\" href=\""+A+"skin/"+C[L].name+"/datepicker.css\" charset=\""+C[L].charset+"\"/>");
                J.push("<script type=\"text/javascript\" src=\""+A+"calendar.js?\"+Math.random()+\"\"></script>");
				J.push("</head><body leftmargin=\"0\" topmargin=\"0\" tabindex=0></body></html>");
				J.push("<script>var t;t=t||setInterval(function(){if(document.ready){new My97DP();$cfg.onload();$c.autoSize();$cfg.setPos($dp);clearInterval(t);}},20);</script>");
				H.setPos=B;
				H.onload=Y;
				F.write("<html>");
				F.cfg=H;
				F.write(J.join(""));
				F.close()
	}
	function B(J){
		var H=J.position.left,C=J.position.top,D=J.el;
		if(D==S)return;
		if(D!=J.srcEl&&(O(D)=="none"||D.type=="hidden"))D=J.srcEl;
		var I=V(D),$=F(X),E=L(U),B=Z(U),G=$dp.dd.offsetHeight,A=$dp.dd.offsetWidth;
		if(isNaN(C))C=0;
		if(($.topM+I.bottom+G>E.height)&&($.topM+I.top-G>0))
			C+=B.top+$.topM+I.top-G-2;
		else{
			C+=B.top+$.topM+I.bottom;
			var _=C-B.top+G-E.height;
			if(_>0)C-=_
		}
		if(isNaN(H))
			H=0;
			H+=B.left+Math.min($.leftM+I.left,E.width-A-5)-(R?2:0);
			J.dd.style.top=C+"px";
			J.dd.style.left=H+"px"
	}
}
})()