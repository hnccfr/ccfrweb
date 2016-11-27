/*
 * 共通脚本。
 * 提供整个系统中通用的脚本代码，建议此脚本文件内容采用原始的JavaScript代码编写，而不采用jQuery等框架编写。
 * 
 * author: zhengdd
 * date: 2010-3-23
 */

/*
 * 增加JavaScript原生String的replaceAll方法。
 * author: zhengdd
 * date: 2010-3-30
 */
String.prototype.replaceAll = function(stringToFind, stringToReplace) {
	var temp = this;
	var index = temp.indexOf(stringToFind);
	while (index != -1) {
		temp = temp.replace(stringToFind, stringToReplace);
		index = temp.indexOf(stringToFind);
	}
	return temp;
}

/*
 * 增加JavaScript原生String的trim方法。 author: zhengdd date: 2010-3-30
 */
String.prototype.trim= function(){
    return this.replace(/(^\s*)|(\s*$)/g, "");  
}

/*
 * 增加JavaScript原生String的isBlank方法。 author: zhengdd date: 2010-3-30
 */
String.prototype.isBlank = function() {
	if (this == null) {
		return true;
	}
	var temp = this.trim();
	if (temp == null || temp == "") {
		return true;
	}
	return false;
}

/*
 * 增加JavaScript原生String的isNotBlank方法。 author: zhengdd date: 2010-3-30
 */
String.prototype.isNotBlank = function() {
	if (this == null) {
		return false;
	}
	var temp = this.trim();
	if (temp != null && temp != "") {
		return true;
	}
	return false;
}

function goUrl(url){
	window.location.href = url;
}

function goBack(){
	window.history.go(-1);
}
// 判断闰年
// ---------------------------------------------------
Date.prototype.isLeapYear = function()    
{    
  return (0==this.getYear()%4&&((this.getYear()%100!=0)||(this.getYear()%400==0)));    
}    
 
// ---------------------------------------------------
// 日期格式化
// 格式 YYYY/yyyy/YY/yy 表示年份
// MM/M 月份
// W/w 星期
// dd/DD/d/D 日期
// hh/HH/h/H 时间
// mm/m 分钟
// ss/SS/s/S 秒
// ---------------------------------------------------
Date.prototype.Format = function(formatStr)    
{    
  var str = formatStr;    
  var Week = ['日','一','二','三','四','五','六'];   
 
  str=str.replace(/yyyy|YYYY/,this.getFullYear());    
  str=str.replace(/yy|YY/,(this.getYear() % 100)>9?(this.getYear() % 100).toString():'0' + (this.getYear() % 100));    
 
  str=str.replace(/MM/,this.getMonth()>9?this.getMonth().toString():'0' + this.getMonth());    
  str=str.replace(/M/g,this.getMonth());    
 
  str=str.replace(/w|W/g,Week[this.getDay()]);    
 
  str=str.replace(/dd|DD/,this.getDate()>9?this.getDate().toString():'0' + this.getDate());    
  str=str.replace(/d|D/g,this.getDate());    
 
  str=str.replace(/hh|HH/,this.getHours()>9?this.getHours().toString():'0' + this.getHours());    
  str=str.replace(/h|H/g,this.getHours());    
  str=str.replace(/mm/,this.getMinutes()>9?this.getMinutes().toString():'0' + this.getMinutes());    
  str=str.replace(/m/g,this.getMinutes());    
 
  str=str.replace(/ss|SS/,this.getSeconds()>9?this.getSeconds().toString():'0' + this.getSeconds());    
  str=str.replace(/s|S/g,this.getSeconds());    
 
  return str;    
}    
 
