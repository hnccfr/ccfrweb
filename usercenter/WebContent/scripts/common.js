/*
 * ��ͨ�ű���
 * �ṩ����ϵͳ��ͨ�õĽű����룬����˽ű��ļ����ݲ���ԭʼ��JavaScript�����д����������jQuery�ȿ�ܱ�д��
 * 
 * author: zhengdd
 * date: 2010-3-23
 */

/*
 * ����JavaScriptԭ��String��replaceAll������
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
 * ����JavaScriptԭ��String��trim������ author: zhengdd date: 2010-3-30
 */
String.prototype.trim= function(){
    return this.replace(/(^\s*)|(\s*$)/g, "");  
}

/*
 * ����JavaScriptԭ��String��isBlank������ author: zhengdd date: 2010-3-30
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
 * ����JavaScriptԭ��String��isNotBlank������ author: zhengdd date: 2010-3-30
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
// �ж�����
// ---------------------------------------------------
Date.prototype.isLeapYear = function()    
{    
  return (0==this.getYear()%4&&((this.getYear()%100!=0)||(this.getYear()%400==0)));    
}    
 
// ---------------------------------------------------
// ���ڸ�ʽ��
// ��ʽ YYYY/yyyy/YY/yy ��ʾ���
// MM/M �·�
// W/w ����
// dd/DD/d/D ����
// hh/HH/h/H ʱ��
// mm/m ����
// ss/SS/s/S ��
// ---------------------------------------------------
Date.prototype.Format = function(formatStr)    
{    
  var str = formatStr;    
  var Week = ['��','һ','��','��','��','��','��'];   
 
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
// | ������ʱ��������� ���ڸ�ʽΪ YYYY-MM-dd
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
// | ������ʱ��ĺ���� ���ڸ�ʽΪ YYYY-MM-dd HH:mm:ss
// +---------------------------------------------------
function millisecondBetween(DateOne,DateTwo){
	// ��֤���ڵĸ�ʽ YYYY-MM-DD HH:MM:SS
	if(CheckDateTime(DateOne)){
		alert(DateOne+"�����ڸ�ʽ����ȷ����ת��ΪYYYY-MM-DD HH:MM:SS���ټ���!");
		return false;
	}
	if(CheckDateTime(DateTwo)){
		alert(DateTwo+"�����ڸ�ʽ����ȷ����ת��ΪYYYY-MM-DD HH:MM:SS���ټ���!");
		return false;
	}
	var date1=new Date(DateOne);
	var date2=new Date(DateTwo);
	return date1- date2;
}
 
// +---------------------------------------------------
// | ���ڼ���
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
// �Ƚ�ʱ�� ��ʽ yyyy-mm-dd hh:mi:ss
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
// alert("endTimeС!");
	return false;
}else if (a>0){
	return true;
// alert("endTime��!");
}else if (a==0){
	return true;
// alert("ʱ�����!");
}else{
return 'exception'
}
}
// +---------------------------------------------------
// | �Ƚ����ڲ� dtEnd ��ʽΪ�����ͻ��� ��Ч���ڸ�ʽ�ַ���
// +---------------------------------------------------
Date.prototype.DateDiff = function(strInterval, dtEnd) {    
  var dtStart = this;   
  if (typeof dtEnd == 'string' )// ������ַ���ת��Ϊ������
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
// | ��������ַ�����������ϵͳ��toString����
// +---------------------------------------------------
Date.prototype.toString = function(showWeek)   
{    
  var myDate= this;   
  var str = myDate.toLocaleDateString();   
  if (showWeek)   
  {    
      var Week = ['��','һ','��','��','��','��','��'];   
      str += ' ����' + Week[myDate.getDay()];   
  }   
  return str;   
}   
 
// +---------------------------------------------------
// | ���ںϷ�����֤
// | ��ʽΪ��YYYY-MM-DD��YYYY/MM/DD
// +---------------------------------------------------
function IsValidDate(DateStr)    
{    
  var sDate=DateStr.replace(/(^\s+|\s+$)/g,''); // ȥ���߿ո�;
  if(sDate=='') return true;    
  // �����ʽ����YYYY-(/)MM-(/)DD��YYYY-(/)M-(/)DD��YYYY-(/)M-(/)D��YYYY-(/)MM-(/)D���滻Ϊ''
  // ���ݿ��У��Ϸ����ڿ�����:YYYY-MM/DD(2003-3/21),���ݿ���Զ�ת��ΪYYYY-MM-DD��ʽ
 var s = sDate.replace(/[\d]{ 4,4 }[\-/]{ 1 }[\d]{ 1,2 }[\-/]{ 1 }[\d]{ 1,2 }/g,'');

// var s=sDate.replace(regex,"")
  if (s=='') // ˵����ʽ����YYYY-MM-DD��YYYY-M-DD��YYYY-M-D��YYYY-MM-D
  {    
      var t=new Date(sDate.replace(/\-/g,'/'));    
      var ar = sDate.split(/[-/:]/);    
      if(ar[0] != t.getYear() || ar[1] != t.getMonth()+1 || ar[2] != t.getDate())    
      {    
          // alert('��������ڸ�ʽ����ʽΪ��YYYY-MM-DD��YYYY/MM/DD��ע�����ꡣ');
          return false;    
      }    
  }    
  else    
  {    
      // alert('��������ڸ�ʽ����ʽΪ��YYYY-MM-DD��YYYY/MM/DD��ע�����ꡣ');
      return false;    
  }    
  return true;    
}    
 
// +---------------------------------------------------
// | ����ʱ����
// | ��ʽΪ��YYYY-MM-DD HH:MM:SS
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
// | �����ڷָ������
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
// | ȡ������������Ϣ
// | ���� interval ��ʾ��������
// | y �� m�� d�� w���� ww�� hʱ n�� s��
// +---------------------------------------------------
Date.prototype.DatePart = function(interval)   
{    
  var myDate = this;   
  var partStr='';   
  var Week = ['��','һ','��','��','��','��','��'];   
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
// | ȡ�õ�ǰ���������µ��������
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
// | ȡ�õ�ǰ������������һ���еĵڼ���
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
// | �ַ���ת����������
// | ��ʽ MM/dd/YYYY MM-dd-YYYY YYYY/MM/dd YYYY-MM-dd
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
// | ����˵������ѯʹ��ʱ��ؼ�ʱ������ʼʱ��ͽ���ʱ����бȽ�
// | ����ʼʱ����ڽ���ʱ����������ύ��������ʾ��
// | ����ʱ�䲻��С�ڿ�ʼʱ�䡣
// | �����÷���Ϊ����onsubmit�¼�����ú����������ʱ��ı�ǩ
// | ��ID��Ϊ��Σ�id1Ϊ��ʼʱ�䣬id2Ϊ����ʱ��
// | autor��xiejh
// +---------------------------------------------------
function equalTime(id1,id2){
	var beginTime = $("#"+id1).val().replace(/\-*/g,'');
	var endTime = $("#"+id2).val().replace(/\-*/g,'');
	if(beginTime.length > 0 && endTime.length == 0){
		return true;
	}
	if(beginTime > endTime){
		alert("����ʱ�䲻��С�ڿ�ʼʱ��");
		return false;
	}else{
		return true;
	}
}
/*
 * ��;����������ַ����Ƿ��Ǵ�С�������ָ�ʽ,�����Ǹ��� ���룺 s���ַ��� ���أ� ���ͨ����֤����true,���򷵻�false
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
 * ��֤��������
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
 * ��֤��������
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
 * ��֤������
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
 * ��֤������
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
 * ��֤�����Ƿ�Ϊ���Ҹ�ʽ�������������߸����͵����֣�
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

// У����Ҹ�ʽ
function isCurrency(s)
{
	var patrn=/^\d{9}(.\d{2})?$/;
	if (!patrn.exec(s)){
		return false;
	} 
	return true;
}

	
 // ����Ƿ�����
function isDigit(s) 
{ 
var patrn=/^[0-9]{1,20}$/; 
if (!patrn.exec(s)) return false 
return true 
} 
// У������
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
 * ��;��У��ip��ַ�ĸ�ʽ ���룺strIP��ip��ַ ���أ����ͨ����֤����true,���򷵻�false��
 * 
 */ 
