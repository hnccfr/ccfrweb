$(function(){
    var now = new Date();
    var nowyear = now.getFullYear();
    if (nowyear == year) {
	    var month = now.getMonth();
	    var date = new Date(nowyear,month+1,0);
	    var dayCount = date.getDate();
	    var day =  now.getDate()+1;
	    if(day > dayCount) {
		    month ++;
		    day = 1;
	    }
    } else {
	    var month = 0;
	    var day =  1;
    }
    
    var startdate = year+"-"+(month+1)+"-"+day;
    var enddate = year+"-12-31";
    var tradeDays = new Array();
    
    for (var i = 0 ; i < tmpdays.length ; i ++ ) {
        tradeDays[tmpdays[i]] = tmpdays[i];
    }
    var markTradeDays = function($td, thisDate){
        var tradeDaysName = tradeDays[thisDate.asString()];
        if (tradeDaysName) {
	        var selectMonth = parseInt(tradeDaysName.split('-')[1],10);
	        if (selectMonth == (month+1)) {
	        	eval("$date"+month).dpSetSelected((thisDate.asString()), true, false);
	        }
        }
    }
    var date = new Date(year,month+1,0);
    eval("$date"+month+"= $('<div id="+month+"/>')").datePicker({
        startDate:startdate,
        endDate:year+"-"+(month+1)+"-"+date.getDate(),
        year:year,
        month:month,
        inline:true,
        selectMultiple:true,
        closeOnSelect:false,
        renderCallback:markTradeDays
     });
     $('#multimonth').html('').append(eval("$date"+month));
     for(var i = month ; i < 11 ; i ++ ) {
            month++;
            var date = new Date(year,month+1,0);
            eval("$date"+month+"= $('<div id="+month+"/>')").datePicker({
	            startDate:year+"-"+(month+1)+"-01",
	            endDate:year+"-"+(month+1)+"-"+date.getDate(),
	            year:year,
	            month:month,
	            inline:true,
	            selectMultiple:true,
	            closeOnSelect:false,
	            renderCallback:markTradeDays
            });
            $('#multimonth').append(eval("$date"+month));
      }
      $('#total').bind('click',function() {
            var now = new Date();
            var nowyear = now.getFullYear();
            var year = sys_year;
            if (nowyear == year) {
	            var month = now.getMonth();
	            var date = new Date(nowyear,month+1,0);
	            var dayCount = date.getDate();
	            var day =  now.getDate()+1;
	            if(day > dayCount) {
	           		 month ++;
	            }
            } else {
            	var month = 0;
            }
            var alldates = '';
            for (var i = month ; i < 12 ; i ++ ) {
	                var dates = eval("$date"+i).dpGetSelected();
	                if(dates != '' && i == month)  {
	               		 alldates = alldates + dates;
	                } else {
	               	 	alldates = alldates + ',' + dates;
	                }
                } 
             $('#dates').val(alldates);
             $('#year').val(year);
             $('#editForm').submit();
       	}
       );
});

function previous() {
	var preyear = currentyear - 1;
	location.href = 'list.htm?year=' + preyear;
}
function next() {
	var nextyear = currentyear + 1;
	location.href = 'list.htm?year=' + nextyear;
}
function sel_work_day() {
	var now = new Date();
	var nowyear = now.getFullYear();
	if (currentyear == nowyear) {
		var month = now.getMonth();
		var date = new Date(nowyear, month + 1, 0);
		var dayCount = date.getDate();
		var day = now.getDate() + 1;
		if (day > dayCount) {
			month++;
			day = 1;
		}
	} else {
		var month = 0;
		var day = 1;
	}
	$('#startDate').val(currentyear + "-" + (month + 1) + "-" + day);
	$('#form1').submit();
}