!function(t){function e(o){if(n[o])return n[o].exports;var i=n[o]={exports:{},id:o,loaded:!1};return t[o].call(i.exports,i,i.exports,e),i.loaded=!0,i.exports}var n={};e.m=t,e.c=n,e.p="",e(0)}({0:function(t,e,n){"use strict";function o(t){return t&&t.__esModule?t:{default:t}}var i=n(68),r=o(i),a=n(110),s=o(a);(0,r.default)(function(){if(!/quickapp/i.test(navigator.userAgent)&&/usercenter|oppocommunity|oppostore/i.test(navigator.userAgent)&&(RainbowBridge.callMethod("JSCommondMethod","setClientTitle",{title:"回收代金券",isNeedBackIcon:!0,nextText:""},function(t){}),RainbowBridge.callMethod("JSCommondMethod","onDomLoadFinish",{})),/oppostore/i.test(navigator.userAgent)?$(".go-shopping").click(function(){JSCallJava.analyzeInnerLink("www.opposhop.cn/app/store/index?tab1=0&tab2=0")}):$(".go-shopping a").attr("href",OPPO_CONFIG_ATTR.base_url),(0,s.default)().screen()){var t=function(t){t.preventDefault(),this.isopen?($(this).parent().removeClass("active"),this.isopen=!1):($(this).parent().addClass("active"),this.isopen=!0)};$(".data-table-item-main").each(function(e,n){$(this).on("click.open",t)})}})},68:function(t,e,n){!function(e,n){t.exports=n()}(0,function(){var t,e=[],n=document,o=n.documentElement.doScroll,i=(o?/^loaded|^c/:/^loaded|^i|^c/).test(n.readyState);return i||n.addEventListener("DOMContentLoaded",t=function(){for(n.removeEventListener("DOMContentLoaded",t),i=1;t=e.shift();)t()}),function(t){i?setTimeout(t,0):e.push(t)}})},110:function(t,e){"use strict";t.exports=function(){return{platform:function(){return Modernizr.mobile||!1},screen:function(){return Modernizr.mq("(max-width: 768px)")},touch:function(){return Modernizr.touchevents||!1}}}}});