function isIP(strIP) { 
if (isNull(strIP)) return false; 
var re=/^(\d+)\.(\d+)\.(\d+)\.(\d+)$/g // ƥ��IP��ַ��������ʽ
if(re.test(strIP)) 
{ 
if( RegExp.$1 <256 && RegExp.$2<256 && RegExp.$3<256 && RegExp.$4<256) return true; 
} 
return false; 
} 

/*
 * ��;����������ַ����Ƿ�Ϊ�ջ���ȫ�����ǿո� ���룺str ���أ� ���ȫ�ǿշ���true,���򷵻�false
 */ 
function isNull( str ){ 
if ( str == "" ) return true; 
var regu = "^[ ]+$"; 
var re = new RegExp(regu); 
return re.test(str); 
} 


/*
 * ��;�������������ֵ�Ƿ����������ʽ ���룺str ������ַ��� ���أ����ͨ����֤����true,���򷵻�false
 * 
 */ 
function isInteger( str ){ 
var regu = /^[-]{0,1}[0-9]{1,}$/; 
return regu.test(str); 
} 

/*
 * ��;����������ֻ������Ƿ���ȷ ���룺 s���ַ��� ���أ� ���ͨ����֤����true,���򷵻�false
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
 * ��;����������ַ����Ƿ������������ʽ ���룺 s���ַ��� ���أ� ���ͨ����֤����true,���򷵻�false
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
 * ��;����������ַ����Ƿ��Ǵ�С�������ָ�ʽ,�����Ǹ��� ���룺 s���ַ��� ���أ� ���ͨ����֤����true,���򷵻�false
 * /^-?\d+\.\d+$/ С��
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
 * ��;����������ַ����Ƿ��Ǵ�С����1λ�������ָ�ʽ,�����Ǹ��� ���룺 s���ַ��� ���أ� ���ͨ����֤����true,���򷵻�false��
 * 
 */ 