// +---------------------------------------------------
// | 求两个时间的天数差 日期格式为 YYYY-MM-dd
// +---------------------------------------------------
function daysBetween(DateOne,DateTwo)   
{    
  var OneMonth = DateOne.substring(5,DateOne.lastIndexOf ('-'));   
  var OneDay = DateOne.substring(DateOne.length,DateOne.lastIndexOf ('-')+1);   
  var OneYear = DateOne.substring(0,DateOne.indexOf ('-'));   
 
  var TwoMonth = DateTwo.substring(5,DateTwo.lastIndexOf ('-'));   
  var TwoDay = DateTwo.substring(DateTwo.length,DateTwo.lastIndexOf ('-')+1);   
  var TwoYear = DateTwo.substring(0,DateTwo.indexOf ('-'));   
 
  var cha=((Date.parse(OneMonth+'/'+OneDay+'/'+OneYear)- Date.parse(TwoMonth+'/'+TwoDay+'/'+TwoYear))/86400000);    
// return Math.abs(cha);
  return cha;
}   
// +---------------------------------------------------
// | 求两个时间的毫秒差 日期格式为 YYYY-MM-dd HH:mm:ss
// +---------------------------------------------------
function millisecondBetween(DateOne,DateTwo){
	// 验证日期的格式 YYYY-MM-DD HH:MM:SS
	if(CheckDateTime(DateOne)){
		alert(DateOne+"：日期格式不正确，请转换为YYYY-MM-DD HH:MM:SS后再计算!");
		return false;
	}
	if(CheckDateTime(DateTwo)){
		alert(DateTwo+"：日期格式不正确，请转换为YYYY-MM-DD HH:MM:SS后再计算!");
		return false;
	}
	var date1=new Date(DateOne);
	var date2=new Date(DateTwo);
	return date1- date2;
}
 
// +---------------------------------------------------
// | 日期计算
// +---------------------------------------------------
Date.prototype.DateAdd = function(strInterval, Number) {    
  var dtTmp = this;   
  switch (strInterval) {    
      case 's' :return new Date(Date.parse(dtTmp) + (1000 * Number));   
      case 'n' :return new Date(Date.parse(dtTmp) + (60000 * Number));   
      case 'h' :return new Date(Date.parse(dtTmp) + (3600000 * Number));   
      case 'd' :return new Date(Date.parse(dtTmp) + (86400000 * Number));   
      case 'w' :return new Date(Date.parse(dtTmp) + ((86400000 * 7) * Number));   
      case 'q' :return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number*3, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());   
      case 'm' :return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());   
      case 'y' :return new Date((dtTmp.getFullYear() + Number), dtTmp.getMonth(), dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());   
  }   
}   
// 比较时间 格式 yyyy-mm-dd hh:mi:ss
function comptime(beginTime,endTime){
// var beginTime = "2012-01-13 15:08:25";
// var endTime = "2012-01-13 15:08:26";
var beginTimes=beginTime.substring(0,10).split('-');
var endTimes=endTime.substring(0,10).split('-');
beginTime=beginTimes[1]+'-'+beginTimes[2]+'-'+beginTimes[0]+' '+beginTime.substring(10,19);
endTime=endTimes[1]+'-'+endTimes[2]+'-'+endTimes[0]+' '+endTime.substring(10,19);
// alert(beginTime+"----------"+endTime);
var a =(Date.parse(endTime)-Date.parse(beginTime))/3600/1000;
if(a<0){
// alert("endTime小!");
	return false;
}else if (a>0){
	return true;
// alert("endTime大!");
}else if (a==0){
	return true;
// alert("时间相等!");
}else{
return 'exception'
}
}
// +---------------------------------------------------
// | 比较日期差 dtEnd 格式为日期型或者 有效日期格式字符串
// +---------------------------------------------------
Date.prototype.DateDiff = function(strInterval, dtEnd) {    
  var dtStart = this;   
  if (typeof dtEnd == 'string' )// 如果是字符串转换为日期型
  {    
      dtEnd = StringToDate(dtEnd);   
  }   
  switch (strInterval) {    
      case 's' :return parseInt((dtEnd - dtStart) / 1000);   
      case 'n' :return parseInt((dtEnd - dtStart) / 60000);   
      case 'h' :return parseInt((dtEnd - dtStart) / 3600000);   
      case 'd' :return parseInt((dtEnd - dtStart) / 86400000);   
      case 'w' :return parseInt((dtEnd - dtStart) / (86400000 * 7));   
      case 'm' :return (dtEnd.getMonth()+1)+((dtEnd.getFullYear()-dtStart.getFullYear())*12) - (dtStart.getMonth()+1);   
      case 'y' :return dtEnd.getFullYear() - dtStart.getFullYear();   
  }   
}   
 
