var speed = 40;
 
var demo;
var demo1;
var demo2;
 
 function change(){
  if(demo2.offsetTop - demo.scrollTop <=0){
                  demo.scrollTop-=demo1.offsetHeight;
  }else{
   demo.scrollTop++;
  }
 }
  
 var marquee;
 
 function scrollUp(typeIndex){
	 demo = document.getElementById(typeIndex);
	 demo1 = document.getElementById(typeIndex+"-demo1");
	 demo2 = document.getElementById(typeIndex+"-demo2");
	 demo2.innerHTML = demo1.innerHTML;
	 marquee = setInterval(change,speed);
	 demo.onmouseover = function(){ clearInterval(marquee); }
	 demo.onmouseout = function(){ marquee = setInterval(change,speed); }
 }