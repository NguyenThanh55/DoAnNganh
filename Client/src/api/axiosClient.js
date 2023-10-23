import axios from "axios";
import cookie from "react-cookies";

const SERVER_CONTEXT = "/OUAdmissions";
const SERVER = "http://localhost:8088";

export const endpoints = {
  //Banner
  banner: `${SERVER_CONTEXT}/api/listBanner`,

  //Type
  type: `${SERVER_CONTEXT}/api/type`,

  //Post
  postInfo: (id) => `${SERVER_CONTEXT}/api/post_info/${id}`,
  post1: `${SERVER_CONTEXT}/api/getList5Post/1`,
  post2: `${SERVER_CONTEXT}/api/getList5Post/2`,
  post3: `${SERVER_CONTEXT}/api/getList5Post/3`,
  post4: `${SERVER_CONTEXT}/api/getList5Post/4`,
  post5: `${SERVER_CONTEXT}/api/getList5Post/5`,
  posts: `${SERVER_CONTEXT}/api/listPost`,
  postByType: `${SERVER_CONTEXT}/api/getPostByType/`,

  //Department
  departs: `${SERVER_CONTEXT}/api/departments/listDepartment`,
  departInfo: `${SERVER_CONTEXT}/api/departments/department_info/`,

  //Comment
  commentByPost: (postId) => `${SERVER_CONTEXT}/api/post/${postId}/comments/`,
  addComment: `${SERVER_CONTEXT}/api/comments/`,
  updateComment: (questionId) => `${SERVER_CONTEXT}/api/comments/${questionId}`,
  deleteComment: (questionId) => `${SERVER_CONTEXT}/api/comments/${questionId}`,

  //Live
  liveStreams: `${SERVER_CONTEXT}/api/livestreams/`,
  liveInfo: `${SERVER_CONTEXT}/api/live_info/`,
  listQuestionsForLive: `${SERVER_CONTEXT}/api/questionsForLive/`,

  //Question
  addQuestion: `${SERVER_CONTEXT}/api/questions/`,
  listQuestions: `${SERVER_CONTEXT}/api/questions/`,
  date: `${SERVER_CONTEXT}/api/questions/getdate`,
  deleteQuestion: (questionId) =>
    `${SERVER_CONTEXT}/api/questions/${questionId}`,
  updateQuestion: (questionId) =>
    `${SERVER_CONTEXT}/api/questions/${questionId}`,
  questionInfo: (quesId) => `${SERVER_CONTEXT}/api/questions/${quesId}`,
  questions: (liveId) => `${SERVER_CONTEXT}/api/live_info/${liveId}/questions`,

  //User
  username: `${SERVER_CONTEXT}/api/username/`,
  login: `${SERVER_CONTEXT}/api/login/`,
  "login-google": `${SERVER_CONTEXT}/api/login-google/`,
  "current-user": `${SERVER_CONTEXT}/api/current-user/`,
  "register-user": `${SERVER_CONTEXT}/api/register-user/`,
  "change-password": `${SERVER_CONTEXT}/api/change-password/`,
  "up-password": `${SERVER_CONTEXT}/api/up-password/`,
  isUser: `${SERVER_CONTEXT}/api/isUser/`,

  //Home
  slide: `${SERVER_CONTEXT}/api/slide`,
  postsTinTuc: `${SERVER_CONTEXT}/api/post_tintuc`,
  postsLichThi: `${SERVER_CONTEXT}/api/post_lichthi`,
  postsHDSinhvien: `${SERVER_CONTEXT}/api/post_hoatdong_sinhvien`,
  depart_chinhquy: `${SERVER_CONTEXT}/api/chinhquy`,
  depart_saudaihoc: `${SERVER_CONTEXT}/api/saudaihoc`,
  depart_daotaotuxa: `${SERVER_CONTEXT}/api/daotaotuxa`,
  postsHDKH: `${SERVER_CONTEXT}/api/post_hoatdong_khoahoc`,
  postsHTQT: `${SERVER_CONTEXT}/api/post_hoptac_quocte`,
  postsTuyenDung: `${SERVER_CONTEXT}/api/post_tuyendung`,
  postsCenter: `${SERVER_CONTEXT}/api/post_center`,
  listCategories: `${SERVER_CONTEXT}/api/list_categories`,
  website: `${SERVER_CONTEXT}/api/website`,
};
export const authApi = () => {
  return axios.create({
    baseURL: SERVER,
    headers: {
      Authorization: cookie.load("token"),
    },
  });
};

export default axios.create({
  baseURL: SERVER,
});
