(function(e){function t(t){for(var r,o,s=t[0],c=t[1],u=t[2],p=0,d=[];p<s.length;p++)o=s[p],Object.prototype.hasOwnProperty.call(a,o)&&a[o]&&d.push(a[o][0]),a[o]=0;for(r in c)Object.prototype.hasOwnProperty.call(c,r)&&(e[r]=c[r]);l&&l(t);while(d.length)d.shift()();return i.push.apply(i,u||[]),n()}function n(){for(var e,t=0;t<i.length;t++){for(var n=i[t],r=!0,s=1;s<n.length;s++){var c=n[s];0!==a[c]&&(r=!1)}r&&(i.splice(t--,1),e=o(o.s=n[0]))}return e}var r={},a={app:0},i=[];function o(t){if(r[t])return r[t].exports;var n=r[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,o),n.l=!0,n.exports}o.m=e,o.c=r,o.d=function(e,t,n){o.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},o.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},o.t=function(e,t){if(1&t&&(e=o(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(o.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var r in e)o.d(n,r,function(t){return e[t]}.bind(null,r));return n},o.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return o.d(t,"a",t),t},o.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},o.p="/";var s=window["webpackJsonp"]=window["webpackJsonp"]||[],c=s.push.bind(s);s.push=t,s=s.slice();for(var u=0;u<s.length;u++)t(s[u]);var l=c;i.push([0,"chunk-vendors"]),n()})({0:function(e,t,n){e.exports=n("56d7")},1:function(e,t){},"19be":function(e,t,n){"use strict";n("6644")},2395:function(e,t,n){},"239a":function(e,t,n){e.exports=n.p+"img/Logout.f61ced29.png"},"54b7":function(e,t,n){"use strict";n("7cd9")},"56d7":function(e,t,n){"use strict";n.r(t);n("e260"),n("e6cf"),n("cca6"),n("a79d");var r=n("2b0e"),a=n("5c96"),i=n.n(a),o=(n("0fae"),function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"app"}},[n("router-view")],1)}),s=[],c=(n("7c55"),n("2877")),u={},l=Object(c["a"])(u,o,s,!1,null,null,null),p=l.exports,d=n("8c4f"),f=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[n("h1",[e._v(e._s(e.$route.params.category))]),n("h1",[e._v(e._s(e.$route.params.id))]),n("video",{attrs:{src:"/product/video/"+e.$route.params.category+"/"+e.$route.params.id,controls:"controls",width:"500px",height:"500px"}})])},m=[],h={},g=h,v=Object(c["a"])(g,f,m,!1,null,null,null),b=v.exports,x=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"index-container"},[n("h1"),n("Top"),n("Left"),n("Filters",{attrs:{buttonList:e.catalogue}}),n("ul",{directives:[{name:"infinite-scroll",rawName:"v-infinite-scroll",value:e.load,expression:"load"}],staticClass:"infinite-list",staticStyle:{overflow:"auto"}},[n("Main",[e._l(e.videoList,(function(e,t){return n("template",{slot:"video"},[n("AV",{key:t,attrs:{product:e}})],1)}))],2)],1)],1)},y=[],j=n("1da1"),k=(n("96cf"),function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"top-container"},[r("nav",{staticClass:"navbar"},[e._m(0),r("img",{staticClass:"logo",attrs:{src:n("a1d8"),alt:""}}),r("div",{staticClass:"search-box"},[r("input",{directives:[{name:"model",rawName:"v-model",value:e.searchText,expression:"searchText"}],staticClass:"search-bar",attrs:{type:"text",placeholder:"search"},domProps:{value:e.searchText},on:{input:function(t){t.target.composing||(e.searchText=t.target.value)}}}),r("button",{staticClass:"search-btn",on:{click:e.searchButton}},[r("img",{attrs:{src:n("8743"),alt:""}})])]),e._m(1)])])}),w=[function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"toggle-btn"},[n("span"),n("span"),n("span")])},function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"user-options"},[r("img",{staticClass:"icon",attrs:{src:n("e350"),alt:""}}),r("img",{staticClass:"icon",attrs:{src:n("fcbb"),alt:""}}),r("img",{staticClass:"icon",attrs:{src:n("fcab"),alt:""}}),r("div",{staticClass:"user-dp"},[r("img",{attrs:{src:n("a2f9"),alt:""}})])])}],O=new r["default"],_=O,R={data:function(){return{searchText:null,sendText:null}},methods:{searchButton:function(){this.sendText!=this.searchText&&(this.sendText=this.searchText,_.$emit("searchButton",this.sendText))}}},$=R,C=(n("19be"),Object(c["a"])($,k,w,!1,null,"504811e4",null)),T=C.exports,L=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"left-container"},[n("div",{staticClass:"side-bar"},e._l(e.leftBarList,(function(t){return n("a",{key:t.name,class:e.currentId==t.name?"links active":"links",on:{click:function(n){return e.changeButton(t.name)}}},[n("img",{attrs:{src:t.url,alt:""}}),e._v(" "+e._s(t.name)+" ")])})),0)])},P=[],N=(n("ac1f"),n("1276"),{data:function(){return{leftBarList:[{url:n("70ad"),name:"主页"},{url:n("a51a"),name:"权限控制"},{url:n("dbc7"),name:"管理员页面"},{url:n("239a"),name:"登出"}],currentId:"home"}},methods:{changeButton:function(e){var t=this;return Object(j["a"])(regeneratorRuntime.mark((function n(){var r;return regeneratorRuntime.wrap((function(n){while(1)switch(n.prev=n.next){case 0:if("登出"!=e){n.next=3;break}return window.location.href="/logout",n.abrupt("return",!1);case 3:return n.next=5,t.havaAuthentication("admin");case 5:if(r=n.sent,!r){n.next=10;break}return"权限控制"==e&&(window.location.href=t.authrizationControl),"管理员页面"==e&&(window.location.href=t.adminPage),n.abrupt("return",!1);case 10:return t.$message("你没有权限进入"),n.abrupt("return",!1);case 12:case"end":return n.stop()}}),n)})))()},havaAuthentication:function(e){var t=this;return Object(j["a"])(regeneratorRuntime.mark((function n(){var r,a,i,o;return regeneratorRuntime.wrap((function(n){while(1)switch(n.prev=n.next){case 0:return!1,n.next=3,t.Cookies.get("authCookie");case 3:r=n.sent,a=r.split("/"),i=a.length,o=0;case 7:if(!(o<i)){n.next=13;break}if(e!=a[o]){n.next=10;break}return n.abrupt("return",!0);case 10:o++,n.next=7;break;case 13:return n.abrupt("return",!1);case 14:case"end":return n.stop()}}),n)})))()}}}),S=N,B=(n("cc8e"),Object(c["a"])(S,L,P,!1,null,"1f7d9048",null)),I=B.exports,E=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"filter-container"},[n("div",{staticClass:"filters"},e._l(e.buttonList,(function(t){return n("button",{key:t,class:e.currentIndex==t?"filter-options active":"filter-options",on:{click:function(n){return e.changeButton(t)}}},[e._v(e._s(t))])})),0)])},F=[],V={props:{buttonList:{type:Array,default:function(){return["all","CSS","web development","python","entertainment","marvel","javascript","artificial intellience","meachine leaning","treand"]}}},data:function(){return{currentIndex:"all"}},methods:{changeButton:function(e){this.currentIndex!=e&&(this.currentIndex=e,_.$emit("changeButton",this.currentIndex))}}},M=V,U=(n("e073"),Object(c["a"])(M,E,F,!1,null,"02e62351",null)),z=U.exports,A=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"main-container"},[n("div",{staticClass:"video-container"},[e._t("video")],2)])},q=[],D={},J=D,H=(n("ac90"),Object(c["a"])(J,A,q,!1,null,"9eba8fbc",null)),X=H.exports,G=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"video-container-in"},[n("div",{staticClass:"video"},[n("img",{ref:"image",staticClass:"thumbnail",attrs:{alt:""},on:{mousemove:function(t){return e.playVideo()},mouseout:function(t){return e.stopVideo()},click:function(t){return e.clickVideo()}}}),n("div",{staticClass:"content"},[n("div",{staticClass:"info"},[n("h5",{staticClass:"title"},[e._v(e._s(e.product.videoInfo))]),null!=e.product.name?n("p",{staticClass:"channel-name"},[e._v(" "+e._s(e.product.name)+" ")]):e._e()])])])])},K=[],Q=(n("d3b7"),n("3ca3"),n("ddb0"),n("2b3d"),n("9861"),{props:["product"],mounted:function(){this.getImage()},updated:function(){this.getImage()},created:function(){},methods:{getImage:function(){var e=this.$refs.image,t=this.localhost+"/product/image/getimage/"+this.product.dir+"/"+this.product.imageFileName,n=new XMLHttpRequest;n.responseType="blob",n.open("get",t,!0),n.setRequestHeader("Authorization","Bearer "+this.Cookies.get(this.CookiesName)),n.onreadystatechange=function(t){n.readyState==XMLHttpRequest.DONE&&200==n.status&&(e.src=URL.createObjectURL(n.response),e.onload=function(){URL.revokeObjectURL(e.src)})},n.send(null)},playVideo:function(){},stopVideo:function(){},clickVideo:function(){this.$router.push("/video/"+this.product.dir+"/"+this.product.videoFileName)}}}),W=Q,Y=(n("b273"),Object(c["a"])(W,G,K,!1,null,"758d7570",null)),Z=Y.exports,ee={components:{Top:T,Left:I,Filters:z,Main:X,AV:Z},mounted:function(){var e=this;return Object(j["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,e.Cookies.get("client1token");case 2:return t.sent,e.$http.post("/product/index/getVideoInfo",{page:1,dir:e.dir}).then((function(t){200==t.code&&"ok"==t.message&&(e.videoList=t.data)})),e.$http.post("/product/filter/getCatalogue",null).then((function(t){200==t.code&&"ok"==t.message&&(e.catalogue=t.data)})),t.next=7,e.$http.post("/product/index/indexTable/getPageNumber",{dir:e.dir});case 7:e.pageSize=t.sent;case 8:case"end":return t.stop()}}),t)})))()},created:function(){var e=this;return Object(j["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:_.$on("changeButton",function(){var t=Object(j["a"])(regeneratorRuntime.mark((function t(n){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return e.dir=n,t.next=3,e.$http.post("/product/index/indexTable/getPageNumber",{dir:e.dir});case 3:return e.pageSize=t.sent,t.next=6,e.$http.post("/product/index/getVideoInfo",{page:1,dir:e.dir});case 6:e.videoList=t.sent.data,e.currentPage=1,0==e.videoList.length&&e.$message.success("此栏目没有视频");case 9:case"end":return t.stop()}}),t)})));return function(e){return t.apply(this,arguments)}}()),_.$on("searchButton",function(){var t=Object(j["a"])(regeneratorRuntime.mark((function t(n){var r;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,e.$http.post("/product/index/indexTable/getSearchVideoInfo",{text:n});case 2:r=t.sent,200==r.code&&(r.data.length>0?(e.currentPage=1,e.pageSize=1,e.videoList=r.data):e.$message.success("没有相关的视频，请重新搜寻"));case 4:case"end":return t.stop()}}),t)})));return function(e){return t.apply(this,arguments)}}());case 2:case"end":return t.stop()}}),t)})))()},beforeMount:function(){return Object(j["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:case"end":return e.stop()}}),e)})))()},dated:function(){return Object(j["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:case"end":return e.stop()}}),e)})))()},data:function(){return{videoList:null,catalogue:null,pageSize:1,currentPage:1,dir:"all"}},methods:{load:function(){var e=this;return Object(j["a"])(regeneratorRuntime.mark((function t(){var n,r,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(e.currentPage!=e.pageSize){t.next=2;break}return t.abrupt("return");case 2:return e.currentPage++,t.next=5,e.$http.post("/product/index/getVideoInfo",{page:e.currentPage,dir:e.dir});case 5:for(n=t.sent.data,r=n.length,a=0;a<r;a++)e.videoList.push(n[a]);case 8:case"end":return t.stop()}}),t)})))()}}},te=ee,ne=(n("54b7"),Object(c["a"])(te,x,y,!1,null,"6fb4ff9c",null)),re=ne.exports,ae=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[e._m(0),n("div",{ref:"image",staticClass:"demo-image"},e._l(e.fits,(function(t){return n("div",{key:t,staticClass:"block"},[n("el-image",{staticStyle:{width:"200px",height:"200px"},attrs:{src:e.smallPic,fit:t}})],1)})),0)])},ie=[function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[n("div",[n("video",{staticClass:"video-js vjs-default-skin vjs-big-play-centered",attrs:{id:"video",controls:"",preload:"none"}})])])}],oe=(n("7db0"),n("4795"),n("00b4"),n("1157")),se=n.n(oe),ce={components:{},data:function(){return{myPlayer:null,that:null,dir:null,videoFileName:null,product:null,videoImg:null,videoSrc:null,fits:["fill"],smallPic:null}},mounted:function(){var e=this;return Object(j["a"])(regeneratorRuntime.mark((function t(){var n,r,a,i,o,s,c,u,l,p,d,f,m,h,g,v,b,x,y,k,w,O,_;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return _=function(){return _=Object(j["a"])(regeneratorRuntime.mark((function e(t,r,a){var i,o;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return i="/product/video/getVideoBytes/"+t+"/"+r+"/"+a,e.next=3,n.$http.get(i,null,{responseType:"arraybuffer"});case 3:return o=e.sent,e.abrupt("return",o);case 5:case"end":return e.stop()}}),e)}))),_.apply(this,arguments)},O=function(e,t,n){return _.apply(this,arguments)},w=function(){return w=Object(j["a"])(regeneratorRuntime.mark((function e(t,n,r,a){var i;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,O(t,n,r);case 2:i=e.sent,p?(p=!1,a.appendBuffer(i)):d.push(i);case 4:case"end":return e.stop()}}),e)}))),w.apply(this,arguments)},k=function(e,t,n,r){return w.apply(this,arguments)},y=function(e){var t=null;return/^\d+$/.test(e)?e="0:0:"+e:/^\d+:\d+$/.test(e)&&(e="0:"+e),t=e.split(":"),e=60*+t[0]*60+60*+t[1]+ +t[2]+"","NaN"==e&&(e="0"),e},x=function(){return x=Object(j["a"])(regeneratorRuntime.mark((function e(t,r,a,i,o){var s,c;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(s="/product/image/getImageBytesOnSpecifiedTime/"+t+"/"+r+"/"+o,!a){e.next=6;break}return e.next=4,i.$http.get(s,null,{responseType:"blob"});case 4:c=e.sent,n.smallPic=URL.createObjectURL(c);case 6:case"end":return e.stop()}}),e)}))),x.apply(this,arguments)},b=function(e,t,n,r,a){return x.apply(this,arguments)},function(e,t){},v=function(e,t){var n=e.$refs.image,r=se()(".vjs-mouse-display .vjs-time-tooltip"),a=r.offset();n.style.top=a.top-200+"px",n.style.left=a.left-80+"px",n.style.display="block"},g=function(){l.appendBuffer(d.shift())},e.that=e,n=e.that,e.dir=e.$route.params.dir,e.videoFileName=e.$route.params.videoFileName,t.next=16,e.$http.post("/product/video/info",{videoFileName:e.videoFileName});case 16:return e.product=t.sent.data,t.next=19,e.$http.get("/product/image/getimage/"+e.product.dir+"/"+e.product.imageFileName,null,{responseType:"blob"});case 19:return r=t.sent,e.videoImg=URL.createObjectURL(r),a=e.product.dir,i=e.product.videoFileName.split(".")[0],o="product/video/info/"+a+"/"+i,t.next=26,e.$http.get(o,null);case 26:s=t.sent,c=new MediaSource,e.videoSrc=URL.createObjectURL(c),u=s.mimeType+"; codecs="+s.codes,l=null,p=!0,d=[],f=60,e.myPlayer=e.$videojs("video",{controls:!0,muted:!1,autoplay:!0,preload:"auto",width:"1280px",height:"720px",poster:e.videoImg,sources:[{src:e.videoSrc,type:"video/mp4"}],playbackRates:[.5,1,1.5,2,3]},(function(){var e=this,t=document.getElementById("video_html5_api");function r(){var t=e.player_.children_[0],r=(se()(t).closest(".video-js"),se()(".vjs-progress-control")[0]);console.log(r);var a=-1,i=null;r.addEventListener("mousemove",function(){var e=Object(j["a"])(regeneratorRuntime.mark((function e(t){var r,o,s;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(r=se()(this).find(".vjs-mouse-display .vjs-time-tooltip"),o=r.text(),o!=a&&""!=o){e.next=4;break}return e.abrupt("return");case 4:a=o,s=n.$refs.image,s.style.display="none",clearTimeout(i),i=setTimeout((function(){var e=y(o),r=n.product.dir,a=n.product.videoFileName;a=a.split(".")[0],b(r,a,!0,n,e),v(n,t)}),100);case 9:case"end":return e.stop()}}),e,this)})));return function(t){return e.apply(this,arguments)}}()),r.addEventListener("mouseleave",(function(){var e=n.$refs.image;e.style.display="none"}))}r(),t.onkeydown=function(e){if(39==e.keyCode){var n=t.currentTime+5;n>=s.videoTime?t.currentTime=s.videoTime-1:t.currentTime=n}if(37==e.keyCode){var r=t.currentTime-5;t.currentTime=r<0?0:r}},c.addEventListener("sourceopen",Object(j["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return l=c.addSourceBuffer(u),l.onupdateend=function(){0==d.length?p=!0:g()},e.next=4,k(a,i,0,l);case 4:return e.next=6,k(a,i,1,l);case 6:case"end":return e.stop()}}),e)})))),this.on("seeking",Object(j["a"])(regeneratorRuntime.mark((function e(){var n,r,o,s,c,u;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:for(n=t.currentTime,r=!1,o=t.buffered,s=0;s<o.length;s++)c=o.start(s),u=o.end(s),n>=c&&n<=u&&(r=!0);if(r){e.next=7;break}return e.next=7,k(a,i,Math.floor(n/f)+1,l);case 7:case"end":return e.stop()}}),e)})))),this.on("timeupdate",Object(j["a"])(regeneratorRuntime.mark((function e(){var n,r,o,c,u;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(n=t.currentTime,!(n>s.videoTime)){e.next=5;break}return t.currentTime=0,this.pause(),e.abrupt("return");case 5:for(r=!1,o=t.buffered,0,c=0,u=0;u<o.length;u++)o.start(u),c=o.end(u),n<=c-f&&(r=!0);if(r){e.next=14;break}if(!(n+f<=s.videoTime)){e.next=14;break}return e.next=14,k(a,i,Math.ceil((n+f)/f),l);case 14:case"end":return e.stop()}}),e,this)}))))})),m=document.getElementById("video"),h=se()(".demo-image").remove()[0],m.append(h);case 38:case"end":return t.stop()}}),t)})))()},destroyed:function(){this.myPlayer.dispose()}},ue=ce,le=(n("a338"),Object(c["a"])(ue,ae,ie,!1,null,"0f44aef8",null)),pe=le.exports,de=n("f0e2"),fe=n("2eee");n("fda2");de["a"].addLanguage("zh-CN",fe),r["default"].prototype.$videojs=de["a"],r["default"].use(d["a"]);var me=[{path:"/",redirect:"index"},{path:"/index",component:re},{path:"/show/:category/:id",component:b},{path:"/video/:dir/:videoFileName",component:pe}],he=d["a"].prototype.push;d["a"].prototype.push=function(e){return he.call(this,e)["catch"]((function(e){return e}))};var ge=new d["a"]({routes:me}),ve=ge,be=n("b970"),xe=(n("833e"),n("5530")),ye=(n("e9c4"),n("0d03"),n("bc3a")),je=n.n(ye),ke=n("d399"),we="production",Oe="";"development"===we?Oe="http://localhost:7001":"testing"===we?Oe="https://xxx.test.com/api":"production"===we&&(Oe="http://localhost:7001");var _e=je.a.create({baseURL:Oe,timeout:6e4});_e.interceptors.request.use((function(e){return e.data=JSON.stringify(e.data),e.headers={"Content-Type":"application/json",Authorization:"Bearer "+r["default"].prototype.Cookies.get(r["default"].prototype.CookiesName)},"get"==e.method&&(e.params=Object(xe["a"])({t:Date.parse(new Date)},e.params)),e}),(function(e){Promise.reject(e)})),_e.interceptors.response.use((function(e){return e.data}),(function(e){if(e&&e.response)switch(e.response.status){case 400:Object(ke["a"])("错误请求");break;case 401:Object(ke["a"])("未授权，请重新登录");break;case 403:Object(ke["a"])("拒绝访问");break;case 404:Object(ke["a"])("请求错误,未找到该资源");break;case 405:Object(ke["a"])("请求方法未允许");break;case 408:Object(ke["a"])("请求超时");break;case 500:Object(ke["a"])("服务器端出错");break;case 501:Object(ke["a"])("网络未实现");break;case 502:Object(ke["a"])("网络错误");break;case 503:Object(ke["a"])("服务不可用");break;case 504:Object(ke["a"])("网络超时");break;case 505:Object(ke["a"])("http版本不支持该请求");break;default:Object(ke["a"])("连接错误".concat(e.response.status))}else Object(ke["a"])("连接服务器失败");return Promise.resolve(e.response)}));var Re=_e,$e={get:function(e,t,n){var r={};return t&&Object.assign(r,{params:t}),n&&Object.assign(r,n),Re.get(e,r)},post:function(e,t,n){return Re.post(e,t,n)},put:function(e,t,n){return Re.put(e,t,n)},delete:function(e,t,n){var r={};return t&&Object.assign(r,{params:t}),n&&Object.assign(r,n),Re["delete"](e,r)}},Ce=$e,Te="production",Le="";"development"===Te?Le="http://localhost":"testing"===Te?Le="https://xxx.test.com/api":"production"===Te&&(Le="http://localhost");var Pe=je.a.create({baseURL:Le,timeout:6e4});Pe.interceptors.request.use((function(e){return e.data=JSON.stringify(e.data),e.headers={"Content-Type":"application/json"},"get"==e.method&&(e.params=Object(xe["a"])({t:Date.parse(new Date)},e.params)),e}),(function(e){Promise.reject(e)})),Pe.interceptors.response.use((function(e){return e.data}),(function(e){if(e&&e.response)switch(e.response.status){case 400:Object(ke["a"])("错误请求");break;case 401:Object(ke["a"])("未授权，请重新登录");break;case 403:Object(ke["a"])("拒绝访问");break;case 404:Object(ke["a"])("请求错误,未找到该资源");break;case 405:Object(ke["a"])("请求方法未允许");break;case 408:Object(ke["a"])("请求超时");break;case 500:Object(ke["a"])("服务器端出错");break;case 501:Object(ke["a"])("网络未实现");break;case 502:Object(ke["a"])("网络错误");break;case 503:Object(ke["a"])("服务不可用");break;case 504:Object(ke["a"])("网络超时");break;case 505:Object(ke["a"])("http版本不支持该请求");break;default:Object(ke["a"])("连接错误".concat(e.response.status))}else Object(ke["a"])("连接服务器失败");return Promise.resolve(e.response)}));var Ne=Pe,Se={get:function(e,t,n){var r={};return t&&Object.assign(r,{params:t}),n&&Object.assign(r,n),Ne.get(e,r)},post:function(e,t,n){return Ne.post(e,t,n)},put:function(e,t,n){return Ne.put(e,t,n)},delete:function(e,t,n){var r={};return t&&Object.assign(r,{params:t}),n&&Object.assign(r,n),Ne["delete"](e,r)}},Be=Se,Ie=n("852e"),Ee=n.n(Ie);r["default"].prototype.$video=de["a"],r["default"].prototype.localhost="http://localhost:7001",r["default"].prototype.$http=Ce,r["default"].prototype.$http2=Be,r["default"].prototype.Cookies=Ee.a,r["default"].prototype.CookiesName="client1token",r["default"].prototype.adminPage="http://localhost:8087",r["default"].prototype.authrizationControl="http://localhost:8090/auth/admin/adminPage",r["default"].use(be["a"]),r["default"].use(i.a),r["default"].config.productionTip=!1,new r["default"]({router:ve,render:function(e){return e(p)}}).$mount("#app")},"57b5":function(e,t,n){},6644:function(e,t,n){},"70ad":function(e,t,n){e.exports=n.p+"img/home.b95d9e95.png"},"7c55":function(e,t,n){"use strict";n("2395")},"7cd9":function(e,t,n){},8743:function(e,t,n){e.exports=n.p+"img/search.c13fd303.png"},a1d8:function(e,t,n){e.exports=n.p+"img/logo.b9381a76.png"},a2f9:function(e,t,n){e.exports=n.p+"img/profile-pic.ea3d8551.png"},a338:function(e,t,n){"use strict";n("a3e2")},a3e2:function(e,t,n){},a51a:function(e,t,n){e.exports=n.p+"img/explore.c285db18.png"},ac90:function(e,t,n){"use strict";n("f7b5")},b273:function(e,t,n){"use strict";n("f529")},cc8e:function(e,t,n){"use strict";n("57b5")},dbc7:function(e,t,n){e.exports=n.p+"img/subscription.8655f45d.png"},e073:function(e,t,n){"use strict";n("eccc")},e350:function(e,t,n){e.exports=n.p+"img/video.f35999c8.png"},eccc:function(e,t,n){},f529:function(e,t,n){},f7b5:function(e,t,n){},fcab:function(e,t,n){e.exports=n.p+"img/bell.14805373.png"},fcbb:function(e,t,n){e.exports=n.p+"img/grid.8ead6386.png"}});
//# sourceMappingURL=app.3009483b.js.map