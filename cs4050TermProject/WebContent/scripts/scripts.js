 	var pe = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;  
	var re = /^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
	
        $(function(){
        	
        	var emailDivClone = $("#emailDiv2").clone(); 
        	
        	$('#signUpModal').on('hide.bs.modal', function (e) {
        		alert("its firing");
        		 	$('#emailDiv2').remove();
        		    var myClone = emailDivClone;
        		    $('#emailDiv').append(myClone);
        		    
        	 });
        	
        	$('[data-toggle="tooltip"]').tooltip(); 
            var val = {name:"fillBooks"}
            $.ajax({
                url:"BookstoreServlet",
                data: val,
                datatype:"json",
                method:"GET",
                success: function(responseText){
                    
            
            }
                
            })
            var checks= [0,0,0];
            $('.butt').prop('disabled',true);
            $('#signupFrm').submit(function(e){
					e.preventDefault();
					$.ajax({
						type: "POST",
						url: "BookstoreServlet",
						data: $(this).serialize(),
						success:function(responseText){
								$('#allInputs').empty();
								$('#allInputs').append(responseText);
								$('#signUpModal').remove();
								var myClone = originalModal.clone();
								$('body').append(myClone);
								
							},
						error: function(data) {
								console.log('An error occured.');
								console.log(data);

                        	}	

						})
						
                });
            
        	
        	$("#allInputs").on('keyup focusin focusout', 'div', function(){
					var ch = checks.every(isChecked);
					if (ch){
						$('.butt').prop('disabled',false);
						}
					else {
						$('.butt').prop('disabled',true);

						}
					
            	});
        	function isChecked(element, index, array){
					return element == 1;
            	}
            
            $(".pwds").on('keyup focusin focusout',function(){
            	var pwd = $("#pwd").val();
                var pwd2 =$("#pwd2").val();
				if(pwd.match(pe)){
					checks[1]=1;
					if(document.getElementById('validPWD1')){

						}
					else{
						$("#shortPWD").remove();
						$('#pwds1').append("<span id=\"validPWD1\"class=\"input-group-addon checkMarkPwd\"><span class=\"glyphicon glyphicon-ok\"</span></span>");

					}
                	if (pwd !== pwd2){
                    	checks[2]=0;
                    	if (document.getElementById('invalidPWD')){

                    	}else {
                    		$('#checkMarkPwd').remove();
                    		$('#pwds2').append("<span id=\"xMarkPwd\"class=\"input-group-addon xMarkPwd\"><span class=\"glyphicon glyphicon-remove\"</span></span>");
							$("#toGo").append("<p id=\"invalidPWD\" style=\"color:red\">These passwords are not the same</p>");
							
                    	}
                	}
                	else {
                    	checks[2]=1;
                    	if (document.getElementById('checkMarkPwd')){

                        }else {
							$('#invalidPWD').remove();
							$('#xMarkPwd').remove();
							$('#pwds2').append("<span id=\"checkMarkPwd\"class=\"input-group-addon checkMarkPwd\"><span class=\"glyphicon glyphicon-ok\"</span></span>")
							
                        }
                    }
				}
				else {
					checks[1]=0;
					if (document.getElementById('shortPWD')){

						}
					else {
						$("#validPWD1").remove();
						$('#toGoPwd').append("<p id=\"shortPWD\" style=\"color:red\">Passwords must have a capital letter, a number, and must be 6-20.</p>")
						
						
					}

					}    
            });
            
            

            $("#emailDiv").on('focusin focusout keyup', ".emailDiv2", function(){
                alert('firing');
            	var em = $("#email").val();
            	var val = {name:"email", email:em}
            	if (!em.match(re)){
                	if (document.getElementById('invalidEmail')){

                    	}
                	else {
                    	checks[0]=0;
                    	$('#checkMark').remove();
                    	if(!document.getElementById('xMark')){
        					$('#emailDiv2').append("<span id=\"xMark\" class=\"input-group-addon\"><span class=\"glyphicon glyphicon-remove\"</span></span>");
                    	}
    					$('#toGoEmail').append("<p id=\"invalidEmail\" style=\"color:red\">This email is not valid.</p>");
                	}
               	}
            	else {
                	$('#invalidEmail').remove();
               	 	$.ajax({
                    	url:"BookstoreServlet",
                    	data: val,
                    	datatype:"json",
                    	method:"GET",
                    	success: function(json){
                     		
                       		if (!json.email){
                           		checks[0]=1;
                           		if(!document.getElementById('checkMark')){
                               		$('#xMark').remove();
                               		$('#emailDiv2').append("<span id =\"checkMark\" class=\"input-group-addon\"><span class=\"glyphicon glyphicon-ok\"</span></span>");
                               		$("#takenEmail").remove();
                       				}
                        	}else {
                            	if(!document.getElementById('takenEmail')) {
                                	checks[0]=0;
                            		$('#toGoEmail').append("<p id=\"takenEmail\" style=\"color:red\">This email is not taken.</p>");
                                	$('#checkMark').remove();
                                	if(!document.getElementById('xMark')){
                        				$('#emailDiv2').append("<span id=\"xMark\" class=\"input-group-addon\"><span class=\"glyphicon glyphicon-remove\"</span></span>");
                                	}
                               	}
                    	    }
                         },
                    	error: function(data) {
								console.log('An error occured.');
								console.log(data);

                        	}
                    
                	})
            	}
            });
            
        });