webpackJsonp([27],{140:function(e,t,a){function r(e){a(457)}var n=a(37)(a(293),a(528),r,"data-v-46e31da1",null);e.exports=n.exports},293:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=a(2),n=a.n(r);t.default={data:function(){var e;return e={dateRange:"",RangeValue:"",CustomerValue:"",BrandValue:"",ClothingLevelValue:""},n()(e,"RangeValue",""),n()(e,"Data",""),n()(e,"DataStartTime",""),n()(e,"DataEndTime",""),n()(e,"dialogFormVisible",!1),n()(e,"dialogFormVisible1",!1),n()(e,"tableData",[]),n()(e,"totalTableData",[]),n()(e,"pagination",{currentPage:1,pageSizes:[5,10,20,30,50],pageSize:5,total:0}),n()(e,"searchOptions",{options:{customerNameOptions:[],brandNameOptions:[],clothingTypeOptions:[],rangeNameOption:[]}}),n()(e,"multipleSelection",[]),n()(e,"rules",{customerName:[{required:!0,message:"请选择客户名称",trigger:"change"}],brandName:[{required:!0,message:"请选择品牌",trigger:"change"}],clothingLevelName:[{required:!0,message:"请选择服装层次",trigger:"change"}],name:[{required:!0,message:"请输入系列名称",trigger:"blur"}]}),n()(e,"ruleForm",{brandName:"",brandId:"",customerName:"",customerId:"",name:"",id:"",clothingLevelId:"",clothingLevelName:"",options:{customerNameOptions:[],brandNameOptions:[],clothingTypeOptions:[],rangeNameOption:[]}}),e},created:function(){var e=this,t=this;t.$axios.get(window.$config.HOST+"/baseInfoManagement/getBrandName ",{customerId:""}).then(function(t){console.log("获得品牌信息成功了"),e.searchOptions.options.brandNameOptions=t.data}).catch(function(t){e.$message({message:"获取品牌信息失败",type:"error"})}),t.$axios.get(window.$config.HOST+"/infoManagement/getRangeName",{params:{brandId:""}}).then(function(t){console.log("获得系列信息成功了"),e.searchOptions.options.rangeNameOption=t.data}).catch(function(t){console.log("失败了"),e.$message({message:"获取系列信息失败",type:"error"})}),t.$axios.get(window.$config.HOST+"/baseInfoManagement/getCustomerName").then(function(t){console.log("获得顾客信息成功了");var a=t.data;e.searchOptions.options.customerNameOptions=a,e.ruleForm.options.customerNameOptions=e.searchOptions.options.customerNameOptions,console.log(t.data)}).catch(function(t){e.$message({message:"获取顾客信息失败",type:"error"})}),t.$axios.get(window.$config.HOST+"/baseInfoManagement/getClothingLevelName").then(function(t){console.log("获得服装层次信息成功了");var a=t.data;e.searchOptions.options.clothingTypeOptions=a,e.ruleForm.options.clothingTypeOptions=e.searchOptions.options.clothingTypeOptions}).catch(function(t){e.$message({message:"获取服装层次失败",type:"error"})}),this.$axios.post(window.$config.HOST+"/infoManagement/getRangeList",{customerId:"",brandId:"",id:"",clothingLevelId:"",startDate:"",endDate:""}).then(function(t){console.log("获得搜索列表成功了"),e.totalTableData=t.data,e.totalTableData.forEach(function(e){1===e.addingMode?e.addingModeName="手动":e.addingModeName="导入",1===e.state?e.stateName="已制定":2===e.state?e.stateName="已提交":3===e.state?e.stateName="被驳回":4===e.state?e.stateName="已审核":5===e.state?e.stateName="已下发":6===e.state&&(e.stateName="已删除");var t=new Date(e.createTime),a=t.toLocaleString();e.createTime=a}),e.pagination.total=e.totalTableData.length;var a=(e.pagination.currentPage-1)*e.pagination.pageSize,r=a+e.pagination.pageSize>e.pagination.total-1?-1:a+e.pagination.pageSize;e.tableData=e.totalTableData.slice(a,r)}).catch(function(t){e.$message({message:"获取搜索结果失败",type:"error"})})},methods:{clientSelect2:function(){var e=this;this.ruleForm.brandName="";var t={customerId:this.ruleForm.customerName};console.log(t),this.$axios.get(window.$config.HOST+"/baseInfoManagement/getBrandName",{params:t}).then(function(t){console.log(t.data),e.ruleForm.options.brandNameOptions=t.data}).catch(function(t){e.$message({message:"获取品牌信息失败",type:"error"})})},changeDate:function(e){if(e){var t=e.getFullYear(),a=e.getMonth()+1;a=a<10?"0"+a:a;var r=e.getDate();r=r<10?"0"+r:r;var n=(e.getHours(),e.getMinutes());n=n<10?"0"+n:n;var o=e.getSeconds();return o=n<10?"0"+o:o,t+"-"+a+"-"+r}return""},handleSizeChange:function(e){this.pagination.pageSize=e,console.log("每页 "+e+" 条"),this.pagination.currentPage=1,this.handleSearch()},handleCurrentChange:function(e){console.log("当前页: "+e),this.pagination.currentPage=e,this.handleSearch()},changeCheckBoxFun:function(e){this.multipleSelection=e},handleSearch:function(){var e=this,t=void 0,a=void 0;void 0==this.dateRange?(t="",a=""):(t=this.changeDate(this.dateRange[0]),a=this.changeDate(this.dateRange[1]));var r={customerId:""===this.CustomerValue?null:this.CustomerValue,brandId:""===this.BrandValue?null:this.BrandValue,id:""===this.RangeValue?null:this.RangeValue,clothingLevelId:""===this.ClothingLevelValue?null:this.ClothingLevelValue,dataRange:this.dataRange};console.log(r),this.$axios.post(window.$config.HOST+"/infoManagement/getRangeList",{customerId:""===this.CustomerValue?null:this.CustomerValue,brandId:""===this.BrandValue?null:this.BrandValue,id:""===this.RangeValue?null:this.RangeValue,clothingLevelId:""===this.ClothingLevelValue?null:this.ClothingLevelValue,startDate:t,endDate:a}).then(function(t){e.totalTableData=t.data,e.totalTableData.forEach(function(e){1===e.addingMode?e.addingModeName="手动":e.addingModeName="导入",1===e.state?e.stateName="已制定":2===e.state?e.stateName="已提交":3===e.state?e.stateName="被驳回":4===e.state?e.stateName="已审核":5===e.state?e.stateName="已下发":6===e.state&&(e.stateName="已删除");var t=new Date(e.createTime),a=t.toLocaleString();e.createTime=a}),e.pagination.total=e.totalTableData.length;var a=(e.pagination.currentPage-1)*e.pagination.pageSize,r=a+e.pagination.pageSize>e.pagination.total?e.pagination.total:a+e.pagination.pageSize;e.tableData=e.totalTableData.slice(a,r)}).catch(function(t){e.$message({message:"搜索失败",type:"error"})})},addRange:function(){console.log("添加系列按钮点击"),this.dialogFormVisible=!0},importRange:function(){var e=this;console.log("批量导入按钮点击"),e.$router.push({path:"/range/rangeImport"})},deleteRange:function(){var e=this,t=this;0===t.multipleSelection.length?this.$message({message:"请选择要删除的系列数据",type:"warning"}):t.multipleSelection.length>=1&&(console.log("有"+t.multipleSelection.length+"条数据被选中"),this.$confirm("删除所选的"+t.multipleSelection.length+"条系列信息, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){e.multipleSelection.forEach(function(t){console.log(t.id);var a={id:t.id};e.$axios.delete(window.$config.HOST+"/infoManagement/deleteRange",{params:a}).then(function(t){e.handleSearch(),t.data<0?e.$message({message:"删除失败",type:"error"}):e.$message({message:"删除成功",type:"success"})}).catch(function(t){e.handleSearch(),e.$message({message:"删除失败",type:"error"})})})}).catch(function(){e.handleSearch(),e.$message({type:"info",message:"已取消删除"})}))},changeRangeData:function(e){var t=this;this.$axios.get(window.$config.HOST+"/baseInfoManagement/getBrandName",{params:{customerId:e.customerId}}).then(function(e){console.log(e),t.ruleForm.options.brandNameOptions=e.data}).catch(function(e){t.$message({message:"获取品牌信息失败",type:"error"})}),this.ruleForm.firstCustomerName=e.customerName,this.ruleForm.firstBrandName=e.brandName,this.ruleForm.firstRangeName=e.name,this.ruleForm.firstClothingLevel=e.clothingLevelName,this.ruleForm.id=e.id,this.ruleForm.number=e.number,this.ruleForm.name=e.name,this.ruleForm.customerId=e.customerId,this.ruleForm.customerName=e.customerName,this.ruleForm.brandId=e.brandId,this.ruleForm.brandName=e.brandName,this.ruleForm.clothingLevelId=e.clothingLevelId,this.ruleForm.clothingLevelName=e.clothingLevelName,this.ruleForm.createrName=e.createrName,this.ruleForm.styleQuantity=e.styleQuantity,this.ruleForm.deptName=e.deptName,this.ruleForm.createTime=e.createTime,this.ruleForm.addingMode=e.addingMode,this.ruleForm.state=e.state,this.ruleForm.note=e.note,this.ruleForm.havePlan=e.havePlan,this.dialogFormVisible1=!0},deleteRangeData:function(e,t){var a=this;console.log("点击了本行的删除"),console.log("当前row=",e.rangeNumber);var r={id:e.id};this.$confirm("是否确认删除该系列？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){a.$axios.delete(window.$config.HOST+"/infoManagement/deleteRange",{params:r}).then(function(e){a.handleSearch(),e.data<0?a.$message({message:"删除失败",type:"error"}):a.$message({message:"删除成功",type:"success"})}).catch(function(e){a.handleSearch(),a.$message({message:"删除2失败",type:"error"})})}).catch(function(){a.$message({message:"删除3失败",type:"error"})})},submitForm:function(e){var t=this;this.$refs[e].validate(function(e){e?(t.$axios.post(window.$config.HOST+"/infoManagement/addRange",{name:""===t.ruleForm.name?null:t.ruleForm.name,customerId:""===t.ruleForm.customerName?null:t.ruleForm.customerName,brandId:""===t.ruleForm.brandName?null:t.ruleForm.brandName,clothingLevelId:""===t.ruleForm.clothingLevelName?null:t.ruleForm.clothingLevelName,note:""===t.ruleForm.note?null:t.ruleForm.note}).then(function(e){e.data<0?t.$message({message:"添加失败",type:"warning"}):(t.handleSearch(),t.ruleForm.id="",t.ruleForm.number="",t.ruleForm.name="",t.ruleForm.customerId="",t.ruleForm.customerName="",t.ruleForm.brandId="",t.ruleForm.brandName="",t.ruleForm.clothingLevelId="",t.ruleForm.clothingLevelName="",t.ruleForm.createrName="",t.ruleForm.styleQuantity="",t.ruleForm.deptName="",t.ruleForm.createTime="",t.ruleForm.addingMode="",t.ruleForm.state="",t.ruleForm.note="",t.ruleForm.havePlan="",t.dialogFormVisible=!1,t.$message({message:"添加成功",type:"success"}))}).catch(function(e){t.handleSearch(),t.$message({message:"添加2失败",type:"error"})}),console.log("现在要添加啦")):t.$message({message:"请填写必须填写的项！",type:"error"})})},submitForm1:function(e){var t=this;this.$refs[e].validate(function(e){if(e){t.ruleForm.firstCustomerName!=t.ruleForm.customerName&&(t.ruleForm.customerId=t.ruleForm.customerName),t.ruleForm.firstBrandName!=t.ruleForm.brandName&&(t.ruleForm.brandId=t.ruleForm.brandName),t.ruleForm.firstClothingLevel!=t.ruleForm.clothingLevelName&&(t.ruleForm.clothingLevelId=t.ruleForm.clothingLevelName);t.$axios.post(window.$config.HOST+"/infoManagement/updateRange",{id:t.ruleForm.id,name:t.ruleForm.name,brandId:t.ruleForm.brandId,clothingLevelId:t.ruleForm.clothingLevelId,note:t.ruleForm.note}).then(function(e){t.handleSearch(),console.log("成功了"),e.data<0?t.$message({message:"修改失败",type:"error"}):(t.ruleForm.id="",t.ruleForm.number="",t.ruleForm.name="",t.ruleForm.customerId="",t.ruleForm.customerName="",t.ruleForm.brandId="",t.ruleForm.brandName="",t.ruleForm.clothingLevelId="",t.ruleForm.clothingLevelName="",t.ruleForm.createrName="",t.ruleForm.styleQuantity="",t.ruleForm.deptName="",t.ruleForm.createTime="",t.ruleForm.addingMode="",t.ruleForm.state="",t.ruleForm.note="",t.ruleForm.havePlan="",t.ruleForm.options.brandNameOptions="",t.ruleForm.options.rangeNameOption="",t.dialogFormVisible1=!1,t.handleSearch(),t.$message({message:"修改成功",type:"success"}))}).catch(function(e){t.handleSearch(),t.$message({message:"修改失败!",type:"error"})})}else t.$message({message:"修改失败!",type:"error"})})},cancel:function(){console.log("取消按钮点击"),this.ruleForm.id="",this.ruleForm.number="",this.ruleForm.name="",this.ruleForm.customerId="",this.ruleForm.customerName="",this.ruleForm.brandId="",this.ruleForm.brandName="",this.ruleForm.clothingLevelId="",this.ruleForm.clothingLevelName="",this.ruleForm.createrName="",this.ruleForm.styleQuantity="",this.ruleForm.deptName="",this.ruleForm.createTime="",this.ruleForm.addingMode="",this.ruleForm.state="",this.ruleForm.note="",this.ruleForm.havePlan="",this.ruleForm.options.brandNameOptions="",this.ruleForm.options.rangeNameOption="",this.dialogFormVisible=!1,this.dialogFormVisible1=!1}}}},408:function(e,t,a){t=e.exports=a(123)(!0),t.push([e.i,".box-card[data-v-46e31da1]{margin:20px 50px;padding:0 20px}.box-card .bar[data-v-46e31da1]{display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-orient:horizontal;-webkit-box-direction:normal;-ms-flex-direction:row;flex-direction:row;-webkit-box-align:center;-ms-flex-align:center;align-items:center;width:100%}.box-card .bar .title[data-v-46e31da1]{font-size:14px;min-width:75px;text-align:center}.box-card .bar .el-input[data-v-46e31da1],.box-card .bar .el-select[data-v-46e31da1]{width:300px;min-width:75px}.box-card .block[data-v-46e31da1]{padding:30px 0;text-align:center}","",{version:3,sources:["/home/titanxu/Desktop/planui/src/page/infoManagement/range/rangeManagement.vue"],names:[],mappings:"AACA,2BACE,iBAAkB,AAClB,cAAgB,CACjB,AACD,gCACE,oBAAqB,AACrB,oBAAqB,AACrB,aAAc,AACd,8BAA+B,AAC/B,6BAA8B,AAC1B,uBAAwB,AACpB,mBAAoB,AAC5B,yBAA0B,AACtB,sBAAuB,AACnB,mBAAoB,AAC5B,UAAY,CACb,AACD,uCACE,eAAgB,AAChB,eAAgB,AAChB,iBAAmB,CACpB,AAKD,qFAHE,YAAa,AACb,cAAgB,CAKjB,AACD,kCACE,eAAgB,AAChB,iBAAmB,CACpB",file:"rangeManagement.vue",sourcesContent:["\n.box-card[data-v-46e31da1] {\n  margin: 20px 50px;\n  padding: 0 20px;\n}\n.box-card .bar[data-v-46e31da1] {\n  display: -webkit-box;\n  display: -ms-flexbox;\n  display: flex;\n  -webkit-box-orient: horizontal;\n  -webkit-box-direction: normal;\n      -ms-flex-direction: row;\n          flex-direction: row;\n  -webkit-box-align: center;\n      -ms-flex-align: center;\n          align-items: center;\n  width: 100%;\n}\n.box-card .bar .title[data-v-46e31da1] {\n  font-size: 14px;\n  min-width: 75px;\n  text-align: center;\n}\n.box-card .bar .el-input[data-v-46e31da1] {\n  width: 300px;\n  min-width: 75px;\n}\n.box-card .bar .el-select[data-v-46e31da1] {\n  width: 300px;\n  min-width: 75px;\n}\n.box-card .block[data-v-46e31da1] {\n  padding: 30px 0;\n  text-align: center;\n}\n"],sourceRoot:""}])},457:function(e,t,a){var r=a(408);"string"==typeof r&&(r=[[e.i,r,""]]),r.locals&&(e.exports=r.locals);a(124)("40491329",r,!0)},528:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"body"},[a("el-card",{staticClass:"box-card"},[a("el-row",{staticStyle:{"margin-top":"5px"},attrs:{gutter:20}},[a("el-col",{attrs:{span:6}},[a("div",{staticClass:"bar"},[a("div",{staticClass:"title"},[e._v("客户名称")]),e._v(" "),a("el-select",{attrs:{clearable:!0},model:{value:e.CustomerValue,callback:function(t){e.CustomerValue=t},expression:"CustomerValue"}},e._l(e.searchOptions.options.customerNameOptions,function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}))],1)]),e._v(" "),a("el-col",{attrs:{span:6}},[a("div",{staticClass:"bar"},[a("div",{staticClass:"title"},[e._v("品牌")]),e._v(" "),a("el-select",{attrs:{clearable:!0},model:{value:e.BrandValue,callback:function(t){e.BrandValue=t},expression:"BrandValue"}},e._l(e.searchOptions.options.brandNameOptions,function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}))],1)]),e._v(" "),a("el-col",{attrs:{span:6}},[a("div",{staticClass:"bar"},[a("div",{staticClass:"title"},[e._v("系列名称")]),e._v(" "),a("el-select",{attrs:{clearable:!0},model:{value:e.RangeValue,callback:function(t){e.RangeValue=t},expression:"RangeValue"}},e._l(e.searchOptions.options.rangeNameOption,function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}))],1)]),e._v(" "),a("el-col",{attrs:{span:6}},[a("div",{staticClass:"bar"},[a("div",{staticClass:"title"},[e._v("服装层次")]),e._v(" "),a("el-select",{attrs:{clearable:!0},model:{value:e.ClothingLevelValue,callback:function(t){e.ClothingLevelValue=t},expression:"ClothingLevelValue"}},e._l(e.searchOptions.options.clothingTypeOptions,function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}))],1)])],1),e._v(" "),a("el-row",{staticStyle:{"margin-top":"30px","margin-bottom":"5px"},attrs:{gutter:20}},[a("el-col",{attrs:{span:12}},[a("div",{staticClass:"bar"},[a("div",{staticClass:"title"},[e._v("添加时间")]),e._v(" "),a("el-date-picker",{staticClass:"inputBar",attrs:{type:"daterange","range-separator":"至","start-placeholde":"开始日期","end-placeholde":"结束日期",clearable:!0},model:{value:e.dateRange,callback:function(t){e.dateRange=t},expression:"dateRange"}})],1)]),e._v(" "),a("el-col",{attrs:{span:2}},[a("el-button",{attrs:{type:"primary",icon:"el-icon-search"},on:{click:e.handleSearch}},[e._v("搜索")])],1)],1)],1),e._v(" "),a("el-card",{staticClass:"box-card"},[a("div",{staticClass:"table"},[a("el-row",{attrs:{gutter:10}},[a("el-col",{attrs:{span:3}},[a("el-button",{attrs:{type:"primary"},on:{click:e.addRange}},[e._v("添加系列")])],1),e._v(" "),a("el-col",{attrs:{span:3}},[a("el-button",{attrs:{type:"primary"},on:{click:e.importRange}},[e._v("批量导入")])],1),e._v(" "),a("el-col",{attrs:{span:3}},[a("el-button",{attrs:{type:"primary"},on:{click:e.deleteRange}},[e._v("删除系列")])],1)],1),e._v(" "),a("el-table",{staticStyle:{width:"100%","margin-top":"20px"},attrs:{data:e.tableData,"max-height":"400",border:"",stripe:!0,"highlight-current-row":!0},on:{"selection-change":e.changeCheckBoxFun}},[a("el-table-column",{attrs:{type:"selection",width:"50",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{type:"index",label:"序号",width:"50",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"number",width:"130",label:"系列编号",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"customerName",width:"120",label:"客户名称",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"brandName",label:"品牌",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"clothingLevelName",label:"服装类型",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"name",width:"170",label:"系列名称",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"createrName",label:"添加人",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"deptName",label:"部门",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"createTime",width:"170",label:"添加时间",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"addingModeName",label:"添加方式",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{prop:"stateName",label:"状态",align:"center"}}),e._v(" "),a("el-table-column",{attrs:{label:"操作",width:"150","min-width":"100",align:"center",fixed:"right"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){e.changeRangeData(t.row)}}},[e._v("修改")]),e._v(" "),a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){e.deleteRangeData(t.row,t.index)}}},[e._v("删除")])]}}])})],1),e._v(" "),a("div",{staticClass:"block"},[a("el-pagination",{attrs:{"current-page":e.pagination.currentPage,"page-sizes":e.pagination.pageSizes,"page-size":e.pagination.pageSize,layout:"total, sizes, prev, pager, next, jumper",total:e.pagination.total},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange,"update:currentPage":function(t){e.$set(e.pagination,"currentPage",t)}}})],1)],1)]),e._v(" "),a("el-dialog",{attrs:{modal:!1,title:"系列信息",visible:e.dialogFormVisible},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[a("el-form",{ref:"ruleForm",staticClass:"demo-ruleForm",attrs:{model:e.ruleForm,rules:e.rules,"label-width":"100px"}},[a("el-row",{staticStyle:{"margin-top":"5px"},attrs:{gutter:20}},[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"客户名称",prop:"customerName",placeholder:"请选择客户名称"}},[a("el-select",{on:{change:e.clientSelect2},model:{value:e.ruleForm.customerName,callback:function(t){e.$set(e.ruleForm,"customerName",t)},expression:"ruleForm.customerName"}},e._l(e.ruleForm.options.customerNameOptions,function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}))],1)],1),e._v(" "),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"品牌名称",prop:"brandName"}},[a("el-select",{model:{value:e.ruleForm.brandName,callback:function(t){e.$set(e.ruleForm,"brandName",t)},expression:"ruleForm.brandName"}},e._l(e.ruleForm.options.brandNameOptions,function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}))],1)],1),e._v(" "),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"系列名称",prop:"name"}},[a("el-input",{attrs:{clearable:"",placeholder:"请输入"},model:{value:e.ruleForm.name,callback:function(t){e.$set(e.ruleForm,"name",t)},expression:"ruleForm.name"}})],1)],1)],1),e._v(" "),a("el-row",{staticStyle:{"margin-top":"30px","margin-bottom":"5px"},attrs:{gutter:20}},[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"服装层次",prop:"clothingLevelName"}},[a("el-select",{model:{value:e.ruleForm.clothingLevelName,callback:function(t){e.$set(e.ruleForm,"clothingLevelName",t)},expression:"ruleForm.clothingLevelName "}},e._l(e.ruleForm.options.clothingTypeOptions,function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}))],1)],1)],1),e._v(" "),a("el-row",{staticStyle:{"margin-top":"30px","margin-bottom":"5px"},attrs:{gutter:10}},[a("el-col",{attrs:{span:24}},[a("el-form-item",{attrs:{label:"系列备注"}},[a("el-input",{attrs:{type:"textarea",rows:3,placeholder:"请输入"},model:{value:e.ruleForm.note,callback:function(t){e.$set(e.ruleForm,"note",t)},expression:"ruleForm.note "}})],1)],1)],1),e._v(" "),a("el-row",{staticStyle:{margin:"50px 0 10px 0"}},[a("el-col",{attrs:{span:3,offset:10}},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.submitForm("ruleForm")}}},[e._v("保存")])],1),e._v(" "),a("el-col",{attrs:{span:3}},[a("el-button",{attrs:{type:"info"},on:{click:e.cancel}},[e._v("取消")])],1)],1)],1)],1),e._v(" "),a("el-dialog",{attrs:{modal:!1,title:"系列信息",visible:e.dialogFormVisible1},on:{"update:visible":function(t){e.dialogFormVisible1=t}}},[a("el-form",{ref:"ruleForm",staticClass:"demo-ruleForm",attrs:{model:e.ruleForm,rules:e.rules,"label-width":"100px"}},[a("el-row",{staticStyle:{"margin-top":"5px"},attrs:{gutter:20}},[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"客户名称",placeholder:"请选择客户名称",prop:"customerName"}},[a("el-select",{on:{change:e.clientSelect2},model:{value:e.ruleForm.customerName,callback:function(t){e.$set(e.ruleForm,"customerName",t)},expression:"ruleForm.customerName "}},e._l(e.ruleForm.options.customerNameOptions,function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}))],1)],1),e._v(" "),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"品牌名称",prop:"brandName"}},[a("el-select",{model:{value:e.ruleForm.brandName,callback:function(t){e.$set(e.ruleForm,"brandName",t)},expression:"ruleForm.brandName "}},e._l(e.ruleForm.options.brandNameOptions,function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}))],1)],1),e._v(" "),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"系列名称",prop:"name"}},[a("el-input",{attrs:{clearable:"",placeholder:"请输入"},model:{value:e.ruleForm.name,callback:function(t){e.$set(e.ruleForm,"name",t)},expression:"ruleForm.name"}})],1)],1)],1),e._v(" "),a("el-row",{staticStyle:{"margin-top":"30px","margin-bottom":"5px"},attrs:{gutter:20}},[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"服装层次",prop:"clothingLevelName"}},[a("el-select",{model:{value:e.ruleForm.clothingLevelName,callback:function(t){e.$set(e.ruleForm,"clothingLevelName",t)},expression:"ruleForm.clothingLevelName "}},e._l(e.ruleForm.options.clothingTypeOptions,function(e){return a("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}))],1)],1)],1),e._v(" "),a("el-row",{staticStyle:{"margin-top":"30px","margin-bottom":"5px"},attrs:{gutter:10}},[a("el-col",{attrs:{span:24}},[a("el-form-item",{attrs:{label:"系列备注"}},[a("el-input",{attrs:{type:"textarea",rows:3,placeholder:"请输入"},model:{value:e.ruleForm.note,callback:function(t){e.$set(e.ruleForm,"note",t)},expression:"ruleForm.note"}})],1)],1)],1),e._v(" "),a("el-row",{staticStyle:{margin:"50px 0 10px 0"}},[a("el-col",{attrs:{span:3,offset:10}},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.submitForm1("ruleForm")}}},[e._v("保存")])],1),e._v(" "),a("el-col",{attrs:{span:3}},[a("el-button",{attrs:{type:"info"},on:{click:e.cancel}},[e._v("取消")])],1)],1)],1)],1)],1)},staticRenderFns:[]}}});
//# sourceMappingURL=27.30a6c2cb9f41a80a8514.js.map