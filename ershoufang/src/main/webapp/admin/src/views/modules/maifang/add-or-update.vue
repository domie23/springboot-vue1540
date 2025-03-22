











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
                <el-col :span="12"  v-if="sessionTable !='xiaoqu'">
                    <el-form-item class="select" v-if="type!='info'"  label="小区" prop="xiaoquId">
                        <el-select v-model="ruleForm.xiaoquId" filterable placeholder="请选择小区" @change="xiaoquChange">
                            <el-option
                                    v-for="(item,index) in xiaoquOptions"
                                    v-bind:key="item.id"
                                    :label="item.xiaoquName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='xiaoqu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="小区名" prop="xiaoquName">
                        <el-input v-model="xiaoquForm.xiaoquName"
                                  placeholder="小区名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="小区名" prop="xiaoquName">
                            <el-input v-model="ruleForm.xiaoquName"
                                      placeholder="小区名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='xiaoqu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="建筑年代" prop="xiaoquNiandai">
                        <el-input v-model="xiaoquForm.xiaoquNiandai"
                                  placeholder="建筑年代" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="建筑年代" prop="xiaoquNiandai">
                            <el-input v-model="ruleForm.xiaoquNiandai"
                                      placeholder="建筑年代" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='xiaoqu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="建筑类型" prop="xiaoquValue">
                        <el-input v-model="xiaoquForm.xiaoquValue"
                                  placeholder="建筑类型" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="建筑类型" prop="xiaoquValue">
                            <el-input v-model="ruleForm.xiaoquValue"
                                      placeholder="建筑类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='xiaoqu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="物业公司" prop="wuyeValue">
                        <el-input v-model="xiaoquForm.wuyeValue"
                                  placeholder="物业公司" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="物业公司" prop="wuyeValue">
                            <el-input v-model="ruleForm.wuyeValue"
                                      placeholder="物业公司" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='xiaoqu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="每平米价格" prop="wuyeMoney">
                        <el-input v-model="xiaoquForm.wuyeMoney"
                                  placeholder="每平米价格" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="每平米价格" prop="wuyeMoney">
                            <el-input v-model="ruleForm.wuyeMoney"
                                      placeholder="每平米价格" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu'">
                    <el-form-item class="select" v-if="type!='info'"  label="用户" prop="yonghuId">
                        <el-select v-model="ruleForm.yonghuId" filterable placeholder="请选择用户" @change="yonghuChange">
                            <el-option
                                    v-for="(item,index) in yonghuOptions"
                                    v-bind:key="item.id"
                                    :label="item.yonghuName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户姓名" prop="yonghuName">
                        <el-input v-model="yonghuForm.yonghuName"
                                  placeholder="用户姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="用户姓名" prop="yonghuName">
                            <el-input v-model="ruleForm.yonghuName"
                                      placeholder="用户姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户手机号" prop="yonghuPhone">
                        <el-input v-model="yonghuForm.yonghuPhone"
                                  placeholder="用户手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="用户手机号" prop="yonghuPhone">
                            <el-input v-model="ruleForm.yonghuPhone"
                                      placeholder="用户手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户身份证号" prop="yonghuIdNumber">
                        <el-input v-model="yonghuForm.yonghuIdNumber"
                                  placeholder="用户身份证号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="用户身份证号" prop="yonghuIdNumber">
                            <el-input v-model="ruleForm.yonghuIdNumber"
                                      placeholder="用户身份证号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24" v-if="sessionTable !='yonghu' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.yonghuPhoto" label="用户头像" prop="yonghuPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (yonghuForm.yonghuPhoto || '').split(',')" :src="item" width="100" height="100">
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.yonghuPhoto" label="用户头像" prop="yonghuPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.yonghuPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="电子邮箱" prop="yonghuEmail">
                        <el-input v-model="yonghuForm.yonghuEmail"
                                  placeholder="电子邮箱" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="电子邮箱" prop="yonghuEmail">
                            <el-input v-model="ruleForm.yonghuEmail"
                                      placeholder="电子邮箱" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
            <input id="yonghuId" name="yonghuId" type="hidden">
            <input id="xiaoquId" name="xiaoquId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="房间" prop="maifangName">
                       <el-input v-model="ruleForm.maifangName"
                                 placeholder="房间" clearable  :readonly="ro.maifangName"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="房间" prop="maifangName">
                           <el-input v-model="ruleForm.maifangName"
                                     placeholder="房间" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="24">
                    <el-form-item class="upload" v-if="type!='info' && !ro.maifangPhoto" label="房屋图片" prop="maifangPhoto">
                        <file-upload
                            tip="点击上传房屋图片"
                            action="file/upload"
                            :limit="3"
                            :multiple="true"
                            :fileUrls="ruleForm.maifangPhoto?ruleForm.maifangPhoto:''"
                            @change="maifangPhotoUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.maifangPhoto" label="房屋图片" prop="maifangPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.maifangPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="房屋类型" prop="fangxingTypes">
                        <el-select v-model="ruleForm.fangxingTypes" placeholder="请选择房屋类型">
                            <el-option
                                v-for="(item,index) in fangxingTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="房屋类型" prop="fangxingValue">
                        <el-input v-model="ruleForm.fangxingValue"
                            placeholder="房屋类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="房屋平方" prop="pingfang">
                       <el-input v-model="ruleForm.pingfang"
                                 placeholder="房屋平方" clearable  :readonly="ro.pingfang"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="房屋平方" prop="pingfang">
                           <el-input v-model="ruleForm.pingfang"
                                     placeholder="房屋平方" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="每平米/价格" prop="maifangMoney">
                       <el-input v-model="ruleForm.maifangMoney"
                                 placeholder="每平米/价格" clearable  :readonly="ro.maifangMoney"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="每平米/价格" prop="maifangMoney">
                           <el-input v-model="ruleForm.maifangMoney"
                                     placeholder="每平米/价格" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="装修方式" prop="zhuangxiuTypes">
                        <el-select v-model="ruleForm.zhuangxiuTypes" placeholder="请选择装修方式">
                            <el-option
                                v-for="(item,index) in zhuangxiuTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="装修方式" prop="zhuangxiuValue">
                        <el-input v-model="ruleForm.zhuangxiuValue"
                            placeholder="装修方式" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="房屋朝向" prop="chaoxiangTypes">
                        <el-select v-model="ruleForm.chaoxiangTypes" placeholder="请选择房屋朝向">
                            <el-option
                                v-for="(item,index) in chaoxiangTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="房屋朝向" prop="chaoxiangValue">
                        <el-input v-model="ruleForm.chaoxiangValue"
                            placeholder="房屋朝向" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="楼层" prop="louceng">
                       <el-input v-model="ruleForm.louceng"
                                 placeholder="楼层" clearable  :readonly="ro.louceng"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="楼层" prop="louceng">
                           <el-input v-model="ruleForm.louceng"
                                     placeholder="楼层" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="所属区域" prop="quyuTypes">
                        <el-select v-model="ruleForm.quyuTypes" placeholder="请选择所属区域">
                            <el-option
                                v-for="(item,index) in quyuTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="所属区域" prop="quyuValue">
                        <el-input v-model="ruleForm.quyuValue"
                            placeholder="所属区域" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="是否卖出" prop="maifangTypes">
                        <el-select v-model="ruleForm.maifangTypes" placeholder="请选择是否卖出">
                            <el-option
                                v-for="(item,index) in maifangTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="是否卖出" prop="maifangValue">
                        <el-input v-model="ruleForm.maifangValue"
                            placeholder="是否卖出" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="房屋特色" prop="tese">
                       <el-input v-model="ruleForm.tese"
                                 placeholder="房屋特色" clearable  :readonly="ro.tese"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="房屋特色" prop="tese">
                           <el-input v-model="ruleForm.tese"
                                     placeholder="房屋特色" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="详细地址" prop="xiangxi">
                       <el-input v-model="ruleForm.xiangxi"
                                 placeholder="详细地址" clearable  :readonly="ro.xiangxi"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="详细地址" prop="xiangxi">
                           <el-input v-model="ruleForm.xiangxi"
                                     placeholder="详细地址" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info'"  label="房屋详细介绍" prop="maifangContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.maifangContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.maifangContent" label="房屋详细介绍" prop="maifangContent">
                            <span v-html="ruleForm.maifangContent"></span>
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
                xiaoquForm: {},
                yonghuForm: {},
                ro:{
                    yonghuId: false,
                    xiaoquId: false,
                    maifangName: false,
                    maifangPhoto: false,
                    fangxingTypes: false,
                    pingfang: false,
                    maifangMoney: false,
                    zhuangxiuTypes: false,
                    chaoxiangTypes: false,
                    louceng: false,
                    quyuTypes: false,
                    maifangTypes: false,
                    tese: false,
                    xiangxi: false,
                    maifangContent: false,
                    insertTime: false,
                },
                ruleForm: {
                    yonghuId: '',
                    xiaoquId: '',
                    maifangName: '',
                    maifangPhoto: '',
                    fangxingTypes: '',
                    pingfang: '',
                    maifangMoney: '',
                    zhuangxiuTypes: '',
                    chaoxiangTypes: '',
                    louceng: '',
                    quyuTypes: '',
                    maifangTypes: '',
                    tese: '',
                    xiangxi: '',
                    maifangContent: '',
                    insertTime: '',
                },
                fangxingTypesOptions : [],
                zhuangxiuTypesOptions : [],
                quyuTypesOptions : [],
                chaoxiangTypesOptions : [],
                maifangTypesOptions : [],
                xiaoquOptions : [],
                yonghuOptions : [],
                rules: {
                   yonghuId: [
                              { required: true, message: '用户不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   xiaoquId: [
                              { required: true, message: '小区不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   maifangName: [
                              { required: true, message: '房间不能为空', trigger: 'blur' },
                          ],
                   maifangPhoto: [
                              { required: true, message: '房屋图片不能为空', trigger: 'blur' },
                          ],
                   fangxingTypes: [
                              { required: true, message: '房屋类型不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   pingfang: [
                              { required: true, message: '房屋平方不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]{0,6}(\.[0-9]{1,2})?$/,
                                  message: '只允许输入整数6位,小数2位的数字',
                                  trigger: 'blur'
                              }
                          ],
                   maifangMoney: [
                              { required: true, message: '每平米/价格不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]{0,6}(\.[0-9]{1,2})?$/,
                                  message: '只允许输入整数6位,小数2位的数字',
                                  trigger: 'blur'
                              }
                          ],
                   zhuangxiuTypes: [
                              { required: true, message: '装修方式不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   chaoxiangTypes: [
                              { required: true, message: '房屋朝向不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   louceng: [
                              { required: true, message: '楼层不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   quyuTypes: [
                              { required: true, message: '所属区域不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   maifangTypes: [
                              { required: true, message: '是否卖出不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   tese: [
                              { required: true, message: '房屋特色不能为空', trigger: 'blur' },
                          ],
                   xiangxi: [
                              { required: true, message: '详细地址不能为空', trigger: 'blur' },
                          ],
                   maifangContent: [
                              { required: true, message: '房屋详细介绍不能为空', trigger: 'blur' },
                          ],
                   insertTime: [
                              { required: true, message: '添加时间不能为空', trigger: 'blur' },
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

            // if (this.role != "管理员"){
            //     this.ro.maifangMoney = true;
            // }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange();
            this.addEditUploadStyleChange();
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=fangxing_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.fangxingTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=zhuangxiu_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.zhuangxiuTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=chaoxiang_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.chaoxiangTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=quyu_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.quyuTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=maifang_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.maifangTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `xiaoqu/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.xiaoquOptions = data.data.list;
            }
         });
         this.$http({
             url: `yonghu/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.yonghuOptions = data.data.list;
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

                      if(o=='yonghuId'){
                          this.ruleForm.yonghuId = obj[o];
                          this.ro.yonghuId = true;
                          continue;
                      }
                      if(o=='xiaoquId'){
                          this.ruleForm.xiaoquId = obj[o];
                          this.ro.xiaoquId = true;
                          continue;
                      }
                      if(o=='maifangName'){
                          this.ruleForm.maifangName = obj[o];
                          this.ro.maifangName = true;
                          continue;
                      }
                      if(o=='maifangPhoto'){
                          this.ruleForm.maifangPhoto = obj[o];
                          this.ro.maifangPhoto = true;
                          continue;
                      }
                      if(o=='fangxingTypes'){
                          this.ruleForm.fangxingTypes = obj[o];
                          this.ro.fangxingTypes = true;
                          continue;
                      }
                      if(o=='pingfang'){
                          this.ruleForm.pingfang = obj[o];
                          this.ro.pingfang = true;
                          continue;
                      }
                      if(o=='maifangMoney'){
                          this.ruleForm.maifangMoney = obj[o];
                          this.ro.maifangMoney = true;
                          continue;
                      }
                      if(o=='zhuangxiuTypes'){
                          this.ruleForm.zhuangxiuTypes = obj[o];
                          this.ro.zhuangxiuTypes = true;
                          continue;
                      }
                      if(o=='chaoxiangTypes'){
                          this.ruleForm.chaoxiangTypes = obj[o];
                          this.ro.chaoxiangTypes = true;
                          continue;
                      }
                      if(o=='louceng'){
                          this.ruleForm.louceng = obj[o];
                          this.ro.louceng = true;
                          continue;
                      }
                      if(o=='quyuTypes'){
                          this.ruleForm.quyuTypes = obj[o];
                          this.ro.quyuTypes = true;
                          continue;
                      }
                      if(o=='maifangTypes'){
                          this.ruleForm.maifangTypes = obj[o];
                          this.ro.maifangTypes = true;
                          continue;
                      }
                      if(o=='tese'){
                          this.ruleForm.tese = obj[o];
                          this.ro.tese = true;
                          continue;
                      }
                      if(o=='xiangxi'){
                          this.ruleForm.xiangxi = obj[o];
                          this.ro.xiangxi = true;
                          continue;
                      }
                      if(o=='maifangContent'){
                          this.ruleForm.maifangContent = obj[o];
                          this.ro.maifangContent = true;
                          continue;
                      }
                      if(o=='insertTime'){
                          this.ruleForm.insertTime = obj[o];
                          this.ro.insertTime = true;
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
            xiaoquChange(id){
                this.$http({
                    url: `xiaoqu/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.xiaoquForm = data.data;
                    }
                });
            },
            yonghuChange(id){
                this.$http({
                    url: `yonghu/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.yonghuForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                this.$http({
                    url: `maifang/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.ruleForm = data.data;
                        this.xiaoquChange(data.data.xiaoquId)
                        this.yonghuChange(data.data.yonghuId)
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
                            url:`maifang/${!this.ruleForm.id ? "save" : "update"}`,
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
                                        this.parent.maifangCrossAddOrUpdateFlag = false;
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
                this.parent.maifangCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片
            maifangPhotoUploadChange(fileUrls){
                this.ruleForm.maifangPhoto = fileUrls;
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

