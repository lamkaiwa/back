(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4a62d4bd"],{"25a9":function(e,t,r){"use strict";r.r(t);var n=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"videoForm"},[r("el-row",{staticClass:"video",attrs:{type:"flex",justify:"space-between"}},[r("el-col",{attrs:{span:12}},[r("el-upload",{ref:"video",attrs:{drag:"","auto-upload":!1,limit:1,name:"video",action:"","on-change":e.videoUpload,"on-exceed":e.videoExceed,accept:".mp4,.flv","on-remove":e.videoRemove}},[r("i",{staticClass:"el-icon-upload"}),r("div",{staticClass:"el-upload__text"},[e._v(" 将视频文件拖到此处，或 "),r("em",[e._v("点击上传")])]),r("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[e._v("只能上传mp4文件，且不超过1GB")])])],1),r("el-col",{staticClass:"titlePic",attrs:{span:12}},[r("el-upload",{ref:"img",staticClass:"avatar-uploader",attrs:{"auto-upload":!1,limit:1,name:"img",action:"","on-change":e.imgUpload,"on-exceed":e.imgExceed,"on-remove":e.imgRemove,accept:".jpg,.jpeg,.png"}},[e.imgUrl?r("img",{staticClass:"avatar",attrs:{src:e.imgUrl}}):r("i",{staticClass:"el-icon-plus avatar-uploader-icon"},[e._v("视频封面")])]),r("h4",{staticClass:"el-upload__tip"},[e._v("只能上传jpg文件，且不超过2MB")])],1)],1),r("el-form",{ref:"videoForm",attrs:{model:e.videoForm,"label-width":"80px",rules:e.rules,"label-position":"top"}},[r("el-form-item",{attrs:{label:"标题",prop:"title"}},[r("el-input",{model:{value:e.videoForm.title,callback:function(t){e.$set(e.videoForm,"title",t)},expression:"videoForm.title"}})],1),r("el-form-item",{attrs:{label:"视频类型",prop:"type"}},[r("el-select",{attrs:{placeholder:"请选择视频类型"},model:{value:e.videoForm.type,callback:function(t){e.$set(e.videoForm,"type",t)},expression:"videoForm.type"}},e._l(e.types,(function(e,t){return r("el-option",{key:t,attrs:{label:e,value:t+1}})})),1)],1),r("el-form-item",{attrs:{label:"简介"}},[r("el-input",{attrs:{type:"textarea",rows:"5"},model:{value:e.videoForm.desc,callback:function(t){e.$set(e.videoForm,"desc",t)},expression:"videoForm.desc"}})],1),r("el-form-item",[r("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.submit("videoForm")}}},[e._v("立即提交")])],1)],1)],1)},o=[],i=r("53ca"),a=r("5530"),s=r("1da1"),c=(r("b0c0"),r("fb6a"),r("d3b7"),r("3ca3"),r("ddb0"),r("2b3d"),r("9861"),r("a4d3"),r("e01a"),r("d28b"),r("b636"),r("944a"),r("0c47"),r("23dc"),r("3410"),r("159b"),r("131a"),r("2f62")),u=r("093a"),l=r("a01c");function f(){/*! regenerator-runtime -- Copyright (c) 2014-present, Facebook, Inc. -- license (MIT): https://github.com/facebook/regenerator/blob/main/LICENSE */f=function(){return e};var e={},t=Object.prototype,r=t.hasOwnProperty,n="function"==typeof Symbol?Symbol:{},o=n.iterator||"@@iterator",a=n.asyncIterator||"@@asyncIterator",s=n.toStringTag||"@@toStringTag";function c(e,t,r){return Object.defineProperty(e,t,{value:r,enumerable:!0,configurable:!0,writable:!0}),e[t]}try{c({},"")}catch(E){c=function(e,t,r){return e[t]=r}}function u(e,t,r,n){var o=t&&t.prototype instanceof d?t:d,i=Object.create(o.prototype),a=new $(n||[]);return i._invoke=function(e,t,r){var n="suspendedStart";return function(o,i){if("executing"===n)throw new Error("Generator is already running");if("completed"===n){if("throw"===o)throw i;return _()}for(r.method=o,r.arg=i;;){var a=r.delegate;if(a){var s=O(a,r);if(s){if(s===p)continue;return s}}if("next"===r.method)r.sent=r._sent=r.arg;else if("throw"===r.method){if("suspendedStart"===n)throw n="completed",r.arg;r.dispatchException(r.arg)}else"return"===r.method&&r.abrupt("return",r.arg);n="executing";var c=l(e,t,r);if("normal"===c.type){if(n=r.done?"completed":"suspendedYield",c.arg===p)continue;return{value:c.arg,done:r.done}}"throw"===c.type&&(n="completed",r.method="throw",r.arg=c.arg)}}}(e,r,a),i}function l(e,t,r){try{return{type:"normal",arg:e.call(t,r)}}catch(E){return{type:"throw",arg:E}}}e.wrap=u;var p={};function d(){}function h(){}function v(){}var m={};c(m,o,(function(){return this}));var g=Object.getPrototypeOf,y=g&&g(g(L([])));y&&y!==t&&r.call(y,o)&&(m=y);var b=v.prototype=d.prototype=Object.create(m);function w(e){["next","throw","return"].forEach((function(t){c(e,t,(function(e){return this._invoke(t,e)}))}))}function x(e,t){function n(o,a,s,c){var u=l(e[o],e,a);if("throw"!==u.type){var f=u.arg,p=f.value;return p&&"object"==Object(i["a"])(p)&&r.call(p,"__await")?t.resolve(p.__await).then((function(e){n("next",e,s,c)}),(function(e){n("throw",e,s,c)})):t.resolve(p).then((function(e){f.value=e,s(f)}),(function(e){return n("throw",e,s,c)}))}c(u.arg)}var o;this._invoke=function(e,r){function i(){return new t((function(t,o){n(e,r,t,o)}))}return o=o?o.then(i,i):i()}}function O(e,t){var r=e.iterator[t.method];if(void 0===r){if(t.delegate=null,"throw"===t.method){if(e.iterator.return&&(t.method="return",t.arg=void 0,O(e,t),"throw"===t.method))return p;t.method="throw",t.arg=new TypeError("The iterator does not provide a 'throw' method")}return p}var n=l(r,e.iterator,t.arg);if("throw"===n.type)return t.method="throw",t.arg=n.arg,t.delegate=null,p;var o=n.arg;return o?o.done?(t[e.resultName]=o.value,t.next=e.nextLoc,"return"!==t.method&&(t.method="next",t.arg=void 0),t.delegate=null,p):o:(t.method="throw",t.arg=new TypeError("iterator result is not an object"),t.delegate=null,p)}function j(e){var t={tryLoc:e[0]};1 in e&&(t.catchLoc=e[1]),2 in e&&(t.finallyLoc=e[2],t.afterLoc=e[3]),this.tryEntries.push(t)}function k(e){var t=e.completion||{};t.type="normal",delete t.arg,e.completion=t}function $(e){this.tryEntries=[{tryLoc:"root"}],e.forEach(j,this),this.reset(!0)}function L(e){if(e){var t=e[o];if(t)return t.call(e);if("function"==typeof e.next)return e;if(!isNaN(e.length)){var n=-1,i=function t(){for(;++n<e.length;)if(r.call(e,n))return t.value=e[n],t.done=!1,t;return t.value=void 0,t.done=!0,t};return i.next=i}}return{next:_}}function _(){return{value:void 0,done:!0}}return h.prototype=v,c(b,"constructor",v),c(v,"constructor",h),h.displayName=c(v,s,"GeneratorFunction"),e.isGeneratorFunction=function(e){var t="function"==typeof e&&e.constructor;return!!t&&(t===h||"GeneratorFunction"===(t.displayName||t.name))},e.mark=function(e){return Object.setPrototypeOf?Object.setPrototypeOf(e,v):(e.__proto__=v,c(e,s,"GeneratorFunction")),e.prototype=Object.create(b),e},e.awrap=function(e){return{__await:e}},w(x.prototype),c(x.prototype,a,(function(){return this})),e.AsyncIterator=x,e.async=function(t,r,n,o,i){void 0===i&&(i=Promise);var a=new x(u(t,r,n,o),i);return e.isGeneratorFunction(r)?a:a.next().then((function(e){return e.done?e.value:a.next()}))},w(b),c(b,s,"Generator"),c(b,o,(function(){return this})),c(b,"toString",(function(){return"[object Generator]"})),e.keys=function(e){var t=[];for(var r in e)t.push(r);return t.reverse(),function r(){for(;t.length;){var n=t.pop();if(n in e)return r.value=n,r.done=!1,r}return r.done=!0,r}},e.values=L,$.prototype={constructor:$,reset:function(e){if(this.prev=0,this.next=0,this.sent=this._sent=void 0,this.done=!1,this.delegate=null,this.method="next",this.arg=void 0,this.tryEntries.forEach(k),!e)for(var t in this)"t"===t.charAt(0)&&r.call(this,t)&&!isNaN(+t.slice(1))&&(this[t]=void 0)},stop:function(){this.done=!0;var e=this.tryEntries[0].completion;if("throw"===e.type)throw e.arg;return this.rval},dispatchException:function(e){if(this.done)throw e;var t=this;function n(r,n){return a.type="throw",a.arg=e,t.next=r,n&&(t.method="next",t.arg=void 0),!!n}for(var o=this.tryEntries.length-1;o>=0;--o){var i=this.tryEntries[o],a=i.completion;if("root"===i.tryLoc)return n("end");if(i.tryLoc<=this.prev){var s=r.call(i,"catchLoc"),c=r.call(i,"finallyLoc");if(s&&c){if(this.prev<i.catchLoc)return n(i.catchLoc,!0);if(this.prev<i.finallyLoc)return n(i.finallyLoc)}else if(s){if(this.prev<i.catchLoc)return n(i.catchLoc,!0)}else{if(!c)throw new Error("try statement without catch or finally");if(this.prev<i.finallyLoc)return n(i.finallyLoc)}}}},abrupt:function(e,t){for(var n=this.tryEntries.length-1;n>=0;--n){var o=this.tryEntries[n];if(o.tryLoc<=this.prev&&r.call(o,"finallyLoc")&&this.prev<o.finallyLoc){var i=o;break}}i&&("break"===e||"continue"===e)&&i.tryLoc<=t&&t<=i.finallyLoc&&(i=null);var a=i?i.completion:{};return a.type=e,a.arg=t,i?(this.method="next",this.next=i.finallyLoc,p):this.complete(a)},complete:function(e,t){if("throw"===e.type)throw e.arg;return"break"===e.type||"continue"===e.type?this.next=e.arg:"return"===e.type?(this.rval=this.arg=e.arg,this.method="return",this.next="end"):"normal"===e.type&&t&&(this.next=t),p},finish:function(e){for(var t=this.tryEntries.length-1;t>=0;--t){var r=this.tryEntries[t];if(r.finallyLoc===e)return this.complete(r.completion,r.afterLoc),k(r),p}},catch:function(e){for(var t=this.tryEntries.length-1;t>=0;--t){var r=this.tryEntries[t];if(r.tryLoc===e){var n=r.completion;if("throw"===n.type){var o=n.arg;k(r)}return o}}throw new Error("illegal catch attempt")},delegateYield:function(e,t,r){return this.delegate={iterator:L(e),resultName:t,nextLoc:r},"next"===this.method&&(this.arg=void 0),p}},e}var p={data:function(){return{types:["生活","科技","游戏","校园","教育","动物","其他"],imgUrl:"",rules:{title:[{required:!0,message:"请输入标题",trigger:"blur"},{max:30,message:"长度不超过30个字符",trigger:"blur"}],type:[{required:!0,message:"请选择类型",trigger:"blur"}]},videoForm:{title:"",type:"",desc:""},img:"",video:"",process:0}},methods:{imgRemove:function(){this.imgUrl="",this.img=""},videoRemove:function(){this.video=""},videoExceed:function(){this.$message.error("视频只能上传一个")},imgExceed:function(){this.$message.error("图片只能上传一个")},videoUpload:function(e){var t=["mp4"],r=e.name,n=r.lastIndexOf(".")+1,o=t.indexOf(r.slice(n)),i=e.raw.size/1024/1024<1024;return-1===o?(this.$message.error("格式只能是mp4!"),this.$refs.video.uploadFiles.length=0,!1):i?(this.video=e,!0):(this.$message.error("视频大小不能超过1GB!"),this.$refs.video.uploadFiles.length=0,!1)},imgUpload:function(e){var t=["jpg"],r=e.name,n=r.lastIndexOf(".")+1,o=t.indexOf(r.slice(n)),i=e.raw.size/1024/1024<2;return-1===o?(this.$message.error("格式只能是jpg!"),this.$refs.img.uploadFiles.length=0,!1):i?(this.imgUrl=URL.createObjectURL(e.raw),this.img=e,!0):(this.$message.error("图片大小不能超过 2MB!"),this.$refs.img.uploadFiles.length=0,!1)},submit:function(e){var t=this;this.$refs[e].validate(function(){var e=Object(s["a"])(f().mark((function e(r){var n,o,i,a,s,c,l,p,d,h,v,m,g,y;return f().wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(!r){e.next=54;break}if(!t.img||!t.video){e.next=51;break}for(i in n=new FormData,o=t.videoForm,o)n.append(i,o[i]);n.append("author",t.$store.state.user.id),n.append("image",t.img.raw),n.append("uuid",t.video.uid),a=t.$loading({text:"正在上传...进度为"+t.process+"%",fullscreen:!0,lock:!0,background:"rgba(255,255,255,.7)"}),s=function(){a.close(),t.$refs.video.uploadFiles.length=0,t.$refs.img.uploadFiles.length=0,Object.assign(t.$data,t.$options.data())},e.prev=10,l=0,p=65536,d=p,h=t.video.raw,v=Math.ceil((h.size+0)/(d+0)),m=100/v,n.append("size",h.size),g=h.type,y=0;case 20:if(!(y<v)){e.next=41;break}return d>h.size&&(d=h.size),n.set("end",d),n.set("video",h.slice(l,d,g)),e.next=26,Object(u["C"])(n,t.$store.state.user.token);case 26:if(c=e.sent,200!=c.code){e.next=34;break}t.process=y*m,a.text="正在上传...进度为"+parseInt(t.process)+"%",l=d,d+=p,e.next=37;break;case 34:return t.$message.error(c.message),s(),e.abrupt("break",41);case 37:0==y&&n.delete("image");case 38:y++,e.next=20;break;case 41:e.next=47;break;case 43:return e.prev=43,e.t0=e["catch"](10),t.$message.success("网络出错"),e.abrupt("return",s());case 47:s(),t.$message.success(c.message),e.next=52;break;case 51:t.$message.error("请完善图片和视频");case 52:e.next=56;break;case 54:return t.$message.error("请修改错误项"),e.abrupt("return",!1);case 56:case"end":return e.stop()}}),e,null,[[10,43]])})));return function(t){return e.apply(this,arguments)}}())},init:function(){var e=this;return Object(s["a"])(f().mark((function t(){var r;return f().wrap((function(t){while(1)switch(t.prev=t.next){case 0:return null==e.$store.state.user&&(e.$message.error("先登录"),e.$router.push("/login/loginForm")),t.next=3,Object(l["a"])(e.$store.state.user.token);case 3:r=t.sent,200==r.code&&(e.types=r.data);case 5:case"end":return t.stop()}}),t)})))()}},computed:Object(a["a"])({},Object(c["b"])(["userId"])),created:function(){this.init()}},d=p,h=(r("a2c4"),r("2877")),v=Object(h["a"])(d,n,o,!1,null,"d5c8f616",null);t["default"]=v.exports},5530:function(e,t,r){"use strict";r.d(t,"a",(function(){return i}));r("b64b"),r("a4d3"),r("4de4"),r("d3b7"),r("e439"),r("159b"),r("dbb4");function n(e,t,r){return t in e?Object.defineProperty(e,t,{value:r,enumerable:!0,configurable:!0,writable:!0}):e[t]=r,e}function o(e,t){var r=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),r.push.apply(r,n)}return r}function i(e){for(var t=1;t<arguments.length;t++){var r=null!=arguments[t]?arguments[t]:{};t%2?o(Object(r),!0).forEach((function(t){n(e,t,r[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(r)):o(Object(r)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(r,t))}))}return e}},a01c:function(e,t,r){"use strict";r.d(t,"a",(function(){return o}));var n=r("4279"),o=function(e){return Object(n["a"])("/video/home/getAllType",{},"get",{headers:{Authorization:e}})}},a2c4:function(e,t,r){"use strict";var n=r("f2bf"),o=r.n(n);o.a},dbb4:function(e,t,r){var n=r("23e7"),o=r("83ab"),i=r("56ef"),a=r("fc6a"),s=r("06cf"),c=r("8418");n({target:"Object",stat:!0,sham:!o},{getOwnPropertyDescriptors:function(e){var t,r,n=a(e),o=s.f,u=i(n),l={},f=0;while(u.length>f)r=o(n,t=u[f++]),void 0!==r&&c(l,t,r);return l}})},e439:function(e,t,r){var n=r("23e7"),o=r("d039"),i=r("fc6a"),a=r("06cf").f,s=r("83ab"),c=o((function(){a(1)})),u=!s||c;n({target:"Object",stat:!0,forced:u,sham:!s},{getOwnPropertyDescriptor:function(e,t){return a(i(e),t)}})},f2bf:function(e,t,r){}}]);
//# sourceMappingURL=chunk-4a62d4bd.e712ffe0.js.map