// +---------------------------------------------------
// | 日期输出字符串，重载了系统的toString方法
// +---------------------------------------------------
Date.prototype.toString = function(showWeek)   
{    
  var myDate= this;   
  var str = myDate.toLocaleDateString();   
  if (showWeek)   
  {    
      var Week = ['日','一','二','三','四','五','六'];   
      str += ' 星期' + Week[myDate.getDay()];   
  }   
  return str;   
}   
 
// +---------------------------------------------------
// | 日期合法性验证
// | 格式为：YYYY-MM-DD或YYYY/MM/DD
// +---------------------------------------------------
function IsValidDate(DateStr)    
{    
  var sDate=DateStr.replace(/(^\s+|\s+$)/g,''); // 去两边空格;
  if(sDate=='') return true;    
  // 如果格式满足YYYY-(/)MM-(/)DD或YYYY-(/)M-(/)DD或YYYY-(/)M-(/)D或YYYY-(/)MM-(/)D就替换为''
  // 数据库中，合法日期可以是:YYYY-MM/DD(2003-3/21),数据库会自动转换为YYYY-MM-DD格式
 var s = sDate.replace(/[\d]{ 4,4 }[\-/]{ 1 }[\d]{ 1,2 }[\-/]{ 1 }[\d]{ 1,2 }/g,'');

// var s=sDate.replace(regex,"")
  if (s=='') // 说明格式满足YYYY-MM-DD或YYYY-M-DD或YYYY-M-D或YYYY-MM-D
  {    
      var t=new Date(sDate.replace(/\-/g,'/'));    
      var ar = sDate.split(/[-/:]/);    
      if(ar[0] != t.getYear() || ar[1] != t.getMonth()+1 || ar[2] != t.getDate())    
      {    
          // alert('错误的日期格式！格式为：YYYY-MM-DD或YYYY/MM/DD。注意闰年。');
          return false;    
      }    
  }    
  else    
  {    
      // alert('错误的日期格式！格式为：YYYY-MM-DD或YYYY/MM/DD。注意闰年。');
      return false;    
  }    
  return true;    
}    
 
// +---------------------------------------------------
// | 日期时间检查
// | 格式为：YYYY-MM-DD HH:MM:SS
// +---------------------------------------------------
function CheckDateTime(str)   
{    
  var reg = /^(\d+)-(\d{ 1,2 })-(\d{ 1,2 }) (\d{ 1,2 }):(\d{ 1,2 }):(\d{ 1,2 })$/;    
  var r = str.match(reg);    
  if(r==null)return false;    
  r[2]=r[2]-1;    
  var d= new Date(r[1],r[2],r[3],r[4],r[5],r[6]);    
  if(d.getFullYear()!=r[1])return false;    
  if(d.getMonth()!=r[2])return false;    
  if(d.getDate()!=r[3])return false;    
  if(d.getHours()!=r[4])return false;    
  if(d.getMinutes()!=r[5])return false;    
  if(d.getSeconds()!=r[6])return false;    
  return true;    
}    
 
// +---------------------------------------------------
// | 把日期分割成数组
// +---------------------------------------------------
Date.prototype.toArray = function()   
{    
  var myDate = this;   
  var myArray = Array();   
  myArray[0] = myDate.getFullYear();   
  myArray[1] = myDate.getMonth();   
  myArray[2] = myDate.getDate();   
  myArray[3] = myDate.getHours();   
  myArray[4] = myDate.getMinutes();   
  myArray[5] = myDate.getSeconds();   
  return myArray;   
}   
 
// +---------------------------------------------------
// | 取得日期数据信息
// | 参数 interval 表示数据类型
// | y 年 m月 d日 w星期 ww周 h时 n分 s秒
// +---------------------------------------------------
Date.prototype.DatePart = function(interval)   
{    
  var myDate = this;   
  var partStr='';   
  var Week = ['日','一','二','三','四','五','六'];   
  switch (interval)   
  {    
      case 'y' :partStr = myDate.getFullYear();break;   
      case 'm' :partStr = myDate.getMonth()+1;break;   
      case 'd' :partStr = myDate.getDate();break;   
      case 'w' :partStr = Week[myDate.getDay()];break;   
      case 'ww' :partStr = myDate.WeekNumOfYear();break;   
      case 'h' :partStr = myDate.getHours();break;   
      case 'n' :partStr = myDate.getMinutes();break;   
      case 's' :partStr = myDate.getSeconds();break;   
  }   
  return partStr;   
}   
 
