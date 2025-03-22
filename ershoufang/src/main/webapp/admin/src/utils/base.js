const base = {
    get() {
        return {
            url : "http://localhost:8080/ershoufang/",
            name: "ershoufang",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ershoufang/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "二手房中介管理平台"
        } 
    }
}
export default base
