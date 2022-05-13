<template>
	<div>
		<el-form-item v-if="$check_register_field('add','gender','/employee_user/view')" label="性别" prop="gender">
		<el-select id="gender" v-model="form['gender']">
			<el-option v-for="o in list_gender" :key="o" :label="o" :value="o">
			</el-option>
		</el-select>
		</el-form-item>
		<el-form-item v-if="$check_register_field('add','full_name','/employee_user/view')" label="姓名" prop="full_name">
		<el-input id="full_name" v-model="form['full_name']" placeholder="请输入姓名"></el-input>
		</el-form-item>
		<el-form-item v-if="$check_register_field('add','position','/employee_user/view')" label="职位" prop="position">
		<el-select id="position" v-model="form['position']">
			<el-option v-for="o in list_position" :key="o.position" :label="o.position"
				:value="o.position">
			</el-option>
		</el-select>
		</el-form-item>

	</div>
</template>

<script>
	import mixin from "@/mixins/component.js";

	export default {
		mixins: [mixin],
		props:{

			form:{
				type: Object,
				default: function(){
					return {
						"gender":'',
						"full_name":'',
						"position":'',
					}
				}
			},

		},
		data() {
			return {
				field: "employee_user_id",
				url_add: "~/api/employee_user/add?",
				url_set: "~/api/employee_user/set?",
				url_upload: "~/api/employee_user/upload?",
				list_gender: ['男','女'],
				list_position: [],

				rules: {
					"gender": [ ],
					"full_name": [ ],
					"position": [ ],
				}

			}
		},
		methods: {
			/**
			 * 获取职位列表
			 */
			async get_list_position() {
				var list = await this.$get("~/api/job_classification/get_list?");
				this.list_position = list.result.list;
			},

		},
		created() {
			this.get_list_position();
		}
	}
</script>