// +---------------------------------------------------
// | 取得当前日期所在月的最大天数
// +---------------------------------------------------
Date.prototype.MaxDayOfDate = function()   
{    
  var myDate = this;   
  var ary = myDate.toArray();   
  var date1 = (new Date(ary[0],ary[1]+1,1));   
  var date2 = date1.dateAdd(1,'m',1);   
  var result = dateDiff(date1.Format('yyyy-MM-dd'),date2.Format('yyyy-MM-dd'));   
  return result;   
}   
 
// +---------------------------------------------------
// | 取得当前日期所在周是一年中的第几周
// +---------------------------------------------------
Date.prototype.WeekNumOfYear = function()   
{    
  var myDate = this;   
  var ary = myDate.toArray();   
  var year = ary[0];   
  var month = ary[1]+1;   
  var day = ary[2];   
  document.write('< script. language=VBScript\> \n');   
  document.write("myDate = DateValue('"+month+"-"+day+"-"+year+"') \n'");   
  document.write("result = DatePart('"+ww+"', myDate) \n");   
  document.write(' \n');   
  return result;   
}   
 
// +---------------------------------------------------
// | 字符串转成日期类型
// | 格式 MM/dd/YYYY MM-dd-YYYY YYYY/MM/dd YYYY-MM-dd
// +---------------------------------------------------
function StringToDate(DateStr)   
{    
 
  var converted = Date.parse(DateStr);   
  var myDate = new Date(converted);   
  if (isNaN(myDate))   
  {    
      // var delimCahar = DateStr.indexOf('/')!=-1?'/':'-';
      var arys= DateStr.split('-');   
      myDate = new Date(arys[0],--arys[1],arys[2]);   
  }   
  return myDate;   
}  

// +---------------------------------------------------
// | 函数说明：查询使用时间控件时，对起始时间和结束时间进行比较
// | 若起始时间大于结束时间则表单不能提交，并且提示：
// | 结束时间不能小于开始时间。
// | 函数用法：为表单的onsubmit事件加入该函数，将存放时间的标签
// | 的ID作为入参，id1为起始时间，id2为结束时间
// | autor：xiejh
// +---------------------------------------------------
function equalTime(id1,id2){
	var beginTime = $("#"+id1).val().replace(/\-*/g,'');
	var endTime = $("#"+id2).val().replace(/\-*/g,'');
	if(beginTime.length > 0 && endTime.length == 0){
		return true;
	}
	if(beginTime > endTime){
		alert("结束时间不能小于开始时间");
		return false;
	}else{
		return true;
	}
}
/*
 * 用途：检查输入字符串是否是带小数的数字格式,可以是负数 输入： s：字符串 返回： 如果通过验证返回true,否则返回false
 * 
 */ 
function isDecimal( str ){ 
if(isInteger(str)) return true; 
var re = /^[-]{0,1}(\d+)[\.]+(\d+)$/; 
if (re.test(str)) { 
if(RegExp.$1==0&&RegExp.$2==0) return false; 
return true; 
} else { 
return false; 
} 
} 

/**
 * 验证正浮点数
 * 
 * @return
 */
function isFloatPositive(s){
	 var patrn =/^[0-9]\d*\.\d*$/;
	 if(patrn.test(s))
	 {
	  return true;
	 }
	 return false;
}
/**
 * 验证负浮点数
 * 
 * @param s
 * @return
 */
function isFloatNegative(s){
	 var patrn =/-^[0-9]\d*\.\d*$/;
	 if(patrn.test(s))
	 {
	  return true;
	 }
	 return false;
}
/**
 * 验证正整数
 * 
 * @param s
 * @return
 */
function isDigitPositive(s){
	 var patrn =/^[0-9]\d*$/;
	 if(patrn.test(s))
	 {
	  return true;
	 }
	 return false;
}
/**
 * 验证负整数
 * 
 * @param s
 * @return
 */
