webpackJsonp([18],{154:function(a,e,t){function n(a){t(438)}var i=t(37)(t(307),t(508),n,"data-v-12dfadee",null);a.exports=i.exports},307:function(a,e,t){"use strict";Object.defineProperty(e,"__esModule",{value:!0}),e.default={data:function(){return{totalTableData:[],tableData:[],searchOptions:{searchParams:{customerName:"",brandName:"",rangeName:"",dateRange:""},options:{customerNameOptions:[],brandNameOptions:[],rangeNameOptions:[]}},pagination:{currentPage:1,pageSizes:[5,10,20,30,50],pageSize:5,total:0},pages:0,tableSelectionData:[]}},created:function(){var a=this;console.log("进入计划回收站页面"),this.$axios.get(window.$config.HOST+"/baseInfoManagement/getCustomerName").then(function(e){a.searchOptions.options.customerNameOptions=e.data}).catch(function(a){console.log("初始化加载客户名称失败!")}),this.$axios.get(window.$config.HOST+"/baseInfoManagement/getBrandName").then(function(e){a.searchOptions.options.brandNameOptions=e.data}).catch(function(a){console.log("初始化品牌名称加载错误")}),this.$axios.get(window.$config.HOST+"/infoManagement/getRangeName").then(function(e){a.searchOptions.options.rangeNameOptions=e.data}).catch(function(a){console.log("初始化系列名称加载错误")}),this.$axios.get(window.$config.HOST+"/planManagement/getPlanList",{params:{stage:"delete"}}).then(function(e){e.data.forEach(function(e){"6"===e.state&&a.totalTableData.push(e)}),a.pagination.total=a.totalTableData.length;var t=(a.pagination.currentPage-1)*a.pagination.pageSize,n=t+a.pagination.pageSize>a.pagination.total?a.pagination.total:t+a.pagination.pageSize;a.tableData=a.totalTableData.slice(t,n)}).catch(function(a){console.log("初始化删除计划加载错误")})},methods:{handleSizeChange:function(a){this.pagination.pageSize=a,console.log("每页 "+a+" 条"),this.pagination.currentPage=1,this.handleSearch()},handleCurrentChange:function(a){console.log("当前页: "+a),this.pagination.currentPage=a,this.handleSearch()},ReCoverAll:function(){var a=this;0===this.tableSelectionData.length?this.$message.error("请选择要恢复的计划!"):this.tableSelectionData.forEach(function(e){console.log("恢复"+e.name),a.ReCover(e)})},ReCover:function(a){var e=this;console.log("行恢复");var t={id:a.id};console.log(a),this.$axios.get(window.$config.HOST+"/planManagement/restorePlan",{params:t}).then(function(t){t.data<0?e.$message.error(a.number+"恢复失败！"):(e.$message({type:"success",message:"恢复成功！"}),handleSearch())}).catch(function(t){e.$message.error(a.number+"恢复失败！")})},tableSelectionChange:function(a){this.tableSelectionData=a},changeDate:function(a){if(a){var e=a.getFullYear(),t=a.getMonth()+1;t=t<10?"0"+t:t;var n=a.getDate();n=n<10?"0"+n:n;var i=a.getHours(),o=a.getMinutes();o=o<10?"0"+o:o;var s=a.getSeconds();return s=o<10?"0"+s:s,e+"-"+t+"-"+n+" "+i+":"+o+":"+s}},handleSearch:function(){var a,e=this;a={customerId:""===this.searchOptions.searchParams.customerName?void 0:this.searchOptions.searchParams.customerName,brandId:""===this.searchOptions.searchParams.brandName?void 0:this.searchOptions.searchParams.brandName,rangeId:""===this.searchOptions.searchParams.rangeName?void 0:this.searchOptions.searchParams.rangeName,name:void 0,clothingLevelId:void 0,startDate:this.changeDate(this.searchOptions.searchParams.dateRange[0]),endDate:this.changeDate(this.searchOptions.searchParams.dateRange[1]),stage:"delete"},console.log(a),this.$axios.get(window.$config.HOST+"/planManagement/getPlanList",{params:a}).then(function(a){e.totalTableData=[],a.data.forEach(function(a){"6"===a.state&&e.totalTableData.push(a)}),e.pagination.total=e.totalTableData.length;var t=(e.pagination.currentPage-1)*e.pagination.pageSize,n=t+e.pagination.pageSize>e.pagination.total?e.pagination.total:t+e.pagination.pageSize;e.tableData=e.totalTableData.slice(t,n)}).catch(function(a){console.log("搜索失败")})}}}},389:function(a,e,t){e=a.exports=t(123)(!0),e.push([a.i,".box-card[data-v-12dfadee]{margin:20px 50px;padding:0 20px}.box-card .bar[data-v-12dfadee]{display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-orient:horizontal;-webkit-box-direction:normal;-ms-flex-direction:row;flex-direction:row;-webkit-box-align:center;-ms-flex-align:center;align-items:center;width:100%}.box-card .bar .title[data-v-12dfadee]{font-size:14px;min-width:75px;text-align:center}.box-card .bar .el-input[data-v-12dfadee],.box-card .bar .el-select[data-v-12dfadee]{width:300px;min-width:75px}.box-card .block[data-v-12dfadee]{padding:30px 0;text-align:center}","",{version:3,sources:["/home/titanxu/Desktop/planui/src/page/planManagement/planRecover.vue"],names:[],mappings:"AACA,2BACE,iBAAkB,AAClB,cAAgB,CACjB,AACD,gCACE,oBAAqB,AACrB,oBAAqB,AACrB,aAAc,AACd,8BAA+B,AAC/B,6BAA8B,AAC1B,uBAAwB,AACpB,mBAAoB,AAC5B,yBAA0B,AACtB,sBAAuB,AACnB,mBAAoB,AAC5B,UAAY,CACb,AACD,uCACE,eAAgB,AAChB,eAAgB,AAChB,iBAAmB,CACpB,AAKD,qFAHE,YAAa,AACb,cAAgB,CAKjB,AACD,kCACE,eAAgB,AAChB,iBAAmB,CACpB",file:"planRecover.vue",sourcesContent:["\n.box-card[data-v-12dfadee] {\n  margin: 20px 50px;\n  padding: 0 20px;\n}\n.box-card .bar[data-v-12dfadee] {\n  display: -webkit-box;\n  display: -ms-flexbox;\n  display: flex;\n  -webkit-box-orient: horizontal;\n  -webkit-box-direction: normal;\n      -ms-flex-direction: row;\n          flex-direction: row;\n  -webkit-box-align: center;\n      -ms-flex-align: center;\n          align-items: center;\n  width: 100%;\n}\n.box-card .bar .title[data-v-12dfadee] {\n  font-size: 14px;\n  min-width: 75px;\n  text-align: center;\n}\n.box-card .bar .el-input[data-v-12dfadee] {\n  width: 300px;\n  min-width: 75px;\n}\n.box-card .bar .el-select[data-v-12dfadee] {\n  width: 300px;\n  min-width: 75px;\n}\n.box-card .block[data-v-12dfadee] {\n  padding: 30px 0;\n  text-align: center;\n}\n"],sourceRoot:""}])},438:function(a,e,t){var n=t(389);"string"==typeof n&&(n=[[a.i,n,""]]),n.locals&&(a.exports=n.locals);t(124)("f0cfdbd2",n,!0)},508:function(a,e){a.exports={render:function(){var a=this,e=a.$createElement,t=a._self._c||e;return t("div",{staticClass:"body"},[t("el-card",{staticClass:"box-card"},[t("el-row",{staticStyle:{"margin-top":"15px","margin-bottom":"5px"},attrs:{gutter:20}},[t("el-col",{attrs:{span:6}},[t("div",{staticClass:"bar"},[t("div",{staticClass:"title"},[a._v("客户名称")]),a._v(" "),t("el-select",{attrs:{clearable:""},model:{value:a.searchOptions.searchParams.customerName,callback:function(e){a.$set(a.searchOptions.searchParams,"customerName",e)},expression:"searchOptions.searchParams.customerName"}},a._l(a.searchOptions.options.customerNameOptions,function(a){return t("el-option",{key:a.id,attrs:{label:a.name,value:a.id}})}))],1)]),a._v(" "),t("el-col",{attrs:{span:6,offset:4}},[t("div",{staticClass:"bar"},[t("div",{staticClass:"title"},[a._v("品牌")]),a._v(" "),t("el-select",{attrs:{clearable:""},model:{value:a.searchOptions.searchParams.brandName,callback:function(e){a.$set(a.searchOptions.searchParams,"brandName",e)},expression:"searchOptions.searchParams.brandName"}},a._l(a.searchOptions.options.brandNameOptions,function(a){return t("el-option",{key:a.id,attrs:{label:a.name,value:a.id}})}))],1)])],1),a._v(" "),t("el-row",{staticStyle:{"margin-top":"25px","margin-bottom":"5px"},attrs:{gutter:20}},[t("el-col",{attrs:{span:10}},[t("div",{staticClass:"bar"},[t("div",{staticClass:"title"},[a._v("新建时间")]),a._v(" "),t("el-date-picker",{attrs:{type:"daterange","start-placeholder":"开始日期","end-placeholder":"结束日期","default-time":["00:00:00","23:59:59"]},model:{value:a.searchOptions.searchParams.dateRange,callback:function(e){a.$set(a.searchOptions.searchParams,"dateRange",e)},expression:"searchOptions.searchParams.dateRange"}})],1)]),a._v(" "),t("el-col",{attrs:{span:6}},[t("div",{staticClass:"bar"},[t("div",{staticClass:"title"},[a._v("系列名称")]),a._v(" "),t("el-select",{model:{value:a.searchOptions.searchParams.rangeName,callback:function(e){a.$set(a.searchOptions.searchParams,"rangeName",e)},expression:"searchOptions.searchParams.rangeName"}},a._l(a.searchOptions.options.rangeNameOptions,function(a){return t("el-option",{key:a.id,attrs:{label:a.name,value:a.id}})}))],1)]),a._v(" "),t("el-col",{attrs:{offset:0,span:2}},[t("div",{staticClass:"bar"},[t("el-button",{staticStyle:{"margin-right":"20px"},attrs:{type:"primary"},on:{click:a.handleSearch}},[a._v("查询")])],1)])],1)],1),a._v(" "),t("el-card",{staticClass:"box-card"},[t("div",[t("el-row",{attrs:{gutter:20}},[t("el-button",{staticStyle:{"margin-right":"20px"},attrs:{type:"primary"},on:{click:a.ReCoverAll}},[a._v("恢复所选计划")])],1),a._v(" "),t("el-table",{staticStyle:{width:"100%","margin-top":"20px"},attrs:{data:a.tableData,stripe:!0},on:{"selection-change":a.tableSelectionChange}},[t("el-table-column",{attrs:{type:"selection",width:"50",align:"center"}}),a._v(" "),t("el-table-column",{attrs:{type:"index",label:"序号",align:"center"}}),a._v(" "),a._e(),a._v(" "),t("el-table-column",{attrs:{prop:"number",label:"预测编号",align:"center"}}),a._v(" "),t("el-table-column",{attrs:{prop:"customerName",label:"客户名称",align:"center"}}),a._v(" "),t("el-table-column",{attrs:{prop:"brandName",label:"品牌",align:"center"}}),a._v(" "),t("el-table-column",{attrs:{prop:"name",label:"计划名称",align:"center"}}),a._v(" "),t("el-table-column",{attrs:{prop:"rangeName",label:"系列名称",align:"center"}}),a._v(" "),t("el-table-column",{attrs:{prop:"planObject",label:"计划对象",align:"center"}}),a._v(" "),t("el-table-column",{attrs:{prop:"type",label:"项目类型",align:"center"}}),a._v(" "),t("el-table-column",{attrs:{prop:"createrName",label:"创建人",align:"center"}}),a._v(" "),t("el-table-column",{attrs:{prop:"createrName",label:"删除人",align:"center"}}),a._v(" "),t("el-table-column",{attrs:{prop:"deleteTime",label:"删除时间",align:"center"}}),a._v(" "),t("el-table-column",{attrs:{fixed:"right",label:"操作",width:"50"},scopedSlots:a._u([{key:"default",fn:function(e){return[t("el-button",{attrs:{type:"text",size:"small"},on:{click:function(t){a.ReCover(e.row)}}},[a._v("恢复")])]}}])})],1)],1),a._v(" "),t("div",{staticClass:"block"},[t("el-pagination",{attrs:{"current-page":a.pagination.currentPage,"page-sizes":a.pagination.pageSizes,"page-size":a.pagination.pageSize,layout:"total, sizes, prev, pager, next, jumper",total:a.pagination.total},on:{"size-change":a.handleSizeChange,"current-change":a.handleCurrentChange,"update:currentPage":function(e){a.$set(a.pagination,"currentPage",e)}}})],1)])],1)},staticRenderFns:[]}}});
//# sourceMappingURL=18.8348892095f9c3503bf3.js.map