











<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="80px"
                :style="{backgroundColor:addEditForm.addEditBoxColor}">
            <el-row>
                <input id="updateId" name="id" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="小区名" prop="xiaoquName">
                       <el-input v-model="ruleForm.xiaoquName"
                                 placeholder="小区名" clearable  :readonly="ro.xiaoquName"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="小区名" prop="xiaoquName">
                           <el-input v-model="ruleForm.xiaoquName"
                                     placeholder="小区名" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="建筑年代" prop="xiaoquNiandai">
                       <el-input v-model="ruleForm.xiaoquNiandai"
                                 placeholder="建筑年代" clearable  :readonly="ro.xiaoquNiandai"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="建筑年代" prop="xiaoquNiandai">
                           <el-input v-model="ruleForm.xiaoquNiandai"
                                     placeholder="建筑年代" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="24">
                    <el-form-item class="upload" v-if="type!='info' && !ro.xiaoquPhoto" label="小区图片" prop="xiaoquPhoto">
                        <file-upload
                            tip="点击上传小区图片"
                            action="file/upload"
                            :limit="3"
                            :multiple="true"
                            :fileUrls="ruleForm.xiaoquPhoto?ruleForm.xiaoquPhoto:''"
                            @change="xiaoquPhotoUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.xiaoquPhoto" label="小区图片" prop="xiaoquPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.xiaoquPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="建筑类型" prop="xiaoquTypes">
                        <el-select v-model="ruleForm.xiaoquTypes" placeholder="请选择建筑类型">
                            <el-option
                                v-for="(item,index) in xiaoquTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="建筑类型" prop="xiaoquValue">
                        <el-input v-model="ruleForm.xiaoquValue"
                            placeholder="建筑类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="物业公司" prop="wuyeTypes">
                        <el-select v-model="ruleForm.wuyeTypes" placeholder="请选择物业公司">
                            <el-option
                                v-for="(item,index) in wuyeTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="物业公司" prop="wuyeValue">
                        <el-input v-model="ruleForm.wuyeValue"
                            placeholder="物业公司" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="每平米价格" prop="wuyeMoney">
                       <el-input v-model="ruleForm.wuyeMoney"
                                 placeholder="每平米价格" clearable  :readonly="ro.wuyeMoney"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="每平米价格" prop="wuyeMoney">
                           <el-input v-model="ruleForm.wuyeMoney"
                                     placeholder="每平米价格" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="所属商圈" prop="shangquanTypes">
                        <el-select v-model="ruleForm.shangquanTypes" placeholder="请选择所属商圈">
                            <el-option
                                v-for="(item,index) in shangquanTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="所属商圈" prop="shangquanValue">
                        <el-input v-model="ruleForm.shangquanValue"
                            placeholder="所属商圈" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="小区环境" prop="huanjing">
                       <el-input v-model="ruleForm.huanjing"
                                 placeholder="小区环境" clearable  :readonly="ro.huanjing"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="小区环境" prop="huanjing">
                           <el-input v-model="ruleForm.huanjing"
                                     placeholder="小区环境" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="周边配置" prop="zhoubian">
                       <el-input v-model="ruleForm.zhoubian"
                                 placeholder="周边配置" clearable  :readonly="ro.zhoubian"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="周边配置" prop="zhoubian">
                           <el-input v-model="ruleForm.zhoubian"
                                     placeholder="周边配置" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="小区地址" prop="xiaoquAddress">
                       <el-input v-model="ruleForm.xiaoquAddress"
                                 placeholder="小区地址" clearable  :readonly="ro.xiaoquAddress"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="小区地址" prop="xiaoquAddress">
                           <el-input v-model="ruleForm.xiaoquAddress"
                                     placeholder="小区地址" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               
                <el-col :span="24">
                    <el-form-item v-if="type!='info'"  label="小区介绍" prop="xiaoquContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.xiaoquContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.xiaoquContent" label="小区介绍" prop="xiaoquContent">
                            <span v-html="ruleForm.xiaoquContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                ro:{
                    xiaoquName: false,
                    xiaoquNiandai: false,
                    xiaoquPhoto: false,
                    xiaoquTypes: false,
                    wuyeTypes: false,
                    wuyeMoney: false,
                    shangquanTypes: false,
                    huanjing: false,
                    zhoubian: false,
                    xiaoquAddress: false,
                    zaishouNumber: false,
                    chuzuNumber: false,
                    xiaoquContent: false,
                },
                ruleForm: {
                    xiaoquName: '',
                    xiaoquNiandai: '',
                    xiaoquPhoto: '',
                    xiaoquTypes: '',
                    wuyeTypes: '',
                    wuyeMoney: '',
                    shangquanTypes: '',
                    huanjing: '',
                    zhoubian: '',
                    xiaoquAddress: '',
                    zaishouNumber: '',
                    chuzuNumber: '',
                    xiaoquContent: '',
                },
                xiaoquTypesOptions : [],
                wuyeTypesOptions : [],
                shangquanTypesOptions : [],
                rules: {
                   xiaoquName: [
                              { required: true, message: '小区名不能为空', trigger: 'blur' },
                          ],
                   xiaoquNiandai: [
                              { required: true, message: '建筑年代不能为空', trigger: 'blur' },
                          ],
                   xiaoquPhoto: [
                              { required: true, message: '小区图片不能为空', trigger: 'blur' },
                          ],
                   xiaoquTypes: [
                              { required: true, message: '建筑类型不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   wuyeTypes: [
                              { required: true, message: '物业公司不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   wuyeMoney: [
                              { required: true, message: '每平米价格不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]{0,6}(\.[0-9]{1,2})?$/,
                                  message: '只允许输入整数6位,小数2位的数字',
                                  trigger: 'blur'
                              }
                          ],
                   shangquanTypes: [
                              { required: true, message: '所属商圈不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   huanjing: [
                              { required: true, message: '小区环境不能为空', trigger: 'blur' },
                          ],
                   zhoubian: [
                              { required: true, message: '周边配置不能为空', trigger: 'blur' },
                          ],
                   xiaoquAddress: [
                              { required: true, message: '小区地址不能为空', trigger: 'blur' },
                          ],
                   zaishouNumber: [
                              { required: true, message: '卖房套数不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   chuzuNumber: [
                              { required: true, message: '出租套数不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   xiaoquContent: [
                              { required: true, message: '小区介绍不能为空', trigger: 'blur' },
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");

            if (this.role != "管理员"){
                this.ro.wuyeMoney = true;
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=xiaoqu_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.xiaoquTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=wuye_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.wuyeTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=shangquan_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.shangquanTypesOptions = data.data.list;
                    }
                });


        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }else if(this.type=='cross'){
                    var obj = this.$storage.getObj('crossObj');
                    for (var o in obj){

                      if(o=='xiaoquName'){
                          this.ruleForm.xiaoquName = obj[o];
                          this.ro.xiaoquName = true;
                          continue;
                      }
                      if(o=='xiaoquNiandai'){
                          this.ruleForm.xiaoquNiandai = obj[o];
                          this.ro.xiaoquNiandai = true;
                          continue;
                      }
                      if(o=='xiaoquPhoto'){
                          this.ruleForm.xiaoquPhoto = obj[o];
                          this.ro.xiaoquPhoto = true;
                          continue;
                      }
                      if(o=='xiaoquTypes'){
                          this.ruleForm.xiaoquTypes = obj[o];
                          this.ro.xiaoquTypes = true;
                          continue;
                      }
                      if(o=='wuyeTypes'){
                          this.ruleForm.wuyeTypes = obj[o];
                          this.ro.wuyeTypes = true;
                          continue;
                      }
                      if(o=='wuyeMoney'){
                          this.ruleForm.wuyeMoney = obj[o];
                          this.ro.wuyeMoney = true;
                          continue;
                      }
                      if(o=='shangquanTypes'){
                          this.ruleForm.shangquanTypes = obj[o];
                          this.ro.shangquanTypes = true;
                          continue;
                      }
                      if(o=='huanjing'){
                          this.ruleForm.huanjing = obj[o];
                          this.ro.huanjing = true;
                          continue;
                      }
                      if(o=='zhoubian'){
                          this.ruleForm.zhoubian = obj[o];
                          this.ro.zhoubian = true;
                          continue;
                      }
                      if(o=='xiaoquAddress'){
                          this.ruleForm.xiaoquAddress = obj[o];
                          this.ro.xiaoquAddress = true;
                          continue;
                      }
                      if(o=='zaishouNumber'){
                          this.ruleForm.zaishouNumber = obj[o];
                          this.ro.zaishouNumber = true;
                          continue;
                      }
                      if(o=='chuzuNumber'){
                          this.ruleForm.chuzuNumber = obj[o];
                          this.ro.chuzuNumber = true;
                          continue;
                      }
                      if(o=='xiaoquContent'){
                          this.ruleForm.xiaoquContent = obj[o];
                          this.ro.xiaoquContent = true;
                          continue;
                      }
                    }
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            // 多级联动参数
            info(id) {
                this.$http({
                    url: `xiaoqu/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.ruleForm = data.data;
                        //解决前台上传图片后台不显示的问题
                        let reg=new RegExp('../../../upload','g')//g代表全部
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.$http({
                            url:`xiaoqu/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.xiaoquCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.xiaoquCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片
            xiaoquPhotoUploadChange(fileUrls){
                this.ruleForm.xiaoquPhoto = fileUrls;
                this.addEditUploadStyleChange()
            },

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}</style>

