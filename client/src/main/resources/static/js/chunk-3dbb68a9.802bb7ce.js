(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-3dbb68a9"],{5530:function(t,e,r){"use strict";r.d(e,"a",(function(){return a}));r("b64b"),r("a4d3"),r("4de4"),r("d3b7"),r("e439"),r("159b"),r("dbb4");function n(t,e,r){return e in t?Object.defineProperty(t,e,{value:r,enumerable:!0,configurable:!0,writable:!0}):t[e]=r,t}function o(t,e){var r=Object.keys(t);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(t);e&&(n=n.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),r.push.apply(r,n)}return r}function a(t){for(var e=1;e<arguments.length;e++){var r=null!=arguments[e]?arguments[e]:{};e%2?o(Object(r),!0).forEach((function(e){n(t,e,r[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(r)):o(Object(r)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(r,e))}))}return t}},"6bf2":function(t,e,r){"use strict";var n=r("d0ed"),o=r.n(n);o.a},d0ed:function(t,e,r){},d716:function(t,e,r){"use strict";r.r(e);var n=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{staticClass:"pass"},[r("el-form",{ref:"userForm",attrs:{"label-width":"80px",rules:t.rules,"status-icon":"",model:t.user}},[r("el-form-item",{attrs:{label:"邮箱"}},[r("el-input",{attrs:{disabled:""},model:{value:t.email,callback:function(e){t.email=e},expression:"email"}})],1),r("el-form-item",{attrs:{label:"验证码",prop:"code"}},[r("el-col",{attrs:{span:14}},[r("el-input",{model:{value:t.user.code,callback:function(e){t.$set(t.user,"code",t._n(e))},expression:"user.code"}})],1),r("el-col",{attrs:{span:2,offset:3}},[r("el-button",{attrs:{type:"primary",disabled:t.isDisabled},on:{click:t.getCode}},[t._v(t._s(t.btnText))])],1)],1),r("el-form-item",{attrs:{label:"密码",prop:"password"}},[r("el-input",{attrs:{type:"password"},model:{value:t.user.password,callback:function(e){t.$set(t.user,"password",e)},expression:"user.password"}})],1),r("el-form-item",{attrs:{label:"确认密码",prop:"checkPass"}},[r("el-input",{attrs:{type:"password"},model:{value:t.user.checkPass,callback:function(e){t.$set(t.user,"checkPass",e)},expression:"user.checkPass"}})],1),r("el-form-item",[r("el-button",{attrs:{type:"primary"},on:{click:t.submit}},[t._v("提交")])],1)],1)],1)},o=[],a=(r("a4d3"),r("e01a"),r("d3b7"),r("d28b"),r("3ca3"),r("ddb0"),r("b636"),r("944a"),r("0c47"),r("23dc"),r("3410"),r("159b"),r("b0c0"),r("131a"),r("fb6a"),r("53ca")),i=r("1da1"),s=r("5530"),c=r("c24f"),u=r("2f62");function l(){/*! regenerator-runtime -- Copyright (c) 2014-present, Facebook, Inc. -- license (MIT): https://github.com/facebook/regenerator/blob/main/LICENSE */l=function(){return t};var t={},e=Object.prototype,r=e.hasOwnProperty,n="function"==typeof Symbol?Symbol:{},o=n.iterator||"@@iterator",i=n.asyncIterator||"@@asyncIterator",s=n.toStringTag||"@@toStringTag";function c(t,e,r){return Object.defineProperty(t,e,{value:r,enumerable:!0,configurable:!0,writable:!0}),t[e]}try{c({},"")}catch(_){c=function(t,e,r){return t[e]=r}}function u(t,e,r,n){var o=e&&e.prototype instanceof p?e:p,a=Object.create(o.prototype),i=new L(n||[]);return a._invoke=function(t,e,r){var n="suspendedStart";return function(o,a){if("executing"===n)throw new Error("Generator is already running");if("completed"===n){if("throw"===o)throw a;return P()}for(r.method=o,r.arg=a;;){var i=r.delegate;if(i){var s=O(i,r);if(s){if(s===h)continue;return s}}if("next"===r.method)r.sent=r._sent=r.arg;else if("throw"===r.method){if("suspendedStart"===n)throw n="completed",r.arg;r.dispatchException(r.arg)}else"return"===r.method&&r.abrupt("return",r.arg);n="executing";var c=f(t,e,r);if("normal"===c.type){if(n=r.done?"completed":"suspendedYield",c.arg===h)continue;return{value:c.arg,done:r.done}}"throw"===c.type&&(n="completed",r.method="throw",r.arg=c.arg)}}}(t,r,i),a}function f(t,e,r){try{return{type:"normal",arg:t.call(e,r)}}catch(_){return{type:"throw",arg:_}}}t.wrap=u;var h={};function p(){}function d(){}function m(){}var v={};c(v,o,(function(){return this}));var b=Object.getPrototypeOf,g=b&&b(b(E([])));g&&g!==e&&r.call(g,o)&&(v=g);var y=m.prototype=p.prototype=Object.create(v);function w(t){["next","throw","return"].forEach((function(e){c(t,e,(function(t){return this._invoke(e,t)}))}))}function x(t,e){function n(o,i,s,c){var u=f(t[o],t,i);if("throw"!==u.type){var l=u.arg,h=l.value;return h&&"object"==Object(a["a"])(h)&&r.call(h,"__await")?e.resolve(h.__await).then((function(t){n("next",t,s,c)}),(function(t){n("throw",t,s,c)})):e.resolve(h).then((function(t){l.value=t,s(l)}),(function(t){return n("throw",t,s,c)}))}c(u.arg)}var o;this._invoke=function(t,r){function a(){return new e((function(e,o){n(t,r,e,o)}))}return o=o?o.then(a,a):a()}}function O(t,e){var r=t.iterator[e.method];if(void 0===r){if(e.delegate=null,"throw"===e.method){if(t.iterator.return&&(e.method="return",e.arg=void 0,O(t,e),"throw"===e.method))return h;e.method="throw",e.arg=new TypeError("The iterator does not provide a 'throw' method")}return h}var n=f(r,t.iterator,e.arg);if("throw"===n.type)return e.method="throw",e.arg=n.arg,e.delegate=null,h;var o=n.arg;return o?o.done?(e[t.resultName]=o.value,e.next=t.nextLoc,"return"!==e.method&&(e.method="next",e.arg=void 0),e.delegate=null,h):o:(e.method="throw",e.arg=new TypeError("iterator result is not an object"),e.delegate=null,h)}function j(t){var e={tryLoc:t[0]};1 in t&&(e.catchLoc=t[1]),2 in t&&(e.finallyLoc=t[2],e.afterLoc=t[3]),this.tryEntries.push(e)}function k(t){var e=t.completion||{};e.type="normal",delete e.arg,t.completion=e}function L(t){this.tryEntries=[{tryLoc:"root"}],t.forEach(j,this),this.reset(!0)}function E(t){if(t){var e=t[o];if(e)return e.call(t);if("function"==typeof t.next)return t;if(!isNaN(t.length)){var n=-1,a=function e(){for(;++n<t.length;)if(r.call(t,n))return e.value=t[n],e.done=!1,e;return e.value=void 0,e.done=!0,e};return a.next=a}}return{next:P}}function P(){return{value:void 0,done:!0}}return d.prototype=m,c(y,"constructor",m),c(m,"constructor",d),d.displayName=c(m,s,"GeneratorFunction"),t.isGeneratorFunction=function(t){var e="function"==typeof t&&t.constructor;return!!e&&(e===d||"GeneratorFunction"===(e.displayName||e.name))},t.mark=function(t){return Object.setPrototypeOf?Object.setPrototypeOf(t,m):(t.__proto__=m,c(t,s,"GeneratorFunction")),t.prototype=Object.create(y),t},t.awrap=function(t){return{__await:t}},w(x.prototype),c(x.prototype,i,(function(){return this})),t.AsyncIterator=x,t.async=function(e,r,n,o,a){void 0===a&&(a=Promise);var i=new x(u(e,r,n,o),a);return t.isGeneratorFunction(r)?i:i.next().then((function(t){return t.done?t.value:i.next()}))},w(y),c(y,s,"Generator"),c(y,o,(function(){return this})),c(y,"toString",(function(){return"[object Generator]"})),t.keys=function(t){var e=[];for(var r in t)e.push(r);return e.reverse(),function r(){for(;e.length;){var n=e.pop();if(n in t)return r.value=n,r.done=!1,r}return r.done=!0,r}},t.values=E,L.prototype={constructor:L,reset:function(t){if(this.prev=0,this.next=0,this.sent=this._sent=void 0,this.done=!1,this.delegate=null,this.method="next",this.arg=void 0,this.tryEntries.forEach(k),!t)for(var e in this)"t"===e.charAt(0)&&r.call(this,e)&&!isNaN(+e.slice(1))&&(this[e]=void 0)},stop:function(){this.done=!0;var t=this.tryEntries[0].completion;if("throw"===t.type)throw t.arg;return this.rval},dispatchException:function(t){if(this.done)throw t;var e=this;function n(r,n){return i.type="throw",i.arg=t,e.next=r,n&&(e.method="next",e.arg=void 0),!!n}for(var o=this.tryEntries.length-1;o>=0;--o){var a=this.tryEntries[o],i=a.completion;if("root"===a.tryLoc)return n("end");if(a.tryLoc<=this.prev){var s=r.call(a,"catchLoc"),c=r.call(a,"finallyLoc");if(s&&c){if(this.prev<a.catchLoc)return n(a.catchLoc,!0);if(this.prev<a.finallyLoc)return n(a.finallyLoc)}else if(s){if(this.prev<a.catchLoc)return n(a.catchLoc,!0)}else{if(!c)throw new Error("try statement without catch or finally");if(this.prev<a.finallyLoc)return n(a.finallyLoc)}}}},abrupt:function(t,e){for(var n=this.tryEntries.length-1;n>=0;--n){var o=this.tryEntries[n];if(o.tryLoc<=this.prev&&r.call(o,"finallyLoc")&&this.prev<o.finallyLoc){var a=o;break}}a&&("break"===t||"continue"===t)&&a.tryLoc<=e&&e<=a.finallyLoc&&(a=null);var i=a?a.completion:{};return i.type=t,i.arg=e,a?(this.method="next",this.next=a.finallyLoc,h):this.complete(i)},complete:function(t,e){if("throw"===t.type)throw t.arg;return"break"===t.type||"continue"===t.type?this.next=t.arg:"return"===t.type?(this.rval=this.arg=t.arg,this.method="return",this.next="end"):"normal"===t.type&&e&&(this.next=e),h},finish:function(t){for(var e=this.tryEntries.length-1;e>=0;--e){var r=this.tryEntries[e];if(r.finallyLoc===t)return this.complete(r.completion,r.afterLoc),k(r),h}},catch:function(t){for(var e=this.tryEntries.length-1;e>=0;--e){var r=this.tryEntries[e];if(r.tryLoc===t){var n=r.completion;if("throw"===n.type){var o=n.arg;k(r)}return o}}throw new Error("illegal catch attempt")},delegateYield:function(t,e,r){return this.delegate={iterator:E(t),resultName:e,nextLoc:r},"next"===this.method&&(this.arg=void 0),h}},t}var f={name:"setPassword",computed:Object(s["a"])({},Object(u["b"])(["userId"])),data:function(){var t=this,e=function(e,r,n){t.user.password!==r?n(new Error("两次密码输入不一样！")):n()};return{email:"",user:{code:"",password:"",checkPass:""},rules:{code:[{required:!0,message:"请输入验证码",trigger:"blur"},{type:"string",message:"请输入正确的4位验证码",trigger:"blur"}],password:[{required:!0,message:"请输入密码",trigger:"blur"},{min:6,max:14,message:"长度在 6 到 14 个字符",trigger:"blur"}],checkPass:[{required:!0,message:"再次输入密码",trigger:"blur"},{min:6,max:14,message:"长度在 6 到 14 个字符",trigger:"blur"},{validator:e,trigger:"blur"}]},btnText:"点击获取",isDisabled:!1}},methods:{submit:function(){var t=this;return Object(i["a"])(l().mark((function e(){return l().wrap((function(e){while(1)switch(e.prev=e.next){case 0:t.$refs.userForm.validate(function(){var e=Object(i["a"])(l().mark((function e(r){var n;return l().wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(!r){e.next=14;break}return e.next=3,Object(c["E"])({id:t.$store.state.user.id,code:{code:t.user.code},email:t.email,password:t.user.password},t.$store.state.user.token);case 3:if(n=e.sent,200!=n.code){e.next=11;break}return t.$message.success(n.message),t.$store.commit("logout"),e.next=9,t.$router.push("/login");case 9:e.next=12;break;case 11:t.$message.error(n.message);case 12:e.next=16;break;case 14:return t.$message.error("请修改错误项"),e.abrupt("return",!1);case 16:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}());case 1:case"end":return e.stop()}}),e)})))()},getCode:function(){var t=this;return Object(i["a"])(l().mark((function e(){var r,n,o;return l().wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,Object(c["B"])(t.email);case 2:r=e.sent,200==r.code?t.$message.success(r.message):t.$message.error(r.message),n=0,t.isDisabled=!0,o=setInterval((function(){if(++n>=60)return clearInterval(o),t.isDisabled=!1,t.btnText="点击获取";t.btnText="".concat(60-n,"秒后获取")}),1e3);case 7:case"end":return e.stop()}}),e)})))()},init:function(){var t=this;return Object(i["a"])(l().mark((function e(){return l().wrap((function(e){while(1)switch(e.prev=e.next){case 0:t.email=t.$store.state.user.email;case 1:case"end":return e.stop()}}),e)})))()}},created:function(){this.init()}},h=f,p=(r("6bf2"),r("2877")),d=Object(p["a"])(h,n,o,!1,null,"2d2b8611",null);e["default"]=d.exports},dbb4:function(t,e,r){var n=r("23e7"),o=r("83ab"),a=r("56ef"),i=r("fc6a"),s=r("06cf"),c=r("8418");n({target:"Object",stat:!0,sham:!o},{getOwnPropertyDescriptors:function(t){var e,r,n=i(t),o=s.f,u=a(n),l={},f=0;while(u.length>f)r=o(n,e=u[f++]),void 0!==r&&c(l,e,r);return l}})},e439:function(t,e,r){var n=r("23e7"),o=r("d039"),a=r("fc6a"),i=r("06cf").f,s=r("83ab"),c=o((function(){i(1)})),u=!s||c;n({target:"Object",stat:!0,forced:u,sham:!s},{getOwnPropertyDescriptor:function(t,e){return i(a(t),e)}})}}]);
//# sourceMappingURL=chunk-3dbb68a9.802bb7ce.js.map