$(document).ready(function() {

	var isDirty = false;
	
    $(".addValidation").validate({
        rules: {
            depminutes: { min: 0, max: 60 },
            dephours: { min: 0, max: 23 },
            arrminutes: { min: 0, max: 60 },
            arrhours: { min: 0, max: 23 },
            campID: { required: true, min: 1 },
            contactID: { required: true, min: 1 }
        }
    });

    $(document).ready(function() {
        $(".dateselect").datepicker({ buttonImage: '/i/icon_date_picker.jpg', buttonImageOnly: true, showOn: 'button', buttonText: "select", dateFormat: 'dd/mm/yy' });
    });

    $('#addPhoneNumber').click(function() {
        var count = parseInt($('#phoneNumbersTable tr:last').attr("id"));
        if (isNaN(count))count = 0;
        else {
            count = count + 1;
        }
        $('#phoneNumbersTable tr:last').after('<tr id="' + count + '">' +
                                              '<td><input id="phoneName' + count + '" name="phoneName' + count + '" value="" class="medium"></td>' +
                                              '<td><input name="phoneNumber' + count + '" value="" class="medium"></td>' +
                                              '</tr>');
        $('#phoneName'+count).focus();
    });
    $('#removePhoneNumber').click(function() {
        if (confirm("CAUTION! You are about to remove the bottom \n" +
                    "phone number, this cannot be undone! \n" +
                    "Are you sure?")){
            $('#phoneNumbersTable tr:last').remove();
        }
    });

    $('#addEmail').click(function() {
        var count = parseInt($('#emailsTable tr:last').attr("id"));
        if (isNaN(count))count = 0;
        else {
            count = count + 1;
        }
        $('#emailsTable tr:last').after('<tr id="' + count + '">' +
                                        '<td><input id="emailName' + count + '" name="emailName' + count + '" value="" class="medium"></td>' +
                                        '<td><input name="emailAddress' + count + '" value="" class="long"></td>' +
                                        '</tr>');
        $('#emailName'+count).focus();
    });
    $('#removeEmail').click(function() {
        if (confirm("CAUTION! You are about to remove the bottom \n" +
                "email address, this cannot be undone! \n" +
                "Are you sure?")){
        $('#emailsTable tr:last').remove();
        }
    });
    
    $('#addNote').click(function() {
        var count = parseInt($('#notesTable tr:last').attr("id"));
        if (isNaN(count))count = 0;
        else {
            count = count + 1;
        }
        $('#notesTable tr:last').after('<tr id="' + count + '">' +
                                       '<td><input id="noteName' + count + '" name="noteName' + count + '" value=""></td>' +
                                       '<td><textarea name="noteText' + count + '" rows="3" cols="20" ></textarea>' +
                                       '</tr>');
        $('#noteName'+count).focus();
    });
    $('#removeNote').click(function() {
        if (confirm("CAUTION! You are about to remove the bottom \n" +
                "note, this cannot be undone! \n" +
                "Are you sure?")){
            $('#notesTable tr:last').remove();
        }
    });
    
    

    $('#addSchoolPhoneNumber').click(function() {
        var count = parseInt($('#schoolPhoneNumbersTable tr:last').attr("id"));
        if (isNaN(count))count = 0;
        else {
            count = count + 1;
        }
        $('#schoolPhoneNumbersTable tr:last').after('<tr id="' + count + '">' +
                                              '<td><input id="schoolPhoneName' + count + '" name="schoolPhoneName' + count + '" value=""></td>' +
                                              '<td><input name="schoolPhoneNumber' + count + '" value=""></td>' +
                                              '</tr>');
        $('#schoolPhoneName'+count).focus();
    });
    $('#removeSchoolPhoneNumber').click(function() {
        if (confirm("CAUTION! You are about to remove the bottom \n" +
                    "phone number, this cannot be undone! \n" +
                    "Are you sure?")){
            $('#schoolPhoneNumbersTable tr:last').remove();
        }
    });

    $('#addSchoolEmail').click(function() {
        var count = parseInt($('#schoolEmailsTable tr:last').attr("id"));
        if (isNaN(count))count = 0;
        else {
            count = count + 1;
        }
        $('#schoolEmailsTable tr:last').after('<tr id="' + count + '">' +
                                        '<td><input id="schoolEmailName' + count + '" name="schoolEmailName' + count + '" value=""></td>' +
                                        '<td><input name="schoolEmailAddress' + count + '" value=""></td>' +
                                        '</tr>');
        $('#schoolEmailName'+count).focus();
    });
    $('#removeSchoolEmail').click(function() {
        if (confirm("CAUTION! You are about to remove the bottom \n" +
                "email address, this cannot be undone! \n" +
                "Are you sure?")){
        $('#schoolEmailsTable tr:last').remove();
        }
    }); 
    
    
    $('.dateChangeCheck').change(function(){
    	isDirty = true;
    });
    
    /*$('#camp').submit(function(){
    	if(isDirty){
    		if (confirm("CAUTION! When you change the start or end date \n" +
                    "the staff members will be removed. \n" +
                    "Are you sure you want to continue?")){
    			return true;
            }	
    		return false;
    	}
    });*/

    $('#addContact').click(function() {
        var count = parseInt($('#contactsTable tr:last').attr("id"));
        if (isNaN(count))count = 0;
        else {
            count = count + 1;
        }
        $('#contactsTable tr:last').after('<tr id="' + count + '">' +
                                          '<td>First Name: <input id="contactFirstNames' + count + '" name="contactFirstNames' + count + '" value=""></td>' +
                                          '<td>Second Name: <input name="contactSecondName' + count + '" value=""></td>' +
                                          '<td>Sex: ' +
                                          '<select name="sex' + count + '">' +
                                          '<option value="male">male</option>' +
                                          '<option value="female">female</option>' +
                                          '</select>' +
                                          '</td>' +
                                          '</tr>');

        $('#contactFirstNames'+count).focus();
    });
    $('#removeContact').click(function() {
        if (confirm("CAUTION! You are about to remove the bottom \n" +
                "contact, this cannot be undone! \n" +
                "Are you sure?")){
            $('#contactsTable tr:last').remove();
        }
    });
    
    $('#showYearCombo').change(function() {
    	 var param = $(this).val();
    	 var param2 = $('#showDeleted').is(':checked');
    	 var param3 = false;
    	 window.location.replace(location.pathname+"?showYear="+param+"&showDeleted="+param2+"&copyAll="+param3);     
    });


    $('#orderBy').change(function() {
    	 var param = $(this).val();
    	 var param2 = $('#showDeleted').is(':checked');
    	 var param3 = false;
    	 window.location.replace(location.pathname+"?orderBy="+param+"&showDeleted="+param2+"&copyAll="+param3);
    });
    
    
    $('#showDeleted').click(function() {
   	 var param = $('#showYearCombo').val();
   	 var param2 = $(this).is(':checked');
   	 var param3 = false;
   	 window.location.replace(location.pathname+"?showYear="+param+"&showDeleted="+param2+"&copyAll="+param3);     
   });
    
    $('#showDeleted2').click(function() {
      	 var param = $(this).is(':checked');
      	 window.location.replace(location.pathname+"?showDeleted2="+param);     
      });
    
    $('#showYear').change(function() {
   	 	var param = $(this).val();
   	 	var param2 = $('#contacts').val();
   	 	var paramRole = $('#showRole').val();
   	 	window.location.replace(location.pathname+"?action=camps&showYear="+param+"&contacts="+param2+"&showRole="+paramRole);     
   });
    
    $('#showRole').change(function() {
   	 	var paramRole = $(this).val();
   	 	var param2 = $('#contacts').val();
   	 	var param = $('#showYear').val();
   	 	window.location.replace(location.pathname+"?action=camps&showYear="+param+"&contacts="+param2+"&showRole="+paramRole);     
   });
    
    $('#staffYear').change(function() {
   	   var param = $("td:eq(2)").html();
   	   var param2 = $(this).val();
       window.location.replace(location.pathname+"?id="+param+"&staffYear="+param2);     
   });
    
    $('#existingStaff').click(function() {
    	$('#newStatus').hide();    
    });
    
    $('#newStaff').click(function() {
    	$('#newStatus').show();    
    });
    
    $(document).ready(function() {   	
        if ($("#existingStaff").is(':checked')){
        	$('#newStatus').hide(); 
    	}
      });
    
    $(document).ready(function() {   	
        if ($("td").length){
    		$('#copyAll').hide();
    	}
      });

    $('#copyAll').click(function() {
      	 var param = $('#showYearCombo').val();
      	 var param2 = $('#showDeleted').is(':checked');
      	 var param3 = true;
      	 window.location.replace(location.pathname+"?showYear="+param+"&showDeleted="+param2+"&copyAll="+param3);     
      });
    
    $('#selectAll').click(function() {
    	$("INPUT[type='checkbox']").attr('checked', $('#selectAll').is(':checked'));  	
    });

    $('#externalUpdateStatus').change(function() {
    	var value = $("#externalUpdateStatus option:selected").attr('value');
    	$("#parentID").val(value);
    	$('#staffMemberForm').submit();
    });
    $('#disableExternalUpdate').click(function() {
    	$("#parentID").val("-1");
    	$('#staffMemberForm').submit();
    });
    $('#exceptionTrace').click(function() {
    	$('#exceptionTraceContent').css("display", "block");
    });
    
    if($("#accordion")) {
    	$("#accordion").accordion();
    }

    // ajax stuff for transfer and flight ajax forms

    // wait for the DOM to be loaded
    $(document).ready(function() {
        // bind 'myForm' and provide a simple callback function
        $('.ajaxForm').ajaxForm(function() {
            alert("form submitted!");
        });
    });
    
});