function isDigitNegative(s){
	 var patrn =/^[0-9]\d*$/;
	 if(patrn.test(s))
	 {
	  return true;
	 }
	 return false;
}
/**
 * 验证输入是否为货币格式（保正整数或者浮点型的数字）
 * 
 * @param s
 * @return
 */
function isMoneyInput(s){
	if(!isDigitPositive(s)&&!(isFloatPositive(s))){
		return false;
	}else{
		return true;
	}
	
}

// 校验货币格式
function isCurrency(s)
{
	var patrn=/^\d{9}(.\d{2})?$/;
	if (!patrn.exec(s)){
		return false;
	} 
	return true;
}
// 检查是否数字
function isNum(s)
{
 var patrn ="/^/d+(/./d+)?$/";
 if(patrn.test(s))
 {
  return true;
 }
 return false;
}
	
 // 检查是否整数
function isDigit(s) 
{ 
var patrn=/^[0-9]{1,20}$/; 
if (!patrn.exec(s)) return false 
return true 
} 
// 校验日期
// function isdate(s)
// {
// var
// patrn="/^((/d{2}(([02468][048])|([13579][26]))[/-///s]?((((0?[13578])|(1[02]))[/-///s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[/-///s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[/-///s]?((0?[1-9])|([1-2][0-9])))))|(/d{2}(([02468][1235679])|([13579][01345789]))[/-//
// /s]?((((0?[13578])|(1[02]))[/-///s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[/-///s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[/-///s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(/s(((0?[0-9])|([1-2][0-3]))/:([0-5]?[0-9])((/s)|(/:([0-5]?[0-9])))))?$/";
// if (!patrn.test(s)){
// return false;
// }
// return true;
// }
/*
 * 用途：校验ip地址的格式 输入：strIP：ip地址 返回：如果通过验证返回true,否则返回false；
 * 
 */ 
function isIP(strIP) { 
if (isNull(strIP)) return false; 
var re=/^(\d+)\.(\d+)\.(\d+)\.(\d+)$/g // 匹配IP地址的正则表达式
if(re.test(strIP)) 
{ 
if( RegExp.$1 <256 && RegExp.$2<256 && RegExp.$3<256 && RegExp.$4<256) return true; 
} 
return false; 
} 

/*
 * 用途：检查输入字符串是否为空或者全部都是空格 输入：str 返回： 如果全是空返回true,否则返回false
 */ 
function isNull( str ){ 
if ( str == "" ) return true; 
var regu = "^[ ]+$"; 
var re = new RegExp(regu); 
return re.test(str); 
} 


/*
 * 用途：检查输入对象的值是否符合整数格式 输入：str 输入的字符串 返回：如果通过验证返回true,否则返回false
 * 
 */ 
function isInteger( str ){ 
var regu = /^[-]{0,1}[0-9]{1,}$/; 
return regu.test(str); 
} 

/*
 * 用途：检查输入手机号码是否正确 输入： s：字符串 返回： 如果通过验证返回true,否则返回false
 * 
 */ 
function checkMobile( s ){ 
var regu =/^[1][3][0-9]{9}$/; 
var re = new RegExp(regu); 
if (re.test(s)) { 
return true; 
}else{ 
return false; 
} 
} 


/*
 * 用途：检查输入字符串是否符合正整数格式 输入： s：字符串 返回： 如果通过验证返回true,否则返回false
 * 
 */ 
function isNumber( s ){ 
var regu = "^[0-9]+$"; 
var re = new RegExp(regu); 
if (s.search(re) != -1) { 
return true; 
} else { 
return false; 
} 
} 

/*
 * 用途：检查输入字符串是否是带小数的数字格式,可以是负数 输入： s：字符串 返回： 如果通过验证返回true,否则返回false
 * /^-?\d+\.\d+$/ 小数
 * 
 */ 
function isDecimal( str ){ 
if(isInteger(str)) return true; 
var re = /^[-]{0,1}(\d+)[\.]+(\d+)$/; 
if (re.test(str)) { 
if(RegExp.$1==0&&RegExp.$2==0) return false; 
return true; 
} else { 
return false; 
} 
} 
/*
 * 用途：检查输入字符串是否是带小数（1位）的数字格式,可以是负数 输入： s：字符串 返回： 如果通过验证返回true,否则返回false，
 * 
 */ 
