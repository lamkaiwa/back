(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-64d0d2f9"],{"075b":function(e,t,r){},"093a":function(e,t,r){"use strict";r.d(t,"C",(function(){return o})),r.d(t,"w",(function(){return i})),r.d(t,"p",(function(){return a})),r.d(t,"A",(function(){return u})),r.d(t,"x",(function(){return c})),r.d(t,"y",(function(){return s})),r.d(t,"q",(function(){return d})),r.d(t,"e",(function(){return l})),r.d(t,"s",(function(){return f})),r.d(t,"z",(function(){return h})),r.d(t,"j",(function(){return v})),r.d(t,"i",(function(){return p})),r.d(t,"d",(function(){return m})),r.d(t,"n",(function(){return g})),r.d(t,"l",(function(){return b})),r.d(t,"B",(function(){return y})),r.d(t,"v",(function(){return w})),r.d(t,"o",(function(){return O})),r.d(t,"k",(function(){return j})),r.d(t,"u",(function(){return x})),r.d(t,"t",(function(){return k})),r.d(t,"b",(function(){return L})),r.d(t,"a",(function(){return A})),r.d(t,"f",(function(){return F})),r.d(t,"c",(function(){return z})),r.d(t,"r",(function(){return E})),r.d(t,"g",(function(){return _})),r.d(t,"h",(function(){return $})),r.d(t,"m",(function(){return P}));var n=r("4279"),o=function(e,t){return Object(n["a"])("/video/upload/uploadVideo",e,"post",{headers:{Authorization:t}})},i=function(e){return Object(n["a"])("/video/home/getLunBoPic",{},"get",{headers:{Authorization:e}})},a=function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:1,t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:"",r=arguments.length>2?arguments[2]:void 0;return Object(n["a"])("/video/home/getVideoPage",{page:e,type:t},"get",{headers:{Authorization:r}})},u=function(e){return Object(n["a"])("/video/top/getTopVideo",{},"get",{headers:{Authorization:e}})},c=function(e,t,r,o){return Object(n["a"])("/video/search/searchVideos",{words:e,page:t,sortBy:r},"get",{headers:{Authorization:o}})},s=function(e,t){return Object(n["a"])("/video/search/searchCount",{words:e},"get",{headers:{Authorization:t}})},d=function(e,t){return Object(n["a"])("/video/mine/video/getVideoPageByUser",e,"get",{headers:{Authorization:t}})},l=function(e,t){return Object(n["a"])("/video/mine/video/deleteVideoById",{videoId:e},"get",{headers:{Authorization:t}})},f=function(e,t){return Object(n["a"])("/video/home/getTotalVideoByType",{type:e},"get",{headers:{Authorization:t}})},h=function(e,t,r){return Object(n["a"])("/video/mine/video/searchCount",{words:e,userId:t},"get",{headers:{Authorization:r}})},v=function(e,t,r){return Object(n["a"])("/video/mine/collection/getCollectionVideoListByUserId",{userId:e,page:t},"get",{headers:{Authorization:r}})},p=function(e,t){return Object(n["a"])("/video/mine/collection/getAttentionCountByUserId",{userId:e},"get",{headers:{Authorization:t}})},m=function(e,t){return Object(n["a"])("/video/mine/collection/deleteCollectionListByVideoIdAndUserId",e,"post",{headers:{Authorization:t}})},g=function(e,t){return Object(n["a"])("/video/detail/getVideoByVideoId",{videoId:e},"get",{headers:{Authorization:t}})},b=function(e,t,r){return Object(n["a"])("/video/detail/getRecommendVideoByWord",{title:e,desc:t},"get",{headers:{Authorization:r}})},y=function(e,t){return Object(n["a"])("/video/detail/updateVideoPlayCount",{videoId:e},"get",{headers:{Authorization:t}})},w=function(e,t){return Object(n["a"])("/video/detail/getVideoBlock",{type:e.type,block:e.block,videoName:e.videoName},"get",{headers:{Authorization:t},responseType:"arraybuffer"})},O=function(e,t,r){return Object(n["a"])("/video/detail/getVideoInfo",{type:e,fileName:t},"get",{headers:{Authorization:r}})},j=function(e,t,r,o){return Object(n["a"])("/video/detail/getImageBytesOnSpecifiedTime",{type:e,videoName:t,time:r},"get",{headers:{Authorization:o},responseType:"blob"})},x=function(e,t){return Object(n["a"])("/video/detail/isZan",e,"post",{headers:{Authorization:t}})},k=function(e,t){return Object(n["a"])("/video/detail/isCollectionList",e,"post",{headers:{Authorization:t}})},L=function(e,t){return Object(n["a"])("/video/detail/addZan",e,"post",{headers:{Authorization:t}})},A=function(e,t){return Object(n["a"])("/video/detail/addCollection",e,"post",{headers:{Authorization:t}})},F=function(e,t){return Object(n["a"])("/video/detail/deleteZan",e,"post",{headers:{Authorization:t}})},z=function(e,t){return Object(n["a"])("/video/detail/deleteCollection",e,"post",{headers:{Authorization:t}})},E=function(e,t){return Object(n["a"])("/video/webUpload/getYoutubeDLsByUrl",{url:e},"get",{headers:{Authorization:t}})},_=function(e,t){return Object(n["a"])("/video/webUpload/downLoadVideoByYoutubeDl",e,"post",{headers:{Authorization:t}})},$=function(e,t){return Object(n["a"])("/video/admin/video/editVideo",e,"post",{headers:{Authorization:t}})},P=function(e){return Object(n["a"])("/video/admin/video/getType",{},"get",{headers:{Authorization:e}})}},5530:function(e,t,r){"use strict";r.d(t,"a",(function(){return i}));r("b64b"),r("a4d3"),r("4de4"),r("d3b7"),r("e439"),r("159b"),r("dbb4");function n(e,t,r){return t in e?Object.defineProperty(e,t,{value:r,enumerable:!0,configurable:!0,writable:!0}):e[t]=r,e}function o(e,t){var r=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),r.push.apply(r,n)}return r}function i(e){for(var t=1;t<arguments.length;t++){var r=null!=arguments[t]?arguments[t]:{};t%2?o(Object(r),!0).forEach((function(t){n(e,t,r[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(r)):o(Object(r)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(r,t))}))}return e}},"8e28":function(e,t,r){"use strict";var n=r("075b"),o=r.n(n);o.a},a01c:function(e,t,r){"use strict";r.d(t,"a",(function(){return o}));var n=r("4279"),o=function(e){return Object(n["a"])("/video/home/getAllType",{},"get",{headers:{Authorization:e}})}},dbb4:function(e,t,r){var n=r("23e7"),o=r("83ab"),i=r("56ef"),a=r("fc6a"),u=r("06cf"),c=r("8418");n({target:"Object",stat:!0,sham:!o},{getOwnPropertyDescriptors:function(e){var t,r,n=a(e),o=u.f,s=i(n),d={},l=0;while(s.length>l)r=o(n,t=s[l++]),void 0!==r&&c(d,t,r);return d}})},e439:function(e,t,r){var n=r("23e7"),o=r("d039"),i=r("fc6a"),a=r("06cf").f,u=r("83ab"),c=o((function(){a(1)})),s=!u||c;n({target:"Object",stat:!0,forced:s,sham:!u},{getOwnPropertyDescriptor:function(e,t){return a(i(e),t)}})},f8db:function(e,t,r){"use strict";r.r(t);var n=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"videoForm"},[r("el-form",{ref:"videoForm",attrs:{model:e.videoForm,"label-width":"80px",rules:e.rules,"label-position":"top"}},[r("el-form-item",{attrs:{label:"网站地址:目前支持youtube和优酷 tip:将你要上传的视频链接地址填在空格中，然后检验是否有效",prop:"url"}},[r("el-input",{model:{value:e.videoForm.url,callback:function(t){e.$set(e.videoForm,"url",t)},expression:"videoForm.url"}}),r("el-button",{staticClass:"checkurl",attrs:{plain:!0},on:{click:e.checkurl}},[e._v("查看链接是否有效")])],1),e.visible?r("el-form-item",{attrs:{label:"请选择视频版本"}},[r("el-radio-group",{model:{value:e.videoForm.version,callback:function(t){e.$set(e.videoForm,"version",t)},expression:"videoForm.version"}},e._l(e.versionList,(function(t){return r("div",{key:t.formatCode},[r("div",[r("el-radio",{attrs:{label:t}},[e._v("版本："+e._s(t.formatCode)+" 格式: "+e._s(t.extension)+" 视频宽高: "+e._s(t.resolution)+" 视频大小: "+e._s(t.note))])],1)])})),0)],1):e._e(),r("el-form-item",{attrs:{label:"视频标题",prop:"title"}},[r("el-input",{model:{value:e.videoForm.title,callback:function(t){e.$set(e.videoForm,"title",t)},expression:"videoForm.title"}})],1),r("el-form-item",{attrs:{label:"视频类型",prop:"type"}},[r("el-select",{attrs:{placeholder:"请选择视频类型"},model:{value:e.videoForm.type,callback:function(t){e.$set(e.videoForm,"type",t)},expression:"videoForm.type"}},e._l(e.types,(function(e,t){return r("el-option",{key:t,attrs:{label:e,value:t+1}})})),1)],1),r("el-form-item",{attrs:{label:"简介"}},[r("el-input",{attrs:{type:"textarea",rows:"5"},model:{value:e.videoForm.desc,callback:function(t){e.$set(e.videoForm,"desc",t)},expression:"videoForm.desc"}})],1),r("el-form-item",[r("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.submit()}}},[e._v("立即提交")])],1)],1)],1)},o=[],i=(r("a4d3"),r("e01a"),r("d3b7"),r("d28b"),r("3ca3"),r("ddb0"),r("b636"),r("944a"),r("0c47"),r("23dc"),r("3410"),r("159b"),r("b0c0"),r("131a"),r("fb6a"),r("53ca")),a=r("5530"),u=r("1da1"),c=r("2f62"),s=r("a01c"),d=r("093a");function l(){/*! regenerator-runtime -- Copyright (c) 2014-present, Facebook, Inc. -- license (MIT): https://github.com/facebook/regenerator/blob/main/LICENSE */l=function(){return e};var e={},t=Object.prototype,r=t.hasOwnProperty,n="function"==typeof Symbol?Symbol:{},o=n.iterator||"@@iterator",a=n.asyncIterator||"@@asyncIterator",u=n.toStringTag||"@@toStringTag";function c(e,t,r){return Object.defineProperty(e,t,{value:r,enumerable:!0,configurable:!0,writable:!0}),e[t]}try{c({},"")}catch(z){c=function(e,t,r){return e[t]=r}}function s(e,t,r,n){var o=t&&t.prototype instanceof h?t:h,i=Object.create(o.prototype),a=new L(n||[]);return i._invoke=function(e,t,r){var n="suspendedStart";return function(o,i){if("executing"===n)throw new Error("Generator is already running");if("completed"===n){if("throw"===o)throw i;return F()}for(r.method=o,r.arg=i;;){var a=r.delegate;if(a){var u=j(a,r);if(u){if(u===f)continue;return u}}if("next"===r.method)r.sent=r._sent=r.arg;else if("throw"===r.method){if("suspendedStart"===n)throw n="completed",r.arg;r.dispatchException(r.arg)}else"return"===r.method&&r.abrupt("return",r.arg);n="executing";var c=d(e,t,r);if("normal"===c.type){if(n=r.done?"completed":"suspendedYield",c.arg===f)continue;return{value:c.arg,done:r.done}}"throw"===c.type&&(n="completed",r.method="throw",r.arg=c.arg)}}}(e,r,a),i}function d(e,t,r){try{return{type:"normal",arg:e.call(t,r)}}catch(z){return{type:"throw",arg:z}}}e.wrap=s;var f={};function h(){}function v(){}function p(){}var m={};c(m,o,(function(){return this}));var g=Object.getPrototypeOf,b=g&&g(g(A([])));b&&b!==t&&r.call(b,o)&&(m=b);var y=p.prototype=h.prototype=Object.create(m);function w(e){["next","throw","return"].forEach((function(t){c(e,t,(function(e){return this._invoke(t,e)}))}))}function O(e,t){function n(o,a,u,c){var s=d(e[o],e,a);if("throw"!==s.type){var l=s.arg,f=l.value;return f&&"object"==Object(i["a"])(f)&&r.call(f,"__await")?t.resolve(f.__await).then((function(e){n("next",e,u,c)}),(function(e){n("throw",e,u,c)})):t.resolve(f).then((function(e){l.value=e,u(l)}),(function(e){return n("throw",e,u,c)}))}c(s.arg)}var o;this._invoke=function(e,r){function i(){return new t((function(t,o){n(e,r,t,o)}))}return o=o?o.then(i,i):i()}}function j(e,t){var r=e.iterator[t.method];if(void 0===r){if(t.delegate=null,"throw"===t.method){if(e.iterator.return&&(t.method="return",t.arg=void 0,j(e,t),"throw"===t.method))return f;t.method="throw",t.arg=new TypeError("The iterator does not provide a 'throw' method")}return f}var n=d(r,e.iterator,t.arg);if("throw"===n.type)return t.method="throw",t.arg=n.arg,t.delegate=null,f;var o=n.arg;return o?o.done?(t[e.resultName]=o.value,t.next=e.nextLoc,"return"!==t.method&&(t.method="next",t.arg=void 0),t.delegate=null,f):o:(t.method="throw",t.arg=new TypeError("iterator result is not an object"),t.delegate=null,f)}function x(e){var t={tryLoc:e[0]};1 in e&&(t.catchLoc=e[1]),2 in e&&(t.finallyLoc=e[2],t.afterLoc=e[3]),this.tryEntries.push(t)}function k(e){var t=e.completion||{};t.type="normal",delete t.arg,e.completion=t}function L(e){this.tryEntries=[{tryLoc:"root"}],e.forEach(x,this),this.reset(!0)}function A(e){if(e){var t=e[o];if(t)return t.call(e);if("function"==typeof e.next)return e;if(!isNaN(e.length)){var n=-1,i=function t(){for(;++n<e.length;)if(r.call(e,n))return t.value=e[n],t.done=!1,t;return t.value=void 0,t.done=!0,t};return i.next=i}}return{next:F}}function F(){return{value:void 0,done:!0}}return v.prototype=p,c(y,"constructor",p),c(p,"constructor",v),v.displayName=c(p,u,"GeneratorFunction"),e.isGeneratorFunction=function(e){var t="function"==typeof e&&e.constructor;return!!t&&(t===v||"GeneratorFunction"===(t.displayName||t.name))},e.mark=function(e){return Object.setPrototypeOf?Object.setPrototypeOf(e,p):(e.__proto__=p,c(e,u,"GeneratorFunction")),e.prototype=Object.create(y),e},e.awrap=function(e){return{__await:e}},w(O.prototype),c(O.prototype,a,(function(){return this})),e.AsyncIterator=O,e.async=function(t,r,n,o,i){void 0===i&&(i=Promise);var a=new O(s(t,r,n,o),i);return e.isGeneratorFunction(r)?a:a.next().then((function(e){return e.done?e.value:a.next()}))},w(y),c(y,u,"Generator"),c(y,o,(function(){return this})),c(y,"toString",(function(){return"[object Generator]"})),e.keys=function(e){var t=[];for(var r in e)t.push(r);return t.reverse(),function r(){for(;t.length;){var n=t.pop();if(n in e)return r.value=n,r.done=!1,r}return r.done=!0,r}},e.values=A,L.prototype={constructor:L,reset:function(e){if(this.prev=0,this.next=0,this.sent=this._sent=void 0,this.done=!1,this.delegate=null,this.method="next",this.arg=void 0,this.tryEntries.forEach(k),!e)for(var t in this)"t"===t.charAt(0)&&r.call(this,t)&&!isNaN(+t.slice(1))&&(this[t]=void 0)},stop:function(){this.done=!0;var e=this.tryEntries[0].completion;if("throw"===e.type)throw e.arg;return this.rval},dispatchException:function(e){if(this.done)throw e;var t=this;function n(r,n){return a.type="throw",a.arg=e,t.next=r,n&&(t.method="next",t.arg=void 0),!!n}for(var o=this.tryEntries.length-1;o>=0;--o){var i=this.tryEntries[o],a=i.completion;if("root"===i.tryLoc)return n("end");if(i.tryLoc<=this.prev){var u=r.call(i,"catchLoc"),c=r.call(i,"finallyLoc");if(u&&c){if(this.prev<i.catchLoc)return n(i.catchLoc,!0);if(this.prev<i.finallyLoc)return n(i.finallyLoc)}else if(u){if(this.prev<i.catchLoc)return n(i.catchLoc,!0)}else{if(!c)throw new Error("try statement without catch or finally");if(this.prev<i.finallyLoc)return n(i.finallyLoc)}}}},abrupt:function(e,t){for(var n=this.tryEntries.length-1;n>=0;--n){var o=this.tryEntries[n];if(o.tryLoc<=this.prev&&r.call(o,"finallyLoc")&&this.prev<o.finallyLoc){var i=o;break}}i&&("break"===e||"continue"===e)&&i.tryLoc<=t&&t<=i.finallyLoc&&(i=null);var a=i?i.completion:{};return a.type=e,a.arg=t,i?(this.method="next",this.next=i.finallyLoc,f):this.complete(a)},complete:function(e,t){if("throw"===e.type)throw e.arg;return"break"===e.type||"continue"===e.type?this.next=e.arg:"return"===e.type?(this.rval=this.arg=e.arg,this.method="return",this.next="end"):"normal"===e.type&&t&&(this.next=t),f},finish:function(e){for(var t=this.tryEntries.length-1;t>=0;--t){var r=this.tryEntries[t];if(r.finallyLoc===e)return this.complete(r.completion,r.afterLoc),k(r),f}},catch:function(e){for(var t=this.tryEntries.length-1;t>=0;--t){var r=this.tryEntries[t];if(r.tryLoc===e){var n=r.completion;if("throw"===n.type){var o=n.arg;k(r)}return o}}throw new Error("illegal catch attempt")},delegateYield:function(e,t,r){return this.delegate={iterator:A(e),resultName:t,nextLoc:r},"next"===this.method&&(this.arg=void 0),f}},e}var f={data:function(){return{visible:!1,versionList:[],types:["生活","科技","游戏","校园","教育","动物","其他"],imgUrl:"",rules:{url:[{type:"url",message:"请输入正确的网址,然后点击检查是否有相关资源",trigger:"blur"}],title:[{required:!0,message:"请输入标题",trigger:"blur"},{max:90,message:"长度不超过30个字符",trigger:"blur"}],type:[{required:!0,message:"请选择类型",trigger:"blur"}]},videoForm:{title:"",type:"",desc:"",url:"",version:""},img:"",video:"",process:0}},methods:{checkurl:function(){var e=this;return Object(u["a"])(l().mark((function t(){var r,n;return l().wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(""==e.videoForm.url){t.next=9;break}return r=e.$loading({text:"正在检查url是否可用",fullscreen:!0,lock:!0,background:"rgba(255,255,255,.7)"}),t.next=4,Object(d["r"])(e.videoForm.url,e.$store.state.user.token);case 4:n=t.sent,r.close(),200==n.code&&(e.visible=!0,e.versionList=n.data,0==e.versionList.length?(e.visible=!1,e.versionList=[],e.videoForm={},e.$message.error("该视频没有资源请选择其他链接")):e.$message.success("网址正确，请选择下面所要下载的版本")),t.next=11;break;case 9:e.visible=!1,e.$message.error("请填写正确的网站地址,不能为空");case 11:case"end":return t.stop()}}),t)})))()},imgRemove:function(){this.imgUrl="",this.img=""},videoRemove:function(){this.video=""},videoExceed:function(){this.$message.error("视频只能上传一个")},imgExceed:function(){this.$message.error("图片只能上传一个")},submit:function(){var e=this;return Object(u["a"])(l().mark((function t(){var r,n;return l().wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(""!=e.videoForm.version&&""!=e.videoForm.desc){t.next=4;break}e.$message("视频版本和视频吗描述不能为空"),t.next=12;break;case 4:return r=e.$loading({text:"正在上传视频，请稍等",fullscreen:!0,lock:!0,background:"rgba(255,255,255,.7)"}),t.next=7,Object(d["g"])({url:e.videoForm.url,title:e.videoForm.title,desc:e.videoForm.desc,type:e.videoForm.type,code:e.videoForm.version.formatCode,author:e.$store.state.user.id,email:e.$store.state.user.email},e.$store.state.user.token);case 7:n=t.sent,200==n.code?e.$message.success("视频正在上传,当上传成功后系统会发信息给你"):e.$message.error("视频上传失败"),e.videoForm={},e.visible=!1,r.close();case 12:case"end":return t.stop()}}),t)})))()},init:function(){var e=this;return Object(u["a"])(l().mark((function t(){var r;return l().wrap((function(t){while(1)switch(t.prev=t.next){case 0:return null==e.$store.state.user&&(e.$message.error("先登录"),e.$router.push("/login/loginForm")),t.next=3,Object(s["a"])(e.$store.state.user.token);case 3:r=t.sent,200==r.code&&(e.types=r.data);case 5:case"end":return t.stop()}}),t)})))()}},computed:Object(a["a"])({},Object(c["b"])(["userId"])),created:function(){this.init()}},h=f,v=(r("8e28"),r("2877")),p=Object(v["a"])(h,n,o,!1,null,"6cd85d1e",null);t["default"]=p.exports}}]);
//# sourceMappingURL=chunk-64d0d2f9.7f8f8ffa.js.map