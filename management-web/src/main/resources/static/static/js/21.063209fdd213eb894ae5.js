webpackJsonp([21],{150:function(e,a,t){function n(e){t(477)}var i=t(37)(t(303),t(563),n,"data-v-ef8593e8",null);e.exports=i.exports},303:function(e,a,t){"use strict";Object.defineProperty(a,"__esModule",{value:!0}),a.default={data:function(){return{totalTableData:[],tableData:[],pagination:{currentPage:1,pageSizes:[5,10,20,30,50],pageSize:5,total:0},pages:0,tableSelectionData:[]}},created:function(){var e=this;console.log("进入计划完成页面"),this.$axios.post(window.$config.HOST+"/infoManagement/getRangeList",{customerId:"",brandId:"",id:"",clothingLevelId:"",startDate:"",endDate:""}).then(function(a){e.totalTableData=a.data,e.totalTableData.forEach(function(e){1===e.addingMode?e.addingModeName="手动":e.addingModeName="导入",1===e.state?e.stateName="已制定":2===e.state?e.stateName="已提交":3===e.state?e.stateName="被驳回":4===e.state?e.stateName="已审核":5===e.state?e.stateName="已下发":6===e.state&&(e.stateName="已删除");var a=new Date(e.createTime),t=a.toLocaleString();e.createTime=t}),e.pagination.total=e.totalTableData.length;var t=(e.pagination.currentPage-1)*e.pagination.pageSize,n=t+e.pagination.pageSize>e.pagination.total?e.pagination.total:t+e.pagination.pageSize;e.tableData=e.totalTableData.slice(t,n)}).catch(function(e){console.log("初始化加载系列失败")})},methods:{handleSizeChange:function(e){this.pagination.pageSize=e,console.log("每页 "+e+" 条"),this.pagination.currentPage=1,this.handleSearch()},handleCurrentChange:function(e){console.log("当前页: "+e),this.pagination.currentPage=e,this.handleSearch()},handleSearch:function(){var e=this;this.$axios.post(window.$config.HOST+"/infoManagement/getRangeList",{customerId:"",brandId:"",id:"",clothingLevelId:"",startDate:"",endDate:""}).then(function(a){e.totalTableData=a.data,e.totalTableData.forEach(function(e){1===e.addingMode?e.addingModeName="手动":e.addingModeName="导入",1===e.state?e.stateName="已制定":2===e.state?e.stateName="已提交":3===e.state?e.stateName="被驳回":4===e.state?e.stateName="已审核":5===e.state?e.stateName="已下发":6===e.state&&(e.stateName="已删除");var a=new Date(e.createTime),t=a.toLocaleString();e.createTime=t}),e.pagination.total=e.totalTableData.length;var t=(e.pagination.currentPage-1)*e.pagination.pageSize,n=t+e.pagination.pageSize>e.pagination.total?e.pagination.total:t+e.pagination.pageSize;e.tableData=e.totalTableData.slice(t,n)}).catch(function(e){console.log("加载系列失败")})},handleCompletionClick:function(){var e=this,a=this;0===a.tableSelectionData.length?a.$message.error("请选择要删除的计划！"):this.tableSelectionData.forEach(function(a){console.log("删除"+a.name),e.$axios.get(window.$config.HOST+"/infoManagement/completeRange",{params:{id:a.id}}).then(function(t){t.data<0?e.$message.error(a.name+"添加完成失败"):(console.log("完成"+a.name),e.handleSearch())}).catch(function(t){console.log(a.name+"完成失败"),e.$message.error(a.name+"添加完成失败")})})},tableSelectionChange:function(e){this.tableSelectionData=e}}}},428:function(e,a,t){a=e.exports=t(123)(!0),a.push([e.i,".box-card[data-v-ef8593e8]{margin:20px 50px;padding:0 20px}.box-card .bar[data-v-ef8593e8]{display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-orient:horizontal;-webkit-box-direction:normal;-ms-flex-direction:row;flex-direction:row;-webkit-box-align:center;-ms-flex-align:center;align-items:center;width:100%}.box-card .bar .title[data-v-ef8593e8]{font-size:14px;min-width:75px;text-align:center}.box-card .bar .el-input[data-v-ef8593e8],.box-card .bar .el-select[data-v-ef8593e8]{width:300px;min-width:75px}.box-card .block[data-v-ef8593e8]{padding:30px 0;text-align:center}","",{version:3,sources:["/home/titanxu/Desktop/planui/src/page/planManagement/planCompletionManage.vue"],names:[],mappings:"AACA,2BACE,iBAAkB,AAClB,cAAgB,CACjB,AACD,gCACE,oBAAqB,AACrB,oBAAqB,AACrB,aAAc,AACd,8BAA+B,AAC/B,6BAA8B,AAC1B,uBAAwB,AACpB,mBAAoB,AAC5B,yBAA0B,AACtB,sBAAuB,AACnB,mBAAoB,AAC5B,UAAY,CACb,AACD,uCACE,eAAgB,AAChB,eAAgB,AAChB,iBAAmB,CACpB,AAKD,qFAHE,YAAa,AACb,cAAgB,CAKjB,AACD,kCACE,eAAgB,AAChB,iBAAmB,CACpB",file:"planCompletionManage.vue",sourcesContent:["\n.box-card[data-v-ef8593e8] {\n  margin: 20px 50px;\n  padding: 0 20px;\n}\n.box-card .bar[data-v-ef8593e8] {\n  display: -webkit-box;\n  display: -ms-flexbox;\n  display: flex;\n  -webkit-box-orient: horizontal;\n  -webkit-box-direction: normal;\n      -ms-flex-direction: row;\n          flex-direction: row;\n  -webkit-box-align: center;\n      -ms-flex-align: center;\n          align-items: center;\n  width: 100%;\n}\n.box-card .bar .title[data-v-ef8593e8] {\n  font-size: 14px;\n  min-width: 75px;\n  text-align: center;\n}\n.box-card .bar .el-input[data-v-ef8593e8] {\n  width: 300px;\n  min-width: 75px;\n}\n.box-card .bar .el-select[data-v-ef8593e8] {\n  width: 300px;\n  min-width: 75px;\n}\n.box-card .block[data-v-ef8593e8] {\n  padding: 30px 0;\n  text-align: center;\n}\n"],sourceRoot:""}])},477:function(e,a,t){var n=t(428);"string"==typeof n&&(n=[[e.i,n,""]]),n.locals&&(e.exports=n.locals);t(124)("d2b7ccda",n,!0)},563:function(e,a){e.exports={render:function(){var e=this,a=e.$createElement,t=e._self._c||a;return t("div",{staticClass:"body"},[t("el-card",{staticClass:"box-card"},[t("div",[t("el-row",{attrs:{gutter:20}},[t("el-button",{staticStyle:{"margin-right":"20px"},attrs:{type:"primary"},on:{click:e.handleCompletionClick}},[e._v("计划完成")])],1),e._v(" "),t("el-table",{staticStyle:{width:"100%","margin-top":"20px"},attrs:{data:e.tableData,stripe:!0},on:{"selection-change":e.tableSelectionChange}},[t("el-table-column",{attrs:{type:"selection",width:"50",align:"center"}}),e._v(" "),t("el-table-column",{attrs:{type:"index",label:"序号",align:"center"}}),e._v(" "),e._e(),e._v(" "),t("el-table-column",{attrs:{prop:"number",label:"系列编号",align:"center"}}),e._v(" "),t("el-table-column",{attrs:{prop:"customerName",label:"客户名称",align:"center"}}),e._v(" "),t("el-table-column",{attrs:{prop:"brandName",label:"品牌",align:"center"}}),e._v(" "),t("el-table-column",{attrs:{prop:"clothingLevelName",label:"服装类型",align:"center"}}),e._v(" "),t("el-table-column",{attrs:{prop:"name",width:"170",label:"系列名称",align:"center"}}),e._v(" "),t("el-table-column",{attrs:{prop:"createrName",label:"添加人",align:"center"}}),e._v(" "),t("el-table-column",{attrs:{prop:"deptName",label:"部门",align:"center"}}),e._v(" "),t("el-table-column",{attrs:{prop:"createTime",width:"170",label:"添加时间",align:"center"}}),e._v(" "),t("el-table-column",{attrs:{prop:"addingModeName",label:"添加方式",align:"center"}}),e._v(" "),t("el-table-column",{attrs:{prop:"stateName",label:"状态",align:"center"}})],1)],1),e._v(" "),t("div",{staticClass:"block"},[t("el-pagination",{attrs:{"current-page":e.pagination.currentPage,"page-sizes":e.pagination.pageSizes,"page-size":e.pagination.pageSize,layout:"total, sizes, prev, pager, next, jumper",total:e.pagination.total},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange,"update:currentPage":function(a){e.$set(e.pagination,"currentPage",a)}}})],1)])],1)},staticRenderFns:[]}}});
//# sourceMappingURL=21.063209fdd213eb894ae5.js.map