<template>
	<div class="page_root" id="root_index">
		<div class="warp">
			<div class="container-fluid">
				<el-row>
					<el-col :span="4">
						<mm_label bg_color="bg_purple" icon="el-icon-user-solid" :url="url_user_count" unit="人"
								  title="用户数量"></mm_label>
					</el-col>
				</el-row>

				<el-row>
					<el-col v-if="user_group == '管理员' || $check_figure('/project_information/table')" :span="8">
						<div class="card chart">
							<newLineChart v-if="line_obj_project_information.values.length > 0" id="line_obj_project_information" :vm="line_obj_project_information" :title="'项目预算申请统计'">
							</newLineChart>
							<div v-if="!line_obj_project_information.values.length">项目预算申请没有符合条件的数据</div>
						</div>
					</el-col>
					<el-col v-if="user_group == '管理员' || $check_figure('/claim_for_reimbursement/table')" :span="8">
						<div class="card chart">
							<newLineChart v-if="line_obj_claim_for_reimbursement.values.length > 0" id="line_obj_claim_for_reimbursement" :vm="line_obj_claim_for_reimbursement" :title="'报销申请统计'">
							</newLineChart>
							<div v-if="!line_obj_claim_for_reimbursement.values.length">报销申请没有符合条件的数据</div>
						</div>
					</el-col>
					<el-col v-if="user_group == '管理员' || $check_figure('/budget_statement/table')" :span="8">
						<div class="card chart">
							<newBarChart v-if="bar_obj_budget_statement.values.length > 0" id="bar_obj_budget_statement" :vm="bar_obj_budget_statement" :title="'预算报表统计'">
							</newBarChart>
							<div v-if="!bar_obj_budget_statement.values.length">预算报表没有符合条件的数据</div>
						</div>
					</el-col>
					<el-col v-if="user_group == '管理员' || $check_figure('/reimbursement_report/table')" :span="8">
						<div class="card chart">
							<newBarChart v-if="bar_obj_reimbursement_report.values.length > 0" id="bar_obj_reimbursement_report" :vm="bar_obj_reimbursement_report" :title="'报销报表统计'">
							</newBarChart>
							<div v-if="!bar_obj_reimbursement_report.values.length">报销报表没有符合条件的数据</div>
						</div>
					</el-col>
				</el-row>
			</div>
		</div>
	</div>
