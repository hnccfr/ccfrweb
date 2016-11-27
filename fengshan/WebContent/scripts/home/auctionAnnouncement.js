var isStoped = false;
var oScroll;

var interval;//滚动间隔

var maxMillisecond = 0;//页面当前所有公告中最新公告标记(最大修改时间的毫秒数)

var ann_div_margin_top;
$(function() {
	oScroll = document.getElementById("scrollMsg");
	with (oScroll) {
		noWrap = true;
	}
	oScroll.onmouseover = new Function('isStoped = true');
	oScroll.onmouseout = new Function('isStoped = false');
	init_srolltext();
	
	announcementsRefresh(announcements);
	//self.setInterval("refreshAnnouncementAjax(\'"+projectId+"\')", 10000);//定时刷新公告列表
});

/** 样式用到的 begin* */
function init_srolltext() {
	ann_div_margin_top = 0;
	interval = setInterval('scrollUp()', 50);
}
function scrollUp() {
	if (isStoped){
		return;
	}
	if(ann_div_margin_top <= -110){
		ann_div_margin_top = 0;
		$("#scrollMsg").css({ "margin-top":ann_div_margin_top+"px"});
		return ;
	}
	ann_div_margin_top = ann_div_margin_top - 1;
	$("#scrollMsg").css({ "margin-top":ann_div_margin_top+"px"});
	
}

function announcementsRefresh(data){
	if(data){
	window.clearInterval(interval);
	
	$("#announcements").empty();
	var html_announcement;
	var announcements = data;
	if(!announcements || announcements.length == 0){
		return ;
	}
	html_announcement = "<li>&nbsp;&nbsp;</li>";
	$("#announcements").append(html_announcement);
	for(var i in announcements){
		var announcement = announcements[i];
		//维护最新公告
		if(announcement.gmtModify > maxMillisecond){
			maxMillisecond = announcement.gmtModify;
		}
		
		html_announcement = "";
		html_announcement = html_announcement + "<li><span class=\"fr\">"
								+new Date(announcement.gmtCreate).format("hh:mm:ss")
								+"</span><a target=\"_blank\" href=\""
								+appServer
								+"/home/announcement/info.htm?id="
								+announcement.id
								+"\">";
   		if(announcement.title.length > 25){
   			html_announcement = html_announcement + announcement.title.substring(0,23)+"..";
   		}else{
   			html_announcement = html_announcement + announcement.title;
   		}
   		html_announcement = html_announcement + "</a></li>";
   		$("#announcements").append(html_announcement);
	}
	$("#announcements").append("<li>&nbsp;</li>");
	interval = setInterval('scrollUp()', 50);
	}
}

function refreshAnnouncementAjax(id){
	var projectId = id;
	jQuery.ajax({
				type : "POST",
				url : appServer + "/home/announcement/refreshAnnouncement.htm",
				data : "projectId="+projectId+"&maxMillisecond="+maxMillisecond,
				dataType : "json",
				async : false,
				cache : false,
				success : function(data) {
					if(data){
						if(data.length != 0){//有最新的公告需要刷新
							var i = 3 - data.length ;
							if(i < 0){//最新公告多于3条，取前3条
								var newest = data.slice(0,3);
								announcementsRefresh(newest);
								announcements = newest;
							}else if(i == 0){//最新公告不超过3条
								announcementsRefresh(data);
								announcements = data;
							}else{
							
								if(i == 1){
									if(announcements){
										if(announcements.length >=1 ){
											data.push(announcements[0]);
										}
									}
								}
								if(i == 2){
									if(announcements){
										if(announcements.length ==1 ){
											data.push(announcements[0]);
										}
										if(announcements.length >1 ){
											data.push(announcements[0]);
											data.push(announcements[1]);
										}
									}
								}
								announcementsRefresh(data);
								announcements = data;
							}
							
						}
					}
				},
				error : function() {
				}
			});
	
}

/** 设置日期格式化方式* */
Date.prototype.format = function(format) {
	var o = {
		"M+" : this.getMonth() + 1, // month
		"d+" : this.getDate(), // day
		"h+" : this.getHours(), // hour
		"m+" : this.getMinutes(), // minute
		"s+" : this.getSeconds(), // second
		"q+" : Math.floor((this.getMonth() + 3) / 3), // quarter
		"S" : this.getMilliseconds()// millisecond
	}
	if (/(y+)/.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4
						- RegExp.$1.length));
	}
	for (var k in o) {
		if (new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1
							? o[k]
							: ("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format;
}