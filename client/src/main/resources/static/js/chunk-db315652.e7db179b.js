(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-db315652"],{"0b11":function(t,e,r){"use strict";var n=r("aa9d"),o=r.n(n);o.a},5530:function(t,e,r){"use strict";r.d(e,"a",(function(){return i}));r("b64b"),r("a4d3"),r("4de4"),r("d3b7"),r("e439"),r("159b"),r("dbb4");function n(t,e,r){return e in t?Object.defineProperty(t,e,{value:r,enumerable:!0,configurable:!0,writable:!0}):t[e]=r,t}function o(t,e){var r=Object.keys(t);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(t);e&&(n=n.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),r.push.apply(r,n)}return r}function i(t){for(var e=1;e<arguments.length;e++){var r=null!=arguments[e]?arguments[e]:{};e%2?o(Object(r),!0).forEach((function(e){n(t,e,r[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(r)):o(Object(r)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(r,e))}))}return t}},8448:function(t,e,r){"use strict";r.r(e);var n=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",[r("div",{staticClass:"topBg"},[r("el-row",{attrs:{type:"flex",align:"middle"}},[r("el-col",{staticStyle:{"text-align":"center"},attrs:{span:2}},[r("el-avatar",{attrs:{icon:"el-icon-user-solid",size:64,src:t.$store.state.user.headUrl}})],1),r("el-col",{attrs:{span:8}},[r("span",{staticStyle:{"font-size":"1.6rem"}},[t._v(t._s(t.$store.state.user.nick))]),t._v(" "),t.$store.state.user.sex?r("i",{staticClass:"el-icon-female el-icon",staticStyle:{color:"#FF758F"}}):r("i",{staticClass:"el-icon-male el-icon",staticStyle:{color:"#5FD4F2"}}),r("div",{staticClass:"sign"},[r("p",{ref:"sign",staticStyle:{color:"#D6DEE4"},attrs:{contenteditable:"true",title:"个性签名,点击可编辑"},on:{blur:function(e){return t.updateSign(t.user.sign)}}},[t._v(" "+t._s(t.$store.state.user.sign)+" ")])])])],1)],1),r("div",{staticClass:"middle"},[r("el-row",[r("router-link",{attrs:{to:"/mine/video"}},[r("el-col",{attrs:{span:2}},[r("i",{staticClass:"el-icon-video-camera",staticStyle:{color:"#00C091",margin:"4px"}}),t._v(" 视频 ")])],1),r("div",[r("router-link",{attrs:{to:"/mine/collection"}},[r("el-col",{attrs:{span:2}},[r("i",{staticClass:"el-icon-collection",staticStyle:{color:"#FB7299",margin:"4px"}}),t._v(" 收藏 ")])],1),r("router-link",{attrs:{to:"/mine/attention"}},[r("el-col",{attrs:{span:2}},[r("i",{staticClass:"el-icon-collection-tag",staticStyle:{color:"#F3A034",margin:"4px"}}),t._v(" 关注 ")])],1),r("router-link",{attrs:{to:"/mine/setting"}},[r("el-col",{attrs:{span:2}},[r("i",{staticClass:"el-icon-setting",staticStyle:{color:"#23C9ED",margin:"4px"}}),t._v(" 个人资料 ")])],1),r("router-link",{attrs:{to:"/mine/setPassword"}},[r("el-col",{attrs:{span:2}},[r("i",{staticClass:"el-icon-warning-outline",staticStyle:{color:"#FB7299",margin:"4px"}}),t._v(" 密码修改 ")])],1)],1),r("el-col",{staticStyle:{"line-height":"200%","font-size":"1.4rem"},attrs:{span:2,offset:8}},[r("p",[t._v("粉丝数")]),r("span",[t._v(t._s(t.user.fansCount))])])],1)],1),r("div",{staticClass:"panel"},[r("router-view")],1)])},o=[],i=r("53ca"),a=r("1da1"),c=r("5530"),s=(r("498a"),r("a4d3"),r("e01a"),r("d3b7"),r("d28b"),r("3ca3"),r("ddb0"),r("b636"),r("944a"),r("0c47"),r("23dc"),r("3410"),r("159b"),r("b0c0"),r("131a"),r("fb6a"),r("2f62")),u=r("c24f");function l(){/*! regenerator-runtime -- Copyright (c) 2014-present, Facebook, Inc. -- license (MIT): https://github.com/facebook/regenerator/blob/main/LICENSE */l=function(){return t};var t={},e=Object.prototype,r=e.hasOwnProperty,n="function"==typeof Symbol?Symbol:{},o=n.iterator||"@@iterator",a=n.asyncIterator||"@@asyncIterator",c=n.toStringTag||"@@toStringTag";function s(t,e,r){return Object.defineProperty(t,e,{value:r,enumerable:!0,configurable:!0,writable:!0}),t[e]}try{s({},"")}catch(S){s=function(t,e,r){return t[e]=r}}function u(t,e,r,n){var o=e&&e.prototype instanceof p?e:p,i=Object.create(o.prototype),a=new E(n||[]);return i._invoke=function(t,e,r){var n="suspendedStart";return function(o,i){if("executing"===n)throw new Error("Generator is already running");if("completed"===n){if("throw"===o)throw i;return k()}for(r.method=o,r.arg=i;;){var a=r.delegate;if(a){var c=O(a,r);if(c){if(c===h)continue;return c}}if("next"===r.method)r.sent=r._sent=r.arg;else if("throw"===r.method){if("suspendedStart"===n)throw n="completed",r.arg;r.dispatchException(r.arg)}else"return"===r.method&&r.abrupt("return",r.arg);n="executing";var s=f(t,e,r);if("normal"===s.type){if(n=r.done?"completed":"suspendedYield",s.arg===h)continue;return{value:s.arg,done:r.done}}"throw"===s.type&&(n="completed",r.method="throw",r.arg=s.arg)}}}(t,r,a),i}function f(t,e,r){try{return{type:"normal",arg:t.call(e,r)}}catch(S){return{type:"throw",arg:S}}}t.wrap=u;var h={};function p(){}function d(){}function v(){}var g={};s(g,o,(function(){return this}));var y=Object.getPrototypeOf,m=y&&y(y(L([])));m&&m!==e&&r.call(m,o)&&(g=m);var b=v.prototype=p.prototype=Object.create(g);function w(t){["next","throw","return"].forEach((function(e){s(t,e,(function(t){return this._invoke(e,t)}))}))}function x(t,e){function n(o,a,c,s){var u=f(t[o],t,a);if("throw"!==u.type){var l=u.arg,h=l.value;return h&&"object"==Object(i["a"])(h)&&r.call(h,"__await")?e.resolve(h.__await).then((function(t){n("next",t,c,s)}),(function(t){n("throw",t,c,s)})):e.resolve(h).then((function(t){l.value=t,c(l)}),(function(t){return n("throw",t,c,s)}))}s(u.arg)}var o;this._invoke=function(t,r){function i(){return new e((function(e,o){n(t,r,e,o)}))}return o=o?o.then(i,i):i()}}function O(t,e){var r=t.iterator[e.method];if(void 0===r){if(e.delegate=null,"throw"===e.method){if(t.iterator.return&&(e.method="return",e.arg=void 0,O(t,e),"throw"===e.method))return h;e.method="throw",e.arg=new TypeError("The iterator does not provide a 'throw' method")}return h}var n=f(r,t.iterator,e.arg);if("throw"===n.type)return e.method="throw",e.arg=n.arg,e.delegate=null,h;var o=n.arg;return o?o.done?(e[t.resultName]=o.value,e.next=t.nextLoc,"return"!==e.method&&(e.method="next",e.arg=void 0),e.delegate=null,h):o:(e.method="throw",e.arg=new TypeError("iterator result is not an object"),e.delegate=null,h)}function j(t){var e={tryLoc:t[0]};1 in t&&(e.catchLoc=t[1]),2 in t&&(e.finallyLoc=t[2],e.afterLoc=t[3]),this.tryEntries.push(e)}function _(t){var e=t.completion||{};e.type="normal",delete e.arg,t.completion=e}function E(t){this.tryEntries=[{tryLoc:"root"}],t.forEach(j,this),this.reset(!0)}function L(t){if(t){var e=t[o];if(e)return e.call(t);if("function"==typeof t.next)return t;if(!isNaN(t.length)){var n=-1,i=function e(){for(;++n<t.length;)if(r.call(t,n))return e.value=t[n],e.done=!1,e;return e.value=void 0,e.done=!0,e};return i.next=i}}return{next:k}}function k(){return{value:void 0,done:!0}}return d.prototype=v,s(b,"constructor",v),s(v,"constructor",d),d.displayName=s(v,c,"GeneratorFunction"),t.isGeneratorFunction=function(t){var e="function"==typeof t&&t.constructor;return!!e&&(e===d||"GeneratorFunction"===(e.displayName||e.name))},t.mark=function(t){return Object.setPrototypeOf?Object.setPrototypeOf(t,v):(t.__proto__=v,s(t,c,"GeneratorFunction")),t.prototype=Object.create(b),t},t.awrap=function(t){return{__await:t}},w(x.prototype),s(x.prototype,a,(function(){return this})),t.AsyncIterator=x,t.async=function(e,r,n,o,i){void 0===i&&(i=Promise);var a=new x(u(e,r,n,o),i);return t.isGeneratorFunction(r)?a:a.next().then((function(t){return t.done?t.value:a.next()}))},w(b),s(b,c,"Generator"),s(b,o,(function(){return this})),s(b,"toString",(function(){return"[object Generator]"})),t.keys=function(t){var e=[];for(var r in t)e.push(r);return e.reverse(),function r(){for(;e.length;){var n=e.pop();if(n in t)return r.value=n,r.done=!1,r}return r.done=!0,r}},t.values=L,E.prototype={constructor:E,reset:function(t){if(this.prev=0,this.next=0,this.sent=this._sent=void 0,this.done=!1,this.delegate=null,this.method="next",this.arg=void 0,this.tryEntries.forEach(_),!t)for(var e in this)"t"===e.charAt(0)&&r.call(this,e)&&!isNaN(+e.slice(1))&&(this[e]=void 0)},stop:function(){this.done=!0;var t=this.tryEntries[0].completion;if("throw"===t.type)throw t.arg;return this.rval},dispatchException:function(t){if(this.done)throw t;var e=this;function n(r,n){return a.type="throw",a.arg=t,e.next=r,n&&(e.method="next",e.arg=void 0),!!n}for(var o=this.tryEntries.length-1;o>=0;--o){var i=this.tryEntries[o],a=i.completion;if("root"===i.tryLoc)return n("end");if(i.tryLoc<=this.prev){var c=r.call(i,"catchLoc"),s=r.call(i,"finallyLoc");if(c&&s){if(this.prev<i.catchLoc)return n(i.catchLoc,!0);if(this.prev<i.finallyLoc)return n(i.finallyLoc)}else if(c){if(this.prev<i.catchLoc)return n(i.catchLoc,!0)}else{if(!s)throw new Error("try statement without catch or finally");if(this.prev<i.finallyLoc)return n(i.finallyLoc)}}}},abrupt:function(t,e){for(var n=this.tryEntries.length-1;n>=0;--n){var o=this.tryEntries[n];if(o.tryLoc<=this.prev&&r.call(o,"finallyLoc")&&this.prev<o.finallyLoc){var i=o;break}}i&&("break"===t||"continue"===t)&&i.tryLoc<=e&&e<=i.finallyLoc&&(i=null);var a=i?i.completion:{};return a.type=t,a.arg=e,i?(this.method="next",this.next=i.finallyLoc,h):this.complete(a)},complete:function(t,e){if("throw"===t.type)throw t.arg;return"break"===t.type||"continue"===t.type?this.next=t.arg:"return"===t.type?(this.rval=this.arg=t.arg,this.method="return",this.next="end"):"normal"===t.type&&e&&(this.next=e),h},finish:function(t){for(var e=this.tryEntries.length-1;e>=0;--e){var r=this.tryEntries[e];if(r.finallyLoc===t)return this.complete(r.completion,r.afterLoc),_(r),h}},catch:function(t){for(var e=this.tryEntries.length-1;e>=0;--e){var r=this.tryEntries[e];if(r.tryLoc===t){var n=r.completion;if("throw"===n.type){var o=n.arg;_(r)}return o}}throw new Error("illegal catch attempt")},delegateYield:function(t,e,r){return this.delegate={iterator:L(t),resultName:e,nextLoc:r},"next"===this.method&&(this.arg=void 0),h}},t}var f={data:function(){return{leo:"dsadsa",user:{}}},computed:Object(c["a"])({},Object(s["b"])(["userId"])),methods:{updateSign:function(t){var e=this;return Object(a["a"])(l().mark((function r(){var n,o;return l().wrap((function(r){while(1)switch(r.prev=r.next){case 0:if(n=e.$refs.sign.innerText.trim(),t!==n){r.next=3;break}return r.abrupt("return",e.$refs.sign.innerText=t);case 3:if(!(n.length>40||n.length<2)){r.next=6;break}return e.$refs.sign.innerText=t,r.abrupt("return",e.$message.error("不能为空且长度2-40"));case 6:return r.next=8,Object(u["F"])({id:e.user.id,sign:n},e.user.token);case 8:o=r.sent,200==o.code?(e.user.sign=n,e.$store.commit("setSign",n),e.$message.success(o.message)):e.$message.error(o.message);case 10:case"end":return r.stop()}}),r)})))()},init:function(){var t=this;return Object(a["a"])(l().mark((function e(){return l().wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(null!=t.$store.state.user){e.next=5;break}return t.$message.error("先登录"),e.next=4,t.$router.push("/login");case 4:return e.abrupt("return",e.sent);case 5:t.user=t.$store.state.user;case 6:case"end":return e.stop()}}),e)})))()}},created:function(){this.init()}},h=f,p=(r("0b11"),r("2877")),d=Object(p["a"])(h,n,o,!1,null,"c2294872",null);e["default"]=d.exports},aa9d:function(t,e,r){},dbb4:function(t,e,r){var n=r("23e7"),o=r("83ab"),i=r("56ef"),a=r("fc6a"),c=r("06cf"),s=r("8418");n({target:"Object",stat:!0,sham:!o},{getOwnPropertyDescriptors:function(t){var e,r,n=a(t),o=c.f,u=i(n),l={},f=0;while(u.length>f)r=o(n,e=u[f++]),void 0!==r&&s(l,e,r);return l}})},e439:function(t,e,r){var n=r("23e7"),o=r("d039"),i=r("fc6a"),a=r("06cf").f,c=r("83ab"),s=o((function(){a(1)})),u=!c||s;n({target:"Object",stat:!0,forced:u,sham:!c},{getOwnPropertyDescriptor:function(t,e){return a(i(t),e)}})}}]);
//# sourceMappingURL=chunk-db315652.e7db179b.js.map