webpackJsonp([11],{161:function(e,a,t){function n(e){t(470)}var i=t(37)(t(314),t(555),n,"data-v-9d8f16d4",null);e.exports=i.exports},314:function(e,a,t){"use strict";Object.defineProperty(a,"__esModule",{value:!0}),a.default={data:function(){return{tableDataA:[],pagination:{currentPage:1,pageSizes:[5,10,20,30,50],pageSize:5,total:400},checked:!0,DataStartTime:"",DataEndTime:"",ClientName:"",BrandName:"",ClothesType:"",Date1:"",Date2:"",SeriesName:"",SeriesGroupName:"",PlanName:"",OrderId:"",orderOption:[],seriesGroup:[],client:[],brand:[],type:[],series:[],tableData:[],barCode:"",qualityTestRecordDetail:[{materialCode:"",unit:"",qualityTestQuantity:"",qualityTestMethod:"",qualityTestStandard:"",entryQuantity:"",returnQuantity:"",reason:"",result:""}],multipleSelection:[],controlData:{isFromPlan:!1,isFromTest:!1,selectDataLength:0}}},created:function(){var e=this,a=this;a.$axios.get(window.$config.HOST+"/infoManagement/getStyleNumber",{params:{rangeId:""}}).then(function(a){e.orderOption=a.data}).catch(function(a){e.$message({message:"获取订单款号失败",type:"error"})}),this.$axios.get(window.$config.HOST+"/infoManagement/getRangeName",{params:{brandId:""}}).then(function(a){e.series=a.data}).catch(function(a){e.$message({message:"获取系列名称失败",type:"error"})}),this.$axios.get(window.$config.HOST+"/baseInfoManagement/getBrandName",{params:{customerId:""}}).then(function(a){e.brand=a.data}).catch(function(a){e.$message({message:"获取品牌名称失败",type:"error"})}),a.$axios.get(window.$config.HOST+"/baseInfoManagement/getCustomerName").then(function(a){e.client=a.data}).catch(function(a){e.$message({message:"获取客户名称失败",type:"error"})}),this.$axios.post(window.$config.HOST+"/infoManagement/getStyleList",{customerId:null,brandId:null,rangeId:null,number:null,clothingLevelId:null,startDate:null,endDate:null}).then(function(a){a.data.forEach(function(a){var t=new Date(a.createTime);1===a.state?a.stateName="已制定":2===a.state?a.stateName="已提交":3===a.state?a.stateName="被驳回":4===a.state?a.stateName="已审核":5===a.state?a.stateName="已下发":6===a.state&&(a.stateName="已删除");var t=new Date(a.createTime),n=t.toLocaleString();a.createTime=n,1==e.checked&&!1===a.havePlan?e.tableData.push(a):0==e.checked&&!0===a.havePlan&&e.tableData.push(a)}),e.pagination.total=e.tableData.length;var t=(e.pagination.currentPage-1)*e.pagination.pageSize,n=(e.pagination.currentPage-1)*e.pagination.pageSize;for(e.tableDataA=[];t-n<e.pagination.pageSize&&t<e.tableData.length;t++)e.tableDataA.push(e.tableData[t])}).catch(function(a){e.$message({message:"获取搜索结果失败",type:"error"})})},methods:{handleSizeChange:function(e){this.pagination.pageSize=e,console.log("每页+"+this.pagination.pageSize),this.SearchIt()},handleCurrentChange:function(e){this.pagination.currentPage=e,this.SearchIt()},planTypeSwitchChange:function(){var e=this;this.pagination.currentPage=1,console.log(this.checked);var a=this;this.DataStartTime=a.changeDate(this.Date1[0]),this.DataEndTime=a.changeDate(this.Date1[1]),this.$axios.post(window.$config.HOST+"/infoManagement/getStyleList",{customerId:""===this.ClientName?null:this.ClientName,brandId:""===this.BrandName?null:this.BrandName,rangeId:""===this.SeriesName?null:this.SeriesName,number:""===this.OrderId?null:this.OrderId,clothingLevelId:null,startDate:this.DataStartTime,endDate:this.DataEndTime}).then(function(a){console.log(a.data);var t=a.data;e.tableData=[],t.forEach(function(a){var t=new Date(a.createTime);1===a.state?a.stateName="已制定":2===a.state?a.stateName="已提交":3===a.state?a.stateName="被驳回":4===a.state?a.stateName="已审核":5===a.state?a.stateName="已下发":6===a.state&&(a.stateName="已删除");var t=new Date(a.createTime),n=t.toLocaleString();a.createTime=n,1==e.checked&&!1===a.havePlan?e.tableData.push(a):0==e.checked&&!0===a.havePlan&&e.tableData.push(a)}),e.pagination.total=e.tableData.length;var n=(e.pagination.currentPage-1)*e.pagination.pageSize,i=(e.pagination.currentPage-1)*e.pagination.pageSize;for(e.tableDataA=[];n-i<e.pagination.pageSize&&n<e.tableData.length;n++)e.tableDataA.push(e.tableData[n])}).catch(function(a){e.$message({message:"获取搜索结果失败",type:"error"})})},changeDate:function(e){if(console.log(e),e){var a=e.getFullYear(),t=e.getMonth()+1;t=t<10?"0"+t:t;var n=e.getDate();n=n<10?"0"+n:n;var i=e.getHours(),l=e.getMinutes();l=l<10?"0"+l:l;var r=e.getSeconds();return r=l<10?"0"+r:r,a+"-"+t+"-"+n+" "+i+":"+l+":"+r}return null},SearchIt:function(){var e=this,a=this;this.DataStartTime=a.changeDate(this.Date1[0]),this.DataEndTime=a.changeDate(this.Date1[1]),this.$axios.post(window.$config.HOST+"/infoManagement/getStyleList",{customerId:""===this.ClientName?null:this.ClientName,brandId:""===this.BrandName?null:this.BrandName,rangeId:""===this.SeriesName?null:this.SeriesName,number:""===this.OrderId?null:this.OrderId,clothingLevelId:null,startDate:this.DataStartTime,endDate:this.DataEndTime}).then(function(a){console.log(a.data),console.log("checked=",e.checked);var t=a.data;e.tableData=[],t.forEach(function(a){console.log("这次havePlan的值为:"+a.havePlan);var t=new Date(a.createTime);1===a.state?a.stateName="已制定":2===a.state?a.stateName="已提交":3===a.state?a.stateName="被驳回":4===a.state?a.stateName="已审核":5===a.state?a.stateName="已下发":6===a.state&&(a.stateName="已删除");var t=new Date(a.createTime),n=t.toLocaleString();a.createTime=n,0!=e.checked?1==e.checked&&!1===a.havePlan?e.tableData.push(a):2==e.checked&&!0===a.havePlan&&e.tableData.push(a):e.tableData.push(a)}),e.pagination.total=e.tableData.length;var n=(e.pagination.currentPage-1)*e.pagination.pageSize,i=(e.pagination.currentPage-1)*e.pagination.pageSize;for(e.tableDataA=[];n-i<e.pagination.pageSize&&n<e.tableData.length;n++)e.tableDataA.push(e.tableData[n])}).catch(function(a){e.$message({message:"获取搜索结果失败",type:"error"})})},ToPlanForm:function(e){this.$router.push({name:"planMakeIndex",params:{flag:3,goback:"stylePlanMake",client:e.customerName,brand:e.brandName,series:e.rangeName,id:e.id,plantype:3,planobj:e.number}})},QuoteSeriesPlan:function(e){this.$router.push({name:"planMakeIndex",params:{flag:2,goback:"stylePlanMake",client:e.customerName,brand:e.brandName,id:e.id,series:e.rangeName,plantype:2,planobj:e.number}})}}}},421:function(e,a,t){a=e.exports=t(123)(!0),a.push([e.i,".block[data-v-9d8f16d4]{padding:30px 0;text-align:center}.Mtitle[data-v-9d8f16d4]{-ms-flex-line-pack:center;align-content:center;margin-left:43%;font-size:2ch}.box-card[data-v-9d8f16d4]{margin:20px 50px;padding:0 20px}.box-card .el-row[data-v-9d8f16d4]{display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-orient:horizontal;-webkit-box-direction:normal;-ms-flex-direction:row;flex-direction:row;-webkit-box-align:center;-ms-flex-align:center;align-items:center;margin-bottom:20px}.box-card .el-row .MinW[data-v-9d8f16d4]{min-width:400px}.box-card .el-row .bar[data-v-9d8f16d4]{display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-orient:horizontal;-webkit-box-direction:normal;-ms-flex-direction:row;flex-direction:row;-webkit-box-align:center;-ms-flex-align:center;align-items:center}.box-card .el-row .bar .title[data-v-9d8f16d4]{font-size:14px;width:90px;min-width:100px;text-align:center}.box-card .el-row .bar .el-input[data-v-9d8f16d4],.box-card .el-row .bar .el-select[data-v-9d8f16d4]{width:70%;min-width:80px;margin-left:20px}","",{version:3,sources:["/home/titanxu/Desktop/planui/src/page/planManagement/stylePlanMake.vue"],names:[],mappings:"AACA,wBACE,eAAgB,AAChB,iBAAmB,CACpB,AACD,yBACE,0BAA2B,AACvB,qBAAsB,AAC1B,gBAAiB,AACjB,aAAe,CAChB,AACD,2BACE,iBAAkB,AAClB,cAAgB,CACjB,AACD,mCACE,oBAAqB,AACrB,oBAAqB,AACrB,aAAc,AACd,8BAA+B,AAC/B,6BAA8B,AAC1B,uBAAwB,AACpB,mBAAoB,AAC5B,yBAA0B,AACtB,sBAAuB,AACnB,mBAAoB,AAC5B,kBAAoB,CACrB,AACD,yCACE,eAAiB,CAClB,AACD,wCACE,oBAAqB,AACrB,oBAAqB,AACrB,aAAc,AACd,8BAA+B,AAC/B,6BAA8B,AAC1B,uBAAwB,AACpB,mBAAoB,AAC5B,yBAA0B,AACtB,sBAAuB,AACnB,kBAAoB,CAC7B,AACD,+CACE,eAAgB,AAChB,WAAY,AACZ,gBAAiB,AACjB,iBAAmB,CACpB,AAMD,qGACE,UAAW,AACX,eAAgB,AAChB,gBAAkB,CACnB",file:"stylePlanMake.vue",sourcesContent:["\n.block[data-v-9d8f16d4] {\n  padding: 30px 0;\n  text-align: center;\n}\n.Mtitle[data-v-9d8f16d4] {\n  -ms-flex-line-pack: center;\n      align-content: center;\n  margin-left: 43%;\n  font-size: 2ch;\n}\n.box-card[data-v-9d8f16d4] {\n  margin: 20px 50px;\n  padding: 0 20px;\n}\n.box-card .el-row[data-v-9d8f16d4] {\n  display: -webkit-box;\n  display: -ms-flexbox;\n  display: flex;\n  -webkit-box-orient: horizontal;\n  -webkit-box-direction: normal;\n      -ms-flex-direction: row;\n          flex-direction: row;\n  -webkit-box-align: center;\n      -ms-flex-align: center;\n          align-items: center;\n  margin-bottom: 20px;\n}\n.box-card .el-row .MinW[data-v-9d8f16d4] {\n  min-width: 400px;\n}\n.box-card .el-row .bar[data-v-9d8f16d4] {\n  display: -webkit-box;\n  display: -ms-flexbox;\n  display: flex;\n  -webkit-box-orient: horizontal;\n  -webkit-box-direction: normal;\n      -ms-flex-direction: row;\n          flex-direction: row;\n  -webkit-box-align: center;\n      -ms-flex-align: center;\n          align-items: center;\n}\n.box-card .el-row .bar .title[data-v-9d8f16d4] {\n  font-size: 14px;\n  width: 90px;\n  min-width: 100px;\n  text-align: center;\n}\n.box-card .el-row .bar .el-input[data-v-9d8f16d4] {\n  width: 70%;\n  min-width: 80px;\n  margin-left: 20px;\n}\n.box-card .el-row .bar .el-select[data-v-9d8f16d4] {\n  width: 70%;\n  min-width: 80px;\n  margin-left: 20px;\n}\n"],sourceRoot:""}])},470:function(e,a,t){var n=t(421);"string"==typeof n&&(n=[[e.i,n,""]]),n.locals&&(e.exports=n.locals);t(124)("465aee32",n,!0)},555:function(e,a){e.exports={render:function(){var e=this,a=e.$createElement,t=e._self._c||a;return t("div",{staticClass:"body"},[t("el-card",{staticClass:"box-card"},[t("el-row",{attrs:{gutter:20}},[t("el-col",{attrs:{span:8}},[t("div",{staticClass:"bar"},[t("div",{staticClass:"title"},[e._v("客户名称")]),e._v(" "),t("el-select",{attrs:{clearable:"",placeholder:"请选择"},model:{value:e.ClientName,callback:function(a){e.ClientName=a},expression:"ClientName"}},e._l(e.client,function(e){return t("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}))],1)]),e._v(" "),t("el-col",{attrs:{span:8}},[t("div",{staticClass:"bar"},[t("div",{staticClass:"title"},[e._v("品牌")]),e._v(" "),t("el-select",{attrs:{clearable:"",placeholder:"请选择"},model:{value:e.BrandName,callback:function(a){e.BrandName=a},expression:"BrandName"}},e._l(e.brand,function(e){return t("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}))],1)]),e._v(" "),t("el-col",{attrs:{span:8}},[t("div",{staticClass:"bar"},[t("div",{staticClass:"title"},[e._v("系列名称")]),e._v(" "),t("el-select",{attrs:{clearable:"",placeholder:"请选择"},model:{value:e.SeriesName,callback:function(a){e.SeriesName=a},expression:"SeriesName"}},e._l(e.series,function(e){return t("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}))],1)])],1),e._v(" "),t("el-row",{attrs:{gutter:20}},[t("el-col",{attrs:{span:8}},[t("div",{staticClass:"bar"},[t("div",{staticClass:"title"},[e._v("添加时间")]),e._v(" "),t("el-date-picker",{staticStyle:{"margin-left":"20px"},attrs:{type:"daterange",align:"right","unlink-panels":"",clearable:"","range-separator":"至","start-placeholder":"开始日期","end-placeholder":"结束日期"},model:{value:e.Date1,callback:function(a){e.Date1=a},expression:"Date1"}})],1)]),e._v(" "),t("el-col",{attrs:{span:8}},[t("div",{staticClass:"bar"},[t("div",{staticClass:"title"},[e._v("订单款号")]),e._v(" "),t("el-select",{attrs:{clearable:""},model:{value:e.OrderId,callback:function(a){e.OrderId=a},expression:"OrderId"}},e._l(e.orderOption,function(e){return t("el-option",{key:e.id,attrs:{label:e.number,value:e.number}})}))],1)]),e._v(" "),t("el-col",{staticClass:"MinW",staticStyle:{"margin-left":"30px"},attrs:{span:5}},[t("el-switch",{attrs:{"inactive-color":"#13ce66","inactive-text":"未制定","active-text":"已制定"},on:{change:e.planTypeSwitchChange},model:{value:e.checked,callback:function(a){e.checked=a},expression:"checked"}}),e._v(" "),t("el-button",{staticStyle:{"margin-left":"50px"},attrs:{type:"primary"},on:{click:function(a){e.SearchIt()}}},[e._v("搜索")])],1)],1)],1),e._v(" "),t("el-card",{staticClass:"box-card"},[t("el-table",{staticStyle:{width:"100%","margin-top":"20px"},attrs:{data:e.tableDataA}},[t("el-table-column",{attrs:{width:"50",type:"index",label:"序号",align:"center"}}),e._v(" "),t("el-table-column",{attrs:{prop:"styleGroupNumber",label:"款式组编号",align:"center",width:"100px"}}),e._v(" "),t("el-table-column",{attrs:{prop:"styleGroupName",label:"款式组名称",align:"center",width:"100px"}}),e._v(" "),t("el-table-column",{attrs:{prop:"number",label:"订单款号",align:"center"}}),e._v(" "),t("el-table-column",{attrs:{prop:"rangeNumber",label:"系列编号",align:"center"}}),e._v(" "),t("el-table-column",{attrs:{prop:"customerName",label:"客户名称",align:"center"}}),e._v(" "),t("el-table-column",{attrs:{prop:"brandName",label:"品牌",align:"center"}}),e._v(" "),t("el-table-column",{attrs:{prop:"clothingLevelName",label:"服装层次",align:"center"}}),e._v(" "),t("el-table-column",{attrs:{prop:"rangeName",label:"系列名称",align:"center"}}),e._v(" "),t("el-table-column",{attrs:{prop:"createrName",label:"添加人",align:"center"}}),e._v(" "),t("el-table-column",{attrs:{prop:"deptName",label:"部门",align:"center"}}),e._v(" "),t("el-table-column",{attrs:{prop:"stateName",label:"状态",align:"center"}}),e._v(" "),t("el-table-column",{attrs:{fixed:"right",label:"操作",width:"250",align:"center"},scopedSlots:e._u([{key:"default",fn:function(a){return[t("el-button",{attrs:{type:"text",size:"small"},on:{click:function(t){e.QuoteSeriesPlan(a.row)}}},[e._v("引用系列计划")]),e._v(" "),t("el-button",{attrs:{type:"text",size:"small"},on:{click:function(t){e.ToPlanForm(a.row)}}},[e._v("制定计划")])]}}])})],1),e._v(" "),t("div",{staticClass:"block"},[t("el-pagination",{attrs:{"current-page":e.pagination.currentPage,"page-sizes":e.pagination.pageSizes,"page-size":e.pagination.pageSize,layout:"total, sizes, prev, pager, next, jumper",total:e.pagination.total},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange,"update:currentPage":function(a){e.$set(e.pagination,"currentPage",a)}}})],1)],1)],1)},staticRenderFns:[]}}});
//# sourceMappingURL=11.6cd8ea76fdaea9aae4ac.js.map