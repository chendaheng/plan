webpackJsonp([26],{141:function(t,e,a){function n(t){a(453)}var o=a(37)(a(294),a(524),n,"data-v-404b1cc6",null);t.exports=o.exports},294:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0}),e.default={data:function(){return{styleIdList:[],data:{tableData:[]},options:{customerNameOptions:[],brandNameOptions:[],clothingTypeOptions:[],rangeNameTypeOptions:[],styleGroupNameTypeOptions:[]},controlData:{storeDisabled:!1}}},created:function(){var t=this,e=this;console.log("进入绑定款式组页面");var a={};a=e.$route.query,a.hasOwnProperty("bindData")&&(console.log("传过来的 绑定数据为"+a.bindData),e.data.tableData=a.bindData),this.$axios.post(window.$config.HOST+"/infoManagement/getStyleGroupList",{customerId:null,brandId:null,rangeId:null,clothingLevelId:null,id:null,startDate:null,endDate:null}).then(function(e){console.log(e.data),t.options.styleGroupNameTypeOptions=e.data}).catch(function(t){console.log("拿款式组出错")})},methods:{store:function(){var t=this,e=this,a=void 0,n=void 0;this.options.styleGroupNameTypeOptions.forEach(function(e){e.id===t.data.styleGroupName&&(a=e.name,n=e.number)}),e.data.tableData.forEach(function(e){t.styleIdList.push({styleGroupId:t.data.styleGroupName,styleGroupNumber:n,styleGroupName:a,styleNumber:e.number}),console.log(t.styleIdList)});var o=this.styleIdList;console.log(o),this.$axios.post(window.$config.HOST+"/infoManagement/bindStyleGroup",o).then(function(a){var n=a.data;n>=0?n===t.styleIdList.length?(console.log(n),t.$message({message:"绑定成功!",type:"success"}),e.$router.push({path:"/style/styleManagement"})):t.$message({message:t.styleIdList.length-n+"条数据未添加成功",type:"warning"}):t.$message({message:"绑定失败",type:"warning"})}).catch(function(e){t.$message({message:"绑定款式失败",type:"warning"})})},cancel:function(){var t=this;console.log("取消按钮点击"),t.$router.push({path:"/style/styleManagement"})}}}},404:function(t,e,a){e=t.exports=a(123)(!0),e.push([t.i,".box-card[data-v-404b1cc6]{margin:20px 50px;padding:0 20px}.box-card .inputBox[data-v-404b1cc6]{display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-orient:horizontal;-webkit-box-direction:normal;-ms-flex-direction:row;flex-direction:row;-webkit-box-align:center;-ms-flex-align:center;align-items:center;width:100%}.box-card .inputBox .label[data-v-404b1cc6]{font-size:14px;min-width:75px;text-align:center}.box-card .inputBox .el-input[data-v-404b1cc6],.box-card .inputBox .el-select[data-v-404b1cc6]{width:300px;min-width:75px}.box-card .block[data-v-404b1cc6]{padding:30px 0;text-align:center}","",{version:3,sources:["/home/titanxu/Desktop/planui/src/page/infoManagement/style/bindStyleGroup.vue"],names:[],mappings:"AACA,2BACE,iBAAkB,AAClB,cAAgB,CACjB,AACD,qCACE,oBAAqB,AACrB,oBAAqB,AACrB,aAAc,AACd,8BAA+B,AAC/B,6BAA8B,AAC1B,uBAAwB,AACpB,mBAAoB,AAC5B,yBAA0B,AACtB,sBAAuB,AACnB,mBAAoB,AAC5B,UAAY,CACb,AACD,4CACE,eAAgB,AAChB,eAAgB,AAChB,iBAAmB,CACpB,AAKD,+FAHE,YAAa,AACb,cAAgB,CAKjB,AACD,kCACE,eAAgB,AAChB,iBAAmB,CACpB",file:"bindStyleGroup.vue",sourcesContent:["\n.box-card[data-v-404b1cc6] {\n  margin: 20px 50px;\n  padding: 0 20px;\n}\n.box-card .inputBox[data-v-404b1cc6] {\n  display: -webkit-box;\n  display: -ms-flexbox;\n  display: flex;\n  -webkit-box-orient: horizontal;\n  -webkit-box-direction: normal;\n      -ms-flex-direction: row;\n          flex-direction: row;\n  -webkit-box-align: center;\n      -ms-flex-align: center;\n          align-items: center;\n  width: 100%;\n}\n.box-card .inputBox .label[data-v-404b1cc6] {\n  font-size: 14px;\n  min-width: 75px;\n  text-align: center;\n}\n.box-card .inputBox .el-input[data-v-404b1cc6] {\n  width: 300px;\n  min-width: 75px;\n}\n.box-card .inputBox .el-select[data-v-404b1cc6] {\n  width: 300px;\n  min-width: 75px;\n}\n.box-card .block[data-v-404b1cc6] {\n  padding: 30px 0;\n  text-align: center;\n}\n"],sourceRoot:""}])},453:function(t,e,a){var n=a(404);"string"==typeof n&&(n=[[t.i,n,""]]),n.locals&&(t.exports=n.locals);a(124)("c6f88f38",n,!0)},524:function(t,e){t.exports={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"body"},[a("el-card",{staticClass:"box-card"},[a("el-row",{staticStyle:{"margin-top":"30px","margin-bottom":"5px"},attrs:{gutter:20}},[a("el-col",{attrs:{span:8}},[a("div",{staticClass:"inputBox"},[a("div",{staticClass:"label"},[t._v("款式组名")]),t._v(" "),a("el-select",{model:{value:t.data.styleGroupName,callback:function(e){t.$set(t.data,"styleGroupName",e)},expression:"data.styleGroupName"}},t._l(t.options.styleGroupNameTypeOptions,function(t){return a("el-option",{key:t.id,attrs:{label:t.name,value:t.id}})}))],1)])],1),t._v(" "),a("el-row",{staticStyle:{margin:"20px 0 10px 0"}},[a("div",{staticClass:"label",staticStyle:{margin:"0 0 5px 0"},attrs:{align:"center"}},[t._v("已选款号")]),t._v(" "),a("el-table",{staticStyle:{width:"100%"},attrs:{data:t.data.tableData,border:""}},[a("el-table-column",{attrs:{prop:"number",label:"订单款号",align:"center"}})],1)],1),t._v(" "),a("el-row",{staticStyle:{margin:"50px 0 10px 0"}},[a("el-col",{attrs:{span:3,offset:10}},[a("el-button",{attrs:{type:"primary",disabled:t.controlData.storeDisabled},on:{click:t.store}},[t._v("保存")])],1),t._v(" "),a("el-col",{attrs:{span:3}},[a("el-button",{attrs:{type:"info"},on:{click:t.cancel}},[t._v("取消")])],1)],1)],1)],1)},staticRenderFns:[]}}});
//# sourceMappingURL=26.495ab7066fc8bbdaf5eb.js.map