function isDecimal1( str ){ 
	var re = /^\d+\.?\d{0,1}$/; 
	return (re.test(str)) ;
} 
/*
 * ��;����������ַ����Ƿ��Ǵ�С����2λ�������ָ�ʽ,�����Ǹ��� ���룺 s���ַ��� ���أ� ���ͨ����֤����true,���򷵻�false��
 * 
 */ 
function isDecimal2( str ){ 
	var re = /^\d+\.?\d{0,2}$/; 
	return (re.test(str)) ;
} 
/*
 * ��;����������ַ����Ƿ��Ǵ�С����7λ�������ָ�ʽ,�����Ǹ��� ���룺 s���ַ��� ���أ� ���ͨ����֤����true,���򷵻�false��
 * 
 */ 
function isDecimal6( str ){ 
	var re = /^\d+\.?\d{0,6}$/; 
	return (re.test(str)) ;
} 
/*
 * ��;����������ַ����Ƿ��Ǵ�С����7λ�������ָ�ʽ,�����Ǹ��� ���룺 s���ַ��� ���أ� ���ͨ����֤����true,���򷵻�false��
 * 
 */ 
function isDecimal10( str ){ 
	var re = /^\d+\.?\d{0,10}$/; 
	return (re.test(str)) ;
} 

/*
 * ��;�������������ֵ�Ƿ���϶˿ںŸ�ʽ ���룺str ������ַ��� ���أ����ͨ����֤����true,���򷵻�false
 * 
 */ 
function isPort( str ){ 
return (isNumber(str) && str<65536); 
} 

/*
 * ��;�������������ֵ�Ƿ����E-Mail��ʽ ���룺str ������ַ��� ���أ����ͨ����֤����true,���򷵻�false
 * 
 */ 
function isEmail( str ){ 
var myReg = /^[-_A-Za-z0-9]+@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/; 
if(myReg.test(str)) return true; 
return false; 
} 

/*
 * ��;����������ַ����Ƿ���Ͻ���ʽ ��ʽ����Ϊ��С����������С����������λ ���룺 s���ַ��� ���أ� ���ͨ����֤����true,���򷵻�false
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
 * ��;����������ַ����Ƿ�ֻ��Ӣ����ĸ�����ֺ��»������ ���룺 s���ַ��� ���أ� ���ͨ����֤����true,���򷵻�false
 * 
 */ 
function isNumberOr_Letter( s ){// �ж��Ƿ������ֻ���ĸ

var regu = "^[0-9a-zA-Z\_]+$"; 
var re = new RegExp(regu); 
if (re.test(s)) { 
return true; 
}else{ 
return false; 
} 
} 
/*
 * ��;����������ַ����Ƿ�ֻ��Ӣ����ĸ��������� ���룺 s���ַ��� ���أ� ���ͨ����֤����true,���򷵻�false
 * 
 */ 
