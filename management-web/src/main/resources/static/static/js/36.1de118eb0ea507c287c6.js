webpackJsonp([36],{129:function(e,t,a){function i(e){a(469)}var n=a(37)(a(282),a(554),i,"data-v-7e522d28",null);e.exports=n.exports},282:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default={data:function(){return{viewname:"first",dictionCategories:[],multiCateSelection:[],selectedCateProps:[],multiplePropSelection:[],addCateName:"",addCateCode:"",editCateId:"",editCateName:"",editCateCode:"",addPropName:"",addPropCode:"",addPropCategoryId:"",editPropId:"",editPropName:"",editPropCode:"",editPropCate:"",initeditPropCateName:"",addCateShowFlag:!1,editCateShowFlag:!1,addPropShowFlag:!1,editPropShowFlag:!1}},created:function(){var e=this;this.$axios.get(window.$config.HOST+"/dictionaryManagement/getAllDictionaryCategory").then(function(t){e.dictionCategories=t.data}).catch(function(t){console.log("字典类别加载错误"),e.dictionCategories=[{id:"241234",category:"性别",code:"sex"},{id:"4234",category:"职称",code:"job"},{id:"2345234",category:"学历",code:"education"},{id:"2412764",category:"客户类型",code:"customerType"}]})},methods:{reSearchProperty:function(e){var t=this;console.log(e),this.$axios.get(window.$config.HOST+"/dictionaryManagement/getCategoryProperty",{params:{categoryId:e}}).then(function(e){t.selectedCateProps=e.data}).catch(function(e){t.$message.error("属性信息加载失败"),t.selectedCateProps=[{id:"3245123",name:"属性1",code:"faksjdk",categoryId:"54145",categoryName:"类别1"},{id:"1543",name:"属性2",code:"adsf",categoryId:"54145",categoryName:"类别1"},{id:"3245123",name:"属性3",code:"xggffh",categoryId:"54145",categoryName:"类别1"},{id:"3245123",name:"属性4",code:"ertdf ",categoryId:"54145",categoryName:"类别1"},{id:"76867",name:"属性7",code:"dfgadf",categoryId:"54145",categoryName:"类别1"}]})},reSearchCategory:function(){var e=this;console.log("再搜索"),this.$axios.get(window.$config.HOST+"/dictionaryManagement/getAllDictionaryCategory").then(function(t){e.dictionCategories=t.data}).catch(function(t){console.log("字典类别加载错误"),e.dictionCategories=[{id:"241234",category:"性别",code:"sex"},{id:"4234",category:"职称",code:"job"},{id:"2345234",category:"学历",code:"education"},{id:"241234",category:"客户类型",code:"customerType"}]})},handleViewChange:function(e,t){console.log(e,t)},handleCategSelectionChange:function(e){this.multiCateSelection=e,this.selectedCateProps=[],e.length>=1&&this.reSearchProperty(e[0].id)},handlePropSelectionChange:function(e){this.multiplePropSelection=e},handleAddCateClick:function(){this.addCateShowFlag=!0,this.viewname="second"},handleEditCateClick:function(){return 0===this.multiCateSelection.length?void alert("请选择一个字典类别!"):this.multiCateSelection.length>1?void alert("只能选择一个字典类别!"):(this.editCateId=this.multiCateSelection[0].id,this.editCateName=this.multiCateSelection[0].category,this.editCateCode=this.multiCateSelection[0].code,this.editCateShowFlag=!0,void(this.viewname="third"))},handleDeleteCateClick:function(){var e=this;0===this.multiCateSelection.length&&this.$message({message:"至少选择一个字典类别",type:"warning"}),this.multiCateSelection.forEach(function(t){console.log("删除"+t.id),e.$axios.delete(window.$config.HOST+"/dictionaryManagement/deleteDictionaryCategory",{params:{id:t.id}}).then(function(t){t.data<0?(e.$message.error("删除失败"),console.log("删除失败")):(e.$message({message:"删除成功!",type:"success"}),console.log("删除成功"),e.reSearchCategory())}).catch(function(t){e.$message.error("删除失败"),console.log("删除失败")})})},handleAddPropClick:function(){this.addPropShowFlag=!0,this.viewname="fourth"},handleEditPropClick:function(){return 0===this.multiplePropSelection.length?void alert("请选择一个类别属性!"):this.multiplePropSelection.length>1?void alert("只能选择一个类别属性!"):(this.editPropId=this.multiplePropSelection[0].id,this.editPropName=this.multiplePropSelection[0].name,this.editPropCode=this.multiplePropSelection[0].code,this.editPropCate=this.multiCateSelection[0].category,this.initeditPropCateId=this.multiplePropSelection[0].categoryId,this.initeditPropCateName=this.editPropCate,this.editPropShowFlag=!0,void(this.viewname="fifth"))},handleDeletePropClick:function(){var e=this;0===this.multiplePropSelection.length&&this.$message({message:"至少选择一个类别属性",type:"warning"}),this.multiplePropSelection.forEach(function(t){e.$axios.delete(window.$config.HOST+"/dictionaryManagement/deleteCategoryProperty",{params:{id:t.id}}).then(function(a){a.data<0?e.$message.error("删除失败"):(e.$message({message:"删除成功!",type:"success"}),e.reSearchProperty(t.categoryId))}).catch(function(t){e.$message.error("删除失败")})})},handleAddCateSaveClick:function(){var e=this,t={category:""===this.addCateName?null:this.addCateName,code:""===this.addCateCode?null:this.addCateCode};this.$axios.post(window.$config.HOST+"/dictionaryManagement/addDictionaryCategory",t).then(function(t){t.data<0?e.$message.error("添加失败"):(e.$message({message:"添加成功!",type:"success"}),e.reSearchCategory())}).catch(function(t){e.$message.error("添加失败")}),this.addCateName="",this.addCateCode="",this.addCateShowFlag=!1,this.viewname="first"},handleAddCateCancelClick:function(){this.$message({message:"取消新增!",type:"info"}),this.addCateName="",this.addCateCode="",this.addCateShowFlag=!1,this.viewname="first"},handleEditCateSaveClick:function(){var e=this,t={id:""===this.editCateId?null:this.editCateId,category:""===this.editCateName?null:this.editCateName,code:""===this.editCateCode?null:this.editCateCode};this.$axios.post(window.$config.HOST+"/dictionaryManagement/updateDictionaryCategory",t).then(function(t){t.data<0?e.$message.error("编辑失败"):(e.$message({message:"编辑成功!",type:"success"}),e.reSearchCategory())}),this.editCateId="",this.editCateName="",this.editPropCode="",this.editCateShowFlag=!1,this.viewname="first"},handleEditCateCancelClick:function(){this.$message({message:"取消编辑!",type:"info"}),this.editCateShowFlag=!1,this.viewname="first"},handleAddPropSaveClick:function(){var e=this,t={name:""===this.addPropName?null:this.addPropName,code:""===this.addPropCode?null:this.addPropCode,categoryId:""===this.addPropCategoryId?null:this.addPropCategoryId};console.log(t),this.$axios.post(window.$config.HOST+"/dictionaryManagement/addCategoryProperty",t).then(function(a){a.data<0?e.$message.error("添加失败"):(console.log("添加成功"),e.$message({message:"添加成功!",type:"success"}),e.reSearchProperty(t.categoryId))}).catch(function(t){e.$message.error("添加失败")}),this.addPropName="",this.addPropCode="",this.addPropCategoryId="",this.addPropShowFlag=!1,this.viewname="first"},handleAddPropCancelClick:function(){this.$message({message:"取消新增!",type:"info"}),this.addPropName="",this.addPropCode="",this.addPropCategoryId="",this.addPropShowFlag=!1,this.viewname="first"},handleEditPropSaveClick:function(){var e=this,t=this.editPropCate===this.initeditPropCateName?this.initeditPropCateId:this.editPropCate,a={id:""===this.editPropId?null:this.editPropId,name:""===this.editPropName?null:this.editPropName,code:""===this.editPropCode?null:this.editPropCode,categoryId:""===t?null:t};console.log(a),this.$axios.post(window.$config.HOST+"/dictionaryManagement/updateCategoryProperty",a).then(function(t){t.data<0?e.$message.error("编辑失败"):(console.log("编辑成功"),e.$message({message:"编辑成功!",type:"success"}),e.reSearchProperty(a.categoryId))}).catch(function(t){e.$message.error("编辑失败")}),this.editPropId="",this.editPropName="",this.editPropCode="",this.editPropCate="",this.initeditPropCateId="",this.initeditPropCateName="",this.editPropShowFlag=!1,this.viewname="first"},handleEditPropCancelClick:function(){this.$message({message:"取消编辑!",type:"info"}),this.editPropShowFlag=!1,this.viewname="first"}}}},420:function(e,t,a){t=e.exports=a(123)(!0),t.push([e.i,".box-card[data-v-7e522d28]{background-color:none;min-width:1500px;margin:20px 50px;padding:0 20px}.submainCard .subAside[data-v-7e522d28]{width:400px}.submainCard .subAside .containerHeaderDiv[data-v-7e522d28]{margin-top:10px}.submainCard .subAside .containerHeaderDiv .cateButton[data-v-7e522d28]{text-align:center}.submainCard .subMain[data-v-7e522d28]{margin-left:10px}.submainCard .subMain .containerHeaderDiv[data-v-7e522d28]{margin-top:10px}.submainCard .subMain .containerHeaderDiv .cateButton[data-v-7e522d28]{text-align:center}.inputCombine[data-v-7e522d28]{margin-top:10px;display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-orient:horizontal;-webkit-box-direction:normal;-ms-flex-direction:row;flex-direction:row;min-width:250px;max-width:500px}.inputCombine .inputTag[data-v-7e522d28]{font-size:18px;line-height:40px;min-width:130px}.secondButtonDiv[data-v-7e522d28]{margin-top:20px;min-width:250px;max-width:500px}.secondButtonDiv .save[data-v-7e522d28]{margin-left:68%}","",{version:3,sources:["/home/titanxu/Desktop/planui/src/page/backEndModule/dictionaryCateMana.vue"],names:[],mappings:"AACA,2BACE,sBAAuB,AACvB,iBAAkB,AAClB,iBAAkB,AAClB,cAAgB,CACjB,AACD,wCACE,WAAa,CACd,AACD,4DACE,eAAiB,CAClB,AACD,wEACE,iBAAmB,CACpB,AACD,uCACE,gBAAkB,CACnB,AACD,2DACE,eAAiB,CAClB,AACD,uEACE,iBAAmB,CACpB,AACD,+BACE,gBAAiB,AACjB,oBAAqB,AACrB,oBAAqB,AACrB,aAAc,AACd,8BAA+B,AAC/B,6BAA8B,AAC1B,uBAAwB,AACpB,mBAAoB,AAC5B,gBAAiB,AACjB,eAAiB,CAClB,AACD,yCACE,eAAgB,AAChB,iBAAkB,AAClB,eAAiB,CAClB,AACD,kCACE,gBAAiB,AACjB,gBAAiB,AACjB,eAAiB,CAClB,AACD,wCACE,eAAiB,CAClB",file:"dictionaryCateMana.vue",sourcesContent:["\n.box-card[data-v-7e522d28] {\n  background-color: none;\n  min-width: 1500px;\n  margin: 20px 50px;\n  padding: 0 20px;\n}\n.submainCard .subAside[data-v-7e522d28] {\n  width: 400px;\n}\n.submainCard .subAside .containerHeaderDiv[data-v-7e522d28] {\n  margin-top: 10px;\n}\n.submainCard .subAside .containerHeaderDiv .cateButton[data-v-7e522d28] {\n  text-align: center;\n}\n.submainCard .subMain[data-v-7e522d28] {\n  margin-left: 10px;\n}\n.submainCard .subMain .containerHeaderDiv[data-v-7e522d28] {\n  margin-top: 10px;\n}\n.submainCard .subMain .containerHeaderDiv .cateButton[data-v-7e522d28] {\n  text-align: center;\n}\n.inputCombine[data-v-7e522d28] {\n  margin-top: 10px;\n  display: -webkit-box;\n  display: -ms-flexbox;\n  display: flex;\n  -webkit-box-orient: horizontal;\n  -webkit-box-direction: normal;\n      -ms-flex-direction: row;\n          flex-direction: row;\n  min-width: 250px;\n  max-width: 500px;\n}\n.inputCombine .inputTag[data-v-7e522d28] {\n  font-size: 18px;\n  line-height: 40px;\n  min-width: 130px;\n}\n.secondButtonDiv[data-v-7e522d28] {\n  margin-top: 20px;\n  min-width: 250px;\n  max-width: 500px;\n}\n.secondButtonDiv .save[data-v-7e522d28] {\n  margin-left: 68%;\n}\n"],sourceRoot:""}])},469:function(e,t,a){var i=a(420);"string"==typeof i&&(i=[[e.i,i,""]]),i.locals&&(e.exports=i.locals);a(124)("764dadd9",i,!0)},554:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"box-card"},[a("el-tabs",{on:{"tab-click":e.handleViewChange},model:{value:e.viewname,callback:function(t){e.viewname=t},expression:"viewname"}},[a("el-tab-pane",{attrs:{label:"数据字典管理",name:"first"}},[a("el-card",{staticClass:"submainCard"},[a("el-container",[a("el-main",{staticClass:"subAside"},[a("el-container",{staticClass:"paneContainer"},[a("el-header",{attrs:{clas:"containerHeader"}},[a("div",{staticClass:"containerHeaderDiv"},[a("el-button",{staticClass:"cateButton",attrs:{type:"primary"},on:{click:function(t){e.handleAddCateClick()}}},[e._v("新增")]),e._v(" "),a("el-button",{staticClass:"cateButton",attrs:{type:"primary"},on:{click:function(t){e.handleEditCateClick()}}},[e._v("编辑")]),e._v(" "),a("el-button",{staticClass:"cateButton",attrs:{type:"primary"},on:{click:function(t){e.handleDeleteCateClick()}}},[e._v("删除")])],1),e._v(" "),a("hr")]),e._v(" "),a("el-main",{attrs:{clas:"containerMain"}},[a("el-table",{ref:"multipleTable",staticStyle:{width:"100%"},attrs:{data:e.dictionCategories,"tooltip-effect":"dark"},on:{"selection-change":e.handleCategSelectionChange}},[a("el-table-column",{attrs:{type:"selection",width:"55"}}),e._v(" "),e._e(),e._v(" "),a("el-table-column",{attrs:{prop:"category",label:"字典类别","show-overflow-tooltip":""}})],1)],1)],1)],1),e._v(" "),a("hr",{staticClass:"hr"}),e._v(" "),a("el-main",{staticClass:"subMain"},[a("el-container",{staticClass:"paneContainer"},[a("el-header",{attrs:{clas:"containerHeader"}},[a("div",{staticClass:"containerHeaderDiv"},[a("el-button",{staticClass:"cateButton",attrs:{type:"primary"},on:{click:function(t){e.handleAddPropClick()}}},[e._v("新增")]),e._v(" "),a("el-button",{staticClass:"cateButton",attrs:{type:"primary"},on:{click:function(t){e.handleEditPropClick()}}},[e._v("编辑")]),e._v(" "),a("el-button",{staticClass:"cateButton",attrs:{type:"primary"},on:{click:function(t){e.handleDeletePropClick()}}},[e._v("删除")])],1),e._v(" "),a("hr")]),e._v(" "),a("el-main",{attrs:{clas:"containerMain"}},[a("el-table",{ref:"multipleTable",staticStyle:{width:"100%"},attrs:{data:e.selectedCateProps,"tooltip-effect":"dark"},on:{"selection-change":e.handlePropSelectionChange}},[a("el-table-column",{attrs:{type:"selection",width:"55"}}),e._v(" "),e._e(),e._v(" "),a("el-table-column",{attrs:{prop:"name",label:"类别属性","show-overflow-tooltip":""}})],1)],1)],1)],1)],1)],1)],1),e._v(" "),e.addCateShowFlag?a("el-tab-pane",{attrs:{label:"新增字典类别",name:"second"}},[a("el-card",[a("div",{staticClass:"inputCombine"},[a("span",{staticClass:"inputTag"},[e._v("字典类别名称:")]),e._v(" "),a("el-input",{staticClass:"input",attrs:{placeholder:"请输入字典类别名称"},model:{value:e.addCateName,callback:function(t){e.addCateName=t},expression:"addCateName"}})],1),e._v(" "),a("div",{staticClass:"inputCombine"},[a("span",{staticClass:"inputTag"},[e._v("字典类别编码:")]),e._v(" "),a("el-input",{staticClass:"input",attrs:{placeholder:"请输入字典类别编码"},model:{value:e.addCateCode,callback:function(t){e.addCateCode=t},expression:"addCateCode"}})],1),e._v(" "),a("div",{staticClass:"secondButtonDiv"},[a("el-button",{staticClass:"save",attrs:{type:"primary"},on:{click:function(t){e.handleAddCateSaveClick()}}},[e._v("保存")]),e._v(" "),a("el-button",{staticClass:"cancel",attrs:{type:"primary"},on:{click:function(t){e.handleAddCateCancelClick()}}},[e._v("取消")])],1)])],1):e._e(),e._v(" "),e.editCateShowFlag?a("el-tab-pane",{attrs:{label:"编辑字典类别",name:"third"}},[a("el-card",[a("div",{staticClass:"inputCombine"},[a("span",{staticClass:"inputTag"},[e._v("字典类别名称:")]),e._v(" "),a("el-input",{staticClass:"input",attrs:{placeholder:"请输入字典类别名称"},model:{value:e.editCateName,callback:function(t){e.editCateName=t},expression:"editCateName"}})],1),e._v(" "),a("div",{staticClass:"inputCombine"},[a("span",{staticClass:"inputTag"},[e._v("字典类别编码:")]),e._v(" "),a("el-input",{staticClass:"input",attrs:{placeholder:"请输入字典类别编码"},model:{value:e.editCateCode,callback:function(t){e.editCateCode=t},expression:"editCateCode"}})],1),e._v(" "),a("div",{staticClass:"secondButtonDiv"},[a("el-button",{staticClass:"save",attrs:{type:"primary"},on:{click:function(t){e.handleEditCateSaveClick()}}},[e._v("保存")]),e._v(" "),a("el-button",{staticClass:"cancel",attrs:{type:"primary"},on:{click:function(t){e.handleEditCateCancelClick()}}},[e._v("取消")])],1)])],1):e._e(),e._v(" "),e.addPropShowFlag?a("el-tab-pane",{attrs:{label:"新增类别属性",name:"fourth"}},[a("el-card",[a("div",{staticClass:"inputCombine"},[a("span",{staticClass:"inputTag"},[e._v("类别属性名称:")]),e._v(" "),a("el-input",{staticClass:"input",attrs:{placeholder:"请输入类别属性名称"},model:{value:e.addPropName,callback:function(t){e.addPropName=t},expression:"addPropName"}})],1),e._v(" "),a("div",{staticClass:"inputCombine"},[a("span",{staticClass:"inputTag"},[e._v("类别属性编码:")]),e._v(" "),a("el-input",{staticClass:"input",attrs:{placeholder:"请输入类别属性编码"},model:{value:e.addPropCode,callback:function(t){e.addPropCode=t},expression:"addPropCode"}})],1),e._v(" "),a("div",{staticClass:"inputCombine"},[a("span",{staticClass:"inputTag"},[e._v("所属类别:")]),e._v(" "),a("el-select",{staticClass:"inputSelector",attrs:{placeholder:"请选择"},model:{value:e.addPropCategoryId,callback:function(t){e.addPropCategoryId=t},expression:"addPropCategoryId"}},e._l(e.dictionCategories,function(e){return a("el-option",{key:e.id,attrs:{label:e.category,value:e.id}})}))],1),e._v(" "),a("div",{staticClass:"secondButtonDiv"},[a("el-button",{staticClass:"save",attrs:{type:"primary"},on:{click:function(t){e.handleAddPropSaveClick()}}},[e._v("保存")]),e._v(" "),a("el-button",{staticClass:"cancel",attrs:{type:"primary"},on:{click:function(t){e.handleAddPropCancelClick()}}},[e._v("取消")])],1)])],1):e._e(),e._v(" "),e.editPropShowFlag?a("el-tab-pane",{attrs:{label:"编辑类别属性",name:"fifth"}},[a("el-card",[a("div",{staticClass:"inputCombine"},[a("span",{staticClass:"inputTag"},[e._v("类别属性名称:")]),e._v(" "),a("el-input",{staticClass:"input",attrs:{placeholder:"请输入类别属性名称"},model:{value:e.editPropName,callback:function(t){e.editPropName=t},expression:"editPropName"}})],1),e._v(" "),a("div",{staticClass:"inputCombine"},[a("span",{staticClass:"inputTag"},[e._v("类别属性编码:")]),e._v(" "),a("el-input",{staticClass:"input",attrs:{placeholder:"请输入类别属性编码"},model:{value:e.editPropCode,callback:function(t){e.editPropCode=t},expression:"editPropCode"}})],1),e._v(" "),a("div",{staticClass:"inputCombine"},[a("span",{staticClass:"inputTag"},[e._v("所属类别:")]),e._v(" "),a("el-select",{staticClass:"inputSelector",attrs:{placeholder:"请选择"},model:{value:e.editPropCate,callback:function(t){e.editPropCate=t},expression:"editPropCate"}},e._l(e.dictionCategories,function(e){return a("el-option",{key:e.id,attrs:{label:e.category,value:e.id}})}))],1),e._v(" "),a("div",{staticClass:"secondButtonDiv"},[a("el-button",{staticClass:"save",attrs:{type:"primary"},on:{click:function(t){e.handleEditPropSaveClick()}}},[e._v("保存")]),e._v(" "),a("el-button",{staticClass:"cancel",attrs:{type:"primary"},on:{click:function(t){e.handleEditPropCancelClick()}}},[e._v("取消")])],1)])],1):e._e()],1)],1)},staticRenderFns:[]}}});
//# sourceMappingURL=36.1de118eb0ea507c287c6.js.map