!function(e){function t(n){if(i[n])return i[n].exports;var o=i[n]={exports:{},id:n,loaded:!1};return e[n].call(o.exports,o,o.exports,t),o.loaded=!0,o.exports}var i={};t.m=e,t.c=i,t.p="",t(0)}({0:function(e,t,i){"use strict";function n(e){return e&&e.__esModule?e:{default:e}}var o=i(68),a=n(o),r=i(299),s=n(r),u=i(301),d=n(u),l=i(302),c=n(l),f=i(303),h=n(f);(0,a.default)(function(){(0,d.default)("oppoweb_index_close"),(0,s.default)(),(0,c.default)(),(0,h.default)()})},10:function(e,t,i){var n=i(11),o=i(12),a=i(13),r=i(15),s=i(25),u=function(e,t,i){var d,l,c,f=e&u.F,h=e&u.G,p=e&u.S,v=e&u.P,m=e&u.B,g=e&u.W,y=h?o:o[t]||(o[t]={}),w=y.prototype,b=h?n:p?n[t]:(n[t]||{}).prototype;h&&(i=t);for(d in i)(l=!f&&b&&void 0!==b[d])&&s(y,d)||(c=l?b[d]:i[d],y[d]=h&&"function"!=typeof b[d]?i[d]:m&&l?a(c,n):g&&b[d]==c?function(e){var t=function(t,i,n){if(this instanceof e){switch(arguments.length){case 0:return new e;case 1:return new e(t);case 2:return new e(t,i)}return new e(t,i,n)}return e.apply(this,arguments)};return t.prototype=e.prototype,t}(c):v&&"function"==typeof c?a(Function.call,c):c,v&&((y.virtual||(y.virtual={}))[d]=c,e&u.R&&w&&!w[d]&&r(w,d,c)))};u.F=1,u.G=2,u.S=4,u.P=8,u.B=16,u.W=32,u.U=64,u.R=128,e.exports=u},11:function(e,t){var i=e.exports="undefined"!=typeof window&&window.Math==Math?window:"undefined"!=typeof self&&self.Math==Math?self:Function("return this")();"number"==typeof __g&&(__g=i)},12:function(e,t){var i=e.exports={version:"2.6.5"};"number"==typeof __e&&(__e=i)},13:function(e,t,i){var n=i(14);e.exports=function(e,t,i){if(n(e),void 0===t)return e;switch(i){case 1:return function(i){return e.call(t,i)};case 2:return function(i,n){return e.call(t,i,n)};case 3:return function(i,n,o){return e.call(t,i,n,o)}}return function(){return e.apply(t,arguments)}}},14:function(e,t){e.exports=function(e){if("function"!=typeof e)throw TypeError(e+" is not a function!");return e}},15:function(e,t,i){var n=i(16),o=i(24);e.exports=i(20)?function(e,t,i){return n.f(e,t,o(1,i))}:function(e,t,i){return e[t]=i,e}},16:function(e,t,i){var n=i(17),o=i(19),a=i(23),r=Object.defineProperty;t.f=i(20)?Object.defineProperty:function(e,t,i){if(n(e),t=a(t,!0),n(i),o)try{return r(e,t,i)}catch(e){}if("get"in i||"set"in i)throw TypeError("Accessors not supported!");return"value"in i&&(e[t]=i.value),e}},17:function(e,t,i){var n=i(18);e.exports=function(e){if(!n(e))throw TypeError(e+" is not an object!");return e}},18:function(e,t){e.exports=function(e){return"object"==typeof e?null!==e:"function"==typeof e}},19:function(e,t,i){e.exports=!i(20)&&!i(21)(function(){return 7!=Object.defineProperty(i(22)("div"),"a",{get:function(){return 7}}).a})},20:function(e,t,i){e.exports=!i(21)(function(){return 7!=Object.defineProperty({},"a",{get:function(){return 7}}).a})},21:function(e,t){e.exports=function(e){try{return!!e()}catch(e){return!0}}},22:function(e,t,i){var n=i(18),o=i(11).document,a=n(o)&&n(o.createElement);e.exports=function(e){return a?o.createElement(e):{}}},23:function(e,t,i){var n=i(18);e.exports=function(e,t){if(!n(e))return e;var i,o;if(t&&"function"==typeof(i=e.toString)&&!n(o=i.call(e)))return o;if("function"==typeof(i=e.valueOf)&&!n(o=i.call(e)))return o;if(!t&&"function"==typeof(i=e.toString)&&!n(o=i.call(e)))return o;throw TypeError("Can't convert object to primitive value")}},24:function(e,t){e.exports=function(e,t){return{enumerable:!(1&e),configurable:!(2&e),writable:!(4&e),value:t}}},25:function(e,t){var i={}.hasOwnProperty;e.exports=function(e,t){return i.call(e,t)}},68:function(e,t,i){!function(t,i){e.exports=i()}(0,function(){var e,t=[],i=document,n=i.documentElement.doScroll,o=(n?/^loaded|^c/:/^loaded|^i|^c/).test(i.readyState);return o||i.addEventListener("DOMContentLoaded",e=function(){for(i.removeEventListener("DOMContentLoaded",e),o=1;e=t.shift();)e()}),function(e){o?setTimeout(e,0):t.push(e)}})},103:function(e,t,i){e.exports={default:i(104),__esModule:!0}},104:function(e,t,i){i(105);var n=i(12).Object;e.exports=function(e,t,i){return n.defineProperty(e,t,i)}},105:function(e,t,i){var n=i(10);n(n.S+n.F*!i(20),"Object",{defineProperty:i(16).f})},110:function(e,t){"use strict";e.exports=function(){return{platform:function(){return Modernizr.mobile||!1},screen:function(){return Modernizr.mq("(max-width: 768px)")},touch:function(){return Modernizr.touchevents||!1}}}},112:function(e,t){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default=function(e){var t="string"==typeof e?$(e):e;return!!(t&&t.length>0)}},113:function(e,t,i){"use strict";var n=i(112),o=function(e){return e&&e.__esModule?e:{default:e}}(n),a=void 0;e.exports=function(e,t){var i=$(document),n=$(window),r=$("html"),s=t||"oc-noscroll",u=$("#oc-wrapper"),d=e?n.scrollTop():a,l=i.height();e?(r.addClass(s),(0,o.default)(u)&&u.css({height:l,marginTop:-d}),n.scrollTop(0)):(r.removeClass(s),(0,o.default)(u)&&u.css({height:"",marginTop:""}),n.scrollTop(d)),e&&(a=d)}},116:function(e,t){"use strict";t.__esModule=!0,t.default=function(e,t){if(!(e instanceof t))throw new TypeError("Cannot call a class as a function")}},117:function(e,t,i){"use strict";t.__esModule=!0;var n=i(103),o=function(e){return e&&e.__esModule?e:{default:e}}(n);t.default=function(){function e(e,t){for(var i=0;i<t.length;i++){var n=t[i];n.enumerable=n.enumerable||!1,n.configurable=!0,"value"in n&&(n.writable=!0),(0,o.default)(e,n.key,n)}}return function(t,i,n){return i&&e(t.prototype,i),n&&e(t,n),t}}()},120:function(e,t){"use strict";"undefined"==typeof OPPO_MODULE_FN&&(window.OPPO_MODULE_FN={}),"undefined"==typeof OPPO_CONFIG_ATTR&&(window.OPPO_CONFIG_ATTR={})},121:function(e,t,i){"use strict";function n(e){return e&&e.__esModule?e:{default:e}}Object.defineProperty(t,"__esModule",{value:!0});var o=i(116),a=n(o),r=i(117),s=n(r),u={regClassCache:{},hasClass:function(e,t){return u.regClassCache[t]||(u.regClassCache[t]=new RegExp("(\\s|^)"+t+"(\\s|$)")),u.regClassCache[t].test(e.getAttribute("class")||"")&&u.regClassCache[t]},addClass:function(e,t){u.hasClass(e,t)||e.setAttribute("class",(e.getAttribute("class")||"").trim()+" "+t)},removeClass:function(e,t){var i;(i=u.hasClass(e,t))&&e.setAttribute("class",(e.getAttribute("class")||"").replace(i," "))}},d=function(){function e(t,i){return(0,a.default)(this,e),this.videoNode=document.getElementById(t),this.iscanplay=!1,this.isplaying=!1,this.cb=null,this.getUpdate=null,this.parent=this.videoNode.parentNode,i&&(i.loop&&(this.loop=i.loop||!1),i.unmuted&&(this.unmuted=i.unmuted||!1),i.url&&(this.url=i.url||!1),this.unmuted&&this.videoNode.setAttribute("muted",!1),this.loop&&this.videoNode.setAttribute("loop",!0)),this.onEnd=this.onEnd.bind(this),this.onPlay=this.onPlay.bind(this),this.play=this.play.bind(this),this.pause=this.pause.bind(this),this.onTimeupdate=this.onTimeupdate.bind(this),this.videoNode&&(this.videoNode.setAttribute("playsinline","true"),this.videoNode.setAttribute("webkit-playsinline","true"),this.onComplete=this.onComplete.bind(this),this.onMetaData=this.onMetaData.bind(this),this.videoNode.addEventListener("loadmetadata",this.onMetaDta),this.onProgress=this.onProgress.bind(this),this.videoNode.addEventListener("progress",this.onProgress)),this}return(0,s.default)(e,[{key:"execute",value:function(){this.url&&(this.videoNode.src=this.url),this.videoNode.addEventListener("canplaythrough",this.onComplete),this.videoNode.addEventListener("ended",this.onEnd),this.videoNode.addEventListener("play",this.onPlay),this.videoNode.addEventListener("timeupdate",this.onTimeupdate),this.videoNode.load()}},{key:"onProgress",value:function(e){if(!0===this.videoNode.buffered.length){var t=this.videoNode.buffered.end(0);e&&"function"==typeof e&&e(t/this.videoNode.duration*100)}}},{key:"onComplete",value:function(){!u.hasClass(this.videoNode,"loaded")&&u.addClass(this.videoNode,"loaded"),this.videoNode.removeEventListener("canplaythrough",this.onComplete),this.iscanplay=!0}},{key:"onEnd",value:function(){u.hasClass(this.parent,"active")&&u.removeClass(this.parent,"active"),this.cb&&"function"==typeof this.cb&&this.cb()}},{key:"onTimeupdate",value:function(){var e={currenttime:this.videoNode.currentTime,duration:this.videoNode.duration};this.getUpdate&&"function"==typeof this.getUpdate&&this.getUpdate(e)}},{key:"onPlay",value:function(){!u.hasClass(this.parent,"active")&&u.addClass(this.parent,"active")}},{key:"play",value:function(e){var t=this;this.currenttime=null,this.cb=null;try{this.videoNode&&(this.videoNode.currentTime=0)}catch(e){}if(!u.hasClass(this.videoNode,"play")&&u.addClass(this.videoNode,"play"),this.videoNode){var i=this.videoNode.play();void 0!==i&&i.catch(function(){t.videoNode.play()}),this.isplaying=!0}e&&"function"==typeof e&&(this.cb=e)}},{key:"pause",value:function(e){this.cb=null,u.hasClass(this.videoNode,"play")&&u.removeClass(this.videoNode,"play"),this.videoNode&&this.videoNode.pause(),this.currenttime=this.videoNode.currentTime,this.isplaying=!1,e&&"function"==typeof e&&(this.cb=e)}},{key:"stop",value:function(e){this.videoNode&&this.videoNode.pause(),this.videoNode.currentTime=0,this.isplaying=!1}},{key:"resume",value:function(e){this.cb=null,u.hasClass(this.videoNode,"play")&&u.removeClass(this.videoNode,"play"),this.videoNode&&this.videoNode.play(),this.currenttime&&(this.videoNode.currentTime=this.currenttime),this.isplaying=!0,this.currenttime=null,e&&"function"==typeof e&&(this.cb=e)}},{key:"setAttribute",value:function(e){for(var t in e)this.videoNode.setAttribute(t.toString(),e[t].toString())}},{key:"setUpdate",value:function(e){}},{key:"onMetaData",value:function(){}},{key:"revert",value:function(){}},{key:"destroy",value:function(){}}]),e}();t.default=d},281:function(e,t,i){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var n=i(113),o=function(e){return e&&e.__esModule?e:{default:e}}(n),a={install:function(){var e=$("[data-video-model]");$.each(e,function(e,t){function i(e){(0,o.default)(!0);var t='<video src="'+r+'" autobuffer autoloop loop autoplay="autoplay" width="100%" controls="controls" class="video-content" webkit-playsinline playsinline x5-playsinline x-webkit-airplay="allow">';f.html(t),s&&h.removeClass("hide").attr("href",s).text(u),c.attr("data-video-orientation",d),TweenMax.to(c,.5,{height:"100%",autoAlpha:1,ease:Ease.easeInOut,onComplete:function(){c.find("video")[0].play()}})}function n(e){e.preventDefault(),(0,o.default)(!1),TweenMax.to(c,.5,{height:0,autoAlpha:1,ease:Ease.easeInOut,onComplete:function(){c.data("video-orientation","horizonal"),c.find("video")[0].pause(),f.html(""),h.addClass("hide")}})}var a=$(t),r=(a[0],a.data("video-url")),s=a.data("video-link"),u=a.data("video-link-text"),d=a.data("video-orientation"),l=a.data("video-model"),c=$("[data-model='"+l+"']"),f=c.find(".video-content"),h=c.find(".oc-video-model-link"),p=c.find(".close-btn");a.on("click.openModel",i),p.on("click.closeModel",n)})}};t.default={install:a.install}},299:function(e,t,i){"use strict";function n(e){return e&&e.__esModule?e:{default:e}}Object.defineProperty(t,"__esModule",{value:!0});var o=i(110),a=n(o),r=i(112),s=n(r);i(120);var u=i(121),d=n(u),l=i(300),c=n(l);t.default=function(){var e={},t=void 0,i=["white","black"],n=function(){var i=e,n=i.pc,a=i.mobile,u=i.$high,d=i.$highItem;e.winHeight=$(window).height(),e.winWidth=$(window).width(),(0,s.default)(d)&&v(d.first().data("theme")),t.platform()?(e.ismobile=!0,p(!0),void 0===a&&(l(),e.mobile=!0,u.css({height:e.winHeight})),o()):(e.ismobile=!1,p(!1),void 0===n&&(r(),e.pc=!0,u.css({height:""})))},o=function(){(0,c.default)()},r=function(){void 0===e.curItem&&(e.curItem=0);var t=e,i=t.$highItem,n=t.$paginationWrap,o=(t.curItem,""),a=i.length;i.each(function(e,t){var i=$(t);0===e&&(i.addClass("jumpin"),h(i),i[0].videoHandle&&i[0].videoHandle.play()),o+='<li class="pagination-item">\n                \t\t\t\t\t<a href="#'+e+'">\n                \t\t\t\t\t<b></b>\n                \t\t\t\t\t<i>\n\t\t\t\t\t\t\t\t\t\t<svg version="1.1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 14 14"preserveAspectRatio="none"><circle cx="7" cy="7" r="6"/></svg>\n                \t\t\t\t\t</i>\n                \t\t\t\t\t</a>\n            \t\t\t\t\t</li>'}),a>1&&(n.html(o),u());var r=!1;a>1&&document.addEventListener("lazybeforeunveil",function(e){$(e.target).hasClass("lazypreload")&&!r&&(r=!0,setTimeout(function(e){return i.first().siblings().find(".lazyload").addClass("lazypreload")}))})},u=function(){function t(){c=!0,r=r>=o.length-1?0:++r,u.eq(r).trigger("click.pagin")}function i(i){if(i.preventDefault(),!$(this).hasClass("active")&&e.iscanplay){clearTimeout(d),clearTimeout(l),e.iscanplay=!1,$(this).addClass("active").siblings().removeClass("active"),r=$(this).index();var n=o.eq(r),a=n.find("._title"),u=n.find("._figure"),h=o.eq(s),p=h.find("._title"),m=h.find("._figure"),g=n.data("theme")||"white",y=n.data("delay")||e.delayTime;f({curItem:r,oldItem:s,$cur:n,$cur_title:a,$cur_figure:u,$old:h,$old_title:p,$old_figure:m,isClickEvent:c}),d=setTimeout(function(e){v(g)},500),setTimeout(function(t){return e.iscanplay=!0},500),c=!1,s=r,clearTimeout(l),l=setTimeout(t,y)}}void 0===e.curItem&&(e.curItem=0),void 0===e.iscanplay&&(e.iscanplay=!0);var n=e,o=n.$highItem,a=n.$paginationWrap,r=n.curItem,s=0,u=a.find("li"),d=null,l=null,c=!1;u.on("click.pagin",i),setTimeout(function(e){return u.eq(r).trigger("click.pagin")},v(o.eq(r).data("theme")))},l=function(){var t=e,i=t.$highItem,n=t.$paginationWrap,o=t.curItem,a=0,r=!1,s=[];if(i.each(function(){s.push($(this))}),!(s.length<=1)){new Swiper(".high-swiper-container",{speed:600,pagination:".high-swiper-pagination",paginationClickable:!0,loop:!0,autoplay:e.delayTime,autoplayDisableOnInteraction:!1,onSlideChangeStart:function(e){o=e.realIndex,v(i.eq(o).data("theme")),n.find(".pagination-item").eq(o).addClass("active").siblings().removeClass("active");var t=$(".high-swiper-container").find(".swiper-slide-active"),s=t.find("._title"),u=t.find("._figure"),d=$(".high-swiper-container").find(".swiper-slide-prev"),l=d.find("._title"),c=d.find("._figure");[s,u,l,c].forEach(function(e){return e.removeAttr("style")}),!r&&o!=a&&f({curItem:o,oldItem:a,$cur:t,$cur_title:s,$cur_figure:u,$old:d,$old_title:l,$old_figure:c,isClickEvent:!1}),r=!1,a=o},onSliderMove:function(e,t){r=!0},paginationBulletRender:function(e,t,i){return'<li class="pagination-item">\n                \t\t<a href="#'+t+'">\n\t                \t\t<b></b>\n\t                \t\t<i>\n\t                \t\t<svg version="1.1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 14 14"preserveAspectRatio="none"><circle cx="7" cy="7" r="6"/></svg>\n\t                \t\t</i>\n                \t\t</a>\n                \t\t</li>'},onAutoplayStart:function(e){setTimeout(function(t){return n.find(".pagination-item").eq(e.realIndex).addClass("active")},100)},onAfterResize:function(e){setTimeout(function(t){return n.find(".pagination-item").eq(e.realIndex).addClass("active")})}});n.find(".pagination-item").on("click.stop",function(e){return e.preventDefault()})}},f=function(t){var i=e,n=i.easeingIn,o=t.curItem,a=t.oldItem,r=t.$cur,s=t.$cur_title,u=t.$cur_figure,d=t.$old,l=t.$old_title,c=t.$old_figure,f=t.isClickEvent;o>a||f||e.ismobile?(TweenMax.set(s,{x:500,autoAlpha:0}),TweenMax.set(u,{x:50,scale:.7,transformOrigin:"250% 100%"}),TweenMax.set(l,{x:0}),TweenMax.set(c,{x:0,transformOrigin:"-250% 100%"}),!e.ismobile&&TweenMax.set(r,{x:e.winWidth,display:"block",zIndex:9}),!e.ismobile&&TweenMax.set(d,{x:0,zIndex:1}),h(r),setTimeout(function(t){r[0].videoHandle&&r[0].videoHandle.play(),!e.ismobile&&TweenMax.to(r,1.2,{x:0,ease:n}),TweenMax.to(s,e.ismobile?1:.8,{x:0,autoAlpha:1,delay:(e.ismobile,.5),ease:Cubic.easeOut,onComplete:function(){s.removeAttr("style")}}),TweenMax.to(u,e.ismobile?1:1.2,{x:0,scale:1,ease:n,onComplete:function(){u.removeAttr("style")}}),!e.ismobile&&TweenMax.to(d,e.ismobile?.8:1.2,{x:-e.winWidth/4,ease:n,onComplete:function(){d.hide(),l.removeAttr("style"),c.removeAttr("style"),d[0].videoHandle&&d[0].videoHandle.pause()}}),TweenMax.to(l,1,{x:-500,delay:.3,ease:Cubic.easeOut}),TweenMax.to(c,1.3,{x:-50,scale:.8,ease:n})},10)):o<a&&(TweenMax.set(s,{x:-500,autoAlpha:0}),TweenMax.set(u,{x:-50,scale:.8,transformOrigin:"-250% 100%"}),TweenMax.set(l,{x:0}),TweenMax.set(c,{x:0,transformOrigin:"250% 100%"}),!e.ismobile&&TweenMax.set(r,{x:-e.winWidth,display:"block",zIndex:9}),!e.ismobile&&TweenMax.set(d,{x:0,zIndex:1}),h(r),setTimeout(function(t){r[0].videoHandle&&r[0].videoHandle.play(),!e.ismobile&&TweenMax.to(r,1.2,{x:0,ease:n}),TweenMax.to(s,.8,{x:0,autoAlpha:1,delay:.8,ease:Cubic.easeOut,onComplete:function(){s.removeAttr("style")}}),TweenMax.to(u,1.2,{x:0,scale:1,ease:n,onComplete:function(){u.removeAttr("style")}}),!e.ismobile&&TweenMax.to(d,1.2,{x:e.winWidth/4,ease:n,onComplete:function(){d.hide(),c.removeAttr("style"),c.removeAttr("style"),d[0].videoHandle&&d[0].videoHandle.pause()}}),TweenMax.to(l,1,{x:500,delay:.3,ease:Cubic.easeOut}),TweenMax.to(c,1.3,{x:50,scale:.8,ease:n})},10))},h=function(t){if(!e.ismobile&&Modernizr.video&&void 0!==t.data("video")&&""!=t.data("video")&&void 0===t[0].videoHandle){var i=t.data("video").split(","),n="banner-item-video"+(t.index()+1),o='<div class="banner-video"><video id="'+n+'" autoplay="true" preload="auto" muted="true">';i.forEach(function(e){var t="mp4";e.indexOf("webm")>-1&&(t="webm"),e.indexOf("ogg")>-1&&(t="ogg"),o+='<source src="'+e+'" type="video/'+t+'">'}),o+="</video></div>",t.find(".banner-bg").append(o);var a=new d.default(n);a.execute(),t[0].videoHandle=a}},p=function(t){var i=e,n=(i.$high,i.$highWrap),o=i.$highList,a=i.$highItem,r=(i.$pagination,i.$paginationWrap);t?(n.addClass("high-swiper-container"),o.addClass("swiper-wrapper"),a.addClass("swiper-slide"),r.addClass("high-swiper-pagination")):(n.removeClass("high-swiper-container"),o.removeClass("swiper-wrapper"),a.removeClass("swiper-slide"),r.removeClass("high-swiper-pagination"))},v=function(t){var n=e,o=n.$high;return OPPO_MODULE_FN.common&&OPPO_MODULE_FN.common.changeNavTheme(t),o.hasClass("ohigh-theme-"+t)||o.addClass("ohigh-theme-"+t),i.forEach(function(e){e!==t&&o.removeClass("ohigh-theme-"+e)}),!0};return function(){t=(0,a.default)();var i=$(".oc-high"),o=i.find(".ohigh-wrapper"),r=i.find(".ohw-banner-list"),u=r.find(".banner-item"),d=i.find(".ohw-pagination"),l=d.find("ul");if(!(0,s.default)(i))return!1;var c=CustomEase.create("custom","M0,0 C0.303,0 0,1 1,1")||Cubic.easeInOut;e={delayTime:5e3,$high:i,$highWrap:o,$highList:r,$highItem:u,$pagination:d,$paginationWrap:l,easeingIn:c},n(),window.addEventListener("resize",n)}()}},300:function(e,t,i){"use strict";function n(){var e=$(".oc-high"),t=$(window).height(),i=$("#oc-header-guide"),n=OPPO_MODULE_FN.common.getQueryString("utm_source")||OPPO_MODULE_FN.common.getCookies("utm_source");!Modernizr.android||!Modernizr.mobile||/^baiduprogram/i.test(n)||/^alipayprogram/i.test(n)||/^zhifubao/i.test(n)||/^miniprogram/i.test(n)||/^iot/i.test(n)||/^abcbank/i.test(n)||/^abcwechat/i.test(n)||/^ccbbank/i.test(n)||Modernizr.oppostore||Modernizr.quickapp||Modernizr.aliapp||Modernizr.aliappmini||!(0,a.default)(i)||(!OPPO_MODULE_FN.common.getCookies("header_guide")&&i.removeClass("hide")&&e.css({height:t-50}),$(".header-guide-close").on("click",function(){i.hide(400),OPPO_MODULE_FN.common.setCookies("header_guide",1,2)}))}Object.defineProperty(t,"__esModule",{value:!0}),t.default=n;var o=i(112),a=function(e){return e&&e.__esModule?e:{default:e}}(o)},301:function(e,t){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default=function(e){return function(){if(OPPO_MODULE_FN.common)var t=$.ajax({url:OPPO_CONFIG_ATTR.base_url_v3+"/configs/web/switches/list?codes="+e,type:"GET",dataType:"json",timeout:OPPO_CONFIG_ATTR.timeout}).done(function(t){if(200==parseInt(t.code)&&t.data[0]){var i=t.data[0].remark||"",n=t.data[0].md5Str||"",o=OPPO_MODULE_FN.common.getCookies(e);OPPO_MODULE_FN.common.setCookies(e,n),i&&n&&n!=o&&(window.location.href=i+window.location.search)}}).fail(function(){}).always(function(e,i){"timeout"===i&&t.abort()})}()}},302:function(e,t,i){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var n=i(110),o=function(e){return e&&e.__esModule?e:{default:e}}(n);t.default=function(){return function(){var e=function(e){var t=$(window).height(),i=$(window).scrollTop(),n=$(e).offset().top,o=1-$(e).data("ratio");return n>i-t*o&&n<t*o+i},t=function(){(0,o.default)().screen()?$.each($(".visible-ready"),function(t,i){e($(i))&&$(i).addClass("visible-active").removeClass("visible-ready")}):$.each($(".promos-detail"),function(e,t){var i=$(t).find("video");i.length&&$(t).mouseenter(function(){i[0].play(),i.addClass("active")}).mouseleave(function(){i[0].currentTime=0,i[0].pause(),i.removeClass("active")})})};t(),$(window).scroll(function(){t()}),$(window).resize(function(){t()})}()}},303:function(e,t,i){"use strict";function n(e){return e&&e.__esModule?e:{default:e}}Object.defineProperty(t,"__esModule",{value:!0});var o=i(110),a=n(o),r=i(281),s=n(r);t.default=function(){var e={},t=function(t){var i=arguments.length>1&&void 0!==arguments[1]?arguments[1]:"runaway",n=arguments[2],o=$(document).scrollTop(),a=$(t).find(".fixed-wrapper"),r=$(t).find(".video-wrapper"),s=$(t).find(".scroll-content"),u=$(t).offset().top,d=s.offset().top+s.outerHeight()-window.innerHeight;"fade"===i&&(d+=300),o<u&&(e[t]||(a.hasClass("zoom-in")?(e[t]=!0,setTimeout(function(){e[t]&&a.addClass("normal"),e[t]=!1},500)):a.addClass("normal"),a.removeClass("zoom-in runaway").addClass("zoom-out"),s.removeClass("fade-in"),"fade"===i&&n.css("background-color","white"))),o>=u&&o<d&&(e[t]=!1,a.removeClass("runaway zoom-out normal").addClass("zoom-in"),s.addClass("fade-in"),"fade"===i&&r.hasClass("fade-out")&&r.removeClass("fade-out").addClass("fade-in")),o>d&&(a.removeClass("zoom-out normal"),"runaway"===i&&a.addClass("runaway"),"fade"===i&&(n.css("background-color","black"),r.removeClass("fade-in").addClass("fade-out")))};return function(){$(".home-reno").length&&((0,a.default)().screen()&&$(".reno-video").data("video-url","https://dsfs.oppo.com/hd/2019/Reno/images/tvc/tvc-30s-mobile-180b149238.mp4"),$("html.ie").length,s.default.install(),t("#home-reno-video"),$(window).scroll(function(){t("#home-reno-video")}))}()}}});