function isNumberOrLetter( s ){// �ж��Ƿ������ֻ���ĸ

var regu = "^[0-9a-zA-Z]+$"; 
var re = new RegExp(regu); 
if (re.test(s)) { 
return true; 
}else{ 
return false; 
} 
} 
/*
 * ��;����������ַ����Ƿ�ֻ�ɺ��֡���ĸ��������� ���룺 value���ַ��� ���أ� ���ͨ����֤����true,���򷵻�false
 * 
 */ 
function isChinaOrNumbOrLett( s ){// �ж��Ƿ��Ǻ��֡���ĸ���������

var regu = "^[0-9a-zA-Z\u4e00-\u9fa5]+$"; 
var re = new RegExp(regu); 
if (re.test(s)) { 
return true; 
}else{ 
return false; 
} 
} 

/*
 * ��;���ж��Ƿ������� ���룺date�����ڣ�fmt�����ڸ�ʽ ���أ����ͨ����֤����true,���򷵻�false
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
 * ��;���ַ�1�Ƿ����ַ���2���� ���룺str1���ַ�����str2�����������ַ��� ���أ����ͨ����֤����true,���򷵻�false
 * 
 */ 
function isLastMatch(str1,str2) 
{ 
var index = str1.lastIndexOf(str2); 
if(str1.length==index+str2.length) return true; 
return false; 
} 


/*
 * ��;���ַ�1�Ƿ����ַ���2��ʼ ���룺str1���ַ�����str2�����������ַ��� ���أ����ͨ����֤����true,���򷵻�false
 * 
 */ 
function isFirstMatch(str1,str2) 
{ 
var index = str1.indexOf(str2); 
if(index==0) return true; 
return false; 
} 

/*
 * ��;���ַ�1�ǰ����ַ���2 ���룺str1���ַ�����str2�����������ַ��� ���أ����ͨ����֤����true,���򷵻�false
 * 
 */ 
function isMatch(str1,str2) 
{ 
var index = str1.indexOf(str2); 
if(index==-1) return false; 
return true; 
} 


/*
 * ��;������������ֹ�����Ƿ���ȷ������Ϊ�������ڵĸ�ʽ��ȷ�� �ҽ�������>=��ʼ���� ���룺 startDate����ʼ���ڣ��ַ���
 * endDate���������ڣ��ַ��� ���أ� ���ͨ����֤����true,���򷵻�false
 * 
 */ 
function checkTwoDate( startDate,endDate ) { 
if( !isDate(startDate) ) { 
alert("��ʼ���ڲ���ȷ!"); 
return false; 
} else if( !isDate(endDate) ) { 
alert("��ֹ���ڲ���ȷ!"); 
return false; 
} else if( startDate > endDate ) { 
alert("��ʼ���ڲ��ܴ�����ֹ����!"); 
return false; 
} 
return true; 
} 

/*
 * ��;����������Email�����ʽ�Ƿ���ȷ ���룺 strEmail���ַ��� ���أ� ���ͨ����֤����true,���򷵻�false
 * 
 */ 
function checkEmail(strEmail) { 
// var emailReg = /^[_a-z0-9]+@([_a-z0-9]+\.)+[a-z0-9]{2,3}$/;
var emailReg = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/; 
if( emailReg.test(strEmail) ){ 
return true; 
}else{ 
alert("�������Email��ַ��ʽ����ȷ��"); 
return false; 
} 
} 

/*
 * ��;���������ĵ绰�����ʽ�Ƿ���ȷ ���룺 strPhone���ַ��� ���أ� ���ͨ����֤����true,���򷵻�false
 * 
 */ 