function isDecimal1( str ){ 
	var re = /^\d+\.?\d{0,1}$/; 
	return (re.test(str)) ;
} 
/*
 * 用途：检查输入字符串是否是带小数（2位）的数字格式,可以是负数 输入： s：字符串 返回： 如果通过验证返回true,否则返回false，
 * 
 */ 
function isDecimal2( str ){ 
	var re = /^\d+\.?\d{0,2}$/; 
	return (re.test(str)) ;
} 
/*
 * 用途：检查输入字符串是否是带小数（7位）的数字格式,可以是负数 输入： s：字符串 返回： 如果通过验证返回true,否则返回false，
 * 
 */ 
function isDecimal6( str ){ 
	var re = /^\d+\.?\d{0,6}$/; 
	return (re.test(str)) ;
} 
/*
 * 用途：检查输入字符串是否是带小数（7位）的数字格式,可以是负数 输入： s：字符串 返回： 如果通过验证返回true,否则返回false，
 * 
 */ 
function isDecimal10( str ){ 
	var re = /^\d+\.?\d{0,10}$/; 
	return (re.test(str)) ;
} 

/*
 * 用途：检查输入对象的值是否符合端口号格式 输入：str 输入的字符串 返回：如果通过验证返回true,否则返回false
 * 
 */ 
function isPort( str ){ 
return (isNumber(str) && str<65536); 
} 

/*
 * 用途：检查输入对象的值是否符合E-Mail格式 输入：str 输入的字符串 返回：如果通过验证返回true,否则返回false
 * 
 */ 
function isEmail( str ){ 
var myReg = /^[-_A-Za-z0-9]+@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/; 
if(myReg.test(str)) return true; 
return false; 
} 

/*
 * 用途：检查输入字符串是否符合金额格式 格式定义为带小数的正数，小数点后最多三位 输入： s：字符串 返回： 如果通过验证返回true,否则返回false
 * 
 */ 
function isMoney( s ){ 
var regu = "^[0-9]+[\.][0-9]{0,3}$"; 
var re = new RegExp(regu); 
if (re.test(s)) { 
return true; 
} else { 
return false; 
} 
} 
/*
 * 用途：检查输入字符串是否只由英文字母和数字和下划线组成 输入： s：字符串 返回： 如果通过验证返回true,否则返回false
 * 
 */ 
function isNumberOr_Letter( s ){// 判断是否是数字或字母

var regu = "^[0-9a-zA-Z\_]+$"; 
var re = new RegExp(regu); 
if (re.test(s)) { 
return true; 
}else{ 
return false; 
} 
} 
/*
 * 用途：检查输入字符串是否只由英文字母和数字组成 输入： s：字符串 返回： 如果通过验证返回true,否则返回false
 * 
 */ 
function isNumberOrLetter( s ){// 判断是否是数字或字母

var regu = "^[0-9a-zA-Z]+$"; 
var re = new RegExp(regu); 
if (re.test(s)) { 
return true; 
}else{ 
return false; 
} 
} 
/*
 * 用途：检查输入字符串是否只由汉字、字母、数字组成 输入： value：字符串 返回： 如果通过验证返回true,否则返回false
 * 
 */ 
function isChinaOrNumbOrLett( s ){// 判断是否是汉字、字母、数字组成

var regu = "^[0-9a-zA-Z\u4e00-\u9fa5]+$"; 
var re = new RegExp(regu); 
if (re.test(s)) { 
return true; 
}else{ 
return false; 
} 
} 

/*
 * 用途：判断是否是日期 输入：date：日期；fmt：日期格式 返回：如果通过验证返回true,否则返回false
 */ 
function isDate( date, fmt ) { 
if (fmt==null) fmt="yyyyMMdd"; 
var yIndex = fmt.indexOf("yyyy"); 
if(yIndex==-1) return false; 
var year = date.substring(yIndex,yIndex+4); 
var mIndex = fmt.indexOf("MM"); 
if(mIndex==-1) return false; 
var month = date.substring(mIndex,mIndex+2); 
var dIndex = fmt.indexOf("dd"); 
if(dIndex==-1) return false; 
var day = date.substring(dIndex,dIndex+2); 
if(!isNumber(year)||year>"2100" || year< "1900") return false; 
if(!isNumber(month)||month>"12" || month< "01") return false; 
if(day>getMaxDay(year,month) || day< "01") return false; 
return true; 
} 

