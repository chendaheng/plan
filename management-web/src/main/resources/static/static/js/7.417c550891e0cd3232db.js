webpackJsonp([7],{153:function(e,t,a){function n(e){a(460)}var r=a(37)(a(306),a(534),n,"data-v-526481a4",null);e.exports=r.exports},206:function(e,t){"function"==typeof Object.create?e.exports=function(e,t){e.super_=t,e.prototype=Object.create(t.prototype,{constructor:{value:e,enumerable:!1,writable:!0,configurable:!0}})}:e.exports=function(e,t){e.super_=t;var a=function(){};a.prototype=t.prototype,e.prototype=new a,e.prototype.constructor=e}},207:function(e,t){e.exports=function(e){return e&&"object"==typeof e&&"function"==typeof e.copy&&"function"==typeof e.fill&&"function"==typeof e.readUInt8}},208:function(e,t,a){(function(e,n){function r(e,a){var n={seen:[],stylize:o};return arguments.length>=3&&(n.depth=arguments[2]),arguments.length>=4&&(n.colors=arguments[3]),h(a)?n.showHidden=a:a&&t._extend(n,a),A(n.showHidden)&&(n.showHidden=!1),A(n.depth)&&(n.depth=2),A(n.colors)&&(n.colors=!1),A(n.customInspect)&&(n.customInspect=!0),n.colors&&(n.stylize=i),l(n,e,n.depth)}function i(e,t){var a=r.styles[t];return a?"["+r.colors[a][0]+"m"+e+"["+r.colors[a][1]+"m":e}function o(e,t){return e}function s(e){var t={};return e.forEach(function(e,a){t[e]=!0}),t}function l(e,a,n){if(e.customInspect&&a&&D(a.inspect)&&a.inspect!==t.inspect&&(!a.constructor||a.constructor.prototype!==a)){var r=a.inspect(n,e);return x(r)||(r=l(e,r,n)),r}var i=c(e,a);if(i)return i;var o=Object.keys(a),h=s(o);if(e.showHidden&&(o=Object.getOwnPropertyNames(a)),S(a)&&(o.indexOf("message")>=0||o.indexOf("description")>=0))return p(a);if(0===o.length){if(D(a)){var f=a.name?": "+a.name:"";return e.stylize("[Function"+f+"]","special")}if(O(a))return e.stylize(RegExp.prototype.toString.call(a),"regexp");if(P(a))return e.stylize(Date.prototype.toString.call(a),"date");if(S(a))return p(a)}var b="",v=!1,y=["{","}"];if(m(a)&&(v=!0,y=["[","]"]),D(a)){b=" [Function"+(a.name?": "+a.name:"")+"]"}if(O(a)&&(b=" "+RegExp.prototype.toString.call(a)),P(a)&&(b=" "+Date.prototype.toUTCString.call(a)),S(a)&&(b=" "+p(a)),0===o.length&&(!v||0==a.length))return y[0]+b+y[1];if(n<0)return O(a)?e.stylize(RegExp.prototype.toString.call(a),"regexp"):e.stylize("[Object]","special");e.seen.push(a);var A;return A=v?u(e,a,n,h,o):o.map(function(t){return g(e,a,n,h,t,v)}),e.seen.pop(),d(A,b,y)}function c(e,t){if(A(t))return e.stylize("undefined","undefined");if(x(t)){var a="'"+JSON.stringify(t).replace(/^"|"$/g,"").replace(/'/g,"\\'").replace(/\\"/g,'"')+"'";return e.stylize(a,"string")}return v(t)?e.stylize(""+t,"number"):h(t)?e.stylize(""+t,"boolean"):f(t)?e.stylize("null","null"):void 0}function p(e){return"["+Error.prototype.toString.call(e)+"]"}function u(e,t,a,n,r){for(var i=[],o=0,s=t.length;o<s;++o)B(t,String(o))?i.push(g(e,t,a,n,String(o),!0)):i.push("");return r.forEach(function(r){r.match(/^\d+$/)||i.push(g(e,t,a,n,r,!0))}),i}function g(e,t,a,n,r,i){var o,s,c;if(c=Object.getOwnPropertyDescriptor(t,r)||{value:t[r]},c.get?s=c.set?e.stylize("[Getter/Setter]","special"):e.stylize("[Getter]","special"):c.set&&(s=e.stylize("[Setter]","special")),B(n,r)||(o="["+r+"]"),s||(e.seen.indexOf(c.value)<0?(s=f(a)?l(e,c.value,null):l(e,c.value,a-1),s.indexOf("\n")>-1&&(s=i?s.split("\n").map(function(e){return"  "+e}).join("\n").substr(2):"\n"+s.split("\n").map(function(e){return"   "+e}).join("\n"))):s=e.stylize("[Circular]","special")),A(o)){if(i&&r.match(/^\d+$/))return s;o=JSON.stringify(""+r),o.match(/^"([a-zA-Z_][a-zA-Z_0-9]*)"$/)?(o=o.substr(1,o.length-2),o=e.stylize(o,"name")):(o=o.replace(/'/g,"\\'").replace(/\\"/g,'"').replace(/(^"|"$)/g,"'"),o=e.stylize(o,"string"))}return o+": "+s}function d(e,t,a){var n=0;return e.reduce(function(e,t){return n++,t.indexOf("\n")>=0&&n++,e+t.replace(/\u001b\[\d\d?m/g,"").length+1},0)>60?a[0]+(""===t?"":t+"\n ")+" "+e.join(",\n  ")+" "+a[1]:a[0]+t+" "+e.join(", ")+" "+a[1]}function m(e){return Array.isArray(e)}function h(e){return"boolean"==typeof e}function f(e){return null===e}function b(e){return null==e}function v(e){return"number"==typeof e}function x(e){return"string"==typeof e}function y(e){return"symbol"==typeof e}function A(e){return void 0===e}function O(e){return w(e)&&"[object RegExp]"===N(e)}function w(e){return"object"==typeof e&&null!==e}function P(e){return w(e)&&"[object Date]"===N(e)}function S(e){return w(e)&&("[object Error]"===N(e)||e instanceof Error)}function D(e){return"function"==typeof e}function _(e){return null===e||"boolean"==typeof e||"number"==typeof e||"string"==typeof e||"symbol"==typeof e||void 0===e}function N(e){return Object.prototype.toString.call(e)}function C(e){return e<10?"0"+e.toString(10):e.toString(10)}function $(){var e=new Date,t=[C(e.getHours()),C(e.getMinutes()),C(e.getSeconds())].join(":");return[e.getDate(),E[e.getMonth()],t].join(" ")}function B(e,t){return Object.prototype.hasOwnProperty.call(e,t)}var z=/%[sdj%]/g;t.format=function(e){if(!x(e)){for(var t=[],a=0;a<arguments.length;a++)t.push(r(arguments[a]));return t.join(" ")}for(var a=1,n=arguments,i=n.length,o=String(e).replace(z,function(e){if("%%"===e)return"%";if(a>=i)return e;switch(e){case"%s":return String(n[a++]);case"%d":return Number(n[a++]);case"%j":try{return JSON.stringify(n[a++])}catch(e){return"[Circular]"}default:return e}}),s=n[a];a<i;s=n[++a])f(s)||!w(s)?o+=" "+s:o+=" "+r(s);return o},t.deprecate=function(a,r){function i(){if(!o){if(n.throwDeprecation)throw new Error(r);n.traceDeprecation?console.trace(r):console.error(r),o=!0}return a.apply(this,arguments)}if(A(e.process))return function(){return t.deprecate(a,r).apply(this,arguments)};if(!0===n.noDeprecation)return a;var o=!1;return i};var k,M={};t.debuglog=function(e){if(A(k)&&(k=a.i({NODE_ENV:"production"}).NODE_DEBUG||""),e=e.toUpperCase(),!M[e])if(new RegExp("\\b"+e+"\\b","i").test(k)){var r=n.pid;M[e]=function(){var a=t.format.apply(t,arguments);console.error("%s %d: %s",e,r,a)}}else M[e]=function(){};return M[e]},t.inspect=r,r.colors={bold:[1,22],italic:[3,23],underline:[4,24],inverse:[7,27],white:[37,39],grey:[90,39],black:[30,39],blue:[34,39],cyan:[36,39],green:[32,39],magenta:[35,39],red:[31,39],yellow:[33,39]},r.styles={special:"cyan",number:"yellow",boolean:"yellow",undefined:"grey",null:"bold",string:"green",date:"magenta",regexp:"red"},t.isArray=m,t.isBoolean=h,t.isNull=f,t.isNullOrUndefined=b,t.isNumber=v,t.isString=x,t.isSymbol=y,t.isUndefined=A,t.isRegExp=O,t.isObject=w,t.isDate=P,t.isError=S,t.isFunction=D,t.isPrimitive=_,t.isBuffer=a(207);var E=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];t.log=function(){console.log("%s - %s",$(),t.format.apply(t,arguments))},t.inherits=a(206),t._extend=function(e,t){if(!t||!w(t))return e;for(var a=Object.keys(t),n=a.length;n--;)e[a[n]]=t[a[n]];return e}}).call(t,a(6),a(18))},306:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var n=a(208);a.n(n);t.default={data:function(){return{tableDataA:[],isSelfMadePlan:!1,searchOptions:{searchParams:{customerName:"",brandName:"",clothingLevel:"",rangeName:"",name:"",dateRange:""},options:{customerNameOptions:[],brandNameOptions:[],clothingLevelOptions:[],rangeNameOptions:[],planNameOptions:[]}},tableData:[],pagination:{currentPage:1,pageSizes:[5,10,20,30,50],pageSize:5,total:400},selectedData:[]}},created:function(){var e=this,t=this;console.log("进入计划管理页面"),this.$axios.get(window.$config.HOST+"/baseInfoManagement/getCustomerName").then(function(t){e.searchOptions.options.customerNameOptions=t.data}).catch(function(e){console.log("初始化客户选项错误!")}),t.$axios.get(window.$config.HOST+"/baseInfoManagement/getClothingLevelName").then(function(t){e.searchOptions.options.clothingLevelOptions=t.data}).catch(function(e){console.log("初始化服装层次加载错误")}),this.$axios.get(window.$config.HOST+"/baseInfoManagement/getBrandName",{params:{customerId:""}}).then(function(t){e.searchOptions.options.brandNameOptions=t.data}).catch(function(e){console.log("初始化品牌名称选择错误")}),this.$axios.get(window.$config.HOST+"/infoManagement/getRangeName",{params:{brandId:""}}).then(function(t){e.searchOptions.options.rangeNameOptions=t.data}).catch(function(e){console.log("初始化系列名称加载错误")});this.$axios.get(window.$config.HOST+"/planManagement/getDistributedPlanList").then(function(t){e.tableData=t.data,e.pagination.total=t.data.length;var a=(e.pagination.currentPage-1)*e.pagination.pageSize,n=(e.pagination.currentPage-1)*e.pagination.pageSize;for(e.tableDataA=[];a-n<e.pagination.pageSize&&a<e.tableData.length;a++)e.tableDataA.push(e.tableData[a]);e.searchOptions.options.planNameOptions=t.data}).catch(function(e){console.log("初始化被下发计划列表获取错误")})},methods:{ToSearchException:function(e){console.log("查看异常"+e.id),this.$router.push({name:"exceptionManagement",params:{planId:e.id,customerId:e.customerId,customerName:e.customerName,brandId:e.brandId,brandName:e.brandName,rangeId:e.rangeId,rangeName:e.rangeName}})},handleSizeChange:function(e){this.pagination.pageSize=e,console.log("每页+"+this.pagination.pageSize),this.handleSearch()},handleCurrentChange:function(e){this.pagination.currentPage=e,this.handleSearch()},addPlanChild:function(){var e=this;if(1===e.selectedData.length){var t=e.selectedData[0];e.$router.push({name:"planMakeIndex",params:{client:t.customerName,brand:t.brandName,series:t.rangeName,plantype:2,planobj:t.rangeName}})}else 0===e.selectedData.length?e.$message.error("请选择要添加子计划的计划！"):e.$message.error("仅允许对一条计划添加子计划，请重新选择！")},deletePlan:function(){var e=this,t=this;0===t.selectedData.length?t.$message.error("请选择要删除的计划！"):this.selectedData.forEach(function(t){console.log(t.id),e.$axios.delete(window.$config.HOST+"/planManagement/deletePlan",{params:{id:t.id}}).then(function(a){a.data<0?e.$message.error(t.id+"删除失败!"):(e.$message({type:"success",message:t.id+"删除成功!"}),e.handleSearch())}).catch(function(a){e.$message.error(t.id+"删除失败!")})})},commitPlan:function(){var e=this;0===that.selectedData.length?that.$message.error("请选择要提交的计划！"):this.selectedData.forEach(function(t){console.log(t.id),e.$axios.get(window.$config.HOST+"/planManagement/submitPlan",{params:{id:t.id}}).then(function(a){a.data<0?(console.log(t.id+"提交失败!"),e.$message.error(t.id+"提交失败!")):(e.$message({type:"success",message:t.id+"提交成功!"}),e.handleSearch())}).catch(function(a){console.log(t.id+"提交失败!"),e.$message.error(t.id+"提交失败!")})})},changeOrder:function(){this.$message("此功能对应页面暂时缺失")},addException:function(){var e=this;0===e.selectedData.length?e.$message.error("请选择要添加异常的计划！"):e.$prompt("请输入计划出现的异常","异常信息添加",{confirmButtonText:"确定",cancelButttonText:"取消",inputPattern:/\S/,inputErrorMessage:"异常内容不得为空"}).then(function(t){var a=t.value;console.log(a),e.selectedData.forEach(function(t){var n={planId:t.id,cause:""===a?"":a};e.$axios.post(window.$config.HOST+"/planManagement/addException",n).then(function(a){a.data<0?e.$message.error(t.name+"添加异常失败"):e.$message({type:"success",message:t.name+"异常添加成功"})}).catch(function(a){e.$message.error(t.name+"添加异常失败")})})})},changeCheckBoxFun:function(e){this.selectedData=e},getPlanDetail:function(e){var t;t=this.isSelfMadePlan?{flag:1,goback:"planManagement",client:e.customerName,brand:e.brandName,series:e.rangeName,id:e.id,plantype:e.type,planobj:e.planObject,TopPlan:e.parentId,TopPlanName:e.parentName?e.parentName:"根计划",planName:e.name,projectType:e.projectType,number:e.number,dataStart:e.startDate,dataEnd:e.endDate,productDate:e.productDate,productDateType:e.productDateType,productId:e.productId,proposal:e.proposal,note:e.note,description:e.description}:{flag:0,goback:"planManagement",client:e.customerName,brand:e.brandName,series:e.rangeName,id:e.id,plantype:e.type,planobj:e.planObject,TopPlan:e.parentId,TopPlanName:e.parentName?e.parentName:"根计划",planName:e.name,projectType:e.projectType,number:e.number,dataStart:e.startDate,dataEnd:e.endDate,productDate:e.productDate,productDateType:e.productDateType,productId:e.productId,proposal:e.proposal,note:e.note,description:e.description},console.log(e),console.log(t),this.$router.push({name:"planMakeIndex",params:t})},ModifyPlanDetail:function(e){this.$router.push({name:"planMakeIndex",params:{goback:"planManagement",flag:5,client:e.customerName,brand:e.brandName,series:e.rangeName,plantype:2,planobj:e.rangeName}})},deleteOnePlan:function(e){var t=this;console.log("删除 "+e),this.$axios.post(window.$config.HOST+"/planManagement/deletePlan",{params:{id:e}}).then(function(a){if(a.data<0)return void t.$message.error(e+"删除失败");t.handleSearch(),t.$message({type:"success",message:e+"删除成功"})}).catch(function(a){t.$message.error(e+"删除失败")})},changeDate:function(e){if(e){var t=e.getFullYear(),a=e.getMonth()+1;a=a<10?"0"+a:a;var n=e.getDate();return n=n<10?"0"+n:n,t+"-"+a+"-"+n}},handleSearch:function(){var e=this,t={customerId:""===this.searchOptions.searchParams.customerName?void 0:this.searchOptions.searchParams.customerName,brandId:""===this.searchOptions.searchParams.brandName?void 0:this.searchOptions.searchParams.brandName,rangeId:""===this.searchOptions.searchParams.rangeName?void 0:this.searchOptions.searchParams.rangeName,name:""===this.searchOptions.searchParams.name?void 0:this.searchOptions.searchParams.name,clothingLevelId:""===this.searchOptions.searchParams.name?void 0:this.searchOptions.searchParams.name,startDate:this.changeDate(this.searchOptions.searchParams.dateRange[0]),endDate:this.changeDate(this.searchOptions.searchParams.dateRange[1])};this.isSelfMadePlan?(t.stage="manage",console.log(t),this.$axios.get(window.$config.HOST+"/planManagement/getPlanList",{params:t}).then(function(t){e.tableData=t.data,e.pagination.total=t.data.length;var a=(e.pagination.currentPage-1)*e.pagination.pageSize,n=(e.pagination.currentPage-1)*e.pagination.pageSize;for(e.tableDataA=[];a-n<e.pagination.pageSize&&a<e.tableData.length;a++)e.tableDataA.push(e.tableData[a])}).catch(function(t){e.$message.error("搜索失败!")})):(console.log(t),this.$axios.get(window.$config.HOST+"/planManagement/getDistributedPlanList",{params:t}).then(function(t){e.tableData=t.data,e.pagination.total=t.data.length;var a=(e.pagination.currentPage-1)*e.pagination.pageSize,n=(e.pagination.currentPage-1)*e.pagination.pageSize;for(e.tableDataA=[];a-n<e.pagination.pageSize&&a<e.tableData.length;a++)e.tableDataA.push(e.tableData[a])}).catch(function(t){e.$message.error("搜索失败!")}))},planTypeSwitchChange:function(){var e=this;this.pagination.currentPage=1,this.tableData=[],this.isSelfMadePlan?this.$axios.get(window.$config.HOST+"/planManagement/getPlanList",{params:{stage:"manage"}}).then(function(t){e.tableData=t.data,e.pagination.total=t.data.length;var a=(e.pagination.currentPage-1)*e.pagination.pageSize,n=(e.pagination.currentPage-1)*e.pagination.pageSize;for(e.tableDataA=[];a-n<e.pagination.pageSize&&a<e.tableData.length;a++)e.tableDataA.push(e.tableData[a])}).catch(function(t){e.$message.error("搜索失败!")}):this.$axios.get(window.$config.HOST+"/planManagement/getDistributedPlanList").then(function(t){e.tableData=t.data,e.pagination.total=t.data.length;var a=(e.pagination.currentPage-1)*e.pagination.pageSize,n=(e.pagination.currentPage-1)*e.pagination.pageSize;for(e.tableDataA=[];a-n<e.pagination.pageSize&&a<e.tableData.length;a++)e.tableDataA.push(e.tableData[a])}).catch(function(t){e.$message.error("搜索失败!")})}}}},411:function(e,t,a){t=e.exports=a(123)(!0),t.push([e.i,".Mtitle[data-v-526481a4]{font-size:3ch;margin-left:47%}.box-card[data-v-526481a4]{margin:20px 50px;padding:0 20px}.box-card .el-row[data-v-526481a4]{margin-bottom:20px}.box-card .el-row .bar[data-v-526481a4],.box-card .el-row[data-v-526481a4]{display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-orient:horizontal;-webkit-box-direction:normal;-ms-flex-direction:row;flex-direction:row;-webkit-box-align:center;-ms-flex-align:center;align-items:center}.box-card .el-row .bar .title[data-v-526481a4]{font-size:14px;width:90px;min-width:50px;text-align:center}.box-card .el-row .bar .el-input[data-v-526481a4],.box-card .el-row .bar .el-select[data-v-526481a4]{width:70%;min-width:80px;margin-left:20px}.box-card .block[data-v-526481a4]{padding:30px 0;text-align:center}","",{version:3,sources:["/home/titanxu/Desktop/planui/src/page/planManagement/planManagement.vue"],names:[],mappings:"AACA,yBACE,cAAe,AACf,eAAiB,CAClB,AACD,2BACE,iBAAkB,AAClB,cAAgB,CACjB,AACD,mCAWE,kBAAoB,CACrB,AACD,2EAZE,oBAAqB,AACrB,oBAAqB,AACrB,aAAc,AACd,8BAA+B,AAC/B,6BAA8B,AAC1B,uBAAwB,AACpB,mBAAoB,AAC5B,yBAA0B,AACtB,sBAAuB,AACnB,kBAAoB,CAc7B,AACD,+CACE,eAAgB,AAChB,WAAY,AACZ,eAAgB,AAChB,iBAAmB,CACpB,AAMD,qGACE,UAAW,AACX,eAAgB,AAChB,gBAAkB,CACnB,AACD,kCACE,eAAgB,AAChB,iBAAmB,CACpB",file:"planManagement.vue",sourcesContent:["\n.Mtitle[data-v-526481a4] {\n  font-size: 3ch;\n  margin-left: 47%;\n}\n.box-card[data-v-526481a4] {\n  margin: 20px 50px;\n  padding: 0 20px;\n}\n.box-card .el-row[data-v-526481a4] {\n  display: -webkit-box;\n  display: -ms-flexbox;\n  display: flex;\n  -webkit-box-orient: horizontal;\n  -webkit-box-direction: normal;\n      -ms-flex-direction: row;\n          flex-direction: row;\n  -webkit-box-align: center;\n      -ms-flex-align: center;\n          align-items: center;\n  margin-bottom: 20px;\n}\n.box-card .el-row .bar[data-v-526481a4] {\n  display: -webkit-box;\n  display: -ms-flexbox;\n  display: flex;\n  -webkit-box-orient: horizontal;\n  -webkit-box-direction: normal;\n      -ms-flex-direction: row;\n          flex-direction: row;\n  -webkit-box-align: center;\n      -ms-flex-align: center;\n          align-items: center;\n}\n.box-card .el-row .bar .title[data-v-526481a4] {\n  font-size: 14px;\n  width: 90px;\n  min-width: 50px;\n  text-align: center;\n}\n.box-card .el-row .bar .el-input[data-v-526481a4] {\n  width: 70%;\n  min-width: 80px;\n  margin-left: 20px;\n}\n.box-card .el-row .bar .el-select[data-v-526481a4] {\n  width: 70%;\n  min-width: 80px;\n  margin-left: 20px;\n}\n.box-card .block[data-v-526481a4] {\n  padding: 30px 0;\n  text-align: center;\n}\n"],sourceRoot:""}])},460:function(e,t,a){var n=a(411);"string"==typeof n&&(n=[[e.i,n,""]]),n.locals&&(e.exports=n.locals);a(124)("0e8d65d6",n,!0)},534:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"body"},[a("el-card",{staticClass:"box-card"},[a("el-row",{staticStyle:{"margin-top":"5px"},attrs:{gutter:20}},[a("el-col",{attrs:{span:6}},[a("div",{staticClass:"bar"},[a("div",{staticClass:"title"},[e._v("客户名称")]),e._v(" "),a("el-select",{attrs:{clearable:""},model:{value:e.searchOptions.searchParams.customerName,callback:function(t){e.$set(e.searchOptions.searchParams,"customerName",t)},expression:"searchOptions.searchParams.customerName"}},e._l(e.searchOptions.options.customerNameOptions,function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}))],1)]),e._v(" "),a("el-col",{attrs:{span:6}},[a("div",{staticClass:"bar"},[a("div",{staticClass:"title"},[e._v("品牌")]),e._v(" "),a("el-select",{attrs:{clearable:""},model:{value:e.searchOptions.searchParams.brandName,callback:function(t){e.$set(e.searchOptions.searchParams,"brandName",t)},expression:"searchOptions.searchParams.brandName"}},e._l(e.searchOptions.options.brandNameOptions,function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}))],1)]),e._v(" "),a("el-col",{attrs:{span:6}},[a("div",{staticClass:"bar"},[a("div",{staticClass:"title"},[e._v("服装层次")]),e._v(" "),a("el-select",{attrs:{clearable:""},model:{value:e.searchOptions.searchParams.clothingLevel,callback:function(t){e.$set(e.searchOptions.searchParams,"clothingLevel",t)},expression:"searchOptions.searchParams.clothingLevel"}},e._l(e.searchOptions.options.clothingLevelOptions,function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}))],1)]),e._v(" "),a("el-col",{attrs:{span:6}},[a("div",{staticClass:"bar"},[a("div",{staticClass:"title"},[e._v("系列名称")]),e._v(" "),a("el-select",{attrs:{clearable:""},model:{value:e.searchOptions.searchParams.rangeName,callback:function(t){e.$set(e.searchOptions.searchParams,"rangeName",t)},expression:"searchOptions.searchParams.rangeName"}},e._l(e.searchOptions.options.rangeNameOptions,function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}))],1)])],1),e._v(" "),a("el-row",{staticStyle:{"margin-top":"30px","margin-bottom":"5px"},attrs:{gutter:20}},[a("el-col",{attrs:{span:6}},[a("div",{staticClass:"bar"},[a("div",{staticClass:"title"},[e._v("计划名称")]),e._v(" "),a("el-select",{attrs:{clearable:""},model:{value:e.searchOptions.searchParams.name,callback:function(t){e.$set(e.searchOptions.searchParams,"name",t)},expression:"searchOptions.searchParams.name"}},e._l(e.searchOptions.options.planNameOptions,function(e){return a("el-option",{key:e.name,attrs:{label:e.name,value:e.name}})}))],1)]),e._v(" "),a("el-col",{attrs:{span:9}},[a("div",{staticClass:"bar"},[a("div",{staticClass:"title"},[e._v("添加时间")]),e._v(" "),a("el-date-picker",{staticStyle:{"margin-left":"20px"},attrs:{type:"daterange","range-separator":"至","start-placeholde":"开始日期","end-placeholde":"结束日期",clearable:""},model:{value:e.searchOptions.searchParams.dateRange,callback:function(t){e.$set(e.searchOptions.searchParams,"dateRange",t)},expression:"searchOptions.searchParams.dateRange"}})],1)]),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-switch",{attrs:{"inactive-color":"#13ce66","active-text":"制定的计划","inactive-text":"被下发计划"},on:{change:e.planTypeSwitchChange},model:{value:e.isSelfMadePlan,callback:function(t){e.isSelfMadePlan=t},expression:"isSelfMadePlan"}})],1),e._v(" "),a("el-col",{attrs:{span:2}},[a("el-button",{attrs:{type:"primary",icon:"el-icon-search"},on:{click:e.handleSearch}},[e._v("搜索")])],1)],1)],1),e._v(" "),a("el-card",{staticClass:"box-card"},[a("el-row",{attrs:{gutter:20}},[e.isSelfMadePlan?a("el-col",{attrs:{span:3}},[a("el-button",{attrs:{type:"primary",size:"small"},on:{click:e.deletePlan}},[e._v("删除计划")])],1):e._e(),e._v(" "),e.isSelfMadePlan?a("el-col",{attrs:{span:3}},[a("el-button",{attrs:{type:"primary",size:"small"},on:{click:e.commitPlan}},[e._v("提交计划")])],1):e._e(),e._v(" "),e.isSelfMadePlan?e._e():a("el-col",{attrs:{span:3}},[a("el-button",{attrs:{type:"primary",size:"small"},on:{click:e.addPlanChild}},[e._v("添加子计划")])],1),e._v(" "),e.isSelfMadePlan?e._e():a("el-col",{attrs:{span:4}},[a("el-button",{attrs:{type:"primary",size:"small"},on:{click:e.changeOrder}},[e._v("下级计划顺序调整")])],1),e._v(" "),e.isSelfMadePlan?e._e():a("el-col",{attrs:{span:3}},[a("el-button",{attrs:{type:"primary",size:"small"},on:{click:e.addException}},[e._v("添加异常")])],1)],1),e._v(" "),a("el-table",{staticStyle:{width:"100%","margin-top":"20px"},attrs:{data:e.tableDataA,"max-height":"400",stripe:!0,"highlight-current-row":!0},on:{"selection-change":e.changeCheckBoxFun}},[a("el-table-column",{attrs:{width:"50",type:"selection",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{width:"50",type:"index",label:"序号",align:"center"}}),e._v(" "),e._e(),e._v(" "),a("el-table-column",{attrs:{prop:"number",label:"计划编号",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"name",label:"计划名称",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"rangeNumber",label:"系列编号",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"customerName",label:"客户名称",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"brandName",label:"品牌",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"rangeName",label:"系列名称",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"createrName",label:"添加人",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"deptName",label:"部门",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"createTime",label:"添加时间",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"parentName",label:"上级计划",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"havePlan",label:"状态",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.havePlan?a("p",[e._v("已制定")]):a("p",[e._v("未制定")])]}}])}),e._v(" "),a("el-table-column",{attrs:{label:"异常状态",width:"150",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.haveException?a("el-button",{attrs:{type:"text",size:"small"},nativeOn:{click:function(a){a.preventDefault(),e.ToSearchException(t.row)}}},[e._v("有异常，查看")]):a("p",[e._v("无异常")])]}}])}),e._v(" "),a("el-table-column",{attrs:{fixed:"right",label:"操作",width:"150",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"text",size:"small"},nativeOn:{click:function(a){a.preventDefault(),e.getPlanDetail(t.row)}}},[e._v("查看")]),e._v(" "),e.isSelfMadePlan?a("el-button",{attrs:{type:"text",size:"small"},nativeOn:{click:function(a){a.preventDefault(),e.ModifyPlanDetail(t.row)}}},[e._v("修改")]):e._e(),e._v(" "),e.isSelfMadePlan?a("el-button",{attrs:{type:"text",size:"small"},nativeOn:{click:function(a){a.preventDefault(),e.deleteOnePlan(t.row.id)}}},[e._v("删除")]):e._e()]}}])})],1),e._v(" "),a("div",{staticClass:"block"},[a("el-pagination",{attrs:{"current-page":e.pagination.currentPage,"page-sizes":e.pagination.pageSizes,"page-size":e.pagination.pageSize,layout:"total, sizes, prev, pager, next, jumper",total:e.pagination.total},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange,"update:currentPage":function(t){e.$set(e.pagination,"currentPage",t)}}})],1)],1)],1)},staticRenderFns:[]}}});
//# sourceMappingURL=7.417c550891e0cd3232db.js.map