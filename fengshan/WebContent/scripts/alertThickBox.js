
$(function() {
   $("#machbox").dialog({
      autoOpen: false,
      bgiframe: true, 
      modal: true,
      position: ['center',160],
      width: 800,
      height:500,
      title: "���һ��",
      buttons: {
         "�ر�": function() {
        	$(this).dialog("close");   
         }
      }
   });
   $("#machbox").bind("dialogopen", function(event, ui) {
	     var projectId = $("#projectListingId").val();
	     $("#machbox").load(appServer+"/project/matcheResult.htm?id="+projectId);

   });
   $("#machbox").bind("dialogclose", function(event, ui) {
	 
      $(this).empty();
   });
});


function doMatch() {
		$("#machbox").dialog("open");
}