function getMaxDay(year,month) { 
if(month==4||month==6||month==9||month==11) 
return "30"; 
if(month==2) 
if(year%4==0&&year%100!=0 || year%400==0) 
return "29"; 
else 
return "28"; 
return "31"; 
} 

/*
 * 用途：字符1是否以字符串2结束 输入：str1：字符串；str2：被包含的字符串 返回：如果通过验证返回true,否则返回false
 * 
 */ 
function isLastMatch(str1,str2) 
{ 
var index = str1.lastIndexOf(str2); 
if(str1.length==index+str2.length) return true; 
return false; 
} 


/*
 * 用途：字符1是否以字符串2开始 输入：str1：字符串；str2：被包含的字符串 返回：如果通过验证返回true,否则返回false
 * 
 */ 
function isFirstMatch(str1,str2) 
{ 
var index = str1.indexOf(str2); 
if(index==0) return true; 
return false; 
} 

/*
 * 用途：字符1是包含字符串2 输入：str1：字符串；str2：被包含的字符串 返回：如果通过验证返回true,否则返回false
 * 
 */ 
function isMatch(str1,str2) 
{ 
var index = str1.indexOf(str2); 
if(index==-1) return false; 
return true; 
} 


/*
 * 用途：检查输入的起止日期是否正确，规则为两个日期的格式正确， 且结束如期>=起始日期 输入： startDate：起始日期，字符串
 * endDate：结束如期，字符串 返回： 如果通过验证返回true,否则返回false
 * 
 */ 
function checkTwoDate( startDate,endDate ) { 
if( !isDate(startDate) ) { 
alert("起始日期不正确!"); 
return false; 
} else if( !isDate(endDate) ) { 
alert("终止日期不正确!"); 
return false; 
} else if( startDate > endDate ) { 
alert("起始日期不能大于终止日期!"); 
return false; 
} 
return true; 
} 

/*
 * 用途：检查输入的Email信箱格式是否正确 输入： strEmail：字符串 返回： 如果通过验证返回true,否则返回false
 * 
 */ 
function checkEmail(strEmail) { 
// var emailReg = /^[_a-z0-9]+@([_a-z0-9]+\.)+[a-z0-9]{2,3}$/;
var emailReg = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/; 
if( emailReg.test(strEmail) ){ 
return true; 
}else{ 
alert("您输入的Email地址格式不正确！"); 
return false; 
} 
} 

/*
 * 用途：检查输入的电话号码格式是否正确 输入： strPhone：字符串 返回： 如果通过验证返回true,否则返回false
 * 
 */ 
function checkPhone( strPhone ) { 
var phoneRegWithArea = /^[0][1-9]{2,3}-[0-9]{5,10}$/; 
var phoneRegNoArea = /^[1-9]{1}[0-9]{5,8}$/; 
var prompt = "您输入的电话号码不正确!" 
if( strPhone.length > 9 ) { 
if( phoneRegWithArea.test(strPhone) ){ 
return true; 
}else{ 
alert( prompt ); 
return false; 
} 
}else{ 
if( phoneRegNoArea.test( strPhone ) ){ 
return true; 
}else{ 
alert( prompt ); 
return false; 
} 


} 
} 


/*
 * 用途：检查复选框被选中的数目 输入： checkboxID：字符串 返回： 返回该复选框中被选中的数目
 * 
 */ 

function checkSelect( checkboxID ) { 
var check = 0; 
var i=0; 
if( document.all(checkboxID).length > 0 ) { 
for( i=0; i<document.all(checkboxID).length; i++ ) { 
if( document.all(checkboxID).item( i ).checked ) { 
check += 1; 
} 




} 
}else{ 
if( document.all(checkboxID).checked ) 
check = 1; 
} 
return check; 
} 

function getTotalBytes(varField) { 
if(varField == null) 
return -1; 

var totalCount = 0; 
for (i = 0; i< varField.value.length; i++) { 
if (varField.value.charCodeAt(i) > 127) 
totalCount += 2; 
else 
totalCount++ ; 
} 
return totalCount; 
} 