</template>
<script>
	import mixin from "@/mixins/page.js";
	import pieChart from "@/components/charts/pie_chart";
	import barChart from "@/components/charts/bar_chart";
	import newBarChart from "@/components/charts/new_bar_chart";
	import lineChart from "@/components/charts/line_chart";
	import newLineChart from "@/components/charts/new_line_chart";
	import mm_label from "@/components/mm_label.vue";
	export default {
		mixins: [mixin],
		name: "Home",
		components: {
			pieChart,
			barChart,
			newBarChart,
			lineChart,
			newLineChart,
			mm_label
		},
		data() {
			return {
				isAdmin: false,
				recognitionType: "",
				activeName: "third",
				line_obj_project_information:{
					names:[],
					xAxis: [],
					values:[]
				},
				line_obj_claim_for_reimbursement:{
					names:[],
					xAxis: [],
					values:[]
				},
				bar_obj_budget_statement: {
					names:[],
					xAxis: [],
					values:[]
				},
				bar_obj_reimbursement_report: {
					names:[],
					xAxis: [],
					values:[]
				},
				url_user_count: "~/api/user/count?",
			};
		},
		created() {
			this.getUserInfo();
			// 执行项目预算申请数据获取
			this.get_list_project_information();
			// 执行报销申请数据获取
			this.get_list_claim_for_reimbursement();
			// 执行预算报表数据获取
			this.get_list_budget_statement();
			// 执行报销报表数据获取
			this.get_list_reimbursement_report();
			
			
		},
		mounted() {},
		methods: {
			async get_nickname(list,flag){
				if (flag) {
					for (let i=0;i<list.length;i++){
						await this.$get(
								"~/api/user/get_obj?user_id="+list[i],
								null,
								(json) => {
									if (json.result) {
										list[i] = json.result.obj.nickname;
									}
								});
					}
				}else {
					for (let i=0;i<list.length;i++){
						await this.$get(
								"~/api/user/get_obj?user_id="+list[i].name,
								null,
								(json) => {
									if (json.result) {
										list[i].name = json.result.obj.nickname;
									}
								});
					}
				}
			},
			// 获取项目预算申请统计折线图
			async get_list_project_information() {
				let group_by_value = "entry_name";
				let data = {};
				let flag = false;
				let user_group = this.$store.state.user.user_group;
				let user_id = this.$store.state.user.user_id;
				if (user_group!='管理员'){
					if (user_group=="员工用户"){
						data.applicant = user_id;
					}
				}
				await this.$get(
					"~/api/project_information/get_list?groupby="+group_by_value,data,
					(json) => {
						if (json.result) {
							let list = json.result.list;
							let name_list = [];
							for (let i=0;i<list.length;i++){
								name_list.push(list[i].entry_name);
							}
							this.line_obj_project_information.names = name_list;
							this.get_list_project_information_sub("entry_name",flag);
						}
				});
			},
			async get_list_project_information_sub(v1,names_flag) {
				let data = {};
				let flag = false;
				let user_group = this.$store.state.user.user_group;
				let user_id = this.$store.state.user.user_id;
				if (user_group!='管理员'){
					if (user_group=="员工用户"){
						data.applicant = user_id;
					}
				}
				await this.$get(
					"~/api/project_information/get_list?groupby=application_time",data,
					(json) => {
						if (json.result) {
							let list = json.result.list;
							let xAxis_list = [];
							for (let i=0;i<list.length;i++){
								xAxis_list.push(this.$toTime(list[i].application_time ,"yyyy-MM-dd"));
							}
							this.line_obj_project_information.xAxis = xAxis_list;
							this.get_list_project_information_sub_sub(v1,"application_time",names_flag,flag);
						}
				});
			},
			async get_list_project_information_sub_sub(v1,v2,names_flag,xAxis_flag) {
				let data_str = "{\""+v1+"\":\"\",\""+v2+"\":\"\"}";
				let data = JSON.parse(data_str);
				let user_group = this.$store.state.user.user_group;
				let user_id = this.$store.state.user.user_id;
				if (user_group!='管理员'){
					if (user_group=="员工用户"){
						data.applicant = user_id;
					}
				}
				for (let i=0;i<this.line_obj_project_information.xAxis.length;i++){
					let list = []
					for (let j=0;j<this.line_obj_project_information.names.length;j++){
						data[v2] = this.line_obj_project_information.xAxis[i];
						data[v1] = this.line_obj_project_information.names[j];
						await this.$get(
								"~/api/project_information/sum?field=apply_for_budget",
								data,
								(json) => {
									if (json.result) {
										list[j] = json.result;
									}else {
										list[j] = 0;
									}
								});
					}
					this.line_obj_project_information.values.push(list)
				}
				if (names_flag){
					this.get_nickname(this.line_obj_project_information.names,true);
				}
				if (xAxis_flag){
					this.get_nickname(this.line_obj_project_information.xAxis,true);
				}
			},
			// 获取报销申请统计折线图
			async get_list_claim_for_reimbursement() {
				let group_by_value = "reimbursement_name";
				let data = {};
				let flag = false;
				let user_group = this.$store.state.user.user_group;
				let user_id = this.$store.state.user.user_id;
				if (user_group!='管理员'){
					if (user_group=="员工用户"){
						data.applicant = user_id;
					}
				}
				await this.$get(
					"~/api/claim_for_reimbursement/get_list?groupby="+group_by_value,data,
					(json) => {
						if (json.result) {
							let list = json.result.list;
							let name_list = [];
							for (let i=0;i<list.length;i++){
								name_list.push(list[i].reimbursement_name);
							}
							this.line_obj_claim_for_reimbursement.names = name_list;
							this.get_list_claim_for_reimbursement_sub("reimbursement_name",flag);
						}
				});
			},
			async get_list_claim_for_reimbursement_sub(v1,names_flag) {
				let data = {};
				let flag = false;
				let user_group = this.$store.state.user.user_group;
				let user_id = this.$store.state.user.user_id;
				if (user_group!='管理员'){
					if (user_group=="员工用户"){
						data.applicant = user_id;
					}
				}
				await this.$get(
					"~/api/claim_for_reimbursement/get_list?groupby=cost_time",data,
					(json) => {
						if (json.result) {
							let list = json.result.list;
							let xAxis_list = [];
							for (let i=0;i<list.length;i++){
								xAxis_list.push(this.$toTime(list[i].cost_time ,"yyyy-MM-dd"));
							}
							this.line_obj_claim_for_reimbursement.xAxis = xAxis_list;
							this.get_list_claim_for_reimbursement_sub_sub(v1,"cost_time",names_flag,flag);
						}
				});
			},
			async get_list_claim_for_reimbursement_sub_sub(v1,v2,names_flag,xAxis_flag) {
				let data_str = "{\""+v1+"\":\"\",\""+v2+"\":\"\"}";
				let data = JSON.parse(data_str);
				let user_group = this.$store.state.user.user_group;
				let user_id = this.$store.state.user.user_id;
				if (user_group!='管理员'){
					if (user_group=="员工用户"){
						data.applicant = user_id;
					}
				}
				for (let i=0;i<this.line_obj_claim_for_reimbursement.xAxis.length;i++){
					let list = []
					for (let j=0;j<this.line_obj_claim_for_reimbursement.names.length;j++){
						data[v2] = this.line_obj_claim_for_reimbursement.xAxis[i];
						data[v1] = this.line_obj_claim_for_reimbursement.names[j];
						await this.$get(
								"~/api/claim_for_reimbursement/sum?field=reimbursement_expenses",
								data,
								(json) => {
									if (json.result) {
										list[j] = json.result;
									}else {
										list[j] = 0;
									}
								});
					}
					this.line_obj_claim_for_reimbursement.values.push(list)
				}
				if (names_flag){
					this.get_nickname(this.line_obj_claim_for_reimbursement.names,true);
				}
				if (xAxis_flag){
					this.get_nickname(this.line_obj_claim_for_reimbursement.xAxis,true);
				}
			},
			// 获取预算报表统计柱状图
			async get_list_budget_statement() {
				let name_list = [];
				let query_str = "";
				let group_by_value = "budget_name";
				let flag = false;
				let date_flag = "其他"
				name_list.push("预算费用");
				query_str = query_str+"budget_expenses"+","
				this.bar_obj_budget_statement.names = name_list
				query_str = query_str.substr(0,query_str.length-1);
				let data = {};
				await this.$get(
						"~/api/budget_statement/bar_group?field="+query_str+"&groupby="+group_by_value,
						data,
						(json) => {
							if (json.result) {
								let xAxis = [];
								let values = [];
								json.result.list.map((o) => {
									if (date_flag === "日期") {
										xAxis.push(this.$toTime(o[0] ,"yyyy-MM-dd"));
									}else if (date_flag === "时间") {
										xAxis.push(this.$toTime(o[0] ,"hh:mm:ss"));
									}else if (date_flag === "日长") {
                    xAxis.push(this.$toTime(o[0] ,"yyyy-MM-dd hh:mm:ss"));
                  }else {
										xAxis.push(o[0]);
									}
									values.push(o.splice(1))
								});
								this.bar_obj_budget_statement.xAxis = xAxis;
								this.bar_obj_budget_statement.values = values;
							}
							if (flag){
								this.get_nickname(this.bar_obj_budget_statement.xAxis,true);
							}
						});
			},
			// 获取报销报表统计柱状图
			async get_list_reimbursement_report() {
				let name_list = [];
				let query_str = "";
				let group_by_value = "reimbursement_name";
				let flag = false;
				let date_flag = "其他"
				name_list.push("报销费用");
				query_str = query_str+"reimbursement_expenses"+","
				this.bar_obj_reimbursement_report.names = name_list
				query_str = query_str.substr(0,query_str.length-1);
				let data = {};
				await this.$get(
						"~/api/reimbursement_report/bar_group?field="+query_str+"&groupby="+group_by_value,
						data,
						(json) => {
							if (json.result) {
								let xAxis = [];
								let values = [];
								json.result.list.map((o) => {
									if (date_flag === "日期") {
										xAxis.push(this.$toTime(o[0] ,"yyyy-MM-dd"));
									}else if (date_flag === "时间") {
										xAxis.push(this.$toTime(o[0] ,"hh:mm:ss"));
									}else if (date_flag === "日长") {
                    xAxis.push(this.$toTime(o[0] ,"yyyy-MM-dd hh:mm:ss"));
                  }else {
										xAxis.push(o[0]);
									}
									values.push(o.splice(1))
								});
								this.bar_obj_reimbursement_report.xAxis = xAxis;
								this.bar_obj_reimbursement_report.values = values;
							}
							if (flag){
								this.get_nickname(this.bar_obj_reimbursement_report.xAxis,true);
							}
						});
			},
				getUserInfo(){
					let userGroup = window.localStorage.getItem('user_group');
						if(userGroup){
						let _userGroup =JSON.parse(userGroup);
						let _info = JSON.parse(_userGroup.value);
						this.isAdmin = _info["user_group"] == "管理员" ? true : false;
					}
			}

		},
		computed:{
			recognitionHeight(){
				if(this.recognitionType === "face"){
					return "1070px"
				}else{
					return "1180px"
				}
			},
			recognitionUrl(){
					if(this.recognitionType === "face"){
					return "https://www.sk-ai.com/Experience/face-compare"
				}else{
					return "https://www.sk-ai.com/Experience/recognition?type="
				}
			}
		}
	};
</script>

<style scoped="scoped">
	.chart {
		display: block;
		width: 100%;
		height: 400px;
		padding: 1rem;
		position: relative;
	}

	.el-col {
		padding: 0.5rem;
	}

	.card {
		overflow: hidden;
	}
	
	.iframe_box ,.iframe_box_change{
		width: 100%;
		height: 1180px;
		position: relative;
		margin-top: 25px;
	}
	.iframe_box_change{
		height: 580px;
		padding-top: 50px;
	}
.iframe_box	.iframe_box_content, .iframe_box_change .iframe_box_content{
	width: 100%;
	height: 100%;
}
.iframe_box_top{
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100px;
	font-size: 25px;
	line-height: 100px;
	background: #fff;
	z-index: 99999999;
	padding-left: 50px;
}
</style>
