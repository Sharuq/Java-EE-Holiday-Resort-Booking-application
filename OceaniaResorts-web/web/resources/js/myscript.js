	
	
$(document).ready(function () {
    
  var item= document.querySelector("#options");
       
            if (item.value == 'Booking Number') {
                $('#typeoptions').attr("disabled",true);
                $('#searchbox').show();
                $('#searchbox').removeAttr("disabled");
            }
            
            if (item.value == 'Booking Name')
            {
                $('#typeoptions').attr("disabled",true);
                $('#searchbox').show;
                $('#searchbox').removeAttr("disabled");
            }
            
            if (item.value == 'Booking Type')
            {
                $('#typeoptions').show();
                $('#typeoptions').removeAttr("disabled");
                $('#typeoptions').css('display','block');
                $('#searchbox').attr("disabled",true);
                $('#searchbox').hide();
            }
  
            $('#options').change(function () {
            
            if (item.value == 'Booking Type')
            {
                $('#typeoptions').removeAttr("disabled");
                $('#typeoptions').css('display','block');
                $('#searchbox').attr("disabled",true);
                $('#searchbox').hide();
            }
            if (item.value == 'Booking Number') {
                
                $('#searchbox').removeAttr("disabled");
                $('#typeoptions').attr("disabled",true);
                $('#searchbox').css('display','block');
                $('#typeoptions').hide();
            }
            
            if (item.value == 'Booking Name')
            {
                $('#searchbox').removeAttr("disabled");
                $('#typeoptions').attr("disabled",true);
                $('#searchbox').css('display','block');
                 $('#typeoptions').hide();
            }
            
        }); 
    });