function getFirstSelectedValue( checkboxID ){ 
var value = null; 
var i=0; 
if( document.all(checkboxID).length > 0 ){ 
for( i=0; i<document.all(checkboxID).length; i++ ){ 
if( document.all(checkboxID).item( i ).checked ){ 
value = document.all(checkboxID).item(i).value; 
break; 
} 
} 
} else { 
if( document.all(checkboxID).checked ) 
value = document.all(checkboxID).value; 
} 
return value; 
} 


function getFirstSelectedIndex( checkboxID ){ 
var value = -2; 
var i=0; 
if( document.all(checkboxID).length > 0 ){ 
for( i=0; i<document.all(checkboxID).length; i++ ) { 
if( document.all(checkboxID).item( i ).checked ) { 
value = i; 
break; 
} 
} 
} else { 
if( document.all(checkboxID).checked ) 
value = -1; 
} 
return value; 
} 

function selectAll( checkboxID,status ){ 

if( document.all(checkboxID) == null) 
return; 

if( document.all(checkboxID).length > 0 ){ 
for( i=0; i<document.all(checkboxID).length; i++ ){ 

document.all(checkboxID).item( i ).checked = status; 
} 
} else { 
document.all(checkboxID).checked = status; 
} 
} 

function selectInverse( checkboxID ) { 
if( document.all(checkboxID) == null) 
return; 

if( document.all(checkboxID).length > 0 ) { 
for( i=0; i<document.all(checkboxID).length; i++ ) { 
document.all(checkboxID).item( i ).checked = !document.all(checkboxID).item( i ).checked; 
} 
} else { 
document.all(checkboxID).checked = !document.all(checkboxID).checked; 
} 
} 

function checkDate( value ) { 
if(value=='') return true; 
if(value.length!=8 || !isNumber(value)) return false; 
var year = value.substring(0,4); 
if(year>"2100" || year< "1900") 
return false; 

var month = value.substring(4,6); 
if(month>"12" || month< "01") return false; 

var day = value.substring(6,8); 
if(day>getMaxDay(year,month) || day< "01") return false; 

return true; 
} 

/*
 * 用途：检查输入的起止日期是否正确，规则为两个日期的格式正确或都为空 且结束日期>=起始日期 输入： startDate：起始日期，字符串 endDate：
 * 结束日期，字符串 返回： 如果通过验证返回true,否则返回false
 * 
 */ 
function checkPeriod( startDate,endDate ) { 
if( !checkDate(startDate) ) { 
alert("起始日期不正确!"); 
return false; 
} else if( !checkDate(endDate) ) { 
alert("终止日期不正确!"); 
return false; 
} else if( startDate > endDate ) { 
alert("起始日期不能大于终止日期!"); 
return false; 
} 
return true; 
} 

/*
 * 用途：检查证券代码是否正确 输入： secCode:证券代码 返回： 如果通过验证返回true,否则返回false
 * 
 */ 
function checkSecCode( secCode ) { 
if( secCode.length !=6 ){ 
alert("证券代码长度应该为6位"); 
return false; 
} 

if(!isNumber( secCode ) ){ 
alert("证券代码只能包含数字"); 


return false; 
} 
return true; 
} 

/*******************************************************************************
 * function:cTrim(sInputString,iType) description:字符串去空格的函数
 * parameters:iType：1=去掉字符串左边的空格
 * 
 * 2=去掉字符串左边的空格 0=去掉字符串左边和右边的空格 return value:去掉空格的字符串
 ******************************************************************************/ 
function cTrim(sInputString,iType) 
{ 
var sTmpStr = ' '; 
var i = -1; 

if(iType == 0 || iType == 1) 
{ 
while(sTmpStr == ' ') 
{ 
++i; 
sTmpStr = sInputString.substr(i,1); 
} 
sInputString = sInputString.substring(i); 
} 

if(iType == 0 || iType == 2) 
{ 
sTmpStr = ' '; 
i = sInputString.length; 
while(sTmpStr == ' ') 
{ 
--i; 
sTmpStr = sInputString.substr(i,1); 
} 
sInputString = sInputString.substring(0,i+1); 
} 
return sInputString; 
} 