function checkPhone( strPhone ) { 
var phoneRegWithArea = /^[0][1-9]{2,3}-[0-9]{5,10}$/; 
var phoneRegNoArea = /^[1-9]{1}[0-9]{5,8}$/; 
var prompt = "������ĵ绰���벻��ȷ!" 
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
 * ��;����鸴ѡ��ѡ�е���Ŀ ���룺 checkboxID���ַ��� ���أ� ���ظø�ѡ���б�ѡ�е���Ŀ
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
 * ��;������������ֹ�����Ƿ���ȷ������Ϊ�������ڵĸ�ʽ��ȷ��Ϊ�� �ҽ�������>=��ʼ���� ���룺 startDate����ʼ���ڣ��ַ��� endDate��
 * �������ڣ��ַ��� ���أ� ���ͨ����֤����true,���򷵻�false
 * 
 */ 
function checkPeriod( startDate,endDate ) { 
if( !checkDate(startDate) ) { 
alert("��ʼ���ڲ���ȷ!"); 
return false; 
} else if( !checkDate(endDate) ) { 
alert("��ֹ���ڲ���ȷ!"); 
return false; 
} else if( startDate > endDate ) { 
alert("��ʼ���ڲ��ܴ�����ֹ����!"); 
return false; 
} 
return true; 
} 

/*
 * ��;�����֤ȯ�����Ƿ���ȷ ���룺 secCode:֤ȯ���� ���أ� ���ͨ����֤����true,���򷵻�false
 * 
 */ 
function checkSecCode( secCode ) { 
if( secCode.length !=6 ){ 
alert("֤ȯ���볤��Ӧ��Ϊ6λ"); 
return false; 
} 

if(!isNumber( secCode ) ){ 
alert("֤ȯ����ֻ�ܰ�������"); 


return false; 
} 
return true; 
} 

/*******************************************************************************
 * function:cTrim(sInputString,iType) description:�ַ���ȥ�ո�ĺ���
 * parameters:iType��1=ȥ���ַ�����ߵĿո�
 * 
 * 2=ȥ���ַ�����ߵĿո� 0=ȥ���ַ�����ߺ��ұߵĿո� return value:ȥ���ո���ַ���
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


/*
 * ���̺ϲ�ʱ�÷��������ǳ�ע�͵Ĳ��֣��ⲻ������������С�����۵���֤��
 * ��ֻ�ǵ��ⲿ�֣���isNum��ԭ��ǰһ���汾��modified by guowei 2012-3-7
 * */
// ����Ƿ��������������ɣ�
//function isNum(s) {
//	var patrn = /^-?[0-9]\d*$/;
//	return patrn.test(s);
//}
//����Ƿ�����
function isNum(s)
{
 var patrn =/^\d+(\.\d+)?$/;
 if(patrn.test(s))
 {
  return true;
 }
 return false;
}
 
/**
 * �Ƿ���ʵ��
 * @param {} s
 */
function isRealNumber(s) {
	return (isNum(s) || isDigit(s));
}

 

//���������������õ���ȷ�ĳ������
//˵����javascript�ĳ�����������������������������ʱ���Ƚ����ԡ�����������ؽ�Ϊ��ȷ�ĳ��������
//���ã�accDiv(arg1,arg2)
//����ֵ��arg1����arg2�ľ�ȷ���
function accDiv(arg1,arg2){
    var t1=0,t2=0,r1,r2;
    try{t1=arg1.toString().split(".")[1].length}catch(e){}
    try{t2=arg2.toString().split(".")[1].length}catch(e){}
    with(Math){
        r1=Number(arg1.toString().replace(".",""))
        r2=Number(arg2.toString().replace(".",""))
        return (r1/r2)*pow(10,t2-t1);
    }
}


//�˷������������õ���ȷ�ĳ˷����
//˵����javascript�ĳ˷������������������������˵�ʱ���Ƚ����ԡ�����������ؽ�Ϊ��ȷ�ĳ˷������
//���ã�accMul(arg1,arg2)
//����ֵ��arg1����arg2�ľ�ȷ���
function accMul(arg1,arg2)
{
    var m=0,s1=arg1.toString(),s2=arg2.toString();
    try{m+=s1.split(".")[1].length}catch(e){}
    try{m+=s2.split(".")[1].length}catch(e){}
    return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m)
}


//�ӷ������������õ���ȷ�ļӷ����
//˵����javascript�ļӷ������������������������ӵ�ʱ���Ƚ����ԡ�����������ؽ�Ϊ��ȷ�ļӷ������
//���ã�accAdd(arg1,arg2)
//����ֵ��arg1����arg2�ľ�ȷ���
function accAdd(arg1,arg2){
    var r1,r2,m;
    try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
    try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
    m=Math.pow(10,Math.max(r1,r2));

    return accDiv((accMul(arg1,m)+accMul(arg2,m)),m);
}

//��������
function accSub(arg1,arg2){
	return accAdd(arg1,-arg2);
}





