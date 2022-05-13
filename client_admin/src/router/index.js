import Vue from 'vue';
import VueRouter from 'vue-router';
import index from '../views/index.vue';
import login from '../views/login.vue';
import forgot from '../views/forgot.vue';
import register from '../views/register.vue';
Vue.use(VueRouter)

const routes = [
	// 主页
	{
		path: '/',
		name: 'index',
		component: index,
		meta: {
			index: 0,
			title: '首页'
		}
	},

	// 登录
	{
		path: '/login',
		name: 'login',
		component: login,
		meta: {
			index: 0,
			title: '登录'
		}
	},
	// 注册
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {
			index: 0,
			title: '注册'
		}
	},

	// 忘记密码
	{
		path: '/forgot',
		name: "forgot",
		component: forgot,
		meta: {
			index: 0,
			title: '忘记密码'
		}
	},

	// 修改密码
	{
		path: '/user/password',
		name: "password",
		component: () => import("../views/user/password.vue"),
		meta: {
			index: 0,
			title: '修改密码'
		}
	},

	// 视频播放页
	{
		path: "/media/video",
		name: "video",
		component: () => import('../views/media/video.vue'),
		meta: {
			index: 0,
			title: "视频"
		}
	},

	// 音频播放页
	{
		path: "/media/audio",
		name: "audio",
		component: () => import('../views/media/audio.vue'),
		meta: {
			index: 0,
			title: "音频"
		}
	},
	// 员工用户路由
	{
		path: '/employee_user/table',
		name: 'employee_user_table',
		component: () => import('../views/employee_user/table.vue')
	},
	{
		path: '/employee_user/view',
		name: 'employee_user_view',
		component: () => import('../views/employee_user/view.vue')
	},
	// 职位分类路由
	{
		path: '/job_classification/table',
		name: 'job_classification_table',
		component: () => import('../views/job_classification/table.vue')
	},
	{
		path: '/job_classification/view',
		name: 'job_classification_view',
		component: () => import('../views/job_classification/view.vue')
	},
	// 财务用户路由
	{
		path: '/financial_user/table',
		name: 'financial_user_table',
		component: () => import('../views/financial_user/table.vue')
	},
	{
		path: '/financial_user/view',
		name: 'financial_user_view',
		component: () => import('../views/financial_user/view.vue')
	},
	// 项目预算申请路由
	{
		path: '/project_information/table',
		name: 'project_information_table',
		component: () => import('../views/project_information/table.vue')
	},
	{
		path: '/project_information/view',
		name: 'project_information_view',
		component: () => import('../views/project_information/view.vue')
	},
	// 项目审批路由
	{
		path: '/project_approval/table',
		name: 'project_approval_table',
		component: () => import('../views/project_approval/table.vue')
	},
	{
		path: '/project_approval/view',
		name: 'project_approval_view',
		component: () => import('../views/project_approval/view.vue')
	},
	// 报销申请路由
	{
		path: '/claim_for_reimbursement/table',
		name: 'claim_for_reimbursement_table',
		component: () => import('../views/claim_for_reimbursement/table.vue')
	},
	{
		path: '/claim_for_reimbursement/view',
		name: 'claim_for_reimbursement_view',
		component: () => import('../views/claim_for_reimbursement/view.vue')
	},
	// 报销审批路由
	{
		path: '/reimbursement_approval/table',
		name: 'reimbursement_approval_table',
		component: () => import('../views/reimbursement_approval/table.vue')
	},
	{
		path: '/reimbursement_approval/view',
		name: 'reimbursement_approval_view',
		component: () => import('../views/reimbursement_approval/view.vue')
	},
	// 预算报表路由
	{
		path: '/budget_statement/table',
		name: 'budget_statement_table',
		component: () => import('../views/budget_statement/table.vue')
	},
	{
		path: '/budget_statement/view',
		name: 'budget_statement_view',
		component: () => import('../views/budget_statement/view.vue')
	},
	// 报销报表路由
	{
		path: '/reimbursement_report/table',
		name: 'reimbursement_report_table',
		component: () => import('../views/reimbursement_report/table.vue')
	},
	{
		path: '/reimbursement_report/view',
		name: 'reimbursement_report_view',
		component: () => import('../views/reimbursement_report/view.vue')
	},
	// 预算付款路由
	{
		path: '/budget_payment/table',
		name: 'budget_payment_table',
		component: () => import('../views/budget_payment/table.vue')
	},
	{
		path: '/budget_payment/view',
		name: 'budget_payment_view',
		component: () => import('../views/budget_payment/view.vue')
	},
	// 报销付款路由
	{
		path: '/reimbursement_payment/table',
		name: 'reimbursement_payment_table',
		component: () => import('../views/reimbursement_payment/table.vue')
	},
	{
		path: '/reimbursement_payment/view',
		name: 'reimbursement_payment_view',
		component: () => import('../views/reimbursement_payment/view.vue')
	},

	// 用户路由
	{
		path: '/user/table',
		name: 'user_table',
		component: () => import('../views/user/table.vue'),
		meta: {
			index: 0,
			title: '用户列表'
		}
	},
	{
		path: '/user/view',
		name: 'user_view',
		component: () => import('../views/user/view.vue'),
		meta: {
			index: 0,
			title: '用户详情'
		}
	},
	{
		path: '/user/info',
		name: 'user_info',
		component: () => import('../views/user/info.vue'),
		meta: {
			index: 0,
			title: '个人信息'
		}
	},
	// 用户组路由
	{
		path: '/user_group/table',
		name: 'user_group_table',
		component: () => import('../views/user_group/table.vue'),
		meta: {
			index: 0,
			title: '用户组列表'
		}
	},
	{
		path: '/user_group/view',
		name: 'user_group_view',
		component: () => import('../views/user_group/view.vue'),
		meta: {
			index: 0,
			title: '用户组详情'
		}
	}
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

router.beforeEach((to, from, next) => {
	let token = to.query.token;
	if (token){
		$.db.set("token",token,120);
	}
	next();
})

router.afterEach((to, from, next) => {
	let title = "财务管理系统-admin";
	document.title = title;
})

export default router
