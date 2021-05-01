/**
 * 
 */
//所有模块都通过 define 来定义
define(function(require, exports, module) {

  // 通过 require 引入依赖
  var userFormValidation = require('userFormValidation');

  // 通过 exports 对外提供接口
 // exports.doSomething = ...

  // 或者通过 module.exports 提供整个接口
 // module.exports = ...
  /*function validationForm(){
		var ret = true;
		$('input').each(function(idx, e){
			ret = required(e);
		});
		return ret;
	}
	
	var required = function(obj){
		if(obj){
			var val = $.trim($(obj).val());
			if(!val){
				$(obj).parents('.form-group').addClass('has-error');
				return false;
			}else{
				$(obj).parents('.form-group').removeClass('has-error');
			}
		}
		return true;
	}*/
	
	$('#signup-btn').on('click', function(){
		/*if(validationForm()){
			$('#user-add-form').submit();
		}*/
		new userFormValidation({'formId': 'user-add-form'}).validateForm();
	});

});