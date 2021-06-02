/**
 * 
 */
$(function() {
	$('.setting-module').click(function() {
		$('.module-div').removeClass('show').addClass('hide');
		var roleId = $(this).attr('data-role-id');
		$('#role-module' + roleId).removeClass('hide').addClass('show');
	});

	$('.role-module-submit-but').click(function() {
		var moduleDiv = $(this).parents('.module-div');
		var roleId = moduleDiv.attr('data-role-id');
		var moduleArr = [];
		moduleDiv.find('input:checked').each(function(idx, ele) {
			moduleArr.push($(ele).val());
		});
		
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
	   /* $(document).ajaxSend(function(e, xhr, options) {
	        xhr.setRequestHeader(header, token);
	    });*/
	    
		if(moduleArr.length > 0){
			$.ajax({
				type : "POST",
				url : context + "ajax/role/addRoleModule",
				beforeSend: function(xhr){
					xhr.setRequestHeader(header, token);
				},
				data : {
					'roleId' : roleId,
					'moduleIds' : moduleArr.toString()
				}
			}).done(function(data) {
				console.log(data);
			}).fail(function(data) {
				console.log(data);
			});
		}
	});
});