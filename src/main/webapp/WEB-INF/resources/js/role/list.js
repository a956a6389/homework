/**
 * 
 */
$(function(){
	$('.setting-module').click(function(){
		$('.module-div').removeClass('show').addClass('hide');
		var roleId = $(this).attr('data-role-id');
		$('#role-module' + roleId).removeClass('hide').addClass('show');
	});
});