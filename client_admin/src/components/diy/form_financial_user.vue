<template>
	<div>
		<el-form-item v-if="$check_register_field('add','position','/financial_user/view')" label="职位" prop="position">
		<el-select id="position" v-model="form['position']">
			<el-option v-for="o in list_position" :key="o.position" :label="o.position"
				:value="o.position">
			</el-option>
		</el-select>
		</el-form-item>
		<el-form-item v-if="$check_register_field('add','full_name','/financial_user/view')" label="姓名" prop="full_name">
		<el-input id="full_name" v-model="form['full_name']" placeholder="请输入姓名"></el-input>
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
						"position":'',
						"full_name":'',
					}
				}
			},

		},
		data() {
			return {
				field: "financial_user_id",
				url_add: "~/api/financial_user/add?",
				url_set: "~/api/financial_user/set?",
				url_upload: "~/api/financial_user/upload?",
				list_position: [],

				rules: {
					"position": [ ],
					"full_name": [ ],
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
