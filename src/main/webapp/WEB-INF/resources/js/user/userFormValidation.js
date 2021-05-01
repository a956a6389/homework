/**
 * 
 */
// 所有模块都通过 define 来定义
define(function(require, exports, module) {
	// 通过 require 引入依赖
//	var valiadate = require('valiadate');
//	require('mesgZh');
	
	// $('#user-add-form').validate();
	function userFormValidation(option) {
		this.option = option;
	}

	userFormValidation.prototype.validateForm = function(){
		var self = this;
		$('#'+ self.option.formId).validate({
//			debug: true,
			errorClass: 'errorTip',
//			errorContainer: 'label.errorTip',
			focusCleanup: true,
			rules : {
				email : {
					required : true,
					email : true
				},
				password : {
					required : true,
					minlength : 5
				},
				comfrPassword : {
					required : true,
					minlength : 5,
					equalTo : "#password"
				}
			},
			messages : {
				email : "请输入一个正确的邮箱",
				password : {
					required : "请输入密码",
					minlength : "密码长度不能小于 5 个字母"
				},
				comfrPassword : {
					required : "请输入密码",
					minlength : "密码长度不能小于 5 个字母",
					equalTo : "两次密码输入不一致"
				}
			}
		});
	};
	// 通过 exports 对外提供接口
	// exports.doSomething = ...

	// 或者通过 module.exports 提供整个接口
	 module.exports = userFormValidation;
});