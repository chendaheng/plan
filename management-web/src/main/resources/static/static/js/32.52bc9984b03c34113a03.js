webpackJsonp([32],{133:function(e,t,a){function n(e){a(461)}var i=a(37)(a(286),a(539),n,"data-v-5e93ac86",null);e.exports=i.exports},286:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default={data:function(){return{viewname:"first",searchInput:"",tableData:[],selectionData:[],multipleSelection:[],editInfoId:"",editInfoDescription:"",editInfoName:"",editInfoCode:"",editInfoDepart:"",editInfoDepartId:"",tmpeditInfoDepartName:"",addInfoDescription:"",addInfoName:"",addInfoCode:"",addInfoDepart:"",newCardShowFlag:!1,editCardShowFlag:!1}},created:function(){var e=this;this.$axios.get(window.$config.HOST+"/baseInfoManagement/getProduct",{params:{name:null}}).then(function(t){e.tableData=t.data,e.tableData.forEach(function(t){e.selectionData.push({id:t.deptName,name:t.deptName})})}).catch(function(t){e.$message.error("产品信息搜索失败!"),e.tableData=[{id:453453,name:"nike",number:"nk",description:"知名产品",departmentId:"47853453",deptName:"部门1"},{id:875343,name:"addidas",number:"ad",description:"次级产品",departmentId:"7531436",deptName:"部门2"},{id:68143,name:"newbalance",number:"nb",description:"国际产品",departmentId:"986312",deptName:"部门3"},{id:984531,name:"阿赛克斯",number:"asics",description:"日本产品",departmentId:"89753413",deptName:"部门4"}],e.tableData.forEach(function(t){e.selectionData.push({id:t.deptName,name:t.deptName})})})},methods:{handleTabClick:function(e,t){console.log(e,t)},toggleSelection:function(e){var t=this;e?e.forEach(function(e){t.$refs.multipleTable.toggleRowSelection(e)}):this.$refs.multipleTable.clearSelection()},handleSelectionChange:function(e){this.multipleSelection=e},handleSearchClick:function(e){var t=this,a={name:null};e||(a={name:""===this.searchInput?null:this.searchInput}),console.log("搜索"+this.searchInput),this.$axios.get(window.$config.HOST+"/baseInfoManagement/getProduct",{params:a}).then(function(e){t.tableData=e.data}).catch(function(e){t.$message.error("产品信息搜索失败!"),t.tableData=[{id:875343,name:"addidas",number:"ad",description:"次级产品",departmentId:"7531436",deptName:"部门2"},{id:68143,name:"newbalance",number:"nb",description:"国际产品",departmentId:"986312",deptName:"部门3"},{id:984531,name:"阿赛克斯",number:"asics",description:"日本产品",departmentId:"89753413",deptName:"部门4"}]})},handleNewInfoClick:function(){this.newCardShowFlag=!0,this.viewname="second",console.log(this.viewname)},handleEditInfoClick:function(){return 0===this.multipleSelection.length?void this.$message({message:"请选择一个产品信息",type:"warning"}):this.multipleSelection.length>1?void this.$message({message:"只能选择一个信息进行编辑",type:"warning"}):(this.editCardShowFlag=!0,console.log(this.multipleSelection[0]),this.editInfoName=this.multipleSelection[0].name,this.editInfoCode=this.multipleSelection[0].number,this.editInfoDepart=this.multipleSelection[0].deptName,this.editInfoDepartId=this.multipleSelection[0].departmentId,this.tmpeditInfoDepartName=this.multipleSelection[0].deptName,this.editInfoDescription=this.multipleSelection[0].description,this.editInfoId=this.multipleSelection[0].id,void(this.viewname="third"))},handleDeleteInfoClick:function(){var e=this;0===this.multipleSelection.length&&this.$message({message:"至少选择一个产品",type:"warning"}),this.multipleSelection.forEach(function(t){e.$axios.delete(window.$config.HOST+"/baseInfoManagement/deleteProduct",{params:{id:t.id}}).then(function(a){a.data<0&&(console.log(t.name+"删除失败"),e.$message.error(t.name+"删除失败"));var n=e.tableData.indexOf(t);e.tableData.splice(n,1)}).catch(function(a){console.log(t.name+"删除失败"),e.$message.error(t.name+"删除失败")})})},handleNewSaveClick:function(){var e=this,t={number:""===this.addInfoCode?null:this.addInfoCode,name:""===this.addInfoName?null:this.addInfoName,description:""===this.addInfoDescription?null:this.addInfoDescription,deptName:""===this.addInfoDepart?null:this.addInfoDepart};console.log(t),this.$axios.post(window.$config.HOST+"/baseInfoManagement/addProduct",t).then(function(t){if(t.data<0)return console.log("后台添加失败"),void e.$message.error("添加失败!");e.$message({message:"保存成功!",type:"success"}),e.handleSearchClick(!0)}).catch(function(t){e.$message.error("添加失败!"),e.handleSearchClick(!0)}),this.newCardShowFlag=!1,this.viewname="first",this.addInfoName="",this.addInfoDescription="",this.addInfoDepart=""},handleNewCancelClick:function(){this.newCardShowFlag=!1,this.viewname="first",this.$message({message:"取消新增!",type:"info"})},handleEditSaveClick:function(){var e=this,t=this.editInfoDepart,a={id:this.editInfoId,number:""===this.editInfoCode?null:this.editInfoCode,name:""===this.editInfoName?null:this.editInfoName,description:""===this.editInfoDescription?null:this.editInfoDescription,deptName:""===t?null:t};console.log(a),this.$axios.post(window.$config.HOST+"/baseInfoManagement/updateProduct",a).then(function(t){if(t.data<0)return void e.$message.error("编辑失败!");e.$message({message:"编辑成功!",type:"success"}),e.handleSearchClick(!0)}).catch(function(t){e.$message.error("编辑失败!"),e.handleSearchClick(!0)}),this.editInfoName="",this.editInfoCode="",this.editInfoDepart="",this.editInfoDepartId="",this.tmpeditInfoDepartName="",this.editInfoDescription="",this.editInfoId="",this.editCardShowFlag=!1,this.viewname="first"},handleEditCancelClick:function(){this.editCardShowFlag=!1,this.viewname="first",this.$message({message:"取消编辑!",type:"info"})}}}},412:function(e,t,a){t=e.exports=a(123)(!0),t.push([e.i,".box-card[data-v-5e93ac86]{min-width:1500px;margin:20px 50px;padding:0 20px}.containerHeaderDiv2[data-v-5e93ac86]{display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-orient:horizontal;-webkit-box-direction:reverse;-ms-flex-direction:row-reverse;flex-direction:row-reverse;min-width:500px}.containerHeaderDiv2 .nameInput[data-v-5e93ac86]{min-width:100px;max-width:200px}.containerHeaderDiv2 .inputTag[data-v-5e93ac86]{font-size:18px;line-height:40px;min-width:90px}.inputCombine[data-v-5e93ac86]{margin-top:10px;display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-orient:horizontal;-webkit-box-direction:normal;-ms-flex-direction:row;flex-direction:row;min-width:250px;max-width:500px}.inputCombine .inputTag[data-v-5e93ac86]{font-size:18px;line-height:40px;min-width:90px}.secondButtonDiv[data-v-5e93ac86]{margin-top:20px;min-width:250px;max-width:500px}.secondButtonDiv .save[data-v-5e93ac86]{margin-left:68%}","",{version:3,sources:["/home/titanxu/Desktop/planui/src/page/backEndModule/productMana.vue"],names:[],mappings:"AACA,2BACE,iBAAkB,AAClB,iBAAkB,AAClB,cAAgB,CACjB,AACD,sCACE,oBAAqB,AACrB,oBAAqB,AACrB,aAAc,AACd,8BAA+B,AAC/B,8BAA+B,AAC3B,+BAAgC,AAC5B,2BAA4B,AACpC,eAAiB,CAClB,AACD,iDACE,gBAAiB,AACjB,eAAiB,CAClB,AACD,gDACE,eAAgB,AAChB,iBAAkB,AAClB,cAAgB,CACjB,AACD,+BACE,gBAAiB,AACjB,oBAAqB,AACrB,oBAAqB,AACrB,aAAc,AACd,8BAA+B,AAC/B,6BAA8B,AAC1B,uBAAwB,AACpB,mBAAoB,AAC5B,gBAAiB,AACjB,eAAiB,CAClB,AACD,yCACE,eAAgB,AAChB,iBAAkB,AAClB,cAAgB,CACjB,AACD,kCACE,gBAAiB,AACjB,gBAAiB,AACjB,eAAiB,CAClB,AACD,wCACE,eAAiB,CAClB",file:"productMana.vue",sourcesContent:["\n.box-card[data-v-5e93ac86] {\n  min-width: 1500px;\n  margin: 20px 50px;\n  padding: 0 20px;\n}\n.containerHeaderDiv2[data-v-5e93ac86] {\n  display: -webkit-box;\n  display: -ms-flexbox;\n  display: flex;\n  -webkit-box-orient: horizontal;\n  -webkit-box-direction: reverse;\n      -ms-flex-direction: row-reverse;\n          flex-direction: row-reverse;\n  min-width: 500px;\n}\n.containerHeaderDiv2 .nameInput[data-v-5e93ac86] {\n  min-width: 100px;\n  max-width: 200px;\n}\n.containerHeaderDiv2 .inputTag[data-v-5e93ac86] {\n  font-size: 18px;\n  line-height: 40px;\n  min-width: 90px;\n}\n.inputCombine[data-v-5e93ac86] {\n  margin-top: 10px;\n  display: -webkit-box;\n  display: -ms-flexbox;\n  display: flex;\n  -webkit-box-orient: horizontal;\n  -webkit-box-direction: normal;\n      -ms-flex-direction: row;\n          flex-direction: row;\n  min-width: 250px;\n  max-width: 500px;\n}\n.inputCombine .inputTag[data-v-5e93ac86] {\n  font-size: 18px;\n  line-height: 40px;\n  min-width: 90px;\n}\n.secondButtonDiv[data-v-5e93ac86] {\n  margin-top: 20px;\n  min-width: 250px;\n  max-width: 500px;\n}\n.secondButtonDiv .save[data-v-5e93ac86] {\n  margin-left: 68%;\n}\n"],sourceRoot:""}])},461:function(e,t,a){var n=a(412);"string"==typeof n&&(n=[[e.i,n,""]]),n.locals&&(e.exports=n.locals);a(124)("ba951080",n,!0)},539:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-card",{staticClass:"box-card"},[a("el-tabs",{staticClass:"cardTab",on:{"tab-click":e.handleTabClick},model:{value:e.viewname,callback:function(t){e.viewname=t},expression:"viewname"}},[a("el-tab-pane",{staticClass:"tabPane",attrs:{label:"产品信息管理",name:"first"}},[a("el-container",{staticClass:"paneContainer"},[a("el-header",{attrs:{clas:"containerHeader"}},[a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:2}},[a("div",[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.handleNewInfoClick()}}},[e._v("新增信息")])],1)]),e._v(" "),a("el-col",{attrs:{span:2}},[a("div",[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.handleEditInfoClick()}}},[e._v("编辑信息")])],1)]),e._v(" "),a("el-col",{attrs:{span:2}},[a("div",[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.handleDeleteInfoClick()}}},[e._v("删除信息")])],1)]),e._v(" "),a("el-col",{attrs:{span:6}},[a("div",{staticClass:"containerHeaderDiv2"},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.handleSearchClick(!1)}}},[e._v("搜索产品")]),e._v(" "),a("el-input",{staticClass:"nameInput",attrs:{placeholder:"请输入产品名称"},model:{value:e.searchInput,callback:function(t){e.searchInput=t},expression:"searchInput"}}),e._v(" "),a("span",{staticClass:"inputTag"},[e._v("产品名称:")])],1)])],1),e._v(" "),a("hr")],1),e._v(" "),a("el-main",{attrs:{clas:"containerMain"}},[a("el-table",{ref:"multipleTable",staticStyle:{width:"100%"},attrs:{data:e.tableData,"tooltip-effect":"dark"},on:{"selection-change":e.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",width:"55"}}),e._v(" "),e._e(),e._v(" "),a("el-table-column",{attrs:{prop:"number",label:"产品编号",width:"120"}}),e._v(" "),a("el-table-column",{attrs:{prop:"name",label:"产品名称",width:"120"}}),e._v(" "),a("el-table-column",{attrs:{prop:"description",label:"产品描述",width:"120","show-overflow-tooltip":""}}),e._v(" "),a("el-table-column",{attrs:{prop:"deptName",label:"产品部门","show-overflow-tooltip":""}})],1),e._v(" "),a("div",{staticStyle:{"margin-top":"20px"}},[a("el-button",{attrs:{type:"info"},on:{click:function(t){e.toggleSelection()}}},[e._v("取消选择")])],1)],1)],1)],1),e._v(" "),e.newCardShowFlag?a("el-tab-pane",{attrs:{label:"新增产品信息",name:"second"}},[a("el-card",[a("div",{staticClass:"inputCombine"},[a("span",{staticClass:"inputTag"},[e._v("产品编号:")]),e._v(" "),a("el-input",{staticClass:"input",attrs:{placeholder:"请输入产品名称"},model:{value:e.addInfoCode,callback:function(t){e.addInfoCode=t},expression:"addInfoCode"}})],1),e._v(" "),a("div",{staticClass:"inputCombine"},[a("span",{staticClass:"inputTag"},[e._v("产品名称:")]),e._v(" "),a("el-input",{staticClass:"input",attrs:{placeholder:"请输入产品简称"},model:{value:e.addInfoName,callback:function(t){e.addInfoName=t},expression:"addInfoName"}})],1),e._v(" "),a("div",{staticClass:"inputCombine"},[a("span",{staticClass:"inputTag"},[e._v("产品部门:")]),e._v(" "),a("el-input",{staticClass:"input",attrs:{placeholder:"请输入产品部门"},model:{value:e.addInfoDepart,callback:function(t){e.addInfoDepart=t},expression:"addInfoDepart"}})],1),e._v(" "),a("div",{staticClass:"inputCombine"},[a("span",{staticClass:"inputTag"},[e._v("产品描述:")]),e._v(" "),a("el-input",{staticClass:"inputArea",attrs:{type:"textarea",rows:4,placeholder:"请输入产品描述"},model:{value:e.addInfoDescription,callback:function(t){e.addInfoDescription=t},expression:"addInfoDescription"}})],1),e._v(" "),a("div",{staticClass:"secondButtonDiv"},[a("el-button",{staticClass:"save",attrs:{type:"primary"},on:{click:function(t){e.handleNewSaveClick()}}},[e._v("保存")]),e._v(" "),a("el-button",{staticClass:"cancel",attrs:{type:"primary"},on:{click:function(t){e.handleNewCancelClick()}}},[e._v("取消")])],1)])],1):e._e(),e._v(" "),e.editCardShowFlag?a("el-tab-pane",{attrs:{label:"编辑产品信息",name:"third"}},[a("el-card",[a("div",{staticClass:"inputCombine"},[a("span",{staticClass:"inputTag"},[e._v("产品编号:")]),e._v(" "),a("el-input",{staticClass:"input",attrs:{placeholder:"请输入产品名称"},model:{value:e.editInfoCode,callback:function(t){e.editInfoCode=t},expression:"editInfoCode"}})],1),e._v(" "),a("div",{staticClass:"inputCombine"},[a("span",{staticClass:"inputTag"},[e._v("产品名称:")]),e._v(" "),a("el-input",{staticClass:"input",attrs:{placeholder:"请输入产品简称"},model:{value:e.editInfoName,callback:function(t){e.editInfoName=t},expression:"editInfoName"}})],1),e._v(" "),a("div",{staticClass:"inputCombine"},[a("span",{staticClass:"inputTag"},[e._v("产品部门:")]),e._v(" "),a("el-input",{staticClass:"input",attrs:{placeholder:"请输入产品部门"},model:{value:e.editInfoDepart,callback:function(t){e.editInfoDepart=t},expression:"editInfoDepart"}})],1),e._v(" "),a("div",{staticClass:"inputCombine"},[a("span",{staticClass:"inputTag"},[e._v("产品描述:")]),e._v(" "),a("el-input",{staticClass:"inputArea",attrs:{type:"textarea",rows:4,placeholder:"请输入产品描述"},model:{value:e.editInfoDescription,callback:function(t){e.editInfoDescription=t},expression:"editInfoDescription"}})],1),e._v(" "),a("div",{staticClass:"secondButtonDiv"},[a("el-button",{staticClass:"save",attrs:{type:"primary"},on:{click:function(t){e.handleEditSaveClick()}}},[e._v("保存")]),e._v(" "),a("el-button",{staticClass:"cancel",attrs:{type:"primary"},on:{click:function(t){e.handleEditCancelClick()}}},[e._v("取消")])],1)])],1):e._e()],1)],1)},staticRenderFns:[]}}});
//# sourceMappingURL=32.52bc9984b03c34113a03.js.map